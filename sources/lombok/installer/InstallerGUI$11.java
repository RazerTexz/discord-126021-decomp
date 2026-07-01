package lombok.installer;

import java.awt.Container;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.SwingUtilities;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$11.SCL.lombok */
class InstallerGUI$11 implements Runnable {
    final /* synthetic */ InstallerGUI this$0;
    private final /* synthetic */ AtomicInteger val$successes;
    private final /* synthetic */ Container val$originalContentPane;

    InstallerGUI$11(InstallerGUI installerGUI, AtomicInteger atomicInteger, Container container) {
        this.this$0 = installerGUI;
        this.val$successes = atomicInteger;
        this.val$originalContentPane = container;
    }

    static /* synthetic */ InstallerGUI access$0(InstallerGUI$11 installerGUI$11) {
        return installerGUI$11.this$0;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (IdeLocation loc : InstallerGUI.access$15(this.this$0)) {
            try {
                loc.uninstall();
                this.val$successes.incrementAndGet();
            } catch (UninstallException e) {
                if (e.isWarning()) {
                    try {
                        SwingUtilities.invokeAndWait(new InstallerGUI$11$1(this, e));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        throw new RuntimeException(e2);
                    }
                } else {
                    try {
                        SwingUtilities.invokeAndWait(new InstallerGUI$11$2(this, e));
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        throw new RuntimeException(e3);
                    }
                }
            }
        }
        SwingUtilities.invokeLater(new InstallerGUI$11$3(this, this.val$successes, this.val$originalContentPane));
    }
}
