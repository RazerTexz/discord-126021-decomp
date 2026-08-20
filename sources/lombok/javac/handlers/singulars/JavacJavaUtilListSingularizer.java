package lombok.javac.handlers.singulars;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.util.List;
import lombok.AccessLevel;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.javac.Javac;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.javac.handlers.JavacHandlerUtil;
import lombok.javac.handlers.JavacSingularsRecipes;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/handlers/singulars/JavacJavaUtilListSingularizer.SCL.lombok */
public class JavacJavaUtilListSingularizer extends JavacJavaUtilListSetSingularizer {
    @Override // lombok.javac.handlers.singulars.JavacJavaUtilListSetSingularizer, lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public /* bridge */ /* synthetic */ List generateFields(JavacSingularsRecipes.SingularData singularData, JavacNode javacNode, JCTree jCTree) {
        return super.generateFields(singularData, javacNode, jCTree);
    }

    @Override // lombok.javac.handlers.singulars.JavacJavaUtilListSetSingularizer, lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public /* bridge */ /* synthetic */ void generateMethods(CheckerFrameworkVersion checkerFrameworkVersion, JavacSingularsRecipes.SingularData singularData, boolean z2, JavacNode javacNode, JCTree jCTree, boolean z3, JavacSingularsRecipes.ExpressionMaker expressionMaker, JavacSingularsRecipes.StatementMaker statementMaker, AccessLevel accessLevel) {
        super.generateMethods(checkerFrameworkVersion, singularData, z2, javacNode, jCTree, z3, expressionMaker, statementMaker, accessLevel);
    }

    @Override // lombok.javac.handlers.singulars.JavacJavaUtilListSetSingularizer, lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public /* bridge */ /* synthetic */ List listFieldsToBeGenerated(JavacSingularsRecipes.SingularData singularData, JavacNode javacNode) {
        return super.listFieldsToBeGenerated(singularData, javacNode);
    }

    @Override // lombok.javac.handlers.singulars.JavacJavaUtilListSetSingularizer, lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public /* bridge */ /* synthetic */ List listMethodsToBeGenerated(JavacSingularsRecipes.SingularData singularData, JavacNode javacNode) {
        return super.listMethodsToBeGenerated(singularData, javacNode);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public LombokImmutableList<String> getSupportedTypes() {
        return LombokImmutableList.m10921of("java.util.List", "java.util.Collection", "java.lang.Iterable");
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected String getEmptyMaker(String target) {
        return "java.util.Collections.emptyList";
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public void appendBuildCode(JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source, ListBuffer<JCTree.JCStatement> statements, Name targetVariableName, String builderVariable) {
        JavacTreeMaker maker = builderType.getTreeMaker();
        com.sun.tools.javac.util.List<JCTree.JCExpression> jceBlank = com.sun.tools.javac.util.List.nil();
        ListBuffer<JCTree.JCCase> cases = new ListBuffer<>();
        JCTree.JCCase emptyCase = maker.Case(maker.Literal(Javac.CTC_INT, 0), com.sun.tools.javac.util.List.of(maker.Exec(maker.Assign(maker.Ident(data.getPluralName()), maker.Apply(jceBlank, JavacHandlerUtil.chainDots(builderType, "java", "util", "Collections", "emptyList"), jceBlank))), maker.Break(null)));
        cases.append(emptyCase);
        com.sun.tools.javac.util.List<JCTree.JCExpression> args = com.sun.tools.javac.util.List.of(maker.Apply(jceBlank, JavacHandlerUtil.chainDots(builderType, builderVariable, data.getPluralName().toString(), "get"), com.sun.tools.javac.util.List.of(maker.Literal(Javac.CTC_INT, 0))));
        JCTree.JCCase singletonCase = maker.Case(maker.Literal(Javac.CTC_INT, 1), com.sun.tools.javac.util.List.of(maker.Exec(maker.Assign(maker.Ident(data.getPluralName()), maker.Apply(jceBlank, JavacHandlerUtil.chainDots(builderType, "java", "util", "Collections", "singletonList"), args))), maker.Break(null)));
        cases.append(singletonCase);
        com.sun.tools.javac.util.List<JCTree.JCStatement> defStats = createListCopy(maker, data, builderType, source, builderVariable);
        JCTree.JCCase defaultCase = maker.Case(null, defStats);
        cases.append(defaultCase);
        JCTree.JCSwitch jCSwitchSwitch = maker.Switch(getSize(maker, builderType, data.getPluralName(), true, false, builderVariable), cases.toList());
        JCTree.JCExpression localShadowerType = JavacHandlerUtil.chainDotsString(builderType, data.getTargetFqn());
        statements.append(maker.VarDef(maker.Modifiers(0L), data.getPluralName(), addTypeArgs(1, false, builderType, localShadowerType, data.getTypeArgs(), source), null));
        statements.append(jCSwitchSwitch);
    }

    private com.sun.tools.javac.util.List<JCTree.JCStatement> createListCopy(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source, String builderVariable) {
        com.sun.tools.javac.util.List<JCTree.JCExpression> jceBlank = com.sun.tools.javac.util.List.nil();
        Name thisName = builderType.toName(builderVariable);
        com.sun.tools.javac.util.List.nil();
        com.sun.tools.javac.util.List<JCTree.JCExpression> constructorArgs = com.sun.tools.javac.util.List.of(maker.Select(maker.Ident(thisName), data.getPluralName()));
        JCTree.JCExpression targetTypeExpr = JavacHandlerUtil.chainDots(builderType, "java", "util", "ArrayList");
        return com.sun.tools.javac.util.List.of(maker.Exec(maker.Assign(maker.Ident(data.getPluralName()), maker.Apply(jceBlank, JavacHandlerUtil.chainDots(builderType, "java", "util", "Collections", "unmodifiableList"), com.sun.tools.javac.util.List.of(maker.NewClass(null, jceBlank, addTypeArgs(1, false, builderType, targetTypeExpr, data.getTypeArgs(), source), constructorArgs, null))))));
    }
}
