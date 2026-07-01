package lombok.core;

import java.util.Collections;
import lombok.core.configuration.ConfigurationKey;
import lombok.core.configuration.ConfigurationResolver;

/* JADX INFO: loaded from: app.apk:lombok/core/LombokConfiguration$1.SCL.lombok */
class LombokConfiguration$1 implements ConfigurationResolver {
    LombokConfiguration$1() {
    }

    @Override // lombok.core.configuration.ConfigurationResolver
    public <T> T resolve(ConfigurationKey<T> configurationKey) {
        if (configurationKey.getType().isList()) {
            return (T) Collections.emptyList();
        }
        return null;
    }
}
