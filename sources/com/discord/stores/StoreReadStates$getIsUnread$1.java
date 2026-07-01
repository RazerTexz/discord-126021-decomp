package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.Set;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates$getIsUnread$1<T, R> implements b<Set<? extends Long>, Boolean> {
    public final /* synthetic */ long $guildId;

    public StoreReadStates$getIsUnread$1(long j) {
        this.$guildId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
        return call2((Set<Long>) set);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Set<Long> set) {
        return Boolean.valueOf(set.contains(Long.valueOf(this.$guildId)));
    }
}
