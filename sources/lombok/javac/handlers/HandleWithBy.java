package lombok.javac.handlers;

import com.discord.api.permission.Permission;
import com.sun.tools.javac.code.BoundKind;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.lang.annotation.Annotation;
import java.util.Collection;
import javax.lang.model.type.TypeKind;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.experimental.WithBy;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.javac.handlers.JavacHandlerUtil;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleWithBy.SCL.lombok */
public class HandleWithBy extends JavacAnnotationHandler<WithBy> {
    private static final LombokImmutableList<String> NAME_JUF_FUNCTION = LombokImmutableList.of("java", "util", "function", "Function");
    private static final LombokImmutableList<String> NAME_JUF_OP = LombokImmutableList.of("java", "util", "function", "UnaryOperator");
    private static final LombokImmutableList<String> NAME_JUF_DOUBLEOP = LombokImmutableList.of("java", "util", "function", "DoubleUnaryOperator");
    private static final LombokImmutableList<String> NAME_JUF_INTOP = LombokImmutableList.of("java", "util", "function", "IntUnaryOperator");
    private static final LombokImmutableList<String> NAME_JUF_LONGOP = LombokImmutableList.of("java", "util", "function", "LongUnaryOperator");
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult;

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind() {
        int[] iArr = $SWITCH_TABLE$lombok$core$AST$Kind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AST.Kind.valuesCustom().length];
        try {
            iArr2[AST.Kind.ANNOTATION.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[AST.Kind.ARGUMENT.ordinal()] = 7;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[AST.Kind.COMPILATION_UNIT.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[AST.Kind.FIELD.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[AST.Kind.INITIALIZER.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[AST.Kind.LOCAL.ordinal()] = 8;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[AST.Kind.METHOD.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[AST.Kind.STATEMENT.ordinal()] = 9;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[AST.Kind.TYPE.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[AST.Kind.TYPE_USE.ordinal()] = 10;
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
        int[] iArr2 = new int[JavacHandlerUtil.MemberExistsResult.valuesCustom().length];
        try {
            iArr2[JavacHandlerUtil.MemberExistsResult.EXISTS_BY_LOMBOK.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[JavacHandlerUtil.MemberExistsResult.EXISTS_BY_USER.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[JavacHandlerUtil.MemberExistsResult.NOT_EXISTS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult = iArr2;
        return iArr2;
    }

    public void generateWithByForType(JavacNode typeNode, JavacNode errorNode, AccessLevel level, boolean checkForTypeLevelWithBy) {
        if (checkForTypeLevelWithBy && JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) WithBy.class, typeNode)) {
            return;
        }
        JCTree.JCClassDecl typeDecl = typeNode.get() instanceof JCTree.JCClassDecl ? (JCTree.JCClassDecl) typeNode.get() : null;
        long modifiers = typeDecl == null ? 0L : typeDecl.mods.flags;
        boolean notAClass = (modifiers & 25088) != 0;
        if (typeDecl == null || notAClass) {
            errorNode.addError("@WithBy is only supported on a class or a field.");
            return;
        }
        for (JavacNode field : typeNode.down()) {
            if (field.getKind() == AST.Kind.FIELD) {
                JCTree.JCVariableDecl fieldDecl = field.get();
                if (!fieldDecl.name.toString().startsWith("$") && (fieldDecl.mods.flags & 8) == 0 && ((fieldDecl.mods.flags & 16) == 0 || fieldDecl.init == null)) {
                    generateWithByForField(field, (JCDiagnostic.DiagnosticPosition) errorNode.get(), level);
                }
            }
        }
    }

    public void generateWithByForField(JavacNode fieldNode, JCDiagnostic.DiagnosticPosition pos, AccessLevel level) {
        if (JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) WithBy.class, fieldNode)) {
            return;
        }
        createWithByForField(level, fieldNode, fieldNode, false, List.nil());
    }

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<WithBy> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.WITHBY_FLAG_USAGE, "@WithBy");
        Collection<JavacNode> fields = annotationNode.upFromAnnotationToFields();
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) WithBy.class);
        JavacHandlerUtil.deleteImportFromCompilationUnit(annotationNode, "lombok.AccessLevel");
        JavacNode node = annotationNode.up();
        AccessLevel level = annotation.getInstance().value();
        if (level == AccessLevel.NONE || node == null) {
            return;
        }
        List<JCTree.JCAnnotation> onMethod = JavacHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onMethod", "@WithBy(onMethod", annotationNode);
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
            case 2:
                if (!onMethod.isEmpty()) {
                    annotationNode.addError("'onMethod' is not supported for @WithBy on a type.");
                }
                generateWithByForType(node, annotationNode, level, false);
                break;
            case 3:
                createWithByForFields(level, fields, annotationNode, true, onMethod);
                break;
        }
    }

    public void createWithByForFields(AccessLevel level, Collection<JavacNode> fieldNodes, JavacNode errorNode, boolean whineIfExists, List<JCTree.JCAnnotation> onMethod) {
        for (JavacNode fieldNode : fieldNodes) {
            createWithByForField(level, fieldNode, errorNode, whineIfExists, onMethod);
        }
    }

    public void createWithByForField(AccessLevel level, JavacNode fieldNode, JavacNode source, boolean strictMode, List<JCTree.JCAnnotation> onMethod) {
        JavacNode typeNode = fieldNode.up();
        boolean makeAbstract = (typeNode == null || typeNode.getKind() != AST.Kind.TYPE || (typeNode.get().mods.flags & Permission.VIEW_CHANNEL) == 0) ? false : true;
        if (fieldNode.getKind() != AST.Kind.FIELD) {
            fieldNode.addError("@WithBy is only supported on a class or a field.");
            return;
        }
        JCTree.JCVariableDecl fieldDecl = fieldNode.get();
        String methodName = JavacHandlerUtil.toWithByName(fieldNode);
        if (methodName == null) {
            fieldNode.addWarning("Not generating a withXBy method for this field: It does not fit your @Accessors prefix list.");
            return;
        }
        if ((fieldDecl.mods.flags & 8) != 0) {
            if (strictMode) {
                fieldNode.addWarning("Not generating " + methodName + " for this field: WithBy methods cannot be generated for static fields.");
                return;
            }
            return;
        }
        if ((fieldDecl.mods.flags & 16) != 0 && fieldDecl.init != null) {
            if (strictMode) {
                fieldNode.addWarning("Not generating " + methodName + " for this field: WithBy methods cannot be generated for final, initialized fields.");
                return;
            }
            return;
        }
        if (fieldDecl.name.toString().startsWith("$")) {
            if (strictMode) {
                fieldNode.addWarning("Not generating " + methodName + " for this field: WithBy methods cannot be generated for fields starting with $.");
                return;
            }
            return;
        }
        for (String altName : JavacHandlerUtil.toAllWithByNames(fieldNode)) {
            switch ($SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult()[JavacHandlerUtil.methodExists(altName, fieldNode, false, 1).ordinal()]) {
                case 1:
                default:
                    break;
                case 2:
                    return;
                case 3:
                    if (strictMode) {
                        String altNameExpl = altName.equals(methodName) ? "" : String.format(" (%s)", altName);
                        fieldNode.addWarning(String.format("Not generating %s(): A method with that name already exists%s", methodName, altNameExpl));
                        return;
                    }
                    return;
            }
        }
        long access = JavacHandlerUtil.toJavacModifier(level);
        JCTree.JCMethodDecl createdWithBy = createWithBy(access, fieldNode, fieldNode.getTreeMaker(), source, onMethod, makeAbstract);
        Symbol.ClassSymbol sym = fieldNode.up().get().sym;
        Type returnType = sym == null ? null : sym.type;
        JavacHandlerUtil.injectMethod(typeNode, createdWithBy, List.of(JavacHandlerUtil.getMirrorForFieldType(fieldNode)), returnType);
    }

    public JCTree.JCMethodDecl createWithBy(long access, JavacNode field, JavacTreeMaker maker, JavacNode source, List<JCTree.JCAnnotation> onMethod, boolean makeAbstract) {
        String withByName = JavacHandlerUtil.toWithByName(field);
        if (withByName == null) {
            return null;
        }
        JCTree.JCVariableDecl fieldDecl = field.get();
        Name methodName = field.toName(withByName);
        JCTree.JCExpression returnType = JavacHandlerUtil.cloneSelfType(field);
        JCTree.JCBlock methodBody = null;
        long flags = JavacHandlerUtil.addFinalIfNeeded(Permission.MANAGE_EVENTS, field.getContext());
        LombokImmutableList<String> functionalInterfaceName = null;
        JavacTreeMaker.TypeTag requiredCast = null;
        JCTree.JCExpression parameterizer = null;
        boolean superExtendsStyle = true;
        if (fieldDecl.vartype instanceof JCTree.JCPrimitiveTypeTree) {
            TypeKind kind = fieldDecl.vartype.getPrimitiveTypeKind();
            if (kind == TypeKind.CHAR) {
                requiredCast = Javac.CTC_CHAR;
                functionalInterfaceName = NAME_JUF_INTOP;
            } else if (kind == TypeKind.SHORT) {
                requiredCast = Javac.CTC_SHORT;
                functionalInterfaceName = NAME_JUF_INTOP;
            } else if (kind == TypeKind.BYTE) {
                requiredCast = Javac.CTC_BYTE;
                functionalInterfaceName = NAME_JUF_INTOP;
            } else if (kind == TypeKind.INT) {
                functionalInterfaceName = NAME_JUF_INTOP;
            } else if (kind == TypeKind.LONG) {
                functionalInterfaceName = NAME_JUF_LONGOP;
            } else if (kind == TypeKind.FLOAT) {
                functionalInterfaceName = NAME_JUF_DOUBLEOP;
                requiredCast = Javac.CTC_FLOAT;
            } else if (kind == TypeKind.DOUBLE) {
                functionalInterfaceName = NAME_JUF_DOUBLEOP;
            } else if (kind == TypeKind.BOOLEAN) {
                functionalInterfaceName = NAME_JUF_OP;
                parameterizer = JavacHandlerUtil.genJavaLangTypeRef(field, "Boolean");
                superExtendsStyle = false;
            }
        }
        if (functionalInterfaceName == null) {
            functionalInterfaceName = NAME_JUF_FUNCTION;
            parameterizer = JavacHandlerUtil.cloneType(maker, fieldDecl.vartype, source.get(), field.getContext());
        }
        String applyMethodName = functionalInterfaceName == NAME_JUF_INTOP ? "applyAsInt" : "apply";
        if (functionalInterfaceName == NAME_JUF_LONGOP) {
            applyMethodName = "applyAsLong";
        }
        if (functionalInterfaceName == NAME_JUF_DOUBLEOP) {
            applyMethodName = "applyAsDouble";
        }
        JCTree.JCExpression varType = JavacHandlerUtil.chainDots(field, functionalInterfaceName);
        if (parameterizer != null && superExtendsStyle) {
            JCTree.JCExpression parameterizer1 = parameterizer;
            JCTree.JCExpression parameterizer2 = JavacHandlerUtil.cloneType(maker, parameterizer, source.get(), field.getContext());
            varType = maker.TypeApply(varType, List.of(maker.Wildcard(maker.TypeBoundKind(BoundKind.SUPER), parameterizer1), maker.Wildcard(maker.TypeBoundKind(BoundKind.EXTENDS), parameterizer2)));
        }
        if (parameterizer != null && !superExtendsStyle) {
            varType = maker.TypeApply(varType, List.of(parameterizer));
        }
        Name paramName = field.toName("transformer");
        JCTree.JCVariableDecl param = maker.VarDef(maker.Modifiers(flags), paramName, varType, null);
        if (!makeAbstract) {
            ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
            JCTree.JCExpression selfType = JavacHandlerUtil.cloneSelfType(field);
            if (selfType == null) {
                return null;
            }
            ListBuffer<JCTree.JCExpression> args = new ListBuffer<>();
            for (JavacNode child : field.up().down()) {
                if (child.getKind() == AST.Kind.FIELD) {
                    JCTree.JCVariableDecl childDecl = child.get();
                    if (!childDecl.name.toString().startsWith("$")) {
                        long fieldFlags = childDecl.mods.flags;
                        if ((fieldFlags & 8) == 0 && ((fieldFlags & 16) == 0 || childDecl.init == null)) {
                            if (child.get() == field.get()) {
                                JCTree.JCExpression invoke = maker.Apply(List.nil(), maker.Select(maker.Ident(paramName), field.toName(applyMethodName)), List.of(JavacHandlerUtil.createFieldAccessor(maker, child, HandlerUtil.FieldAccess.ALWAYS_FIELD)));
                                if (requiredCast != null) {
                                    invoke = maker.TypeCast(maker.TypeIdent(requiredCast), invoke);
                                }
                                args.append(invoke);
                            } else {
                                args.append(JavacHandlerUtil.createFieldAccessor(maker, child, HandlerUtil.FieldAccess.ALWAYS_FIELD));
                            }
                        }
                    }
                }
            }
            JCTree.JCNewClass newClass = maker.NewClass(null, List.nil(), selfType, args.toList(), null);
            JCTree.JCReturn returnStatement = maker.Return(newClass);
            statements.append(returnStatement);
            methodBody = maker.Block(0L, statements.toList());
        }
        List<JCTree.JCTypeParameter> methodGenericParams = List.nil();
        List<JCTree.JCVariableDecl> parameters = List.of(param);
        List<JCTree.JCExpression> throwsClauses = List.nil();
        List<JCTree.JCAnnotation> annsOnMethod = JavacHandlerUtil.copyAnnotations(onMethod);
        CheckerFrameworkVersion checkerFramework = JavacHandlerUtil.getCheckerFrameworkVersion(source);
        if (checkerFramework.generateSideEffectFree()) {
            annsOnMethod = annsOnMethod.prepend(maker.Annotation(JavacHandlerUtil.genTypeRef(source, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE), List.nil()));
        }
        if (JavacHandlerUtil.isFieldDeprecated(field)) {
            annsOnMethod = annsOnMethod.prepend(maker.Annotation(JavacHandlerUtil.genJavaLangTypeRef(field, "Deprecated"), List.nil()));
        }
        if (makeAbstract) {
            access |= Permission.VIEW_CHANNEL;
        }
        JavacHandlerUtil.createRelevantNonNullAnnotation(source, param);
        JCTree.JCMethodDecl decl = JavacHandlerUtil.recursiveSetGeneratedBy(maker.MethodDef(maker.Modifiers(access, annsOnMethod), methodName, returnType, methodGenericParams, parameters, throwsClauses, methodBody, null), source.get(), field.getContext());
        JavacHandlerUtil.copyJavadoc(field, decl, JavacHandlerUtil.CopyJavadoc.WITH_BY);
        JavacHandlerUtil.createRelevantNonNullAnnotation(source, decl);
        return decl;
    }
}
