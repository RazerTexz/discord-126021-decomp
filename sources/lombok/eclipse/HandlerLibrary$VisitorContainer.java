package lombok.eclipse;

import lombok.core.HandlerPriority;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/HandlerLibrary$VisitorContainer.SCL.lombok */
class HandlerLibrary$VisitorContainer {
    private final EclipseASTVisitor visitor;
    private final long priority;
    private final boolean deferUntilPostDiet;

    static /* synthetic */ EclipseASTVisitor access$0(HandlerLibrary$VisitorContainer handlerLibrary$VisitorContainer) {
        return handlerLibrary$VisitorContainer.visitor;
    }

    HandlerLibrary$VisitorContainer(EclipseASTVisitor visitor) {
        this.visitor = visitor;
        this.deferUntilPostDiet = visitor.getClass().isAnnotationPresent(DeferUntilPostDiet.class);
        HandlerPriority hp = (HandlerPriority) visitor.getClass().getAnnotation(HandlerPriority.class);
        this.priority = hp == null ? 0L : (((long) hp.value()) << 32) + ((long) hp.subValue());
    }

    public boolean deferUntilPostDiet() {
        return this.deferUntilPostDiet;
    }

    public long getPriority() {
        return this.priority;
    }
}
