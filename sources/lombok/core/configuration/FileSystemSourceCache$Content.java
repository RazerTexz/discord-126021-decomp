package lombok.core.configuration;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/FileSystemSourceCache$Content.SCL.lombok */
class FileSystemSourceCache$Content {
    ConfigurationSource source;
    long lastModified;
    long lastChecked;

    private FileSystemSourceCache$Content(ConfigurationSource source, long lastModified, long lastChecked) {
        this.source = source;
        this.lastModified = lastModified;
        this.lastChecked = lastChecked;
    }

    static FileSystemSourceCache$Content empty() {
        return new FileSystemSourceCache$Content(null, -88L, -1L);
    }
}
