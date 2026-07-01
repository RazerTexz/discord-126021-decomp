package com.discord.widgets.guild_role_subscriptions.setup;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$1 extends o implements Function1<GuildRoleSubscriptionPlanSetupViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionPlanSetup this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$1(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionPlanSetup;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanSetupViewModel$ViewState guildRoleSubscriptionPlanSetupViewModel$ViewState) {
        invoke2(guildRoleSubscriptionPlanSetupViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionPlanSetupViewModel$ViewState guildRoleSubscriptionPlanSetupViewModel$ViewState) {
        m.checkNotNullParameter(guildRoleSubscriptionPlanSetupViewModel$ViewState, "it");
        WidgetGuildRoleSubscriptionPlanSetup.access$configureUI(this.this$0, guildRoleSubscriptionPlanSetupViewModel$ViewState);
    }
}
