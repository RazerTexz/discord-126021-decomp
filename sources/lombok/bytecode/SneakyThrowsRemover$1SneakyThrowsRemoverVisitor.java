package lombok.bytecode;

import java.util.concurrent.atomic.AtomicBoolean;
import lombok.core.DiagnosticsReceiver;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/bytecode/SneakyThrowsRemover$1SneakyThrowsRemoverVisitor.SCL.lombok */
class SneakyThrowsRemover$1SneakyThrowsRemoverVisitor extends MethodVisitor {
    private boolean methodInsnQueued;
    final /* synthetic */ SneakyThrowsRemover this$0;
    private final /* synthetic */ DiagnosticsReceiver val$diagnostics;
    private final /* synthetic */ AtomicBoolean val$changesMade;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SneakyThrowsRemover$1SneakyThrowsRemoverVisitor(SneakyThrowsRemover sneakyThrowsRemover, MethodVisitor mv, DiagnosticsReceiver diagnosticsReceiver, AtomicBoolean atomicBoolean) {
        super(Opcodes.ASM7, mv);
        this.this$0 = sneakyThrowsRemover;
        this.val$diagnostics = diagnosticsReceiver;
        this.val$changesMade = atomicBoolean;
        this.methodInsnQueued = false;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        if (opcode == 184 && "sneakyThrow".equals(name) && "lombok/Lombok".equals(owner) && "(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;".equals(desc)) {
            if (System.getProperty("lombok.debugAsmOnly", null) != null) {
                super.visitMethodInsn(opcode, owner, name, desc, itf);
                return;
            } else {
                this.methodInsnQueued = true;
                return;
            }
        }
        super.visitMethodInsn(opcode, owner, name, desc, itf);
    }

    private void handleQueue() {
        if (this.methodInsnQueued) {
            super.visitMethodInsn(Opcodes.INVOKESTATIC, "lombok/Lombok", "sneakyThrow", "(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;", false);
            this.methodInsnQueued = false;
            this.val$diagnostics.addWarning("Proper usage is: throw lombok.Lombok.sneakyThrow(someException);. You did not 'throw' it. Because of this, the call to sneakyThrow remains in your classfile and you will need lombok.jar on the classpath at runtime.");
        }
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitInsn(int arg0) {
        if (this.methodInsnQueued && arg0 == 191) {
            this.val$changesMade.set(true);
            this.methodInsnQueued = false;
        }
        handleQueue();
        super.visitInsn(arg0);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitFrame(int arg0, int arg1, Object[] arg2, int arg3, Object[] arg4) {
        handleQueue();
        super.visitFrame(arg0, arg1, arg2, arg3, arg4);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitIincInsn(int arg0, int arg1) {
        handleQueue();
        super.visitIincInsn(arg0, arg1);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitFieldInsn(int arg0, String arg1, String arg2, String arg3) {
        handleQueue();
        super.visitFieldInsn(arg0, arg1, arg2, arg3);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitIntInsn(int arg0, int arg1) {
        handleQueue();
        super.visitIntInsn(arg0, arg1);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitEnd() {
        handleQueue();
        super.visitEnd();
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitInvokeDynamicInsn(String arg0, String arg1, Handle arg2, Object... arg3) {
        handleQueue();
        super.visitInvokeDynamicInsn(arg0, arg1, arg2, arg3);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitLabel(Label arg0) {
        handleQueue();
        super.visitLabel(arg0);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitJumpInsn(int arg0, Label arg1) {
        handleQueue();
        super.visitJumpInsn(arg0, arg1);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitLdcInsn(Object arg0) {
        handleQueue();
        super.visitLdcInsn(arg0);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitLocalVariable(String arg0, String arg1, String arg2, Label arg3, Label arg4, int arg5) {
        handleQueue();
        super.visitLocalVariable(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitMaxs(int arg0, int arg1) {
        handleQueue();
        super.visitMaxs(arg0, arg1);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitLookupSwitchInsn(Label arg0, int[] arg1, Label[] arg2) {
        handleQueue();
        super.visitLookupSwitchInsn(arg0, arg1, arg2);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitMultiANewArrayInsn(String arg0, int arg1) {
        handleQueue();
        super.visitMultiANewArrayInsn(arg0, arg1);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitVarInsn(int arg0, int arg1) {
        handleQueue();
        super.visitVarInsn(arg0, arg1);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitTryCatchBlock(Label arg0, Label arg1, Label arg2, String arg3) {
        handleQueue();
        super.visitTryCatchBlock(arg0, arg1, arg2, arg3);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitTableSwitchInsn(int arg0, int arg1, Label arg2, Label... arg3) {
        handleQueue();
        super.visitTableSwitchInsn(arg0, arg1, arg2, arg3);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitTypeInsn(int arg0, String arg1) {
        handleQueue();
        super.visitTypeInsn(arg0, arg1);
    }
}
