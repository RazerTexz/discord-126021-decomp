package lombok.installer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.font.TextAttribute;
import java.util.Collections;
import javax.swing.JButton;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$JHyperLink.SCL.lombok */
class InstallerGUI$JHyperLink extends JButton {
    private static final long serialVersionUID = 1;

    public InstallerGUI$JHyperLink(String text) {
        setFont(getFont().deriveFont(Collections.singletonMap(TextAttribute.UNDERLINE, 1)));
        setText(text);
        setBorder(null);
        setContentAreaFilled(false);
        setForeground(Color.BLUE);
        setCursor(Cursor.getPredefinedCursor(12));
        setMargin(new Insets(0, 0, 0, 0));
    }
}
