package lombok.eclipse.handlers.singulars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.ConfigurationKeys;
import lombok.eclipse.Eclipse;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.eclipse.handlers.EclipseSingularsRecipes;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.BinaryExpression;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.BreakStatement;
import org.eclipse.jdt.internal.compiler.ast.ConditionalExpression;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.ForStatement;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.IntLiteral;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.PostfixExpression;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.SwitchStatement;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/singulars/EclipseJavaUtilSingularizer.SCL.lombok */
abstract class EclipseJavaUtilSingularizer extends EclipseSingularsRecipes.EclipseSingularizer {
    protected static final char[][] JAVA_UTIL_ARRAYLIST = {new char[]{'j', 'a', 'v', 'a'}, new char[]{'u', 't', 'i', 'l'}, new char[]{'A', 'r', 'r', 'a', 'y', 'L', 'i', 's', 't'}};
    protected static final char[][] JAVA_UTIL_LIST = {new char[]{'j', 'a', 'v', 'a'}, new char[]{'u', 't', 'i', 'l'}, new char[]{'L', 'i', 's', 't'}};
    protected static final char[][] JAVA_UTIL_MAP = {new char[]{'j', 'a', 'v', 'a'}, new char[]{'u', 't', 'i', 'l'}, new char[]{'M', 'a', 'p'}};
    protected static final char[][] JAVA_UTIL_MAP_ENTRY = {new char[]{'j', 'a', 'v', 'a'}, new char[]{'u', 't', 'i', 'l'}, new char[]{'M', 'a', 'p'}, new char[]{'E', 'n', 't', 'r', 'y'}};
    protected static final char[][] JAVA_UTIL_COLLECTIONS = {new char[]{'j', 'a', 'v', 'a'}, new char[]{'u', 't', 'i', 'l'}, new char[]{'C', 'o', 'l', 'l', 'e', 'c', 't', 'i', 'o', 'n', 's'}};
    protected final EclipseSingularsRecipes.EclipseSingularizer guavaListSetSingularizer = new EclipseGuavaSetListSingularizer();
    protected final EclipseSingularsRecipes.EclipseSingularizer guavaMapSingularizer = new EclipseGuavaMapSingularizer();

    EclipseJavaUtilSingularizer() {
    }

    protected boolean useGuavaInstead(EclipseNode node) {
        return Boolean.TRUE.equals(node.getAst().readConfiguration(ConfigurationKeys.SINGULAR_USE_GUAVA));
    }

    protected List<Statement> createJavaUtilSetMapInitialCapacitySwitchStatements(EclipseSingularsRecipes.SingularData data, EclipseNode builderType, boolean mapMode, String emptyCollectionMethod, String singletonCollectionMethod, String targetType, String builderVariable) {
        Expression[] args;
        List<Statement> switchContents = new ArrayList<>();
        char[] keyName = mapMode ? (String.valueOf(new String(data.getPluralName())) + "$key").toCharArray() : data.getPluralName();
        if (emptyCollectionMethod != null) {
            switchContents.add(Eclipse.createCaseStatement(EclipseHandlerUtil.makeIntLiteral(new char[]{'0'}, null)));
            MessageSend invoke = new MessageSend();
            invoke.receiver = new QualifiedNameReference(JAVA_UTIL_COLLECTIONS, NULL_POSS, 0, 0);
            invoke.selector = emptyCollectionMethod.toCharArray();
            switchContents.add(new Assignment(new SingleNameReference(data.getPluralName(), 0L), invoke, 0));
            switchContents.add(new BreakStatement((char[]) null, 0, 0));
        }
        if (singletonCollectionMethod != null) {
            switchContents.add(Eclipse.createCaseStatement(EclipseHandlerUtil.makeIntLiteral(new char[]{'1'}, null)));
            FieldReference thisDotKey = new FieldReference(keyName, 0L);
            thisDotKey.receiver = getBuilderReference(builderVariable);
            Expression messageSend = new MessageSend();
            ((MessageSend) messageSend).receiver = thisDotKey;
            ((MessageSend) messageSend).selector = new char[]{'g', 'e', 't'};
            ((MessageSend) messageSend).arguments = new Expression[]{EclipseHandlerUtil.makeIntLiteral(new char[]{'0'}, null)};
            if (mapMode) {
                char[] valueName = (String.valueOf(new String(data.getPluralName())) + "$value").toCharArray();
                FieldReference thisDotValue = new FieldReference(valueName, 0L);
                thisDotValue.receiver = getBuilderReference(builderVariable);
                MessageSend thisDotValueGet0 = new MessageSend();
                thisDotValueGet0.receiver = thisDotValue;
                thisDotValueGet0.selector = new char[]{'g', 'e', 't'};
                thisDotValueGet0.arguments = new Expression[]{EclipseHandlerUtil.makeIntLiteral(new char[]{'0'}, null)};
                args = new Expression[]{messageSend, thisDotValueGet0};
            } else {
                args = new Expression[]{messageSend};
            }
            MessageSend invoke2 = new MessageSend();
            invoke2.receiver = new QualifiedNameReference(JAVA_UTIL_COLLECTIONS, NULL_POSS, 0, 0);
            invoke2.selector = singletonCollectionMethod.toCharArray();
            invoke2.arguments = args;
            switchContents.add(new Assignment(new SingleNameReference(data.getPluralName(), 0L), invoke2, 0));
            switchContents.add(new BreakStatement((char[]) null, 0, 0));
        }
        switchContents.add(Eclipse.createCaseStatement(null));
        switchContents.addAll(createJavaUtilSimpleCreationAndFillStatements(data, builderType, mapMode, false, true, emptyCollectionMethod == null, targetType, builderVariable));
        Statement switchStatement = new SwitchStatement();
        ((SwitchStatement) switchStatement).statements = (Statement[]) switchContents.toArray(new Statement[0]);
        ((SwitchStatement) switchStatement).expression = getSize(builderType, keyName, true, builderVariable);
        TypeReference localShadowerType = addTypeArgs(mapMode ? 2 : 1, false, builderType, new QualifiedTypeReference(Eclipse.fromQualifiedName(data.getTargetFqn()), NULL_POSS), data.getTypeArgs());
        Statement localDeclaration = new LocalDeclaration(data.getPluralName(), 0, 0);
        ((LocalDeclaration) localDeclaration).type = localShadowerType;
        return Arrays.asList(localDeclaration, switchStatement);
    }

