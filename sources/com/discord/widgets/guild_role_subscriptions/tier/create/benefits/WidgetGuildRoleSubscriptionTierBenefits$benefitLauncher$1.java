package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$benefitLauncher$1 extends AbstractC12240o implements Function2<Benefit, Benefit, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefits$benefitLauncher$1(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        super(2);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Benefit benefit, Benefit benefit2) {
        invoke2(benefit, benefit2);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Benefit benefit, Benefit benefit2) {
        this.this$0.getViewModel().updateBenefit(benefit, benefit2);
    }
}
