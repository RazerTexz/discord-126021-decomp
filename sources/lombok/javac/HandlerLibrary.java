package lombok.javac;

import com.sun.source.util.Trees;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCCompilationUnit;
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
import javax.tools.Diagnostic$Kind;
import lombok.core.AnnotationValues$AnnotationValueDecodeFail;
import lombok.core.SpiLoadUtil;
import lombok.core.TypeLibrary;
import lombok.core.TypeResolver;
import lombok.core.configuration.ConfigurationKeysLoader$LoaderLoader;

/* JADX INFO: loaded from: app.apk:lombok/javac/HandlerLibrary.SCL.lombok */
public class HandlerLibrary {
    private final TypeLibrary typeLibrary = new TypeLibrary();
    private final Map<String, List<HandlerLibrary$AnnotationHandlerContainer<?>>> annotationHandlers = new HashMap();
    private final Collection<HandlerLibrary$VisitorContainer> visitorHandlers = new ArrayList();
    private final Messager messager;
    private SortedSet<Long> priorities;
    private SortedSet<Long> prioritiesRequiringResolutionReset;

    public HandlerLibrary(Messager messager) {
        ConfigurationKeysLoader$LoaderLoader.loadAllConfigurationKeys();
        this.messager = messager;
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
        for (List<HandlerLibrary$AnnotationHandlerContainer<?>> containers : this.annotationHandlers.values()) {
            for (HandlerLibrary$AnnotationHandlerContainer<?> container : containers) {
                set.add(Long.valueOf(container.getPriority()));
                if (container.isResolutionResetNeeded()) {
                    resetNeeded.add(Long.valueOf(container.getPriority()));
                }
            }
        }
        for (HandlerLibrary$VisitorContainer container2 : this.visitorHandlers) {
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
            HandlerLibrary$AnnotationHandlerContainer<?> container = new HandlerLibrary$AnnotationHandlerContainer<>(handler, annotationClass);
            String annotationClassName = HandlerLibrary$AnnotationHandlerContainer.access$0(container).getName().replace("$", ".");
            List<HandlerLibrary$AnnotationHandlerContainer<?>> list = lib.annotationHandlers.get(annotationClassName);
            if (list == null) {
                Map<String, List<HandlerLibrary$AnnotationHandlerContainer<?>>> map = lib.annotationHandlers;
                ArrayList arrayList = new ArrayList(1);
                list = arrayList;
                map.put(annotationClassName, arrayList);
            }
            list.add(container);
            lib.typeLibrary.addType(HandlerLibrary$AnnotationHandlerContainer.access$0(container).getName());
        }
    }

    private static void loadVisitorHandlers(HandlerLibrary lib, Trees trees) throws IOException {
        for (JavacASTVisitor visitor : SpiLoadUtil.findServices(JavacASTVisitor.class, JavacASTVisitor.class.getClassLoader())) {
            visitor.setTrees(trees);
            lib.visitorHandlers.add(new HandlerLibrary$VisitorContainer(visitor));
        }
    }

    public void javacWarning(String message) {
        javacWarning(message, null);
    }

    public void javacWarning(String message, Throwable t) {
        this.messager.printMessage(Diagnostic$Kind.WARNING, String.valueOf(message) + (t == null ? "" : ": " + t));
    }

    public void javacError(String message) {
        javacError(message, null);
    }

    public void javacError(String message, Throwable t) {
        this.messager.printMessage(Diagnostic$Kind.ERROR, String.valueOf(message) + (t == null ? "" : ": " + t));
        if (t != null) {
            t.printStackTrace();
        }
    }

    private boolean checkAndSetHandled(JCTree node) {
        return !JavacAugments.JCTree_handled.getAndSet(node, true).booleanValue();
    }

    public void handleAnnotation(JCTree$JCCompilationUnit unit, JavacNode node, JCTree$JCAnnotation annotation, long priority) {
        List<HandlerLibrary$AnnotationHandlerContainer<?>> containers;
        TypeResolver resolver = new TypeResolver(node.getImportList());
        String rawType = annotation.annotationType.toString();
        String fqn = resolver.typeRefToFullyQualifiedName(node, this.typeLibrary, rawType);
        if (fqn == null || (containers = this.annotationHandlers.get(fqn)) == null) {
            return;
        }
        for (HandlerLibrary$AnnotationHandlerContainer<?> container : containers) {
            try {
                if (container.getPriority() == priority) {
                    if (checkAndSetHandled(annotation)) {
                        container.handle(node);
                    } else if (container.isEvenIfAlreadyHandled()) {
                        container.handle(node);
                    }
                }
            } catch (AnnotationValues$AnnotationValueDecodeFail fail) {
                fail.owner.setError(fail.getMessage(), fail.idx);
            } catch (Throwable t) {
                String sourceName = "(unknown).java";
                if (unit != null && unit.sourcefile != null) {
                    sourceName = unit.sourcefile.getName();
                }
                javacError(String.format("Lombok annotation handler %s failed on " + sourceName, HandlerLibrary$AnnotationHandlerContainer.access$1(container).getClass()), t);
            }
        }
    }

    public void callASTVisitors(JavacAST ast, long priority) {
        for (HandlerLibrary$VisitorContainer container : this.visitorHandlers) {
            try {
                if (container.getPriority() == priority) {
                    ast.traverse(HandlerLibrary$VisitorContainer.access$0(container));
                }
            } catch (Throwable t) {
                javacError(String.format("Lombok visitor handler %s failed", HandlerLibrary$VisitorContainer.access$0(container).getClass()), t);
            }
        }
    }
}
