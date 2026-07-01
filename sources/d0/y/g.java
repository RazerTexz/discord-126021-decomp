package d0.y;

import d0.z.d.m;
import java.io.File;

/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes3.dex */
public class g extends f {
    public static final d walk(File file, e eVar) {
        m.checkNotNullParameter(file, "$this$walk");
        m.checkNotNullParameter(eVar, "direction");
        return new d(file, eVar);
    }

    public static final d walkBottomUp(File file) {
        m.checkNotNullParameter(file, "$this$walkBottomUp");
        return walk(file, e.BOTTOM_UP);
    }
}
