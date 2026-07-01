package lombok.javac;

import java.lang.annotation.Annotation;
import lombok.core.AlreadyHandledAnnotations;
import lombok.core.HandlerPriority;
import lombok.javac.handlers.JavacHandlerUtil;

/* JADX INFO: loaded from: app.apk:lombok/javac/HandlerLibrary$AnnotationHandlerContainer.SCL.lombok */
class HandlerLibrary$AnnotationHandlerContainer<T extends Annotation> {
    private final JavacAnnotationHandler<T> handler;
    private final Class<T> annotationClass;
    private final long priority;
    private final boolean resolutionResetNeeded;
    private final boolean evenIfAlreadyHandled;

    static /* synthetic */ JavacAnnotationHandler access$1(HandlerLibrary$AnnotationHandlerContainer handlerLibrary$AnnotationHandlerContainer) {
        return handlerLibrary$AnnotationHandlerContainer.handler;
    }

    static /* synthetic */ Class access$0(HandlerLibrary$AnnotationHandlerContainer handlerLibrary$AnnotationHandlerContainer) {
        return handlerLibrary$AnnotationHandlerContainer.annotationClass;
    }

    HandlerLibrary$AnnotationHandlerContainer(JavacAnnotationHandler<T> handler, Class<T> annotationClass) {
        this.handler = handler;
        this.annotationClass = annotationClass;
        HandlerPriority hp = (HandlerPriority) handler.getClass().getAnnotation(HandlerPriority.class);
        this.priority = hp == null ? 0L : (((long) hp.value()) << 32) + ((long) hp.subValue());
        this.resolutionResetNeeded = handler.getClass().isAnnotationPresent(ResolutionResetNeeded.class);
        this.evenIfAlreadyHandled = handler.getClass().isAnnotationPresent(AlreadyHandledAnnotations.class);
    }

    public void handle(JavacNode node) {
        this.handler.handle(JavacHandlerUtil.createAnnotation(this.annotationClass, node), node.get(), node);
    }

    public long getPriority() {
        return this.priority;
    }

    public boolean isResolutionResetNeeded() {
        return this.resolutionResetNeeded;
    }

    public boolean isEvenIfAlreadyHandled() {
        return this.evenIfAlreadyHandled;
    }
}
