package lombok.installer.eclipse;

import java.util.Collections;

/* JADX INFO: loaded from: discord-126021.apk:lombok/installer/eclipse/RhdsLocationProvider.SCL.lombok */
public class RhdsLocationProvider extends EclipseProductLocationProvider {
    private static final EclipseProductDescriptor RHDS = new StandardProductDescriptor("Red Hat JBoss Developer Studio", "devstudio", "studio", RhdsLocationProvider.class.getResource("rhds.png"), Collections.emptySet());

    public RhdsLocationProvider() {
        super(RHDS);
    }
}
