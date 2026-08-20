package lombok.eclipse;

import java.lang.annotation.Annotation;
import lombok.core.AnnotationValues;
import lombok.core.SpiLoadUtil;

/* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/EclipseAnnotationHandler.SCL.lombok */
public abstract class EclipseAnnotationHandler<T extends Annotation> {
    public abstract void handle(AnnotationValues<T> annotationValues, org.eclipse.jdt.internal.compiler.ast.Annotation annotation, EclipseNode eclipseNode);

    public void preHandle(AnnotationValues<T> annotation, org.eclipse.jdt.internal.compiler.ast.Annotation ast, EclipseNode annotationNode) {
    }

    public Class<T> getAnnotationHandledByThisHandler() {
        return (Class<T>) SpiLoadUtil.findAnnotationClass(getClass(), EclipseAnnotationHandler.class);
    }
}
