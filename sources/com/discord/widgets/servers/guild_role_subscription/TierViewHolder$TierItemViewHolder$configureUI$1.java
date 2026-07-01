package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TierViewHolder$TierItemViewHolder$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener $itemClickListener;
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier $tierAdapterItem;

    public TierViewHolder$TierItemViewHolder$configureUI$1(ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener serverSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener, ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier) {
        this.$itemClickListener = serverSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener;
        this.$tierAdapterItem = serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$itemClickListener.onTierItemClick(this.$tierAdapterItem.getTierListingId());
    }
}
