package lombok.core.configuration;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import lombok.ConfigurationKeys;
import lombok.core.SpiLoadUtil;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationKeysLoader.SCL.lombok */
public interface ConfigurationKeysLoader {

    /* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationKeysLoader$LoaderLoader.SCL.lombok */
    public static class LoaderLoader {
        private static final AtomicBoolean alreadyLoaded = new AtomicBoolean(false);

        private LoaderLoader() {
        }

        public static void loadAllConfigurationKeys() {
            if (alreadyLoaded.get()) {
                return;
            }
            try {
                Class.forName(ConfigurationKeys.class.getName());
            } catch (Throwable unused) {
            }
            try {
                try {
                    Iterator<ConfigurationKeysLoader> iterator = SpiLoadUtil.findServices(ConfigurationKeysLoader.class, ConfigurationKeysLoader.class.getClassLoader()).iterator();
                    while (iterator.hasNext()) {
                        try {
                            iterator.next();
                        } catch (Exception unused2) {
                        }
                    }
                    alreadyLoaded.set(true);
                } catch (IOException e) {
                    throw new RuntimeException("Can't load config keys; services file issue.", e);
                }
            } catch (Throwable th) {
                alreadyLoaded.set(true);
                throw th;
            }
        }
    }
}
