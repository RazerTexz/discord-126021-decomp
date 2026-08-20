package lombok.core.configuration;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/configuration/ConfigurationResolver.SCL.lombok */
public interface ConfigurationResolver {
    <T> T resolve(ConfigurationKey<T> configurationKey);
}
