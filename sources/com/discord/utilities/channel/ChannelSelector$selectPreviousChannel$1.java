package com.discord.utilities.channel;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: ChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSelector$selectPreviousChannel$1<T, R> implements b<Long, Observable<? extends Channel>> {
    public final /* synthetic */ ChannelSelector this$0;

    public ChannelSelector$selectPreviousChannel$1(ChannelSelector channelSelector) {
        this.this$0 = channelSelector;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Channel> call2(Long l) {
        StoreChannels channels = this.this$0.getStream().getChannels();
        m.checkNotNullExpressionValue(l, "previousChannelId");
        return channels.observeChannel(l.longValue());
    }
}
