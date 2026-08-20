package lombok.core.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/configuration/LogDeclaration.SCL.lombok */
public final class LogDeclaration implements ConfigurationValueType {
    private static final Pattern PARAMETERS_PATTERN = Pattern.compile("(?:\\(([A-Z,]*)\\))");
    private static final Pattern DECLARATION_PATTERN = Pattern.compile("^(?:([^ ]+) )?([^(]+)\\.([^(]+)(" + PARAMETERS_PATTERN.pattern() + "+)$");
    private final TypeName loggerType;
    private final TypeName loggerFactoryType;
    private final IdentifierName loggerFactoryMethod;
    private final List<LogFactoryParameter> parametersWithoutTopic;
    private final List<LogFactoryParameter> parametersWithTopic;

    /* JADX INFO: loaded from: discord-126021.apk:lombok/core/configuration/LogDeclaration$LogFactoryParameter.SCL.lombok */
    public enum LogFactoryParameter {
        TYPE,
        NAME,
        TOPIC,
        NULL;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static LogFactoryParameter[] valuesCustom() {
            LogFactoryParameter[] logFactoryParameterArrValuesCustom = values();
            int length = logFactoryParameterArrValuesCustom.length;
            LogFactoryParameter[] logFactoryParameterArr = new LogFactoryParameter[length];
            System.arraycopy(logFactoryParameterArrValuesCustom, 0, logFactoryParameterArr, 0, length);
            return logFactoryParameterArr;
        }
    }

    private LogDeclaration(TypeName loggerType, TypeName loggerFactoryType, IdentifierName loggerFactoryMethod, List<LogFactoryParameter> parametersWithoutTopic, List<LogFactoryParameter> parametersWithTopic) {
        this.loggerType = loggerType;
        this.loggerFactoryType = loggerFactoryType;
        this.loggerFactoryMethod = loggerFactoryMethod;
        this.parametersWithoutTopic = parametersWithoutTopic;
        this.parametersWithTopic = parametersWithTopic;
    }

    public static LogDeclaration valueOf(String declaration) {
        if (declaration == null) {
            return null;
        }
        Matcher matcher = DECLARATION_PATTERN.matcher(declaration);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("The declaration must follow the pattern: [LoggerType ]LoggerFactoryType.loggerFactoryMethod(loggerFactoryMethodParams)[(loggerFactoryMethodParams)]");
        }
        TypeName loggerFactoryType = TypeName.valueOf(matcher.group(2));
        TypeName loggerType = TypeName.valueOf(matcher.group(1));
        if (loggerType == null) {
            loggerType = loggerFactoryType;
        }
        IdentifierName loggerFactoryMethod = IdentifierName.valueOf(matcher.group(3));
        List<List<LogFactoryParameter>> allParameters = parseParameters(matcher.group(4));
        List<LogFactoryParameter> parametersWithoutTopic = null;
        List<LogFactoryParameter> parametersWithTopic = null;
        for (List<LogFactoryParameter> parameters : allParameters) {
            if (parameters.contains(LogFactoryParameter.TOPIC)) {
                if (parametersWithTopic != null) {
                    throw new IllegalArgumentException("There is more than one parameter definition that includes TOPIC: " + parametersWithTopic + " and " + parameters);
                }
                parametersWithTopic = parameters;
            } else {
                if (parametersWithoutTopic != null) {
                    throw new IllegalArgumentException("There is more than one parmaeter definition that does not include TOPIC: " + parametersWithoutTopic + " and " + parameters);
                }
                parametersWithoutTopic = parameters;
            }
        }
        if (parametersWithoutTopic == null && parametersWithTopic == null) {
            throw new IllegalArgumentException("No logger factory method parameters specified.");
        }
        return new LogDeclaration(loggerType, loggerFactoryType, loggerFactoryMethod, parametersWithoutTopic, parametersWithTopic);
    }

    private static List<List<LogFactoryParameter>> parseParameters(String parametersDefinitions) {
        List<List<LogFactoryParameter>> allParameters = new ArrayList<>();
        Matcher matcher = PARAMETERS_PATTERN.matcher(parametersDefinitions);
        while (matcher.find()) {
            String parametersDefinition = matcher.group(1);
            List<LogFactoryParameter> parameters = new ArrayList<>();
            if (!parametersDefinition.isEmpty()) {
                for (String parameter : parametersDefinition.split(",")) {
                    parameters.add(LogFactoryParameter.valueOf(parameter));
                }
            }
            allParameters.add(parameters);
        }
        return allParameters;
    }

    public static String description() {
        return "custom-log-declaration";
    }

    public static String exampleValue() {
        return "my.cool.Logger my.cool.LoggerFactory.createLogger()(TOPIC,TYPE)";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LogDeclaration)) {
            return false;
        }
        if (this.loggerType.equals(((LogDeclaration) obj).loggerType) && this.loggerFactoryType.equals(((LogDeclaration) obj).loggerFactoryType) && this.loggerFactoryMethod.equals(((LogDeclaration) obj).loggerFactoryMethod) && this.parametersWithoutTopic == ((LogDeclaration) obj).parametersWithoutTopic) {
            return true;
        }
        return (this.parametersWithoutTopic.equals(((LogDeclaration) obj).parametersWithoutTopic) && this.parametersWithTopic == ((LogDeclaration) obj).parametersWithTopic) || this.parametersWithTopic.equals(((LogDeclaration) obj).parametersWithTopic);
    }

    public int hashCode() {
        int result = (31 * 1) + this.loggerType.hashCode();
        return (31 * ((31 * ((31 * ((31 * result) + this.loggerFactoryType.hashCode())) + this.loggerFactoryMethod.hashCode())) + (this.parametersWithTopic == null ? 0 : this.parametersWithTopic.hashCode()))) + (this.parametersWithoutTopic == null ? 0 : this.parametersWithoutTopic.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.loggerType);
        sb.append(" ");
        sb.append(this.loggerFactoryType);
        sb.append(".");
        sb.append(this.loggerFactoryMethod);
        appendParams(sb, this.parametersWithoutTopic);
        appendParams(sb, this.parametersWithTopic);
        return sb.toString();
    }

    private static void appendParams(StringBuilder sb, List<LogFactoryParameter> params) {
        if (params != null) {
            sb.append("(");
            boolean first = true;
            for (LogFactoryParameter param : params) {
                if (!first) {
                    sb.append(",");
                }
                first = false;
                sb.append(param);
            }
            sb.append(")");
        }
    }

    public TypeName getLoggerType() {
        return this.loggerType;
    }

    public TypeName getLoggerFactoryType() {
        return this.loggerFactoryType;
    }

    public IdentifierName getLoggerFactoryMethod() {
        return this.loggerFactoryMethod;
    }

    public List<LogFactoryParameter> getParametersWithoutTopic() {
        return this.parametersWithoutTopic;
    }

    public List<LogFactoryParameter> getParametersWithTopic() {
        return this.parametersWithTopic;
    }
}
