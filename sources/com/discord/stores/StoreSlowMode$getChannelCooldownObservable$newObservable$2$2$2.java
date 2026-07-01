package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: StoreSlowMode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSlowMode$getChannelCooldownObservable$newObservable$2$2$2<T, R> implements b<Long, Boolean> {
    public static final StoreSlowMode$getChannelCooldownObservable$newObservable$2$2$2 INSTANCE = new StoreSlowMode$getChannelCooldownObservable$newObservable$2$2$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Long l) {
        return Boolean.valueOf(l.longValue() >= 0);
    }
}
