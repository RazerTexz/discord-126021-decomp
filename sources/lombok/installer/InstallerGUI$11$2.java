package lombok.installer;

import javax.swing.JOptionPane;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$11$2.SCL.lombok */
class InstallerGUI$11$2 implements Runnable {
    final /* synthetic */ InstallerGUI$11 this$1;
    private final /* synthetic */ UninstallException val$e;

    InstallerGUI$11$2(InstallerGUI$11 installerGUI$11, UninstallException uninstallException) {
        this.this$1 = installerGUI$11;
        this.val$e = uninstallException;
    }

    @Override // java.lang.Runnable
    public void run() {
        JOptionPane.showMessageDialog(InstallerGUI.access$0(InstallerGUI$11.access$0(this.this$1)), this.val$e.getMessage(), "Uninstall Problem", 0);
    }
}
