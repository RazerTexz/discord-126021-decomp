package lombok.patcher.scripts;

import java.util.List;
import lombok.patcher.MethodLogistics;
import lombok.patcher.PatchScript$MethodPatcherFactory;
import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/SetSymbolDuringMethodCallScript$1.SCL.lombok */
class SetSymbolDuringMethodCallScript$1 implements PatchScript$MethodPatcherFactory {
    final /* synthetic */ SetSymbolDuringMethodCallScript this$0;
    private final /* synthetic */ String val$classSpec;
    private final /* synthetic */ List val$descriptors;

    SetSymbolDuringMethodCallScript$1(SetSymbolDuringMethodCallScript setSymbolDuringMethodCallScript, String str, List list) {
        this.this$0 = setSymbolDuringMethodCallScript;
        this.val$classSpec = str;
        this.val$descriptors = list;
    }

    @Override // lombok.patcher.PatchScript$MethodPatcherFactory
    public MethodVisitor createMethodVisitor(String name, String desc, MethodVisitor parent, MethodLogistics logistics) {
        return new SetSymbolDuringMethodCallScript$WrapWithSymbol(this.this$0, name, parent, this.val$classSpec, this.val$descriptors);
    }
}
