package lombok.installer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$IdesList$1.SCL.lombok */
class InstallerGUI$IdesList$1 implements ActionListener {
    final /* synthetic */ InstallerGUI$IdesList this$1;
    private final /* synthetic */ IdeLocation val$location;
    private final /* synthetic */ JCheckBox val$checkbox;

    InstallerGUI$IdesList$1(InstallerGUI$IdesList installerGUI$IdesList, IdeLocation ideLocation, JCheckBox jCheckBox) {
        this.this$1 = installerGUI$IdesList;
        this.val$location = ideLocation;
        this.val$checkbox = jCheckBox;
    }

    public void actionPerformed(ActionEvent e) {
        this.val$location.selected = this.val$checkbox.isSelected();
        this.this$1.fireSelectionChange();
    }
}
