package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.LoggingFramework;
import lombok.extern.slf4j.XSlf4j;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog$HandleXSlf4jLog.SCL.lombok */
public class HandleLog$HandleXSlf4jLog extends JavacAnnotationHandler<XSlf4j> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<XSlf4j> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_XSLF4J_FLAG_USAGE, "@XSlf4j", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
        HandleLog.processAnnotation(LoggingFramework.XSLF4J, annotation, annotationNode);
    }
}
