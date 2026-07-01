package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$Actions$requestMembers$1<T, R> implements b<String, String> {
    public final /* synthetic */ boolean $autocomplete;

    public StoreGuilds$Actions$requestMembers$1(boolean z2) {
        this.$autocomplete = z2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ String call(String str) {
        return call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(String str) {
        if (this.$autocomplete) {
            if (!(str == null || str.length() == 0) && str.charAt(0) == '@') {
                String strSubstring = str.substring(1);
                m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                return strSubstring;
            }
        }
        if (!this.$autocomplete) {
            if (!(str == null || str.length() == 0)) {
                return str;
            }
        }
        return null;
    }
}
