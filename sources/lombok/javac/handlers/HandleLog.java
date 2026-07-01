package lombok.javac.handlers;

import com.discord.models.domain.ModelAuditLogEntry;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.Name;
import java.util.List;
import lombok.ConfigurationKeys;
import lombok.CustomLog;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.configuration.IdentifierName;
import lombok.core.configuration.LogDeclaration;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.LoggingFramework;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.flogger.Flogger;
import lombok.extern.java.Log;
import lombok.extern.jbosslog.JBossLog;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.javac.handlers.JavacHandlerUtil;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog.SCL.lombok */
public class HandleLog {
    private static final IdentifierName LOG = IdentifierName.valueOf("log");
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$configuration$LogDeclaration$LogFactoryParameter;

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind() {
        int[] iArr = $SWITCH_TABLE$lombok$core$AST$Kind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AST.Kind.valuesCustom().length];
        try {
            iArr2[AST.Kind.ANNOTATION.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[AST.Kind.ARGUMENT.ordinal()] = 7;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[AST.Kind.COMPILATION_UNIT.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[AST.Kind.FIELD.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[AST.Kind.INITIALIZER.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[AST.Kind.LOCAL.ordinal()] = 8;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[AST.Kind.METHOD.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[AST.Kind.STATEMENT.ordinal()] = 9;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[AST.Kind.TYPE.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[AST.Kind.TYPE_USE.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        $SWITCH_TABLE$lombok$core$AST$Kind = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$configuration$LogDeclaration$LogFactoryParameter() {
        int[] iArr = $SWITCH_TABLE$lombok$core$configuration$LogDeclaration$LogFactoryParameter;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[LogDeclaration.LogFactoryParameter.valuesCustom().length];
        try {
            iArr2[LogDeclaration.LogFactoryParameter.NAME.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[LogDeclaration.LogFactoryParameter.NULL.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[LogDeclaration.LogFactoryParameter.TOPIC.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[LogDeclaration.LogFactoryParameter.TYPE.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$lombok$core$configuration$LogDeclaration$LogFactoryParameter = iArr2;
        return iArr2;
    }

    private HandleLog() {
        throw new UnsupportedOperationException();
    }

    public static void processAnnotation(LoggingFramework framework, AnnotationValues<?> annotation, JavacNode annotationNode) {
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, framework.getAnnotationClass());
        JavacNode typeNode = annotationNode.up();
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[typeNode.getKind().ordinal()]) {
            case 2:
                IdentifierName logFieldName = (IdentifierName) annotationNode.getAst().readConfiguration(ConfigurationKeys.LOG_ANY_FIELD_NAME);
                if (logFieldName == null) {
                    logFieldName = LOG;
                }
                boolean useStatic = !Boolean.FALSE.equals(annotationNode.getAst().readConfiguration(ConfigurationKeys.LOG_ANY_FIELD_IS_STATIC));
                if ((typeNode.get().mods.flags & 512) != 0) {
                    annotationNode.addError(String.valueOf(framework.getAnnotationAsString()) + " is legal only on classes and enums.");
                } else if (JavacHandlerUtil.fieldExists(logFieldName.getName(), typeNode) != JavacHandlerUtil.MemberExistsResult.NOT_EXISTS) {
                    annotationNode.addWarning("Field '" + logFieldName + "' already exists.");
                } else {
                    Object valueGuess = annotation.getValueGuess(ModelAuditLogEntry.CHANGE_KEY_TOPIC);
                    JCTree.JCLiteral jCLiteralLiteral = (JCTree.JCExpression) annotation.getActualExpression(ModelAuditLogEntry.CHANGE_KEY_TOPIC);
                    if ((valueGuess instanceof String) && ((String) valueGuess).trim().isEmpty()) {
                        jCLiteralLiteral = null;
                    }
                    if (framework.getDeclaration().getParametersWithTopic() == null && jCLiteralLiteral != null) {
                        annotationNode.addError(String.valueOf(framework.getAnnotationAsString()) + " does not allow a topic.");
                        jCLiteralLiteral = null;
                    }
                    if (framework.getDeclaration().getParametersWithoutTopic() == null && jCLiteralLiteral == null) {
                        annotationNode.addError(String.valueOf(framework.getAnnotationAsString()) + " requires a topic.");
                        jCLiteralLiteral = typeNode.getTreeMaker().Literal("");
                    }
                    JCTree.JCFieldAccess loggingType = selfType(typeNode);
                    createField(framework, typeNode, loggingType, annotationNode.get(), logFieldName.getName(), useStatic, jCLiteralLiteral);
                }
                break;
            default:
                annotationNode.addError("@Log is legal only on types.");
                break;
        }
    }

    public static JCTree.JCFieldAccess selfType(JavacNode typeNode) {
        JavacTreeMaker maker = typeNode.getTreeMaker();
        Name name = typeNode.get().name;
        return maker.Select(maker.Ident(name), typeNode.toName("class"));
    }

    private static boolean createField(LoggingFramework framework, JavacNode typeNode, JCTree.JCFieldAccess loggingType, JCTree source, String logFieldName, boolean useStatic, JCTree.JCExpression loggerTopic) {
        JavacTreeMaker maker = typeNode.getTreeMaker();
        LogDeclaration logDeclaration = framework.getDeclaration();
        JCTree.JCExpression loggerType = JavacHandlerUtil.chainDotsString(typeNode, logDeclaration.getLoggerType().getName());
        JCTree.JCExpression factoryMethod = JavacHandlerUtil.chainDotsString(typeNode, String.valueOf(logDeclaration.getLoggerFactoryType().getName()) + "." + logDeclaration.getLoggerFactoryMethod().getName());
        List<LogDeclaration.LogFactoryParameter> parameters = loggerTopic != null ? logDeclaration.getParametersWithTopic() : logDeclaration.getParametersWithoutTopic();
        JCTree.JCExpression[] factoryParameters = createFactoryParameters(typeNode, loggingType, parameters, loggerTopic);
        JCTree.JCMethodInvocation factoryMethodCall = maker.Apply(com.sun.tools.javac.util.List.nil(), factoryMethod, com.sun.tools.javac.util.List.from(factoryParameters));
        JCTree.JCVariableDecl fieldDecl = JavacHandlerUtil.recursiveSetGeneratedBy(maker.VarDef(maker.Modifiers(18 | (useStatic ? 8 : 0)), typeNode.toName(logFieldName), loggerType, factoryMethodCall), source, typeNode.getContext());
        JavacHandlerUtil.injectFieldAndMarkGenerated(typeNode, fieldDecl);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static JCTree.JCExpression[] createFactoryParameters(JavacNode typeNode, JCTree.JCFieldAccess loggingType, List<LogDeclaration.LogFactoryParameter> parameters, JCTree.JCExpression loggerTopic) {
        JCTree.JCExpression[] jCExpressionArr = new JCTree.JCExpression[parameters.size()];
        JavacTreeMaker maker = typeNode.getTreeMaker();
        for (int i = 0; i < parameters.size(); i++) {
            LogDeclaration.LogFactoryParameter parameter = parameters.get(i);
            switch ($SWITCH_TABLE$lombok$core$configuration$LogDeclaration$LogFactoryParameter()[parameter.ordinal()]) {
                case 1:
                    jCExpressionArr[i] = loggingType;
                    break;
                case 2:
                    jCExpressionArr[i] = maker.Apply(com.sun.tools.javac.util.List.nil(), maker.Select(loggingType, typeNode.toName("getName")), com.sun.tools.javac.util.List.nil());
                    break;
                case 3:
                    jCExpressionArr[i] = (JCTree.JCExpression) loggerTopic.clone();
                    break;
                case 4:
                    jCExpressionArr[i] = maker.Literal(Javac.CTC_BOT, null);
                    break;
                default:
                    throw new IllegalStateException("Unknown logger factory parameter type: " + parameter);
            }
        }
        return jCExpressionArr;
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog$HandleCommonsLog.SCL.lombok */
    public static class HandleCommonsLog extends JavacAnnotationHandler<CommonsLog> {
        @Override // lombok.javac.JavacAnnotationHandler
        public void handle(AnnotationValues<CommonsLog> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_COMMONS_FLAG_USAGE, "@apachecommons.CommonsLog", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.COMMONS, annotation, annotationNode);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog$HandleJulLog.SCL.lombok */
    public static class HandleJulLog extends JavacAnnotationHandler<Log> {
        @Override // lombok.javac.JavacAnnotationHandler
        public void handle(AnnotationValues<Log> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_JUL_FLAG_USAGE, "@java.Log", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.JUL, annotation, annotationNode);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog$HandleLog4jLog.SCL.lombok */
    public static class HandleLog4jLog extends JavacAnnotationHandler<Log4j> {
        @Override // lombok.javac.JavacAnnotationHandler
        public void handle(AnnotationValues<Log4j> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_LOG4J_FLAG_USAGE, "@Log4j", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.LOG4J, annotation, annotationNode);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog$HandleLog4j2Log.SCL.lombok */
    public static class HandleLog4j2Log extends JavacAnnotationHandler<Log4j2> {
        @Override // lombok.javac.JavacAnnotationHandler
        public void handle(AnnotationValues<Log4j2> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_LOG4J2_FLAG_USAGE, "@Log4j2", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.LOG4J2, annotation, annotationNode);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog$HandleSlf4jLog.SCL.lombok */
    public static class HandleSlf4jLog extends JavacAnnotationHandler<Slf4j> {
        @Override // lombok.javac.JavacAnnotationHandler
        public void handle(AnnotationValues<Slf4j> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_SLF4J_FLAG_USAGE, "@Slf4j", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.SLF4J, annotation, annotationNode);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog$HandleXSlf4jLog.SCL.lombok */
    public static class HandleXSlf4jLog extends JavacAnnotationHandler<XSlf4j> {
        @Override // lombok.javac.JavacAnnotationHandler
        public void handle(AnnotationValues<XSlf4j> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_XSLF4J_FLAG_USAGE, "@XSlf4j", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.XSLF4J, annotation, annotationNode);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog$HandleJBossLog.SCL.lombok */
    public static class HandleJBossLog extends JavacAnnotationHandler<JBossLog> {
        @Override // lombok.javac.JavacAnnotationHandler
        public void handle(AnnotationValues<JBossLog> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_JBOSSLOG_FLAG_USAGE, "@JBossLog", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.JBOSSLOG, annotation, annotationNode);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog$HandleFloggerLog.SCL.lombok */
    public static class HandleFloggerLog extends JavacAnnotationHandler<Flogger> {
        @Override // lombok.javac.JavacAnnotationHandler
        public void handle(AnnotationValues<Flogger> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_FLOGGER_FLAG_USAGE, "@Flogger", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.FLOGGER, annotation, annotationNode);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleLog$HandleCustomLog.SCL.lombok */
    public static class HandleCustomLog extends JavacAnnotationHandler<CustomLog> {
        @Override // lombok.javac.JavacAnnotationHandler
        public void handle(AnnotationValues<CustomLog> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
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
}
