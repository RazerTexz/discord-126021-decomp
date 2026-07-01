package com.discord.utilities.dimen;

import android.content.res.Resources;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: DimenUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DimenUtils {
    private static final float DENSITY;

    static {
        Resources system = Resources.getSystem();
        Intrinsics3.checkNotNullExpressionValue(system, "Resources.getSystem()");
        DENSITY = system.getDisplayMetrics().density;
    }

    public static final int dpToPixels(int i) {
        return (int) (i * DENSITY);
    }

    public static final int pixelsToDp(int i) {
        return (int) (i / DENSITY);
    }

    public static final int dpToPixels(float f) {
        return (int) (f * DENSITY);
    }
}
