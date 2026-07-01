package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$$inlined$apply$lambda$2 implements View$OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem $data$inlined;
    public final /* synthetic */ GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder this$0;

    public GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$$inlined$apply$lambda$2(GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder guildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder, GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem) {
        this.this$0 = guildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder;
        this.$data$inlined = guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder.access$getListener$p(this.this$0).onTrialIntervalClick();
    }
}
