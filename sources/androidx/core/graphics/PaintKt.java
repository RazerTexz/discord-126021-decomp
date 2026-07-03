package androidx.core.graphics;

import android.graphics.Paint;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Paint.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PaintKt {
    public static final boolean setBlendMode(Paint paint, BlendModeCompat blendModeCompat) {
        C12238m.checkNotNullParameter(paint, "<this>");
        return PaintCompat.setBlendMode(paint, blendModeCompat);
    }
}
