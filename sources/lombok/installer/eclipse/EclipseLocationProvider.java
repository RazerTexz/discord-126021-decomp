package lombok.installer.eclipse;

import java.util.Collections;

/* JADX INFO: loaded from: discord-126021.apk:lombok/installer/eclipse/EclipseLocationProvider.SCL.lombok */
public class EclipseLocationProvider extends EclipseProductLocationProvider {
    private static final EclipseProductDescriptor ECLIPSE = new StandardProductDescriptor("Eclipse", "eclipse", "eclipse", EclipseLocationProvider.class.getResource("eclipse.png"), Collections.emptySet());

    public EclipseLocationProvider() {
        super(ECLIPSE);
    }
}
