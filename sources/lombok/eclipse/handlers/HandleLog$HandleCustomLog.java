package lombok.eclipse.handlers;

import lombok.ConfigurationKeys;
import lombok.CustomLog;
import lombok.core.AnnotationValues;
import lombok.core.configuration.LogDeclaration;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.LoggingFramework;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.Annotation;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleLog$HandleCustomLog.SCL.lombok */
public class HandleLog$HandleCustomLog extends EclipseAnnotationHandler<CustomLog> {
    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<CustomLog> annotation, Annotation source, EclipseNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_CUSTOM_FLAG_USAGE, "@CustomLog", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
        LogDeclaration logDeclaration = (LogDeclaration) annotationNode.getAst().readConfiguration(ConfigurationKeys.LOG_CUSTOM_DECLARATION);
        if (logDeclaration == null) {
            annotationNode.addError("The @CustomLog annotation is not configured; please set log.custom.declaration in lombok.config.");
        } else {
            LoggingFramework framework = new LoggingFramework(CustomLog.class, logDeclaration);
            HandleLog.processAnnotation(framework, annotation, source, annotationNode);
        }
    }
}
