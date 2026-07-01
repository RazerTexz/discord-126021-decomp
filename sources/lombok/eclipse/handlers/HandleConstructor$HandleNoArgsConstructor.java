package lombok.eclipse.handlers;

import java.util.Collections;
import java.util.List;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.NoArgsConstructor;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.Annotation;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleConstructor$HandleNoArgsConstructor.SCL.lombok */
public class HandleConstructor$HandleNoArgsConstructor extends EclipseAnnotationHandler<NoArgsConstructor> {
    private static final String NAME = NoArgsConstructor.class.getSimpleName();
    private HandleConstructor handleConstructor = new HandleConstructor();

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<NoArgsConstructor> annotation, Annotation ast, EclipseNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.NO_ARGS_CONSTRUCTOR_FLAG_USAGE, "@NoArgsConstructor", ConfigurationKeys.ANY_CONSTRUCTOR_FLAG_USAGE, "any @xArgsConstructor");
        EclipseNode typeNode = annotationNode.up();
        if (HandleConstructor.checkLegality(typeNode, annotationNode, NAME)) {
            NoArgsConstructor ann = annotation.getInstance();
            AccessLevel level = ann.access();
            String staticName = ann.staticName();
            if (level == AccessLevel.NONE) {
                return;
            }
            boolean force = ann.force();
            List<Annotation> onConstructor = EclipseHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onConstructor", "@NoArgsConstructor(onConstructor", annotationNode);
            this.handleConstructor.generateConstructor(typeNode, level, Collections.emptyList(), force, staticName, HandleConstructor$SkipIfConstructorExists.NO, onConstructor, annotationNode);
        }
    }
}
