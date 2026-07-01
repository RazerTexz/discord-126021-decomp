package com.discord.utilities.channel;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.b;

/* JADX INFO: compiled from: ChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSelector$findAndSet$2<T, R> implements b<Channel, Boolean> {
    public static final ChannelSelector$findAndSet$2 INSTANCE = new ChannelSelector$findAndSet$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Channel channel) {
        return Boolean.valueOf(channel != null);
    }
}
