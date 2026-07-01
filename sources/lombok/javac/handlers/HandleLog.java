package lombok.javac.handlers;

import com.discord.models.domain.ModelAuditLogEntry;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.tree.JCTree$JCFieldAccess;
import com.sun.tools.javac.tree.JCTree$JCLiteral;
import com.sun.tools.javac.tree.JCTree$JCMethodInvocation;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import com.sun.tools.javac.util.Name;
import java.util.List;
import lombok.ConfigurationKeys;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.configuration.IdentifierName;
import lombok.core.configuration.LogDeclaration;
import lombok.core.configuration.LogDeclaration$LogFactoryParameter;
import lombok.core.handlers.LoggingFramework;
import lombok.javac.Javac;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

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
        int[] iArr2 = new int[AST$Kind.valuesCustom().length];
        try {
            iArr2[AST$Kind.ANNOTATION.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[AST$Kind.ARGUMENT.ordinal()] = 7;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[AST$Kind.COMPILATION_UNIT.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[AST$Kind.FIELD.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[AST$Kind.INITIALIZER.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[AST$Kind.LOCAL.ordinal()] = 8;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[AST$Kind.METHOD.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[AST$Kind.STATEMENT.ordinal()] = 9;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[AST$Kind.TYPE.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[AST$Kind.TYPE_USE.ordinal()] = 10;
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
        int[] iArr2 = new int[LogDeclaration$LogFactoryParameter.valuesCustom().length];
        try {
            iArr2[LogDeclaration$LogFactoryParameter.NAME.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[LogDeclaration$LogFactoryParameter.NULL.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[LogDeclaration$LogFactoryParameter.TOPIC.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[LogDeclaration$LogFactoryParameter.TYPE.ordinal()] = 1;
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
                } else if (JavacHandlerUtil.fieldExists(logFieldName.getName(), typeNode) != JavacHandlerUtil$MemberExistsResult.NOT_EXISTS) {
                    annotationNode.addWarning("Field '" + logFieldName + "' already exists.");
                } else {
                    Object valueGuess = annotation.getValueGuess(ModelAuditLogEntry.CHANGE_KEY_TOPIC);
                    JCTree$JCLiteral jCTree$JCLiteralLiteral = (JCTree$JCExpression) annotation.getActualExpression(ModelAuditLogEntry.CHANGE_KEY_TOPIC);
                    if ((valueGuess instanceof String) && ((String) valueGuess).trim().isEmpty()) {
                        jCTree$JCLiteralLiteral = null;
                    }
                    if (framework.getDeclaration().getParametersWithTopic() == null && jCTree$JCLiteralLiteral != null) {
                        annotationNode.addError(String.valueOf(framework.getAnnotationAsString()) + " does not allow a topic.");
                        jCTree$JCLiteralLiteral = null;
                    }
                    if (framework.getDeclaration().getParametersWithoutTopic() == null && jCTree$JCLiteralLiteral == null) {
                        annotationNode.addError(String.valueOf(framework.getAnnotationAsString()) + " requires a topic.");
                        jCTree$JCLiteralLiteral = typeNode.getTreeMaker().Literal("");
                    }
                    JCTree$JCFieldAccess loggingType = selfType(typeNode);
                    createField(framework, typeNode, loggingType, annotationNode.get(), logFieldName.getName(), useStatic, jCTree$JCLiteralLiteral);
                }
                break;
            default:
                annotationNode.addError("@Log is legal only on types.");
                break;
        }
    }

    public static JCTree$JCFieldAccess selfType(JavacNode typeNode) {
        JavacTreeMaker maker = typeNode.getTreeMaker();
        Name name = typeNode.get().name;
        return maker.Select(maker.Ident(name), typeNode.toName("class"));
    }

    private static boolean createField(LoggingFramework framework, JavacNode typeNode, JCTree$JCFieldAccess loggingType, JCTree source, String logFieldName, boolean useStatic, JCTree$JCExpression loggerTopic) {
        JavacTreeMaker maker = typeNode.getTreeMaker();
        LogDeclaration logDeclaration = framework.getDeclaration();
        JCTree$JCExpression loggerType = JavacHandlerUtil.chainDotsString(typeNode, logDeclaration.getLoggerType().getName());
        JCTree$JCExpression factoryMethod = JavacHandlerUtil.chainDotsString(typeNode, String.valueOf(logDeclaration.getLoggerFactoryType().getName()) + "." + logDeclaration.getLoggerFactoryMethod().getName());
        List<LogDeclaration$LogFactoryParameter> parameters = loggerTopic != null ? logDeclaration.getParametersWithTopic() : logDeclaration.getParametersWithoutTopic();
        JCTree$JCExpression[] factoryParameters = createFactoryParameters(typeNode, loggingType, parameters, loggerTopic);
        JCTree$JCMethodInvocation factoryMethodCall = maker.Apply(com.sun.tools.javac.util.List.nil(), factoryMethod, com.sun.tools.javac.util.List.from(factoryParameters));
        JCTree$JCVariableDecl fieldDecl = JavacHandlerUtil.recursiveSetGeneratedBy(maker.VarDef(maker.Modifiers(18 | (useStatic ? 8 : 0)), typeNode.toName(logFieldName), loggerType, factoryMethodCall), source, typeNode.getContext());
        JavacHandlerUtil.injectFieldAndMarkGenerated(typeNode, fieldDecl);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static JCTree$JCExpression[] createFactoryParameters(JavacNode typeNode, JCTree$JCFieldAccess loggingType, List<LogDeclaration$LogFactoryParameter> parameters, JCTree$JCExpression loggerTopic) {
        JCTree$JCExpression[] jCTree$JCExpressionArr = new JCTree$JCExpression[parameters.size()];
        JavacTreeMaker maker = typeNode.getTreeMaker();
        for (int i = 0; i < parameters.size(); i++) {
            LogDeclaration$LogFactoryParameter parameter = parameters.get(i);
            switch ($SWITCH_TABLE$lombok$core$configuration$LogDeclaration$LogFactoryParameter()[parameter.ordinal()]) {
                case 1:
                    jCTree$JCExpressionArr[i] = loggingType;
                    break;
                case 2:
                    jCTree$JCExpressionArr[i] = maker.Apply(com.sun.tools.javac.util.List.nil(), maker.Select(loggingType, typeNode.toName("getName")), com.sun.tools.javac.util.List.nil());
                    break;
                case 3:
                    jCTree$JCExpressionArr[i] = (JCTree$JCExpression) loggerTopic.clone();
                    break;
                case 4:
                    jCTree$JCExpressionArr[i] = maker.Literal(Javac.CTC_BOT, null);
                    break;
                default:
                    throw new IllegalStateException("Unknown logger factory parameter type: " + parameter);
            }
        }
        return jCTree$JCExpressionArr;
    }
}
