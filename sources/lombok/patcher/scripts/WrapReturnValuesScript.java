package lombok.patcher.scripts;

import java.util.List;
import java.util.Set;
import lombok.patcher.Hook;
import lombok.patcher.MethodLogistics;
import lombok.patcher.PatchScript;
import lombok.patcher.StackRequest;
import lombok.patcher.TargetMatcher;
import lombok.patcher.TransplantMapper;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/WrapReturnValuesScript.SCL.lombok */
public final class WrapReturnValuesScript extends MethodLevelPatchScript {
    private final Hook wrapper;
    private final Set<StackRequest> requests;
    private final boolean hijackReturnValue;
    private final boolean transplant;
    private final boolean insert;
    private final boolean cast;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !WrapReturnValuesScript.class.desiredAssertionStatus();
    }

    @Override // lombok.patcher.PatchScript
    public String getPatchScriptName() {
        return "wrap returns with " + this.wrapper.getMethodName() + " in " + describeMatchers();
    }

    WrapReturnValuesScript(List<TargetMatcher> matchers, Hook wrapper, boolean transplant, boolean insert, boolean cast, Set<StackRequest> requests) {
        super(matchers);
        if (wrapper == null) {
            throw new NullPointerException("wrapper");
        }
        this.wrapper = wrapper;
        this.hijackReturnValue = !wrapper.getMethodDescriptor().endsWith(")V");
        this.requests = requests;
        this.transplant = transplant;
        this.insert = insert;
        this.cast = cast && this.hijackReturnValue;
        if (!$assertionsDisabled && insert && transplant) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && cast && insert) {
            throw new AssertionError();
        }
    }

    @Override // lombok.patcher.scripts.MethodLevelPatchScript
    protected PatchScript.MethodPatcher createPatcher(ClassWriter writer, final String classSpec, TransplantMapper transplantMapper) {
        PatchScript.MethodPatcher patcher = new PatchScript.MethodPatcher(writer, transplantMapper, new PatchScript.MethodPatcherFactory() { // from class: lombok.patcher.scripts.WrapReturnValuesScript.1
            @Override // lombok.patcher.PatchScript.MethodPatcherFactory
            public MethodVisitor createMethodVisitor(String name, String desc, MethodVisitor parent, MethodLogistics logistics) {
                return WrapReturnValuesScript.this.new WrapReturnValues(parent, logistics, classSpec, desc);
            }
        });
        if (this.transplant) {
            patcher.addTransplant(this.wrapper);
        }
        return patcher;
    }

    private static String extractReturnValueFromDesc(String desc) {
        int lastIdx = desc == null ? -1 : desc.lastIndexOf(41);
        if (lastIdx == -1) {
            return null;
        }
        String rd = desc.substring(lastIdx + 1);
        return (rd.startsWith("L") && rd.endsWith(";")) ? rd.substring(1, rd.length() - 1) : rd;
    }

    /* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/WrapReturnValuesScript$WrapReturnValues.SCL.lombok */
    private class WrapReturnValues extends MethodVisitor {
        private final MethodLogistics logistics;
        private final String ownClassSpec;
        private final String returnValueDesc;

        public WrapReturnValues(MethodVisitor mv, MethodLogistics logistics, String ownClassSpec, String desc) {
            super(Opcodes.ASM7, mv);
            this.logistics = logistics;
            this.ownClassSpec = ownClassSpec;
            this.returnValueDesc = WrapReturnValuesScript.extractReturnValueFromDesc(desc);
        }

        @Override // org.objectweb.asm.MethodVisitor
        public void visitInsn(int opcode) {
            if (opcode == this.logistics.getReturnOpcode()) {
                if (WrapReturnValuesScript.this.requests.contains(StackRequest.RETURN_VALUE)) {
                    if (!WrapReturnValuesScript.this.hijackReturnValue) {
                        this.logistics.generateDupForReturn(this.mv);
                    }
                } else if (WrapReturnValuesScript.this.hijackReturnValue) {
                    this.logistics.generatePopForReturn(this.mv);
                }
                if (WrapReturnValuesScript.this.requests.contains(StackRequest.THIS)) {
                    this.logistics.generateLoadOpcodeForThis(this.mv);
                }
                for (StackRequest param : StackRequest.PARAMS_IN_ORDER) {
                    if (WrapReturnValuesScript.this.requests.contains(param)) {
                        this.logistics.generateLoadOpcodeForParam(param.getParamPos(), this.mv);
                    }
                }
                if (WrapReturnValuesScript.this.insert) {
                    WrapReturnValuesScript.insertMethod(WrapReturnValuesScript.this.wrapper, this.mv);
                } else {
                    super.visitMethodInsn(Opcodes.INVOKESTATIC, WrapReturnValuesScript.this.transplant ? this.ownClassSpec : WrapReturnValuesScript.this.wrapper.getClassSpec(), WrapReturnValuesScript.this.wrapper.getMethodName(), WrapReturnValuesScript.this.wrapper.getMethodDescriptor(), false);
                }
                if (WrapReturnValuesScript.this.cast) {
                    super.visitTypeInsn(Opcodes.CHECKCAST, this.returnValueDesc);
                }
                super.visitInsn(opcode);
                return;
            }
            super.visitInsn(opcode);
        }
    }

    public String toString() {
        return "WrapReturnValues(wrapper: " + this.wrapper + ", hijackReturn: " + this.hijackReturnValue + ", transplant: " + this.transplant + ", insert: " + this.insert + ", requests: " + this.requests + ")";
    }
}
