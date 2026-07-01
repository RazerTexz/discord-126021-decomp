package lombok.installer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$12.SCL.lombok */
class InstallerGUI$12 implements ActionListener {
    final /* synthetic */ InstallerGUI this$0;

    InstallerGUI$12(InstallerGUI installerGUI) {
        this.this$0 = installerGUI;
    }

    public void actionPerformed(ActionEvent e) {
        InstallerGUI.access$0(this.this$0).setVisible(false);
        System.exit(0);
    }
}
