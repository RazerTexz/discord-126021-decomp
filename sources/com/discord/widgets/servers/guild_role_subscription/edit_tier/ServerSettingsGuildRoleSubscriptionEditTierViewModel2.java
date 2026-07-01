package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionEditTierViewModel2 extends Lambda implements Function0<Tuples2<? extends ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $guildRoleSubscriptionTierListingId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
    public final /* synthetic */ StoreGuilds $storeGuilds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionEditTierViewModel2(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, StoreChannels storeChannels, StoreGuilds storeGuilds, long j2) {
        super(0);
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.$guildId = j;
        this.$storeChannels = storeChannels;
        this.$storeGuilds = storeGuilds;
        this.$guildRoleSubscriptionTierListingId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Tuples2<? extends ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>> invoke() {
        StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionState = this.$storeGuildRoleSubscriptions.getGuildRoleSubscriptionState(this.$guildId);
        return new Tuples2<>(new ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData(guildRoleSubscriptionState, this.$storeGuilds.getRoles().get(Long.valueOf(this.$guildId)), this.$storeGuildRoleSubscriptions.getGuildRoleSubscriptionFreeTrialForListing(this.$guildId, this.$guildRoleSubscriptionTierListingId)), this.$storeChannels.getChannelsForGuild(this.$guildId));
    }
}
