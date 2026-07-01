package lombok.core.configuration;

import java.io.File;
import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import lombok.core.debug.ProblemReporter;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/FileSystemSourceCache.SCL.lombok */
public class FileSystemSourceCache {
    private static final long FULL_CACHE_CLEAR_INTERVAL = TimeUnit.MINUTES.toMillis(30);
    private static final long RECHECK_FILESYSTEM = TimeUnit.SECONDS.toMillis(2);
    private static final long NEVER_CHECKED = -1;
    static final long MISSING = -88;
    private final ConcurrentMap<ConfigurationFile, FileSystemSourceCache$Content> fileCache = new ConcurrentHashMap();
    private final ConcurrentMap<URI, ConfigurationFile> uriCache = new ConcurrentHashMap();
    private volatile long lastCacheClear = System.currentTimeMillis();

    private void cacheClear() {
        long now = System.currentTimeMillis();
        long delta = now - this.lastCacheClear;
        if (delta > FULL_CACHE_CLEAR_INTERVAL) {
            this.lastCacheClear = now;
            this.fileCache.clear();
            this.uriCache.clear();
        }
    }

    public ConfigurationFileToSource fileToSource(ConfigurationParser parser) {
        return new FileSystemSourceCache$1(this, parser);
    }

    public ConfigurationFile forUri(URI javaFile) {
        if (javaFile == null) {
            return null;
        }
        cacheClear();
        ConfigurationFile result = this.uriCache.get(javaFile);
        if (result == null) {
            URI uri = javaFile.normalize();
            if (!uri.isAbsolute()) {
                uri = URI.create("file:" + uri.toString());
            }
            try {
                File file = new File(uri);
                if (!file.exists()) {
                    throw new IllegalArgumentException("File does not exist: " + uri);
                }
                File directory = file.isDirectory() ? file : file.getParentFile();
                if (directory != null) {
                    result = ConfigurationFile.forDirectory(directory);
                }
                this.uriCache.put(javaFile, result);
            } catch (IllegalArgumentException unused) {
            } catch (Exception e) {
                ProblemReporter.error("Can't find absolute path of file being compiled: " + javaFile, e);
            }
        }
        return result;
    }

    static /* synthetic */ ConfigurationSource access$0(FileSystemSourceCache fileSystemSourceCache, ConfigurationFile configurationFile, ConfigurationParser configurationParser) {
        return fileSystemSourceCache.parseIfNeccesary(configurationFile, configurationParser);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Throwable, lombok.core.configuration.FileSystemSourceCache$Content] */
    private ConfigurationSource parseIfNeccesary(ConfigurationFile file, ConfigurationParser parser) {
        long now = System.currentTimeMillis();
        ?? EnsureContent = ensureContent(file);
        synchronized (EnsureContent) {
            try {
                if (EnsureContent.lastChecked != -1 && now - EnsureContent.lastChecked < RECHECK_FILESYSTEM) {
                    return EnsureContent.source;
                }
                EnsureContent.lastChecked = now;
                long previouslyModified = EnsureContent.lastModified;
                EnsureContent.lastModified = file.getLastModifiedOrMissing();
                if (EnsureContent.lastModified != previouslyModified) {
                    EnsureContent.source = EnsureContent.lastModified == MISSING ? null : SingleConfigurationSource.parse(file, parser);
                }
                return EnsureContent.source;
            } catch (Throwable th) {
                throw EnsureContent;
            }
        }
    }

    private FileSystemSourceCache$Content ensureContent(ConfigurationFile context) {
        FileSystemSourceCache$Content content = this.fileCache.get(context);
        if (content != null) {
            return content;
        }
        this.fileCache.putIfAbsent(context, FileSystemSourceCache$Content.empty());
        return this.fileCache.get(context);
    }
}
