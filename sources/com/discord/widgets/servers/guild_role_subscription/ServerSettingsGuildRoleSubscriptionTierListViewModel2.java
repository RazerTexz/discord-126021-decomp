package com.discord.widgets.servers.guild_role_subscription;

import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierListViewModel;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierListViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierListViewModel2 extends Lambda implements Function0<ServerSettingsGuildRoleSubscriptionTierListViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionTierListViewModel2(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j) {
        super(0);
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.$guildId = j;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsGuildRoleSubscriptionTierListViewModel.StoreState invoke() {
        return new ServerSettingsGuildRoleSubscriptionTierListViewModel.StoreState(this.$storeGuildRoleSubscriptions.getGuildRoleSubscriptionState(this.$guildId));
    }
}
