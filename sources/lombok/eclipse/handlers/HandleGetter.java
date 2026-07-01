package lombok.eclipse.handlers;

import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.Getter;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.Eclipse;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.agent.PatchDelegate;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.experimental.Delegate;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.ArrayTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.ConditionalExpression;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.SynchronizedStatement;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleGetter.SCL.lombok */
public class HandleGetter extends EclipseAnnotationHandler<Getter> {
    private static final Annotation[] EMPTY_ANNOTATIONS_ARRAY = new Annotation[0];
    private static final char[][] AR = Eclipse.fromQualifiedName("java.util.concurrent.atomic.AtomicReference");
    public static final Map<String, char[][]> TYPE_MAP;
    private static char[] valueName;
    private static char[] actualValueName;
    private static final int PARENTHESIZED = 2097152;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult;

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

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult() {
        int[] iArr = $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[EclipseHandlerUtil.MemberExistsResult.valuesCustom().length];
        try {
            iArr2[EclipseHandlerUtil.MemberExistsResult.EXISTS_BY_LOMBOK.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[EclipseHandlerUtil.MemberExistsResult.EXISTS_BY_USER.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult = iArr2;
        return iArr2;
    }

    static {
        Map<String, char[][]> m = new HashMap<>();
        m.put("int", Eclipse.fromQualifiedName("java.lang.Integer"));
        m.put("double", Eclipse.fromQualifiedName("java.lang.Double"));
        m.put("float", Eclipse.fromQualifiedName("java.lang.Float"));
        m.put("short", Eclipse.fromQualifiedName("java.lang.Short"));
        m.put("byte", Eclipse.fromQualifiedName("java.lang.Byte"));
        m.put(Constants.LONG, Eclipse.fromQualifiedName("java.lang.Long"));
        m.put("boolean", Eclipse.fromQualifiedName("java.lang.Boolean"));
        m.put("char", Eclipse.fromQualifiedName("java.lang.Character"));
        TYPE_MAP = Collections.unmodifiableMap(m);
        valueName = "value".toCharArray();
        actualValueName = "actualValue".toCharArray();
    }

    public boolean generateGetterForType(EclipseNode typeNode, EclipseNode pos, AccessLevel level, boolean checkForTypeLevelGetter, List<Annotation> onMethod) {
        if (checkForTypeLevelGetter && EclipseHandlerUtil.hasAnnotation((Class<? extends java.lang.annotation.Annotation>) Getter.class, typeNode)) {
            return true;
        }
        TypeDeclaration typeDecl = typeNode.get() instanceof TypeDeclaration ? (TypeDeclaration) typeNode.get() : null;
        int modifiers = typeDecl == null ? 0 : typeDecl.modifiers;
        boolean notAClass = (modifiers & 8704) != 0;
        if (typeDecl == null || notAClass) {
            pos.addError("@Getter is only supported on a class, an enum, or a field.");
            return false;
        }
        for (EclipseNode field : typeNode.down()) {
            if (fieldQualifiesForGetterGeneration(field)) {
                generateGetterForField(field, pos.get(), level, false, onMethod);
            }
        }
        return true;
    }

    public static boolean fieldQualifiesForGetterGeneration(EclipseNode field) {
        if (field.getKind() != AST.Kind.FIELD) {
            return false;
        }
        FieldDeclaration fieldDecl = field.get();
        return EclipseHandlerUtil.filterField(fieldDecl);
    }

    public void generateGetterForField(EclipseNode fieldNode, ASTNode pos, AccessLevel level, boolean lazy, List<Annotation> onMethod) {
        if (EclipseHandlerUtil.hasAnnotation((Class<? extends java.lang.annotation.Annotation>) Getter.class, fieldNode)) {
            return;
        }
        createGetterForField(level, fieldNode, fieldNode, pos, false, lazy, onMethod);
    }

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<Getter> annotation, Annotation ast, EclipseNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.GETTER_FLAG_USAGE, "@Getter");
        EclipseNode node = annotationNode.up();
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
            List<Annotation> onMethod = EclipseHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onMethod", "@Getter(onMethod", annotationNode);
            switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
                case 2:
                    if (lazy) {
                        annotationNode.addError("'lazy' is not supported for @Getter on a type.");
                    }
                    generateGetterForType(node, annotationNode, level, false, onMethod);
                    break;
                case 3:
                    createGetterForFields(level, annotationNode.upFromAnnotationToFields(), annotationNode, annotationNode.get(), true, lazy, onMethod);
                    break;
            }
        }
    }

