package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit$viewModel$2 extends AbstractC12240o implements Function0<GuildRoleSubscriptionTierBenefitViewModel> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefit$viewModel$2(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionTierBenefitViewModel invoke() {
        return new GuildRoleSubscriptionTierBenefitViewModel(this.this$0.getBenefitType(), this.this$0.getTierName(), this.this$0.getExistingBenefit());
    }
}
