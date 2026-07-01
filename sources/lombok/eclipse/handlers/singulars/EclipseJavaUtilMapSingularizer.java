package lombok.eclipse.handlers.singulars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.AccessLevel;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.eclipse.handlers.EclipseSingularsRecipes;
import lombok.eclipse.handlers.HandleNonNull;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/singulars/EclipseJavaUtilMapSingularizer.SCL.lombok */
public class EclipseJavaUtilMapSingularizer extends EclipseJavaUtilSingularizer {
    private static final char[] EMPTY_SORTED_MAP = {'e', 'm', 'p', 't', 'y', 'S', 'o', 'r', 't', 'e', 'd', 'M', 'a', 'p'};
    private static final char[] EMPTY_NAVIGABLE_MAP = {'e', 'm', 'p', 't', 'y', 'N', 'a', 'v', 'i', 'g', 'a', 'b', 'l', 'e', 'M', 'a', 'p'};
    private static final char[] EMPTY_MAP = {'e', 'm', 'p', 't', 'y', 'M', 'a', 'p'};

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public LombokImmutableList<String> getSupportedTypes() {
        return LombokImmutableList.of("java.util.Map", "java.util.SortedMap", "java.util.NavigableMap");
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    protected char[][] getEmptyMakerReceiver(String targetFqn) {
        return JAVA_UTIL_COLLECTIONS;
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    protected char[] getEmptyMakerSelector(String targetFqn) {
        if (targetFqn.endsWith("SortedMap")) {
            return EMPTY_SORTED_MAP;
        }
        return targetFqn.endsWith("NavigableMap") ? EMPTY_NAVIGABLE_MAP : EMPTY_MAP;
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public List<char[]> listFieldsToBeGenerated(EclipseSingularsRecipes.SingularData data, EclipseNode builderType) {
        if (useGuavaInstead(builderType)) {
            return this.guavaMapSingularizer.listFieldsToBeGenerated(data, builderType);
        }
        char[] p = data.getPluralName();
        int len = p.length;
        char[] k = new char[len + 4];
        char[] v = new char[len + 6];
        System.arraycopy(p, 0, k, 0, len);
        System.arraycopy(p, 0, v, 0, len);
        k[len] = '$';
        k[len + 1] = 'k';
        k[len + 2] = 'e';
        k[len + 3] = 'y';
        v[len] = '$';
        v[len + 1] = 'v';
        v[len + 2] = 'a';
        v[len + 3] = 'l';
        v[len + 4] = 'u';
        v[len + 5] = 'e';
        return Arrays.asList(k, v);
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public List<char[]> listMethodsToBeGenerated(EclipseSingularsRecipes.SingularData data, EclipseNode builderType) {
        if (useGuavaInstead(builderType)) {
            return this.guavaMapSingularizer.listFieldsToBeGenerated(data, builderType);
        }
        return super.listMethodsToBeGenerated(data, builderType);
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public List<EclipseNode> generateFields(EclipseSingularsRecipes.SingularData data, EclipseNode builderType) {
        if (useGuavaInstead(builderType)) {
            return this.guavaMapSingularizer.generateFields(data, builderType);
        }
        char[] keyName = (String.valueOf(new String(data.getPluralName())) + "$key").toCharArray();
        char[] valueName = (String.valueOf(new String(data.getPluralName())) + "$value").toCharArray();
        TypeReference type = addTypeArgs(1, false, builderType, new QualifiedTypeReference(JAVA_UTIL_ARRAYLIST, NULL_POSS), data.getTypeArgs());
        FieldDeclaration buildKeyField = new FieldDeclaration(keyName, 0, -1);
        buildKeyField.bits |= 8388608;
        buildKeyField.modifiers = 2;
        buildKeyField.declarationSourceEnd = -1;
        buildKeyField.type = type;
        QualifiedTypeReference qualifiedTypeReference = new QualifiedTypeReference(JAVA_UTIL_ARRAYLIST, NULL_POSS);
        List<TypeReference> tArgs = data.getTypeArgs();
        TypeReference type2 = addTypeArgs(1, false, builderType, qualifiedTypeReference, (tArgs == null || tArgs.size() <= 1) ? Collections.emptyList() : Collections.singletonList(tArgs.get(1)));
        FieldDeclaration buildValueField = new FieldDeclaration(valueName, 0, -1);
        buildValueField.bits |= 8388608;
        buildValueField.modifiers = 2;
        buildValueField.declarationSourceEnd = -1;
        buildValueField.type = type2;
        data.setGeneratedByRecursive(buildKeyField);
        data.setGeneratedByRecursive(buildValueField);
        EclipseNode keyFieldNode = EclipseHandlerUtil.injectFieldAndMarkGenerated(builderType, buildKeyField);
        EclipseNode valueFieldNode = EclipseHandlerUtil.injectFieldAndMarkGenerated(builderType, buildValueField);
        return Arrays.asList(keyFieldNode, valueFieldNode);
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public void generateMethods(CheckerFrameworkVersion cfv, EclipseSingularsRecipes.SingularData data, boolean deprecate, EclipseNode builderType, boolean fluent, EclipseSingularsRecipes.TypeReferenceMaker returnTypeMaker, EclipseSingularsRecipes.StatementMaker returnStatementMaker, AccessLevel access) {
        if (useGuavaInstead(builderType)) {
            this.guavaMapSingularizer.generateMethods(cfv, data, deprecate, builderType, fluent, returnTypeMaker, returnStatementMaker, access);
            return;
        }
        generateSingularMethod(cfv, deprecate, returnTypeMaker.make(), returnStatementMaker.mo186make(), data, builderType, fluent, access);
        generatePluralMethod(cfv, deprecate, returnTypeMaker.make(), returnStatementMaker.mo186make(), data, builderType, fluent, access);
        generateClearMethod(cfv, deprecate, returnTypeMaker.make(), returnStatementMaker.mo186make(), data, builderType, access);
    }

    private void generateClearMethod(CheckerFrameworkVersion cfv, boolean deprecate, TypeReference returnType, Statement returnStatement, EclipseSingularsRecipes.SingularData data, EclipseNode builderType, AccessLevel access) {
        MethodDeclaration md = new MethodDeclaration(builderType.top().get().compilationResult);
        md.bits |= 8388608;
        md.modifiers = EclipseHandlerUtil.toEclipseModifier(access);
        String pN = new String(data.getPluralName());
        char[] keyFieldName = (String.valueOf(pN) + "$key").toCharArray();
        char[] valueFieldName = (String.valueOf(pN) + "$value").toCharArray();
        FieldReference thisDotField = new FieldReference(keyFieldName, 0L);
        thisDotField.receiver = new ThisReference(0, 0);
        FieldReference thisDotField2 = new FieldReference(keyFieldName, 0L);
        thisDotField2.receiver = new ThisReference(0, 0);
        FieldReference thisDotField3 = new FieldReference(valueFieldName, 0L);
        thisDotField3.receiver = new ThisReference(0, 0);
        md.selector = HandlerUtil.buildAccessorName("clear", new String(data.getPluralName())).toCharArray();
        Statement messageSend = new MessageSend();
        ((MessageSend) messageSend).receiver = thisDotField2;
        ((MessageSend) messageSend).selector = "clear".toCharArray();
        Statement messageSend2 = new MessageSend();
        ((MessageSend) messageSend2).receiver = thisDotField3;
        ((MessageSend) messageSend2).selector = "clear".toCharArray();
        Block clearMsgs = new Block(2);
        clearMsgs.statements = new Statement[]{messageSend, messageSend2};
        Statement clearStatement = new IfStatement(new EqualExpression(thisDotField, new NullLiteral(0, 0), 29), clearMsgs, 0, 0);
        md.statements = returnStatement != null ? new Statement[]{clearStatement, returnStatement} : new Statement[]{clearStatement};
        md.returnType = returnType;
        md.annotations = generateSelfReturnAnnotations(deprecate, cfv, data.getSource());
        if (returnStatement != null) {
            EclipseHandlerUtil.createRelevantNonNullAnnotation(builderType, md);
        }
        data.setGeneratedByRecursive(md);
        EclipseHandlerUtil.injectMethod(builderType, md);
    }

    private void generateSingularMethod(CheckerFrameworkVersion cfv, boolean deprecate, TypeReference returnType, Statement returnStatement, EclipseSingularsRecipes.SingularData data, EclipseNode builderType, boolean fluent, AccessLevel access) {
        String str;
        MethodDeclaration md = new MethodDeclaration(builderType.top().get().compilationResult);
        md.bits |= 8388608;
        md.modifiers = EclipseHandlerUtil.toEclipseModifier(access);
        List<Statement> statements = new ArrayList<>();
        statements.add(createConstructBuilderVarIfNeeded(data, builderType, true));
        String sN = new String(data.getSingularName());
        String pN = new String(data.getPluralName());
        char[] keyParamName = (String.valueOf(sN) + "Key").toCharArray();
        char[] valueParamName = (String.valueOf(sN) + "Value").toCharArray();
        char[] keyFieldName = (String.valueOf(pN) + "$key").toCharArray();
        char[] valueFieldName = (String.valueOf(pN) + "$value").toCharArray();
        FieldReference thisDotKeyField = new FieldReference(keyFieldName, 0L);
        thisDotKeyField.receiver = new ThisReference(0, 0);
        MessageSend thisDotKeyFieldDotAdd = new MessageSend();
        thisDotKeyFieldDotAdd.arguments = new Expression[]{new SingleNameReference(keyParamName, 0L)};
        thisDotKeyFieldDotAdd.receiver = thisDotKeyField;
        thisDotKeyFieldDotAdd.selector = "add".toCharArray();
        statements.add(thisDotKeyFieldDotAdd);
        FieldReference thisDotValueField = new FieldReference(valueFieldName, 0L);
        thisDotValueField.receiver = new ThisReference(0, 0);
        MessageSend thisDotValueFieldDotAdd = new MessageSend();
        thisDotValueFieldDotAdd.arguments = new Expression[]{new SingleNameReference(valueParamName, 0L)};
        thisDotValueFieldDotAdd.receiver = thisDotValueField;
        thisDotValueFieldDotAdd.selector = "add".toCharArray();
        statements.add(thisDotValueFieldDotAdd);
        if (returnStatement != null) {
            statements.add(returnStatement);
        }
        md.statements = (Statement[]) statements.toArray(new Statement[0]);
        TypeReference keyParamType = cloneParamType(0, data.getTypeArgs(), builderType);
        TypeReference valueParamType = cloneParamType(1, data.getTypeArgs(), builderType);
        Annotation[] typeUseAnnsKey = EclipseHandlerUtil.getTypeUseAnnotations(keyParamType);
        Annotation[] typeUseAnnsValue = EclipseHandlerUtil.getTypeUseAnnotations(valueParamType);
        EclipseHandlerUtil.removeTypeUseAnnotations(keyParamType);
        EclipseHandlerUtil.removeTypeUseAnnotations(valueParamType);
        Argument keyParam = new Argument(keyParamName, 0L, keyParamType, 16);
        Argument valueParam = new Argument(valueParamName, 0L, valueParamType, 16);
        keyParam.annotations = typeUseAnnsKey;
        valueParam.annotations = typeUseAnnsValue;
        md.arguments = new Argument[]{keyParam, valueParam};
        md.returnType = returnType;
        String name = new String(data.getSingularName());
        if (data.getSetterPrefix().length > 0) {
            str = new String(data.getSetterPrefix());
        } else {
            str = fluent ? "" : "put";
        }
        String setterPrefix = str;
        String setterName = HandlerUtil.buildAccessorName(setterPrefix, name);
        md.selector = setterName.toCharArray();
        Annotation[] selfReturnAnnotations = generateSelfReturnAnnotations(deprecate, cfv, data.getSource());
        Annotation[] copyToSetterAnnotations = EclipseHandlerUtil.copyAnnotations(md, EclipseHandlerUtil.findCopyableToBuilderSingularSetterAnnotations(data.getAnnotation().up()));
        md.annotations = (Annotation[]) EclipseHandlerUtil.concat(selfReturnAnnotations, copyToSetterAnnotations, Annotation.class);
        if (returnStatement != null) {
            EclipseHandlerUtil.createRelevantNonNullAnnotation(builderType, md);
        }
        data.setGeneratedByRecursive(md);
        HandleNonNull.INSTANCE.fix(EclipseHandlerUtil.injectMethod(builderType, md));
    }

    private void generatePluralMethod(CheckerFrameworkVersion cfv, boolean deprecate, TypeReference returnType, Statement returnStatement, EclipseSingularsRecipes.SingularData data, EclipseNode builderType, boolean fluent, AccessLevel access) {
        String str;
        MethodDeclaration md = new MethodDeclaration(builderType.top().get().compilationResult);
        md.bits |= 8388608;
        md.modifiers = EclipseHandlerUtil.toEclipseModifier(access);
        String pN = new String(data.getPluralName());
        char[] keyFieldName = (String.valueOf(pN) + "$key").toCharArray();
        char[] valueFieldName = (String.valueOf(pN) + "$value").toCharArray();
        List<Statement> statements = new ArrayList<>();
        statements.add(createConstructBuilderVarIfNeeded(data, builderType, true));
        char[] entryName = "$lombokEntry".toCharArray();
        TypeReference forEachType = addTypeArgs(2, true, builderType, new QualifiedTypeReference(JAVA_UTIL_MAP_ENTRY, NULL_POSS), data.getTypeArgs());
        Expression messageSend = new MessageSend();
        ((MessageSend) messageSend).receiver = new SingleNameReference(entryName, 0L);
        ((MessageSend) messageSend).selector = "getKey".toCharArray();
        Statement messageSend2 = new MessageSend();
        FieldReference thisDotKeyField = new FieldReference(keyFieldName, 0L);
        thisDotKeyField.receiver = new ThisReference(0, 0);
        ((MessageSend) messageSend2).receiver = thisDotKeyField;
        ((MessageSend) messageSend2).selector = new char[]{'a', 'd', 'd'};
        ((MessageSend) messageSend2).arguments = new Expression[]{messageSend};
        Expression messageSend3 = new MessageSend();
        ((MessageSend) messageSend3).receiver = new SingleNameReference(entryName, 0L);
        ((MessageSend) messageSend3).selector = "getValue".toCharArray();
        Statement messageSend4 = new MessageSend();
        FieldReference thisDotValueField = new FieldReference(valueFieldName, 0L);
        thisDotValueField.receiver = new ThisReference(0, 0);
        ((MessageSend) messageSend4).receiver = thisDotValueField;
        ((MessageSend) messageSend4).selector = new char[]{'a', 'd', 'd'};
        ((MessageSend) messageSend4).arguments = new Expression[]{messageSend3};
        LocalDeclaration elementVariable = new LocalDeclaration(entryName, 0, 0);
        elementVariable.type = forEachType;
        ForeachStatement forEach = new ForeachStatement(elementVariable, 0);
        MessageSend invokeEntrySet = new MessageSend();
        invokeEntrySet.selector = new char[]{'e', 'n', 't', 'r', 'y', 'S', 'e', 't'};
        invokeEntrySet.receiver = new SingleNameReference(data.getPluralName(), 0L);
        forEach.collection = invokeEntrySet;
        Block forEachContent = new Block(0);
        forEachContent.statements = new Statement[]{messageSend2, messageSend4};
        forEach.action = forEachContent;
        statements.add(forEach);
        TypeReference paramType = addTypeArgs(2, true, builderType, new QualifiedTypeReference(JAVA_UTIL_MAP, NULL_POSS), data.getTypeArgs());
        Argument param = new Argument(data.getPluralName(), 0L, paramType, 16);
        nullBehaviorize(builderType, data, statements, param);
        if (returnStatement != null) {
            statements.add(returnStatement);
        }
        md.statements = (Statement[]) statements.toArray(new Statement[0]);
        md.arguments = new Argument[]{param};
        md.returnType = returnType;
        String name = new String(data.getPluralName());
        if (data.getSetterPrefix().length > 0) {
            str = new String(data.getSetterPrefix());
        } else {
            str = fluent ? "" : "put";
        }
        String setterPrefix = str;
        String setterName = HandlerUtil.buildAccessorName(setterPrefix, name);
        md.selector = setterName.toCharArray();
        Annotation[] selfReturnAnnotations = generateSelfReturnAnnotations(deprecate, cfv, data.getSource());
        Annotation[] copyToSetterAnnotations = EclipseHandlerUtil.copyAnnotations(md, EclipseHandlerUtil.findCopyableToSetterAnnotations(data.getAnnotation().up()));
        md.annotations = (Annotation[]) EclipseHandlerUtil.concat(selfReturnAnnotations, copyToSetterAnnotations, Annotation.class);
        if (returnStatement != null) {
            EclipseHandlerUtil.createRelevantNonNullAnnotation(builderType, md);
        }
        data.setGeneratedByRecursive(md);
        EclipseHandlerUtil.injectMethod(builderType, md);
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public void appendBuildCode(EclipseSingularsRecipes.SingularData data, EclipseNode builderType, List<Statement> statements, char[] targetVariableName, String builderVariable) {
        if (useGuavaInstead(builderType)) {
            this.guavaMapSingularizer.appendBuildCode(data, builderType, statements, targetVariableName, builderVariable);
        } else if (data.getTargetFqn().equals("java.util.Map")) {
            statements.addAll(createJavaUtilSetMapInitialCapacitySwitchStatements(data, builderType, true, "emptyMap", "singletonMap", "LinkedHashMap", builderVariable));
        } else {
            statements.addAll(createJavaUtilSimpleCreationAndFillStatements(data, builderType, true, true, false, true, "TreeMap", builderVariable));
        }
    }
}
