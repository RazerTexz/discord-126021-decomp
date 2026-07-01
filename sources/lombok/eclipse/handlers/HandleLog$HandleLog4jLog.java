package lombok.eclipse.handlers;

import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.LoggingFramework;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.extern.log4j.Log4j;
import org.eclipse.jdt.internal.compiler.ast.Annotation;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleLog$HandleLog4jLog.SCL.lombok */
public class HandleLog$HandleLog4jLog extends EclipseAnnotationHandler<Log4j> {
    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<Log4j> annotation, Annotation source, EclipseNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_LOG4J_FLAG_USAGE, "@Log4j", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
        HandleLog.processAnnotation(LoggingFramework.LOG4J, annotation, source, annotationNode);
    }
}
