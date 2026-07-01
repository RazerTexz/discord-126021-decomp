package lombok.patcher.scripts;

import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import lombok.patcher.Hook;
import lombok.patcher.MethodLogistics;
import lombok.patcher.PatchScript$MethodPatcher;
import lombok.patcher.TargetMatcher;
import lombok.patcher.TransplantMapper;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/SetSymbolDuringMethodCallScript.SCL.lombok */
public class SetSymbolDuringMethodCallScript extends MethodLevelPatchScript {
    private final Hook callToWrap;
    private final String symbol;
    private final boolean report;

    static /* synthetic */ Hook access$0(SetSymbolDuringMethodCallScript setSymbolDuringMethodCallScript) {
        return setSymbolDuringMethodCallScript.callToWrap;
    }

    static /* synthetic */ String access$2(SetSymbolDuringMethodCallScript setSymbolDuringMethodCallScript) {
        return setSymbolDuringMethodCallScript.symbol;
    }

    static /* synthetic */ boolean access$1(SetSymbolDuringMethodCallScript setSymbolDuringMethodCallScript) {
        return setSymbolDuringMethodCallScript.report;
    }

    @Override // lombok.patcher.PatchScript
    public String getPatchScriptName() {
        return "set symbol " + this.symbol + " if " + this.callToWrap.getMethodName() + " is invoked in " + describeMatchers();
    }

    SetSymbolDuringMethodCallScript(List<TargetMatcher> matchers, Hook callToWrap, String symbol, boolean report) {
        super(matchers);
        if (callToWrap == null) {
            throw new NullPointerException("callToWrap");
        }
        if (symbol == null) {
            throw new NullPointerException("symbol");
        }
        this.callToWrap = callToWrap;
        this.symbol = symbol;
        this.report = report;
    }

    @Override // lombok.patcher.scripts.MethodLevelPatchScript
    protected PatchScript$MethodPatcher createPatcher(ClassWriter writer, String classSpec, TransplantMapper transplantMapper) {
        List<WrapperMethodDescriptor> descriptors = new ArrayList<>();
        PatchScript$MethodPatcher patcher = new SetSymbolDuringMethodCallScript$2(this, writer, transplantMapper, new SetSymbolDuringMethodCallScript$1(this, classSpec, descriptors), descriptors);
        return patcher;
    }

    static /* synthetic */ void access$3(SetSymbolDuringMethodCallScript setSymbolDuringMethodCallScript, ClassVisitor classVisitor, WrapperMethodDescriptor wrapperMethodDescriptor) {
        setSymbolDuringMethodCallScript.makeWrapperMethod(classVisitor, wrapperMethodDescriptor);
    }

    private void makeWrapperMethod(ClassVisitor cv, WrapperMethodDescriptor wmd) {
        MethodVisitor mv = cv.visitMethod(4106, wmd.getWrapperName(), wmd.getWrapperDescriptor(), null, null);
        MethodLogistics logistics = new MethodLogistics(8, wmd.getWrapperDescriptor());
        mv.visitCode();
        Label start = new Label();
        Label end = new Label();
        Label handler = new Label();
        mv.visitTryCatchBlock(start, end, handler, null);
        mv.visitLabel(start);
        mv.visitLdcInsn(this.symbol);
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "lombok/patcher/Symbols", Constants.PUSH, "(Ljava/lang/String;)V", false);
        for (int i = 0; i < logistics.getParamCount(); i++) {
            logistics.generateLoadOpcodeForParam(i, mv);
        }
        mv.visitMethodInsn(wmd.getOpcode(), wmd.getOwner(), wmd.getName(), wmd.getTargetDescriptor(), wmd.isItf());
        mv.visitLabel(end);
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "lombok/patcher/Symbols", "pop", "()V", false);
        logistics.generateReturnOpcode(mv);
        mv.visitLabel(handler);
        mv.visitFrame(0, 0, null, 1, new Object[]{"java/lang/Throwable"});
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "lombok/patcher/Symbols", "pop", "()V", false);
        mv.visitInsn(Opcodes.ATHROW);
        mv.visitMaxs(Math.max(1, logistics.getParamCount()), logistics.getParamCount());
        mv.visitEnd();
    }
}
