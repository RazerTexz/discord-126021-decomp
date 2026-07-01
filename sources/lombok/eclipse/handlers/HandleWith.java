package lombok.eclipse.handlers;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.With;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.HandlerUtil$FieldAccess;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.ConditionalExpression;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleWith.SCL.lombok */
public class HandleWith extends EclipseAnnotationHandler<With> {
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

    public boolean generateWithForType(EclipseNode typeNode, EclipseNode pos, AccessLevel level, boolean checkForTypeLevelWith) {
        if (checkForTypeLevelWith && EclipseHandlerUtil.hasAnnotation((Class<? extends Annotation>) With.class, typeNode)) {
            return true;
        }
        TypeDeclaration typeDecl = typeNode.get() instanceof TypeDeclaration ? (TypeDeclaration) typeNode.get() : null;
        int modifiers = typeDecl == null ? 0 : typeDecl.modifiers;
        boolean notAClass = (modifiers & 25088) != 0;
        if (typeDecl == null || notAClass) {
            pos.addError("@With is only supported on a class or a field.");
            return false;
        }
        for (EclipseNode field : typeNode.down()) {
            if (field.getKind() == AST$Kind.FIELD) {
                FieldDeclaration fieldDecl = field.get();
                if (EclipseHandlerUtil.filterField(fieldDecl) && ((fieldDecl.modifiers & 16) == 0 || fieldDecl.initialization == null)) {
                    generateWithForField(field, pos, level);
                }
            }
        }
        return true;
    }

