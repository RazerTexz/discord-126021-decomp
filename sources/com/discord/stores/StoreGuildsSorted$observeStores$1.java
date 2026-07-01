package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: StoreGuildsSorted.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildsSorted$observeStores$1<T, R> implements b<List<? extends Long>, Set<? extends Long>> {
    public static final StoreGuildsSorted$observeStores$1 INSTANCE = new StoreGuildsSorted$observeStores$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Set<? extends Long> call(List<? extends Long> list) {
        return call2((List<Long>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Set<Long> call2(List<Long> list) {
        m.checkNotNullExpressionValue(list, "it");
        return u.toSet(list);
    }
}
