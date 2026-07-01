package lombok.patcher;

import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: app.apk:lombok/patcher/PatchScript$1.SCL.lombok */
class PatchScript$1 extends PatchScript$NoopClassVisitor {
    private final /* synthetic */ Hook val$methodToInsert;
    private final /* synthetic */ MethodVisitor val$target;

    PatchScript$1(Hook hook, MethodVisitor methodVisitor) {
        this.val$methodToInsert = hook;
        this.val$target = methodVisitor;
    }

    @Override // lombok.patcher.PatchScript$NoopClassVisitor, org.objectweb.asm.ClassVisitor
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (name.equals(this.val$methodToInsert.getMethodName()) && desc.equals(this.val$methodToInsert.getMethodDescriptor())) {
            return new PatchScript$InsertBodyOfMethodIntoAnotherVisitor(this.val$target, null);
        }
        return null;
    }
}
