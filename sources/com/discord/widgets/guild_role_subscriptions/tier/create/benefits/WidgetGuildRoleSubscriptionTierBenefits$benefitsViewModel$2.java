package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2 extends Lambda implements Function0<GuildRoleSubscriptionTierBenefitsViewModel> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionTierBenefitsViewModel invoke() {
        return new GuildRoleSubscriptionTierBenefitsViewModel(this.this$0.getGuildId(), this.this$0.getBenefitListType(), null, null, null, 28, null);
    }
}
