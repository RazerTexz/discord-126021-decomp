package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$2$1 extends o implements Function1<GuildRoleSubscriptionTierBenefitsViewModel$ViewState, Unit> {
    public final /* synthetic */ int $index;
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$2$1(WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$2 widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$2, int i) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$2;
        this.$index = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitsViewModel$ViewState guildRoleSubscriptionTierBenefitsViewModel$ViewState) {
        invoke2(guildRoleSubscriptionTierBenefitsViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionTierBenefitsViewModel$ViewState guildRoleSubscriptionTierBenefitsViewModel$ViewState) {
        m.checkNotNullParameter(guildRoleSubscriptionTierBenefitsViewModel$ViewState, "it");
        WidgetGuildRoleSubscriptionTierBenefits.access$getViewModel$p(this.this$0.this$0.this$0).updateFreeTrialLimit(guildRoleSubscriptionTierBenefitsViewModel$ViewState.getActiveTrialUserLimitOptions().get(this.$index));
    }
}
