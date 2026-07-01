package lombok.installer.eclipse;

import java.io.File;
import java.util.Collections;

/* JADX INFO: loaded from: app.apk:lombok/installer/eclipse/EclipseProductLocationProvider$WindowsFinder.SCL.lombok */
class EclipseProductLocationProvider$WindowsFinder extends EclipseProductLocationProvider$DirectoryFinder {
    final /* synthetic */ EclipseProductLocationProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EclipseProductLocationProvider$WindowsFinder(EclipseProductLocationProvider eclipseProductLocationProvider) {
        super(eclipseProductLocationProvider, EclipseProductLocationProvider.access$4(eclipseProductLocationProvider, EclipseProductLocationProvider.access$3(eclipseProductLocationProvider)), Collections.emptyList());
        this.this$0 = eclipseProductLocationProvider;
    }

    @Override // lombok.installer.eclipse.EclipseProductLocationProvider$DirectoryFinder
    protected String findEclipseOnPlatform(File dir) {
        File possible = new File(dir, EclipseProductLocationProvider.access$2(this.this$0).getWindowsExecutableName());
        if (possible.isFile()) {
            return dir.getAbsolutePath();
        }
        return null;
    }
}
