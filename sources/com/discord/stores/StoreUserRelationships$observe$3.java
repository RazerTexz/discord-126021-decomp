package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreUserRelationships.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserRelationships$observe$3<T, R> implements b<Map<Long, ? extends Integer>, Integer> {
    public final /* synthetic */ long $userId;

    public StoreUserRelationships$observe$3(long j) {
        this.$userId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Integer call(Map<Long, ? extends Integer> map) {
        return call2((Map<Long, Integer>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(Map<Long, Integer> map) {
        return map.get(Long.valueOf(this.$userId));
    }
}
