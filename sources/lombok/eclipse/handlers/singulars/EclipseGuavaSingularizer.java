package lombok.eclipse.handlers.singulars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AccessLevel;
import lombok.core.GuavaTypeMap;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.Eclipse;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer;
import lombok.eclipse.handlers.EclipseSingularsRecipes$SingularData;
import lombok.eclipse.handlers.EclipseSingularsRecipes$StatementMaker;
import lombok.eclipse.handlers.EclipseSingularsRecipes$TypeReferenceMaker;
import lombok.eclipse.handlers.HandleNonNull;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.ConditionalExpression;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/singulars/EclipseGuavaSingularizer.SCL.lombok */
abstract class EclipseGuavaSingularizer extends EclipseSingularsRecipes$EclipseSingularizer {
    protected static final char[] OF = {'o', 'f'};
    protected static final char[][] CGCC = {new char[]{'c', 'o', 'm'}, new char[]{'g', 'o', 'o', 'g', 'l', 'e'}, new char[]{'c', 'o', 'm', 'm', 'o', 'n'}, new char[]{'c', 'o', 'l', 'l', 'e', 'c', 't'}};

    protected abstract LombokImmutableList<String> getArgumentSuffixes();

    protected abstract String getAddMethodName();

    protected abstract String getAddAllTypeName();

    EclipseGuavaSingularizer() {
    }

    protected String getSimpleTargetTypeName(EclipseSingularsRecipes$SingularData data) {
        return GuavaTypeMap.getGuavaTypeName(data.getTargetFqn());
    }

    protected char[] getBuilderMethodName(EclipseSingularsRecipes$SingularData data) {
        String simpleTypeName = getSimpleTargetTypeName(data);
        return ("ImmutableSortedSet".equals(simpleTypeName) || "ImmutableSortedMap".equals(simpleTypeName)) ? "naturalOrder".toCharArray() : "builder".toCharArray();
    }

