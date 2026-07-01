package lombok.core;

import java.net.URI;
import lombok.core.configuration.ConfigurationResolver;
import lombok.core.configuration.ConfigurationResolverFactory;

/* JADX INFO: loaded from: app.apk:lombok/core/LombokConfiguration$2.SCL.lombok */
class LombokConfiguration$2 implements ConfigurationResolverFactory {
    LombokConfiguration$2() {
    }

    @Override // lombok.core.configuration.ConfigurationResolverFactory
    public ConfigurationResolver createResolver(URI sourceLocation) {
        return LombokConfiguration.access$0();
    }
}
