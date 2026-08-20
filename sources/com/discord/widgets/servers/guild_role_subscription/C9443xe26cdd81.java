package com.discord.widgets.servers.guild_role_subscription;

import com.discord.stores.StoreGuildRoleSubscriptions;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierListViewModel$Companion$observeStoreState$1 */
/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9443xe26cdd81 extends AbstractC12240o implements Function0<ServerSettingsGuildRoleSubscriptionTierListViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9443xe26cdd81(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j) {
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
