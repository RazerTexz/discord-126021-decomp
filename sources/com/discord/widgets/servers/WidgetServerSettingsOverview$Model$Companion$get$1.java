package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$Model$Companion$get$1<T, R> implements b<Guild, Observable<? extends WidgetServerSettingsOverview$Model>> {
    public final /* synthetic */ long $guildId;

    public WidgetServerSettingsOverview$Model$Companion$get$1(long j) {
        this.$guildId = j;
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsOverview$Model> call2(Guild guild) {
        if (guild == null) {
            return new k(null);
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableObserveMe$default = StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null);
        StoreChannels channels = storeStream$Companion.getChannels();
        Long afkChannelId = guild.getAfkChannelId();
        Observable<Channel> observableObserveChannel = channels.observeChannel(afkChannelId != null ? afkChannelId.longValue() : 0L);
        StoreChannels channels2 = storeStream$Companion.getChannels();
        Long systemChannelId = guild.getSystemChannelId();
        return Observable.g(observableObserveMe$default, observableObserveChannel, channels2.observeChannel(systemChannelId != null ? systemChannelId.longValue() : 0L), storeStream$Companion.getPermissions().observePermissionsForGuild(this.$guildId), storeStream$Companion.getGuildProfiles().observeGuildProfile(this.$guildId), new WidgetServerSettingsOverview$Model$Companion$get$1$1(guild));
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsOverview$Model> call(Guild guild) {
        return call2(guild);
    }
}
