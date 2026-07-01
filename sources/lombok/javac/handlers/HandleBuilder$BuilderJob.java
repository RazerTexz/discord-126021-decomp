package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.tree.JCTree$JCTypeParameter;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleBuilder$BuilderJob.SCL.lombok */
class HandleBuilder$BuilderJob {
    CheckerFrameworkVersion checkerFramework;
    JavacNode parentType;
    String builderMethodName;
    String buildMethodName;
    boolean isStatic;
    List<JCTree$JCTypeParameter> typeParams;
    List<JCTree$JCTypeParameter> builderTypeParams;
    JCTree source;
    JavacNode sourceNode;
    java.util.List<HandleBuilder$BuilderFieldData> builderFields;
    AccessLevel accessInners;
    AccessLevel accessOuters;
    boolean oldFluent;
    boolean oldChain;
    boolean toBuilder;
    JavacNode builderType;
    String builderClassName;

    HandleBuilder$BuilderJob() {
    }

    void init(AnnotationValues<Builder> annValues, Builder ann, JavacNode node) {
        this.accessOuters = ann.access();
        if (this.accessOuters == null) {
            this.accessOuters = AccessLevel.PUBLIC;
        }
        if (this.accessOuters == AccessLevel.NONE) {
            this.sourceNode.addError("AccessLevel.NONE is not valid here");
            this.accessOuters = AccessLevel.PUBLIC;
        }
        this.accessInners = this.accessOuters == AccessLevel.PROTECTED ? AccessLevel.PUBLIC : this.accessOuters;
        this.oldFluent = HandleBuilder.access$0(annValues.getActualExpression("fluent"), true);
        this.oldChain = HandleBuilder.access$0(annValues.getActualExpression("chain"), true);
        this.builderMethodName = ann.builderMethodName();
        this.buildMethodName = ann.buildMethodName();
        this.builderClassName = fixBuilderClassName(node, ann.builderClassName());
        this.toBuilder = ann.toBuilder();
        if (this.builderMethodName == null) {
            this.builderMethodName = "builder";
        }
        if (this.buildMethodName == null) {
            this.buildMethodName = "build";
        }
        if (this.builderClassName == null) {
            this.builderClassName = "";
        }
    }

    static String fixBuilderClassName(JavacNode node, String override) {
        if (override != null && !override.isEmpty()) {
            return override;
        }
        String override2 = (String) node.getAst().readConfiguration(ConfigurationKeys.BUILDER_CLASS_NAME);
        return (override2 == null || override2.isEmpty()) ? "*Builder" : override2;
    }

    String replaceBuilderClassName(Name name) {
        return this.builderClassName.indexOf(42) == -1 ? this.builderClassName : this.builderClassName.replace("*", name.toString());
    }

    JCTree$JCExpression createBuilderParentTypeReference() {
        return JavacHandlerUtil.namePlusTypeParamsToTypeReference(this.parentType.getTreeMaker(), this.parentType, this.typeParams);
    }

    Name getBuilderClassName() {
        return this.parentType.toName(this.builderClassName);
    }

    List<JCTree$JCTypeParameter> copyTypeParams() {
        return JavacHandlerUtil.copyTypeParams(this.sourceNode, this.typeParams);
    }

    Name toName(String name) {
        return this.parentType.toName(name);
    }

    Context getContext() {
        return this.parentType.getContext();
    }

    JavacTreeMaker getTreeMaker() {
        return this.parentType.getTreeMaker();
    }
}
