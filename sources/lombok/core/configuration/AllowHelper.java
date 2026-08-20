package lombok.core.configuration;

import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/configuration/AllowHelper.SCL.lombok */
public final class AllowHelper {
    private static final Collection<? extends ConfigurationKey<?>> ALLOWABLE = Collections.emptySet();

    private AllowHelper() {
    }

    public static boolean isAllowable(ConfigurationKey<?> key) {
        return ALLOWABLE.contains(key);
    }
}
