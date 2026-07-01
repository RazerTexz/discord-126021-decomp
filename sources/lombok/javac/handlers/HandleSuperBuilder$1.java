package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCExpression;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleSuperBuilder$1.SCL.lombok */
class HandleSuperBuilder$1 implements JavacSingularsRecipes$ExpressionMaker {
    final /* synthetic */ HandleSuperBuilder this$0;
    private final /* synthetic */ JavacTreeMaker val$maker;
    private final /* synthetic */ HandleSuperBuilder$SuperBuilderJob val$job;
    private final /* synthetic */ String val$builderGenericName;

    HandleSuperBuilder$1(HandleSuperBuilder handleSuperBuilder, JavacTreeMaker javacTreeMaker, HandleSuperBuilder$SuperBuilderJob handleSuperBuilder$SuperBuilderJob, String str) {
        this.this$0 = handleSuperBuilder;
        this.val$maker = javacTreeMaker;
        this.val$job = handleSuperBuilder$SuperBuilderJob;
        this.val$builderGenericName = str;
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes$ExpressionMaker
    public JCTree$JCExpression make() {
        return this.val$maker.Ident(this.val$job.toName(this.val$builderGenericName));
    }
}
