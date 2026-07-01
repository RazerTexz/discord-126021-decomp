package com.discord.widgets.channels.permissions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview$Model$Companion$get$1<T, R> implements b<Channel, Observable<? extends WidgetChannelSettingsPermissionsOverview$Model>> {
    public final /* synthetic */ long $channelId;

    public WidgetChannelSettingsPermissionsOverview$Model$Companion$get$1(long j) {
        this.$channelId = j;
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelSettingsPermissionsOverview$Model> call2(Channel channel) {
        if (channel == null) {
            return new k(null);
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.h(storeStream$Companion.getGuilds().observeGuild(channel.getGuildId()), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getPermissions().observePermissionsForChannel(this.$channelId), storeStream$Companion.getGuilds().observeRoles(channel.getGuildId()), new WidgetChannelSettingsPermissionsOverview$Model$Companion$get$1$1(channel));
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelSettingsPermissionsOverview$Model> call(Channel channel) {
        return call2(channel);
    }
}
