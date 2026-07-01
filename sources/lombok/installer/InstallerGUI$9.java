package lombok.installer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$9.SCL.lombok */
class InstallerGUI$9 implements ActionListener {
    final /* synthetic */ InstallerGUI this$0;

    InstallerGUI$9(InstallerGUI installerGUI) {
        this.this$0 = installerGUI;
    }

    public void actionPerformed(ActionEvent e) {
        List<IdeLocation> locationsToUninstall = new ArrayList<>();
        for (IdeLocation location : InstallerGUI.access$7(this.this$0).getSelectedIdes()) {
            if (location.hasLombok()) {
                locationsToUninstall.add(location);
            }
        }
        if (locationsToUninstall.isEmpty()) {
            JOptionPane.showMessageDialog(InstallerGUI.access$0(this.this$0), "You haven't selected any IDE installations that have been lombok-enabled.", "No Selection", 2);
        } else {
            InstallerGUI.access$12(this.this$0, locationsToUninstall);
        }
    }
}
