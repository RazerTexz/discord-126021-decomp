package lombok.installer;

import java.awt.Container;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.SwingUtilities;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$10.SCL.lombok */
class InstallerGUI$10 extends Thread {
    final /* synthetic */ InstallerGUI this$0;
    private final /* synthetic */ List val$toInstall;
    private final /* synthetic */ AtomicInteger val$successes;
    private final /* synthetic */ AtomicBoolean val$failure;
    private final /* synthetic */ Container val$appWindowContent;

    InstallerGUI$10(InstallerGUI installerGUI, List list, AtomicInteger atomicInteger, AtomicBoolean atomicBoolean, Container container) {
        this.this$0 = installerGUI;
        this.val$toInstall = list;
        this.val$successes = atomicInteger;
        this.val$failure = atomicBoolean;
        this.val$appWindowContent = container;
    }

    static /* synthetic */ InstallerGUI access$0(InstallerGUI$10 installerGUI$10) {
        return installerGUI$10.this$0;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        for (IdeLocation loc : this.val$toInstall) {
            try {
                InstallerGUI.access$13(this.this$0).add(loc.install());
                this.val$successes.incrementAndGet();
            } catch (InstallException e) {
                if (e.isWarning()) {
                    try {
                        SwingUtilities.invokeAndWait(new InstallerGUI$10$1(this, e));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        throw new RuntimeException(e2);
                    }
                } else {
                    this.val$failure.set(true);
                    try {
                        SwingUtilities.invokeAndWait(new InstallerGUI$10$2(this, e));
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        throw new RuntimeException(e3);
                    }
                }
            }
        }
        if (this.val$successes.get() > 0) {
            try {
                SwingUtilities.invokeAndWait(new InstallerGUI$10$3(this, this.val$appWindowContent));
                return;
            } catch (Exception e4) {
                throw new RuntimeException(e4);
            }
        }
        SwingUtilities.invokeLater(new InstallerGUI$10$4(this, this.val$failure));
    }
}
