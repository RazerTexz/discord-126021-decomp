package com.discord.widgets.channels.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$Model$Companion$get$1<T, R> implements b<Channel, Observable<? extends WidgetTextChannelSettings$Model>> {
    public final /* synthetic */ long $channelId;

    public WidgetTextChannelSettings$Model$Companion$get$1(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetTextChannelSettings$Model> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetTextChannelSettings$Model> call2(Channel channel) {
        if (channel == null || ChannelUtils.H(channel)) {
            return new k(null);
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.i(storeStream$Companion.getGuilds().observeGuild(channel.getGuildId()), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getPermissions().observePermissionsForChannel(this.$channelId), new WidgetTextChannelSettings$Model$Companion$get$1$1(this, channel));
    }
}
