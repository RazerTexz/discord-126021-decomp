package lombok.patcher.scripts;

import lombok.patcher.MethodLogistics;
import lombok.patcher.PatchScript$MethodPatcherFactory;
import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ReplaceMethodCallScript$1.SCL.lombok */
class ReplaceMethodCallScript$1 implements PatchScript$MethodPatcherFactory {
    final /* synthetic */ ReplaceMethodCallScript this$0;
    private final /* synthetic */ String val$classSpec;

    ReplaceMethodCallScript$1(ReplaceMethodCallScript replaceMethodCallScript, String str) {
        this.this$0 = replaceMethodCallScript;
        this.val$classSpec = str;
    }

    @Override // lombok.patcher.PatchScript$MethodPatcherFactory
    public MethodVisitor createMethodVisitor(String name, String desc, MethodVisitor parent, MethodLogistics logistics) {
        return new ReplaceMethodCallScript$ReplaceMethodCall(this.this$0, parent, this.val$classSpec, logistics);
    }
}
