package lombok.bytecode;

import java.util.concurrent.atomic.AtomicBoolean;
import lombok.core.DiagnosticsReceiver;
import lombok.core.PostCompilerTransformation;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/bytecode/PreventNullAnalysisRemover.SCL.lombok */
public class PreventNullAnalysisRemover implements PostCompilerTransformation {
    @Override // lombok.core.PostCompilerTransformation
    public byte[] applyTransformations(byte[] original, String fileName, DiagnosticsReceiver diagnostics) {
        if (!new ClassFileMetaData(original).usesMethod("lombok/Lombok", "preventNullAnalysis")) {
            return null;
        }
        byte[] fixedByteCode = AsmUtil.fixJSRInlining(original);
        ClassReader reader = new ClassReader(fixedByteCode);
        ClassWriter writer = new FixedClassWriter(reader, 0);
        final AtomicBoolean changesMade = new AtomicBoolean();
        reader.accept(new ClassVisitor(Opcodes.ASM7, writer) { // from class: lombok.bytecode.PreventNullAnalysisRemover.1
            @Override // org.objectweb.asm.ClassVisitor
            public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                final PreventNullAnalysisRemover preventNullAnalysisRemover = PreventNullAnalysisRemover.this;
                MethodVisitor methodVisitorVisitMethod = super.visitMethod(access, name, desc, signature, exceptions);
                final AtomicBoolean atomicBoolean = changesMade;
                return new MethodVisitor(methodVisitorVisitMethod) { // from class: lombok.bytecode.PreventNullAnalysisRemover.1PreventNullAnalysisVisitor
                    @Override // org.objectweb.asm.MethodVisitor
                    public void visitMethodInsn(int opcode, String owner, String name2, String desc2, boolean itf) {
                        boolean hit = true;
                        if (1 != 0 && opcode != 184) {
                            hit = false;
                        }
                        if (hit && !"preventNullAnalysis".equals(name2)) {
                            hit = false;
                        }
                        if (hit && !"lombok/Lombok".equals(owner)) {
                            hit = false;
                        }
                        if (hit && !"(Ljava/lang/Object;)Ljava/lang/Object;".equals(desc2)) {
                            hit = false;
                        }
                        if (hit) {
                            atomicBoolean.set(true);
                            if (System.getProperty("lombok.debugAsmOnly", null) != null) {
                                super.visitMethodInsn(opcode, owner, name2, desc2, itf);
                                return;
                            }
                            return;
                        }
                        super.visitMethodInsn(opcode, owner, name2, desc2, itf);
                    }
                };
            }
        }, 0);
        if (changesMade.get()) {
            return writer.toByteArray();
        }
        return null;
    }
}
