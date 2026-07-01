package com.discord.widgets.guild_role_subscriptions.tier.create;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded;
import com.discord.stores.StoreGuilds;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtilsKt;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CreateGuildRoleSubscriptionTierViewModel$Companion$observeStoreState$1 extends o implements Function0<CreateGuildRoleSubscriptionTierViewModel$StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
    public final /* synthetic */ StoreGuilds $storeGuilds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateGuildRoleSubscriptionTierViewModel$Companion$observeStoreState$1(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, StoreGuilds storeGuilds) {
        super(0);
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.$guildId = j;
        this.$storeGuilds = storeGuilds;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CreateGuildRoleSubscriptionTierViewModel$StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CreateGuildRoleSubscriptionTierViewModel$StoreState invoke() {
        StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState guildRoleSubscriptionState = this.$storeGuildRoleSubscriptions.getGuildRoleSubscriptionState(this.$guildId);
        if (!(guildRoleSubscriptionState instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded)) {
            guildRoleSubscriptionState = null;
        }
        StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded = (StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded) guildRoleSubscriptionState;
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded != null ? storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded.getGuildRoleSubscriptionGroupListing() : null;
        return new CreateGuildRoleSubscriptionTierViewModel$StoreState(guildRoleSubscriptionGroupListing, guildRoleSubscriptionGroupListing != null ? GuildRoleSubscriptionUtilsKt.getFullServerGatingOverwrite(guildRoleSubscriptionGroupListing, this.$storeGuilds.getRoles().get(Long.valueOf(this.$guildId))) : null);
    }
}
