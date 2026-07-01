package lombok.patcher.scripts;

import lombok.patcher.MethodLogistics;
import lombok.patcher.PatchScript$MethodPatcherFactory;
import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/WrapMethodCallScript$1.SCL.lombok */
class WrapMethodCallScript$1 implements PatchScript$MethodPatcherFactory {
    final /* synthetic */ WrapMethodCallScript this$0;
    private final /* synthetic */ String val$classSpec;

    WrapMethodCallScript$1(WrapMethodCallScript wrapMethodCallScript, String str) {
        this.this$0 = wrapMethodCallScript;
        this.val$classSpec = str;
    }

    @Override // lombok.patcher.PatchScript$MethodPatcherFactory
    public MethodVisitor createMethodVisitor(String name, String desc, MethodVisitor parent, MethodLogistics logistics) {
        return new WrapMethodCallScript$WrapMethodCall(this.this$0, parent, this.val$classSpec, logistics);
    }
}
