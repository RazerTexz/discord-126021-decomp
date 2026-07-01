package lombok.patcher.scripts;

import lombok.patcher.MethodLogistics;
import lombok.patcher.StackRequest;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/WrapReturnValuesScript$WrapReturnValues.SCL.lombok */
class WrapReturnValuesScript$WrapReturnValues extends MethodVisitor {
    private final MethodLogistics logistics;
    private final String ownClassSpec;
    private final String returnValueDesc;
    final /* synthetic */ WrapReturnValuesScript this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrapReturnValuesScript$WrapReturnValues(WrapReturnValuesScript wrapReturnValuesScript, MethodVisitor mv, MethodLogistics logistics, String ownClassSpec, String desc) {
        super(Opcodes.ASM7, mv);
        this.this$0 = wrapReturnValuesScript;
        this.logistics = logistics;
        this.ownClassSpec = ownClassSpec;
        this.returnValueDesc = WrapReturnValuesScript.access$0(desc);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitInsn(int opcode) {
        if (opcode != this.logistics.getReturnOpcode()) {
            super.visitInsn(opcode);
            return;
        }
        if (WrapReturnValuesScript.access$1(this.this$0).contains(StackRequest.RETURN_VALUE)) {
            if (!WrapReturnValuesScript.access$2(this.this$0)) {
                this.logistics.generateDupForReturn(this.mv);
            }
        } else if (WrapReturnValuesScript.access$2(this.this$0)) {
            this.logistics.generatePopForReturn(this.mv);
        }
        if (WrapReturnValuesScript.access$1(this.this$0).contains(StackRequest.THIS)) {
            this.logistics.generateLoadOpcodeForThis(this.mv);
        }
        for (StackRequest param : StackRequest.PARAMS_IN_ORDER) {
            if (WrapReturnValuesScript.access$1(this.this$0).contains(param)) {
                this.logistics.generateLoadOpcodeForParam(param.getParamPos(), this.mv);
            }
        }
        if (WrapReturnValuesScript.access$3(this.this$0)) {
            WrapReturnValuesScript.access$5(WrapReturnValuesScript.access$4(this.this$0), this.mv);
        } else {
            super.visitMethodInsn(Opcodes.INVOKESTATIC, WrapReturnValuesScript.access$6(this.this$0) ? this.ownClassSpec : WrapReturnValuesScript.access$4(this.this$0).getClassSpec(), WrapReturnValuesScript.access$4(this.this$0).getMethodName(), WrapReturnValuesScript.access$4(this.this$0).getMethodDescriptor(), false);
        }
        if (WrapReturnValuesScript.access$7(this.this$0)) {
            super.visitTypeInsn(Opcodes.CHECKCAST, this.returnValueDesc);
        }
        super.visitInsn(opcode);
    }
}
