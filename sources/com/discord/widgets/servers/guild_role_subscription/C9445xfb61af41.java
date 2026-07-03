package com.discord.widgets.servers.guild_role_subscription;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtilsKt;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionViewModel$Companion$observeStoreState$1 */
/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9445xfb61af41 extends AbstractC12240o implements Function0<ServerSettingsGuildRoleSubscriptionViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
    public final /* synthetic */ StoreGuilds $storeGuilds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9445xfb61af41(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, StoreGuilds storeGuilds) {
        super(0);
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.$guildId = j;
        this.$storeGuilds = storeGuilds;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsGuildRoleSubscriptionViewModel.StoreState invoke() {
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;
        StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionState = this.$storeGuildRoleSubscriptions.getGuildRoleSubscriptionState(this.$guildId);
        Boolean fullServerGatingOverwrite = null;
        StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded loaded = (StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded) (!(guildRoleSubscriptionState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded) ? null : guildRoleSubscriptionState);
        if (loaded != null && (guildRoleSubscriptionGroupListing = loaded.getGuildRoleSubscriptionGroupListing()) != null) {
            fullServerGatingOverwrite = GuildRoleSubscriptionUtilsKt.getFullServerGatingOverwrite(guildRoleSubscriptionGroupListing, this.$storeGuilds.getRoles().get(Long.valueOf(this.$guildId)));
        }
        return new ServerSettingsGuildRoleSubscriptionViewModel.StoreState(guildRoleSubscriptionState, fullServerGatingOverwrite);
    }
}
