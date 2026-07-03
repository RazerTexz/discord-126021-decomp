package p507d0.p591y;

import java.io.File;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.y.g */
/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12206g extends C12205f {
    public static final C12203d walk(File file, EnumC12204e enumC12204e) {
        C12238m.checkNotNullParameter(file, "$this$walk");
        C12238m.checkNotNullParameter(enumC12204e, "direction");
        return new C12203d(file, enumC12204e);
    }

    public static final C12203d walkBottomUp(File file) {
        C12238m.checkNotNullParameter(file, "$this$walkBottomUp");
        return walk(file, EnumC12204e.BOTTOM_UP);
    }
}
