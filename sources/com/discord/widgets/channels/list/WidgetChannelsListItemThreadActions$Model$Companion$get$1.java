package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions$Model$Companion$get$1<T, R> implements b<Channel, Observable<? extends WidgetChannelsListItemThreadActions$Model>> {
    public static final WidgetChannelsListItemThreadActions$Model$Companion$get$1 INSTANCE = new WidgetChannelsListItemThreadActions$Model$Companion$get$1();

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelsListItemThreadActions$Model> call2(Channel channel) {
        if (channel == null) {
            return new k(null);
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.e(StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getChannels().observeChannel(channel.getParentId()), storeStream$Companion.getGuilds().observeGuild(channel.getGuildId()), storeStream$Companion.getPermissions().observePermissionsForChannel(channel.getParentId()), storeStream$Companion.getUserGuildSettings().observeGuildSettings(), storeStream$Companion.getThreadsJoined().observeJoinedThread(channel.getId()), storeStream$Companion.getThreadsActive().observeActiveThreadsForGuild(channel.getGuildId()).G(new WidgetChannelsListItemThreadActions$Model$Companion$get$1$1(channel)).r(), new WidgetChannelsListItemThreadActions$Model$Companion$get$1$2(channel));
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelsListItemThreadActions$Model> call(Channel channel) {
        return call2(channel);
    }
}
