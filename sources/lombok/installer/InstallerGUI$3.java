package lombok.installer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$3.SCL.lombok */
class InstallerGUI$3 implements ActionListener {
    final /* synthetic */ InstallerGUI this$0;

    InstallerGUI$3(InstallerGUI installerGUI) {
        this.this$0 = installerGUI;
    }

    public void actionPerformed(ActionEvent e) {
        InstallerGUI.access$5(this.this$0).setVisible(false);
        InstallerGUI.access$2(this.this$0).setVisible(true);
        InstallerGUI.access$3(this.this$0).setVisible(true);
        InstallerGUI.access$0(this.this$0).pack();
    }
}
