package lombok.javac.handlers;

import com.discord.api.permission.Permission;
import com.sun.tools.javac.code.Symbol$ClassSymbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCBlock;
import com.sun.tools.javac.tree.JCTree$JCClassDecl;
import com.sun.tools.javac.tree.JCTree$JCConditional;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.tree.JCTree$JCMethodDecl;
import com.sun.tools.javac.tree.JCTree$JCNewClass;
import com.sun.tools.javac.tree.JCTree$JCReturn;
import com.sun.tools.javac.tree.JCTree$JCStatement;
import com.sun.tools.javac.tree.JCTree$JCTypeParameter;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import com.sun.tools.javac.util.JCDiagnostic$DiagnosticPosition;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.lang.annotation.Annotation;
import java.util.Collection;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.With;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.HandlerUtil$FieldAccess;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleWith.SCL.lombok */
public class HandleWith extends JavacAnnotationHandler<With> {
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

    public void generateWithForType(JavacNode typeNode, JavacNode errorNode, AccessLevel level, boolean checkForTypeLevelWith) {
        if (checkForTypeLevelWith && JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) With.class, typeNode)) {
            return;
        }
        JCTree$JCClassDecl typeDecl = typeNode.get() instanceof JCTree$JCClassDecl ? (JCTree$JCClassDecl) typeNode.get() : null;
        long modifiers = typeDecl == null ? 0L : typeDecl.mods.flags;
        boolean notAClass = (modifiers & 25088) != 0;
        if (typeDecl == null || notAClass) {
            errorNode.addError("@With is only supported on a class or a field.");
            return;
        }
        for (JavacNode field : typeNode.down()) {
            if (field.getKind() == AST$Kind.FIELD) {
                JCTree$JCVariableDecl fieldDecl = field.get();
                if (!fieldDecl.name.toString().startsWith("$") && (fieldDecl.mods.flags & 8) == 0 && ((fieldDecl.mods.flags & 16) == 0 || fieldDecl.init == null)) {
                    generateWithForField(field, (JCDiagnostic$DiagnosticPosition) errorNode.get(), level);
                }
            }
        }
    }

    public void generateWithForField(JavacNode fieldNode, JCDiagnostic$DiagnosticPosition pos, AccessLevel level) {
        if (JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) With.class, fieldNode)) {
            return;
        }
        createWithForField(level, fieldNode, fieldNode, false, List.nil(), List.nil());
    }

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<With> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.WITH_FLAG_USAGE, "@With");
        Collection<JavacNode> fields = annotationNode.upFromAnnotationToFields();
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) With.class, "lombok.experimental.Wither");
        JavacHandlerUtil.deleteImportFromCompilationUnit(annotationNode, "lombok.AccessLevel");
        JavacNode node = annotationNode.up();
        AccessLevel level = annotation.getInstance().value();
        if (level == AccessLevel.NONE || node == null) {
            return;
        }
        List<JCTree$JCAnnotation> onMethod = JavacHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onMethod", "@With(onMethod", annotationNode);
        List<JCTree$JCAnnotation> onParam = JavacHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onParam", "@With(onParam", annotationNode);
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
            case 2:
                if (!onMethod.isEmpty()) {
                    annotationNode.addError("'onMethod' is not supported for @With on a type.");
                }
                if (!onParam.isEmpty()) {
                    annotationNode.addError("'onParam' is not supported for @With on a type.");
                }
                generateWithForType(node, annotationNode, level, false);
                break;
            case 3:
                createWithForFields(level, fields, annotationNode, true, onMethod, onParam);
                break;
        }
    }

    public void createWithForFields(AccessLevel level, Collection<JavacNode> fieldNodes, JavacNode errorNode, boolean whineIfExists, List<JCTree$JCAnnotation> onMethod, List<JCTree$JCAnnotation> onParam) {
        for (JavacNode fieldNode : fieldNodes) {
            createWithForField(level, fieldNode, errorNode, whineIfExists, onMethod, onParam);
        }
    }

    public void createWithForField(AccessLevel level, JavacNode fieldNode, JavacNode source, boolean strictMode, List<JCTree$JCAnnotation> onMethod, List<JCTree$JCAnnotation> onParam) {
        JavacNode typeNode = fieldNode.up();
        boolean makeAbstract = (typeNode == null || typeNode.getKind() != AST$Kind.TYPE || (typeNode.get().mods.flags & Permission.VIEW_CHANNEL) == 0) ? false : true;
        if (fieldNode.getKind() != AST$Kind.FIELD) {
            fieldNode.addError("@With is only supported on a class or a field.");
            return;
        }
        JCTree$JCVariableDecl fieldDecl = fieldNode.get();
        String methodName = JavacHandlerUtil.toWithName(fieldNode);
        if (methodName == null) {
            fieldNode.addWarning("Not generating a withX method for this field: It does not fit your @Accessors prefix list.");
            return;
        }
        if ((fieldDecl.mods.flags & 8) != 0) {
            if (strictMode) {
                fieldNode.addWarning("Not generating " + methodName + " for this field: With methods cannot be generated for static fields.");
                return;
            }
            return;
        }
        if ((fieldDecl.mods.flags & 16) != 0 && fieldDecl.init != null) {
            if (strictMode) {
                fieldNode.addWarning("Not generating " + methodName + " for this field: With methods cannot be generated for final, initialized fields.");
                return;
            }
            return;
        }
        if (fieldDecl.name.toString().startsWith("$")) {
            if (strictMode) {
                fieldNode.addWarning("Not generating " + methodName + " for this field: With methods cannot be generated for fields starting with $.");
                return;
            }
            return;
        }
        for (String altName : JavacHandlerUtil.toAllWithNames(fieldNode)) {
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
        JCTree$JCMethodDecl createdWith = createWith(access, fieldNode, fieldNode.getTreeMaker(), source, onMethod, onParam, makeAbstract);
        JavacHandlerUtil.createRelevantNonNullAnnotation(fieldNode, createdWith);
        Symbol$ClassSymbol sym = fieldNode.up().get().sym;
        Type returnType = sym == null ? null : sym.type;
        JavacHandlerUtil.injectMethod(typeNode, createdWith, List.of(JavacHandlerUtil.getMirrorForFieldType(fieldNode)), returnType);
    }

    public JCTree$JCMethodDecl createWith(long access, JavacNode field, JavacTreeMaker maker, JavacNode source, List<JCTree$JCAnnotation> onMethod, List<JCTree$JCAnnotation> onParam, boolean makeAbstract) {
        JCTree$JCStatement nullCheck;
        String withName = JavacHandlerUtil.toWithName(field);
        if (withName == null) {
            return null;
        }
        JCTree$JCVariableDecl fieldDecl = field.get();
        List<JCTree$JCAnnotation> copyableAnnotations = JavacHandlerUtil.findCopyableAnnotations(field);
        Name methodName = field.toName(withName);
        JCTree$JCExpression returnType = JavacHandlerUtil.cloneSelfType(field);
        JCTree$JCBlock methodBody = null;
        long flags = JavacHandlerUtil.addFinalIfNeeded(Permission.MANAGE_EVENTS, field.getContext());
        List<JCTree$JCAnnotation> annsOnParam = JavacHandlerUtil.copyAnnotations(onParam).appendList(copyableAnnotations);
        JCTree$JCExpression pType = JavacHandlerUtil.cloneType(maker, fieldDecl.vartype, source.get(), source.getContext());
        JCTree$JCVariableDecl param = maker.VarDef(maker.Modifiers(flags, annsOnParam), fieldDecl.name, pType, null);
        if (!makeAbstract) {
            ListBuffer<JCTree$JCStatement> statements = new ListBuffer<>();
            JCTree$JCExpression selfType = JavacHandlerUtil.cloneSelfType(field);
            if (selfType == null) {
                return null;
            }
            ListBuffer<JCTree$JCExpression> args = new ListBuffer<>();
            for (JavacNode child : field.up().down()) {
                if (child.getKind() == AST$Kind.FIELD) {
                    JCTree$JCVariableDecl childDecl = child.get();
                    if (!childDecl.name.toString().startsWith("$")) {
                        long fieldFlags = childDecl.mods.flags;
                        if ((fieldFlags & 8) == 0 && ((fieldFlags & 16) == 0 || childDecl.init == null)) {
                            if (child.get() == field.get()) {
                                args.append(maker.Ident(fieldDecl.name));
                            } else {
                                args.append(JavacHandlerUtil.createFieldAccessor(maker, child, HandlerUtil$FieldAccess.ALWAYS_FIELD));
                            }
                        }
                    }
                }
            }
            JCTree$JCNewClass newClass = maker.NewClass(null, List.nil(), selfType, args.toList(), null);
            JCTree$JCConditional conditional = maker.Conditional(maker.Binary(Javac.CTC_EQUAL, JavacHandlerUtil.createFieldAccessor(maker, field, HandlerUtil$FieldAccess.ALWAYS_FIELD), maker.Ident(fieldDecl.name)), maker.Ident(field.toName("this")), newClass);
            JCTree$JCReturn returnStatement = maker.Return(conditional);
            if (JavacHandlerUtil.hasNonNullAnnotations(field) && (nullCheck = JavacHandlerUtil.generateNullCheck(maker, field, source)) != null) {
                statements.append(nullCheck);
            }
            statements.append(returnStatement);
            methodBody = maker.Block(0L, statements.toList());
        }
        List<JCTree$JCTypeParameter> methodGenericParams = List.nil();
        List<JCTree$JCVariableDecl> parameters = List.of(param);
        List<JCTree$JCExpression> throwsClauses = List.nil();
        List<JCTree$JCAnnotation> annsOnMethod = JavacHandlerUtil.copyAnnotations(onMethod);
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
        JCTree$JCMethodDecl decl = JavacHandlerUtil.recursiveSetGeneratedBy(maker.MethodDef(maker.Modifiers(access, annsOnMethod), methodName, returnType, methodGenericParams, parameters, throwsClauses, methodBody, null), source.get(), field.getContext());
        JavacHandlerUtil.copyJavadoc(field, decl, JavacHandlerUtil$CopyJavadoc.WITH);
        return decl;
    }
}
