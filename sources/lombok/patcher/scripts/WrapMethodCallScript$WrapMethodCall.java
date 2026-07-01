package lombok.patcher.scripts;

import lombok.patcher.MethodLogistics;
import lombok.patcher.MethodTarget;
import lombok.patcher.StackRequest;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/WrapMethodCallScript$WrapMethodCall.SCL.lombok */
class WrapMethodCallScript$WrapMethodCall extends MethodVisitor {
    private final String ownClassSpec;
    private final MethodLogistics logistics;
    final /* synthetic */ WrapMethodCallScript this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrapMethodCallScript$WrapMethodCall(WrapMethodCallScript wrapMethodCallScript, MethodVisitor mv, String ownClassSpec, MethodLogistics logistics) {
        super(Opcodes.ASM7, mv);
        this.this$0 = wrapMethodCallScript;
        this.ownClassSpec = ownClassSpec;
        this.logistics = logistics;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        super.visitMethodInsn(opcode, owner, name, desc, itf);
        if (WrapMethodCallScript.access$0(this.this$0).getClassSpec().equals(owner) && WrapMethodCallScript.access$0(this.this$0).getMethodName().equals(name) && WrapMethodCallScript.access$0(this.this$0).getMethodDescriptor().equals(desc)) {
            if (WrapMethodCallScript.access$1(this.this$0)) {
                if (WrapMethodCallScript.access$0(this.this$0).isConstructor()) {
                    this.mv.visitInsn(89);
                } else {
                    MethodLogistics.generateDupForType(MethodTarget.decomposeFullDesc(WrapMethodCallScript.access$0(this.this$0).getMethodDescriptor()).get(0), this.mv);
                }
            }
            if (WrapMethodCallScript.access$2(this.this$0).contains(StackRequest.THIS)) {
                this.logistics.generateLoadOpcodeForThis(this.mv);
            }
            for (StackRequest param : StackRequest.PARAMS_IN_ORDER) {
                if (WrapMethodCallScript.access$2(this.this$0).contains(param)) {
                    this.logistics.generateLoadOpcodeForParam(param.getParamPos(), this.mv);
                }
            }
            if (WrapMethodCallScript.access$3(this.this$0)) {
                WrapMethodCallScript.access$5(WrapMethodCallScript.access$4(this.this$0), this.mv);
            } else {
                super.visitMethodInsn(Opcodes.INVOKESTATIC, WrapMethodCallScript.access$6(this.this$0) ? this.ownClassSpec : WrapMethodCallScript.access$4(this.this$0).getClassSpec(), WrapMethodCallScript.access$4(this.this$0).getMethodName(), WrapMethodCallScript.access$4(this.this$0).getMethodDescriptor(), false);
            }
        }
    }
}
