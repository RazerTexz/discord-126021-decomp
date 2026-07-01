package lombok.installer;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$5.SCL.lombok */
class InstallerGUI$5 extends Thread {
    final /* synthetic */ InstallerGUI this$0;

    InstallerGUI$5(InstallerGUI installerGUI) {
        this.this$0 = installerGUI;
    }

    static /* synthetic */ InstallerGUI access$0(InstallerGUI$5 installerGUI$5) {
        return installerGUI$5.this$0;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            List<IdeLocation> locations = new ArrayList<>();
            List<CorruptedIdeLocationException> problems = new ArrayList<>();
            Installer.autoDiscover(locations, problems);
            SwingUtilities.invokeLater(new InstallerGUI$5$1(this, locations, problems));
        } catch (Throwable t) {
            InstallerGUI.access$8(this.this$0, t);
        }
    }
}