    protected char[][] makeGuavaTypeName(String simpleName, boolean addBuilder) {
        char[][] tokenizedName = new char[addBuilder ? 6 : 5][];
        tokenizedName[0] = CGCC[0];
        tokenizedName[1] = CGCC[1];
        tokenizedName[2] = CGCC[2];
        tokenizedName[3] = CGCC[3];
        tokenizedName[4] = simpleName.toCharArray();
        if (addBuilder) {
            tokenizedName[5] = new char[]{'B', 'u', 'i', 'l', 'd', 'e', 'r'};
        }
        return tokenizedName;
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    protected char[] getEmptyMakerSelector(String targetFqn) {
        return OF;
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    protected char[][] getEmptyMakerReceiver(String targetFqn) {
        return CGCC;
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    public List<EclipseNode> generateFields(EclipseSingularsRecipes$SingularData data, EclipseNode builderType) {
        String simpleTypeName = getSimpleTargetTypeName(data);
        char[][] tokenizedName = makeGuavaTypeName(simpleTypeName, true);
        TypeReference type = addTypeArgs(getTypeArgumentsCount(), false, builderType, new QualifiedTypeReference(tokenizedName, NULL_POSS), data.getTypeArgs());
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
        generateSingularMethod(cfv, deprecate, returnTypeMaker.make(), returnStatementMaker.mo186make(), data, builderType, fluent, access);
        generatePluralMethod(cfv, deprecate, returnTypeMaker.make(), returnStatementMaker.mo186make(), data, builderType, fluent, access);
        generateClearMethod(cfv, deprecate, returnTypeMaker.make(), returnStatementMaker.mo186make(), data, builderType, access);
    }

    void generateClearMethod(CheckerFrameworkVersion cfv, boolean deprecate, TypeReference returnType, Statement returnStatement, EclipseSingularsRecipes$SingularData data, EclipseNode builderType, AccessLevel access) {
        MethodDeclaration md = new MethodDeclaration(builderType.top().get().compilationResult);
        md.bits |= 8388608;
        md.modifiers = EclipseHandlerUtil.toEclipseModifier(access);
        FieldReference thisDotField = new FieldReference(data.getPluralName(), 0L);
        thisDotField.receiver = new ThisReference(0, 0);
        Statement assignment = new Assignment(thisDotField, new NullLiteral(0, 0), 0);
        md.selector = HandlerUtil.buildAccessorName("clear", new String(data.getPluralName())).toCharArray();
        md.statements = returnStatement != null ? new Statement[]{assignment, returnStatement} : new Statement[]{assignment};
        md.returnType = returnType;
        md.annotations = generateSelfReturnAnnotations(deprecate, cfv, data.getSource());
        data.setGeneratedByRecursive(md);
        if (returnStatement != null) {
            EclipseHandlerUtil.createRelevantNonNullAnnotation(builderType, md);
        }
        EclipseHandlerUtil.injectMethod(builderType, md);
    }

    void generateSingularMethod(CheckerFrameworkVersion cfv, boolean deprecate, TypeReference returnType, Statement returnStatement, EclipseSingularsRecipes$SingularData data, EclipseNode builderType, boolean fluent, AccessLevel access) {
        LombokImmutableList<String> suffixes = getArgumentSuffixes();
        char[][] names = new char[suffixes.size()][];
        for (int i = 0; i < suffixes.size(); i++) {
            String s2 = suffixes.get(i);
            char[] n = data.getSingularName();
            names[i] = s2.isEmpty() ? n : s2.toCharArray();
        }
        MethodDeclaration md = new MethodDeclaration(builderType.top().get().compilationResult);
        md.bits |= 8388608;
        md.modifiers = EclipseHandlerUtil.toEclipseModifier(access);
        List<Statement> statements = new ArrayList<>();
        statements.add(createConstructBuilderVarIfNeeded(data, builderType));
        FieldReference thisDotField = new FieldReference(data.getPluralName(), 0L);
        thisDotField.receiver = new ThisReference(0, 0);
        MessageSend thisDotFieldDotAdd = new MessageSend();
        thisDotFieldDotAdd.arguments = new Expression[suffixes.size()];
        for (int i2 = 0; i2 < suffixes.size(); i2++) {
            thisDotFieldDotAdd.arguments[i2] = new SingleNameReference(names[i2], 0L);
        }
        thisDotFieldDotAdd.receiver = thisDotField;
        thisDotFieldDotAdd.selector = getAddMethodName().toCharArray();
        statements.add(thisDotFieldDotAdd);
        if (returnStatement != null) {
            statements.add(returnStatement);
        }
        md.statements = (Statement[]) statements.toArray(new Statement[0]);
        md.arguments = new Argument[suffixes.size()];
        for (int i3 = 0; i3 < suffixes.size(); i3++) {
            TypeReference tr = cloneParamType(i3, data.getTypeArgs(), builderType);
            Annotation[] typeUseAnns = EclipseHandlerUtil.getTypeUseAnnotations(tr);
            EclipseHandlerUtil.removeTypeUseAnnotations(tr);
            md.arguments[i3] = new Argument(names[i3], 0L, tr, 16);
            md.arguments[i3].annotations = typeUseAnns;
        }
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
        statements.add(createConstructBuilderVarIfNeeded(data, builderType));
        FieldReference thisDotField = new FieldReference(data.getPluralName(), 0L);
        thisDotField.receiver = new ThisReference(0, 0);
        MessageSend thisDotFieldDotAddAll = new MessageSend();
        thisDotFieldDotAddAll.arguments = new Expression[]{new SingleNameReference(data.getPluralName(), 0L)};
        thisDotFieldDotAddAll.receiver = thisDotField;
        thisDotFieldDotAddAll.selector = (String.valueOf(getAddMethodName()) + "All").toCharArray();
        statements.add(thisDotFieldDotAddAll);
        TypeReference paramType = addTypeArgs(getTypeArgumentsCount(), true, builderType, new QualifiedTypeReference(Eclipse.fromQualifiedName(getAddAllTypeName()), NULL_POSS), data.getTypeArgs());
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

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    public void appendBuildCode(EclipseSingularsRecipes$SingularData data, EclipseNode builderType, List<Statement> statements, char[] targetVariableName, String builderVariable) {
        QualifiedTypeReference qualifiedTypeReference = new QualifiedTypeReference(Eclipse.fromQualifiedName(data.getTargetFqn()), NULL_POSS);
        String simpleTypeName = getSimpleTargetTypeName(data);
        int agrumentsCount = getTypeArgumentsCount();
        TypeReference varType = addTypeArgs(agrumentsCount, false, builderType, qualifiedTypeReference, data.getTypeArgs());
        MessageSend emptyInvoke = new MessageSend();
        emptyInvoke.selector = new char[]{'o', 'f'};
        emptyInvoke.receiver = new QualifiedNameReference(makeGuavaTypeName(simpleTypeName, false), NULL_POSS, 0, 0);
        emptyInvoke.typeArguments = createTypeArgs(agrumentsCount, false, builderType, data.getTypeArgs());
        MessageSend invokeBuild = new MessageSend();
        invokeBuild.selector = new char[]{'b', 'u', 'i', 'l', 'd'};
        FieldReference thisDotField = new FieldReference(data.getPluralName(), 0L);
        thisDotField.receiver = getBuilderReference(builderVariable);
        invokeBuild.receiver = thisDotField;
        FieldReference thisDotField2 = new FieldReference(data.getPluralName(), 0L);
        thisDotField2.receiver = getBuilderReference(builderVariable);
        ConditionalExpression conditionalExpression = new ConditionalExpression(new EqualExpression(thisDotField2, new NullLiteral(0, 0), 18), emptyInvoke, invokeBuild);
        LocalDeclaration varDefStat = new LocalDeclaration(data.getPluralName(), 0, 0);
        varDefStat.type = varType;
        varDefStat.initialization = conditionalExpression;
        statements.add(varDefStat);
    }

    protected Statement createConstructBuilderVarIfNeeded(EclipseSingularsRecipes$SingularData data, EclipseNode builderType) {
        FieldReference thisDotField = new FieldReference(data.getPluralName(), 0L);
        thisDotField.receiver = new ThisReference(0, 0);
        FieldReference thisDotField2 = new FieldReference(data.getPluralName(), 0L);
        thisDotField2.receiver = new ThisReference(0, 0);
        EqualExpression equalExpression = new EqualExpression(thisDotField, new NullLiteral(0, 0), 18);
        MessageSend createBuilderInvoke = new MessageSend();
        char[][] tokenizedName = makeGuavaTypeName(getSimpleTargetTypeName(data), false);
        createBuilderInvoke.receiver = new QualifiedNameReference(tokenizedName, NULL_POSS, 0, 0);
        createBuilderInvoke.selector = getBuilderMethodName(data);
        return new IfStatement(equalExpression, new Assignment(thisDotField2, createBuilderInvoke, 0), 0, 0);
    }

    protected int getTypeArgumentsCount() {
        return getArgumentSuffixes().size();
    }
}
