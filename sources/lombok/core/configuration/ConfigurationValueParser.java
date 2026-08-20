package lombok.core.configuration;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/configuration/ConfigurationValueParser.SCL.lombok */
interface ConfigurationValueParser {
    Object parse(String str);

    String description();

    String exampleValue();
}
