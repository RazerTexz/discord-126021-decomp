package lombok.core.configuration;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationDataType$4.SCL.lombok */
class ConfigurationDataType$4 implements ConfigurationValueParser {
    ConfigurationDataType$4() {
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public Object parse(String value) {
        return Double.valueOf(Double.parseDouble(value));
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public String description() {
        return "double";
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public String exampleValue() {
        return "<double>";
    }
}
