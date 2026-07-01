package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCExpression;
import lombok.javac.Javac;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacSingularsRecipes$JavacSingularizer$1.SCL.lombok */
class JavacSingularsRecipes$JavacSingularizer$1 implements JavacSingularsRecipes$ExpressionMaker {
    final /* synthetic */ JavacSingularsRecipes$JavacSingularizer this$1;
    private final /* synthetic */ HandleBuilder$BuilderJob val$job;
    private final /* synthetic */ JavacTreeMaker val$maker;

    JavacSingularsRecipes$JavacSingularizer$1(JavacSingularsRecipes$JavacSingularizer javacSingularsRecipes$JavacSingularizer, HandleBuilder$BuilderJob handleBuilder$BuilderJob, JavacTreeMaker javacTreeMaker) {
        this.this$1 = javacSingularsRecipes$JavacSingularizer;
        this.val$job = handleBuilder$BuilderJob;
        this.val$maker = javacTreeMaker;
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes$ExpressionMaker
    public JCTree$JCExpression make() {
        if (this.val$job.oldChain) {
            return JavacHandlerUtil.cloneSelfType(this.val$job.builderType);
        }
        return this.val$maker.Type(Javac.createVoidType(this.val$job.builderType.getSymbolTable(), Javac.CTC_VOID));
    }
}
