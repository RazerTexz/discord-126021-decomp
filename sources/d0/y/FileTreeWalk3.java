package d0.y;

import d0.z.d.Intrinsics3;
import java.io.File;

/* JADX INFO: renamed from: d0.y.g, reason: use source file name */
/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes3.dex */
public class FileTreeWalk3 extends FileReadWrite {
    public static final FileTreeWalk walk(File file, FileTreeWalk2 fileTreeWalk2) {
        Intrinsics3.checkNotNullParameter(file, "$this$walk");
        Intrinsics3.checkNotNullParameter(fileTreeWalk2, "direction");
        return new FileTreeWalk(file, fileTreeWalk2);
    }

    public static final FileTreeWalk walkBottomUp(File file) {
        Intrinsics3.checkNotNullParameter(file, "$this$walkBottomUp");
        return walk(file, FileTreeWalk2.BOTTOM_UP);
    }
}
