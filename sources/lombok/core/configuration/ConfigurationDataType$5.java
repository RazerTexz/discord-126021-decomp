package lombok.core.configuration;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationDataType$5.SCL.lombok */
class ConfigurationDataType$5 implements ConfigurationValueParser {
    ConfigurationDataType$5() {
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public Object parse(String value) {
        return Boolean.valueOf(Boolean.parseBoolean(value));
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public String description() {
        return "boolean";
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public String exampleValue() {
        return "[false | true]";
    }
}
