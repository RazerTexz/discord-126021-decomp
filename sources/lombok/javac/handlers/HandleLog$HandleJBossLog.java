package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.LoggingFramework;
import lombok.extern.jbosslog.JBossLog;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog$HandleJBossLog.SCL.lombok */
public class HandleLog$HandleJBossLog extends JavacAnnotationHandler<JBossLog> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<JBossLog> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_JBOSSLOG_FLAG_USAGE, "@JBossLog", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
        HandleLog.processAnnotation(LoggingFramework.JBOSSLOG, annotation, annotationNode);
    }
}
