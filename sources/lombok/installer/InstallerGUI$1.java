package lombok.installer;

import javax.swing.JOptionPane;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$1.SCL.lombok */
class InstallerGUI$1 implements Runnable {
    final /* synthetic */ InstallerGUI this$0;
    private final /* synthetic */ Throwable val$t;

    InstallerGUI$1(InstallerGUI installerGUI, Throwable th) {
        this.this$0 = installerGUI;
        this.val$t = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        JOptionPane.showMessageDialog(InstallerGUI.access$0(this.this$0), "There was a problem during the installation process:\n" + this.val$t, "Uh Oh!", 0);
        this.val$t.printStackTrace();
        System.exit(1);
    }
}
