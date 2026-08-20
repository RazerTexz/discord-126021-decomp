package lombok.core.handlers;

import java.lang.annotation.Annotation;
import lombok.core.configuration.LogDeclaration;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.flogger.Flogger;
import lombok.extern.java.Log;
import lombok.extern.jbosslog.JBossLog;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/handlers/LoggingFramework.SCL.lombok */
public class LoggingFramework {
    public static final LoggingFramework COMMONS = new LoggingFramework(CommonsLog.class, LogDeclaration.valueOf("org.apache.commons.logging.Log org.apache.commons.logging.LogFactory.getLog(TYPE)(TOPIC)"));
    public static final LoggingFramework JUL = new LoggingFramework(Log.class, LogDeclaration.valueOf("java.util.logging.Logger java.util.logging.Logger.getLogger(NAME)(TOPIC)"));
    public static final LoggingFramework LOG4J = new LoggingFramework(Log4j.class, LogDeclaration.valueOf("org.apache.log4j.Logger org.apache.log4j.Logger.getLogger(TYPE)(TOPIC)"));
    public static final LoggingFramework LOG4J2 = new LoggingFramework(Log4j2.class, LogDeclaration.valueOf("org.apache.logging.log4j.Logger org.apache.logging.log4j.LogManager.getLogger(TYPE)(TOPIC)"));
    public static final LoggingFramework SLF4J = new LoggingFramework(Slf4j.class, LogDeclaration.valueOf("org.slf4j.Logger org.slf4j.LoggerFactory.getLogger(TYPE)(TOPIC)"));
    public static final LoggingFramework XSLF4J = new LoggingFramework(XSlf4j.class, LogDeclaration.valueOf("org.slf4j.ext.XLogger org.slf4j.ext.XLoggerFactory.getXLogger(TYPE)(TOPIC)"));
    public static final LoggingFramework JBOSSLOG = new LoggingFramework(JBossLog.class, LogDeclaration.valueOf("org.jboss.logging.Logger org.jboss.logging.Logger.getLogger(TYPE)(TOPIC)"));
    public static final LoggingFramework FLOGGER = new LoggingFramework(Flogger.class, LogDeclaration.valueOf("com.google.common.flogger.FluentLogger com.google.common.flogger.FluentLogger.forEnclosingClass()"));
    private final Class<? extends Annotation> annotationClass;
    private final String annotationAsString;
    private final LogDeclaration declaration;

    public LoggingFramework(Class<? extends Annotation> annotationClass, LogDeclaration declaration) {
        this.annotationClass = annotationClass;
        this.annotationAsString = "@" + annotationClass.getSimpleName();
        this.declaration = declaration;
    }

    public Class<? extends Annotation> getAnnotationClass() {
        return this.annotationClass;
    }

    public String getAnnotationAsString() {
        return this.annotationAsString;
    }

    public LogDeclaration getDeclaration() {
        return this.declaration;
    }
}
