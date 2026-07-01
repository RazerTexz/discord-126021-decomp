package lombok.javac.handlers;

import com.discord.api.permission.Permission;
import com.sun.source.tree.Tree$Kind;
import com.sun.tools.javac.code.BoundKind;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCBinary;
import com.sun.tools.javac.tree.JCTree$JCBlock;
import com.sun.tools.javac.tree.JCTree$JCConditional;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.tree.JCTree$JCMethodDecl;
import com.sun.tools.javac.tree.JCTree$JCMethodInvocation;
import com.sun.tools.javac.tree.JCTree$JCModifiers;
import com.sun.tools.javac.tree.JCTree$JCStatement;
import com.sun.tools.javac.tree.JCTree$JCTypeParameter;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import com.sun.tools.javac.tree.JCTree$JCWildcard;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import lombok.AccessLevel;
import lombok.core.AST$Kind;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.javac.Javac;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacSingularsRecipes$JavacSingularizer.SCL.lombok */
public abstract class JavacSingularsRecipes$JavacSingularizer {
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;

    public abstract LombokImmutableList<String> getSupportedTypes();

    public abstract List<JavacNode> generateFields(JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData, JavacNode javacNode, JCTree jCTree);

    public abstract void generateMethods(CheckerFrameworkVersion checkerFrameworkVersion, JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData, boolean z2, JavacNode javacNode, JCTree jCTree, boolean z3, JavacSingularsRecipes$ExpressionMaker javacSingularsRecipes$ExpressionMaker, JavacSingularsRecipes$StatementMaker javacSingularsRecipes$StatementMaker, AccessLevel accessLevel);

    protected abstract JCTree$JCStatement generateClearStatements(JavacTreeMaker javacTreeMaker, JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData, JavacNode javacNode);

    protected abstract ListBuffer<JCTree$JCStatement> generateSingularMethodStatements(JavacTreeMaker javacTreeMaker, JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData, JavacNode javacNode, JCTree jCTree);

    protected abstract com.sun.tools.javac.util.List<JCTree$JCVariableDecl> generateSingularMethodParameters(JavacTreeMaker javacTreeMaker, JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData, JavacNode javacNode, JCTree jCTree);

    protected abstract JCTree$JCExpression getPluralMethodParamType(JavacNode javacNode);

    protected abstract JCTree$JCStatement createConstructBuilderVarIfNeeded(JavacTreeMaker javacTreeMaker, JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData, JavacNode javacNode, JCTree jCTree);

    public abstract void appendBuildCode(JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData, JavacNode javacNode, JCTree jCTree, ListBuffer<JCTree$JCStatement> listBuffer, Name name, String str);

    protected abstract String getAddMethodName();

    protected abstract int getTypeArgumentsCount();

