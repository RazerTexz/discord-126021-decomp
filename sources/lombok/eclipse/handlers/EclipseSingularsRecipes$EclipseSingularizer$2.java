package lombok.eclipse.handlers;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseSingularsRecipes$EclipseSingularizer$2.SCL.lombok */
class EclipseSingularsRecipes$EclipseSingularizer$2 implements EclipseSingularsRecipes$StatementMaker {
    final /* synthetic */ EclipseSingularsRecipes$EclipseSingularizer this$1;
    private final /* synthetic */ HandleBuilder$BuilderJob val$job;

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$StatementMaker
    /* JADX INFO: renamed from: make, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Statement mo186make() {
        return make();
    }

    EclipseSingularsRecipes$EclipseSingularizer$2(EclipseSingularsRecipes$EclipseSingularizer eclipseSingularsRecipes$EclipseSingularizer, HandleBuilder$BuilderJob handleBuilder$BuilderJob) {
        this.this$1 = eclipseSingularsRecipes$EclipseSingularizer;
        this.val$job = handleBuilder$BuilderJob;
    }

    public ReturnStatement make() {
        if (this.val$job.oldChain) {
            return new ReturnStatement(new ThisReference(0, 0), 0, 0);
        }
        return null;
    }
}
