package lombok.bytecode;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.JSRInlinerAdapter;

/* JADX INFO: loaded from: app.apk:lombok/bytecode/AsmUtil$1.SCL.lombok */
class AsmUtil$1 extends ClassVisitor {
    AsmUtil$1(int $anonymous0, ClassVisitor $anonymous1) {
        super($anonymous0, $anonymous1);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        return new JSRInlinerAdapter(super.visitMethod(access, name, desc, signature, exceptions), access, name, desc, signature, exceptions);
    }
}
