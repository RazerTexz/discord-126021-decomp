package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCBinary;
import com.sun.tools.javac.tree.JCTree$JCBlock;
import com.sun.tools.javac.tree.JCTree$JCClassDecl;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.tree.JCTree$JCExpressionStatement;
import com.sun.tools.javac.tree.JCTree$JCIf;
import com.sun.tools.javac.tree.JCTree$JCMethodDecl;
import com.sun.tools.javac.tree.JCTree$JCMethodInvocation;
import com.sun.tools.javac.tree.JCTree$JCPrimitiveTypeTree;
import com.sun.tools.javac.tree.JCTree$JCStatement;
import com.sun.tools.javac.tree.JCTree$JCSynchronized;
import com.sun.tools.javac.tree.JCTree$JCTypeParameter;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import com.sun.tools.javac.util.JCDiagnostic$DiagnosticPosition;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.Getter;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.HandlerUtil$FieldAccess;
import lombok.delombok.LombokOptionsFactory;
import lombok.experimental.Delegate;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.javac.JavacTreeMaker$TypeTag;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleGetter.SCL.lombok */
public class HandleGetter extends JavacAnnotationHandler<Getter> {
    private static final String AR = "java.util.concurrent.atomic.AtomicReference";
    private static final List<JCTree$JCExpression> NIL_EXPRESSION = List.nil();
    public static final Map<JavacTreeMaker$TypeTag, String> TYPE_MAP;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult;

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

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult() {
        int[] iArr = $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[JavacHandlerUtil$MemberExistsResult.valuesCustom().length];
        try {
            iArr2[JavacHandlerUtil$MemberExistsResult.EXISTS_BY_LOMBOK.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[JavacHandlerUtil$MemberExistsResult.EXISTS_BY_USER.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[JavacHandlerUtil$MemberExistsResult.NOT_EXISTS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult = iArr2;
        return iArr2;
    }

    public void generateGetterForType(JavacNode typeNode, JavacNode errorNode, AccessLevel level, boolean checkForTypeLevelGetter, List<JCTree$JCAnnotation> onMethod) {
        if (checkForTypeLevelGetter && JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) Getter.class, typeNode)) {
            return;
        }
        JCTree$JCClassDecl typeDecl = typeNode.get() instanceof JCTree$JCClassDecl ? (JCTree$JCClassDecl) typeNode.get() : null;
        long modifiers = typeDecl == null ? 0L : typeDecl.mods.flags;
        boolean notAClass = (modifiers & 8704) != 0;
        if (typeDecl == null || notAClass) {
            errorNode.addError("@Getter is only supported on a class, an enum, or a field.");
            return;
        }
        for (JavacNode field : typeNode.down()) {
            if (fieldQualifiesForGetterGeneration(field)) {
                generateGetterForField(field, (JCDiagnostic$DiagnosticPosition) errorNode.get(), level, false, onMethod);
            }
        }
    }

    public static boolean fieldQualifiesForGetterGeneration(JavacNode field) {
        if (field.getKind() != AST$Kind.FIELD) {
            return false;
        }
        JCTree$JCVariableDecl fieldDecl = field.get();
        return !fieldDecl.name.toString().startsWith("$") && (fieldDecl.mods.flags & 8) == 0;
    }

    public void generateGetterForField(JavacNode fieldNode, JCDiagnostic$DiagnosticPosition pos, AccessLevel level, boolean lazy, List<JCTree$JCAnnotation> onMethod) {
        if (JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) Getter.class, fieldNode)) {
            return;
        }
        createGetterForField(level, fieldNode, fieldNode, false, lazy, onMethod);
    }

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Getter> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.GETTER_FLAG_USAGE, "@Getter");
        Collection<JavacNode> fields = annotationNode.upFromAnnotationToFields();
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) Getter.class);
        JavacHandlerUtil.deleteImportFromCompilationUnit(annotationNode, "lombok.AccessLevel");
        JavacNode node = annotationNode.up();
        Getter annotationInstance = annotation.getInstance();
        AccessLevel level = annotationInstance.value();
        boolean lazy = annotationInstance.lazy();
        if (lazy) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.GETTER_LAZY_FLAG_USAGE, "@Getter(lazy=true)");
        }
        if (level == AccessLevel.NONE) {
            if (lazy) {
                annotationNode.addWarning("'lazy' does not work with AccessLevel.NONE.");
            }
        } else {
            if (node == null) {
                return;
            }
            List<JCTree$JCAnnotation> onMethod = JavacHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onMethod", "@Getter(onMethod", annotationNode);
            switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
                case 2:
                    if (lazy) {
                        annotationNode.addError("'lazy' is not supported for @Getter on a type.");
                    }
                    generateGetterForType(node, annotationNode, level, false, onMethod);
                    break;
                case 3:
                    createGetterForFields(level, fields, annotationNode, true, lazy, onMethod);
                    break;
            }
        }
    }

    public void createGetterForFields(AccessLevel level, Collection<JavacNode> fieldNodes, JavacNode errorNode, boolean whineIfExists, boolean lazy, List<JCTree$JCAnnotation> onMethod) {
        for (JavacNode fieldNode : fieldNodes) {
            createGetterForField(level, fieldNode, errorNode, whineIfExists, lazy, onMethod);
        }
    }

    public void createGetterForField(AccessLevel level, JavacNode fieldNode, JavacNode source, boolean whineIfExists, boolean lazy, List<JCTree$JCAnnotation> onMethod) {
        if (fieldNode.getKind() != AST$Kind.FIELD) {
            source.addError("@Getter is only supported on a class or a field.");
            return;
        }
        JCTree$JCVariableDecl fieldDecl = fieldNode.get();
        if (lazy) {
            if ((fieldDecl.mods.flags & 2) == 0 || (fieldDecl.mods.flags & 16) == 0) {
                source.addError("'lazy' requires the field to be private and final.");
                return;
            } else if ((fieldDecl.mods.flags & 128) != 0) {
                source.addError("'lazy' is not supported on transient fields.");
                return;
            } else if (fieldDecl.init == null) {
                source.addError("'lazy' requires field initialization.");
                return;
            }
        }
        String methodName = JavacHandlerUtil.toGetterName(fieldNode);
        if (methodName == null) {
            source.addWarning("Not generating getter for this field: It does not fit your @Accessors prefix list.");
            return;
        }
        for (String altName : JavacHandlerUtil.toAllGetterNames(fieldNode)) {
            switch ($SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult()[JavacHandlerUtil.methodExists(altName, fieldNode, false, 0).ordinal()]) {
                case 1:
                default:
                    break;
                case 2:
                    return;
                case 3:
                    if (whineIfExists) {
                        String altNameExpl = altName.equals(methodName) ? "" : String.format(" (%s)", altName);
                        source.addWarning(String.format("Not generating %s(): A method with that name already exists%s", methodName, altNameExpl));
                        return;
                    }
                    return;
            }
        }
        long access = ((long) JavacHandlerUtil.toJavacModifier(level)) | (fieldDecl.mods.flags & 8);
        JavacHandlerUtil.injectMethod(fieldNode.up(), createGetter(access, fieldNode, fieldNode.getTreeMaker(), source.get(), lazy, onMethod), List.nil(), JavacHandlerUtil.getMirrorForFieldType(fieldNode));
    }

    public JCTree$JCMethodDecl createGetter(long access, JavacNode field, JavacTreeMaker treeMaker, JCTree source, boolean lazy, List<JCTree$JCAnnotation> onMethod) {
        List<JCTree$JCStatement> statements;
        JCTree$JCVariableDecl fieldNode = (JCTree$JCVariableDecl) field.get();
        JCTree$JCExpression methodType = JavacHandlerUtil.cloneType(treeMaker, copyType(treeMaker, fieldNode), source, field.getContext());
        Name methodName = field.toName(JavacHandlerUtil.toGetterName(field));
        JCTree$JCMethodInvocation jCTree$JCMethodInvocation = null;
        int[] methodArgPos = null;
        boolean addSuppressWarningsUnchecked = false;
        if (lazy && !JavacHandlerUtil.inNetbeansEditor(field)) {
            jCTree$JCMethodInvocation = fieldNode.init;
            if (jCTree$JCMethodInvocation instanceof JCTree$JCMethodInvocation) {
                List<JCTree$JCExpression> args = jCTree$JCMethodInvocation.args;
                methodArgPos = new int[args.length()];
                for (int i = 0; i < methodArgPos.length; i++) {
                    methodArgPos[i] = ((JCTree$JCExpression) args.get(i)).pos;
                }
            }
            statements = createLazyGetterBody(treeMaker, field, source);
            addSuppressWarningsUnchecked = LombokOptionsFactory.getDelombokOptions(field.getContext()).getFormatPreferences().generateSuppressWarnings();
        } else {
            statements = createSimpleGetterBody(treeMaker, field);
        }
        JCTree$JCBlock methodBody = treeMaker.Block(0L, statements);
        List<JCTree$JCTypeParameter> methodGenericParams = List.nil();
        List<JCTree$JCVariableDecl> parameters = List.nil();
        List<JCTree$JCExpression> throwsClauses = List.nil();
        List<JCTree$JCAnnotation> copyableAnnotations = JavacHandlerUtil.findCopyableAnnotations(field);
        List<JCTree$JCAnnotation> delegates = findDelegatesAndRemoveFromField(field);
        List<JCTree$JCAnnotation> annsOnMethod = JavacHandlerUtil.copyAnnotations(onMethod).appendList(copyableAnnotations);
        if (field.isFinal()) {
            if (JavacHandlerUtil.getCheckerFrameworkVersion(field).generatePure()) {
                annsOnMethod = annsOnMethod.prepend(treeMaker.Annotation(JavacHandlerUtil.genTypeRef(field, CheckerFrameworkVersion.NAME__PURE), List.nil()));
            }
        } else if (JavacHandlerUtil.getCheckerFrameworkVersion(field).generateSideEffectFree()) {
            annsOnMethod = annsOnMethod.prepend(treeMaker.Annotation(JavacHandlerUtil.genTypeRef(field, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE), List.nil()));
        }
        if (JavacHandlerUtil.isFieldDeprecated(field)) {
            annsOnMethod = annsOnMethod.prepend(treeMaker.Annotation(JavacHandlerUtil.genJavaLangTypeRef(field, "Deprecated"), List.nil()));
        }
        JCTree$JCMethodDecl decl = JavacHandlerUtil.recursiveSetGeneratedBy(treeMaker.MethodDef(treeMaker.Modifiers(access, annsOnMethod), methodName, methodType, methodGenericParams, parameters, throwsClauses, methodBody, null), source, field.getContext());
        if (jCTree$JCMethodInvocation != null) {
            JavacHandlerUtil.recursiveSetGeneratedBy(jCTree$JCMethodInvocation, null, null);
        }
        if (methodArgPos != null) {
            for (int i2 = 0; i2 < methodArgPos.length; i2++) {
                ((JCTree$JCExpression) jCTree$JCMethodInvocation.args.get(i2)).pos = methodArgPos[i2];
            }
        }
        decl.mods.annotations = decl.mods.annotations.appendList(delegates);
        if (addSuppressWarningsUnchecked) {
            ListBuffer<JCTree$JCExpression> suppressions = new ListBuffer<>();
            if (!Boolean.FALSE.equals(field.getAst().readConfiguration(ConfigurationKeys.ADD_SUPPRESSWARNINGS_ANNOTATIONS))) {
                suppressions.add(treeMaker.Literal("all"));
            }
            suppressions.add(treeMaker.Literal("unchecked"));
            JavacHandlerUtil.addAnnotation(decl.mods, field, source.pos, source, field.getContext(), "java.lang.SuppressWarnings", treeMaker.NewArray(null, List.nil(), suppressions.toList()));
        }
        JavacHandlerUtil.copyJavadoc(field, decl, JavacHandlerUtil$CopyJavadoc.GETTER);
        return decl;
    }

    public static List<JCTree$JCAnnotation> findDelegatesAndRemoveFromField(JavacNode field) {
        JCTree$JCVariableDecl fieldNode = field.get();
        List<JCTree$JCAnnotation> delegates = List.nil();
        for (JCTree$JCAnnotation annotation : fieldNode.mods.annotations) {
            if (JavacHandlerUtil.typeMatches((Class<?>) Delegate.class, field, annotation.annotationType)) {
                delegates = delegates.append(annotation);
            }
        }
        if (!delegates.isEmpty()) {
            ListBuffer<JCTree$JCAnnotation> withoutDelegates = new ListBuffer<>();
            for (JCTree$JCAnnotation annotation2 : fieldNode.mods.annotations) {
                if (!delegates.contains(annotation2)) {
                    withoutDelegates.append(annotation2);
                }
            }
            fieldNode.mods.annotations = withoutDelegates.toList();
            field.rebuild();
        }
        return delegates;
    }

    public List<JCTree$JCStatement> createSimpleGetterBody(JavacTreeMaker treeMaker, JavacNode field) {
        return List.of(treeMaker.Return(JavacHandlerUtil.createFieldAccessor(treeMaker, field, HandlerUtil$FieldAccess.ALWAYS_FIELD)));
    }

    static {
        Map<JavacTreeMaker$TypeTag, String> m = new HashMap<>();
        m.put(Javac.CTC_INT, "Integer");
        m.put(Javac.CTC_DOUBLE, "Double");
        m.put(Javac.CTC_FLOAT, "Float");
        m.put(Javac.CTC_SHORT, "Short");
        m.put(Javac.CTC_BYTE, "Byte");
        m.put(Javac.CTC_LONG, "Long");
        m.put(Javac.CTC_BOOLEAN, "Boolean");
        m.put(Javac.CTC_CHAR, "Character");
        TYPE_MAP = Collections.unmodifiableMap(m);
    }

    public List<JCTree$JCStatement> createLazyGetterBody(JavacTreeMaker maker, JavacNode fieldNode, JCTree source) {
        String boxed;
        ListBuffer<JCTree$JCStatement> statements = new ListBuffer<>();
        JCTree$JCVariableDecl field = (JCTree$JCVariableDecl) fieldNode.get();
        JCTree$JCExpression copyOfRawFieldType = copyType(maker, field);
        JCTree$JCExpression copyOfBoxedFieldType = null;
        field.type = null;
        boolean isPrimitive = false;
        if ((field.vartype instanceof JCTree$JCPrimitiveTypeTree) && (boxed = TYPE_MAP.get(JavacTreeMaker$TypeTag.typeTag((JCTree) field.vartype))) != null) {
            isPrimitive = true;
            field.vartype = JavacHandlerUtil.genJavaLangTypeRef(fieldNode, boxed);
            copyOfBoxedFieldType = JavacHandlerUtil.genJavaLangTypeRef(fieldNode, boxed);
        }
        if (copyOfBoxedFieldType == null) {
            copyOfBoxedFieldType = copyType(maker, field);
        }
        Name valueName = fieldNode.toName("value");
        Name actualValueName = fieldNode.toName("actualValue");
        JCTree$JCExpression valueVarType = JavacHandlerUtil.genJavaLangTypeRef(fieldNode, "Object");
        statements.append(maker.VarDef(maker.Modifiers(0L), valueName, valueVarType, callGet(fieldNode, JavacHandlerUtil.createFieldAccessor(maker, fieldNode, HandlerUtil$FieldAccess.ALWAYS_FIELD))));
        ListBuffer<JCTree$JCStatement> synchronizedStatements = new ListBuffer<>();
        JCTree$JCExpressionStatement newAssign = maker.Exec(maker.Assign(maker.Ident(valueName), callGet(fieldNode, JavacHandlerUtil.createFieldAccessor(maker, fieldNode, HandlerUtil$FieldAccess.ALWAYS_FIELD))));
        synchronizedStatements.append(newAssign);
        ListBuffer<JCTree$JCStatement> innerIfStatements = new ListBuffer<>();
        innerIfStatements.append(maker.VarDef(maker.Modifiers(16L), actualValueName, copyOfRawFieldType, field.init));
        if (isPrimitive) {
            innerIfStatements.append(maker.Exec(maker.Assign(maker.Ident(valueName), maker.Ident(actualValueName))));
        }
        if (!isPrimitive) {
            JCTree$JCBinary jCTree$JCBinaryBinary = maker.Binary(Javac.CTC_EQUAL, maker.Ident(actualValueName), maker.Literal(Javac.CTC_BOT, null));
            JCTree$JCExpression thisDotFieldName = JavacHandlerUtil.createFieldAccessor(maker, fieldNode, HandlerUtil$FieldAccess.ALWAYS_FIELD);
            innerIfStatements.append(maker.Exec(maker.Assign(maker.Ident(valueName), maker.Conditional(jCTree$JCBinaryBinary, thisDotFieldName, maker.Ident(actualValueName)))));
        }
        JCTree$JCStatement statement = callSet(fieldNode, JavacHandlerUtil.createFieldAccessor(maker, fieldNode, HandlerUtil$FieldAccess.ALWAYS_FIELD), maker.Ident(valueName));
        innerIfStatements.append(statement);
        JCTree$JCBinary isNull = maker.Binary(Javac.CTC_EQUAL, maker.Ident(valueName), maker.Literal(Javac.CTC_BOT, null));
        JCTree$JCIf ifStatement = maker.If(isNull, maker.Block(0L, innerIfStatements.toList()), null);
        synchronizedStatements.append(ifStatement);
        JCTree$JCSynchronized synchronizedStatement = maker.Synchronized(JavacHandlerUtil.createFieldAccessor(maker, fieldNode, HandlerUtil$FieldAccess.ALWAYS_FIELD), maker.Block(0L, synchronizedStatements.toList()));
        JCTree$JCBinary isNull2 = maker.Binary(Javac.CTC_EQUAL, maker.Ident(valueName), maker.Literal(Javac.CTC_BOT, null));
        JCTree$JCIf ifStatement2 = maker.If(isNull2, maker.Block(0L, List.of(synchronizedStatement)), null);
        statements.append(ifStatement2);
        if (isPrimitive) {
            statements.append(maker.Return(maker.TypeCast(copyOfBoxedFieldType, maker.Ident(valueName))));
        }
        if (!isPrimitive) {
            statements.append(maker.Return(maker.TypeCast(copyOfBoxedFieldType, maker.Parens(maker.Conditional(maker.Binary(Javac.CTC_EQUAL, maker.Ident(valueName), JavacHandlerUtil.createFieldAccessor(maker, fieldNode, HandlerUtil$FieldAccess.ALWAYS_FIELD)), maker.Literal(Javac.CTC_BOT, null), maker.Ident(valueName))))));
        }
        field.vartype = JavacHandlerUtil.recursiveSetGeneratedBy(maker.TypeApply(JavacHandlerUtil.chainDotsString(fieldNode, AR), List.of(JavacHandlerUtil.genJavaLangTypeRef(fieldNode, "Object"))), source, fieldNode.getContext());
        field.init = JavacHandlerUtil.recursiveSetGeneratedBy(maker.NewClass(null, NIL_EXPRESSION, copyType(maker, field), NIL_EXPRESSION, null), source, fieldNode.getContext());
        return statements.toList();
    }

    public JCTree$JCMethodInvocation callGet(JavacNode source, JCTree$JCExpression receiver) {
        JavacTreeMaker maker = source.getTreeMaker();
        return maker.Apply(NIL_EXPRESSION, maker.Select(receiver, source.toName("get")), NIL_EXPRESSION);
    }

    public JCTree$JCStatement callSet(JavacNode source, JCTree$JCExpression receiver, JCTree$JCExpression value) {
        JavacTreeMaker maker = source.getTreeMaker();
        return maker.Exec(maker.Apply(NIL_EXPRESSION, maker.Select(receiver, source.toName("set")), List.of(value)));
    }

    public JCTree$JCExpression copyType(JavacTreeMaker treeMaker, JCTree$JCVariableDecl fieldNode) {
        return fieldNode.type != null ? treeMaker.Type(fieldNode.type) : fieldNode.vartype;
    }
}
