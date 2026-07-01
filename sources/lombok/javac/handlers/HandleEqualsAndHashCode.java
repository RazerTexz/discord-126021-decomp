package lombok.javac.handlers;

import com.discord.api.permission.Permission;
import com.sun.tools.javac.code.BoundKind;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCArrayTypeTree;
import com.sun.tools.javac.tree.JCTree$JCBinary;
import com.sun.tools.javac.tree.JCTree$JCBlock;
import com.sun.tools.javac.tree.JCTree$JCClassDecl;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.tree.JCTree$JCExpressionStatement;
import com.sun.tools.javac.tree.JCTree$JCFieldAccess;
import com.sun.tools.javac.tree.JCTree$JCIdent;
import com.sun.tools.javac.tree.JCTree$JCMethodDecl;
import com.sun.tools.javac.tree.JCTree$JCMethodInvocation;
import com.sun.tools.javac.tree.JCTree$JCModifiers;
import com.sun.tools.javac.tree.JCTree$JCPrimitiveTypeTree;
import com.sun.tools.javac.tree.JCTree$JCStatement;
import com.sun.tools.javac.tree.JCTree$JCUnary;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.lang.model.type.TypeKind;
import lombok.ConfigurationKeys;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode$CacheStrategy;
import lombok.EqualsAndHashCode$Include;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.configuration.CallSuperType;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.HandlerUtil$FieldAccess;
import lombok.core.handlers.InclusionExclusionUtils;
import lombok.core.handlers.InclusionExclusionUtils$Included;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleEqualsAndHashCode.SCL.lombok */
public class HandleEqualsAndHashCode extends JavacAnnotationHandler<EqualsAndHashCode> {
    private static final String RESULT_NAME = "result";
    private static final String PRIME_NAME = "PRIME";
    private static final String HASH_CODE_CACHE_NAME = "$hashCodeCache";
    private boolean jcAnnotatedTypeInit;
    private Class<?> jcAnnotatedTypeClass = null;
    private Field jcAnnotatedTypeUnderlyingTypeField = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$configuration$CallSuperType;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult;
    private static /* synthetic */ int[] $SWITCH_TABLE$javax$lang$model$type$TypeKind;

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$configuration$CallSuperType() {
        int[] iArr = $SWITCH_TABLE$lombok$core$configuration$CallSuperType;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[CallSuperType.valuesCustom().length];
        try {
            iArr2[CallSuperType.CALL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[CallSuperType.SKIP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[CallSuperType.WARN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$lombok$core$configuration$CallSuperType = iArr2;
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

    static /* synthetic */ int[] $SWITCH_TABLE$javax$lang$model$type$TypeKind() {
        int[] iArr = $SWITCH_TABLE$javax$lang$model$type$TypeKind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[TypeKind.values().length];
        try {
            iArr2[TypeKind.ARRAY.ordinal()] = 12;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[TypeKind.BOOLEAN.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[TypeKind.BYTE.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[TypeKind.CHAR.ordinal()] = 6;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[TypeKind.DECLARED.ordinal()] = 13;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[TypeKind.DOUBLE.ordinal()] = 8;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[TypeKind.ERROR.ordinal()] = 14;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[TypeKind.EXECUTABLE.ordinal()] = 18;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[TypeKind.FLOAT.ordinal()] = 7;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[TypeKind.INT.ordinal()] = 4;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[TypeKind.LONG.ordinal()] = 5;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[TypeKind.NONE.ordinal()] = 10;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr2[TypeKind.NULL.ordinal()] = 11;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr2[TypeKind.OTHER.ordinal()] = 19;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            iArr2[TypeKind.PACKAGE.ordinal()] = 17;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            iArr2[TypeKind.SHORT.ordinal()] = 3;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            iArr2[TypeKind.TYPEVAR.ordinal()] = 15;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            iArr2[TypeKind.VOID.ordinal()] = 9;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            iArr2[TypeKind.WILDCARD.ordinal()] = 16;
        } catch (NoSuchFieldError unused19) {
        }
        $SWITCH_TABLE$javax$lang$model$type$TypeKind = iArr2;
        return iArr2;
    }

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<EqualsAndHashCode> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.EQUALS_AND_HASH_CODE_FLAG_USAGE, "@EqualsAndHashCode");
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) EqualsAndHashCode.class);
        JavacHandlerUtil.deleteImportFromCompilationUnit(annotationNode, EqualsAndHashCode$CacheStrategy.class.getName());
        EqualsAndHashCode ann = annotation.getInstance();
        List<InclusionExclusionUtils$Included<JavacNode, EqualsAndHashCode$Include>> members = InclusionExclusionUtils.handleEqualsAndHashCodeMarking(annotationNode.up(), annotation, annotationNode);
        JavacNode typeNode = annotationNode.up();
        com.sun.tools.javac.util.List<JCTree$JCAnnotation> onParam = JavacHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onParam", "@EqualsAndHashCode(onParam", annotationNode);
        Boolean callSuper = Boolean.valueOf(ann.callSuper());
        if (!annotation.isExplicit("callSuper")) {
            callSuper = null;
        }
        Boolean doNotUseGettersConfiguration = (Boolean) annotationNode.getAst().readConfiguration(ConfigurationKeys.EQUALS_AND_HASH_CODE_DO_NOT_USE_GETTERS);
        boolean doNotUseGetters = (annotation.isExplicit("doNotUseGetters") || doNotUseGettersConfiguration == null) ? ann.doNotUseGetters() : doNotUseGettersConfiguration.booleanValue();
        HandlerUtil$FieldAccess fieldAccess = doNotUseGetters ? HandlerUtil$FieldAccess.PREFER_FIELD : HandlerUtil$FieldAccess.GETTER;
        boolean cacheHashCode = ann.cacheStrategy() == EqualsAndHashCode$CacheStrategy.LAZY;
        generateMethods(typeNode, annotationNode, members, callSuper, true, cacheHashCode, fieldAccess, onParam);
    }

    public void generateEqualsAndHashCodeForType(JavacNode typeNode, JavacNode source) {
        if (JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) EqualsAndHashCode.class, typeNode)) {
            return;
        }
        Boolean doNotUseGettersConfiguration = (Boolean) typeNode.getAst().readConfiguration(ConfigurationKeys.EQUALS_AND_HASH_CODE_DO_NOT_USE_GETTERS);
        HandlerUtil$FieldAccess access = (doNotUseGettersConfiguration == null || !doNotUseGettersConfiguration.booleanValue()) ? HandlerUtil$FieldAccess.GETTER : HandlerUtil$FieldAccess.PREFER_FIELD;
        List<InclusionExclusionUtils$Included<JavacNode, EqualsAndHashCode$Include>> members = InclusionExclusionUtils.handleEqualsAndHashCodeMarking(typeNode, null, null);
        generateMethods(typeNode, source, members, null, false, false, access, com.sun.tools.javac.util.List.nil());
    }

    public void generateMethods(JavacNode typeNode, JavacNode source, List<InclusionExclusionUtils$Included<JavacNode, EqualsAndHashCode$Include>> members, Boolean callSuper, boolean whineIfExists, boolean cacheHashCode, HandlerUtil$FieldAccess fieldAccess, com.sun.tools.javac.util.List<JCTree$JCAnnotation> onParam) {
        boolean notAClass = true;
        if (typeNode.get() instanceof JCTree$JCClassDecl) {
            long flags = typeNode.get().mods.flags;
            notAClass = (flags & 25088) != 0;
        }
        if (notAClass) {
            source.addError("@EqualsAndHashCode is only supported on a class.");
            return;
        }
        boolean implicitCallSuper = callSuper == null;
        if (callSuper == null) {
            try {
                callSuper = Boolean.valueOf(((Boolean) EqualsAndHashCode.class.getMethod("callSuper", new Class[0]).getDefaultValue()).booleanValue());
            } catch (Exception unused) {
                throw new InternalError("Lombok bug - this cannot happen - can't find callSuper field in EqualsAndHashCode annotation.");
            }
        }
        boolean isDirectDescendantOfObject = JavacHandlerUtil.isDirectDescendantOfObject(typeNode);
        if (isDirectDescendantOfObject && callSuper.booleanValue()) {
            source.addError("Generating equals/hashCode with a supercall to java.lang.Object is pointless.");
            return;
        }
        if (implicitCallSuper && !isDirectDescendantOfObject) {
            CallSuperType cst = (CallSuperType) typeNode.getAst().readConfiguration(ConfigurationKeys.EQUALS_AND_HASH_CODE_CALL_SUPER);
            if (cst == null) {
                cst = CallSuperType.WARN;
            }
            switch ($SWITCH_TABLE$lombok$core$configuration$CallSuperType()[cst.ordinal()]) {
                case 1:
                    callSuper = true;
                    break;
                case 2:
                    callSuper = false;
                    break;
                case 3:
                default:
                    source.addWarning("Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.");
                    callSuper = false;
                    break;
            }
        }
        boolean isFinal = (typeNode.get().mods.flags & 16) != 0;
        boolean needsCanEqual = (isFinal && isDirectDescendantOfObject) ? false : true;
        JavacHandlerUtil$MemberExistsResult equalsExists = JavacHandlerUtil.methodExists("equals", typeNode, 1);
        JavacHandlerUtil$MemberExistsResult hashCodeExists = JavacHandlerUtil.methodExists("hashCode", typeNode, 0);
        JavacHandlerUtil$MemberExistsResult canEqualExists = JavacHandlerUtil.methodExists("canEqual", typeNode, 1);
        switch ($SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult()[((JavacHandlerUtil$MemberExistsResult) Collections.max(Arrays.asList(equalsExists, hashCodeExists))).ordinal()]) {
            case 1:
            default:
                JCTree$JCMethodDecl equalsMethod = createEquals(typeNode, members, callSuper.booleanValue(), fieldAccess, needsCanEqual, source.get(), onParam);
                JavacHandlerUtil.injectMethod(typeNode, equalsMethod);
                if (needsCanEqual && canEqualExists == JavacHandlerUtil$MemberExistsResult.NOT_EXISTS) {
                    JCTree$JCMethodDecl canEqualMethod = createCanEqual(typeNode, source.get(), onParam);
                    JavacHandlerUtil.injectMethod(typeNode, canEqualMethod);
                }
                if (cacheHashCode) {
                    if (JavacHandlerUtil.fieldExists(HASH_CODE_CACHE_NAME, typeNode) != JavacHandlerUtil$MemberExistsResult.NOT_EXISTS) {
                        String msg = String.format("Not caching the result of hashCode: A field named %s already exists.", HASH_CODE_CACHE_NAME);
                        source.addWarning(msg);
                        cacheHashCode = false;
                    } else {
                        createHashCodeCacheField(typeNode, source.get());
                    }
                }
                JCTree$JCMethodDecl hashCodeMethod = createHashCode(typeNode, members, callSuper.booleanValue(), cacheHashCode, fieldAccess, source.get());
                JavacHandlerUtil.injectMethod(typeNode, hashCodeMethod);
                return;
            case 2:
                return;
            case 3:
                if (whineIfExists) {
                    source.addWarning("Not generating equals and hashCode: A method with one of those names already exists. (Either both or none of these methods will be generated).");
                    return;
                }
                if (equalsExists == JavacHandlerUtil$MemberExistsResult.NOT_EXISTS || hashCodeExists == JavacHandlerUtil$MemberExistsResult.NOT_EXISTS) {
                    Object[] objArr = new Object[1];
                    objArr[0] = equalsExists == JavacHandlerUtil$MemberExistsResult.NOT_EXISTS ? "equals" : "hashCode";
                    String msg2 = String.format("Not generating %s: One of equals or hashCode exists. You should either write both of these or none of these (in the latter case, lombok generates them).", objArr);
                    source.addWarning(msg2);
                    return;
                }
                return;
        }
    }

    private void createHashCodeCacheField(JavacNode typeNode, JCTree source) {
        JavacTreeMaker maker = typeNode.getTreeMaker();
        JCTree$JCModifiers mods = maker.Modifiers(130L);
        JCTree$JCVariableDecl hashCodeCacheField = maker.VarDef(mods, typeNode.toName(HASH_CODE_CACHE_NAME), maker.TypeIdent(Javac.CTC_INT), null);
        JavacHandlerUtil.injectFieldAndMarkGenerated(typeNode, hashCodeCacheField);
        JavacHandlerUtil.recursiveSetGeneratedBy(hashCodeCacheField, source, typeNode.getContext());
    }

    public JCTree$JCMethodDecl createHashCode(JavacNode typeNode, List<InclusionExclusionUtils$Included<JavacNode, EqualsAndHashCode$Include>> members, boolean callSuper, boolean cacheHashCode, HandlerUtil$FieldAccess fieldAccess, JCTree source) {
        JCTree$JCMethodInvocation jCTree$JCMethodInvocationLiteral;
        JavacTreeMaker maker = typeNode.getTreeMaker();
        JCTree$JCAnnotation overrideAnnotation = maker.Annotation(JavacHandlerUtil.genJavaLangTypeRef(typeNode, "Override"), com.sun.tools.javac.util.List.nil());
        com.sun.tools.javac.util.List<JCTree$JCAnnotation> annsOnMethod = com.sun.tools.javac.util.List.of(overrideAnnotation);
        CheckerFrameworkVersion checkerFramework = JavacHandlerUtil.getCheckerFrameworkVersion(typeNode);
        if (cacheHashCode && checkerFramework.generatePure()) {
            annsOnMethod = annsOnMethod.prepend(maker.Annotation(JavacHandlerUtil.genTypeRef(typeNode, CheckerFrameworkVersion.NAME__PURE), com.sun.tools.javac.util.List.nil()));
        } else if (checkerFramework.generateSideEffectFree()) {
            annsOnMethod = annsOnMethod.prepend(maker.Annotation(JavacHandlerUtil.genTypeRef(typeNode, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE), com.sun.tools.javac.util.List.nil()));
        }
        JCTree$JCModifiers mods = maker.Modifiers(1L, annsOnMethod);
        JCTree$JCPrimitiveTypeTree jCTree$JCPrimitiveTypeTreeTypeIdent = maker.TypeIdent(Javac.CTC_INT);
        ListBuffer<JCTree$JCStatement> statements = new ListBuffer<>();
        Name primeName = typeNode.toName(PRIME_NAME);
        Name resultName = typeNode.toName(RESULT_NAME);
        long finalFlag = JavacHandlerUtil.addFinalIfNeeded(0L, typeNode.getContext());
        boolean isEmpty = members.isEmpty();
        if (cacheHashCode) {
            JCTree$JCIdent receiver = maker.Ident(typeNode.toName("this"));
            JCTree$JCFieldAccess cacheHashCodeFieldAccess = maker.Select(receiver, typeNode.toName(HASH_CODE_CACHE_NAME));
            statements.append(maker.If(maker.Binary(Javac.CTC_NOT_EQUAL, cacheHashCodeFieldAccess, maker.Literal(Javac.CTC_INT, 0)), maker.Return(cacheHashCodeFieldAccess), null));
        }
        if (!isEmpty) {
            statements.append(maker.VarDef(maker.Modifiers(finalFlag), primeName, maker.TypeIdent(Javac.CTC_INT), maker.Literal(Integer.valueOf(HandlerUtil.primeForHashcode()))));
        }
        if (callSuper) {
            jCTree$JCMethodInvocationLiteral = maker.Apply(com.sun.tools.javac.util.List.nil(), maker.Select(maker.Ident(typeNode.toName("super")), typeNode.toName("hashCode")), com.sun.tools.javac.util.List.nil());
        } else {
            jCTree$JCMethodInvocationLiteral = maker.Literal(1);
        }
        statements.append(maker.VarDef(maker.Modifiers((!isEmpty || cacheHashCode) ? 0L : finalFlag), resultName, maker.TypeIdent(Javac.CTC_INT), jCTree$JCMethodInvocationLiteral));
        for (InclusionExclusionUtils$Included<JavacNode, EqualsAndHashCode$Include> member : members) {
            JavacNode memberNode = member.getNode();
            JCTree$JCArrayTypeTree jCTree$JCArrayTypeTreeUnnotate = unnotate(JavacHandlerUtil.getFieldType(memberNode, fieldAccess));
            boolean isMethod = memberNode.getKind() == AST$Kind.METHOD;
            JCTree$JCExpression fieldAccessor = isMethod ? JavacHandlerUtil.createMethodAccessor(maker, memberNode) : JavacHandlerUtil.createFieldAccessor(maker, memberNode, fieldAccess);
            if (jCTree$JCArrayTypeTreeUnnotate instanceof JCTree$JCPrimitiveTypeTree) {
                switch ($SWITCH_TABLE$javax$lang$model$type$TypeKind()[((JCTree$JCPrimitiveTypeTree) jCTree$JCArrayTypeTreeUnnotate).getPrimitiveTypeKind().ordinal()]) {
                    case 1:
                        statements.append(createResultCalculation(typeNode, maker.Parens(maker.Conditional(fieldAccessor, maker.Literal(Integer.valueOf(HandlerUtil.primeForTrue())), maker.Literal(Integer.valueOf(HandlerUtil.primeForFalse()))))));
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 6:
                    default:
                        statements.append(createResultCalculation(typeNode, fieldAccessor));
                        break;
                    case 5:
                        Name dollarFieldName = memberNode.toName(String.valueOf(isMethod ? "$$" : "$") + memberNode.getName());
                        statements.append(maker.VarDef(maker.Modifiers(finalFlag), dollarFieldName, maker.TypeIdent(Javac.CTC_LONG), fieldAccessor));
                        statements.append(createResultCalculation(typeNode, longToIntForHashCode(maker, maker.Ident(dollarFieldName), maker.Ident(dollarFieldName))));
                        break;
                    case 7:
                        statements.append(createResultCalculation(typeNode, maker.Apply(com.sun.tools.javac.util.List.nil(), JavacHandlerUtil.genJavaLangTypeRef(typeNode, "Float", "floatToIntBits"), com.sun.tools.javac.util.List.of(fieldAccessor))));
                        break;
                    case 8:
                        Name dollarFieldName2 = memberNode.toName(String.valueOf(isMethod ? "$$" : "$") + memberNode.getName());
                        statements.append(maker.VarDef(maker.Modifiers(finalFlag), dollarFieldName2, maker.TypeIdent(Javac.CTC_LONG), maker.Apply(com.sun.tools.javac.util.List.nil(), JavacHandlerUtil.genJavaLangTypeRef(typeNode, "Double", "doubleToLongBits"), com.sun.tools.javac.util.List.of(fieldAccessor))));
                        statements.append(createResultCalculation(typeNode, longToIntForHashCode(maker, maker.Ident(dollarFieldName2), maker.Ident(dollarFieldName2))));
                        break;
                }
            } else if (jCTree$JCArrayTypeTreeUnnotate instanceof JCTree$JCArrayTypeTree) {
                JCTree$JCArrayTypeTree array = jCTree$JCArrayTypeTreeUnnotate;
                boolean multiDim = unnotate(array.elemtype) instanceof JCTree$JCArrayTypeTree;
                boolean primitiveArray = unnotate(array.elemtype) instanceof JCTree$JCPrimitiveTypeTree;
                boolean useDeepHC = multiDim || !primitiveArray;
                String[] strArr = new String[2];
                strArr[0] = "Arrays";
                strArr[1] = useDeepHC ? "deepHashCode" : "hashCode";
                JCTree$JCExpression hcMethod = JavacHandlerUtil.chainDots(typeNode, "java", "util", strArr);
                statements.append(createResultCalculation(typeNode, maker.Apply(com.sun.tools.javac.util.List.nil(), hcMethod, com.sun.tools.javac.util.List.of(fieldAccessor))));
            } else {
                Name dollarFieldName3 = memberNode.toName(String.valueOf(isMethod ? "$$" : "$") + memberNode.getName());
                statements.append(maker.VarDef(maker.Modifiers(finalFlag), dollarFieldName3, JavacHandlerUtil.genJavaLangTypeRef(typeNode, "Object"), fieldAccessor));
                statements.append(createResultCalculation(typeNode, maker.Parens(maker.Conditional(maker.Binary(Javac.CTC_EQUAL, maker.Ident(dollarFieldName3), maker.Literal(Javac.CTC_BOT, null)), maker.Literal(Integer.valueOf(HandlerUtil.primeForNull())), maker.Apply(com.sun.tools.javac.util.List.nil(), maker.Select(maker.Ident(dollarFieldName3), typeNode.toName("hashCode")), com.sun.tools.javac.util.List.nil())))));
            }
        }
        if (cacheHashCode) {
            statements.append(maker.If(maker.Binary(Javac.CTC_EQUAL, maker.Ident(resultName), maker.Literal(Javac.CTC_INT, 0)), maker.Exec(maker.Assign(maker.Ident(resultName), JavacHandlerUtil.genJavaLangTypeRef(typeNode, "Integer", "MIN_VALUE"))), null));
            statements.append(maker.Exec(maker.Assign(maker.Select(maker.Ident(typeNode.toName("this")), typeNode.toName(HASH_CODE_CACHE_NAME)), maker.Ident(resultName))));
        }
        statements.append(maker.Return(maker.Ident(resultName)));
        JCTree$JCBlock body = maker.Block(0L, statements.toList());
        return JavacHandlerUtil.recursiveSetGeneratedBy(maker.MethodDef(mods, typeNode.toName("hashCode"), jCTree$JCPrimitiveTypeTreeTypeIdent, com.sun.tools.javac.util.List.nil(), com.sun.tools.javac.util.List.nil(), com.sun.tools.javac.util.List.nil(), body, null), source, typeNode.getContext());
    }

    public JCTree$JCExpressionStatement createResultCalculation(JavacNode typeNode, JCTree$JCExpression expr) {
        JavacTreeMaker maker = typeNode.getTreeMaker();
        Name resultName = typeNode.toName(RESULT_NAME);
        return maker.Exec(maker.Assign(maker.Ident(resultName), maker.Binary(Javac.CTC_PLUS, maker.Binary(Javac.CTC_MUL, maker.Ident(resultName), maker.Ident(typeNode.toName(PRIME_NAME))), expr)));
    }

    public JCTree$JCExpression longToIntForHashCode(JavacTreeMaker maker, JCTree$JCExpression ref1, JCTree$JCExpression ref2) {
        return maker.TypeCast(maker.TypeIdent(Javac.CTC_INT), maker.Parens(maker.Binary(Javac.CTC_BITXOR, maker.Binary(Javac.CTC_UNSIGNED_SHIFT_RIGHT, ref1, maker.Literal(32)), ref2)));
    }

    public JCTree$JCExpression createTypeReference(JavacNode type, boolean addWildcards) {
        List<String> list = new ArrayList<>();
        List<Integer> genericsCount = addWildcards ? new ArrayList<>() : null;
        list.add(type.getName());
        if (addWildcards) {
            genericsCount.add(Integer.valueOf(type.get().typarams.size()));
        }
        boolean staticContext = (type.get().getModifiers().flags & 8) != 0;
        JavacNode javacNodeUp = type.up();
        while (true) {
            JavacNode tNode = javacNodeUp;
            if (tNode == null || tNode.getKind() != AST$Kind.TYPE) {
                break;
            }
            list.add(tNode.getName());
            if (addWildcards) {
                genericsCount.add(Integer.valueOf(staticContext ? 0 : tNode.get().typarams.size()));
            }
            if (!staticContext) {
                staticContext = (tNode.get().getModifiers().flags & 8) != 0;
            }
            javacNodeUp = tNode.up();
        }
        Collections.reverse(list);
        if (addWildcards) {
            Collections.reverse(genericsCount);
        }
        JavacTreeMaker maker = type.getTreeMaker();
        JCTree$JCExpression chain = maker.Ident(type.toName(list.get(0)));
        if (addWildcards) {
            chain = wildcardify(maker, chain, genericsCount.get(0).intValue());
        }
        for (int i = 1; i < list.size(); i++) {
            chain = maker.Select(chain, type.toName(list.get(i)));
            if (addWildcards) {
                chain = wildcardify(maker, chain, genericsCount.get(i).intValue());
            }
        }
        return chain;
    }

    private JCTree$JCExpression wildcardify(JavacTreeMaker maker, JCTree$JCExpression expr, int count) {
        if (count == 0) {
            return expr;
        }
        ListBuffer<JCTree$JCExpression> wildcards = new ListBuffer<>();
        for (int i = 0; i < count; i++) {
            wildcards.append(maker.Wildcard(maker.TypeBoundKind(BoundKind.UNBOUND), null));
        }
        return maker.TypeApply(expr, wildcards.toList());
    }

    public JCTree$JCMethodDecl createEquals(JavacNode typeNode, List<InclusionExclusionUtils$Included<JavacNode, EqualsAndHashCode$Include>> members, boolean callSuper, HandlerUtil$FieldAccess fieldAccess, boolean needsCanEqual, JCTree source, com.sun.tools.javac.util.List<JCTree$JCAnnotation> onParam) {
        JCTree$JCExpression objectType;
        JavacTreeMaker maker = typeNode.getTreeMaker();
        Name oName = typeNode.toName("o");
        Name otherName = typeNode.toName("other");
        Name thisName = typeNode.toName("this");
        com.sun.tools.javac.util.List<JCTree$JCAnnotation> annsOnParamOnMethod = com.sun.tools.javac.util.List.nil();
        JCTree$JCAnnotation overrideAnnotation = maker.Annotation(JavacHandlerUtil.genJavaLangTypeRef(typeNode, "Override"), com.sun.tools.javac.util.List.nil());
        com.sun.tools.javac.util.List<JCTree$JCAnnotation> annsOnMethod = com.sun.tools.javac.util.List.of(overrideAnnotation);
        CheckerFrameworkVersion checkerFramework = JavacHandlerUtil.getCheckerFrameworkVersion(typeNode);
        if (checkerFramework.generateSideEffectFree()) {
            annsOnMethod = annsOnMethod.prepend(maker.Annotation(JavacHandlerUtil.genTypeRef(typeNode, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE), com.sun.tools.javac.util.List.nil()));
        }
        JCTree$JCModifiers mods = maker.Modifiers(1L, annsOnMethod);
        if (annsOnParamOnMethod.isEmpty()) {
            objectType = JavacHandlerUtil.genJavaLangTypeRef(typeNode, "Object");
        } else {
            JCTree$JCExpression objectType2 = JavacHandlerUtil.chainDots(typeNode, "java", "lang", "Object");
            objectType = maker.AnnotatedType(annsOnParamOnMethod, objectType2);
        }
        JCTree$JCPrimitiveTypeTree jCTree$JCPrimitiveTypeTreeTypeIdent = maker.TypeIdent(Javac.CTC_BOOLEAN);
        long finalFlag = JavacHandlerUtil.addFinalIfNeeded(0L, typeNode.getContext());
        ListBuffer<JCTree$JCStatement> statements = new ListBuffer<>();
        JCTree$JCVariableDecl param = maker.VarDef(maker.Modifiers(finalFlag | Permission.MANAGE_EVENTS, onParam), oName, objectType, null);
        JavacHandlerUtil.createRelevantNullableAnnotation(typeNode, param);
        com.sun.tools.javac.util.List<JCTree$JCVariableDecl> params = com.sun.tools.javac.util.List.of(param);
        statements.append(maker.If(maker.Binary(Javac.CTC_EQUAL, maker.Ident(oName), maker.Ident(thisName)), returnBool(maker, true), null));
        JCTree$JCUnary notInstanceOf = maker.Unary(Javac.CTC_NOT, maker.Parens(maker.TypeTest(maker.Ident(oName), createTypeReference(typeNode, false))));
        statements.append(maker.If(notInstanceOf, returnBool(maker, false), null));
        if (!members.isEmpty() || needsCanEqual) {
            JCTree$JCExpression selfType1 = createTypeReference(typeNode, true);
            JCTree$JCExpression selfType2 = createTypeReference(typeNode, true);
            statements.append(maker.VarDef(maker.Modifiers(finalFlag), otherName, selfType1, maker.TypeCast(selfType2, maker.Ident(oName))));
        }
        if (needsCanEqual) {
            com.sun.tools.javac.util.List<JCTree$JCExpression> exprNil = com.sun.tools.javac.util.List.nil();
            statements.append(maker.If(maker.Unary(Javac.CTC_NOT, maker.Apply(exprNil, maker.Select(maker.Ident(otherName), typeNode.toName("canEqual")), com.sun.tools.javac.util.List.of(maker.TypeCast(JavacHandlerUtil.genJavaLangTypeRef(typeNode, "Object"), maker.Ident(thisName))))), returnBool(maker, false), null));
        }
        if (callSuper) {
            JCTree$JCMethodInvocation callToSuper = maker.Apply(com.sun.tools.javac.util.List.nil(), maker.Select(maker.Ident(typeNode.toName("super")), typeNode.toName("equals")), com.sun.tools.javac.util.List.of(maker.Ident(oName)));
            JCTree$JCUnary superNotEqual = maker.Unary(Javac.CTC_NOT, callToSuper);
            statements.append(maker.If(superNotEqual, returnBool(maker, false), null));
        }
        for (InclusionExclusionUtils$Included<JavacNode, EqualsAndHashCode$Include> member : members) {
            JavacNode memberNode = member.getNode();
            boolean isMethod = memberNode.getKind() == AST$Kind.METHOD;
            JCTree$JCArrayTypeTree jCTree$JCArrayTypeTreeUnnotate = unnotate(JavacHandlerUtil.getFieldType(memberNode, fieldAccess));
            JCTree$JCExpression thisFieldAccessor = isMethod ? JavacHandlerUtil.createMethodAccessor(maker, memberNode) : JavacHandlerUtil.createFieldAccessor(maker, memberNode, fieldAccess);
            JCTree$JCExpression otherFieldAccessor = isMethod ? JavacHandlerUtil.createMethodAccessor(maker, memberNode, maker.Ident(otherName)) : JavacHandlerUtil.createFieldAccessor(maker, memberNode, fieldAccess, maker.Ident(otherName));
            if (jCTree$JCArrayTypeTreeUnnotate instanceof JCTree$JCPrimitiveTypeTree) {
                switch ($SWITCH_TABLE$javax$lang$model$type$TypeKind()[((JCTree$JCPrimitiveTypeTree) jCTree$JCArrayTypeTreeUnnotate).getPrimitiveTypeKind().ordinal()]) {
                    case 7:
                        statements.append(generateCompareFloatOrDouble(thisFieldAccessor, otherFieldAccessor, maker, typeNode, false));
                        break;
                    case 8:
                        statements.append(generateCompareFloatOrDouble(thisFieldAccessor, otherFieldAccessor, maker, typeNode, true));
                        break;
                    default:
                        statements.append(maker.If(maker.Binary(Javac.CTC_NOT_EQUAL, thisFieldAccessor, otherFieldAccessor), returnBool(maker, false), null));
                        break;
                }
            } else if (jCTree$JCArrayTypeTreeUnnotate instanceof JCTree$JCArrayTypeTree) {
                JCTree$JCArrayTypeTree array = jCTree$JCArrayTypeTreeUnnotate;
                boolean multiDim = unnotate(array.elemtype) instanceof JCTree$JCArrayTypeTree;
                boolean primitiveArray = unnotate(array.elemtype) instanceof JCTree$JCPrimitiveTypeTree;
                boolean useDeepEquals = multiDim || !primitiveArray;
                String[] strArr = new String[2];
                strArr[0] = "Arrays";
                strArr[1] = useDeepEquals ? "deepEquals" : "equals";
                JCTree$JCExpression eqMethod = JavacHandlerUtil.chainDots(typeNode, "java", "util", strArr);
                com.sun.tools.javac.util.List<JCTree$JCExpression> args = com.sun.tools.javac.util.List.of(thisFieldAccessor, otherFieldAccessor);
                statements.append(maker.If(maker.Unary(Javac.CTC_NOT, maker.Apply(com.sun.tools.javac.util.List.nil(), eqMethod, args)), returnBool(maker, false), null));
            } else {
                Name thisDollarFieldName = memberNode.toName("this" + (isMethod ? "$$" : "$") + memberNode.getName());
                Name otherDollarFieldName = memberNode.toName("other" + (isMethod ? "$$" : "$") + memberNode.getName());
                statements.append(maker.VarDef(maker.Modifiers(finalFlag), thisDollarFieldName, JavacHandlerUtil.genJavaLangTypeRef(typeNode, "Object"), thisFieldAccessor));
                statements.append(maker.VarDef(maker.Modifiers(finalFlag), otherDollarFieldName, JavacHandlerUtil.genJavaLangTypeRef(typeNode, "Object"), otherFieldAccessor));
                statements.append(maker.If(maker.Conditional(maker.Binary(Javac.CTC_EQUAL, maker.Ident(thisDollarFieldName), maker.Literal(Javac.CTC_BOT, null)), maker.Binary(Javac.CTC_NOT_EQUAL, maker.Ident(otherDollarFieldName), maker.Literal(Javac.CTC_BOT, null)), maker.Unary(Javac.CTC_NOT, maker.Apply(com.sun.tools.javac.util.List.nil(), maker.Select(maker.Ident(thisDollarFieldName), typeNode.toName("equals")), com.sun.tools.javac.util.List.of(maker.Ident(otherDollarFieldName))))), returnBool(maker, false), null));
            }
        }
        statements.append(returnBool(maker, true));
        JCTree$JCBlock body = maker.Block(0L, statements.toList());
        return JavacHandlerUtil.recursiveSetGeneratedBy(maker.MethodDef(mods, typeNode.toName("equals"), jCTree$JCPrimitiveTypeTreeTypeIdent, com.sun.tools.javac.util.List.nil(), params, com.sun.tools.javac.util.List.nil(), body, null), source, typeNode.getContext());
    }

    public JCTree$JCMethodDecl createCanEqual(JavacNode typeNode, JCTree source, com.sun.tools.javac.util.List<JCTree$JCAnnotation> onParam) {
        JavacTreeMaker maker = typeNode.getTreeMaker();
        com.sun.tools.javac.util.List<JCTree$JCAnnotation> annsOnMethod = com.sun.tools.javac.util.List.nil();
        CheckerFrameworkVersion checkerFramework = JavacHandlerUtil.getCheckerFrameworkVersion(typeNode);
        if (checkerFramework.generatePure()) {
            annsOnMethod = annsOnMethod.prepend(maker.Annotation(JavacHandlerUtil.genTypeRef(typeNode, CheckerFrameworkVersion.NAME__PURE), com.sun.tools.javac.util.List.nil()));
        }
        JCTree$JCModifiers mods = maker.Modifiers(4L, annsOnMethod);
        JCTree$JCPrimitiveTypeTree jCTree$JCPrimitiveTypeTreeTypeIdent = maker.TypeIdent(Javac.CTC_BOOLEAN);
        Name canEqualName = typeNode.toName("canEqual");
        JCTree$JCExpression objectType = JavacHandlerUtil.genJavaLangTypeRef(typeNode, "Object");
        Name otherName = typeNode.toName("other");
        long flags = JavacHandlerUtil.addFinalIfNeeded(Permission.MANAGE_EVENTS, typeNode.getContext());
        JCTree$JCVariableDecl param = maker.VarDef(maker.Modifiers(flags, onParam), otherName, objectType, null);
        JavacHandlerUtil.createRelevantNullableAnnotation(typeNode, param);
        com.sun.tools.javac.util.List<JCTree$JCVariableDecl> params = com.sun.tools.javac.util.List.of(param);
        JCTree$JCBlock body = maker.Block(0L, com.sun.tools.javac.util.List.of(maker.Return(maker.TypeTest(maker.Ident(otherName), createTypeReference(typeNode, false)))));
        return JavacHandlerUtil.recursiveSetGeneratedBy(maker.MethodDef(mods, canEqualName, jCTree$JCPrimitiveTypeTreeTypeIdent, com.sun.tools.javac.util.List.nil(), params, com.sun.tools.javac.util.List.nil(), body, null), source, typeNode.getContext());
    }

    public JCTree$JCStatement generateCompareFloatOrDouble(JCTree$JCExpression thisDotField, JCTree$JCExpression otherDotField, JavacTreeMaker maker, JavacNode node, boolean isDouble) {
        String[] strArr = new String[1];
        strArr[0] = isDouble ? "Double" : "Float";
        JCTree$JCExpression clazz = JavacHandlerUtil.genJavaLangTypeRef(node, strArr);
        com.sun.tools.javac.util.List<JCTree$JCExpression> args = com.sun.tools.javac.util.List.of(thisDotField, otherDotField);
        JCTree$JCBinary compareCallEquals0 = maker.Binary(Javac.CTC_NOT_EQUAL, maker.Apply(com.sun.tools.javac.util.List.nil(), maker.Select(clazz, node.toName("compare")), args), maker.Literal(0));
        return maker.If(compareCallEquals0, returnBool(maker, false), null);
    }

    public JCTree$JCStatement returnBool(JavacTreeMaker maker, boolean bool) {
        return maker.Return(maker.Literal(Javac.CTC_BOOLEAN, Integer.valueOf(bool ? 1 : 0)));
    }

    private JCTree$JCExpression unnotate(JCTree$JCExpression type) {
        if (isJcAnnotatedType(type) && this.jcAnnotatedTypeUnderlyingTypeField != null) {
            try {
                return (JCTree$JCExpression) this.jcAnnotatedTypeUnderlyingTypeField.get(type);
            } catch (Exception unused) {
                return type;
            }
        }
        return type;
    }

    private boolean isJcAnnotatedType(JCTree$JCExpression o) {
        if (o == null) {
            return false;
        }
        if (!this.jcAnnotatedTypeInit) {
            try {
                this.jcAnnotatedTypeClass = Class.forName("com.sun.tools.javac.tree.JCTree$JCAnnotatedType", false, o.getClass().getClassLoader());
                this.jcAnnotatedTypeUnderlyingTypeField = this.jcAnnotatedTypeClass.getDeclaredField("underlyingType");
            } catch (Exception unused) {
            }
            this.jcAnnotatedTypeInit = true;
        }
        return this.jcAnnotatedTypeClass == o.getClass();
    }
}
