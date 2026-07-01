package lombok.eclipse.handlers;

import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleSuperBuilder$1.SCL.lombok */
class HandleSuperBuilder$1 implements EclipseSingularsRecipes$TypeReferenceMaker {
    final /* synthetic */ HandleSuperBuilder this$0;
    private final /* synthetic */ String val$builderGenericName;

    HandleSuperBuilder$1(HandleSuperBuilder handleSuperBuilder, String str) {
        this.this$0 = handleSuperBuilder;
        this.val$builderGenericName = str;
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$TypeReferenceMaker
    public TypeReference make() {
        return new SingleTypeReference(this.val$builderGenericName.toCharArray(), 0L);
    }
}
