package lombok.installer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$7.SCL.lombok */
class InstallerGUI$7 implements ActionListener {
    final /* synthetic */ InstallerGUI this$0;

    InstallerGUI$7(InstallerGUI installerGUI) {
        this.this$0 = installerGUI;
    }

    public void actionPerformed(ActionEvent e) {
        List<IdeLocation> locationsToInstall = new ArrayList<>(InstallerGUI.access$7(this.this$0).getSelectedIdes());
        if (locationsToInstall.isEmpty()) {
            JOptionPane.showMessageDialog(InstallerGUI.access$0(this.this$0), "You haven't selected any IDE installations!.", "No Selection", 2);
        } else {
            InstallerGUI.access$10(this.this$0, locationsToInstall);
        }
    }
}
