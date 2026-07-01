package lombok.core;

import java.net.URI;
import lombok.core.configuration.ConfigurationFileToSource;
import lombok.core.configuration.ConfigurationKey;
import lombok.core.configuration.ConfigurationParser;
import lombok.core.configuration.ConfigurationProblemReporter;
import lombok.core.configuration.ConfigurationResolver;
import lombok.core.configuration.ConfigurationResolverFactory;
import lombok.core.configuration.FileSystemSourceCache;

/* JADX INFO: loaded from: app.apk:lombok/core/LombokConfiguration.SCL.lombok */
public class LombokConfiguration {
    private static final ConfigurationResolver NULL_RESOLVER = new LombokConfiguration$1();
    private static FileSystemSourceCache cache = new FileSystemSourceCache();
    private static ConfigurationResolverFactory configurationResolverFactory;

    static {
        if (System.getProperty("lombok.disableConfig") != null) {
            configurationResolverFactory = new LombokConfiguration$2();
        } else {
            configurationResolverFactory = createFileSystemBubblingResolverFactory();
        }
    }

    static /* synthetic */ ConfigurationResolver access$0() {
        return NULL_RESOLVER;
    }

    static /* synthetic */ FileSystemSourceCache access$1() {
        return cache;
    }

    private LombokConfiguration() {
    }

    public static void overrideConfigurationResolverFactory(ConfigurationResolverFactory crf) {
        configurationResolverFactory = crf == null ? createFileSystemBubblingResolverFactory() : crf;
    }

    static <T> T read(ConfigurationKey<T> configurationKey, AST<?, ?, ?> ast) {
        return (T) read(configurationKey, ast.getAbsoluteFileLocation());
    }

    public static <T> T read(ConfigurationKey<T> configurationKey, URI uri) {
        return (T) configurationResolverFactory.createResolver(uri).resolve(configurationKey);
    }

    private static ConfigurationResolverFactory createFileSystemBubblingResolverFactory() {
        ConfigurationFileToSource fileToSource = cache.fileToSource(new ConfigurationParser(ConfigurationProblemReporter.CONSOLE));
        return new LombokConfiguration$3(fileToSource);
    }
}