    public void createGetterForFields(AccessLevel level, Collection<EclipseNode> fieldNodes, EclipseNode errorNode, ASTNode source, boolean whineIfExists, boolean lazy, List<Annotation> onMethod) {
        for (EclipseNode fieldNode : fieldNodes) {
            createGetterForField(level, fieldNode, errorNode, source, whineIfExists, lazy, onMethod);
        }
    }

    public void createGetterForField(AccessLevel level, EclipseNode fieldNode, EclipseNode errorNode, ASTNode source, boolean whineIfExists, boolean lazy, List<Annotation> onMethod) {
        if (fieldNode.getKind() != AST.Kind.FIELD) {
            errorNode.addError("@Getter is only supported on a class or a field.");
            return;
        }
        FieldDeclaration field = fieldNode.get();
        if (lazy) {
            if ((field.modifiers & 2) == 0 || (field.modifiers & 16) == 0) {
                errorNode.addError("'lazy' requires the field to be private and final.");
                return;
            } else if ((field.modifiers & 128) != 0) {
                errorNode.addError("'lazy' is not supported on transient fields.");
                return;
            } else if (field.initialization == null) {
                errorNode.addError("'lazy' requires field initialization.");
                return;
            }
        }
        TypeReference fieldType = EclipseHandlerUtil.copyType(field.type, source);
        boolean isBoolean = EclipseHandlerUtil.isBoolean(fieldType);
        String getterName = EclipseHandlerUtil.toGetterName(fieldNode, isBoolean);
        if (getterName == null) {
            errorNode.addWarning("Not generating getter for this field: It does not fit your @Accessors prefix list.");
            return;
        }
        int modifier = EclipseHandlerUtil.toEclipseModifier(level) | (field.modifiers & 8);
        for (String altName : EclipseHandlerUtil.toAllGetterNames(fieldNode, isBoolean)) {
            switch ($SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult()[EclipseHandlerUtil.methodExists(altName, fieldNode, false, 0).ordinal()]) {
                case 1:
                default:
                    break;
                case 2:
                    return;
                case 3:
                    if (whineIfExists) {
                        String altNameExpl = altName.equals(getterName) ? "" : String.format(" (%s)", altName);
                        errorNode.addWarning(String.format("Not generating %s(): A method with that name already exists%s", getterName, altNameExpl));
                        return;
                    }
                    return;
            }
        }
        MethodDeclaration method = createGetter((TypeDeclaration) fieldNode.up().get(), fieldNode, getterName, modifier, source, lazy, onMethod);
        EclipseHandlerUtil.injectMethod(fieldNode.up(), method);
    }

