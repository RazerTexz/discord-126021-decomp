package lombok.javac.handlers;

import com.discord.models.domain.ModelAuditLogEntry;
import com.sun.tools.javac.tree.JCTree;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import lombok.ConfigurationKeys;
import lombok.ToString;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.configuration.CallSuperType;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.InclusionExclusionUtils;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.javac.handlers.JavacHandlerUtil;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleToString.SCL.lombok */
public class HandleToString extends JavacAnnotationHandler<ToString> {
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$configuration$CallSuperType;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult;

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

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<ToString> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.TO_STRING_FLAG_USAGE, "@ToString");
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) ToString.class);
        ToString ann = annotation.getInstance();
        List<InclusionExclusionUtils.Included<JavacNode, ToString.Include>> members = InclusionExclusionUtils.handleToStringMarking(annotationNode.up(), annotation, annotationNode);
        if (members == null) {
            return;
        }
        Boolean callSuper = Boolean.valueOf(ann.callSuper());
        if (!annotation.isExplicit("callSuper")) {
            callSuper = null;
        }
        Boolean doNotUseGettersConfiguration = (Boolean) annotationNode.getAst().readConfiguration(ConfigurationKeys.TO_STRING_DO_NOT_USE_GETTERS);
        boolean doNotUseGetters = (annotation.isExplicit("doNotUseGetters") || doNotUseGettersConfiguration == null) ? ann.doNotUseGetters() : doNotUseGettersConfiguration.booleanValue();
        HandlerUtil.FieldAccess fieldAccess = doNotUseGetters ? HandlerUtil.FieldAccess.PREFER_FIELD : HandlerUtil.FieldAccess.GETTER;
        Boolean fieldNamesConfiguration = (Boolean) annotationNode.getAst().readConfiguration(ConfigurationKeys.TO_STRING_INCLUDE_FIELD_NAMES);
        boolean includeNames = (annotation.isExplicit("includeFieldNames") || fieldNamesConfiguration == null) ? ann.includeFieldNames() : fieldNamesConfiguration.booleanValue();
        generateToString(annotationNode.up(), annotationNode, members, includeNames, callSuper, true, fieldAccess);
    }

    public void generateToStringForType(JavacNode typeNode, JavacNode errorNode) {
        if (JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) ToString.class, typeNode)) {
            return;
        }
        boolean includeFieldNames = true;
        try {
            Boolean configuration = (Boolean) typeNode.getAst().readConfiguration(ConfigurationKeys.TO_STRING_INCLUDE_FIELD_NAMES);
            includeFieldNames = configuration != null ? configuration.booleanValue() : ((Boolean) ToString.class.getMethod("includeFieldNames", new Class[0]).getDefaultValue()).booleanValue();
        } catch (Exception unused) {
        }
        Boolean doNotUseGettersConfiguration = (Boolean) typeNode.getAst().readConfiguration(ConfigurationKeys.TO_STRING_DO_NOT_USE_GETTERS);
        HandlerUtil.FieldAccess access = (doNotUseGettersConfiguration == null || !doNotUseGettersConfiguration.booleanValue()) ? HandlerUtil.FieldAccess.GETTER : HandlerUtil.FieldAccess.PREFER_FIELD;
        List<InclusionExclusionUtils.Included<JavacNode, ToString.Include>> members = InclusionExclusionUtils.handleToStringMarking(typeNode, null, null);
        generateToString(typeNode, errorNode, members, includeFieldNames, null, false, access);
    }

    public void generateToString(JavacNode typeNode, JavacNode source, List<InclusionExclusionUtils.Included<JavacNode, ToString.Include>> members, boolean includeFieldNames, Boolean callSuper, boolean whineIfExists, HandlerUtil.FieldAccess fieldAccess) {
        boolean notAClass = true;
        if (typeNode.get() instanceof JCTree.JCClassDecl) {
            long flags = typeNode.get().mods.flags;
            notAClass = (flags & 8704) != 0;
        }
        if (notAClass) {
            source.addError("@ToString is only supported on a class or enum.");
        }
        switch ($SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult()[JavacHandlerUtil.methodExists("toString", typeNode, 0).ordinal()]) {
            case 1:
                if (callSuper == null) {
                    if (JavacHandlerUtil.isDirectDescendantOfObject(typeNode)) {
                        callSuper = false;
                    } else {
                        CallSuperType cst = (CallSuperType) typeNode.getAst().readConfiguration(ConfigurationKeys.TO_STRING_CALL_SUPER);
                        if (cst == null) {
                            cst = CallSuperType.SKIP;
                        }
                        switch ($SWITCH_TABLE$lombok$core$configuration$CallSuperType()[cst.ordinal()]) {
                            case 1:
                                callSuper = true;
                                break;
                            case 2:
                            default:
                                callSuper = false;
                                break;
                            case 3:
                                source.addWarning("Generating toString implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@ToString(callSuper=false)' to your type.");
                                callSuper = false;
                                break;
                        }
                    }
                }
                JCTree.JCMethodDecl method = createToString(typeNode, members, includeFieldNames, callSuper.booleanValue(), fieldAccess, source.get());
                JavacHandlerUtil.injectMethod(typeNode, method);
                break;
            case 2:
                break;
            case 3:
            default:
                if (whineIfExists) {
                    source.addWarning("Not generating toString(): A method with that name already exists");
                }
                break;
        }
    }

    static JCTree.JCMethodDecl createToString(JavacNode typeNode, Collection<InclusionExclusionUtils.Included<JavacNode, ToString.Include>> members, boolean includeNames, boolean callSuper, HandlerUtil.FieldAccess fieldAccess, JCTree source) {
        String prefix;
        JCTree.JCExpression current;
        JCTree.JCExpression memberAccessor;
        JCTree.JCExpression expr;
        JCTree.JCBinary jCBinaryBinary;
        JavacTreeMaker maker = typeNode.getTreeMaker();
        JCTree.JCAnnotation overrideAnnotation = maker.Annotation(JavacHandlerUtil.genJavaLangTypeRef(typeNode, "Override"), com.sun.tools.javac.util.List.nil());
        com.sun.tools.javac.util.List<JCTree.JCAnnotation> annsOnMethod = com.sun.tools.javac.util.List.of(overrideAnnotation);
        if (JavacHandlerUtil.getCheckerFrameworkVersion(typeNode).generateSideEffectFree()) {
            annsOnMethod = annsOnMethod.prepend(maker.Annotation(JavacHandlerUtil.genTypeRef(typeNode, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE), com.sun.tools.javac.util.List.nil()));
        }
        JCTree.JCModifiers mods = maker.Modifiers(1L, annsOnMethod);
        JCTree.JCExpression returnType = JavacHandlerUtil.genJavaLangTypeRef(typeNode, "String");
        boolean first = true;
        String typeName = getTypeName(typeNode);
        boolean isEnum = typeNode.isEnumType();
        if (callSuper) {
            prefix = "(super=";
        } else if (members.isEmpty()) {
            prefix = isEnum ? "" : "()";
        } else if (includeNames) {
            InclusionExclusionUtils.Included<JavacNode, ToString.Include> firstMember = members.iterator().next();
            String name = firstMember.getInc() == null ? "" : firstMember.getInc().name();
            if (name.isEmpty()) {
                name = firstMember.getNode().getName();
            }
            prefix = "(" + name + "=";
        } else {
            prefix = "(";
        }
        if (!isEnum) {
            current = maker.Literal(String.valueOf(typeName) + prefix);
        } else {
            current = maker.Binary(Javac.CTC_PLUS, maker.Literal(String.valueOf(typeName) + "."), maker.Apply(com.sun.tools.javac.util.List.nil(), maker.Select(maker.Ident(typeNode.toName("this")), typeNode.toName(ModelAuditLogEntry.CHANGE_KEY_NAME)), com.sun.tools.javac.util.List.nil()));
            if (!prefix.isEmpty()) {
                current = maker.Binary(Javac.CTC_PLUS, current, maker.Literal(prefix));
            }
        }
        if (callSuper) {
            JCTree.JCMethodInvocation callToSuper = maker.Apply(com.sun.tools.javac.util.List.nil(), maker.Select(maker.Ident(typeNode.toName("super")), typeNode.toName("toString")), com.sun.tools.javac.util.List.nil());
            current = maker.Binary(Javac.CTC_PLUS, current, callToSuper);
            first = false;
        }
        for (InclusionExclusionUtils.Included<JavacNode, ToString.Include> member : members) {
            JavacNode memberNode = member.getNode();
            if (memberNode.getKind() == AST.Kind.METHOD) {
                memberAccessor = JavacHandlerUtil.createMethodAccessor(maker, memberNode);
            } else {
                memberAccessor = JavacHandlerUtil.createFieldAccessor(maker, memberNode, fieldAccess);
            }
            JCTree.JCArrayTypeTree fieldType = JavacHandlerUtil.getFieldType(memberNode, fieldAccess);
            boolean z2 = fieldType instanceof JCTree.JCPrimitiveTypeTree;
            boolean fieldIsPrimitiveArray = (fieldType instanceof JCTree.JCArrayTypeTree) && (fieldType.elemtype instanceof JCTree.JCPrimitiveTypeTree);
            boolean fieldIsObjectArray = !fieldIsPrimitiveArray && (fieldType instanceof JCTree.JCArrayTypeTree);
            if (fieldIsPrimitiveArray || fieldIsObjectArray) {
                String[] strArr = new String[2];
                strArr[0] = "Arrays";
                strArr[1] = fieldIsObjectArray ? "deepToString" : "toString";
                JCTree.JCExpression tsMethod = JavacHandlerUtil.chainDots(typeNode, "java", "util", strArr);
                expr = maker.Apply(com.sun.tools.javac.util.List.nil(), tsMethod, com.sun.tools.javac.util.List.of(memberAccessor));
            } else {
                expr = memberAccessor;
            }
            if (first) {
                current = maker.Binary(Javac.CTC_PLUS, current, expr);
                first = false;
            } else {
                if (includeNames) {
                    String n = member.getInc() == null ? "" : member.getInc().name();
                    if (n.isEmpty()) {
                        n = memberNode.getName();
                    }
                    jCBinaryBinary = maker.Binary(Javac.CTC_PLUS, current, maker.Literal(String.valueOf(", ") + n + "="));
                } else {
                    jCBinaryBinary = maker.Binary(Javac.CTC_PLUS, current, maker.Literal(", "));
                }
                current = maker.Binary(Javac.CTC_PLUS, jCBinaryBinary, expr);
            }
        }
        if (!first) {
            current = maker.Binary(Javac.CTC_PLUS, current, maker.Literal(")"));
        }
        JCTree.JCBlock body = maker.Block(0L, com.sun.tools.javac.util.List.of(maker.Return(current)));
        JCTree.JCMethodDecl methodDef = maker.MethodDef(mods, typeNode.toName("toString"), returnType, com.sun.tools.javac.util.List.nil(), com.sun.tools.javac.util.List.nil(), com.sun.tools.javac.util.List.nil(), body, null);
        JavacHandlerUtil.createRelevantNonNullAnnotation(typeNode, methodDef);
        return JavacHandlerUtil.recursiveSetGeneratedBy(methodDef, source, typeNode.getContext());
    }

    public static String getTypeName(JavacNode typeNode) {
        String typeName = typeNode.get().name.toString();
        JavacNode javacNodeUp = typeNode.up();
        while (true) {
            JavacNode upType = javacNodeUp;
            if (upType.getKind() == AST.Kind.TYPE) {
                typeName = String.valueOf(upType.get().name.toString()) + "." + typeName;
                javacNodeUp = upType.up();
            } else {
                return typeName;
            }
        }
    }
}
