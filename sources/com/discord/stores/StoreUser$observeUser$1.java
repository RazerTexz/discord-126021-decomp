package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUser$observeUser$1<T, R> implements b<Map<Long, ? extends User>, User> {
    public final /* synthetic */ long $userId;

    public StoreUser$observeUser$1(long j) {
        this.$userId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ User call(Map<Long, ? extends User> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final User call2(Map<Long, ? extends User> map) {
        m.checkNotNullParameter(map, "user");
        return map.get(Long.valueOf(this.$userId));
    }
}
