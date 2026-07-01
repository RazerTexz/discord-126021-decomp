package lombok.patcher.scripts;

import lombok.patcher.MethodLogistics;
import lombok.patcher.StackRequest;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ReplaceMethodCallScript$ReplaceMethodCall.SCL.lombok */
class ReplaceMethodCallScript$ReplaceMethodCall extends MethodVisitor {
    private final String ownClassSpec;
    private final MethodLogistics logistics;
    final /* synthetic */ ReplaceMethodCallScript this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplaceMethodCallScript$ReplaceMethodCall(ReplaceMethodCallScript replaceMethodCallScript, MethodVisitor mv, String ownClassSpec, MethodLogistics logistics) {
        super(Opcodes.ASM7, mv);
        this.this$0 = replaceMethodCallScript;
        this.ownClassSpec = ownClassSpec;
        this.logistics = logistics;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        if (ReplaceMethodCallScript.access$0(this.this$0).getClassSpec().equals(owner) && ReplaceMethodCallScript.access$0(this.this$0).getMethodName().equals(name) && ReplaceMethodCallScript.access$0(this.this$0).getMethodDescriptor().equals(desc)) {
            if (ReplaceMethodCallScript.access$1(this.this$0).contains(StackRequest.THIS)) {
                this.logistics.generateLoadOpcodeForThis(this.mv);
            }
            for (StackRequest param : StackRequest.PARAMS_IN_ORDER) {
                if (ReplaceMethodCallScript.access$1(this.this$0).contains(param)) {
                    this.logistics.generateLoadOpcodeForParam(param.getParamPos(), this.mv);
                }
            }
            if (!ReplaceMethodCallScript.access$2(this.this$0)) {
                super.visitMethodInsn(Opcodes.INVOKESTATIC, ReplaceMethodCallScript.access$5(this.this$0) ? this.ownClassSpec : ReplaceMethodCallScript.access$3(this.this$0).getClassSpec(), ReplaceMethodCallScript.access$3(this.this$0).getMethodName(), ReplaceMethodCallScript.access$3(this.this$0).getMethodDescriptor(), itf);
                return;
            } else {
                ReplaceMethodCallScript.access$4(ReplaceMethodCallScript.access$3(this.this$0), this.mv);
                return;
            }
        }
        super.visitMethodInsn(opcode, owner, name, desc, itf);
    }
}
