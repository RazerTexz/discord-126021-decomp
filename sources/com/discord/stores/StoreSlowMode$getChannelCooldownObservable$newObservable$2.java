package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: StoreSlowMode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSlowMode$getChannelCooldownObservable$newObservable$2<T, R> implements b<Boolean, Observable<? extends Long>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreSlowMode$Type $type;
    public final /* synthetic */ StoreSlowMode this$0;

    public StoreSlowMode$getChannelCooldownObservable$newObservable$2(StoreSlowMode storeSlowMode, StoreSlowMode$Type storeSlowMode$Type, long j) {
        this.this$0 = storeSlowMode;
        this.$type = storeSlowMode$Type;
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Long> call(Boolean bool) {
        return call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Long> call2(Boolean bool) {
        m.checkNotNullExpressionValue(bool, "shouldOverrideCooldown");
        if (bool.booleanValue()) {
            return new k(0L);
        }
        return (m.areEqual(this.$type, StoreSlowMode$Type$MessageSend.INSTANCE) ? StoreSlowMode.access$getMessageSendNextSendTimesSubject$p(this.this$0) : StoreSlowMode.access$getThreadCreateNextSendTimesSubject$p(this.this$0)).G(new StoreSlowMode$getChannelCooldownObservable$newObservable$2$1(this)).Y(new StoreSlowMode$getChannelCooldownObservable$newObservable$2$2(this));
    }
}