    protected abstract String getEmptyMaker(String str);

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind() {
        int[] iArr = $SWITCH_TABLE$lombok$core$AST$Kind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AST$Kind.valuesCustom().length];
        try {
            iArr2[AST$Kind.ANNOTATION.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[AST$Kind.ARGUMENT.ordinal()] = 7;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[AST$Kind.COMPILATION_UNIT.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[AST$Kind.FIELD.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[AST$Kind.INITIALIZER.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[AST$Kind.LOCAL.ordinal()] = 8;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[AST$Kind.METHOD.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[AST$Kind.STATEMENT.ordinal()] = 9;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[AST$Kind.TYPE.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[AST$Kind.TYPE_USE.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        $SWITCH_TABLE$lombok$core$AST$Kind = iArr2;
        return iArr2;
    }

    protected JavacSingularsRecipes$JavacSingularizer getGuavaInstead(JavacNode node) {
        return this;
    }

    protected JCTree$JCModifiers makeMods(JavacTreeMaker maker, CheckerFrameworkVersion cfv, JavacNode node, boolean deprecate, AccessLevel access, com.sun.tools.javac.util.List<JCTree$JCAnnotation> methodAnnotations) {
        com.sun.tools.javac.util.List<JCTree$JCAnnotation> listOf;
        JCTree$JCAnnotation deprecateAnn = deprecate ? maker.Annotation(JavacHandlerUtil.genJavaLangTypeRef(node, "Deprecated"), com.sun.tools.javac.util.List.nil()) : null;
        JCTree$JCAnnotation rrAnn = cfv.generateReturnsReceiver() ? maker.Annotation(JavacHandlerUtil.genTypeRef(node, CheckerFrameworkVersion.NAME__RETURNS_RECEIVER), com.sun.tools.javac.util.List.nil()) : null;
        if (deprecateAnn != null && rrAnn != null) {
            listOf = com.sun.tools.javac.util.List.of(deprecateAnn, rrAnn);
        } else if (deprecateAnn != null) {
            listOf = com.sun.tools.javac.util.List.of(deprecateAnn);
        } else {
            listOf = rrAnn != null ? com.sun.tools.javac.util.List.of(rrAnn) : com.sun.tools.javac.util.List.nil();
        }
        com.sun.tools.javac.util.List<JCTree$JCAnnotation> annsOnMethod = listOf;
        return maker.Modifiers(JavacHandlerUtil.toJavacModifier(access), JavacHandlerUtil.mergeAnnotations(annsOnMethod, methodAnnotations));
    }

    public boolean checkForAlreadyExistingNodesAndGenerateError(JavacNode builderType, JavacSingularsRecipes$SingularData data) {
        for (JavacNode child : builderType.down()) {
            switch ($SWITCH_TABLE$lombok$core$AST$Kind()[child.getKind().ordinal()]) {
                case 3:
                    JCTree$JCVariableDecl field = child.get();
                    Name name = field.name;
                    if (name != null && JavacHandlerUtil.getGeneratedBy(field) == null) {
                        for (Name fieldToBeGenerated : listFieldsToBeGenerated(data, builderType)) {
                            if (fieldToBeGenerated.equals(name)) {
                                child.addError("Manually adding a field that @Singular @Builder would generate is not supported. If you want to manually manage the builder aspect for this field/parameter, don't use @Singular.");
                                return true;
                            }
                        }
                    }
                    break;
                case 5:
                    JCTree$JCMethodDecl method = child.get();
                    Name name2 = method.name;
                    if (name2 != null && JavacHandlerUtil.getGeneratedBy(method) == null) {
                        for (Name methodToBeGenerated : listMethodsToBeGenerated(data, builderType)) {
                            if (methodToBeGenerated.equals(name2)) {
                                child.addError("Manually adding a method that @Singular @Builder would generate is not supported. If you want to manually manage the builder aspect for this field/parameter, don't use @Singular.");
                                return true;
                            }
                        }
                    }
                    break;
            }
        }
        return false;
    }

    public List<Name> listFieldsToBeGenerated(JavacSingularsRecipes$SingularData data, JavacNode builderType) {
        return Collections.singletonList(JavacSingularsRecipes$SingularData.access$0(data));
    }

    public List<Name> listMethodsToBeGenerated(JavacSingularsRecipes$SingularData data, JavacNode builderType) {
        Name p = JavacSingularsRecipes$SingularData.access$0(data);
        Name s2 = JavacSingularsRecipes$SingularData.access$1(data);
        return p.equals(s2) ? Collections.singletonList(p) : Arrays.asList(p, s2);
    }

    public void generateMethods(HandleBuilder$BuilderJob job, JavacSingularsRecipes$SingularData data, boolean deprecate) {
        JavacTreeMaker maker = job.builderType.getTreeMaker();
        JavacSingularsRecipes$ExpressionMaker returnTypeMaker = new JavacSingularsRecipes$JavacSingularizer$1(this, job, maker);
        JavacSingularsRecipes$StatementMaker returnStatementMaker = new JavacSingularsRecipes$JavacSingularizer$2(this, job, maker);
        generateMethods(job.checkerFramework, data, deprecate, job.builderType, job.source, job.oldFluent, returnTypeMaker, returnStatementMaker, job.accessInners);
    }

    protected void doGenerateMethods(CheckerFrameworkVersion cfv, JavacSingularsRecipes$SingularData data, boolean deprecate, JavacNode builderType, JCTree source, boolean fluent, JavacSingularsRecipes$ExpressionMaker returnTypeMaker, JavacSingularsRecipes$StatementMaker returnStatementMaker, AccessLevel access) {
        JavacTreeMaker maker = builderType.getTreeMaker();
        generateSingularMethod(cfv, deprecate, maker, returnTypeMaker.make(), returnStatementMaker.make(), data, builderType, source, fluent, access);
        generatePluralMethod(cfv, deprecate, maker, returnTypeMaker.make(), returnStatementMaker.make(), data, builderType, source, fluent, access);
        generateClearMethod(cfv, deprecate, maker, returnTypeMaker.make(), returnStatementMaker.make(), data, builderType, source, access);
    }

    private void finishAndInjectMethod(CheckerFrameworkVersion cfv, JavacTreeMaker maker, JCTree$JCExpression returnType, JCTree$JCStatement returnStatement, JavacSingularsRecipes$SingularData data, JavacNode builderType, JCTree source, boolean deprecate, ListBuffer<JCTree$JCStatement> statements, Name methodName, com.sun.tools.javac.util.List<JCTree$JCVariableDecl> jcVariableDecls, com.sun.tools.javac.util.List<JCTree$JCAnnotation> methodAnnotations, AccessLevel access, Boolean ignoreNullCollections) {
        if (returnStatement != null) {
            statements.append(returnStatement);
        }
        JCTree$JCBlock body = maker.Block(0L, statements.toList());
        JCTree$JCModifiers mods = makeMods(maker, cfv, builderType, deprecate, access, methodAnnotations);
        com.sun.tools.javac.util.List<JCTree$JCTypeParameter> typeParams = com.sun.tools.javac.util.List.nil();
        com.sun.tools.javac.util.List<JCTree$JCExpression> thrown = com.sun.tools.javac.util.List.nil();
        if (ignoreNullCollections != null) {
            if (ignoreNullCollections.booleanValue()) {
                for (JCTree$JCVariableDecl d : jcVariableDecls) {
                    JavacHandlerUtil.createRelevantNullableAnnotation(builderType, d);
                }
            } else {
                for (JCTree$JCVariableDecl d2 : jcVariableDecls) {
                    JavacHandlerUtil.createRelevantNonNullAnnotation(builderType, d2);
                }
            }
        }
        JCTree$JCMethodDecl method = maker.MethodDef(mods, methodName, returnType, typeParams, jcVariableDecls, thrown, body, null);
        JavacHandlerUtil.recursiveSetGeneratedBy(method, source, builderType.getContext());
        if (returnStatement != null) {
            JavacHandlerUtil.createRelevantNonNullAnnotation(builderType, method);
        }
        JavacHandlerUtil.injectMethod(builderType, method);
    }

    private void generateClearMethod(CheckerFrameworkVersion cfv, boolean deprecate, JavacTreeMaker maker, JCTree$JCExpression returnType, JCTree$JCStatement returnStatement, JavacSingularsRecipes$SingularData data, JavacNode builderType, JCTree source, AccessLevel access) {
        JCTree$JCStatement clearStatement = generateClearStatements(maker, data, builderType);
        ListBuffer<JCTree$JCStatement> statements = new ListBuffer<>();
        statements.add(clearStatement);
        Name methodName = builderType.toName(HandlerUtil.buildAccessorName("clear", data.getPluralName().toString()));
        finishAndInjectMethod(cfv, maker, returnType, returnStatement, data, builderType, source, deprecate, statements, methodName, com.sun.tools.javac.util.List.nil(), com.sun.tools.javac.util.List.nil(), access, null);
    }

    private void generateSingularMethod(CheckerFrameworkVersion cfv, boolean deprecate, JavacTreeMaker maker, JCTree$JCExpression returnType, JCTree$JCStatement returnStatement, JavacSingularsRecipes$SingularData data, JavacNode builderType, JCTree source, boolean fluent, AccessLevel access) {
        ListBuffer<JCTree$JCStatement> statements = generateSingularMethodStatements(maker, data, builderType, source);
        com.sun.tools.javac.util.List<JCTree$JCVariableDecl> params = generateSingularMethodParameters(maker, data, builderType, source);
        Name name = data.getSingularName();
        String setterPrefix = data.getSetterPrefix();
        if (setterPrefix.isEmpty() && !fluent) {
            setterPrefix = getAddMethodName();
        }
        if (!setterPrefix.isEmpty()) {
            name = builderType.toName(HandlerUtil.buildAccessorName(setterPrefix, name.toString()));
        }
        statements.prepend(createConstructBuilderVarIfNeeded(maker, data, builderType, source));
        com.sun.tools.javac.util.List<JCTree$JCAnnotation> methodAnnotations = JavacHandlerUtil.copyAnnotations(JavacHandlerUtil.findCopyableToBuilderSingularSetterAnnotations(JavacSingularsRecipes$SingularData.access$2(data).up()));
        finishAndInjectMethod(cfv, maker, returnType, returnStatement, data, builderType, source, deprecate, statements, name, params, methodAnnotations, access, null);
    }

    protected JCTree$JCVariableDecl generateSingularMethodParameter(int typeIndex, JavacTreeMaker maker, JavacSingularsRecipes$SingularData data, JavacNode builderType, JCTree source, Name name) {
        long flags = JavacHandlerUtil.addFinalIfNeeded(Permission.MANAGE_EVENTS, builderType.getContext());
        JCTree$JCExpression type = cloneParamType(typeIndex, maker, data.getTypeArgs(), builderType, source);
        com.sun.tools.javac.util.List<JCTree$JCAnnotation> typeUseAnns = JavacHandlerUtil.getTypeUseAnnotations(type);
        JCTree$JCExpression type2 = JavacHandlerUtil.removeTypeUseAnnotations(type);
        JCTree$JCModifiers mods = typeUseAnns.isEmpty() ? maker.Modifiers(flags) : maker.Modifiers(flags, typeUseAnns);
        return maker.VarDef(mods, name, type2, null);
    }

    protected JCTree$JCStatement generateSingularMethodAddStatement(JavacTreeMaker maker, JavacNode builderType, Name argumentName, String builderFieldName) {
        JCTree$JCExpression thisDotFieldDotAdd = JavacHandlerUtil.chainDots(builderType, "this", builderFieldName, "add");
        return maker.Exec(maker.Apply(com.sun.tools.javac.util.List.nil(), thisDotFieldDotAdd, com.sun.tools.javac.util.List.of(maker.Ident(argumentName))));
    }

    private void generatePluralMethod(CheckerFrameworkVersion cfv, boolean deprecate, JavacTreeMaker maker, JCTree$JCExpression returnType, JCTree$JCStatement returnStatement, JavacSingularsRecipes$SingularData data, JavacNode builderType, JCTree source, boolean fluent, AccessLevel access) {
        ListBuffer<JCTree$JCStatement> statements = generatePluralMethodStatements(maker, data, builderType, source);
        Name name = data.getPluralName();
        String setterPrefix = data.getSetterPrefix();
        if (setterPrefix.isEmpty() && !fluent) {
            setterPrefix = String.valueOf(getAddMethodName()) + "All";
        }
        if (!setterPrefix.isEmpty()) {
            name = builderType.toName(HandlerUtil.buildAccessorName(setterPrefix, name.toString()));
        }
        JCTree$JCExpression paramType = getPluralMethodParamType(builderType);
        JCTree$JCExpression paramType2 = addTypeArgs(getTypeArgumentsCount(), true, builderType, paramType, data.getTypeArgs(), source);
        long paramFlags = JavacHandlerUtil.addFinalIfNeeded(Permission.MANAGE_EVENTS, builderType.getContext());
        boolean ignoreNullCollections = data.isIgnoreNullCollections();
        JCTree$JCModifiers paramMods = maker.Modifiers(paramFlags);
        JCTree$JCVariableDecl param = maker.VarDef(paramMods, data.getPluralName(), paramType2, null);
        statements.prepend(createConstructBuilderVarIfNeeded(maker, data, builderType, source));
        if (ignoreNullCollections) {
            JCTree$JCBinary jCTree$JCBinaryBinary = maker.Binary(Javac.CTC_NOT_EQUAL, maker.Ident(data.getPluralName()), maker.Literal(Javac.CTC_BOT, null));
            JCTree$JCBlock jCTree$JCBlockBlock = maker.Block(0L, statements.toList());
            statements = new ListBuffer<>();
            statements.add(maker.If(jCTree$JCBinaryBinary, jCTree$JCBlockBlock, null));
        } else {
            statements.prepend(JavacHandlerUtil.generateNullCheck(maker, null, data.getPluralName(), builderType, "%s cannot be null"));
        }
        com.sun.tools.javac.util.List<JCTree$JCAnnotation> methodAnnotations = JavacHandlerUtil.copyAnnotations(JavacHandlerUtil.findCopyableToSetterAnnotations(JavacSingularsRecipes$SingularData.access$2(data).up()));
        finishAndInjectMethod(cfv, maker, returnType, returnStatement, data, builderType, source, deprecate, statements, name, com.sun.tools.javac.util.List.of(param), methodAnnotations, access, Boolean.valueOf(ignoreNullCollections));
    }

    protected ListBuffer<JCTree$JCStatement> generatePluralMethodStatements(JavacTreeMaker maker, JavacSingularsRecipes$SingularData data, JavacNode builderType, JCTree source) {
        ListBuffer<JCTree$JCStatement> statements = new ListBuffer<>();
        JCTree$JCExpression thisDotFieldDotAdd = JavacHandlerUtil.chainDots(builderType, "this", data.getPluralName().toString(), String.valueOf(getAddMethodName()) + "All");
        statements.append(maker.Exec(maker.Apply(com.sun.tools.javac.util.List.nil(), thisDotFieldDotAdd, com.sun.tools.javac.util.List.of(maker.Ident(data.getPluralName())))));
        return statements;
    }

    public boolean shadowedDuringBuild() {
        return true;
    }

    public boolean requiresCleaning() {
        try {
            return !getClass().getMethod("appendCleaningCode", JavacSingularsRecipes$SingularData.class, JavacNode.class, JCTree.class, ListBuffer.class).getDeclaringClass().equals(JavacSingularsRecipes$JavacSingularizer.class);
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    public void appendCleaningCode(JavacSingularsRecipes$SingularData data, JavacNode builderType, JCTree source, ListBuffer<JCTree$JCStatement> statements) {
    }

    protected JCTree$JCExpression addTypeArgs(int count, boolean addExtends, JavacNode node, JCTree$JCExpression type, com.sun.tools.javac.util.List<JCTree$JCExpression> typeArgs, JCTree source) {
        JavacTreeMaker maker = node.getTreeMaker();
        com.sun.tools.javac.util.List<JCTree$JCExpression> clonedAndFixedTypeArgs = createTypeArgs(count, addExtends, node, typeArgs, source);
        return maker.TypeApply(type, clonedAndFixedTypeArgs);
    }

    protected com.sun.tools.javac.util.List<JCTree$JCExpression> createTypeArgs(int count, boolean addExtends, JavacNode node, com.sun.tools.javac.util.List<JCTree$JCExpression> typeArgs, JCTree source) {
        JCTree$JCExpression inner;
        JavacTreeMaker maker = node.getTreeMaker();
        Context context = node.getContext();
        if (count < 0) {
            throw new IllegalArgumentException("count is negative");
        }
        if (count == 0) {
            return com.sun.tools.javac.util.List.nil();
        }
        ListBuffer<JCTree$JCExpression> arguments = new ListBuffer<>();
        if (typeArgs != null) {
            Iterator it = typeArgs.iterator();
            while (it.hasNext()) {
                JCTree$JCWildcard jCTree$JCWildcard = (JCTree$JCExpression) it.next();
                if (!addExtends) {
                    if (jCTree$JCWildcard.getKind() == Tree$Kind.UNBOUNDED_WILDCARD || jCTree$JCWildcard.getKind() == Tree$Kind.SUPER_WILDCARD) {
                        arguments.append(JavacHandlerUtil.genJavaLangTypeRef(node, "Object"));
                    } else if (jCTree$JCWildcard.getKind() == Tree$Kind.EXTENDS_WILDCARD) {
                        try {
                            inner = (JCTree$JCExpression) jCTree$JCWildcard.inner;
                        } catch (Exception unused) {
                            inner = JavacHandlerUtil.genJavaLangTypeRef(node, "Object");
                        }
                        arguments.append(JavacHandlerUtil.cloneType(maker, inner, source, context));
                    } else {
                        arguments.append(JavacHandlerUtil.cloneType(maker, jCTree$JCWildcard, source, context));
                    }
                } else if (jCTree$JCWildcard.getKind() == Tree$Kind.UNBOUNDED_WILDCARD || jCTree$JCWildcard.getKind() == Tree$Kind.SUPER_WILDCARD) {
                    arguments.append(maker.Wildcard(maker.TypeBoundKind(BoundKind.UNBOUND), null));
                } else if (jCTree$JCWildcard.getKind() == Tree$Kind.EXTENDS_WILDCARD) {
                    arguments.append(JavacHandlerUtil.cloneType(maker, jCTree$JCWildcard, source, context));
                } else {
                    arguments.append(maker.Wildcard(maker.TypeBoundKind(BoundKind.EXTENDS), JavacHandlerUtil.cloneType(maker, jCTree$JCWildcard, source, context)));
                }
                count--;
                if (count == 0) {
                    break;
                }
            }
        }
        while (true) {
            int i = count;
            count--;
            if (i > 0) {
                if (addExtends) {
                    arguments.append(maker.Wildcard(maker.TypeBoundKind(BoundKind.UNBOUND), null));
                } else {
                    arguments.append(JavacHandlerUtil.genJavaLangTypeRef(node, "Object"));
                }
            } else {
                return arguments.toList();
            }
        }
    }

    protected JCTree$JCExpression getSize(JavacTreeMaker maker, JavacNode builderType, Name name, boolean nullGuard, boolean parens, String builderVariable) {
        Name thisName = builderType.toName(builderVariable);
        JCTree$JCMethodInvocation jCTree$JCMethodInvocationApply = maker.Apply(com.sun.tools.javac.util.List.nil(), maker.Select(maker.Select(maker.Ident(thisName), name), builderType.toName("size")), com.sun.tools.javac.util.List.nil());
        if (nullGuard) {
            JCTree$JCConditional jCTree$JCConditionalConditional = maker.Conditional(maker.Binary(Javac.CTC_EQUAL, maker.Select(maker.Ident(thisName), name), maker.Literal(Javac.CTC_BOT, 0)), maker.Literal(Javac.CTC_INT, 0), jCTree$JCMethodInvocationApply);
            return parens ? maker.Parens(jCTree$JCConditionalConditional) : jCTree$JCConditionalConditional;
        }
        return jCTree$JCMethodInvocationApply;
    }

    protected JCTree$JCExpression cloneParamType(int index, JavacTreeMaker maker, com.sun.tools.javac.util.List<JCTree$JCExpression> typeArgs, JavacNode builderType, JCTree source) {
        if (typeArgs == null || typeArgs.size() <= index) {
            return JavacHandlerUtil.genJavaLangTypeRef(builderType, "Object");
        }
        JCTree$JCWildcard jCTree$JCWildcard = (JCTree$JCExpression) typeArgs.get(index);
        if (jCTree$JCWildcard.getKind() == Tree$Kind.UNBOUNDED_WILDCARD || jCTree$JCWildcard.getKind() == Tree$Kind.SUPER_WILDCARD) {
            return JavacHandlerUtil.genJavaLangTypeRef(builderType, "Object");
        }
        if (jCTree$JCWildcard.getKind() == Tree$Kind.EXTENDS_WILDCARD) {
            try {
                return JavacHandlerUtil.cloneType(maker, jCTree$JCWildcard.inner, source, builderType.getContext());
            } catch (Exception unused) {
                return JavacHandlerUtil.genJavaLangTypeRef(builderType, "Object");
            }
        }
        return JavacHandlerUtil.cloneType(maker, jCTree$JCWildcard, source, builderType.getContext());
    }
}
