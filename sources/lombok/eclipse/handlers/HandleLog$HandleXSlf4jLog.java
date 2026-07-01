package lombok.eclipse.handlers;

import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.LoggingFramework;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.extern.slf4j.XSlf4j;
import org.eclipse.jdt.internal.compiler.ast.Annotation;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleLog$HandleXSlf4jLog.SCL.lombok */
public class HandleLog$HandleXSlf4jLog extends EclipseAnnotationHandler<XSlf4j> {
    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<XSlf4j> annotation, Annotation source, EclipseNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_XSLF4J_FLAG_USAGE, "@XSlf4j", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
        HandleLog.processAnnotation(LoggingFramework.XSLF4J, annotation, source, annotationNode);
    }
}
