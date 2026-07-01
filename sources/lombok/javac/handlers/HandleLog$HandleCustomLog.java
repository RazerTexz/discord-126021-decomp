package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import lombok.ConfigurationKeys;
import lombok.CustomLog;
import lombok.core.AnnotationValues;
import lombok.core.configuration.LogDeclaration;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.LoggingFramework;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog$HandleCustomLog.SCL.lombok */
public class HandleLog$HandleCustomLog extends JavacAnnotationHandler<CustomLog> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<CustomLog> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_CUSTOM_FLAG_USAGE, "@CustomLog", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
        LogDeclaration logDeclaration = (LogDeclaration) annotationNode.getAst().readConfiguration(ConfigurationKeys.LOG_CUSTOM_DECLARATION);
        if (logDeclaration == null) {
            annotationNode.addError("The @CustomLog is not configured; please set log.custom.declaration in lombok.config.");
        } else {
            LoggingFramework framework = new LoggingFramework(CustomLog.class, logDeclaration);
            HandleLog.processAnnotation(framework, annotation, annotationNode);
        }
    }
}
