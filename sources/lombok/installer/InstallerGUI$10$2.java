package lombok.installer;

import javax.swing.JOptionPane;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$10$2.SCL.lombok */
class InstallerGUI$10$2 implements Runnable {
    final /* synthetic */ InstallerGUI$10 this$1;
    private final /* synthetic */ InstallException val$e;

    InstallerGUI$10$2(InstallerGUI$10 installerGUI$10, InstallException installException) {
        this.this$1 = installerGUI$10;
        this.val$e = installException;
    }

    @Override // java.lang.Runnable
    public void run() {
        JOptionPane.showMessageDialog(InstallerGUI.access$0(InstallerGUI$10.access$0(this.this$1)), this.val$e.getMessage(), "Install Problem", 0);
    }
}
