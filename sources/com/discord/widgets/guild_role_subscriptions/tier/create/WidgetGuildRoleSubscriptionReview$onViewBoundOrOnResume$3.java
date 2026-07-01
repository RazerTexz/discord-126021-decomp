package com.discord.widgets.guild_role_subscriptions.tier.create;

import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanSetupViewModel$ViewState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionReview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$3 extends o implements Function1<GuildRoleSubscriptionPlanSetupViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionReview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$3(WidgetGuildRoleSubscriptionReview widgetGuildRoleSubscriptionReview) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionReview;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanSetupViewModel$ViewState guildRoleSubscriptionPlanSetupViewModel$ViewState) {
        invoke2(guildRoleSubscriptionPlanSetupViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionPlanSetupViewModel$ViewState guildRoleSubscriptionPlanSetupViewModel$ViewState) {
        m.checkNotNullParameter(guildRoleSubscriptionPlanSetupViewModel$ViewState, "it");
        WidgetGuildRoleSubscriptionReview.access$updatePlanDetails(this.this$0, guildRoleSubscriptionPlanSetupViewModel$ViewState);
    }
}
