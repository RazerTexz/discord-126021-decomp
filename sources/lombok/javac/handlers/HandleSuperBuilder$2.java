package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCStatement;
import com.sun.tools.javac.util.List;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleSuperBuilder$2.SCL.lombok */
class HandleSuperBuilder$2 implements JavacSingularsRecipes$StatementMaker {
    final /* synthetic */ HandleSuperBuilder this$0;
    private final /* synthetic */ JavacTreeMaker val$maker;
    private final /* synthetic */ HandleSuperBuilder$SuperBuilderJob val$job;

    HandleSuperBuilder$2(HandleSuperBuilder handleSuperBuilder, JavacTreeMaker javacTreeMaker, HandleSuperBuilder$SuperBuilderJob handleSuperBuilder$SuperBuilderJob) {
        this.this$0 = handleSuperBuilder;
        this.val$maker = javacTreeMaker;
        this.val$job = handleSuperBuilder$SuperBuilderJob;
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes$StatementMaker
    public JCTree$JCStatement make() {
        return this.val$maker.Return(this.val$maker.Apply(List.nil(), this.val$maker.Ident(this.val$job.toName("self")), List.nil()));
    }
}
