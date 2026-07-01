package lombok.core.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationFile$ArchivedConfigurationFile.SCL.lombok */
class ConfigurationFile$ArchivedConfigurationFile extends ConfigurationFile {
    private static final URI ROOT1 = URI.create("http://x.y/a/");
    private static final URI ROOT2 = URI.create("ftp://y.x/b/");
    private static final ConcurrentMap<String, Object> locks = new ConcurrentHashMap();
    private final File archive;
    private final URI file;
    private final Object lock;
    private long lastModified;
    private String contents;

    public static ConfigurationFile create(File archive, URI file) {
        if (isRelative(file)) {
            return new ConfigurationFile$ArchivedConfigurationFile(archive, file, String.valueOf(archive.getPath()) + "!" + file.getPath());
        }
        return null;
    }

    static boolean isRelative(URI path) {
        try {
            return ROOT1.resolve(path).toString().startsWith(ROOT1.toString()) && ROOT2.resolve(path).toString().startsWith(ROOT2.toString());
        } catch (Exception unused) {
            return false;
        }
    }

    ConfigurationFile$ArchivedConfigurationFile(File archive, URI file, String description) {
        super(description, null);
        this.lastModified = -2L;
        this.archive = archive;
        this.file = file;
        locks.putIfAbsent(archive.getPath(), new Object());
        this.lock = locks.get(archive.getPath());
    }

    @Override // lombok.core.configuration.ConfigurationFile
    long getLastModifiedOrMissing() {
        return getLastModifiedOrMissing(this.archive);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Throwable] */
    @Override // lombok.core.configuration.ConfigurationFile
    boolean exists() {
        boolean z2;
        if (!ConfigurationFile.access$1(this.archive)) {
            return false;
        }
        ?? r0 = this.lock;
        synchronized (r0) {
            try {
                try {
                    readIfNeccesary();
                    r0 = this.contents;
                    z2 = r0 != 0;
                } catch (Exception unused) {
                    return false;
                }
            } catch (Throwable th) {
                throw r0;
            }
        }
        return z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.CharSequence, java.lang.String] */
    @Override // lombok.core.configuration.ConfigurationFile
    CharSequence contents() throws IOException {
        ?? r0 = this.lock;
        synchronized (r0) {
            try {
                readIfNeccesary();
                r0 = this.contents;
            } catch (Throwable th) {
                throw r0;
            }
        }
        return r0;
    }

    void readIfNeccesary() throws IOException {
        long archiveModified = getLastModifiedOrMissing();
        if (archiveModified == this.lastModified) {
            return;
        }
        this.contents = null;
        this.lastModified = archiveModified;
        if (archiveModified == -88) {
            return;
        }
        this.contents = read();
    }

    private String read() throws IOException {
        ZipEntry entry;
        FileInputStream is = new FileInputStream(this.archive);
        try {
            ZipInputStream zip = new ZipInputStream(is);
            do {
                try {
                    entry = zip.getNextEntry();
                    if (entry == null) {
                        zip.close();
                        is.close();
                        return null;
                    }
                } catch (Throwable th) {
                    zip.close();
                    throw th;
                }
            } while (!entry.getName().equals(this.file.getPath()));
            String strAccess$2 = ConfigurationFile.access$2(zip);
            zip.close();
            is.close();
            return strAccess$2;
        } catch (Throwable th2) {
            is.close();
            throw th2;
        }
    }

    @Override // lombok.core.configuration.ConfigurationFile
    public ConfigurationFile resolve(String path) {
        try {
            URI resolved = this.file.resolve(path);
            if (isRelative(resolved)) {
                return create(this.archive, resolved);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // lombok.core.configuration.ConfigurationFile
    ConfigurationFile parent() {
        return null;
    }
}
