package com.discord.widgets.voice.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: CallModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallModel$Companion$get$1<T, R> implements b<Channel, Observable<? extends CallModel>> {
    public final /* synthetic */ long $channelId;

    public CallModel$Companion$get$1(long j) {
        this.$channelId = j;
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends CallModel> call2(Channel channel) {
        return channel == null ? new k(null) : StoreStream.Companion.getEmbeddedActivities().observeEmbeddedActivitiesForChannel(this.$channelId).Y(new CallModel$Companion$get$1$1(this, channel));
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends CallModel> call(Channel channel) {
        return call2(channel);
    }
}