    protected List<Statement> createJavaUtilSimpleCreationAndFillStatements(EclipseSingularsRecipes.SingularData data, EclipseNode builderType, boolean mapMode, boolean defineVar, boolean addInitialCapacityArg, boolean nullGuard, String targetType, String builderVariable) {
        LocalDeclaration assignment;
        ForStatement ifStatement;
        char[] varName = mapMode ? (String.valueOf(new String(data.getPluralName())) + "$key").toCharArray() : data.getPluralName();
        Expression[] constructorArgs = null;
        if (addInitialCapacityArg) {
            BinaryExpression binaryExpression = new BinaryExpression(getSize(builderType, varName, nullGuard, builderVariable), EclipseHandlerUtil.makeIntLiteral("0x40000000".toCharArray(), null), 4);
            FieldReference integerMaxValue = new FieldReference("MAX_VALUE".toCharArray(), 0L);
            integerMaxValue.receiver = new QualifiedNameReference(TypeConstants.JAVA_LANG_INTEGER, NULL_POSS, 0, 0);
            constructorArgs = new Expression[]{new ConditionalExpression(binaryExpression, new BinaryExpression(new BinaryExpression(EclipseHandlerUtil.makeIntLiteral(new char[]{'1'}, null), getSize(builderType, varName, nullGuard, builderVariable), 14), new BinaryExpression(new BinaryExpression(getSize(builderType, varName, nullGuard, builderVariable), EclipseHandlerUtil.makeIntLiteral(new char[]{'3'}, null), 13), EclipseHandlerUtil.makeIntLiteral(new char[]{'3'}, null), 9), 14), integerMaxValue)};
        }
        TypeReference targetTypeRef = addTypeArgs(mapMode ? 2 : 1, false, builderType, new QualifiedTypeReference(new char[][]{TypeConstants.JAVA, TypeConstants.UTIL, targetType.toCharArray()}, NULL_POSS), data.getTypeArgs());
        AllocationExpression constructorCall = new AllocationExpression();
        constructorCall.type = targetTypeRef;
        constructorCall.arguments = constructorArgs;
        if (defineVar) {
            TypeReference localShadowerType = addTypeArgs(mapMode ? 2 : 1, false, builderType, new QualifiedTypeReference(Eclipse.fromQualifiedName(data.getTargetFqn()), NULL_POSS), data.getTypeArgs());
            LocalDeclaration localShadowerDecl = new LocalDeclaration(data.getPluralName(), 0, 0);
            localShadowerDecl.type = localShadowerType;
            localShadowerDecl.initialization = constructorCall;
            assignment = localShadowerDecl;
        } else {
            assignment = new Assignment(new SingleNameReference(data.getPluralName(), 0L), constructorCall, 0);
        }
        if (mapMode) {
            char[] iVar = {'$', 'i'};
            MessageSend pluralnameDotPut = new MessageSend();
            pluralnameDotPut.selector = new char[]{'p', 'u', 't'};
            pluralnameDotPut.receiver = new SingleNameReference(data.getPluralName(), 0L);
            FieldReference thisDotKey = new FieldReference(varName, 0L);
            thisDotKey.receiver = getBuilderReference(builderVariable);
            FieldReference thisDotValue = new FieldReference((String.valueOf(new String(data.getPluralName())) + "$value").toCharArray(), 0L);
            thisDotValue.receiver = getBuilderReference(builderVariable);
            Expression messageSend = new MessageSend();
            ((MessageSend) messageSend).receiver = thisDotKey;
            ((MessageSend) messageSend).arguments = new Expression[]{new SingleNameReference(iVar, 0L)};
            ((MessageSend) messageSend).selector = new char[]{'g', 'e', 't'};
            Expression messageSend2 = new MessageSend();
            ((MessageSend) messageSend2).receiver = thisDotValue;
            ((MessageSend) messageSend2).arguments = new Expression[]{new SingleNameReference(iVar, 0L)};
            ((MessageSend) messageSend2).selector = new char[]{'g', 'e', 't'};
            pluralnameDotPut.arguments = new Expression[]{messageSend, messageSend2};
            Statement localDeclaration = new LocalDeclaration(iVar, 0, 0);
            ((LocalDeclaration) localDeclaration).type = TypeReference.baseTypeReference(10, 0);
            ((LocalDeclaration) localDeclaration).initialization = EclipseHandlerUtil.makeIntLiteral(new char[]{'0'}, null);
            ifStatement = new ForStatement(new Statement[]{localDeclaration}, new BinaryExpression(new SingleNameReference(iVar, 0L), getSize(builderType, varName, nullGuard, builderVariable), 4), new Statement[]{new PostfixExpression(new SingleNameReference(iVar, 0L), IntLiteral.One, 14, 0)}, pluralnameDotPut, true, 0, 0);
        } else {
            ForStatement messageSend3 = new MessageSend();
            ((MessageSend) messageSend3).selector = new char[]{'a', 'd', 'd', 'A', 'l', 'l'};
            ((MessageSend) messageSend3).receiver = new SingleNameReference(data.getPluralName(), 0L);
            Expression fieldReference = new FieldReference(varName, 0L);
            ((FieldReference) fieldReference).receiver = getBuilderReference(builderVariable);
            ((MessageSend) messageSend3).arguments = new Expression[]{fieldReference};
            ifStatement = messageSend3;
        }
        if (nullGuard) {
            FieldReference thisDotField = new FieldReference(varName, 0L);
            thisDotField.receiver = getBuilderReference(builderVariable);
            ifStatement = new IfStatement(new EqualExpression(thisDotField, new NullLiteral(0, 0), 29), ifStatement, 0, 0);
        }
        Expression arg = new SingleNameReference(data.getPluralName(), 0L);
        MessageSend invoke = new MessageSend();
        invoke.arguments = new Expression[]{arg};
        invoke.selector = ("unmodifiable" + data.getTargetSimpleType()).toCharArray();
        invoke.receiver = new QualifiedNameReference(JAVA_UTIL_COLLECTIONS, NULL_POSS, 0, 0);
        Statement unmodifiableStat = new Assignment(new SingleNameReference(data.getPluralName(), 0L), invoke, 0);
        return Arrays.asList(assignment, ifStatement, unmodifiableStat);
    }

