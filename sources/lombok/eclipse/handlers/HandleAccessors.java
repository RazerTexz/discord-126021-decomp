package lombok.eclipse.handlers;

import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.experimental.Accessors;
import org.eclipse.jdt.internal.compiler.ast.Annotation;

/* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/handlers/HandleAccessors.SCL.lombok */
@HandlerPriority(65536)
public class HandleAccessors extends EclipseAnnotationHandler<Accessors> {
    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<Accessors> annotation, Annotation ast, EclipseNode annotationNode) {
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.ACCESSORS_FLAG_USAGE, "@Accessors");
    }
}
