package com.discord.widgets.channels.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.widgets.forums.ForumUtils;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings$Model$Companion$get$1<T, R> implements b<Channel, Observable<? extends WidgetChannelNotificationSettings$Model>> {
    public static final WidgetChannelNotificationSettings$Model$Companion$get$1 INSTANCE = new WidgetChannelNotificationSettings$Model$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelNotificationSettings$Model> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelNotificationSettings$Model> call2(Channel channel) {
        if (channel == null) {
            return new k(null);
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.f(storeStream$Companion.getThreadsJoined().observeJoinedThread(channel.getId()), storeStream$Companion.getChannels().observeChannel(channel.getParentId()), storeStream$Companion.getGuilds().observeGuild(channel.getGuildId()), storeStream$Companion.getUserGuildSettings().observeGuildSettings(channel.getGuildId()), storeStream$Companion.getGuildProfiles().observeGuildProfile(channel.getGuildId()), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, null, 6, null), new WidgetChannelNotificationSettings$Model$Companion$get$1$$special$$inlined$let$lambda$1(channel));
    }
}
