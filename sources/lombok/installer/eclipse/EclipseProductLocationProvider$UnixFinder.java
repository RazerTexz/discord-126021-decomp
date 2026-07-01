package lombok.installer.eclipse;

import java.io.File;

/* JADX INFO: loaded from: app.apk:lombok/installer/eclipse/EclipseProductLocationProvider$UnixFinder.SCL.lombok */
class EclipseProductLocationProvider$UnixFinder extends EclipseProductLocationProvider$DirectoryFinder {
    final /* synthetic */ EclipseProductLocationProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EclipseProductLocationProvider$UnixFinder(EclipseProductLocationProvider eclipseProductLocationProvider) {
        super(eclipseProductLocationProvider, EclipseProductLocationProvider.access$0(eclipseProductLocationProvider), EclipseProductLocationProvider.access$1(eclipseProductLocationProvider));
        this.this$0 = eclipseProductLocationProvider;
    }

    @Override // lombok.installer.eclipse.EclipseProductLocationProvider$DirectoryFinder
    protected String findEclipseOnPlatform(File dir) {
        File possible = new File(dir, EclipseProductLocationProvider.access$2(this.this$0).getUnixAppName());
        if (possible.exists()) {
            return possible.getAbsolutePath();
        }
        return null;
    }
}