    public static Annotation[] findDelegatesAndMarkAsHandled(EclipseNode fieldNode) {
        List<Annotation> delegates = new ArrayList<>();
        for (EclipseNode child : fieldNode.down()) {
            if (EclipseHandlerUtil.annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) Delegate.class, child)) {
                Annotation delegate = child.get();
                PatchDelegate.markHandled(delegate);
                delegates.add(delegate);
            }
        }
        return (Annotation[]) delegates.toArray(EMPTY_ANNOTATIONS_ARRAY);
    }

    public MethodDeclaration createGetter(TypeDeclaration parent, EclipseNode fieldNode, String name, int modifier, ASTNode source, boolean lazy, List<Annotation> onMethod) {
        Statement[] statements;
        TypeReference returnType = EclipseHandlerUtil.copyType(fieldNode.get().type, source);
        boolean addSuppressWarningsUnchecked = false;
        if (lazy) {
            statements = createLazyGetterBody(source, fieldNode);
            addSuppressWarningsUnchecked = true;
        } else {
            statements = createSimpleGetterBody(source, fieldNode);
        }
        MethodDeclaration method = new MethodDeclaration(parent.compilationResult);
        method.modifiers = modifier;
        method.returnType = returnType;
        method.annotations = null;
        method.arguments = null;
        method.selector = name.toCharArray();
        method.binding = null;
        method.thrownExceptions = null;
        method.typeParameters = null;
        method.bits |= 8388608;
        int i = source.sourceStart;
        method.sourceStart = i;
        method.declarationSourceStart = i;
        method.bodyStart = i;
        int i2 = source.sourceEnd;
        method.sourceEnd = i2;
        method.declarationSourceEnd = i2;
        method.bodyEnd = i2;
        method.statements = statements;
        EclipseHandlerUtil.registerCreatedLazyGetter(fieldNode.get(), method.selector, returnType);
        Annotation[] deprecated = null;
        Annotation[] checkerFramework = null;
        if (EclipseHandlerUtil.isFieldDeprecated(fieldNode)) {
            deprecated = new Annotation[]{EclipseHandlerUtil.generateDeprecatedAnnotation(source)};
        }
        if (fieldNode.isFinal()) {
            if (EclipseHandlerUtil.getCheckerFrameworkVersion(fieldNode).generatePure()) {
                checkerFramework = new Annotation[]{EclipseHandlerUtil.generateNamedAnnotation(source, CheckerFrameworkVersion.NAME__PURE)};
            }
        } else if (EclipseHandlerUtil.getCheckerFrameworkVersion(fieldNode).generateSideEffectFree()) {
            checkerFramework = new Annotation[]{EclipseHandlerUtil.generateNamedAnnotation(source, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE)};
        }
        method.annotations = EclipseHandlerUtil.copyAnnotations(source, (Annotation[]) onMethod.toArray(new Annotation[0]), EclipseHandlerUtil.findCopyableAnnotations(fieldNode), findDelegatesAndMarkAsHandled(fieldNode), checkerFramework, deprecated);
        if (addSuppressWarningsUnchecked) {
            List<Expression> suppressions = new ArrayList<>(2);
            if (!Boolean.FALSE.equals(fieldNode.getAst().readConfiguration(ConfigurationKeys.ADD_SUPPRESSWARNINGS_ANNOTATIONS))) {
                suppressions.add(new StringLiteral(EclipseHandlerUtil.ALL, 0, 0, 0));
            }
            suppressions.add(new StringLiteral(EclipseHandlerUtil.UNCHECKED, 0, 0, 0));
            ASTNode arrayInitializer = new ArrayInitializer();
            ((ArrayInitializer) arrayInitializer).expressions = (Expression[]) suppressions.toArray(new Expression[0]);
            method.annotations = EclipseHandlerUtil.addAnnotation(source, method.annotations, TypeConstants.JAVA_LANG_SUPPRESSWARNINGS, arrayInitializer);
        }
        method.traverse(new SetGeneratedByVisitor(source), parent.scope);
        EclipseHandlerUtil.copyJavadoc(fieldNode, method, EclipseHandlerUtil.CopyJavadoc.GETTER);
        return method;
    }

    public Statement[] createSimpleGetterBody(ASTNode source, EclipseNode fieldNode) {
        FieldDeclaration field = fieldNode.get();
        Expression fieldRef = EclipseHandlerUtil.createFieldAccessor(fieldNode, HandlerUtil.FieldAccess.ALWAYS_FIELD, source);
        Statement returnStatement = new ReturnStatement(fieldRef, field.sourceStart, field.sourceEnd);
        return new Statement[]{returnStatement};
    }

    public Statement[] createLazyGetterBody(ASTNode source, EclipseNode fieldNode) {
        char[][] newType;
        FieldDeclaration field = fieldNode.get();
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (((long) pS) << 32) | ((long) pE);
        TypeReference rawComponentType = EclipseHandlerUtil.copyType(field.type, source);
        QualifiedTypeReference qualifiedTypeReferenceCopyType = null;
        boolean isPrimitive = false;
        if ((field.type instanceof SingleTypeReference) && !(field.type instanceof ArrayTypeReference) && (newType = TYPE_MAP.get(new String(field.type.token))) != null) {
            qualifiedTypeReferenceCopyType = new QualifiedTypeReference(newType, Eclipse.poss(source, 3));
            isPrimitive = true;
        }
        if (qualifiedTypeReferenceCopyType == null) {
            qualifiedTypeReferenceCopyType = EclipseHandlerUtil.copyType(field.type, source);
        }
        ((TypeReference) qualifiedTypeReferenceCopyType).sourceStart = pS;
        ((TypeReference) qualifiedTypeReferenceCopyType).statementEnd = pE;
        ((TypeReference) qualifiedTypeReferenceCopyType).sourceEnd = pE;
        Statement[] statements = new Statement[3];
        LocalDeclaration valueDecl = new LocalDeclaration(valueName, pS, pE);
        valueDecl.type = new QualifiedTypeReference(TypeConstants.JAVA_LANG_OBJECT, Eclipse.poss(source, 3));
        valueDecl.type.sourceStart = pS;
        TypeReference typeReference = valueDecl.type;
        valueDecl.type.statementEnd = pE;
        typeReference.sourceEnd = pE;
        MessageSend getter = new MessageSend();
        getter.sourceStart = pS;
        getter.sourceEnd = pE;
        getter.statementEnd = pE;
        getter.selector = new char[]{'g', 'e', 't'};
        getter.receiver = EclipseHandlerUtil.createFieldAccessor(fieldNode, HandlerUtil.FieldAccess.ALWAYS_FIELD, source);
        valueDecl.initialization = getter;
        statements[0] = valueDecl;
        EqualExpression cond = new EqualExpression(new SingleNameReference(valueName, p), new NullLiteral(pS, pE), 18);
        Block then = new Block(0);
        Expression lock = EclipseHandlerUtil.createFieldAccessor(fieldNode, HandlerUtil.FieldAccess.ALWAYS_FIELD, source);
        Block inner = new Block(0);
        inner.statements = new Statement[2];
        MessageSend getter2 = new MessageSend();
        getter2.sourceStart = pS;
        getter2.statementEnd = pE;
        getter2.sourceEnd = pE;
        getter2.selector = new char[]{'g', 'e', 't'};
        getter2.receiver = EclipseHandlerUtil.createFieldAccessor(fieldNode, HandlerUtil.FieldAccess.ALWAYS_FIELD, source);
        Statement assignment = new Assignment(new SingleNameReference(valueName, p), getter2, pE);
        ((Assignment) assignment).sourceStart = pS;
        ((Assignment) assignment).sourceEnd = pE;
        ((Assignment) assignment).statementEnd = pE;
        inner.statements[0] = assignment;
        EqualExpression innerCond = new EqualExpression(new SingleNameReference(valueName, p), new NullLiteral(pS, pE), 18);
        innerCond.sourceStart = pS;
        innerCond.statementEnd = pE;
        innerCond.sourceEnd = pE;
        Block innerThen = new Block(0);
        innerThen.statements = new Statement[3];
        Statement localDeclaration = new LocalDeclaration(actualValueName, pS, pE);
        ((LocalDeclaration) localDeclaration).type = rawComponentType;
        ((LocalDeclaration) localDeclaration).type.sourceStart = pS;
        TypeReference typeReference2 = ((LocalDeclaration) localDeclaration).type;
        ((LocalDeclaration) localDeclaration).type.statementEnd = pE;
        typeReference2.sourceEnd = pE;
        ((LocalDeclaration) localDeclaration).initialization = field.initialization;
        ((LocalDeclaration) localDeclaration).modifiers = 16;
        innerThen.statements[0] = localDeclaration;
        if (isPrimitive) {
            Statement assignment2 = new Assignment(new SingleNameReference(valueName, p), new SingleNameReference(actualValueName, p), pE);
            ((Assignment) assignment2).sourceStart = pS;
            ((Assignment) assignment2).sourceEnd = pE;
            ((Assignment) assignment2).statementEnd = pE;
            innerThen.statements[1] = assignment2;
        }
        if (!isPrimitive) {
            EqualExpression avIsNull = new EqualExpression(new SingleNameReference(actualValueName, p), new NullLiteral(pS, pE), 18);
            avIsNull.sourceStart = pS;
            avIsNull.statementEnd = pE;
            avIsNull.sourceEnd = pE;
            Expression fieldRef = EclipseHandlerUtil.createFieldAccessor(fieldNode, HandlerUtil.FieldAccess.ALWAYS_FIELD, source);
            ConditionalExpression ternary = new ConditionalExpression(avIsNull, fieldRef, new SingleNameReference(actualValueName, p));
            ternary.sourceStart = pS;
            ternary.statementEnd = pE;
            ternary.sourceEnd = pE;
            Statement assignment3 = new Assignment(new SingleNameReference(valueName, p), ternary, pE);
            ((Assignment) assignment3).sourceStart = pS;
            ((Assignment) assignment3).sourceEnd = pE;
            ((Assignment) assignment3).statementEnd = pE;
            innerThen.statements[1] = assignment3;
        }
        Statement messageSend = new MessageSend();
        ((MessageSend) messageSend).sourceStart = pS;
        ((MessageSend) messageSend).statementEnd = pE;
        ((MessageSend) messageSend).sourceEnd = pE;
        ((MessageSend) messageSend).receiver = EclipseHandlerUtil.createFieldAccessor(fieldNode, HandlerUtil.FieldAccess.ALWAYS_FIELD, source);
        ((MessageSend) messageSend).selector = new char[]{'s', 'e', 't'};
        ((MessageSend) messageSend).arguments = new Expression[]{new SingleNameReference(valueName, p)};
        innerThen.statements[2] = messageSend;
        inner.statements[1] = new IfStatement(innerCond, innerThen, pS, pE);
        then.statements = new Statement[]{new SynchronizedStatement(lock, inner, pS, pE)};
        IfStatement ifStatement = new IfStatement(cond, then, pS, pE);
        statements[1] = ifStatement;
        if (isPrimitive) {
            CastExpression cast = EclipseHandlerUtil.makeCastExpression(new SingleNameReference(valueName, p), qualifiedTypeReferenceCopyType, source);
            statements[2] = new ReturnStatement(cast, pS, pE);
        }
        if (!isPrimitive) {
            EqualExpression vIsThisFieldName = new EqualExpression(new SingleNameReference(valueName, p), EclipseHandlerUtil.createFieldAccessor(fieldNode, HandlerUtil.FieldAccess.ALWAYS_FIELD, source), 18);
            vIsThisFieldName.sourceStart = pS;
            vIsThisFieldName.statementEnd = pE;
            vIsThisFieldName.sourceEnd = pE;
            ConditionalExpression ternary2 = new ConditionalExpression(vIsThisFieldName, new NullLiteral(pS, pE), new SingleNameReference(valueName, p));
            ternary2.sourceStart = pS;
            ternary2.statementEnd = pE;
            ternary2.sourceEnd = pE;
            ternary2.bits |= 2097152;
            CastExpression cast2 = EclipseHandlerUtil.makeCastExpression(ternary2, qualifiedTypeReferenceCopyType, source);
            statements[2] = new ReturnStatement(cast2, pS, pE);
        }
        TypeReference innerType = new QualifiedTypeReference(TypeConstants.JAVA_LANG_OBJECT, Eclipse.poss(source, 3));
        TypeReference[][] typeParams = new TypeReference[5][];
        typeParams[4] = new TypeReference[]{innerType};
        ParameterizedQualifiedTypeReference parameterizedQualifiedTypeReference = new ParameterizedQualifiedTypeReference(AR, typeParams, 0, Eclipse.poss(source, 5));
        ((TypeReference) parameterizedQualifiedTypeReference).sourceStart = -1;
        ((TypeReference) parameterizedQualifiedTypeReference).sourceEnd = -2;
        field.type = parameterizedQualifiedTypeReference;
        AllocationExpression init = new AllocationExpression();
        init.sourceStart = field.initialization.sourceStart;
        int i = field.initialization.sourceEnd;
        init.statementEnd = i;
        init.sourceEnd = i;
        init.type = EclipseHandlerUtil.copyType(parameterizedQualifiedTypeReference, source);
        field.initialization = init;
        return statements;
    }
}
