package lombok.eclipse.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.Setter;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.HandlerUtil$FieldAccess;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleSetter.SCL.lombok */
public class HandleSetter extends EclipseAnnotationHandler<Setter> {
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult;

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

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult() {
        int[] iArr = $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[EclipseHandlerUtil$MemberExistsResult.valuesCustom().length];
        try {
            iArr2[EclipseHandlerUtil$MemberExistsResult.EXISTS_BY_LOMBOK.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[EclipseHandlerUtil$MemberExistsResult.EXISTS_BY_USER.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[EclipseHandlerUtil$MemberExistsResult.NOT_EXISTS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult = iArr2;
        return iArr2;
    }

    public boolean generateSetterForType(EclipseNode typeNode, EclipseNode pos, AccessLevel level, boolean checkForTypeLevelSetter, List<Annotation> onMethod, List<Annotation> onParam) {
        if (checkForTypeLevelSetter && EclipseHandlerUtil.hasAnnotation((Class<? extends java.lang.annotation.Annotation>) Setter.class, typeNode)) {
            return true;
        }
        TypeDeclaration typeDecl = typeNode.get() instanceof TypeDeclaration ? (TypeDeclaration) typeNode.get() : null;
        int modifiers = typeDecl == null ? 0 : typeDecl.modifiers;
        boolean notAClass = (modifiers & 25088) != 0;
        if (typeDecl == null || notAClass) {
            pos.addError("@Setter is only supported on a class or a field.");
            return false;
        }
        for (EclipseNode field : typeNode.down()) {
            if (field.getKind() == AST$Kind.FIELD) {
                FieldDeclaration fieldDecl = field.get();
                if (EclipseHandlerUtil.filterField(fieldDecl) && (fieldDecl.modifiers & 16) == 0) {
                    generateSetterForField(field, pos, level, onMethod, onParam);
                }
            }
        }
        return true;
    }

    public void generateSetterForField(EclipseNode fieldNode, EclipseNode sourceNode, AccessLevel level, List<Annotation> onMethod, List<Annotation> onParam) {
        if (EclipseHandlerUtil.hasAnnotation((Class<? extends java.lang.annotation.Annotation>) Setter.class, fieldNode)) {
            return;
        }
        createSetterForField(level, fieldNode, sourceNode, false, onMethod, onParam);
    }

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<Setter> annotation, Annotation ast, EclipseNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.SETTER_FLAG_USAGE, "@Setter");
        EclipseNode node = annotationNode.up();
        AccessLevel level = annotation.getInstance().value();
        if (level == AccessLevel.NONE || node == null) {
            return;
        }
        List<Annotation> onMethod = EclipseHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onMethod", "@Setter(onMethod", annotationNode);
        List<Annotation> onParam = EclipseHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onParam", "@Setter(onParam", annotationNode);
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
            case 2:
                generateSetterForType(node, annotationNode, level, false, onMethod, onParam);
                break;
            case 3:
                createSetterForFields(level, annotationNode.upFromAnnotationToFields(), annotationNode, true, onMethod, onParam);
                break;
        }
    }

    public void createSetterForFields(AccessLevel level, Collection<EclipseNode> fieldNodes, EclipseNode sourceNode, boolean whineIfExists, List<Annotation> onMethod, List<Annotation> onParam) {
        for (EclipseNode fieldNode : fieldNodes) {
            createSetterForField(level, fieldNode, sourceNode, whineIfExists, onMethod, onParam);
        }
    }

    public void createSetterForField(AccessLevel level, EclipseNode fieldNode, EclipseNode sourceNode, boolean whineIfExists, List<Annotation> onMethod, List<Annotation> onParam) {
        ASTNode source = sourceNode.get();
        if (fieldNode.getKind() != AST$Kind.FIELD) {
            sourceNode.addError("@Setter is only supported on a class or a field.");
            return;
        }
        FieldDeclaration field = fieldNode.get();
        TypeReference fieldType = EclipseHandlerUtil.copyType(field.type, source);
        boolean isBoolean = EclipseHandlerUtil.isBoolean(fieldType);
        String setterName = EclipseHandlerUtil.toSetterName(fieldNode, isBoolean);
        boolean shouldReturnThis = EclipseHandlerUtil.shouldReturnThis(fieldNode);
        if (setterName == null) {
            fieldNode.addWarning("Not generating setter for this field: It does not fit your @Accessors prefix list.");
            return;
        }
        int modifier = EclipseHandlerUtil.toEclipseModifier(level) | (field.modifiers & 8);
        for (String altName : EclipseHandlerUtil.toAllSetterNames(fieldNode, isBoolean)) {
            switch ($SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult()[EclipseHandlerUtil.methodExists(altName, fieldNode, false, 1).ordinal()]) {
                case 1:
                default:
                    break;
                case 2:
                    return;
                case 3:
                    if (whineIfExists) {
                        String altNameExpl = altName.equals(setterName) ? "" : String.format(" (%s)", altName);
                        fieldNode.addWarning(String.format("Not generating %s(): A method with that name already exists%s", setterName, altNameExpl));
                        return;
                    }
                    return;
            }
        }
        MethodDeclaration method = createSetter(fieldNode.up().get(), false, fieldNode, setterName, null, null, shouldReturnThis, modifier, sourceNode, onMethod, onParam);
        EclipseHandlerUtil.injectMethod(fieldNode.up(), method);
    }

    static MethodDeclaration createSetter(TypeDeclaration parent, boolean deprecate, EclipseNode fieldNode, String name, char[] paramName, char[] booleanFieldToSet, boolean shouldReturnThis, int modifier, EclipseNode sourceNode, List<Annotation> onMethod, List<Annotation> onParam) {
        ASTNode source = sourceNode.get();
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        TypeReference returnType = null;
        ReturnStatement returnThis = null;
        if (shouldReturnThis) {
            returnType = EclipseHandlerUtil.cloneSelfType(fieldNode, source);
            ThisReference thisRef = new ThisReference(pS, pE);
            returnThis = new ReturnStatement(thisRef, pS, pE);
        }
        MethodDeclaration d = createSetter(parent, deprecate, fieldNode, name, paramName, booleanFieldToSet, returnType, returnThis, modifier, sourceNode, onMethod, onParam);
        if (shouldReturnThis && EclipseHandlerUtil.getCheckerFrameworkVersion(sourceNode).generateReturnsReceiver()) {
            d.annotations = EclipseHandlerUtil.copyAnnotations(source, d.annotations, new Annotation[]{EclipseHandlerUtil.generateNamedAnnotation(source, CheckerFrameworkVersion.NAME__RETURNS_RECEIVER)});
        }
        return d;
    }

    static MethodDeclaration createSetter(TypeDeclaration parent, boolean deprecate, EclipseNode fieldNode, String name, char[] paramName, char[] booleanFieldToSet, TypeReference returnType, Statement returnStatement, int modifier, EclipseNode sourceNode, List<Annotation> onMethod, List<Annotation> onParam) {
        Statement nullCheck;
        FieldDeclaration field = fieldNode.get();
        if (paramName == null) {
            paramName = field.name;
        }
        ASTNode source = sourceNode.get();
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (((long) pS) << 32) | ((long) pE);
        MethodDeclaration method = new MethodDeclaration(parent.compilationResult);
        method.modifiers = modifier;
        if (returnType != null) {
            method.returnType = returnType;
        } else {
            method.returnType = TypeReference.baseTypeReference(6, 0);
            method.returnType.sourceStart = pS;
            method.returnType.sourceEnd = pE;
        }
        Annotation[] deprecated = null;
        if (EclipseHandlerUtil.isFieldDeprecated(fieldNode) || deprecate) {
            deprecated = new Annotation[]{EclipseHandlerUtil.generateDeprecatedAnnotation(source)};
        }
        method.annotations = EclipseHandlerUtil.copyAnnotations(source, (Annotation[]) onMethod.toArray(new Annotation[0]), deprecated, EclipseHandlerUtil.findCopyableToSetterAnnotations(fieldNode));
        Argument param = new Argument(paramName, p, EclipseHandlerUtil.copyType(field.type, source), 16);
        param.sourceStart = pS;
        param.sourceEnd = pE;
        method.arguments = new Argument[]{param};
        method.selector = name.toCharArray();
        method.binding = null;
        method.thrownExceptions = null;
        method.typeParameters = null;
        method.bits |= 8388608;
        Expression fieldRef = EclipseHandlerUtil.createFieldAccessor(fieldNode, HandlerUtil$FieldAccess.ALWAYS_FIELD, source);
        Assignment assignment = new Assignment(fieldRef, new SingleNameReference(paramName, p), (int) p);
        assignment.sourceStart = pS;
        assignment.statementEnd = pE;
        assignment.sourceEnd = pE;
        int i = source.sourceStart;
        method.sourceStart = i;
        method.declarationSourceStart = i;
        method.bodyStart = i;
        int i2 = source.sourceEnd;
        method.sourceEnd = i2;
        method.declarationSourceEnd = i2;
        method.bodyEnd = i2;
        Annotation[] copyableAnnotations = EclipseHandlerUtil.findCopyableAnnotations(fieldNode);
        List<Statement> statements = new ArrayList<>(5);
        if ((EclipseHandlerUtil.hasNonNullAnnotations(fieldNode) || EclipseHandlerUtil.hasNonNullAnnotations(fieldNode, onParam)) && (nullCheck = EclipseHandlerUtil.generateNullCheck(field.type, paramName, sourceNode, null)) != null) {
            statements.add(nullCheck);
        }
        statements.add(assignment);
        if (booleanFieldToSet != null) {
            statements.add(new Assignment(new SingleNameReference(booleanFieldToSet, p), new TrueLiteral(pS, pE), pE));
        }
        if (returnType != null && returnStatement != null) {
            statements.add(returnStatement);
        }
        method.statements = (Statement[]) statements.toArray(new Statement[0]);
        param.annotations = EclipseHandlerUtil.copyAnnotations(source, copyableAnnotations, (Annotation[]) onParam.toArray(new Annotation[0]));
        if (returnType != null && returnStatement != null) {
            EclipseHandlerUtil.createRelevantNonNullAnnotation(sourceNode, method);
        }
        method.traverse(new SetGeneratedByVisitor(source), parent.scope);
        EclipseHandlerUtil.copyJavadoc(fieldNode, (ASTNode) method, EclipseHandlerUtil$CopyJavadoc.SETTER, returnStatement != null);
        return method;
    }
}
