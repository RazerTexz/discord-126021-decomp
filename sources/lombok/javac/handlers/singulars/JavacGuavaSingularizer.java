package lombok.javac.handlers.singulars;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.util.Collections;
import java.util.List;
import lombok.AccessLevel;
import lombok.core.GuavaTypeMap;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.javac.Javac;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.javac.handlers.JavacHandlerUtil;
import lombok.javac.handlers.JavacSingularsRecipes;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/handlers/singulars/JavacGuavaSingularizer.SCL.lombok */
abstract class JavacGuavaSingularizer extends JavacSingularsRecipes.JavacSingularizer {
    protected abstract LombokImmutableList<String> getArgumentSuffixes();

    protected abstract String getAddAllTypeName();

    JavacGuavaSingularizer() {
    }

    protected String getSimpleTargetTypeName(JavacSingularsRecipes.SingularData data) {
        return GuavaTypeMap.getGuavaTypeName(data.getTargetFqn());
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected String getEmptyMaker(String target) {
        return String.valueOf(target) + ".of";
    }

    protected String getBuilderMethodName(JavacSingularsRecipes.SingularData data) {
        String simpleTypeName = getSimpleTargetTypeName(data);
        return ("ImmutableSortedSet".equals(simpleTypeName) || "ImmutableSortedMap".equals(simpleTypeName)) ? "naturalOrder" : "builder";
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public List<JavacNode> generateFields(JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source) {
        JavacTreeMaker maker = builderType.getTreeMaker();
        String simpleTypeName = getSimpleTargetTypeName(data);
        JCTree.JCExpression type = JavacHandlerUtil.chainDots(builderType, "com", "google", "common", "collect", simpleTypeName, "Builder");
        JCTree.JCVariableDecl buildField = maker.VarDef(maker.Modifiers(2L), data.getPluralName(), addTypeArgs(getTypeArgumentsCount(), false, builderType, type, data.getTypeArgs(), source), null);
        return Collections.singletonList(JavacHandlerUtil.injectFieldAndMarkGenerated(builderType, buildField));
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public void generateMethods(CheckerFrameworkVersion cfv, JavacSingularsRecipes.SingularData data, boolean deprecate, JavacNode builderType, JCTree source, boolean fluent, JavacSingularsRecipes.ExpressionMaker returnTypeMaker, JavacSingularsRecipes.StatementMaker returnStatementMaker, AccessLevel access) {
        doGenerateMethods(cfv, data, deprecate, builderType, source, fluent, returnTypeMaker, returnStatementMaker, access);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected JCTree.JCStatement generateClearStatements(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType) {
        return maker.Exec(maker.Assign(maker.Select(maker.Ident(builderType.toName("this")), data.getPluralName()), maker.Literal(Javac.CTC_BOT, null)));
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected com.sun.tools.javac.util.List<JCTree.JCVariableDecl> generateSingularMethodParameters(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source) {
        Name[] names = generateSingularMethodParameterNames(data, builderType);
        ListBuffer<JCTree.JCVariableDecl> params = new ListBuffer<>();
        for (int i = 0; i < names.length; i++) {
            params.append(generateSingularMethodParameter(i, maker, data, builderType, source, names[i]));
        }
        return params.toList();
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected ListBuffer<JCTree.JCStatement> generateSingularMethodStatements(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source) {
        Name[] names = generateSingularMethodParameterNames(data, builderType);
        JCTree.JCExpression thisDotFieldDotAdd = JavacHandlerUtil.chainDots(builderType, "this", data.getPluralName().toString(), getAddMethodName());
        ListBuffer<JCTree.JCExpression> invokeAddExprBuilder = new ListBuffer<>();
        for (Name name : names) {
            invokeAddExprBuilder.append(maker.Ident(name));
        }
        com.sun.tools.javac.util.List<JCTree.JCExpression> invokeAddExpr = invokeAddExprBuilder.toList();
        return new ListBuffer().append(maker.Exec(maker.Apply(com.sun.tools.javac.util.List.nil(), thisDotFieldDotAdd, invokeAddExpr)));
    }

    private Name[] generateSingularMethodParameterNames(JavacSingularsRecipes.SingularData data, JavacNode builderType) {
        LombokImmutableList<String> suffixes = getArgumentSuffixes();
        Name[] names = new Name[suffixes.size()];
        for (int i = 0; i < names.length; i++) {
            String s2 = suffixes.get(i);
            Name n = data.getSingularName();
            names[i] = s2.isEmpty() ? n : builderType.toName(s2);
        }
        return names;
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected JCTree.JCExpression getPluralMethodParamType(JavacNode builderType) {
        return JavacHandlerUtil.genTypeRef(builderType, getAddAllTypeName());
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public void appendBuildCode(JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source, ListBuffer<JCTree.JCStatement> statements, Name targetVariableName, String builderVariable) {
        JavacTreeMaker maker = builderType.getTreeMaker();
        com.sun.tools.javac.util.List<JCTree.JCExpression> jceBlank = com.sun.tools.javac.util.List.nil();
        JCTree.JCExpression varType = JavacHandlerUtil.chainDotsString(builderType, data.getTargetFqn());
        int argumentsCount = getTypeArgumentsCount();
        JCTree.JCExpression varType2 = addTypeArgs(argumentsCount, false, builderType, varType, data.getTypeArgs(), source);
        JCTree.JCExpression emptyMethod = JavacHandlerUtil.chainDots(builderType, "com", "google", "common", "collect", getSimpleTargetTypeName(data), "of");
        com.sun.tools.javac.util.List<JCTree.JCExpression> invokeTypeArgs = createTypeArgs(argumentsCount, false, builderType, data.getTypeArgs(), source);
        statements.append(maker.VarDef(maker.Modifiers(0L), data.getPluralName(), varType2, maker.Conditional(maker.Binary(Javac.CTC_EQUAL, maker.Select(maker.Ident(builderType.toName(builderVariable)), data.getPluralName()), maker.Literal(Javac.CTC_BOT, null)), maker.Apply(invokeTypeArgs, emptyMethod, jceBlank), maker.Apply(jceBlank, JavacHandlerUtil.chainDots(builderType, builderVariable, data.getPluralName().toString(), "build"), jceBlank))));
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected JCTree.JCStatement createConstructBuilderVarIfNeeded(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source) {
        com.sun.tools.javac.util.List<JCTree.JCExpression> jceBlank = com.sun.tools.javac.util.List.nil();
        return maker.m10940If(maker.Binary(Javac.CTC_EQUAL, maker.Select(maker.Ident(builderType.toName("this")), data.getPluralName()), maker.Literal(Javac.CTC_BOT, null)), maker.Exec(maker.Assign(maker.Select(maker.Ident(builderType.toName("this")), data.getPluralName()), maker.Apply(jceBlank, JavacHandlerUtil.chainDots(builderType, "com", "google", "common", "collect", getSimpleTargetTypeName(data), getBuilderMethodName(data)), jceBlank))), null);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected int getTypeArgumentsCount() {
        return getArgumentSuffixes().size();
    }
}
