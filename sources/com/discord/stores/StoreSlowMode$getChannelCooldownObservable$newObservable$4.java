package com.discord.stores;

import androidx.core.app.NotificationCompat;
import rx.functions.Action0;

/* JADX INFO: compiled from: StoreSlowMode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSlowMode$getChannelCooldownObservable$newObservable$4 implements Action0 {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreSlowMode$Type $type;
    public final /* synthetic */ StoreSlowMode this$0;

    public StoreSlowMode$getChannelCooldownObservable$newObservable$4(StoreSlowMode storeSlowMode, long j, StoreSlowMode$Type storeSlowMode$Type) {
        this.this$0 = storeSlowMode;
        this.$channelId = j;
        this.$type = storeSlowMode$Type;
    }

    @Override // rx.functions.Action0
    public final void call() {
        StoreSlowMode.access$removeChannelCooldownObservable(this.this$0, this.$channelId, this.$type);
    }
}
