package lombok.eclipse;

import java.lang.annotation.Annotation;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.eclipse.handlers.EclipseHandlerUtil;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/HandlerLibrary$AnnotationHandlerContainer.SCL.lombok */
class HandlerLibrary$AnnotationHandlerContainer<T extends Annotation> {
    private final EclipseAnnotationHandler<T> handler;
    private final Class<T> annotationClass;
    private final long priority;
    private final boolean deferUntilPostDiet;

    static /* synthetic */ EclipseAnnotationHandler access$1(HandlerLibrary$AnnotationHandlerContainer handlerLibrary$AnnotationHandlerContainer) {
        return handlerLibrary$AnnotationHandlerContainer.handler;
    }

    static /* synthetic */ Class access$0(HandlerLibrary$AnnotationHandlerContainer handlerLibrary$AnnotationHandlerContainer) {
        return handlerLibrary$AnnotationHandlerContainer.annotationClass;
    }

    HandlerLibrary$AnnotationHandlerContainer(EclipseAnnotationHandler<T> handler, Class<T> annotationClass) {
        this.handler = handler;
        this.annotationClass = annotationClass;
        this.deferUntilPostDiet = handler.getClass().isAnnotationPresent(DeferUntilPostDiet.class);
        HandlerPriority hp = (HandlerPriority) handler.getClass().getAnnotation(HandlerPriority.class);
        this.priority = hp == null ? 0L : (((long) hp.value()) << 32) + ((long) hp.subValue());
    }

    public void handle(org.eclipse.jdt.internal.compiler.ast.Annotation annotation, EclipseNode annotationNode) {
        AnnotationValues<T> annValues = EclipseHandlerUtil.createAnnotation(this.annotationClass, annotationNode);
        this.handler.handle(annValues, annotation, annotationNode);
    }

    public void preHandle(org.eclipse.jdt.internal.compiler.ast.Annotation annotation, EclipseNode annotationNode) {
        AnnotationValues<T> annValues = EclipseHandlerUtil.createAnnotation(this.annotationClass, annotationNode);
        this.handler.preHandle(annValues, annotation, annotationNode);
    }

    public boolean deferUntilPostDiet() {
        return this.deferUntilPostDiet;
    }

    public long getPriority() {
        return this.priority;
    }
}
