package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.LoggingFramework;
import lombok.extern.java.Log;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog$HandleJulLog.SCL.lombok */
public class HandleLog$HandleJulLog extends JavacAnnotationHandler<Log> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Log> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_JUL_FLAG_USAGE, "@java.Log", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
        HandleLog.processAnnotation(LoggingFramework.JUL, annotation, annotationNode);
    }
}
