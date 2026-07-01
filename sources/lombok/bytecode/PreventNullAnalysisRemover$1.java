package lombok.bytecode;

import java.util.concurrent.atomic.AtomicBoolean;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: app.apk:lombok/bytecode/PreventNullAnalysisRemover$1.SCL.lombok */
class PreventNullAnalysisRemover$1 extends ClassVisitor {
    final /* synthetic */ PreventNullAnalysisRemover this$0;
    private final /* synthetic */ AtomicBoolean val$changesMade;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreventNullAnalysisRemover$1(PreventNullAnalysisRemover preventNullAnalysisRemover, int $anonymous0, ClassVisitor $anonymous1, AtomicBoolean atomicBoolean) {
        super($anonymous0, $anonymous1);
        this.this$0 = preventNullAnalysisRemover;
        this.val$changesMade = atomicBoolean;
    }

    @Override // org.objectweb.asm.ClassVisitor
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        return new PreventNullAnalysisRemover$1PreventNullAnalysisVisitor(this.this$0, super.visitMethod(access, name, desc, signature, exceptions), this.val$changesMade);
    }
}
