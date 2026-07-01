package lombok.bytecode;

import java.util.concurrent.atomic.AtomicBoolean;
import lombok.core.DiagnosticsReceiver;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: app.apk:lombok/bytecode/SneakyThrowsRemover$1.SCL.lombok */
class SneakyThrowsRemover$1 extends ClassVisitor {
    final /* synthetic */ SneakyThrowsRemover this$0;
    private final /* synthetic */ DiagnosticsReceiver val$diagnostics;
    private final /* synthetic */ AtomicBoolean val$changesMade;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SneakyThrowsRemover$1(SneakyThrowsRemover sneakyThrowsRemover, int $anonymous0, ClassVisitor $anonymous1, DiagnosticsReceiver diagnosticsReceiver, AtomicBoolean atomicBoolean) {
        super($anonymous0, $anonymous1);
        this.this$0 = sneakyThrowsRemover;
        this.val$diagnostics = diagnosticsReceiver;
        this.val$changesMade = atomicBoolean;
    }

    @Override // org.objectweb.asm.ClassVisitor
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        return new SneakyThrowsRemover$1SneakyThrowsRemoverVisitor(this.this$0, super.visitMethod(access, name, desc, signature, exceptions), this.val$diagnostics, this.val$changesMade);
    }
}
