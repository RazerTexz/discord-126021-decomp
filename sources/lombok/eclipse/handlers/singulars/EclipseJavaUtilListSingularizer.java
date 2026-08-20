package lombok.eclipse.handlers.singulars;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.eclipse.Eclipse;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.eclipse.handlers.EclipseSingularsRecipes;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.BreakStatement;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.SwitchStatement;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/handlers/singulars/EclipseJavaUtilListSingularizer.SCL.lombok */
public class EclipseJavaUtilListSingularizer extends EclipseJavaUtilListSetSingularizer {
    private static final char[] EMPTY_LIST = {'e', 'm', 'p', 't', 'y', 'L', 'i', 's', 't'};

    @Override // lombok.eclipse.handlers.singulars.EclipseJavaUtilListSetSingularizer, lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public /* bridge */ /* synthetic */ List generateFields(EclipseSingularsRecipes.SingularData singularData, EclipseNode eclipseNode) {
        return super.generateFields(singularData, eclipseNode);
    }

    @Override // lombok.eclipse.handlers.singulars.EclipseJavaUtilListSetSingularizer, lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public /* bridge */ /* synthetic */ void generateMethods(CheckerFrameworkVersion checkerFrameworkVersion, EclipseSingularsRecipes.SingularData singularData, boolean z2, EclipseNode eclipseNode, boolean z3, EclipseSingularsRecipes.TypeReferenceMaker typeReferenceMaker, EclipseSingularsRecipes.StatementMaker statementMaker, AccessLevel accessLevel) {
        super.generateMethods(checkerFrameworkVersion, singularData, z2, eclipseNode, z3, typeReferenceMaker, statementMaker, accessLevel);
    }

    @Override // lombok.eclipse.handlers.singulars.EclipseJavaUtilListSetSingularizer, lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public /* bridge */ /* synthetic */ List listFieldsToBeGenerated(EclipseSingularsRecipes.SingularData singularData, EclipseNode eclipseNode) {
        return super.listFieldsToBeGenerated(singularData, eclipseNode);
    }

    @Override // lombok.eclipse.handlers.singulars.EclipseJavaUtilListSetSingularizer, lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public /* bridge */ /* synthetic */ List listMethodsToBeGenerated(EclipseSingularsRecipes.SingularData singularData, EclipseNode eclipseNode) {
        return super.listMethodsToBeGenerated(singularData, eclipseNode);
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public LombokImmutableList<String> getSupportedTypes() {
        return LombokImmutableList.m10921of("java.util.List", "java.util.Collection", "java.lang.Iterable");
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    protected char[][] getEmptyMakerReceiver(String targetFqn) {
        return JAVA_UTIL_COLLECTIONS;
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    protected char[] getEmptyMakerSelector(String targetFqn) {
        return EMPTY_LIST;
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public void appendBuildCode(EclipseSingularsRecipes.SingularData data, EclipseNode builderType, List<Statement> statements, char[] targetVariableName, String builderVariable) {
        if (useGuavaInstead(builderType)) {
            this.guavaListSetSingularizer.appendBuildCode(data, builderType, statements, targetVariableName, builderVariable);
            return;
        }
        List<Statement> switchContents = new ArrayList<>();
        switchContents.add(Eclipse.createCaseStatement(EclipseHandlerUtil.makeIntLiteral(new char[]{'0'}, null)));
        MessageSend invoke = new MessageSend();
        invoke.receiver = new QualifiedNameReference(JAVA_UTIL_COLLECTIONS, NULL_POSS, 0, 0);
        invoke.selector = "emptyList".toCharArray();
        switchContents.add(new Assignment(new SingleNameReference(data.getPluralName(), 0L), invoke, 0));
        switchContents.add(new BreakStatement((char[]) null, 0, 0));
        switchContents.add(Eclipse.createCaseStatement(EclipseHandlerUtil.makeIntLiteral(new char[]{'1'}, null)));
        FieldReference thisDotField = new FieldReference(data.getPluralName(), 0L);
        thisDotField.receiver = getBuilderReference(builderVariable);
        Expression messageSend = new MessageSend();
        ((MessageSend) messageSend).receiver = thisDotField;
        ((MessageSend) messageSend).selector = new char[]{'g', 'e', 't'};
        ((MessageSend) messageSend).arguments = new Expression[]{EclipseHandlerUtil.makeIntLiteral(new char[]{'0'}, null)};
        Expression[] args = {messageSend};
        MessageSend invoke2 = new MessageSend();
        invoke2.receiver = new QualifiedNameReference(JAVA_UTIL_COLLECTIONS, NULL_POSS, 0, 0);
        invoke2.selector = "singletonList".toCharArray();
        invoke2.arguments = args;
        switchContents.add(new Assignment(new SingleNameReference(data.getPluralName(), 0L), invoke2, 0));
        switchContents.add(new BreakStatement((char[]) null, 0, 0));
        switchContents.add(Eclipse.createCaseStatement(null));
        Expression fieldReference = new FieldReference(data.getPluralName(), 0L);
        ((FieldReference) fieldReference).receiver = getBuilderReference(builderVariable);
        TypeReference targetTypeExpr = addTypeArgs(1, false, builderType, new QualifiedTypeReference(JAVA_UTIL_ARRAYLIST, NULL_POSS), data.getTypeArgs());
        Expression allocationExpression = new AllocationExpression();
        ((AllocationExpression) allocationExpression).type = targetTypeExpr;
        ((AllocationExpression) allocationExpression).arguments = new Expression[]{fieldReference};
        MessageSend unmodInvoke = new MessageSend();
        unmodInvoke.receiver = new QualifiedNameReference(JAVA_UTIL_COLLECTIONS, NULL_POSS, 0, 0);
        unmodInvoke.selector = "unmodifiableList".toCharArray();
        unmodInvoke.arguments = new Expression[]{allocationExpression};
        switchContents.add(new Assignment(new SingleNameReference(data.getPluralName(), 0L), unmodInvoke, 0));
        SwitchStatement switchStat = new SwitchStatement();
        switchStat.statements = (Statement[]) switchContents.toArray(new Statement[0]);
        switchStat.expression = getSize(builderType, data.getPluralName(), true, builderVariable);
        TypeReference localShadowerType = addTypeArgs(1, false, builderType, new QualifiedTypeReference(Eclipse.fromQualifiedName(data.getTargetFqn()), NULL_POSS), data.getTypeArgs());
        LocalDeclaration varDefStat = new LocalDeclaration(data.getPluralName(), 0, 0);
        varDefStat.type = localShadowerType;
        statements.add(varDefStat);
        statements.add(switchStat);
    }
}
