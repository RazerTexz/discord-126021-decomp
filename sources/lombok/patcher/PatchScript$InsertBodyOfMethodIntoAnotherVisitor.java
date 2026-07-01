package lombok.patcher;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/patcher/PatchScript$InsertBodyOfMethodIntoAnotherVisitor.SCL.lombok */
final class PatchScript$InsertBodyOfMethodIntoAnotherVisitor extends MethodVisitor {
    /* synthetic */ PatchScript$InsertBodyOfMethodIntoAnotherVisitor(MethodVisitor methodVisitor, PatchScript$InsertBodyOfMethodIntoAnotherVisitor patchScript$InsertBodyOfMethodIntoAnotherVisitor) {
        this(methodVisitor);
    }

    private PatchScript$InsertBodyOfMethodIntoAnotherVisitor(MethodVisitor mv) {
        super(Opcodes.ASM7, mv);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
        return null;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitMaxs(int maxStack, int maxLocals) {
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitLineNumber(int line, Label start) {
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitEnd() {
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitCode() {
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitInsn(int opcode) {
        if (opcode == 177 || opcode == 176 || opcode == 172 || opcode == 175 || opcode == 174 || opcode == 173) {
            return;
        }
        super.visitInsn(opcode);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitAttribute(Attribute attr) {
    }

    @Override // org.objectweb.asm.MethodVisitor
    public AnnotationVisitor visitAnnotationDefault() {
        return null;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return null;
    }
}
