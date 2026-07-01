package lombok.eclipse.handlers;

import java.util.List;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.RequiredArgsConstructor;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.Annotation;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleConstructor$HandleRequiredArgsConstructor.SCL.lombok */
public class HandleConstructor$HandleRequiredArgsConstructor extends EclipseAnnotationHandler<RequiredArgsConstructor> {
    private static final String NAME = RequiredArgsConstructor.class.getSimpleName();
    private HandleConstructor handleConstructor = new HandleConstructor();

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<RequiredArgsConstructor> annotation, Annotation ast, EclipseNode annotationNode) {
        RequiredArgsConstructor ann;
        AccessLevel level;
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.REQUIRED_ARGS_CONSTRUCTOR_FLAG_USAGE, "@RequiredArgsConstructor", ConfigurationKeys.ANY_CONSTRUCTOR_FLAG_USAGE, "any @xArgsConstructor");
        EclipseNode typeNode = annotationNode.up();
        if (HandleConstructor.checkLegality(typeNode, annotationNode, NAME) && (level = (ann = annotation.getInstance()).access()) != AccessLevel.NONE) {
            String staticName = ann.staticName();
            if (annotation.isExplicit("suppressConstructorProperties")) {
                annotationNode.addError("This deprecated feature is no longer supported. Remove it; you can create a lombok.config file with 'lombok.anyConstructor.suppressConstructorProperties = true'.");
            }
            List<Annotation> onConstructor = EclipseHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onConstructor", "@RequiredArgsConstructor(onConstructor", annotationNode);
            this.handleConstructor.generateConstructor(typeNode, level, HandleConstructor.access$0(typeNode), false, staticName, HandleConstructor$SkipIfConstructorExists.NO, onConstructor, annotationNode);
        }
    }
}
