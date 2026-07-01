package lombok.installer;

import java.awt.Container;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$10$3.SCL.lombok */
class InstallerGUI$10$3 implements Runnable {
    final /* synthetic */ InstallerGUI$10 this$1;
    private final /* synthetic */ Container val$appWindowContent;

    InstallerGUI$10$3(InstallerGUI$10 installerGUI$10, Container container) {
        this.this$1 = installerGUI$10;
        this.val$appWindowContent = container;
    }

    @Override // java.lang.Runnable
    public void run() {
        InstallerGUI.access$0(InstallerGUI$10.access$0(this.this$1)).setContentPane(this.val$appWindowContent);
        InstallerGUI.access$0(InstallerGUI$10.access$0(this.this$1)).pack();
        StringBuilder installSpecific = new StringBuilder();
        for (String installSpecificMessage : InstallerGUI.access$13(InstallerGUI$10.access$0(this.this$1))) {
            installSpecific.append("<br>").append(installSpecificMessage);
        }
        InstallerGUI.access$14(InstallerGUI$10.access$0(this.this$1), installSpecific.toString());
    }
}
