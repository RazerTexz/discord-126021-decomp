package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.LoggingFramework;
import lombok.extern.log4j.Log4j2;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog$HandleLog4j2Log.SCL.lombok */
public class HandleLog$HandleLog4j2Log extends JavacAnnotationHandler<Log4j2> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Log4j2> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_LOG4J2_FLAG_USAGE, "@Log4j2", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
        HandleLog.processAnnotation(LoggingFramework.LOG4J2, annotation, annotationNode);
    }
}
