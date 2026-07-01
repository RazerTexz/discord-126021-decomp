package lombok.eclipse.handlers;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleBuilder$BuilderJob.SCL.lombok */
class HandleBuilder$BuilderJob {
    CheckerFrameworkVersion checkerFramework;
    EclipseNode parentType;
    String builderMethodName;
    String buildMethodName;
    boolean isStatic;
    TypeParameter[] typeParams;
    TypeParameter[] builderTypeParams;
    ASTNode source;
    EclipseNode sourceNode;
    List<HandleBuilder$BuilderFieldData> builderFields;
    AccessLevel accessInners;
    AccessLevel accessOuters;
    boolean oldFluent;
    boolean oldChain;
    boolean toBuilder;
    EclipseNode builderType;
    String builderClassName;
    char[] builderClassNameArr;

    HandleBuilder$BuilderJob() {
    }

    void setBuilderClassName(String builderClassName) {
        this.builderClassName = builderClassName;
        this.builderClassNameArr = builderClassName.toCharArray();
    }

    TypeParameter[] copyTypeParams() {
        return EclipseHandlerUtil.copyTypeParams(this.typeParams, this.source);
    }

    long getPos() {
        return (((long) this.source.sourceStart) << 32) | ((long) this.source.sourceEnd);
    }

    public TypeReference createBuilderTypeReference() {
        return EclipseHandlerUtil.namePlusTypeParamsToTypeReference(this.parentType, this.builderClassNameArr, !this.isStatic, this.builderTypeParams, getPos());
    }

    public TypeReference createBuilderTypeReferenceForceStatic() {
        return EclipseHandlerUtil.namePlusTypeParamsToTypeReference(this.parentType, this.builderClassNameArr, false, this.builderTypeParams, getPos());
    }

    public TypeReference createBuilderParentTypeReference() {
        return EclipseHandlerUtil.namePlusTypeParamsToTypeReference(this.parentType, this.typeParams, getPos());
    }

    public EclipseNode getTopNode() {
        return this.parentType.top();
    }

    void init(AnnotationValues<Builder> annValues, Builder ann, EclipseNode node) {
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
        setBuilderClassName(fixBuilderClassName(node, ann.builderClassName()));
        this.toBuilder = ann.toBuilder();
        if (this.builderMethodName == null) {
            this.builderMethodName = "builder";
        }
        if (this.buildMethodName == null) {
            this.buildMethodName = "build";
        }
    }

    static String fixBuilderClassName(EclipseNode node, String override) {
        if (override != null && !override.isEmpty()) {
            return override;
        }
        String override2 = (String) node.getAst().readConfiguration(ConfigurationKeys.BUILDER_CLASS_NAME);
        return (override2 == null || override2.isEmpty()) ? "*Builder" : override2;
    }

    MethodDeclaration createNewMethodDeclaration() {
        return new MethodDeclaration(getTopNode().get().compilationResult);
    }

    String replaceBuilderClassName(char[] name) {
        return this.builderClassName.indexOf(42) == -1 ? this.builderClassName : this.builderClassName.replace("*", new String(name));
    }

    String replaceBuilderClassName(String name) {
        return this.builderClassName.replace("*", name);
    }
}
