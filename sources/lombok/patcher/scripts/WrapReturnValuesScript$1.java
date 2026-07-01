package lombok.patcher.scripts;

import lombok.patcher.MethodLogistics;
import lombok.patcher.PatchScript$MethodPatcherFactory;
import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/WrapReturnValuesScript$1.SCL.lombok */
class WrapReturnValuesScript$1 implements PatchScript$MethodPatcherFactory {
    final /* synthetic */ WrapReturnValuesScript this$0;
    private final /* synthetic */ String val$classSpec;

    WrapReturnValuesScript$1(WrapReturnValuesScript wrapReturnValuesScript, String str) {
        this.this$0 = wrapReturnValuesScript;
        this.val$classSpec = str;
    }

    @Override // lombok.patcher.PatchScript$MethodPatcherFactory
    public MethodVisitor createMethodVisitor(String name, String desc, MethodVisitor parent, MethodLogistics logistics) {
        return new WrapReturnValuesScript$WrapReturnValues(this.this$0, parent, logistics, this.val$classSpec, desc);
    }
}
