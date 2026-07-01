package lombok.patcher.scripts;

import java.util.List;
import lombok.patcher.PatchScript$MethodPatcher;
import lombok.patcher.PatchScript$MethodPatcherFactory;
import lombok.patcher.TransplantMapper;
import org.objectweb.asm.ClassVisitor;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/SetSymbolDuringMethodCallScript$2.SCL.lombok */
class SetSymbolDuringMethodCallScript$2 extends PatchScript$MethodPatcher {
    final /* synthetic */ SetSymbolDuringMethodCallScript this$0;
    private final /* synthetic */ List val$descriptors;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SetSymbolDuringMethodCallScript$2(SetSymbolDuringMethodCallScript setSymbolDuringMethodCallScript, ClassVisitor $anonymous0, TransplantMapper $anonymous1, PatchScript$MethodPatcherFactory $anonymous2, List list) {
        super($anonymous0, $anonymous1, $anonymous2);
        this.this$0 = setSymbolDuringMethodCallScript;
        this.val$descriptors = list;
    }

    @Override // lombok.patcher.PatchScript$MethodPatcher, org.objectweb.asm.ClassVisitor
    public void visitEnd() {
        for (WrapperMethodDescriptor wmd : this.val$descriptors) {
            SetSymbolDuringMethodCallScript.access$3(this.this$0, this, wmd);
        }
        super.visitEnd();
    }
}
