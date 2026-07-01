package lombok.patcher.scripts;

import java.util.List;
import java.util.Set;
import lombok.patcher.Hook;
import lombok.patcher.MethodLogistics;
import lombok.patcher.MethodTarget;
import lombok.patcher.PatchScript;
import lombok.patcher.StackRequest;
import lombok.patcher.TargetMatcher;
import lombok.patcher.TransplantMapper;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/WrapMethodCallScript.SCL.lombok */
public class WrapMethodCallScript extends MethodLevelPatchScript {
    private final Hook wrapper;
    private final Hook callToWrap;
    private final boolean transplant;
    private final boolean insert;
    private final boolean leaveReturnValueIntact;
    private final Set<StackRequest> extraRequests;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !WrapMethodCallScript.class.desiredAssertionStatus();
    }

    @Override // lombok.patcher.PatchScript
    public String getPatchScriptName() {
        return "wrap " + this.callToWrap.getMethodName() + " with " + this.wrapper.getMethodName() + " in " + describeMatchers();
    }

    WrapMethodCallScript(List<TargetMatcher> matchers, Hook callToWrap, Hook wrapper, boolean transplant, boolean insert, Set<StackRequest> extraRequests) {
        super(matchers);
        if (callToWrap == null) {
            throw new NullPointerException("callToWrap");
        }
        if (wrapper == null) {
            throw new NullPointerException("wrapper");
        }
        this.leaveReturnValueIntact = wrapper.getMethodDescriptor().endsWith(")V") && (!callToWrap.getMethodDescriptor().endsWith(")V") || callToWrap.isConstructor());
        this.callToWrap = callToWrap;
        this.wrapper = wrapper;
        this.transplant = transplant;
        this.insert = insert;
        if (!$assertionsDisabled && insert && transplant) {
            throw new AssertionError();
        }
        this.extraRequests = extraRequests;
    }

    @Override // lombok.patcher.scripts.MethodLevelPatchScript
    protected PatchScript.MethodPatcher createPatcher(ClassWriter writer, final String classSpec, TransplantMapper transplantMapper) {
        PatchScript.MethodPatcher patcher = new PatchScript.MethodPatcher(writer, transplantMapper, new PatchScript.MethodPatcherFactory() { // from class: lombok.patcher.scripts.WrapMethodCallScript.1
            @Override // lombok.patcher.PatchScript.MethodPatcherFactory
            public MethodVisitor createMethodVisitor(String name, String desc, MethodVisitor parent, MethodLogistics logistics) {
                return WrapMethodCallScript.this.new WrapMethodCall(parent, classSpec, logistics);
            }
        });
        if (this.transplant) {
            patcher.addTransplant(this.wrapper);
        }
        return patcher;
    }

    /* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/WrapMethodCallScript$WrapMethodCall.SCL.lombok */
    private class WrapMethodCall extends MethodVisitor {
        private final String ownClassSpec;
        private final MethodLogistics logistics;

        public WrapMethodCall(MethodVisitor mv, String ownClassSpec, MethodLogistics logistics) {
            super(Opcodes.ASM7, mv);
            this.ownClassSpec = ownClassSpec;
            this.logistics = logistics;
        }

        @Override // org.objectweb.asm.MethodVisitor
        public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
            super.visitMethodInsn(opcode, owner, name, desc, itf);
            if (WrapMethodCallScript.this.callToWrap.getClassSpec().equals(owner) && WrapMethodCallScript.this.callToWrap.getMethodName().equals(name) && WrapMethodCallScript.this.callToWrap.getMethodDescriptor().equals(desc)) {
                if (WrapMethodCallScript.this.leaveReturnValueIntact) {
                    if (WrapMethodCallScript.this.callToWrap.isConstructor()) {
                        this.mv.visitInsn(89);
                    } else {
                        MethodLogistics.generateDupForType(MethodTarget.decomposeFullDesc(WrapMethodCallScript.this.callToWrap.getMethodDescriptor()).get(0), this.mv);
                    }
                }
                if (WrapMethodCallScript.this.extraRequests.contains(StackRequest.THIS)) {
                    this.logistics.generateLoadOpcodeForThis(this.mv);
                }
                for (StackRequest param : StackRequest.PARAMS_IN_ORDER) {
                    if (WrapMethodCallScript.this.extraRequests.contains(param)) {
                        this.logistics.generateLoadOpcodeForParam(param.getParamPos(), this.mv);
                    }
                }
                if (WrapMethodCallScript.this.insert) {
                    WrapMethodCallScript.insertMethod(WrapMethodCallScript.this.wrapper, this.mv);
                } else {
                    super.visitMethodInsn(Opcodes.INVOKESTATIC, WrapMethodCallScript.this.transplant ? this.ownClassSpec : WrapMethodCallScript.this.wrapper.getClassSpec(), WrapMethodCallScript.this.wrapper.getMethodName(), WrapMethodCallScript.this.wrapper.getMethodDescriptor(), false);
                }
            }
        }
    }
}
