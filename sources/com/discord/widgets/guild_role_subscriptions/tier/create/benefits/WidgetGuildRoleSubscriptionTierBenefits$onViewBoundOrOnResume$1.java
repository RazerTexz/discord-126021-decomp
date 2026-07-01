package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel$ViewState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$onViewBoundOrOnResume$1 extends o implements Function1<GuildRoleSubscriptionTierViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefits$onViewBoundOrOnResume$1(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState) {
        invoke2(guildRoleSubscriptionTierViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState) {
        m.checkNotNullParameter(guildRoleSubscriptionTierViewModel$ViewState, "it");
        WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitsViewModel$p(this.this$0).updateBenefits(guildRoleSubscriptionTierViewModel$ViewState.getGuildRoleSubscriptionTier(), guildRoleSubscriptionTierViewModel$ViewState.isFullServerGating());
    }
}
