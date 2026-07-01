package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$Actions$requestMembers$2<T, R> implements b<String, Boolean> {
    public static final StoreGuilds$Actions$requestMembers$2 INSTANCE = new StoreGuilds$Actions$requestMembers$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(String str) {
        return call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(String str) {
        boolean z2 = false;
        if (str != null) {
            int length = str.length() - 1;
            int i = 0;
            boolean z3 = false;
            while (i <= length) {
                boolean z4 = m.compare(str.charAt(!z3 ? i : length), 32) <= 0;
                if (z3) {
                    if (!z4) {
                        break;
                    }
                    length--;
                } else if (z4) {
                    i++;
                } else {
                    z3 = true;
                }
            }
            if (str.subSequence(i, length + 1).toString().length() > 0) {
                z2 = true;
            }
        }
        return Boolean.valueOf(z2);
    }
}
