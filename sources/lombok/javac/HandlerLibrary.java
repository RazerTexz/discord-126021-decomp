package lombok.javac;

import com.sun.source.util.Trees;
import com.sun.tools.javac.tree.JCTree;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;
import lombok.core.AlreadyHandledAnnotations;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.SpiLoadUtil;
import lombok.core.TypeLibrary;
import lombok.core.TypeResolver;
import lombok.core.configuration.ConfigurationKeysLoader;
import lombok.javac.handlers.JavacHandlerUtil;

/* JADX INFO: loaded from: app.apk:lombok/javac/HandlerLibrary.SCL.lombok */
public class HandlerLibrary {
    private final TypeLibrary typeLibrary = new TypeLibrary();
    private final Map<String, List<AnnotationHandlerContainer<?>>> annotationHandlers = new HashMap();
    private final Collection<VisitorContainer> visitorHandlers = new ArrayList();
    private final Messager messager;
    private SortedSet<Long> priorities;
    private SortedSet<Long> prioritiesRequiringResolutionReset;

    public HandlerLibrary(Messager messager) {
        ConfigurationKeysLoader.LoaderLoader.loadAllConfigurationKeys();
        this.messager = messager;
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/HandlerLibrary$VisitorContainer.SCL.lombok */
    private static class VisitorContainer {
        private final JavacASTVisitor visitor;
        private final long priority;
        private final boolean resolutionResetNeeded;

        VisitorContainer(JavacASTVisitor visitor) {
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

    /* JADX INFO: loaded from: app.apk:lombok/javac/HandlerLibrary$AnnotationHandlerContainer.SCL.lombok */
    private static class AnnotationHandlerContainer<T extends Annotation> {
        private final JavacAnnotationHandler<T> handler;
        private final Class<T> annotationClass;
        private final long priority;
        private final boolean resolutionResetNeeded;
        private final boolean evenIfAlreadyHandled;

        AnnotationHandlerContainer(JavacAnnotationHandler<T> handler, Class<T> annotationClass) {
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

    public SortedSet<Long> getPriorities() {
        return this.priorities;
    }

    public SortedSet<Long> getPrioritiesRequiringResolutionReset() {
        return this.prioritiesRequiringResolutionReset;
    }

    private void calculatePriorities() {
        SortedSet<Long> set = new TreeSet<>();
        SortedSet<Long> resetNeeded = new TreeSet<>();
        for (List<AnnotationHandlerContainer<?>> containers : this.annotationHandlers.values()) {
            for (AnnotationHandlerContainer<?> container : containers) {
                set.add(Long.valueOf(container.getPriority()));
                if (container.isResolutionResetNeeded()) {
                    resetNeeded.add(Long.valueOf(container.getPriority()));
                }
            }
        }
        for (VisitorContainer container2 : this.visitorHandlers) {
            set.add(Long.valueOf(container2.getPriority()));
            if (container2.isResolutionResetNeeded()) {
                resetNeeded.add(Long.valueOf(container2.getPriority()));
            }
        }
        this.priorities = Collections.unmodifiableSortedSet(set);
        this.prioritiesRequiringResolutionReset = Collections.unmodifiableSortedSet(resetNeeded);
    }

    public static HandlerLibrary load(Messager messager, Trees trees) {
        HandlerLibrary library = new HandlerLibrary(messager);
        try {
            loadAnnotationHandlers(library, trees);
            loadVisitorHandlers(library, trees);
        } catch (IOException e) {
            System.err.println("Lombok isn't running due to misconfigured SPI files: " + e);
        }
        library.calculatePriorities();
        return library;
    }

    private static void loadAnnotationHandlers(HandlerLibrary lib, Trees trees) throws IOException {
        for (JavacAnnotationHandler handler : SpiLoadUtil.findServices(JavacAnnotationHandler.class, JavacAnnotationHandler.class.getClassLoader())) {
            handler.setTrees(trees);
            Class<? extends Annotation> annotationClass = handler.getAnnotationHandledByThisHandler();
            AnnotationHandlerContainer<?> container = new AnnotationHandlerContainer<>(handler, annotationClass);
            String annotationClassName = ((AnnotationHandlerContainer) container).annotationClass.getName().replace("$", ".");
            List<AnnotationHandlerContainer<?>> list = lib.annotationHandlers.get(annotationClassName);
            if (list == null) {
                Map<String, List<AnnotationHandlerContainer<?>>> map = lib.annotationHandlers;
                ArrayList arrayList = new ArrayList(1);
                list = arrayList;
                map.put(annotationClassName, arrayList);
            }
            list.add(container);
            lib.typeLibrary.addType(((AnnotationHandlerContainer) container).annotationClass.getName());
        }
    }

    private static void loadVisitorHandlers(HandlerLibrary lib, Trees trees) throws IOException {
        for (JavacASTVisitor visitor : SpiLoadUtil.findServices(JavacASTVisitor.class, JavacASTVisitor.class.getClassLoader())) {
            visitor.setTrees(trees);
            lib.visitorHandlers.add(new VisitorContainer(visitor));
        }
    }

    public void javacWarning(String message) {
        javacWarning(message, null);
    }

    public void javacWarning(String message, Throwable t) {
        this.messager.printMessage(Diagnostic.Kind.WARNING, String.valueOf(message) + (t == null ? "" : ": " + t));
    }

    public void javacError(String message) {
        javacError(message, null);
    }

    public void javacError(String message, Throwable t) {
        this.messager.printMessage(Diagnostic.Kind.ERROR, String.valueOf(message) + (t == null ? "" : ": " + t));
        if (t != null) {
            t.printStackTrace();
        }
    }

    private boolean checkAndSetHandled(JCTree node) {
        return !JavacAugments.JCTree_handled.getAndSet(node, true).booleanValue();
    }

    public void handleAnnotation(JCTree.JCCompilationUnit unit, JavacNode node, JCTree.JCAnnotation annotation, long priority) {
        List<AnnotationHandlerContainer<?>> containers;
        TypeResolver resolver = new TypeResolver(node.getImportList());
        String rawType = annotation.annotationType.toString();
        String fqn = resolver.typeRefToFullyQualifiedName(node, this.typeLibrary, rawType);
        if (fqn == null || (containers = this.annotationHandlers.get(fqn)) == null) {
            return;
        }
        for (AnnotationHandlerContainer<?> container : containers) {
            try {
                if (container.getPriority() == priority) {
                    if (checkAndSetHandled(annotation)) {
                        container.handle(node);
                    } else if (container.isEvenIfAlreadyHandled()) {
                        container.handle(node);
                    }
                }
            } catch (AnnotationValues.AnnotationValueDecodeFail fail) {
                fail.owner.setError(fail.getMessage(), fail.idx);
            } catch (Throwable t) {
                String sourceName = "(unknown).java";
                if (unit != null && unit.sourcefile != null) {
                    sourceName = unit.sourcefile.getName();
                }
                javacError(String.format("Lombok annotation handler %s failed on " + sourceName, ((AnnotationHandlerContainer) container).handler.getClass()), t);
            }
        }
    }

    public void callASTVisitors(JavacAST ast, long priority) {
        for (VisitorContainer container : this.visitorHandlers) {
            try {
                if (container.getPriority() == priority) {
                    ast.traverse(container.visitor);
                }
            } catch (Throwable t) {
                javacError(String.format("Lombok visitor handler %s failed", container.visitor.getClass()), t);
            }
        }
    }
}
