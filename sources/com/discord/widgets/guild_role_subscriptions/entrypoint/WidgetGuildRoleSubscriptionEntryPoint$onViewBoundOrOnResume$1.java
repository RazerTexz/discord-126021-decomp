package com.discord.widgets.guild_role_subscriptions.entrypoint;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionEntryPoint$onViewBoundOrOnResume$1 extends k implements Function1<WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState, Unit> {
    public WidgetGuildRoleSubscriptionEntryPoint$onViewBoundOrOnResume$1(WidgetGuildRoleSubscriptionEntryPoint widgetGuildRoleSubscriptionEntryPoint) {
        super(1, widgetGuildRoleSubscriptionEntryPoint, WidgetGuildRoleSubscriptionEntryPoint.class, "configureUI", "configureUI(Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState widgetGuildRoleSubscriptionEntryPointViewModel$ViewState) {
        invoke2(widgetGuildRoleSubscriptionEntryPointViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState widgetGuildRoleSubscriptionEntryPointViewModel$ViewState) {
        m.checkNotNullParameter(widgetGuildRoleSubscriptionEntryPointViewModel$ViewState, "p1");
        WidgetGuildRoleSubscriptionEntryPoint.access$configureUI((WidgetGuildRoleSubscriptionEntryPoint) this.receiver, widgetGuildRoleSubscriptionEntryPointViewModel$ViewState);
    }
}
