package lombok.eclipse;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import lombok.Lombok;
import lombok.core.AnnotationValues$AnnotationValueDecodeFail;
import lombok.core.SpiLoadUtil;
import lombok.core.TypeLibrary;
import lombok.core.TypeResolver;
import lombok.core.configuration.ConfigurationKeysLoader$LoaderLoader;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/HandlerLibrary.SCL.lombok */
public class HandlerLibrary {
    private TypeLibrary typeLibrary = new TypeLibrary();
    private Map<String, HandlerLibrary$AnnotationHandlerContainer<?>> annotationHandlers = new HashMap();
    private Collection<HandlerLibrary$VisitorContainer> visitorHandlers = new ArrayList();
    private SortedSet<Long> priorities;

    public HandlerLibrary() {
        ConfigurationKeysLoader$LoaderLoader.loadAllConfigurationKeys();
    }

    public static HandlerLibrary load() {
        HandlerLibrary lib = new HandlerLibrary();
        loadAnnotationHandlers(lib);
        loadVisitorHandlers(lib);
        lib.calculatePriorities();
        return lib;
    }

    public SortedSet<Long> getPriorities() {
        return this.priorities;
    }

    private void calculatePriorities() {
        SortedSet<Long> set = new TreeSet<>();
        for (HandlerLibrary$AnnotationHandlerContainer<?> container : this.annotationHandlers.values()) {
            set.add(Long.valueOf(container.getPriority()));
        }
        for (HandlerLibrary$VisitorContainer container2 : this.visitorHandlers) {
            set.add(Long.valueOf(container2.getPriority()));
        }
        this.priorities = Collections.unmodifiableSortedSet(set);
    }

    private static void loadAnnotationHandlers(HandlerLibrary lib) {
        try {
            for (EclipseAnnotationHandler<?> handler : SpiLoadUtil.findServices(EclipseAnnotationHandler.class, EclipseAnnotationHandler.class.getClassLoader())) {
                try {
                    HandlerLibrary$AnnotationHandlerContainer<?> container = new HandlerLibrary$AnnotationHandlerContainer<>(handler, handler.getAnnotationHandledByThisHandler());
                    String annotationClassName = HandlerLibrary$AnnotationHandlerContainer.access$0(container).getName().replace("$", ".");
                    if (lib.annotationHandlers.put(annotationClassName, container) != null) {
                        EclipseHandlerUtil.error(null, "Duplicate handlers for annotation type: " + annotationClassName, null);
                    }
                    lib.typeLibrary.addType(HandlerLibrary$AnnotationHandlerContainer.access$0(container).getName());
                } catch (Throwable t) {
                    EclipseHandlerUtil.error(null, "Can't load Lombok annotation handler for Eclipse: ", t);
                }
            }
        } catch (IOException e) {
            throw Lombok.sneakyThrow(e);
        }
    }

    private static void loadVisitorHandlers(HandlerLibrary lib) {
        try {
            for (EclipseASTVisitor visitor : SpiLoadUtil.findServices(EclipseASTVisitor.class, EclipseASTVisitor.class.getClassLoader())) {
                lib.visitorHandlers.add(new HandlerLibrary$VisitorContainer(visitor));
            }
        } catch (Throwable t) {
            throw Lombok.sneakyThrow(t);
        }
    }

    private boolean checkAndSetHandled(ASTNode node) {
        return !EcjAugments.ASTNode_handled.getAndSet(node, true).booleanValue();
    }

    private boolean needsHandling(ASTNode node) {
        return !EcjAugments.ASTNode_handled.get(node).booleanValue();
    }

    public long handleAnnotation(CompilationUnitDeclaration ast, EclipseNode annotationNode, Annotation annotation, long priority) {
        String fqn;
        HandlerLibrary$AnnotationHandlerContainer<?> container;
        TypeResolver resolver = new TypeResolver(annotationNode.getImportList());
        TypeReference rawType = annotation.type;
        if (rawType == null || (fqn = resolver.typeRefToFullyQualifiedName(annotationNode, this.typeLibrary, Eclipse.toQualifiedName(annotation.type.getTypeName()))) == null || (container = this.annotationHandlers.get(fqn)) == null) {
            return RecyclerView.FOREVER_NS;
        }
        if (priority < container.getPriority()) {
            return container.getPriority();
        }
        if (priority > container.getPriority()) {
            return RecyclerView.FOREVER_NS;
        }
        if (!annotationNode.isCompleteParse() && container.deferUntilPostDiet()) {
            if (needsHandling(annotation)) {
                container.preHandle(annotation, annotationNode);
                return RecyclerView.FOREVER_NS;
            }
            return RecyclerView.FOREVER_NS;
        }
        try {
            if (checkAndSetHandled(annotation)) {
                container.handle(annotation, annotationNode);
                return RecyclerView.FOREVER_NS;
            }
            return RecyclerView.FOREVER_NS;
        } catch (AnnotationValues$AnnotationValueDecodeFail fail) {
            fail.owner.setError(fail.getMessage(), fail.idx);
            return RecyclerView.FOREVER_NS;
        } catch (Throwable t) {
            EclipseHandlerUtil.error(ast, String.format("Lombok annotation handler %s failed", HandlerLibrary$AnnotationHandlerContainer.access$1(container).getClass()), t);
            return RecyclerView.FOREVER_NS;
        }
    }

    public long callASTVisitors(EclipseAST ast, long priority, boolean isCompleteParse) {
        long nearestPriority = Long.MAX_VALUE;
        for (HandlerLibrary$VisitorContainer container : this.visitorHandlers) {
            if (priority < container.getPriority()) {
                nearestPriority = Math.min(container.getPriority(), nearestPriority);
            }
            if (isCompleteParse || !container.deferUntilPostDiet()) {
                if (priority == container.getPriority()) {
                    try {
                        ast.traverse(HandlerLibrary$VisitorContainer.access$0(container));
                    } catch (Throwable t) {
                        EclipseHandlerUtil.error(ast.top().get(), String.format("Lombok visitor handler %s failed", HandlerLibrary$VisitorContainer.access$0(container).getClass()), t);
                    }
                }
            }
        }
        return nearestPriority;
    }
}
