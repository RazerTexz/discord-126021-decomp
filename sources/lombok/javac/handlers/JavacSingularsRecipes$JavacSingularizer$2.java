package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCStatement;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacSingularsRecipes$JavacSingularizer$2.SCL.lombok */
class JavacSingularsRecipes$JavacSingularizer$2 implements JavacSingularsRecipes$StatementMaker {
    final /* synthetic */ JavacSingularsRecipes$JavacSingularizer this$1;
    private final /* synthetic */ HandleBuilder$BuilderJob val$job;
    private final /* synthetic */ JavacTreeMaker val$maker;

    JavacSingularsRecipes$JavacSingularizer$2(JavacSingularsRecipes$JavacSingularizer javacSingularsRecipes$JavacSingularizer, HandleBuilder$BuilderJob handleBuilder$BuilderJob, JavacTreeMaker javacTreeMaker) {
        this.this$1 = javacSingularsRecipes$JavacSingularizer;
        this.val$job = handleBuilder$BuilderJob;
        this.val$maker = javacTreeMaker;
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes$StatementMaker
    public JCTree$JCStatement make() {
        if (this.val$job.oldChain) {
            return this.val$maker.Return(this.val$maker.Ident(this.val$job.builderType.toName("this")));
        }
        return null;
    }
}
