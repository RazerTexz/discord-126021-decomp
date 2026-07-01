package lombok.eclipse.handlers;

import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleSuperBuilder$2.SCL.lombok */
class HandleSuperBuilder$2 implements EclipseSingularsRecipes$StatementMaker {
    final /* synthetic */ HandleSuperBuilder this$0;

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$StatementMaker
    /* JADX INFO: renamed from: make */
    public /* bridge */ /* synthetic */ Statement mo186make() {
        return make();
    }

    HandleSuperBuilder$2(HandleSuperBuilder handleSuperBuilder) {
        this.this$0 = handleSuperBuilder;
    }

    public ReturnStatement make() {
        MessageSend returnCall = new MessageSend();
        returnCall.receiver = ThisReference.implicitThis();
        returnCall.selector = HandleSuperBuilder.access$1();
        return new ReturnStatement(returnCall, 0, 0);
    }
}
