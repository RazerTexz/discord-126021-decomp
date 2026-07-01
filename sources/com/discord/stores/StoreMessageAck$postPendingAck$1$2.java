package com.discord.stores;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$postPendingAck$1$2<T> implements Action1<Void> {
    public final /* synthetic */ long $channelId;

    public StoreMessageAck$postPendingAck$1$2(long j) {
        this.$channelId = j;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Void r1) {
        call2(r1);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Void r3) {
        StoreStream.Companion.getAnalytics().ackMessage(this.$channelId);
    }
}
