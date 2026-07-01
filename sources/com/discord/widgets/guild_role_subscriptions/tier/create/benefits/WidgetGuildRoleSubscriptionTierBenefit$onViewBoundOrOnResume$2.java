package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit$onViewBoundOrOnResume$2 extends o implements Function1<GuildRoleSubscriptionTierBenefitViewModel$Event, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefit$onViewBoundOrOnResume$2(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitViewModel$Event guildRoleSubscriptionTierBenefitViewModel$Event) {
        invoke2(guildRoleSubscriptionTierBenefitViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionTierBenefitViewModel$Event guildRoleSubscriptionTierBenefitViewModel$Event) {
        m.checkNotNullParameter(guildRoleSubscriptionTierBenefitViewModel$Event, "it");
        WidgetGuildRoleSubscriptionTierBenefit.access$handleEvent(this.this$0, guildRoleSubscriptionTierBenefitViewModel$Event);
    }
}