    protected Statement createConstructBuilderVarIfNeeded(EclipseSingularsRecipes.SingularData data, EclipseNode builderType, boolean mapMode) {
        char[] v1Name;
        char[] v2Name;
        Statement thenPart;
        if (mapMode) {
            String n = new String(data.getPluralName());
            v1Name = (String.valueOf(n) + "$key").toCharArray();
            v2Name = (String.valueOf(n) + "$value").toCharArray();
        } else {
            v1Name = data.getPluralName();
            v2Name = null;
        }
        FieldReference thisDotField = new FieldReference(v1Name, 0L);
        thisDotField.receiver = new ThisReference(0, 0);
        EqualExpression equalExpression = new EqualExpression(thisDotField, new NullLiteral(0, 0), 18);
        FieldReference thisDotField2 = new FieldReference(v1Name, 0L);
        thisDotField2.receiver = new ThisReference(0, 0);
        TypeReference v1Type = addTypeArgs(1, false, builderType, new QualifiedTypeReference(JAVA_UTIL_ARRAYLIST, NULL_POSS), data.getTypeArgs());
        AllocationExpression constructArrayList = new AllocationExpression();
        constructArrayList.type = v1Type;
        Statement assignment = new Assignment(thisDotField2, constructArrayList, 0);
        if (mapMode) {
            FieldReference thisDotField3 = new FieldReference(v2Name, 0L);
            thisDotField3.receiver = new ThisReference(0, 0);
            QualifiedTypeReference qualifiedTypeReference = new QualifiedTypeReference(JAVA_UTIL_ARRAYLIST, NULL_POSS);
            List<TypeReference> tArgs = data.getTypeArgs();
            TypeReference v2Type = addTypeArgs(1, false, builderType, qualifiedTypeReference, (tArgs == null || tArgs.size() <= 1) ? Collections.emptyList() : Collections.singletonList(tArgs.get(1)));
            AllocationExpression constructArrayList2 = new AllocationExpression();
            constructArrayList2.type = v2Type;
            Statement assignment2 = new Assignment(thisDotField3, constructArrayList2, 0);
            Statement block = new Block(0);
            ((Block) block).statements = new Statement[]{assignment, assignment2};
            thenPart = block;
        } else {
            thenPart = assignment;
        }
        return new IfStatement(equalExpression, thenPart, 0, 0);
    }
}
