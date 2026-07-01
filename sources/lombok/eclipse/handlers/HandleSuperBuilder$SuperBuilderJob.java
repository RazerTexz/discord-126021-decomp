package lombok.eclipse.handlers;

import lombok.AccessLevel;
import lombok.core.AnnotationValues;
import lombok.eclipse.EclipseNode;
import lombok.experimental.SuperBuilder;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleSuperBuilder$SuperBuilderJob.SCL.lombok */
class HandleSuperBuilder$SuperBuilderJob extends HandleBuilder$BuilderJob {
    EclipseNode builderAbstractType;
    String builderAbstractClassName;
    char[] builderAbstractClassNameArr;
    EclipseNode builderImplType;
    String builderImplClassName;
    char[] builderImplClassNameArr;
    private TypeParameter[] builderTypeParams_;
    final /* synthetic */ HandleSuperBuilder this$0;

    HandleSuperBuilder$SuperBuilderJob(HandleSuperBuilder handleSuperBuilder) {
        this.this$0 = handleSuperBuilder;
    }

    void init(AnnotationValues<SuperBuilder> annValues, SuperBuilder ann, EclipseNode node) {
        AccessLevel accessLevel = AccessLevel.PUBLIC;
        this.accessInners = accessLevel;
        this.accessOuters = accessLevel;
        this.oldFluent = true;
        this.oldChain = true;
        this.builderMethodName = ann.builderMethodName();
        this.buildMethodName = ann.buildMethodName();
        this.toBuilder = ann.toBuilder();
        if (this.builderMethodName == null) {
            this.builderMethodName = "builder";
        }
        if (this.buildMethodName == null) {
            this.buildMethodName = "build";
        }
        this.builderClassName = fixBuilderClassName(node, "");
    }

    static /* synthetic */ void access$0(HandleSuperBuilder$SuperBuilderJob handleSuperBuilder$SuperBuilderJob, TypeParameter[] typeParameterArr) {
        handleSuperBuilder$SuperBuilderJob.builderTypeParams_ = typeParameterArr;
    }

    void setBuilderToImpl() {
        this.builderType = this.builderImplType;
        this.builderClassName = this.builderImplClassName;
        this.builderClassNameArr = this.builderImplClassNameArr;
        this.builderTypeParams = this.typeParams;
    }

    void setBuilderToAbstract() {
        this.builderType = this.builderAbstractType;
        this.builderClassName = this.builderAbstractClassName;
        this.builderClassNameArr = this.builderAbstractClassNameArr;
        this.builderTypeParams = this.builderTypeParams_;
    }
}
