package lombok.installer;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$6.SCL.lombok */
class InstallerGUI$6 implements ActionListener {
    final /* synthetic */ InstallerGUI this$0;

    InstallerGUI$6(InstallerGUI installerGUI) {
        this.this$0 = installerGUI;
    }

    public void actionPerformed(ActionEvent event) {
        List<Pattern> exeNames = Installer.getIdeExecutableNames();
        String file = null;
        if (OsUtils.getOS() == OsUtils$OS.MAC_OS_X) {
            FileDialog chooser = new FileDialog(InstallerGUI.access$0(this.this$0));
            chooser.setMode(0);
            chooser.setFilenameFilter(new InstallerGUI$6$1(this, exeNames));
            chooser.setVisible(true);
            if (chooser.getDirectory() != null && chooser.getFile() != null) {
                file = new File(chooser.getDirectory(), chooser.getFile()).getAbsolutePath();
            }
        } else {
            JFileChooser chooser2 = new JFileChooser();
            chooser2.setAcceptAllFileFilterUsed(false);
            chooser2.setFileSelectionMode(2);
            chooser2.setFileFilter(new InstallerGUI$6$2(this, exeNames));
            switch (chooser2.showDialog(InstallerGUI.access$0(this.this$0), "Select")) {
                case 0:
                    file = chooser2.getSelectedFile().getAbsolutePath();
                    break;
            }
        }
        if (file != null) {
            try {
                IdeLocation loc = Installer.tryAllProviders(file);
                if (loc != null) {
                    InstallerGUI.access$7(this.this$0).addLocation(loc);
                } else {
                    JOptionPane.showMessageDialog(InstallerGUI.access$0(this.this$0), "I can't find any IDE that lombok supports at location: " + file, "No IDE found", 2);
                }
            } catch (CorruptedIdeLocationException e) {
                e.showDialog(InstallerGUI.access$0(this.this$0));
            } catch (Throwable t) {
                InstallerGUI.access$8(this.this$0, t);
            }
        }
    }
}
