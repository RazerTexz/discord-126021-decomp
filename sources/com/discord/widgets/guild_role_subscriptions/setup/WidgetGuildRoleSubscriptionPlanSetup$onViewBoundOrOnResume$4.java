package com.discord.widgets.guild_role_subscriptions.setup;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$4 extends o implements Function1<GuildRoleSubscriptionPlanDetailsViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionPlanSetup this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$4(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionPlanSetup;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanDetailsViewModel$ViewState guildRoleSubscriptionPlanDetailsViewModel$ViewState) {
        invoke2(guildRoleSubscriptionPlanDetailsViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionPlanDetailsViewModel$ViewState guildRoleSubscriptionPlanDetailsViewModel$ViewState) {
        WidgetGuildRoleSubscriptionPlanSetup.access$getSetupViewModel$p(this.this$0).onSubscriptionPlanUpdated(guildRoleSubscriptionPlanDetailsViewModel$ViewState.getCoverImage(), guildRoleSubscriptionPlanDetailsViewModel$ViewState.getDescription(), guildRoleSubscriptionPlanDetailsViewModel$ViewState.isFullServerGate());
        WidgetGuildRoleSubscriptionPlanSetup.access$getCreateTierViewModel$p(this.this$0).setFullServerGating(guildRoleSubscriptionPlanDetailsViewModel$ViewState.isFullServerGate());
    }
}
