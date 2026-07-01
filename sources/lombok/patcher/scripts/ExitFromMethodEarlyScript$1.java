package lombok.patcher.scripts;

import lombok.patcher.MethodLogistics;
import lombok.patcher.PatchScript$MethodPatcherFactory;
import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ExitFromMethodEarlyScript$1.SCL.lombok */
class ExitFromMethodEarlyScript$1 implements PatchScript$MethodPatcherFactory {
    final /* synthetic */ ExitFromMethodEarlyScript this$0;
    private final /* synthetic */ String val$classSpec;

    ExitFromMethodEarlyScript$1(ExitFromMethodEarlyScript exitFromMethodEarlyScript, String str) {
        this.this$0 = exitFromMethodEarlyScript;
        this.val$classSpec = str;
    }

    @Override // lombok.patcher.PatchScript$MethodPatcherFactory
    public MethodVisitor createMethodVisitor(String name, String desc, MethodVisitor parent, MethodLogistics logistics) {
        if (ExitFromMethodEarlyScript.access$6(this.this$0) == null && !ExitFromMethodEarlyScript.access$5(this.this$0) && logistics.getReturnOpcode() != 177) {
            throw new IllegalStateException("method " + name + desc + " must return something, but you did not provide a value hook method.");
        }
        return new ExitFromMethodEarlyScript$ExitEarly(this.this$0, parent, logistics, this.val$classSpec);
    }
}
