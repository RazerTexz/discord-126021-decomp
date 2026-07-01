package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TierViewHolder$AddTierItemViewHolder$1 implements View$OnClickListener {
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener $itemClickListener;

    public TierViewHolder$AddTierItemViewHolder$1(ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener serverSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener) {
        this.$itemClickListener = serverSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$itemClickListener.onAddTierItemClick();
    }
}
