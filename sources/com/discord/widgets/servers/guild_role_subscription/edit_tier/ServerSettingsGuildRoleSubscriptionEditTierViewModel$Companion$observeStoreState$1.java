package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;
import com.discord.stores.StoreGuilds;
import d0.z.d.o;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion$observeStoreState$1 extends o implements Function0<Pair<? extends ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $guildRoleSubscriptionTierListingId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
    public final /* synthetic */ StoreGuilds $storeGuilds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion$observeStoreState$1(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, StoreChannels storeChannels, StoreGuilds storeGuilds, long j2) {
        super(0);
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.$guildId = j;
        this.$storeChannels = storeChannels;
        this.$storeGuilds = storeGuilds;
        this.$guildRoleSubscriptionTierListingId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Pair<? extends ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<? extends ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>> invoke2() {
        StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState guildRoleSubscriptionState = this.$storeGuildRoleSubscriptions.getGuildRoleSubscriptionState(this.$guildId);
        return new Pair<>(new ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData(guildRoleSubscriptionState, this.$storeGuilds.getRoles().get(Long.valueOf(this.$guildId)), this.$storeGuildRoleSubscriptions.getGuildRoleSubscriptionFreeTrialForListing(this.$guildId, this.$guildRoleSubscriptionTierListingId)), this.$storeChannels.getChannelsForGuild(this.$guildId));
    }
}
