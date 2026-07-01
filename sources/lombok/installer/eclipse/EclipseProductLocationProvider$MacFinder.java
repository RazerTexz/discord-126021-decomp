package lombok.installer.eclipse;

import java.io.File;
import java.util.Collections;

/* JADX INFO: loaded from: app.apk:lombok/installer/eclipse/EclipseProductLocationProvider$MacFinder.SCL.lombok */
class EclipseProductLocationProvider$MacFinder extends EclipseProductLocationProvider$DirectoryFinder {
    final /* synthetic */ EclipseProductLocationProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EclipseProductLocationProvider$MacFinder(EclipseProductLocationProvider eclipseProductLocationProvider) {
        super(eclipseProductLocationProvider, EclipseProductLocationProvider.access$4(eclipseProductLocationProvider, EclipseProductLocationProvider.access$2(eclipseProductLocationProvider).getSourceDirsOnMac()), Collections.emptyList());
        this.this$0 = eclipseProductLocationProvider;
    }

    @Override // lombok.installer.eclipse.EclipseProductLocationProvider$DirectoryFinder
    protected String findEclipseOnPlatform(File dir) {
        if (dir.getName().toLowerCase().equals(EclipseProductLocationProvider.access$2(this.this$0).getMacAppName().toLowerCase())) {
            return dir.getParent();
        }
        if (dir.getName().toLowerCase().contains(EclipseProductLocationProvider.access$2(this.this$0).getDirectoryName()) && new File(dir, EclipseProductLocationProvider.access$2(this.this$0).getMacAppName()).exists()) {
            return dir.toString();
        }
        return null;
    }
}
