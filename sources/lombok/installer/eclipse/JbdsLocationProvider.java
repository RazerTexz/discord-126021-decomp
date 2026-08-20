package lombok.installer.eclipse;

import java.util.Collections;

/* JADX INFO: loaded from: discord-126021.apk:lombok/installer/eclipse/JbdsLocationProvider.SCL.lombok */
public class JbdsLocationProvider extends EclipseProductLocationProvider {
    private static final EclipseProductDescriptor JBDS = new StandardProductDescriptor("JBoss Developer Studio", "jbdevstudio", "studio", JbdsLocationProvider.class.getResource("jbds.png"), Collections.emptySet());

    public JbdsLocationProvider() {
        super(JBDS);
    }
}
