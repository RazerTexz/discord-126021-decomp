package lombok.eclipse.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Builder;
import lombok.ConfigurationKeys;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.Eclipse;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.ClassLiteralAccess;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleJacksonized.SCL.lombok */
@HandlerPriority(-512)
public class HandleJacksonized extends EclipseAnnotationHandler<Jacksonized> {
    private static final char[][] JSON_POJO_BUILDER_ANNOTATION = Eclipse.fromQualifiedName("com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder");
    private static final char[][] JSON_DESERIALIZE_ANNOTATION = Eclipse.fromQualifiedName("com.fasterxml.jackson.databind.annotation.JsonDeserialize");
    private static final Annotation[] EMPTY_ANNOTATIONS_ARRAY = new Annotation[0];

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<Jacksonized> annotation, Annotation ast, EclipseNode annotationNode) {
        EclipseNode tdNode;
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.JACKSONIZED_FLAG_USAGE, "@Jacksonized");
        EclipseNode annotatedNode = annotationNode.up();
        if (annotatedNode.getKind() != AST$Kind.TYPE) {
            tdNode = annotatedNode.up();
        } else {
            tdNode = annotatedNode;
        }
        TypeDeclaration td = (TypeDeclaration) tdNode.get();
        EclipseNode builderAnnotationNode = EclipseHandlerUtil.findAnnotation(Builder.class, annotatedNode);
        EclipseNode superBuilderAnnotationNode = EclipseHandlerUtil.findAnnotation(SuperBuilder.class, annotatedNode);
        if (builderAnnotationNode == null && superBuilderAnnotationNode == null) {
            annotationNode.addWarning("@Jacksonized requires @Builder or @SuperBuilder for it to mean anything.");
            return;
        }
        if (builderAnnotationNode != null && superBuilderAnnotationNode != null) {
            annotationNode.addError("@Jacksonized cannot process both @Builder and @SuperBuilder on the same class.");
            return;
        }
        boolean isAbstract = (td.modifiers & 1024) != 0;
        if (isAbstract) {
            annotationNode.addError("Builders on abstract classes cannot be @Jacksonized (the builder would never be used).");
            return;
        }
        AnnotationValues<Builder> builderAnnotation = builderAnnotationNode != null ? EclipseHandlerUtil.createAnnotation(Builder.class, builderAnnotationNode) : null;
        AnnotationValues<SuperBuilder> superBuilderAnnotation = superBuilderAnnotationNode != null ? EclipseHandlerUtil.createAnnotation(SuperBuilder.class, superBuilderAnnotationNode) : null;
        String setPrefix = builderAnnotation != null ? builderAnnotation.getInstance().setterPrefix() : superBuilderAnnotation.getInstance().setterPrefix();
        String buildMethodName = builderAnnotation != null ? builderAnnotation.getInstance().buildMethodName() : superBuilderAnnotation.getInstance().buildMethodName();
        EclipseNode builderClassNode = null;
        TypeDeclaration builderClass = null;
        String builderClassName = getBuilderClassName(ast, annotationNode, annotatedNode, td, builderAnnotation);
        for (EclipseNode member : tdNode.down()) {
            TypeDeclaration typeDeclaration = (ASTNode) member.get();
            if ((typeDeclaration instanceof TypeDeclaration) && Arrays.equals(typeDeclaration.name, builderClassName.toCharArray())) {
                builderClassNode = member;
                builderClass = typeDeclaration;
                break;
            }
        }
        if (builderClass == null) {
            annotationNode.addError("Could not find @(Super)Builder's generated builder class for @Jacksonized processing. If there are other compiler errors, fix them first.");
            return;
        }
        if (EclipseHandlerUtil.hasAnnotation("com.fasterxml.jackson.databind.annotation.JsonDeserialize", tdNode)) {
            annotationNode.addError("@JsonDeserialize already exists on class. Either delete @JsonDeserialize, or remove @Jacksonized and manually configure Jackson.");
            return;
        }
        long p = (((long) ast.sourceStart) << 32) | ((long) ast.sourceEnd);
        TypeReference builderClassExpression = EclipseHandlerUtil.namePlusTypeParamsToTypeReference(builderClassNode, null, p);
        ClassLiteralAccess builderClassLiteralAccess = new ClassLiteralAccess(td.sourceEnd, builderClassExpression);
        td.annotations = EclipseHandlerUtil.addAnnotation(td, td.annotations, JSON_DESERIALIZE_ANNOTATION, new MemberValuePair("builder".toCharArray(), td.sourceStart, td.sourceEnd, builderClassLiteralAccess));
        Annotation[] copyableAnnotations = findJacksonAnnotationsOnClass(td, tdNode);
        builderClass.annotations = EclipseHandlerUtil.copyAnnotations(builderClass, builderClass.annotations, copyableAnnotations);
        StringLiteral withPrefixLiteral = new StringLiteral(setPrefix.toCharArray(), builderClass.sourceStart, builderClass.sourceEnd, 0);
        ASTNode memberValuePair = new MemberValuePair("withPrefix".toCharArray(), builderClass.sourceStart, builderClass.sourceEnd, withPrefixLiteral);
        StringLiteral buildMethodNameLiteral = new StringLiteral(buildMethodName.toCharArray(), builderClass.sourceStart, builderClass.sourceEnd, 0);
        builderClass.annotations = EclipseHandlerUtil.addAnnotation(builderClass, builderClass.annotations, JSON_POJO_BUILDER_ANNOTATION, memberValuePair, new MemberValuePair("buildMethodName".toCharArray(), builderClass.sourceStart, builderClass.sourceEnd, buildMethodNameLiteral));
        if (superBuilderAnnotationNode != null) {
            builderClass.modifiers &= -3;
        }
    }

    private String getBuilderClassName(Annotation ast, EclipseNode annotationNode, EclipseNode annotatedNode, TypeDeclaration td, AnnotationValues<Builder> builderAnnotation) {
        char[] replacement;
        String builderClassName = builderAnnotation != null ? builderAnnotation.getInstance().builderClassName() : null;
        if (builderClassName == null || builderClassName.isEmpty()) {
            String builderClassName2 = (String) annotationNode.getAst().readConfiguration(ConfigurationKeys.BUILDER_CLASS_NAME);
            if (builderClassName2 == null || builderClassName2.isEmpty()) {
                builderClassName2 = "*Builder";
            }
            MethodDeclaration fillParametersFrom = annotatedNode.get() instanceof MethodDeclaration ? (MethodDeclaration) annotatedNode.get() : null;
            if (fillParametersFrom != null) {
                replacement = HandleBuilder.returnTypeToBuilderClassName(annotationNode, fillParametersFrom, fillParametersFrom.typeParameters);
            } else {
                replacement = td.name;
            }
            builderClassName = builderClassName2.replace("*", new String(replacement));
        }
        if (builderAnnotation == null) {
            builderClassName = String.valueOf(builderClassName) + "Impl";
        }
        return builderClassName;
    }

    private static Annotation[] findJacksonAnnotationsOnClass(TypeDeclaration td, EclipseNode node) {
        if (td.annotations == null) {
            return EMPTY_ANNOTATIONS_ARRAY;
        }
        List<Annotation> result = new ArrayList<>();
        for (Annotation annotation : td.annotations) {
            TypeReference typeRef = annotation.type;
            if (typeRef != null && typeRef.getTypeName() != null) {
                for (String bn : HandlerUtil.JACKSON_COPY_TO_BUILDER_ANNOTATIONS) {
                    if (EclipseHandlerUtil.typeMatches(bn, node, typeRef)) {
                        result.add(annotation);
                        break;
                    }
                }
            }
        }
        return (Annotation[]) result.toArray(EMPTY_ANNOTATIONS_ARRAY);
    }
}
