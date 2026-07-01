package lombok.javac.handlers;

import com.discord.api.permission.Permission;
import com.sun.tools.javac.code.Symbol$ClassSymbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCAssign;
import com.sun.tools.javac.tree.JCTree$JCBlock;
import com.sun.tools.javac.tree.JCTree$JCClassDecl;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.tree.JCTree$JCMethodDecl;
import com.sun.tools.javac.tree.JCTree$JCReturn;
import com.sun.tools.javac.tree.JCTree$JCStatement;
import com.sun.tools.javac.tree.JCTree$JCTypeParameter;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.lang.annotation.Annotation;
import java.util.Collection;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.Setter;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.HandlerUtil$FieldAccess;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleSetter.SCL.lombok */
public class HandleSetter extends JavacAnnotationHandler<Setter> {
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

    public void generateSetterForType(JavacNode typeNode, JavacNode errorNode, AccessLevel level, boolean checkForTypeLevelSetter, List<JCTree$JCAnnotation> onMethod, List<JCTree$JCAnnotation> onParam) {
        if (checkForTypeLevelSetter && JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) Setter.class, typeNode)) {
            return;
        }
        JCTree$JCClassDecl typeDecl = typeNode.get() instanceof JCTree$JCClassDecl ? (JCTree$JCClassDecl) typeNode.get() : null;
        long modifiers = typeDecl == null ? 0L : typeDecl.mods.flags;
        boolean notAClass = (modifiers & 25088) != 0;
        if (typeDecl == null || notAClass) {
            errorNode.addError("@Setter is only supported on a class or a field.");
            return;
        }
        for (JavacNode field : typeNode.down()) {
            if (field.getKind() == AST$Kind.FIELD) {
                JCTree$JCVariableDecl fieldDecl = field.get();
                if (!fieldDecl.name.toString().startsWith("$") && (fieldDecl.mods.flags & 8) == 0 && (fieldDecl.mods.flags & 16) == 0) {
                    generateSetterForField(field, errorNode, level, onMethod, onParam);
                }
            }
        }
    }

    public void generateSetterForField(JavacNode fieldNode, JavacNode sourceNode, AccessLevel level, List<JCTree$JCAnnotation> onMethod, List<JCTree$JCAnnotation> onParam) {
        if (JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) Setter.class, fieldNode)) {
            return;
        }
        createSetterForField(level, fieldNode, sourceNode, false, onMethod, onParam);
    }

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Setter> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.SETTER_FLAG_USAGE, "@Setter");
        Collection<JavacNode> fields = annotationNode.upFromAnnotationToFields();
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) Setter.class);
        JavacHandlerUtil.deleteImportFromCompilationUnit(annotationNode, "lombok.AccessLevel");
        JavacNode node = annotationNode.up();
        AccessLevel level = annotation.getInstance().value();
        if (level == AccessLevel.NONE || node == null) {
            return;
        }
        List<JCTree$JCAnnotation> onMethod = JavacHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onMethod", "@Setter(onMethod", annotationNode);
        List<JCTree$JCAnnotation> onParam = JavacHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onParam", "@Setter(onParam", annotationNode);
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
            case 2:
                generateSetterForType(node, annotationNode, level, false, onMethod, onParam);
                break;
            case 3:
                createSetterForFields(level, fields, annotationNode, true, onMethod, onParam);
                break;
        }
    }

    public void createSetterForFields(AccessLevel level, Collection<JavacNode> fieldNodes, JavacNode errorNode, boolean whineIfExists, List<JCTree$JCAnnotation> onMethod, List<JCTree$JCAnnotation> onParam) {
        for (JavacNode fieldNode : fieldNodes) {
            createSetterForField(level, fieldNode, errorNode, whineIfExists, onMethod, onParam);
        }
    }

    public void createSetterForField(AccessLevel level, JavacNode fieldNode, JavacNode sourceNode, boolean whineIfExists, List<JCTree$JCAnnotation> onMethod, List<JCTree$JCAnnotation> onParam) {
        Type returnType;
        if (fieldNode.getKind() != AST$Kind.FIELD) {
            fieldNode.addError("@Setter is only supported on a class or a field.");
            return;
        }
        JCTree$JCVariableDecl fieldDecl = fieldNode.get();
        String methodName = JavacHandlerUtil.toSetterName(fieldNode);
        if (methodName == null) {
            fieldNode.addWarning("Not generating setter for this field: It does not fit your @Accessors prefix list.");
            return;
        }
        if ((fieldDecl.mods.flags & 16) != 0) {
            fieldNode.addWarning("Not generating setter for this field: Setters cannot be generated for final fields.");
            return;
        }
        for (String altName : JavacHandlerUtil.toAllSetterNames(fieldNode)) {
            switch ($SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult()[JavacHandlerUtil.methodExists(altName, fieldNode, false, 1).ordinal()]) {
                case 1:
                default:
                    break;
                case 2:
                    return;
                case 3:
                    if (whineIfExists) {
                        String altNameExpl = altName.equals(methodName) ? "" : String.format(" (%s)", altName);
                        fieldNode.addWarning(String.format("Not generating %s(): A method with that name already exists%s", methodName, altNameExpl));
                        return;
                    }
                    return;
            }
        }
        long access = ((long) JavacHandlerUtil.toJavacModifier(level)) | (fieldDecl.mods.flags & 8);
        JCTree$JCMethodDecl createdSetter = createSetter(access, fieldNode, fieldNode.getTreeMaker(), sourceNode, onMethod, onParam);
        Type fieldType = JavacHandlerUtil.getMirrorForFieldType(fieldNode);
        if (JavacHandlerUtil.shouldReturnThis(fieldNode)) {
            Symbol$ClassSymbol sym = fieldNode.up().get().sym;
            returnType = sym == null ? null : sym.type;
        } else {
            returnType = Javac.createVoidType(fieldNode.getSymbolTable(), Javac.CTC_VOID);
        }
        JavacHandlerUtil.injectMethod(fieldNode.up(), createdSetter, fieldType == null ? null : List.of(fieldType), returnType);
    }

    public static JCTree$JCMethodDecl createSetter(long access, JavacNode field, JavacTreeMaker treeMaker, JavacNode source, List<JCTree$JCAnnotation> onMethod, List<JCTree$JCAnnotation> onParam) {
        String setterName = JavacHandlerUtil.toSetterName(field);
        boolean returnThis = JavacHandlerUtil.shouldReturnThis(field);
        return createSetter(access, false, field, treeMaker, setterName, null, null, returnThis, source, onMethod, onParam);
    }

    public static JCTree$JCMethodDecl createSetter(long access, boolean deprecate, JavacNode field, JavacTreeMaker treeMaker, String setterName, Name paramName, Name booleanFieldToSet, boolean shouldReturnThis, JavacNode source, List<JCTree$JCAnnotation> onMethod, List<JCTree$JCAnnotation> onParam) {
        JCTree$JCExpression returnType = null;
        JCTree$JCReturn returnStatement = null;
        if (shouldReturnThis) {
            returnType = JavacHandlerUtil.cloneSelfType(field);
            returnStatement = treeMaker.Return(treeMaker.Ident(field.toName("this")));
        }
        JCTree$JCMethodDecl d = createSetter(access, deprecate, field, treeMaker, setterName, paramName, booleanFieldToSet, returnType, returnStatement, source, onMethod, onParam);
        if (shouldReturnThis && JavacHandlerUtil.getCheckerFrameworkVersion(source).generateReturnsReceiver()) {
            List<JCTree$JCAnnotation> annotations = d.mods.annotations;
            if (annotations == null) {
                annotations = List.nil();
            }
            JCTree$JCAnnotation anno = treeMaker.Annotation(JavacHandlerUtil.genTypeRef(source, CheckerFrameworkVersion.NAME__RETURNS_RECEIVER), List.nil());
            JavacHandlerUtil.recursiveSetGeneratedBy(anno, source.get(), field.getContext());
            d.mods.annotations = annotations.prepend(anno);
        }
        return d;
    }

    public static JCTree$JCMethodDecl createSetterWithRecv(long access, boolean deprecate, JavacNode field, JavacTreeMaker treeMaker, String setterName, Name paramName, Name booleanFieldToSet, boolean shouldReturnThis, JavacNode source, List<JCTree$JCAnnotation> onMethod, List<JCTree$JCAnnotation> onParam, JCTree$JCVariableDecl recv) {
        JCTree$JCExpression returnType = null;
        JCTree$JCReturn returnStatement = null;
        if (shouldReturnThis) {
            returnType = JavacHandlerUtil.cloneSelfType(field);
            returnStatement = treeMaker.Return(treeMaker.Ident(field.toName("this")));
        }
        JCTree$JCMethodDecl d = createSetterWithRecv(access, deprecate, field, treeMaker, setterName, paramName, booleanFieldToSet, returnType, returnStatement, source, onMethod, onParam, recv);
        if (shouldReturnThis && JavacHandlerUtil.getCheckerFrameworkVersion(source).generateReturnsReceiver()) {
            List<JCTree$JCAnnotation> annotations = d.mods.annotations;
            if (annotations == null) {
                annotations = List.nil();
            }
            JCTree$JCAnnotation anno = treeMaker.Annotation(JavacHandlerUtil.genTypeRef(source, CheckerFrameworkVersion.NAME__RETURNS_RECEIVER), List.nil());
            JavacHandlerUtil.recursiveSetGeneratedBy(anno, source.get(), field.getContext());
            d.mods.annotations = annotations.prepend(anno);
        }
        return d;
    }

    public static JCTree$JCMethodDecl createSetter(long access, boolean deprecate, JavacNode field, JavacTreeMaker treeMaker, String setterName, Name paramName, Name booleanFieldToSet, JCTree$JCExpression methodType, JCTree$JCStatement returnStatement, JavacNode source, List<JCTree$JCAnnotation> onMethod, List<JCTree$JCAnnotation> onParam) {
        return createSetterWithRecv(access, deprecate, field, treeMaker, setterName, paramName, booleanFieldToSet, methodType, returnStatement, source, onMethod, onParam, null);
    }

    public static JCTree$JCMethodDecl createSetterWithRecv(long access, boolean deprecate, JavacNode field, JavacTreeMaker treeMaker, String setterName, Name paramName, Name booleanFieldToSet, JCTree$JCExpression methodType, JCTree$JCStatement returnStatement, JavacNode source, List<JCTree$JCAnnotation> onMethod, List<JCTree$JCAnnotation> onParam, JCTree$JCVariableDecl recv) {
        JCTree$JCStatement nullCheck;
        JCTree$JCMethodDecl methodDef;
        if (setterName == null) {
            return null;
        }
        JCTree$JCVariableDecl fieldDecl = field.get();
        if (paramName == null) {
            paramName = fieldDecl.name;
        }
        JCTree$JCExpression fieldRef = JavacHandlerUtil.createFieldAccessor(treeMaker, field, HandlerUtil$FieldAccess.ALWAYS_FIELD);
        JCTree$JCAssign assign = treeMaker.Assign(fieldRef, treeMaker.Ident(paramName));
        ListBuffer<JCTree$JCStatement> statements = new ListBuffer<>();
        List<JCTree$JCAnnotation> copyableAnnotations = JavacHandlerUtil.findCopyableAnnotations(field);
        Name methodName = field.toName(setterName);
        List<JCTree$JCAnnotation> annsOnParam = JavacHandlerUtil.copyAnnotations(onParam).appendList(copyableAnnotations);
        long flags = JavacHandlerUtil.addFinalIfNeeded(Permission.MANAGE_EVENTS, field.getContext());
        JCTree$JCExpression pType = JavacHandlerUtil.cloneType(treeMaker, fieldDecl.vartype, source.get(), source.getContext());
        JCTree$JCVariableDecl param = treeMaker.VarDef(treeMaker.Modifiers(flags, annsOnParam), paramName, pType, null);
        if ((JavacHandlerUtil.hasNonNullAnnotations(field) || JavacHandlerUtil.hasNonNullAnnotations(field, onParam)) && (nullCheck = JavacHandlerUtil.generateNullCheck(treeMaker, fieldDecl.vartype, paramName, source, null)) != null) {
            statements.append(nullCheck);
        }
        statements.append(treeMaker.Exec(assign));
        if (booleanFieldToSet != null) {
            JCTree$JCAssign setBool = treeMaker.Assign(treeMaker.Ident(booleanFieldToSet), treeMaker.Literal(Javac.CTC_BOOLEAN, 1));
            statements.append(treeMaker.Exec(setBool));
        }
        if (methodType == null) {
            methodType = treeMaker.Type(Javac.createVoidType(field.getSymbolTable(), Javac.CTC_VOID));
            returnStatement = null;
        }
        if (returnStatement != null) {
            statements.append(returnStatement);
        }
        JCTree$JCBlock methodBody = treeMaker.Block(0L, statements.toList());
        List<JCTree$JCTypeParameter> methodGenericParams = List.nil();
        List<JCTree$JCVariableDecl> parameters = List.of(param);
        List<JCTree$JCExpression> throwsClauses = List.nil();
        List<JCTree$JCAnnotation> annsOnMethod = JavacHandlerUtil.mergeAnnotations(JavacHandlerUtil.copyAnnotations(onMethod), JavacHandlerUtil.findCopyableToSetterAnnotations(field));
        if (JavacHandlerUtil.isFieldDeprecated(field) || deprecate) {
            annsOnMethod = annsOnMethod.prepend(treeMaker.Annotation(JavacHandlerUtil.genJavaLangTypeRef(field, "Deprecated"), List.nil()));
        }
        if (recv != null && treeMaker.hasMethodDefWithRecvParam()) {
            methodDef = treeMaker.MethodDefWithRecvParam(treeMaker.Modifiers(access, annsOnMethod), methodName, methodType, methodGenericParams, recv, parameters, throwsClauses, methodBody, null);
        } else {
            methodDef = treeMaker.MethodDef(treeMaker.Modifiers(access, annsOnMethod), methodName, methodType, methodGenericParams, parameters, throwsClauses, methodBody, null);
        }
        if (returnStatement != null) {
            JavacHandlerUtil.createRelevantNonNullAnnotation(source, methodDef);
        }
        JCTree$JCMethodDecl decl = JavacHandlerUtil.recursiveSetGeneratedBy(methodDef, source.get(), field.getContext());
        JavacHandlerUtil.copyJavadoc(field, decl, JavacHandlerUtil$CopyJavadoc.SETTER, returnStatement != null);
        return decl;
    }
}
