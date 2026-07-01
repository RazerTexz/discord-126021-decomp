package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCTypeParameter;
import com.sun.tools.javac.util.List;
import lombok.AccessLevel;
import lombok.core.AnnotationValues;
import lombok.experimental.SuperBuilder;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleSuperBuilder$SuperBuilderJob.SCL.lombok */
class HandleSuperBuilder$SuperBuilderJob extends HandleBuilder$BuilderJob {
    JavacNode builderAbstractType;
    String builderAbstractClassName;
    JavacNode builderImplType;
    String builderImplClassName;
    List<JCTree$JCTypeParameter> builderTypeParams_;
    final /* synthetic */ HandleSuperBuilder this$0;

    HandleSuperBuilder$SuperBuilderJob(HandleSuperBuilder handleSuperBuilder) {
        this.this$0 = handleSuperBuilder;
    }

    void init(AnnotationValues<SuperBuilder> annValues, SuperBuilder ann, JavacNode node) {
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

    void setBuilderToImpl() {
        this.builderType = this.builderImplType;
        this.builderClassName = this.builderImplClassName;
        this.builderTypeParams = this.typeParams;
    }

    void setBuilderToAbstract() {
        this.builderType = this.builderAbstractType;
        this.builderClassName = this.builderAbstractClassName;
        this.builderTypeParams = this.builderTypeParams_;
    }
}
