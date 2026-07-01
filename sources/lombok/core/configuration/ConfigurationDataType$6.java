package lombok.core.configuration;

import java.util.Arrays;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationDataType$6.SCL.lombok */
class ConfigurationDataType$6 implements ConfigurationValueParser {
    private final /* synthetic */ Class val$rawType;
    private final /* synthetic */ Class val$type;

    ConfigurationDataType$6(Class cls, Class cls2) {
        this.val$rawType = cls;
        this.val$type = cls2;
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public Object parse(String value) {
        try {
            return Enum.valueOf(this.val$rawType, value);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < value.length(); i++) {
                char c = value.charAt(i);
                if (Character.isUpperCase(c) && i > 0) {
                    sb.append("_");
                }
                sb.append(Character.toUpperCase(c));
            }
            return Enum.valueOf(this.val$rawType, sb.toString());
        }
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public String description() {
        return "enum (" + this.val$type.getName() + ")";
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public String exampleValue() {
        ExampleValueString evs = (ExampleValueString) this.val$type.getAnnotation(ExampleValueString.class);
        return evs != null ? evs.value() : Arrays.toString(this.val$type.getEnumConstants()).replace(",", " |");
    }
}
