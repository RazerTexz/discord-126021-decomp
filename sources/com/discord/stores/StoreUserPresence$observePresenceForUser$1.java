package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.presence.Presence;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreUserPresence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserPresence$observePresenceForUser$1<T, R> implements b<Map<Long, ? extends Presence>, Presence> {
    public final /* synthetic */ long $userId;

    public StoreUserPresence$observePresenceForUser$1(long j) {
        this.$userId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Presence call(Map<Long, ? extends Presence> map) {
        return call2((Map<Long, Presence>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Presence call2(Map<Long, Presence> map) {
        return map.get(Long.valueOf(this.$userId));
    }
}
