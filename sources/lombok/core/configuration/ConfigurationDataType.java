package lombok.core.configuration;

import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationDataType.SCL.lombok */
public final class ConfigurationDataType {
    private static final Map<Class<?>, ConfigurationValueParser> SIMPLE_TYPES;
    private final boolean isList;
    private final ConfigurationValueParser parser;

    static {
        Map<Class<?>, ConfigurationValueParser> map = new HashMap<>();
        map.put(String.class, new ConfigurationDataType$1());
        map.put(Integer.class, new ConfigurationDataType$2());
        map.put(Long.class, new ConfigurationDataType$3());
        map.put(Double.class, new ConfigurationDataType$4());
        map.put(Boolean.class, new ConfigurationDataType$5());
        SIMPLE_TYPES = map;
    }

    private static ConfigurationValueParser enumParser(Type enumType) {
        Class<?> type = (Class) enumType;
        return new ConfigurationDataType$6(type, type);
    }

    private static ConfigurationValueParser valueTypeParser(Type argumentType) {
        Class<?> type = (Class) argumentType;
        Method valueOfMethod = getMethod(type, "valueOf", String.class);
        Method descriptionMethod = getMethod(type, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, new Class[0]);
        Method exampleValueMethod = getMethod(type, "exampleValue", new Class[0]);
        return new ConfigurationDataType$7(valueOfMethod, descriptionMethod, exampleValueMethod);
    }

    public static ConfigurationDataType toDataType(Class<? extends ConfigurationKey<?>> keyClass) {
        if (keyClass.getSuperclass() != ConfigurationKey.class) {
            throw new IllegalArgumentException("No direct subclass of ConfigurationKey: " + keyClass.getName());
        }
        Type type = keyClass.getGenericSuperclass();
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Missing type parameter in " + type);
        }
        ParameterizedType parameterized = (ParameterizedType) type;
        Type argumentType = parameterized.getActualTypeArguments()[0];
        boolean isList = false;
        if (argumentType instanceof ParameterizedType) {
            ParameterizedType parameterizedArgument = (ParameterizedType) argumentType;
            if (parameterizedArgument.getRawType() == List.class) {
                isList = true;
                argumentType = parameterizedArgument.getActualTypeArguments()[0];
            }
        }
        if (SIMPLE_TYPES.containsKey(argumentType)) {
            return new ConfigurationDataType(isList, SIMPLE_TYPES.get(argumentType));
        }
        if (isEnum(argumentType)) {
            return new ConfigurationDataType(isList, enumParser(argumentType));
        }
        if (isConfigurationValueType(argumentType)) {
            return new ConfigurationDataType(isList, valueTypeParser(argumentType));
        }
        throw new IllegalArgumentException("Unsupported type parameter in " + type);
    }

    private ConfigurationDataType(boolean isList, ConfigurationValueParser parser) {
        this.isList = isList;
        this.parser = parser;
    }

    public boolean isList() {
        return this.isList;
    }

    ConfigurationValueParser getParser() {
        return this.parser;
    }

    public String toString() {
        return this.isList ? "list of " + this.parser.description() : this.parser.description();
    }

    private static boolean isEnum(Type argumentType) {
        return (argumentType instanceof Class) && ((Class) argumentType).isEnum();
    }

    private static boolean isConfigurationValueType(Type argumentType) {
        return (argumentType instanceof Class) && ConfigurationValueType.class.isAssignableFrom((Class) argumentType);
    }

    private static Method getMethod(Class<?> argumentType, String name, Class<?>... clsArr) {
        try {
            return argumentType.getMethod(name, clsArr);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Method " + name + " with parameters " + Arrays.toString(clsArr) + " was not found.", e);
        } catch (SecurityException e2) {
            throw new IllegalStateException("Cannot inspect methods of type " + argumentType, e2);
        }
    }
}
