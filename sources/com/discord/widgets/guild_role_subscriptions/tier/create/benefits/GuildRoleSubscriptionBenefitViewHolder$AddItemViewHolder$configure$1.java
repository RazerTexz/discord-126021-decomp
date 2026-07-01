package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder$AddItemViewHolder$configure$1 implements View$OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem $data;
    public final /* synthetic */ GuildRoleSubscriptionBenefitViewHolder$AddItemViewHolder this$0;

    public GuildRoleSubscriptionBenefitViewHolder$AddItemViewHolder$configure$1(GuildRoleSubscriptionBenefitViewHolder$AddItemViewHolder guildRoleSubscriptionBenefitViewHolder$AddItemViewHolder, GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem guildRoleSubscriptionBenefitAdapterItem$AddBenefitItem) {
        this.this$0 = guildRoleSubscriptionBenefitViewHolder$AddItemViewHolder;
        this.$data = guildRoleSubscriptionBenefitAdapterItem$AddBenefitItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildRoleSubscriptionBenefitViewHolder$AddItemViewHolder.access$getListener$p(this.this$0).onAddBenefitItemClick(this.$data);
    }
}
