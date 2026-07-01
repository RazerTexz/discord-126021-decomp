package com.discord.widgets.servers.guild_role_subscription;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding;
import d0.z.d.m;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TierViewHolder$AddTierItemViewHolder extends TierViewHolder {
    /* JADX WARN: Illegal instructions before constructor call */
    public TierViewHolder$AddTierItemViewHolder(ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener serverSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener) {
        m.checkNotNullParameter(viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, "binding");
        m.checkNotNullParameter(serverSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener, "itemClickListener");
        ConstraintLayout constraintLayout = viewServerSettingsGuildRoleSubscriptionAddTierItemBinding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        super(constraintLayout, null);
        this.itemView.setOnClickListener(new TierViewHolder$AddTierItemViewHolder$1(serverSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener));
        viewServerSettingsGuildRoleSubscriptionAddTierItemBinding.f2209b.setText(2131891414);
    }
}
