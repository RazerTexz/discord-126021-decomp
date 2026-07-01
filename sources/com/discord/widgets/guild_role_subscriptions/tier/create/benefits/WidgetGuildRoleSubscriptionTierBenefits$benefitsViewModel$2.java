package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2 extends o implements Function0<GuildRoleSubscriptionTierBenefitsViewModel> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildRoleSubscriptionTierBenefitsViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionTierBenefitsViewModel invoke() {
        return new GuildRoleSubscriptionTierBenefitsViewModel(WidgetGuildRoleSubscriptionTierBenefits.access$getGuildId$p(this.this$0), WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitListType$p(this.this$0), null, null, null, 28, null);
    }
}
