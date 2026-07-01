package lombok.patcher;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/patcher/PatchScript$NoopClassVisitor.SCL.lombok */
abstract class PatchScript$NoopClassVisitor extends ClassVisitor {
    public PatchScript$NoopClassVisitor() {
        super(Opcodes.ASM7);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visitAttribute(Attribute attr) {
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visitEnd() {
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visitOuterClass(String owner, String name, String desc) {
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visitSource(String source, String debug) {
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
    }

    @Override // org.objectweb.asm.ClassVisitor
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return null;
    }

    @Override // org.objectweb.asm.ClassVisitor
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        return null;
    }

    @Override // org.objectweb.asm.ClassVisitor
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        return null;
    }
}
