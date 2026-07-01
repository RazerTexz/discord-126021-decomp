package lombok.patcher;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

/* JADX INFO: loaded from: app.apk:lombok/patcher/PatchScript$FixedClassWriter.SCL.lombok */
class PatchScript$FixedClassWriter extends ClassWriter {
    PatchScript$FixedClassWriter(ClassReader classReader, int flags) {
        super(classReader, flags);
    }

    @Override // org.objectweb.asm.ClassWriter
    protected String getCommonSuperClass(String type1, String type2) {
        try {
            return super.getCommonSuperClass(type1, type2);
        } catch (Throwable unused) {
            return "java/lang/Object";
        }
    }
}
