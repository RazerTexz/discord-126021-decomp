package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(Size size) {
        C12238m.checkNotNullParameter(size, "<this>");
        return size.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(Size size) {
        C12238m.checkNotNullParameter(size, "<this>");
        return size.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(SizeF sizeF) {
        C12238m.checkNotNullParameter(sizeF, "<this>");
        return sizeF.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(SizeF sizeF) {
        C12238m.checkNotNullParameter(sizeF, "<this>");
        return sizeF.getHeight();
    }
}
