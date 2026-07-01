package lombok.bytecode;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/bytecode/AsmUtil.SCL.lombok */
class AsmUtil {
    private AsmUtil() {
        throw new UnsupportedOperationException();
    }

    static byte[] fixJSRInlining(byte[] byteCode) {
        ClassReader reader = new ClassReader(byteCode);
        ClassWriter writer = new FixedClassWriter(reader, 0);
        ClassVisitor visitor = new AsmUtil$1(Opcodes.ASM7, writer);
        reader.accept(visitor, 0);
        return writer.toByteArray();
    }
}
