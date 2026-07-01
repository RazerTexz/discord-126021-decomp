package lombok.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/core/Main$VersionApp.SCL.lombok */
public class Main$VersionApp extends LombokApp {
    @Override // lombok.core.LombokApp
    public String getAppName() {
        return "version";
    }

    @Override // lombok.core.LombokApp
    public String getAppDescription() {
        return "prints lombok's version.";
    }

    @Override // lombok.core.LombokApp
    public List<String> getAppAliases() {
        return Arrays.asList("-version", "--version");
    }

    @Override // lombok.core.LombokApp
    public int runApp(List<String> args) {
        System.out.println(Version.getFullVersion());
        return 0;
    }
}
