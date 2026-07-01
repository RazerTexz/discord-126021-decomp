package lombok.installer;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.filechooser.FileFilter;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$6$2.SCL.lombok */
class InstallerGUI$6$2 extends FileFilter {
    final /* synthetic */ InstallerGUI$6 this$1;
    private final /* synthetic */ List val$exeNames;

    InstallerGUI$6$2(InstallerGUI$6 installerGUI$6, List list) {
        this.this$1 = installerGUI$6;
        this.val$exeNames = list;
    }

    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        for (Pattern exeName : this.val$exeNames) {
            if (exeName.matcher(f.getName()).matches()) {
                return true;
            }
        }
        return false;
    }

    public String getDescription() {
        return "IDE Installation";
    }
}
