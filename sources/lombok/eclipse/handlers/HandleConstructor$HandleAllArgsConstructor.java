package lombok.eclipse.handlers;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.Annotation;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleConstructor$HandleAllArgsConstructor.SCL.lombok */
public class HandleConstructor$HandleAllArgsConstructor extends EclipseAnnotationHandler<AllArgsConstructor> {
    private static final String NAME = AllArgsConstructor.class.getSimpleName();
    private HandleConstructor handleConstructor = new HandleConstructor();

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<AllArgsConstructor> annotation, Annotation ast, EclipseNode annotationNode) {
        AllArgsConstructor ann;
        AccessLevel level;
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.ALL_ARGS_CONSTRUCTOR_FLAG_USAGE, "@AllArgsConstructor", ConfigurationKeys.ANY_CONSTRUCTOR_FLAG_USAGE, "any @xArgsConstructor");
        EclipseNode typeNode = annotationNode.up();
        if (HandleConstructor.checkLegality(typeNode, annotationNode, NAME) && (level = (ann = annotation.getInstance()).access()) != AccessLevel.NONE) {
            String staticName = ann.staticName();
            if (annotation.isExplicit("suppressConstructorProperties")) {
                annotationNode.addError("This deprecated feature is no longer supported. Remove it; you can create a lombok.config file with 'lombok.anyConstructor.suppressConstructorProperties = true'.");
            }
            List<Annotation> onConstructor = EclipseHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onConstructor", "@AllArgsConstructor(onConstructor", annotationNode);
            this.handleConstructor.generateConstructor(typeNode, level, HandleConstructor.findAllFields(typeNode), false, staticName, HandleConstructor$SkipIfConstructorExists.NO, onConstructor, annotationNode);
        }
    }
}
