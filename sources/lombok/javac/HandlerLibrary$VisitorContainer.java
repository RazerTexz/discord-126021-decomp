package lombok.javac;

import lombok.core.HandlerPriority;

/* JADX INFO: loaded from: app.apk:lombok/javac/HandlerLibrary$VisitorContainer.SCL.lombok */
class HandlerLibrary$VisitorContainer {
    private final JavacASTVisitor visitor;
    private final long priority;
    private final boolean resolutionResetNeeded;

    static /* synthetic */ JavacASTVisitor access$0(HandlerLibrary$VisitorContainer handlerLibrary$VisitorContainer) {
        return handlerLibrary$VisitorContainer.visitor;
    }

    HandlerLibrary$VisitorContainer(JavacASTVisitor visitor) {
        this.visitor = visitor;
        HandlerPriority hp = (HandlerPriority) visitor.getClass().getAnnotation(HandlerPriority.class);
        this.priority = hp == null ? 0L : (((long) hp.value()) << 32) + ((long) hp.subValue());
        this.resolutionResetNeeded = visitor.getClass().isAnnotationPresent(ResolutionResetNeeded.class);
    }

    public long getPriority() {
        return this.priority;
    }

    public boolean isResolutionResetNeeded() {
        return this.resolutionResetNeeded;
    }
}
