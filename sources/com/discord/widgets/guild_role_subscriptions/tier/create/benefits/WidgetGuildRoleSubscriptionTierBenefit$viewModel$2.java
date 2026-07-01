package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit$viewModel$2 extends o implements Function0<GuildRoleSubscriptionTierBenefitViewModel> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefit$viewModel$2(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildRoleSubscriptionTierBenefitViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionTierBenefitViewModel invoke() {
        return new GuildRoleSubscriptionTierBenefitViewModel(WidgetGuildRoleSubscriptionTierBenefit.access$getBenefitType$p(this.this$0), WidgetGuildRoleSubscriptionTierBenefit.access$getTierName$p(this.this$0), WidgetGuildRoleSubscriptionTierBenefit.access$getExistingBenefit$p(this.this$0));
    }
}
