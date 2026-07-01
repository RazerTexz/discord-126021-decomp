package com.discord.rlottie;

import android.graphics.Bitmap;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RLottieDrawable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RLottieDrawable$Companion {
    public RLottieDrawable$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final native long create(String str, int i, int i2, int[] iArr, boolean z2, int[] iArr2, boolean z3);

    public final native void createCache(long j, int i, int i2);

    public final native long createWithJson(String str, String str2, int[] iArr, int[] iArr2);

    public final native int getFrame(long j, int i, Bitmap bitmap, int i2, int i3, int i4, boolean z2);

    public final native void replaceColors(long j, int[] iArr);

    public final native void setLayerColor(long j, String str, int i);
}
