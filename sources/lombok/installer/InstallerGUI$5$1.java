package lombok.installer;

import java.util.List;
import javax.swing.JOptionPane;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$5$1.SCL.lombok */
class InstallerGUI$5$1 implements Runnable {
    final /* synthetic */ InstallerGUI$5 this$1;
    private final /* synthetic */ List val$locations;
    private final /* synthetic */ List val$problems;

    InstallerGUI$5$1(InstallerGUI$5 installerGUI$5, List list, List list2) {
        this.this$1 = installerGUI$5;
        this.val$locations = list;
        this.val$problems = list2;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (IdeLocation location : this.val$locations) {
            try {
                InstallerGUI.access$7(InstallerGUI$5.access$0(this.this$1)).addLocation(location);
            } catch (Throwable t) {
                InstallerGUI.access$8(InstallerGUI$5.access$0(this.this$1), t);
            }
        }
        for (CorruptedIdeLocationException problem : this.val$problems) {
            problem.showDialog(InstallerGUI.access$0(InstallerGUI$5.access$0(this.this$1)));
        }
        InstallerGUI.access$9(InstallerGUI$5.access$0(this.this$1)).setVisible(false);
        if (this.val$locations.size() + this.val$problems.size() == 0) {
            JOptionPane.showMessageDialog(InstallerGUI.access$0(InstallerGUI$5.access$0(this.this$1)), "I can't find any IDEs on your computer.\nIf you have IDEs installed on this computer, please use the 'Specify Location...' button to manually point out the \nlocation of your IDE installation to me. Thanks!", "Can't find IDE", 1);
        }
    }
}
