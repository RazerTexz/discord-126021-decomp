package lombok.installer;

import java.util.List;
import lombok.core.LombokApp;

/* JADX INFO: loaded from: app.apk:lombok/installer/Installer$CommandLineUninstallerApp.SCL.lombok */
public class Installer$CommandLineUninstallerApp extends LombokApp {
    @Override // lombok.core.LombokApp
    public String getAppName() {
        return "uninstall";
    }

    @Override // lombok.core.LombokApp
    public String getAppDescription() {
        return "Runs the 'handsfree' command line scriptable uninstaller.";
    }

    @Override // lombok.core.LombokApp
    public int runApp(List<String> args) throws Exception {
        return Installer.cliInstaller(true, args);
    }
}
