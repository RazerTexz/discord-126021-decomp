package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$getPendingAck$2<T, R> implements b<Long, Observable<? extends StoreMessageAck$PendingAck>> {
    public final /* synthetic */ boolean $isLockedAck;
    public final /* synthetic */ StoreMessageAck$getPendingAck$1 $isUpdateRequired$1;
    public final /* synthetic */ StoreMessageAck this$0;

    public StoreMessageAck$getPendingAck$2(StoreMessageAck storeMessageAck, boolean z2, StoreMessageAck$getPendingAck$1 storeMessageAck$getPendingAck$1) {
        this.this$0 = storeMessageAck;
        this.$isLockedAck = z2;
        this.$isUpdateRequired$1 = storeMessageAck$getPendingAck$1;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends StoreMessageAck$PendingAck> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends StoreMessageAck$PendingAck> call2(Long l) {
        if (l.longValue() <= 0) {
            return new k(StoreMessageAck$PendingAck.Companion.getEMPTY());
        }
        StoreMessageAck messageAck = StoreMessageAck.access$getStream$p(this.this$0).getMessageAck();
        m.checkNotNullExpressionValue(l, "channelId");
        return Observable.i(messageAck.observeForChannel(l.longValue()), StoreMessageAck.access$getStream$p(this.this$0).getMessagesMostRecent().observeRecentMessageIds(l.longValue()), StoreMessageAck.access$observeThreadAckState(this.this$0, l.longValue()), new StoreMessageAck$getPendingAck$2$1(this, l));
    }
}
