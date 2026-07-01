package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: StoreSlowMode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSlowMode$getChannelCooldownObservable$newObservable$2$2$1<T, R> implements b<Long, Long> {
    public final /* synthetic */ Long $nextSendTimeForChannel;
    public final /* synthetic */ long $now;

    public StoreSlowMode$getChannelCooldownObservable$newObservable$2$2$1(Long l, long j) {
        this.$nextSendTimeForChannel = l;
        this.$now = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Long call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(Long l) {
        return Long.valueOf(this.$nextSendTimeForChannel.longValue() - (this.$now + (l.longValue() * 1000)));
    }
}
