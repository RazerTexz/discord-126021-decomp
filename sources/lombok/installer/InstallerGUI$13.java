package lombok.installer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import javax.swing.JOptionPane;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$13.SCL.lombok */
class InstallerGUI$13 implements ActionListener {
    final /* synthetic */ InstallerGUI this$0;
    private final /* synthetic */ InstallerGUI$JHyperLink val$hyperlink;
    private final /* synthetic */ URI val$location;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$installer$OsUtils$OS;

    InstallerGUI$13(InstallerGUI installerGUI, InstallerGUI$JHyperLink installerGUI$JHyperLink, URI uri) {
        this.this$0 = installerGUI;
        this.val$hyperlink = installerGUI$JHyperLink;
        this.val$location = uri;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$installer$OsUtils$OS() {
        int[] iArr = $SWITCH_TABLE$lombok$installer$OsUtils$OS;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[OsUtils$OS.valuesCustom().length];
        try {
            iArr2[OsUtils$OS.MAC_OS_X.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[OsUtils$OS.UNIX.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[OsUtils$OS.WINDOWS.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$lombok$installer$OsUtils$OS = iArr2;
        return iArr2;
    }

    public void actionPerformed(ActionEvent event) {
        this.val$hyperlink.setForeground(new Color(85, Opcodes.I2B, 90));
        try {
            Object desktop = Class.forName("java.awt.Desktop").getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
            Class.forName("java.awt.Desktop").getMethod("browse", URI.class).invoke(desktop, this.val$location);
        } catch (Exception unused) {
            Runtime rt = Runtime.getRuntime();
            try {
                switch ($SWITCH_TABLE$lombok$installer$OsUtils$OS()[OsUtils.getOS().ordinal()]) {
                    case 1:
                        rt.exec("open " + this.val$location.toString());
                        break;
                    case 2:
                        String[] cmd = {"cmd.exe", "/C", "start", this.val$location.toString()};
                        rt.exec(cmd);
                        break;
                    case 3:
                    default:
                        rt.exec("firefox " + this.val$location.toString());
                        break;
                }
            } catch (Exception unused2) {
                JOptionPane.showMessageDialog(InstallerGUI.access$0(this.this$0), "Well, this is embarrassing. I don't know how to open a webbrowser.\nI guess you'll have to open it. Browse to:\n" + this.val$location + " for more information about Lombok.", "I'm embarrassed", 1);
            }
        }
    }
}
