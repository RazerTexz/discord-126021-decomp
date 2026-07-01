package com.discord.widgets.servers.community;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import j0.k.b;
import j0.l.e.k;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunityViewModel$Companion$observeStoreState$1<T, R> implements b<Guild, Observable<? extends WidgetServerSettingsEnableCommunityViewModel$StoreState>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUser $storeUsers;

    public WidgetServerSettingsEnableCommunityViewModel$Companion$observeStoreState$1(StoreUser storeUser, StorePermissions storePermissions, long j, StoreChannels storeChannels) {
        this.$storeUsers = storeUser;
        this.$storePermissions = storePermissions;
        this.$guildId = j;
        this.$storeChannels = storeChannels;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsEnableCommunityViewModel$StoreState> call(Guild guild) {
        return call2(guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsEnableCommunityViewModel$StoreState> call2(Guild guild) {
        if (guild == null) {
            return new k(WidgetServerSettingsEnableCommunityViewModel$StoreState$Invalid.INSTANCE);
        }
        Observable observableObserveMe$default = StoreUser.observeMe$default(this.$storeUsers, false, 1, null);
        Observable<Long> observableObservePermissionsForGuild = this.$storePermissions.observePermissionsForGuild(this.$guildId);
        Observable<Map<Long, GuildRole>> observableObserveRoles = StoreStream.Companion.getGuilds().observeRoles(this.$guildId);
        StoreChannels storeChannels = this.$storeChannels;
        Long rulesChannelId = guild.getRulesChannelId();
        Observable<Channel> observableObserveChannel = storeChannels.observeChannel(rulesChannelId != null ? rulesChannelId.longValue() : 0L);
        StoreChannels storeChannels2 = this.$storeChannels;
        Long publicUpdatesChannelId = guild.getPublicUpdatesChannelId();
        return Observable.g(observableObserveMe$default, observableObservePermissionsForGuild, observableObserveRoles, observableObserveChannel, storeChannels2.observeChannel(publicUpdatesChannelId != null ? publicUpdatesChannelId.longValue() : 0L), new WidgetServerSettingsEnableCommunityViewModel$Companion$observeStoreState$1$1(guild));
    }
}
