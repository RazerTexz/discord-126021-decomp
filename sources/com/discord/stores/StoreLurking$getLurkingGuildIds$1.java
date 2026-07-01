package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking$getLurkingGuildIds$1<T, R> implements b<Map<Long, StoreLurking$LurkContext>, Set<? extends Long>> {
    public static final StoreLurking$getLurkingGuildIds$1 INSTANCE = new StoreLurking$getLurkingGuildIds$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, StoreLurking$LurkContext> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Set<Long> call2(Map<Long, StoreLurking$LurkContext> map) {
        return map.keySet();
    }
}
