package lombok.installer;

import java.awt.Container;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JOptionPane;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$11$3.SCL.lombok */
class InstallerGUI$11$3 implements Runnable {
    final /* synthetic */ InstallerGUI$11 this$1;
    private final /* synthetic */ AtomicInteger val$successes;
    private final /* synthetic */ Container val$originalContentPane;

    InstallerGUI$11$3(InstallerGUI$11 installerGUI$11, AtomicInteger atomicInteger, Container container) {
        this.this$1 = installerGUI$11;
        this.val$successes = atomicInteger;
        this.val$originalContentPane = container;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.val$successes.get() > 0) {
            JOptionPane.showMessageDialog(InstallerGUI.access$0(InstallerGUI$11.access$0(this.this$1)), "Lombok has been removed from the selected IDE installations.", "Uninstall successful", 1);
            InstallerGUI.access$0(InstallerGUI$11.access$0(this.this$1)).setVisible(false);
            System.exit(0);
            return;
        }
        InstallerGUI.access$0(InstallerGUI$11.access$0(this.this$1)).setContentPane(this.val$originalContentPane);
    }
}
