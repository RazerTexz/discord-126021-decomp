package com.discord.widgets.servers.guild_role_subscription;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded;
import com.discord.stores.StoreGuilds;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtilsKt;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionViewModel$Companion$observeStoreState$1 extends o implements Function0<ServerSettingsGuildRoleSubscriptionViewModel$StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
    public final /* synthetic */ StoreGuilds $storeGuilds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionViewModel$Companion$observeStoreState$1(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, StoreGuilds storeGuilds) {
        super(0);
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.$guildId = j;
        this.$storeGuilds = storeGuilds;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel$StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsGuildRoleSubscriptionViewModel$StoreState invoke() {
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;
        StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState guildRoleSubscriptionState = this.$storeGuildRoleSubscriptions.getGuildRoleSubscriptionState(this.$guildId);
        Boolean fullServerGatingOverwrite = null;
        StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded = (StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded) (!(guildRoleSubscriptionState instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded) ? null : guildRoleSubscriptionState);
        if (storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded != null && (guildRoleSubscriptionGroupListing = storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded.getGuildRoleSubscriptionGroupListing()) != null) {
            fullServerGatingOverwrite = GuildRoleSubscriptionUtilsKt.getFullServerGatingOverwrite(guildRoleSubscriptionGroupListing, this.$storeGuilds.getRoles().get(Long.valueOf(this.$guildId)));
        }
        return new ServerSettingsGuildRoleSubscriptionViewModel$StoreState(guildRoleSubscriptionState, fullServerGatingOverwrite);
    }
}
