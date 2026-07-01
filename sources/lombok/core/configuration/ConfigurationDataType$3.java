package lombok.core.configuration;

import com.adjust.sdk.Constants;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationDataType$3.SCL.lombok */
class ConfigurationDataType$3 implements ConfigurationValueParser {
    ConfigurationDataType$3() {
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public Object parse(String value) {
        return Long.valueOf(Long.parseLong(value));
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public String description() {
        return Constants.LONG;
    }

    @Override // lombok.core.configuration.ConfigurationValueParser
    public String exampleValue() {
        return "<long>";
    }
}
