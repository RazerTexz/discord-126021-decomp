package lombok.patcher;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: app.apk:lombok/patcher/PatchScript$2.SCL.lombok */
class PatchScript$2 extends PatchScript$NoopClassVisitor {
    private final /* synthetic */ Hook val$methodToTransplant;
    private final /* synthetic */ ClassVisitor val$target;

    PatchScript$2(Hook hook, ClassVisitor classVisitor) {
        this.val$methodToTransplant = hook;
        this.val$target = classVisitor;
    }

    @Override // lombok.patcher.PatchScript$NoopClassVisitor, org.objectweb.asm.ClassVisitor
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (name.equals(this.val$methodToTransplant.getMethodName()) && desc.equals(this.val$methodToTransplant.getMethodDescriptor())) {
            return this.val$target.visitMethod(access, name, desc, signature, exceptions);
        }
        return null;
    }
}
