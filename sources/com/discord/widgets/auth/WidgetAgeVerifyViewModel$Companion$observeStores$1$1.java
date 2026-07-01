package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.b;

/* JADX INFO: compiled from: WidgetAgeVerifyViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerifyViewModel$Companion$observeStores$1$1<T, R> implements b<Channel, Channel> {
    public static final WidgetAgeVerifyViewModel$Companion$observeStores$1$1 INSTANCE = new WidgetAgeVerifyViewModel$Companion$observeStores$1$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Channel call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Channel call2(Channel channel) {
        if (channel == null || channel.getNsfw()) {
            return null;
        }
        return channel;
    }
}
