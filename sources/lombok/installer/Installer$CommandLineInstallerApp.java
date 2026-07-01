package lombok.installer;

import java.util.List;
import lombok.core.LombokApp;

/* JADX INFO: loaded from: app.apk:lombok/installer/Installer$CommandLineInstallerApp.SCL.lombok */
public class Installer$CommandLineInstallerApp extends LombokApp {
    @Override // lombok.core.LombokApp
    public String getAppName() {
        return "install";
    }

    @Override // lombok.core.LombokApp
    public String getAppDescription() {
        return "Runs the 'handsfree' command line scriptable installer.";
    }

    @Override // lombok.core.LombokApp
    public int runApp(List<String> args) throws Exception {
        return Installer.cliInstaller(false, args);
    }
}
