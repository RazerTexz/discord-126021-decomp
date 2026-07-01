package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$1 implements View$OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder this$0;

    public GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$1(GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder guildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder) {
        this.this$0 = guildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildRoleSubscriptionBenefitAdapter$Listener guildRoleSubscriptionBenefitAdapter$ListenerAccess$getListener$p = GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder.access$getListener$p(this.this$0);
        CheckedSetting checkedSetting = GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder.access$getBinding$p(this.this$0).e;
        m.checkNotNullExpressionValue(checkedSetting, "binding.guildRoleSubscriptionFreeTrialEnableToggle");
        guildRoleSubscriptionBenefitAdapter$ListenerAccess$getListener$p.onFreeTrialToggle(!checkedSetting.isChecked());
    }
}
