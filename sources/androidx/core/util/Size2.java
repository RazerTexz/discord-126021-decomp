package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.util.SizeKt, reason: use source file name */
/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Size2 {
    @RequiresApi(21)
    public static final int component1(Size size) {
        Intrinsics3.checkNotNullParameter(size, "<this>");
        return size.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(Size size) {
        Intrinsics3.checkNotNullParameter(size, "<this>");
        return size.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(SizeF sizeF) {
        Intrinsics3.checkNotNullParameter(sizeF, "<this>");
        return sizeF.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(SizeF sizeF) {
        Intrinsics3.checkNotNullParameter(sizeF, "<this>");
        return sizeF.getHeight();
    }
}
