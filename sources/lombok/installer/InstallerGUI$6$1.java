package lombok.installer;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$6$1.SCL.lombok */
class InstallerGUI$6$1 implements FilenameFilter {
    final /* synthetic */ InstallerGUI$6 this$1;
    private final /* synthetic */ List val$exeNames;

    InstallerGUI$6$1(InstallerGUI$6 installerGUI$6, List list) {
        this.this$1 = installerGUI$6;
        this.val$exeNames = list;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File dir, String fileName) {
        for (Pattern exeName : this.val$exeNames) {
            if (exeName.matcher(fileName).matches()) {
                return true;
            }
        }
        return false;
    }
}
