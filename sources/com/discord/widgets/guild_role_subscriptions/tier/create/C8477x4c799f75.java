package com.discord.widgets.guild_role_subscriptions.tier.create;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtilsKt;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.CreateGuildRoleSubscriptionTierViewModel$Companion$observeStoreState$1 */
/* JADX INFO: compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8477x4c799f75 extends AbstractC12240o implements Function0<CreateGuildRoleSubscriptionTierViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
    public final /* synthetic */ StoreGuilds $storeGuilds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8477x4c799f75(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, StoreGuilds storeGuilds) {
        super(0);
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.$guildId = j;
        this.$storeGuilds = storeGuilds;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CreateGuildRoleSubscriptionTierViewModel.StoreState invoke() {
        StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionState = this.$storeGuildRoleSubscriptions.getGuildRoleSubscriptionState(this.$guildId);
        if (!(guildRoleSubscriptionState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded)) {
            guildRoleSubscriptionState = null;
        }
        StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded loaded = (StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded) guildRoleSubscriptionState;
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = loaded != null ? loaded.getGuildRoleSubscriptionGroupListing() : null;
        return new CreateGuildRoleSubscriptionTierViewModel.StoreState(guildRoleSubscriptionGroupListing, guildRoleSubscriptionGroupListing != null ? GuildRoleSubscriptionUtilsKt.getFullServerGatingOverwrite(guildRoleSubscriptionGroupListing, this.$storeGuilds.getRoles().get(Long.valueOf(this.$guildId))) : null);
    }
}
