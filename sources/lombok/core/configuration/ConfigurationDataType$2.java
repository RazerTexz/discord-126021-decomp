package lombok.core.configuration;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationDataType$2.SCL.lombok */
class ConfigurationDataType$2 implements ConfigurationValueParser {
    ConfigurationDataType$2() {
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public Object parse(String value) {
        return Integer.valueOf(Integer.parseInt(value));
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public String description() {
        return "int";
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public String exampleValue() {
        return "<int>";
    }
}
