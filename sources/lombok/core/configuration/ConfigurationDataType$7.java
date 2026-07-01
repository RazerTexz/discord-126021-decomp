package lombok.core.configuration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationDataType$7.SCL.lombok */
class ConfigurationDataType$7 implements ConfigurationValueParser {
    private final /* synthetic */ Method val$valueOfMethod;
    private final /* synthetic */ Method val$descriptionMethod;
    private final /* synthetic */ Method val$exampleValueMethod;

    ConfigurationDataType$7(Method method, Method method2, Method method3) {
        this.val$valueOfMethod = method;
        this.val$descriptionMethod = method2;
        this.val$exampleValueMethod = method3;
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public Object parse(String value) {
        return invokeStaticMethod(this.val$valueOfMethod, value);
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public String description() {
        return (String) invokeStaticMethod(this.val$descriptionMethod, new Object[0]);
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public String exampleValue() {
        return (String) invokeStaticMethod(this.val$exampleValueMethod, new Object[0]);
    }

    private <R> R invokeStaticMethod(Method method, Object... objArr) {
        try {
            return (R) method.invoke(null, objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("The method " + method.getName() + " ", e);
        } catch (InvocationTargetException e2) {
            throw ((RuntimeException) e2.getTargetException());
        }
    }
}
