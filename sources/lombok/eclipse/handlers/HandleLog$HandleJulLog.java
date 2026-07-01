package lombok.eclipse.handlers;

import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.LoggingFramework;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.extern.java.Log;
import org.eclipse.jdt.internal.compiler.ast.Annotation;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleLog$HandleJulLog.SCL.lombok */
public class HandleLog$HandleJulLog extends EclipseAnnotationHandler<Log> {
    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<Log> annotation, Annotation source, EclipseNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_JUL_FLAG_USAGE, "@java.Log", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
        HandleLog.processAnnotation(LoggingFramework.JUL, annotation, source, annotationNode);
    }
}
