package lombok.eclipse.handlers;

import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseSingularsRecipes$EclipseSingularizer$1.SCL.lombok */
class EclipseSingularsRecipes$EclipseSingularizer$1 implements EclipseSingularsRecipes$TypeReferenceMaker {
    final /* synthetic */ EclipseSingularsRecipes$EclipseSingularizer this$1;
    private final /* synthetic */ HandleBuilder$BuilderJob val$job;

    EclipseSingularsRecipes$EclipseSingularizer$1(EclipseSingularsRecipes$EclipseSingularizer eclipseSingularsRecipes$EclipseSingularizer, HandleBuilder$BuilderJob handleBuilder$BuilderJob) {
        this.this$1 = eclipseSingularsRecipes$EclipseSingularizer;
        this.val$job = handleBuilder$BuilderJob;
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$TypeReferenceMaker
    public TypeReference make() {
        return this.val$job.oldChain ? EclipseHandlerUtil.cloneSelfType(this.val$job.builderType) : TypeReference.baseTypeReference(6, 0);
    }
}