    public void generateWithForField(EclipseNode fieldNode, EclipseNode sourceNode, AccessLevel level) {
        for (EclipseNode child : fieldNode.down()) {
            if (child.getKind() == AST$Kind.ANNOTATION && EclipseHandlerUtil.annotationTypeMatches((Class<? extends Annotation>) With.class, child)) {
                return;
            }
        }
        List<org.eclipse.jdt.internal.compiler.ast.Annotation> empty = Collections.emptyList();
        createWithForField(level, fieldNode, sourceNode, false, empty, empty);
    }

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<With> annotation, org.eclipse.jdt.internal.compiler.ast.Annotation ast, EclipseNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.WITH_FLAG_USAGE, "@With");
        EclipseNode node = annotationNode.up();
        AccessLevel level = annotation.getInstance().value();
        if (level == AccessLevel.NONE || node == null) {
            return;
        }
        List<org.eclipse.jdt.internal.compiler.ast.Annotation> onMethod = EclipseHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onMethod", "@With(onMethod", annotationNode);
        List<org.eclipse.jdt.internal.compiler.ast.Annotation> onParam = EclipseHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onParam", "@With(onParam", annotationNode);
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
                createWithForFields(level, annotationNode.upFromAnnotationToFields(), annotationNode, true, onMethod, onParam);
                break;
        }
    }

    public void createWithForFields(AccessLevel level, Collection<EclipseNode> fieldNodes, EclipseNode sourceNode, boolean whineIfExists, List<org.eclipse.jdt.internal.compiler.ast.Annotation> onMethod, List<org.eclipse.jdt.internal.compiler.ast.Annotation> onParam) {
        for (EclipseNode fieldNode : fieldNodes) {
            createWithForField(level, fieldNode, sourceNode, whineIfExists, onMethod, onParam);
        }
    }

    public void createWithForField(AccessLevel level, EclipseNode fieldNode, EclipseNode sourceNode, boolean whineIfExists, List<org.eclipse.jdt.internal.compiler.ast.Annotation> onMethod, List<org.eclipse.jdt.internal.compiler.ast.Annotation> onParam) {
        ASTNode source = sourceNode.get();
        if (fieldNode.getKind() != AST$Kind.FIELD) {
            sourceNode.addError("@With is only supported on a class or a field.");
            return;
        }
        EclipseNode typeNode = fieldNode.up();
        boolean makeAbstract = (typeNode == null || typeNode.getKind() != AST$Kind.TYPE || (typeNode.get().modifiers & 1024) == 0) ? false : true;
        FieldDeclaration field = fieldNode.get();
        TypeReference fieldType = EclipseHandlerUtil.copyType(field.type, source);
        boolean isBoolean = EclipseHandlerUtil.isBoolean(fieldType);
        String withName = EclipseHandlerUtil.toWithName(fieldNode, isBoolean);
        if (withName == null) {
            fieldNode.addWarning("Not generating a with method for this field: It does not fit your @Accessors prefix list.");
            return;
        }
        if ((field.modifiers & 8) != 0) {
            fieldNode.addWarning("Not generating " + withName + " for this field: With methods cannot be generated for static fields.");
            return;
        }
        if ((field.modifiers & 16) != 0 && field.initialization != null) {
            fieldNode.addWarning("Not generating " + withName + " for this field: With methods cannot be generated for final, initialized fields.");
            return;
        }
        if (field.name != null && field.name.length > 0 && field.name[0] == '$') {
            fieldNode.addWarning("Not generating " + withName + " for this field: With methods cannot be generated for fields starting with $.");
            return;
        }
        for (String altName : EclipseHandlerUtil.toAllWithNames(fieldNode, isBoolean)) {
            switch ($SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult()[EclipseHandlerUtil.methodExists(altName, fieldNode, false, 1).ordinal()]) {
                case 1:
                default:
                    break;
                case 2:
                    return;
                case 3:
                    if (whineIfExists) {
                        String altNameExpl = altName.equals(withName) ? "" : String.format(" (%s)", altName);
                        fieldNode.addWarning(String.format("Not generating %s(): A method with that name already exists%s", withName, altNameExpl));
                        return;
                    }
                    return;
            }
        }
        int modifier = EclipseHandlerUtil.toEclipseModifier(level);
        MethodDeclaration method = createWith((TypeDeclaration) fieldNode.up().get(), fieldNode, withName, modifier, sourceNode, onMethod, onParam, makeAbstract);
        EclipseHandlerUtil.injectMethod(fieldNode.up(), method);
    }

    public MethodDeclaration createWith(TypeDeclaration parent, EclipseNode fieldNode, String name, int modifier, EclipseNode sourceNode, List<org.eclipse.jdt.internal.compiler.ast.Annotation> onMethod, List<org.eclipse.jdt.internal.compiler.ast.Annotation> onParam, boolean makeAbstract) {
        Statement nullCheck;
        ASTNode source = sourceNode.get();
        if (name == null) {
            return null;
        }
        FieldDeclaration field = fieldNode.get();
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (((long) pS) << 32) | ((long) pE);
        MethodDeclaration method = new MethodDeclaration(parent.compilationResult);
        if (makeAbstract) {
            modifier = modifier | 1024 | 16777216;
        }
        method.modifiers = modifier;
        method.returnType = EclipseHandlerUtil.cloneSelfType(fieldNode, source);
        if (method.returnType == null) {
            return null;
        }
        org.eclipse.jdt.internal.compiler.ast.Annotation[] deprecated = EclipseHandlerUtil.isFieldDeprecated(fieldNode) ? new org.eclipse.jdt.internal.compiler.ast.Annotation[]{EclipseHandlerUtil.generateDeprecatedAnnotation(source)} : null;
        org.eclipse.jdt.internal.compiler.ast.Annotation[] checkerFramework = EclipseHandlerUtil.getCheckerFrameworkVersion(fieldNode).generateSideEffectFree() ? new org.eclipse.jdt.internal.compiler.ast.Annotation[]{EclipseHandlerUtil.generateNamedAnnotation(source, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE)} : null;
        method.annotations = EclipseHandlerUtil.copyAnnotations(source, (org.eclipse.jdt.internal.compiler.ast.Annotation[]) onMethod.toArray(new org.eclipse.jdt.internal.compiler.ast.Annotation[0]), checkerFramework, deprecated);
        Argument param = new Argument(field.name, p, EclipseHandlerUtil.copyType(field.type, source), 16);
        param.sourceStart = pS;
        param.sourceEnd = pE;
        method.arguments = new Argument[]{param};
        method.selector = name.toCharArray();
        method.binding = null;
        method.thrownExceptions = null;
        method.typeParameters = null;
        method.bits |= 8388608;
        org.eclipse.jdt.internal.compiler.ast.Annotation[] copyableAnnotations = EclipseHandlerUtil.findCopyableAnnotations(fieldNode);
        if (!makeAbstract) {
            List<Expression> args = new ArrayList<>();
            for (EclipseNode child : fieldNode.up().down()) {
                if (child.getKind() == AST$Kind.FIELD) {
                    FieldDeclaration childDecl = child.get();
                    if (childDecl.name == null || childDecl.name.length <= 0 || childDecl.name[0] != '$') {
                        long fieldFlags = childDecl.modifiers;
                        if ((fieldFlags & 8) == 0 && ((fieldFlags & 16) == 0 || childDecl.initialization == null)) {
                            if (child.get() == fieldNode.get()) {
                                args.add(new SingleNameReference(field.name, p));
                            } else {
                                args.add(EclipseHandlerUtil.createFieldAccessor(child, HandlerUtil$FieldAccess.ALWAYS_FIELD, source));
                            }
                        }
                    }
                }
            }
            AllocationExpression constructorCall = new AllocationExpression();
            constructorCall.arguments = (Expression[]) args.toArray(new Expression[0]);
            constructorCall.type = EclipseHandlerUtil.cloneSelfType(fieldNode, source);
            EqualExpression equalExpression = new EqualExpression(EclipseHandlerUtil.createFieldAccessor(fieldNode, HandlerUtil$FieldAccess.ALWAYS_FIELD, source), new SingleNameReference(field.name, p), 18);
            ThisReference thisRef = new ThisReference(pS, pE);
            ReturnStatement returnStatement = new ReturnStatement(new ConditionalExpression(equalExpression, thisRef, constructorCall), pS, pE);
            int i = source.sourceStart;
            method.sourceStart = i;
            method.declarationSourceStart = i;
            method.bodyStart = i;
            int i2 = source.sourceEnd;
            method.sourceEnd = i2;
            method.declarationSourceEnd = i2;
            method.bodyEnd = i2;
            List<Statement> statements = new ArrayList<>(5);
            if (EclipseHandlerUtil.hasNonNullAnnotations(fieldNode) && (nullCheck = EclipseHandlerUtil.generateNullCheck(field, sourceNode, null)) != null) {
                statements.add(nullCheck);
            }
            statements.add(returnStatement);
            method.statements = (Statement[]) statements.toArray(new Statement[0]);
        }
        param.annotations = EclipseHandlerUtil.copyAnnotations(source, copyableAnnotations, (org.eclipse.jdt.internal.compiler.ast.Annotation[]) onParam.toArray(new org.eclipse.jdt.internal.compiler.ast.Annotation[0]));
        EclipseHandlerUtil.createRelevantNonNullAnnotation(fieldNode, method);
        method.traverse(new SetGeneratedByVisitor(source), parent.scope);
        EclipseHandlerUtil.copyJavadoc(fieldNode, method, EclipseHandlerUtil$CopyJavadoc.WITH);
        return method;
    }
}
