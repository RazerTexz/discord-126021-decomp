package androidx.core.graphics;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.graphics.PaintKt, reason: use source file name */
/* JADX INFO: compiled from: Paint.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Paint {
    public static final boolean setBlendMode(android.graphics.Paint paint, BlendModeCompat blendModeCompat) {
        Intrinsics3.checkNotNullParameter(paint, "<this>");
        return PaintCompat.setBlendMode(paint, blendModeCompat);
    }
}
