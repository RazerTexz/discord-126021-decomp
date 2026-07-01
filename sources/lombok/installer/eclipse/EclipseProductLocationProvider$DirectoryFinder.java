package lombok.installer.eclipse;

import java.io.File;
import java.util.List;
import lombok.installer.CorruptedIdeLocationException;
import lombok.installer.IdeLocation;

/* JADX INFO: loaded from: app.apk:lombok/installer/eclipse/EclipseProductLocationProvider$DirectoryFinder.SCL.lombok */
abstract class EclipseProductLocationProvider$DirectoryFinder {
    private final List<File> flatSourceDirs;
    private final List<File> nestedSourceDirs;
    final /* synthetic */ EclipseProductLocationProvider this$0;

    abstract String findEclipseOnPlatform(File file);

    EclipseProductLocationProvider$DirectoryFinder(EclipseProductLocationProvider eclipseProductLocationProvider, List<File> nestedSourceDirs, List<File> flatSourceDirs) {
        this.this$0 = eclipseProductLocationProvider;
        this.nestedSourceDirs = nestedSourceDirs;
        this.flatSourceDirs = flatSourceDirs;
    }

    void findEclipse(List<IdeLocation> locations, List<CorruptedIdeLocationException> problems) {
        for (File dir : this.nestedSourceDirs) {
            recurseDirectory(locations, problems, dir);
        }
        for (File dir2 : this.flatSourceDirs) {
            findEclipse(locations, problems, dir2);
        }
    }

    void recurseDirectory(List<IdeLocation> locations, List<CorruptedIdeLocationException> problems, File dir) {
        recurseDirectory0(locations, problems, dir, 0, false);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004b A[Catch: Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:11:0x0031, B:13:0x004b, B:15:0x005a), top: B:21:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x005a A[Catch: Exception -> 0x006a, TRY_LEAVE, TryCatch #0 {Exception -> 0x006a, blocks: (B:11:0x0031, B:13:0x004b, B:15:0x005a), top: B:21:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x006b A[SYNTHETIC] */
    private void recurseDirectory0(List<IdeLocation> locations, List<CorruptedIdeLocationException> problems, File f, int loopCounter, boolean nameFound) {
        File[] listFiles = f.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File dir : listFiles) {
            if (dir.isDirectory()) {
                if (nameFound) {
                    findEclipse(locations, problems, dir);
                    if (loopCounter < 50) {
                        recurseDirectory0(locations, problems, dir, loopCounter + 1, true);
                    }
                } else {
                    try {
                        if (dir.getName().toLowerCase().contains(EclipseProductLocationProvider.access$2(this.this$0).getDirectoryName())) {
                            findEclipse(locations, problems, dir);
                            if (loopCounter < 50) {
                                recurseDirectory0(locations, problems, dir, loopCounter + 1, true);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    private void findEclipse(List<IdeLocation> locations, List<CorruptedIdeLocationException> problems, File dir) {
        String eclipseLocation = findEclipseOnPlatform(dir);
        if (eclipseLocation != null) {
            try {
                IdeLocation newLocation = this.this$0.create(eclipseLocation);
                if (newLocation != null) {
                    locations.add(newLocation);
                }
            } catch (CorruptedIdeLocationException e) {
                problems.add(e);
            }
        }
    }
}
