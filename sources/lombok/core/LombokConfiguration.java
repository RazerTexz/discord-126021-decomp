package lombok.core;

import java.net.URI;
import java.util.Collections;
import lombok.core.configuration.BubblingConfigurationResolver;
import lombok.core.configuration.ConfigurationFileToSource;
import lombok.core.configuration.ConfigurationKey;
import lombok.core.configuration.ConfigurationParser;
import lombok.core.configuration.ConfigurationProblemReporter;
import lombok.core.configuration.ConfigurationResolver;
import lombok.core.configuration.ConfigurationResolverFactory;
import lombok.core.configuration.FileSystemSourceCache;

/* JADX INFO: loaded from: app.apk:lombok/core/LombokConfiguration.SCL.lombok */
public class LombokConfiguration {
    private static final ConfigurationResolver NULL_RESOLVER = new ConfigurationResolver() { // from class: lombok.core.LombokConfiguration.1
        @Override // lombok.core.configuration.ConfigurationResolver
        public <T> T resolve(ConfigurationKey<T> configurationKey) {
            if (configurationKey.getType().isList()) {
                return (T) Collections.emptyList();
            }
            return null;
        }
    };
    private static FileSystemSourceCache cache = new FileSystemSourceCache();
    private static ConfigurationResolverFactory configurationResolverFactory;

    static {
        if (System.getProperty("lombok.disableConfig") != null) {
            configurationResolverFactory = new ConfigurationResolverFactory() { // from class: lombok.core.LombokConfiguration.2
                @Override // lombok.core.configuration.ConfigurationResolverFactory
                public ConfigurationResolver createResolver(URI sourceLocation) {
                    return LombokConfiguration.NULL_RESOLVER;
                }
            };
        } else {
            configurationResolverFactory = createFileSystemBubblingResolverFactory();
        }
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
        final ConfigurationFileToSource fileToSource = cache.fileToSource(new ConfigurationParser(ConfigurationProblemReporter.CONSOLE));
        return new ConfigurationResolverFactory() { // from class: lombok.core.LombokConfiguration.3
            @Override // lombok.core.configuration.ConfigurationResolverFactory
            public ConfigurationResolver createResolver(URI sourceLocation) {
                return new BubblingConfigurationResolver(LombokConfiguration.cache.forUri(sourceLocation), fileToSource);
            }
        };
    }
}
