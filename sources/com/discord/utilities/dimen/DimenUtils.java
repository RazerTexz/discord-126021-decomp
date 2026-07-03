package com.discord.utilities.dimen;

import android.content.res.Resources;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: DimenUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DimenUtils {
    private static final float DENSITY;

    static {
        Resources system = Resources.getSystem();
        C12238m.checkNotNullExpressionValue(system, "Resources.getSystem()");
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
