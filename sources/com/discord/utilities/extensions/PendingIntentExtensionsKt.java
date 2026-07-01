package com.discord.utilities.extensions;

import android.os.Build$VERSION;

/* JADX INFO: compiled from: PendingIntentExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PendingIntentExtensionsKt {
    public static final int immutablePendingIntentFlag(int i) {
        return Build$VERSION.SDK_INT >= 23 ? i | 67108864 : i;
    }

    public static /* synthetic */ int immutablePendingIntentFlag$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return immutablePendingIntentFlag(i);
    }

    public static final int mutablePendingIntentFlag(int i) {
        return i;
    }

    public static /* synthetic */ int mutablePendingIntentFlag$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return mutablePendingIntentFlag(i);
    }
}
