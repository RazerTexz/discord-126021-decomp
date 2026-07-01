package lombok.eclipse.handlers.singulars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AccessLevel;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.eclipse.handlers.EclipseSingularsRecipes$SingularData;
import lombok.eclipse.handlers.EclipseSingularsRecipes$StatementMaker;
import lombok.eclipse.handlers.EclipseSingularsRecipes$TypeReferenceMaker;
import lombok.eclipse.handlers.HandleNonNull;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/singulars/EclipseJavaUtilListSetSingularizer.SCL.lombok */
abstract class EclipseJavaUtilListSetSingularizer extends EclipseJavaUtilSingularizer {
    EclipseJavaUtilListSetSingularizer() {
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    public List<char[]> listFieldsToBeGenerated(EclipseSingularsRecipes$SingularData data, EclipseNode builderType) {
        if (useGuavaInstead(builderType)) {
            return this.guavaListSetSingularizer.listFieldsToBeGenerated(data, builderType);
        }
        return super.listFieldsToBeGenerated(data, builderType);
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    public List<char[]> listMethodsToBeGenerated(EclipseSingularsRecipes$SingularData data, EclipseNode builderType) {
        if (useGuavaInstead(builderType)) {
            return this.guavaListSetSingularizer.listMethodsToBeGenerated(data, builderType);
        }
        return super.listMethodsToBeGenerated(data, builderType);
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    public List<EclipseNode> generateFields(EclipseSingularsRecipes$SingularData data, EclipseNode builderType) {
        if (useGuavaInstead(builderType)) {
            return this.guavaListSetSingularizer.generateFields(data, builderType);
        }
        TypeReference type = addTypeArgs(1, false, builderType, new QualifiedTypeReference(JAVA_UTIL_ARRAYLIST, NULL_POSS), data.getTypeArgs());
        FieldDeclaration buildField = new FieldDeclaration(data.getPluralName(), 0, -1);
        buildField.bits |= 8388608;
        buildField.modifiers = 2;
        buildField.declarationSourceEnd = -1;
        buildField.type = type;
        data.setGeneratedByRecursive(buildField);
        return Collections.singletonList(EclipseHandlerUtil.injectFieldAndMarkGenerated(builderType, buildField));
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    public void generateMethods(CheckerFrameworkVersion cfv, EclipseSingularsRecipes$SingularData data, boolean deprecate, EclipseNode builderType, boolean fluent, EclipseSingularsRecipes$TypeReferenceMaker returnTypeMaker, EclipseSingularsRecipes$StatementMaker returnStatementMaker, AccessLevel access) {
        if (useGuavaInstead(builderType)) {
            this.guavaListSetSingularizer.generateMethods(cfv, data, deprecate, builderType, fluent, returnTypeMaker, returnStatementMaker, access);
            return;
        }
        generateSingularMethod(cfv, deprecate, returnTypeMaker.make(), returnStatementMaker.mo186make(), data, builderType, fluent, access);
        generatePluralMethod(cfv, deprecate, returnTypeMaker.make(), returnStatementMaker.mo186make(), data, builderType, fluent, access);
        generateClearMethod(cfv, deprecate, returnTypeMaker.make(), returnStatementMaker.mo186make(), data, builderType, access);
    }

    private void generateClearMethod(CheckerFrameworkVersion cfv, boolean deprecate, TypeReference returnType, Statement returnStatement, EclipseSingularsRecipes$SingularData data, EclipseNode builderType, AccessLevel access) {
        MethodDeclaration md = new MethodDeclaration(builderType.top().get().compilationResult);
        md.bits |= 8388608;
        md.modifiers = EclipseHandlerUtil.toEclipseModifier(access);
        FieldReference thisDotField = new FieldReference(data.getPluralName(), 0L);
        thisDotField.receiver = new ThisReference(0, 0);
        FieldReference thisDotField2 = new FieldReference(data.getPluralName(), 0L);
        thisDotField2.receiver = new ThisReference(0, 0);
        md.selector = HandlerUtil.buildAccessorName("clear", new String(data.getPluralName())).toCharArray();
        MessageSend clearMsg = new MessageSend();
        clearMsg.receiver = thisDotField2;
        clearMsg.selector = "clear".toCharArray();
        Statement clearStatement = new IfStatement(new EqualExpression(thisDotField, new NullLiteral(0, 0), 29), clearMsg, 0, 0);
        md.statements = returnStatement != null ? new Statement[]{clearStatement, returnStatement} : new Statement[]{clearStatement};
        md.returnType = returnType;
        md.annotations = generateSelfReturnAnnotations(deprecate, cfv, data.getSource());
        data.setGeneratedByRecursive(md);
        if (returnStatement != null) {
            EclipseHandlerUtil.createRelevantNonNullAnnotation(builderType, md);
        }
        EclipseHandlerUtil.injectMethod(builderType, md);
    }

    void generateSingularMethod(CheckerFrameworkVersion cfv, boolean deprecate, TypeReference returnType, Statement returnStatement, EclipseSingularsRecipes$SingularData data, EclipseNode builderType, boolean fluent, AccessLevel access) {
        MethodDeclaration md = new MethodDeclaration(builderType.top().get().compilationResult);
        md.bits |= 8388608;
        md.modifiers = EclipseHandlerUtil.toEclipseModifier(access);
        List<Statement> statements = new ArrayList<>();
        statements.add(createConstructBuilderVarIfNeeded(data, builderType, false));
        FieldReference thisDotField = new FieldReference(data.getPluralName(), 0L);
        thisDotField.receiver = new ThisReference(0, 0);
        MessageSend thisDotFieldDotAdd = new MessageSend();
        thisDotFieldDotAdd.arguments = new Expression[]{new SingleNameReference(data.getSingularName(), 0L)};
        thisDotFieldDotAdd.receiver = thisDotField;
        thisDotFieldDotAdd.selector = "add".toCharArray();
        statements.add(thisDotFieldDotAdd);
        if (returnStatement != null) {
            statements.add(returnStatement);
        }
        md.statements = (Statement[]) statements.toArray(new Statement[0]);
        TypeReference paramType = cloneParamType(0, data.getTypeArgs(), builderType);
        Annotation[] typeUseAnns = EclipseHandlerUtil.getTypeUseAnnotations(paramType);
        EclipseHandlerUtil.removeTypeUseAnnotations(paramType);
        Argument param = new Argument(data.getSingularName(), 0L, paramType, 16);
        param.annotations = typeUseAnns;
        md.arguments = new Argument[]{param};
        md.returnType = returnType;
        char[] prefixedSingularName = data.getSetterPrefix().length == 0 ? data.getSingularName() : HandlerUtil.buildAccessorName(new String(data.getSetterPrefix()), new String(data.getSingularName())).toCharArray();
        md.selector = fluent ? prefixedSingularName : HandlerUtil.buildAccessorName("add", new String(data.getSingularName())).toCharArray();
        Annotation[] selfReturnAnnotations = generateSelfReturnAnnotations(deprecate, cfv, data.getSource());
        Annotation[] copyToSetterAnnotations = EclipseHandlerUtil.copyAnnotations(md, EclipseHandlerUtil.findCopyableToBuilderSingularSetterAnnotations(data.getAnnotation().up()));
        md.annotations = (Annotation[]) EclipseHandlerUtil.concat(selfReturnAnnotations, copyToSetterAnnotations, Annotation.class);
        if (returnStatement != null) {
            EclipseHandlerUtil.createRelevantNonNullAnnotation(builderType, md);
        }
        data.setGeneratedByRecursive(md);
        HandleNonNull.INSTANCE.fix(EclipseHandlerUtil.injectMethod(builderType, md));
    }

    void generatePluralMethod(CheckerFrameworkVersion cfv, boolean deprecate, TypeReference returnType, Statement returnStatement, EclipseSingularsRecipes$SingularData data, EclipseNode builderType, boolean fluent, AccessLevel access) {
        MethodDeclaration md = new MethodDeclaration(builderType.top().get().compilationResult);
        md.bits |= 8388608;
        md.modifiers = EclipseHandlerUtil.toEclipseModifier(access);
        List<Statement> statements = new ArrayList<>();
        statements.add(createConstructBuilderVarIfNeeded(data, builderType, false));
        FieldReference thisDotField = new FieldReference(data.getPluralName(), 0L);
        thisDotField.receiver = new ThisReference(0, 0);
        MessageSend thisDotFieldDotAddAll = new MessageSend();
        thisDotFieldDotAddAll.arguments = new Expression[]{new SingleNameReference(data.getPluralName(), 0L)};
        thisDotFieldDotAddAll.receiver = thisDotField;
        thisDotFieldDotAddAll.selector = "addAll".toCharArray();
        statements.add(thisDotFieldDotAddAll);
        TypeReference paramType = addTypeArgs(1, true, builderType, new QualifiedTypeReference(TypeConstants.JAVA_UTIL_COLLECTION, NULL_POSS), data.getTypeArgs());
        Argument param = new Argument(data.getPluralName(), 0L, paramType, 16);
        nullBehaviorize(builderType, data, statements, param);
        if (returnStatement != null) {
            statements.add(returnStatement);
        }
        md.statements = (Statement[]) statements.toArray(new Statement[0]);
        md.arguments = new Argument[]{param};
        md.returnType = returnType;
        char[] prefixedSelector = data.getSetterPrefix().length == 0 ? data.getPluralName() : HandlerUtil.buildAccessorName(new String(data.getSetterPrefix()), new String(data.getPluralName())).toCharArray();
        md.selector = fluent ? prefixedSelector : HandlerUtil.buildAccessorName("addAll", new String(data.getPluralName())).toCharArray();
        Annotation[] selfReturnAnnotations = generateSelfReturnAnnotations(deprecate, cfv, data.getSource());
        Annotation[] copyToSetterAnnotations = EclipseHandlerUtil.copyAnnotations(md, EclipseHandlerUtil.findCopyableToSetterAnnotations(data.getAnnotation().up()));
        md.annotations = (Annotation[]) EclipseHandlerUtil.concat(selfReturnAnnotations, copyToSetterAnnotations, Annotation.class);
        if (returnStatement != null) {
            EclipseHandlerUtil.createRelevantNonNullAnnotation(builderType, md);
        }
        data.setGeneratedByRecursive(md);
        EclipseHandlerUtil.injectMethod(builderType, md);
    }
}
