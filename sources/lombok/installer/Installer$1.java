package lombok.installer;

import java.awt.HeadlessException;
import javax.swing.UIManager;

/* JADX INFO: loaded from: app.apk:lombok/installer/Installer$1.SCL.lombok */
class Installer$1 implements Runnable {
    Installer$1() {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception unused) {
            }
            new InstallerGUI().show();
        } catch (HeadlessException unused2) {
            Installer.access$1();
        }
    }
}
