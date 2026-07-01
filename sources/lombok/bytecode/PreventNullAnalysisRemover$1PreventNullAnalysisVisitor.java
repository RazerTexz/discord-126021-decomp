package lombok.bytecode;

import java.util.concurrent.atomic.AtomicBoolean;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/bytecode/PreventNullAnalysisRemover$1PreventNullAnalysisVisitor.SCL.lombok */
class PreventNullAnalysisRemover$1PreventNullAnalysisVisitor extends MethodVisitor {
    final /* synthetic */ PreventNullAnalysisRemover this$0;
    private final /* synthetic */ AtomicBoolean val$changesMade;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreventNullAnalysisRemover$1PreventNullAnalysisVisitor(PreventNullAnalysisRemover preventNullAnalysisRemover, MethodVisitor mv, AtomicBoolean atomicBoolean) {
        super(Opcodes.ASM7, mv);
        this.this$0 = preventNullAnalysisRemover;
        this.val$changesMade = atomicBoolean;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        boolean hit = true;
        if (1 != 0 && opcode != 184) {
            hit = false;
        }
        if (hit && !"preventNullAnalysis".equals(name)) {
            hit = false;
        }
        if (hit && !"lombok/Lombok".equals(owner)) {
            hit = false;
        }
        if (hit && !"(Ljava/lang/Object;)Ljava/lang/Object;".equals(desc)) {
            hit = false;
        }
        if (hit) {
            this.val$changesMade.set(true);
            if (System.getProperty("lombok.debugAsmOnly", null) != null) {
                super.visitMethodInsn(opcode, owner, name, desc, itf);
                return;
            }
            return;
        }
        super.visitMethodInsn(opcode, owner, name, desc, itf);
    }
}
