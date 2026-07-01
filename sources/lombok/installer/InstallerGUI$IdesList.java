package lombok.installer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Scrollable;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$IdesList.SCL.lombok */
class InstallerGUI$IdesList extends JPanel implements Scrollable {
    private static final long serialVersionUID = 1;
    List<IdeLocation> locations = new ArrayList();
    final /* synthetic */ InstallerGUI this$0;

    InstallerGUI$IdesList(InstallerGUI installerGUI) {
        this.this$0 = installerGUI;
        setLayout(new BoxLayout(this, 1));
        setBackground(Color.WHITE);
    }

    List<IdeLocation> getSelectedIdes() {
        List<IdeLocation> list = new ArrayList<>();
        for (IdeLocation loc : this.locations) {
            if (loc.selected) {
                list.add(loc);
            }
        }
        return list;
    }

    void fireSelectionChange() {
        this.this$0.selectedLomboksChanged(getSelectedIdes());
    }

    void addLocation(IdeLocation location) {
        if (this.locations.contains(location)) {
            return;
        }
        Box box = Box.createHorizontalBox();
        box.setBackground(Color.WHITE);
        JCheckBox checkbox = new JCheckBox(location.getName());
        checkbox.setBackground(Color.WHITE);
        box.add(new JLabel(new ImageIcon(location.getIdeIcon())));
        box.add(checkbox);
        checkbox.setSelected(true);
        checkbox.addActionListener(new InstallerGUI$IdesList$1(this, location, checkbox));
        if (location.hasLombok()) {
            box.add(new JLabel(new ImageIcon(Installer.class.getResource("lombokIcon.png"))));
        }
        box.add(Box.createHorizontalGlue());
        this.locations.add(location);
        add(box);
        getParent().doLayout();
        fireSelectionChange();
    }

    public Dimension getPreferredScrollableViewportSize() {
        return new Dimension(1, 100);
    }

    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 12;
    }

    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 1;
    }
}
