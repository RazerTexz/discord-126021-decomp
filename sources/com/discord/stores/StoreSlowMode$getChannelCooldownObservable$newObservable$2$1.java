package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.HashMap;

/* JADX INFO: compiled from: StoreSlowMode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSlowMode$getChannelCooldownObservable$newObservable$2$1<T, R> implements b<HashMap<Long, Long>, Long> {
    public final /* synthetic */ StoreSlowMode$getChannelCooldownObservable$newObservable$2 this$0;

    public StoreSlowMode$getChannelCooldownObservable$newObservable$2$1(StoreSlowMode$getChannelCooldownObservable$newObservable$2 storeSlowMode$getChannelCooldownObservable$newObservable$2) {
        this.this$0 = storeSlowMode$getChannelCooldownObservable$newObservable$2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Long call(HashMap<Long, Long> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(HashMap<Long, Long> map) {
        return map.get(Long.valueOf(this.this$0.$channelId));
    }
}
