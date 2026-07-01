package lombok.core;

import java.net.URI;
import lombok.core.configuration.BubblingConfigurationResolver;
import lombok.core.configuration.ConfigurationFileToSource;
import lombok.core.configuration.ConfigurationResolver;
import lombok.core.configuration.ConfigurationResolverFactory;

/* JADX INFO: loaded from: app.apk:lombok/core/LombokConfiguration$3.SCL.lombok */
class LombokConfiguration$3 implements ConfigurationResolverFactory {
    private final /* synthetic */ ConfigurationFileToSource val$fileToSource;

    LombokConfiguration$3(ConfigurationFileToSource configurationFileToSource) {
        this.val$fileToSource = configurationFileToSource;
    }

    @Override // lombok.core.configuration.ConfigurationResolverFactory
    public ConfigurationResolver createResolver(URI sourceLocation) {
        return new BubblingConfigurationResolver(LombokConfiguration.access$1().forUri(sourceLocation), this.val$fileToSource);
    }
}
