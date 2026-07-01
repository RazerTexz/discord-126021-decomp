package lombok.patcher.scripts;

import lombok.patcher.MethodLogistics;
import lombok.patcher.StackRequest;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ExitFromMethodEarlyScript$ExitEarly.SCL.lombok */
class ExitFromMethodEarlyScript$ExitEarly extends MethodVisitor {
    private final MethodLogistics logistics;
    private final String ownClassSpec;
    final /* synthetic */ ExitFromMethodEarlyScript this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExitFromMethodEarlyScript$ExitEarly(ExitFromMethodEarlyScript exitFromMethodEarlyScript, MethodVisitor mv, MethodLogistics logistics, String ownClassSpec) {
        super(Opcodes.ASM7, mv);
        this.this$0 = exitFromMethodEarlyScript;
        this.logistics = logistics;
        this.ownClassSpec = ownClassSpec;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitCode() {
        if (ExitFromMethodEarlyScript.access$0(this.this$0) == null) {
            if (this.logistics.getReturnOpcode() == 177) {
                this.mv.visitInsn(Opcodes.RETURN);
                return;
            } else {
                insertValueWrapperCall();
                return;
            }
        }
        if (ExitFromMethodEarlyScript.access$1(this.this$0).contains(StackRequest.THIS)) {
            this.logistics.generateLoadOpcodeForThis(this.mv);
        }
        for (StackRequest param : StackRequest.PARAMS_IN_ORDER) {
            if (ExitFromMethodEarlyScript.access$1(this.this$0).contains(param)) {
                this.logistics.generateLoadOpcodeForParam(param.getParamPos(), this.mv);
            }
        }
        if (ExitFromMethodEarlyScript.access$2(this.this$0)) {
            ExitFromMethodEarlyScript.access$3(ExitFromMethodEarlyScript.access$0(this.this$0), this.mv);
        } else {
            super.visitMethodInsn(Opcodes.INVOKESTATIC, ExitFromMethodEarlyScript.access$4(this.this$0) ? this.ownClassSpec : ExitFromMethodEarlyScript.access$0(this.this$0).getClassSpec(), ExitFromMethodEarlyScript.access$0(this.this$0).getMethodName(), ExitFromMethodEarlyScript.access$0(this.this$0).getMethodDescriptor(), false);
        }
        if (ExitFromMethodEarlyScript.access$5(this.this$0)) {
            super.visitCode();
            return;
        }
        Label label0 = new Label();
        this.mv.visitJumpInsn(153, label0);
        if (this.logistics.getReturnOpcode() == 177) {
            this.mv.visitInsn(Opcodes.RETURN);
        } else {
            if (ExitFromMethodEarlyScript.access$1(this.this$0).contains(StackRequest.THIS)) {
                this.logistics.generateLoadOpcodeForThis(this.mv);
            }
            for (StackRequest param2 : StackRequest.PARAMS_IN_ORDER) {
                if (ExitFromMethodEarlyScript.access$1(this.this$0).contains(param2)) {
                    this.logistics.generateLoadOpcodeForParam(param2.getParamPos(), this.mv);
                }
            }
            if (ExitFromMethodEarlyScript.access$2(this.this$0)) {
                ExitFromMethodEarlyScript.access$3(ExitFromMethodEarlyScript.access$6(this.this$0), this.mv);
            } else {
                super.visitMethodInsn(Opcodes.INVOKESTATIC, ExitFromMethodEarlyScript.access$4(this.this$0) ? this.ownClassSpec : ExitFromMethodEarlyScript.access$6(this.this$0).getClassSpec(), ExitFromMethodEarlyScript.access$6(this.this$0).getMethodName(), ExitFromMethodEarlyScript.access$6(this.this$0).getMethodDescriptor(), false);
            }
            this.logistics.generateReturnOpcode(this.mv);
        }
        this.mv.visitLabel(label0);
        this.mv.visitFrame(3, 0, null, 0, null);
        super.visitCode();
    }

    private void insertValueWrapperCall() {
        if (ExitFromMethodEarlyScript.access$1(this.this$0).contains(StackRequest.THIS)) {
            this.logistics.generateLoadOpcodeForThis(this.mv);
        }
        for (StackRequest param : StackRequest.PARAMS_IN_ORDER) {
            if (ExitFromMethodEarlyScript.access$1(this.this$0).contains(param)) {
                this.logistics.generateLoadOpcodeForParam(param.getParamPos(), this.mv);
            }
        }
        if (ExitFromMethodEarlyScript.access$2(this.this$0)) {
            ExitFromMethodEarlyScript.access$3(ExitFromMethodEarlyScript.access$6(this.this$0), this.mv);
        } else {
            super.visitMethodInsn(Opcodes.INVOKESTATIC, ExitFromMethodEarlyScript.access$4(this.this$0) ? this.ownClassSpec : ExitFromMethodEarlyScript.access$6(this.this$0).getClassSpec(), ExitFromMethodEarlyScript.access$6(this.this$0).getMethodName(), ExitFromMethodEarlyScript.access$6(this.this$0).getMethodDescriptor(), false);
        }
        this.logistics.generateReturnOpcode(this.mv);
    }
}
