package lombok.javac.handlers.singulars;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.util.Arrays;
import java.util.List;
import lombok.AccessLevel;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.javac.Javac;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.javac.handlers.JavacHandlerUtil;
import lombok.javac.handlers.JavacSingularsRecipes;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/singulars/JavacJavaUtilMapSingularizer.SCL.lombok */
public class JavacJavaUtilMapSingularizer extends JavacJavaUtilSingularizer {
    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public LombokImmutableList<String> getSupportedTypes() {
        return LombokImmutableList.of("java.util.Map", "java.util.SortedMap", "java.util.NavigableMap");
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected String getEmptyMaker(String target) {
        if (target.endsWith("NavigableMap")) {
            return "java.util.Collections.emptyNavigableMap";
        }
        return target.endsWith("SortedMap") ? "java.util.Collections.emptySortedMap" : "java.util.Collections.emptyMap";
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected JavacSingularsRecipes.JavacSingularizer getGuavaInstead(JavacNode node) {
        return new JavacGuavaMapSingularizer();
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public List<Name> listFieldsToBeGenerated(JavacSingularsRecipes.SingularData data, JavacNode builderType) {
        String p = data.getPluralName().toString();
        return Arrays.asList(builderType.toName(String.valueOf(p) + "$key"), builderType.toName(String.valueOf(p) + "$value"));
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public List<Name> listMethodsToBeGenerated(JavacSingularsRecipes.SingularData data, JavacNode builderType) {
        return super.listMethodsToBeGenerated(data, builderType);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public List<JavacNode> generateFields(JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source) {
        JavacTreeMaker maker = builderType.getTreeMaker();
        JCTree.JCExpression type = JavacHandlerUtil.chainDots(builderType, "java", "util", "ArrayList");
        JCTree.JCVariableDecl buildKeyField = maker.VarDef(maker.Modifiers(2L), builderType.toName(data.getPluralName() + "$key"), addTypeArgs(1, false, builderType, type, data.getTypeArgs(), source), null);
        JCTree.JCExpression type2 = JavacHandlerUtil.chainDots(builderType, "java", "util", "ArrayList");
        com.sun.tools.javac.util.List<JCTree.JCExpression> tArgs = data.getTypeArgs();
        JCTree.JCVariableDecl buildValueField = maker.VarDef(maker.Modifiers(2L), builderType.toName(data.getPluralName() + "$value"), addTypeArgs(1, false, builderType, type2, (tArgs == null || tArgs.size() <= 1) ? com.sun.tools.javac.util.List.nil() : tArgs.tail, source), null);
        JavacNode valueFieldNode = JavacHandlerUtil.injectFieldAndMarkGenerated(builderType, buildValueField);
        JavacNode keyFieldNode = JavacHandlerUtil.injectFieldAndMarkGenerated(builderType, buildKeyField);
        return Arrays.asList(keyFieldNode, valueFieldNode);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public void generateMethods(CheckerFrameworkVersion cfv, JavacSingularsRecipes.SingularData data, boolean deprecate, JavacNode builderType, JCTree source, boolean fluent, JavacSingularsRecipes.ExpressionMaker returnTypeMaker, JavacSingularsRecipes.StatementMaker returnStatementMaker, AccessLevel access) {
        doGenerateMethods(cfv, data, deprecate, builderType, source, fluent, returnTypeMaker, returnStatementMaker, access);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected JCTree.JCStatement generateClearStatements(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType) {
        com.sun.tools.javac.util.List<JCTree.JCExpression> jceBlank = com.sun.tools.javac.util.List.nil();
        JCTree.JCExpression thisDotKeyField = JavacHandlerUtil.chainDots(builderType, "this", data.getPluralName() + "$key", new String[0]);
        JCTree.JCExpression thisDotKeyFieldDotClear = JavacHandlerUtil.chainDots(builderType, "this", data.getPluralName() + "$key", "clear");
        JCTree.JCExpression thisDotValueFieldDotClear = JavacHandlerUtil.chainDots(builderType, "this", data.getPluralName() + "$value", "clear");
        JCTree.JCExpressionStatement jCExpressionStatementExec = maker.Exec(maker.Apply(jceBlank, thisDotKeyFieldDotClear, jceBlank));
        JCTree.JCExpressionStatement jCExpressionStatementExec2 = maker.Exec(maker.Apply(jceBlank, thisDotValueFieldDotClear, jceBlank));
        JCTree.JCBinary jCBinaryBinary = maker.Binary(Javac.CTC_NOT_EQUAL, thisDotKeyField, maker.Literal(Javac.CTC_BOT, null));
        JCTree.JCBlock clearCalls = maker.Block(0L, com.sun.tools.javac.util.List.of(jCExpressionStatementExec, jCExpressionStatementExec2));
        return maker.If(jCBinaryBinary, clearCalls, null);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected ListBuffer<JCTree.JCStatement> generateSingularMethodStatements(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source) {
        Name keyName = builderType.toName(String.valueOf(data.getSingularName().toString()) + "Key");
        Name valueName = builderType.toName(String.valueOf(data.getSingularName().toString()) + "Value");
        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
        statements.append(generateSingularMethodAddStatement(maker, builderType, keyName, data.getPluralName() + "$key"));
        statements.append(generateSingularMethodAddStatement(maker, builderType, valueName, data.getPluralName() + "$value"));
        return statements;
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected com.sun.tools.javac.util.List<JCTree.JCVariableDecl> generateSingularMethodParameters(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source) {
        Name keyName = builderType.toName(String.valueOf(data.getSingularName().toString()) + "Key");
        Name valueName = builderType.toName(String.valueOf(data.getSingularName().toString()) + "Value");
        JCTree.JCVariableDecl paramKey = generateSingularMethodParameter(0, maker, data, builderType, source, keyName);
        JCTree.JCVariableDecl paramValue = generateSingularMethodParameter(1, maker, data, builderType, source, valueName);
        return com.sun.tools.javac.util.List.of(paramKey, paramValue);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected ListBuffer<JCTree.JCStatement> generatePluralMethodStatements(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source) {
        com.sun.tools.javac.util.List<JCTree.JCExpression> jceBlank = com.sun.tools.javac.util.List.nil();
        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
        long baseFlags = JavacHandlerUtil.addFinalIfNeeded(0L, builderType.getContext());
        Name entryName = builderType.toName("$lombokEntry");
        JCTree.JCExpression forEachType = JavacHandlerUtil.chainDots(builderType, "java", "util", "Map", "Entry");
        JCTree.JCExpression forEachType2 = addTypeArgs(2, true, builderType, forEachType, data.getTypeArgs(), source);
        JCTree.JCBlock forEachBody = maker.Block(0L, com.sun.tools.javac.util.List.of(maker.Exec(maker.Apply(com.sun.tools.javac.util.List.nil(), JavacHandlerUtil.chainDots(builderType, "this", data.getPluralName() + "$key", "add"), com.sun.tools.javac.util.List.of(maker.Apply(com.sun.tools.javac.util.List.nil(), maker.Select(maker.Ident(entryName), builderType.toName("getKey")), com.sun.tools.javac.util.List.nil())))), maker.Exec(maker.Apply(com.sun.tools.javac.util.List.nil(), JavacHandlerUtil.chainDots(builderType, "this", data.getPluralName() + "$value", "add"), com.sun.tools.javac.util.List.of(maker.Apply(com.sun.tools.javac.util.List.nil(), maker.Select(maker.Ident(entryName), builderType.toName("getValue")), com.sun.tools.javac.util.List.nil()))))));
        statements.append(maker.ForeachLoop(maker.VarDef(maker.Modifiers(baseFlags), entryName, forEachType2, null), maker.Apply(jceBlank, maker.Select(maker.Ident(data.getPluralName()), builderType.toName("entrySet")), jceBlank), forEachBody));
        return statements;
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected JCTree.JCExpression getPluralMethodParamType(JavacNode builderType) {
        return JavacHandlerUtil.chainDots(builderType, "java", "util", "Map");
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected JCTree.JCStatement createConstructBuilderVarIfNeeded(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source) {
        return createConstructBuilderVarIfNeeded(maker, data, builderType, true, source);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public void appendBuildCode(JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source, ListBuffer<JCTree.JCStatement> statements, Name targetVariableName, String builderVariable) {
        JavacTreeMaker maker = builderType.getTreeMaker();
        if (data.getTargetFqn().equals("java.util.Map")) {
            statements.appendList(createJavaUtilSetMapInitialCapacitySwitchStatements(maker, data, builderType, true, "emptyMap", "singletonMap", "LinkedHashMap", source, builderVariable));
        } else {
            statements.appendList(createJavaUtilSimpleCreationAndFillStatements(maker, data, builderType, true, true, false, true, "TreeMap", source, builderVariable));
        }
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected String getAddMethodName() {
        return "put";
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    protected int getTypeArgumentsCount() {
        return 2;
    }
}
