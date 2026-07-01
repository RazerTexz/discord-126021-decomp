package com.discord.widgets.servers.guild_role_subscription;

import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier;
import com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionTierList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionTierList$configureUI$1 implements ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener {
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded $loadedViewState;
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionTierList this$0;

    public WidgetServerSettingsGuildRoleSubscriptionTierList$configureUI$1(WidgetServerSettingsGuildRoleSubscriptionTierList widgetServerSettingsGuildRoleSubscriptionTierList, ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded) {
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionTierList;
        this.$loadedViewState = serverSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded;
    }

    @Override // com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener
    public void onAddTierItemClick() {
        WidgetCreateGuildRoleSubscriptionTier.Companion.launch(this.this$0.requireContext(), WidgetServerSettingsGuildRoleSubscriptionTierList.access$getGuildId$p(this.this$0), this.$loadedViewState.getGroupListingId());
    }

    @Override // com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener
    public void onTierItemClick(long tierListingId) {
        WidgetServerSettingsGuildRoleSubscriptionEditTier.Companion.launch(this.this$0.requireContext(), WidgetServerSettingsGuildRoleSubscriptionTierList.access$getGuildId$p(this.this$0), this.$loadedViewState.getGroupListingId(), tierListingId);
    }
}
