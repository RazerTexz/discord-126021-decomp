package lombok.installer;

import java.util.Arrays;
import java.util.List;
import lombok.core.LombokApp;

/* JADX INFO: loaded from: app.apk:lombok/installer/Installer$GraphicalInstallerApp.SCL.lombok */
public class Installer$GraphicalInstallerApp extends LombokApp {
    @Override // lombok.core.LombokApp
    public String getAppName() {
        return "installer";
    }

    @Override // lombok.core.LombokApp
    public String getAppDescription() {
        return "Runs the graphical installer tool (default).";
    }

    @Override // lombok.core.LombokApp
    public List<String> getAppAliases() {
        return Arrays.asList("");
    }

    @Override // lombok.core.LombokApp
    public int runApp(List<String> args) throws Exception {
        return Installer.access$0();
    }
}
