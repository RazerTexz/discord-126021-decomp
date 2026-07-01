package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;


/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface GuildRoleSubscriptionBenefitAdapter$Listener {
    void onActiveTrialUserLimitClick();

    void onAddBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem benefitAdapterItem);

    void onBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem);

    void onFreeTrialToggle(boolean isEnabled);

    void onTrialIntervalClick();
}
