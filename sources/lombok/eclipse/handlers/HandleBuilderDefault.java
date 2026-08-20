package lombok.eclipse.handlers;

import lombok.Builder;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.experimental.SuperBuilder;
import org.eclipse.jdt.internal.compiler.ast.Annotation;

/* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/handlers/HandleBuilderDefault.SCL.lombok */
@HandlerPriority(-1025)
public class HandleBuilderDefault extends EclipseAnnotationHandler<Builder.Default> {
    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<Builder.Default> annotation, Annotation ast, EclipseNode annotationNode) {
        EclipseNode annotatedField = annotationNode.m10925up();
        if (annotatedField.getKind() != AST.Kind.FIELD) {
            return;
        }
        EclipseNode classWithAnnotatedField = annotatedField.m10925up();
        if (!EclipseHandlerUtil.hasAnnotation((Class<? extends java.lang.annotation.Annotation>) Builder.class, classWithAnnotatedField) && !EclipseHandlerUtil.hasAnnotation("lombok.experimental.Builder", classWithAnnotatedField) && !EclipseHandlerUtil.hasAnnotation((Class<? extends java.lang.annotation.Annotation>) SuperBuilder.class, classWithAnnotatedField)) {
            annotationNode.addWarning("@Builder.Default requires @Builder or @SuperBuilder on the class for it to mean anything.");
        }
    }
}
