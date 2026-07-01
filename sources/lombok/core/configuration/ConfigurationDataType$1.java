package lombok.core.configuration;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationDataType$1.SCL.lombok */
class ConfigurationDataType$1 implements ConfigurationValueParser {
    ConfigurationDataType$1() {
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public Object parse(String value) {
        return value;
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public String description() {
        return "string";
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public String exampleValue() {
        return "<text>";
    }
}
