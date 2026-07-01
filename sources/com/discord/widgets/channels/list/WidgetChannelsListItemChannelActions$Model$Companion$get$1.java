package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions$Model$Companion$get$1<T, R> implements b<Channel, Observable<? extends WidgetChannelsListItemChannelActions$Model>> {
    public final /* synthetic */ long $channelId;

    public WidgetChannelsListItemChannelActions$Model$Companion$get$1(long j) {
        this.$channelId = j;
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelsListItemChannelActions$Model> call2(Channel channel) {
        if (channel == null) {
            return new k(null);
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.i(storeStream$Companion.getGuilds().observeFromChannelId(this.$channelId), storeStream$Companion.getPermissions().observePermissionsForChannel(this.$channelId), storeStream$Companion.getUserGuildSettings().observeGuildSettings(), new WidgetChannelsListItemChannelActions$Model$Companion$get$1$1(channel));
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelsListItemChannelActions$Model> call(Channel channel) {
        return call2(channel);
    }
}
