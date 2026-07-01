package lombok.installer;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$10$4.SCL.lombok */
class InstallerGUI$10$4 implements Runnable {
    final /* synthetic */ InstallerGUI$10 this$1;
    private final /* synthetic */ AtomicBoolean val$failure;

    InstallerGUI$10$4(InstallerGUI$10 installerGUI$10, AtomicBoolean atomicBoolean) {
        this.this$1 = installerGUI$10;
        this.val$failure = atomicBoolean;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.atomic.AtomicReference<java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    @Override // java.lang.Runnable
    public void run() {
        ?? r0 = InstallerGUI.exitMarker;
        synchronized (r0) {
            try {
                InstallerGUI.exitMarker.set(Integer.valueOf(this.val$failure.get() ? 1 : 0));
                InstallerGUI.exitMarker.notifyAll();
                r0 = r0;
            } catch (Throwable th) {
                throw r0;
            }
        }
    }
}
