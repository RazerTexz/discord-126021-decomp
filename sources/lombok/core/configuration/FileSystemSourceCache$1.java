package lombok.core.configuration;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/FileSystemSourceCache$1.SCL.lombok */
class FileSystemSourceCache$1 implements ConfigurationFileToSource {
    final /* synthetic */ FileSystemSourceCache this$0;
    private final /* synthetic */ ConfigurationParser val$parser;

    FileSystemSourceCache$1(FileSystemSourceCache fileSystemSourceCache, ConfigurationParser configurationParser) {
        this.this$0 = fileSystemSourceCache;
        this.val$parser = configurationParser;
    }

    @Override // lombok.core.configuration.ConfigurationFileToSource
    public ConfigurationSource parsed(ConfigurationFile fileLocation) {
        return FileSystemSourceCache.access$0(this.this$0, fileLocation, this.val$parser);
    }
}
