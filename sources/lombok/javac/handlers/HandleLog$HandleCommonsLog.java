package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.LoggingFramework;
import lombok.extern.apachecommons.CommonsLog;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog$HandleCommonsLog.SCL.lombok */
public class HandleLog$HandleCommonsLog extends JavacAnnotationHandler<CommonsLog> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<CommonsLog> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_COMMONS_FLAG_USAGE, "@apachecommons.CommonsLog", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
        HandleLog.processAnnotation(LoggingFramework.COMMONS, annotation, annotationNode);
    }
}
