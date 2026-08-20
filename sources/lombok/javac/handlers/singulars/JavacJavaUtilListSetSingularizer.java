package lombok.javac.handlers.singulars;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.util.Collections;
import java.util.List;
import lombok.AccessLevel;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.javac.Javac;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.javac.handlers.JavacHandlerUtil;
import lombok.javac.handlers.JavacSingularsRecipes;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/handlers/singulars/JavacJavaUtilListSetSingularizer.SCL.lombok */
abstract class JavacJavaUtilListSetSingularizer extends JavacJavaUtilSingularizer {
    JavacJavaUtilListSetSingularizer() {
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected JavacSingularsRecipes.JavacSingularizer getGuavaInstead(JavacNode node) {
        return new JavacGuavaSetListSingularizer();
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public List<Name> listFieldsToBeGenerated(JavacSingularsRecipes.SingularData data, JavacNode builderType) {
        return super.listFieldsToBeGenerated(data, builderType);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public List<Name> listMethodsToBeGenerated(JavacSingularsRecipes.SingularData data, JavacNode builderType) {
        return super.listMethodsToBeGenerated(data, builderType);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public List<JavacNode> generateFields(JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source) {
        JavacTreeMaker maker = builderType.getTreeMaker();
        JCTree.JCExpression type = JavacHandlerUtil.chainDots(builderType, "java", "util", "ArrayList");
        JCTree.JCVariableDecl buildField = maker.VarDef(maker.Modifiers(2L), data.getPluralName(), addTypeArgs(1, false, builderType, type, data.getTypeArgs(), source), null);
        return Collections.singletonList(JavacHandlerUtil.injectFieldAndMarkGenerated(builderType, buildField));
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public void generateMethods(CheckerFrameworkVersion cfv, JavacSingularsRecipes.SingularData data, boolean deprecate, JavacNode builderType, JCTree source, boolean fluent, JavacSingularsRecipes.ExpressionMaker returnTypeMaker, JavacSingularsRecipes.StatementMaker returnStatementMaker, AccessLevel access) {
        doGenerateMethods(cfv, data, deprecate, builderType, source, fluent, returnTypeMaker, returnStatementMaker, access);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected JCTree.JCStatement generateClearStatements(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType) {
        com.sun.tools.javac.util.List<JCTree.JCExpression> jceBlank = com.sun.tools.javac.util.List.nil();
        JCTree.JCFieldAccess jCFieldAccessSelect = maker.Select(maker.Ident(builderType.toName("this")), data.getPluralName());
        return maker.m10940If(maker.Binary(Javac.CTC_NOT_EQUAL, jCFieldAccessSelect, maker.Literal(Javac.CTC_BOT, null)), maker.Exec(maker.Apply(jceBlank, maker.Select(maker.Select(maker.Ident(builderType.toName("this")), data.getPluralName()), builderType.toName("clear")), jceBlank)), null);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected ListBuffer<JCTree.JCStatement> generateSingularMethodStatements(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source) {
        return new ListBuffer().append(generateSingularMethodAddStatement(maker, builderType, data.getSingularName(), data.getPluralName().toString()));
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected com.sun.tools.javac.util.List<JCTree.JCVariableDecl> generateSingularMethodParameters(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source) {
        JCTree.JCVariableDecl param = generateSingularMethodParameter(0, maker, data, builderType, source, data.getSingularName());
        return com.sun.tools.javac.util.List.of(param);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected JCTree.JCExpression getPluralMethodParamType(JavacNode builderType) {
        return JavacHandlerUtil.chainDots(builderType, "java", "util", "Collection");
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected JCTree.JCStatement createConstructBuilderVarIfNeeded(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source) {
        return createConstructBuilderVarIfNeeded(maker, data, builderType, false, source);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected String getAddMethodName() {
        return "add";
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected int getTypeArgumentsCount() {
        return 1;
    }
}
