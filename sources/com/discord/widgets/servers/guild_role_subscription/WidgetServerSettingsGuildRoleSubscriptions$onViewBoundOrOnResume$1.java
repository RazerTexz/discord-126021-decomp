package com.discord.widgets.servers.guild_role_subscription;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$1 extends o implements Function1<ServerSettingsGuildRoleSubscriptionViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$1(WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions) {
        super(1);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionViewModel$ViewState serverSettingsGuildRoleSubscriptionViewModel$ViewState) {
        invoke2(serverSettingsGuildRoleSubscriptionViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ServerSettingsGuildRoleSubscriptionViewModel$ViewState serverSettingsGuildRoleSubscriptionViewModel$ViewState) {
        WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions = this.this$0;
        m.checkNotNullExpressionValue(serverSettingsGuildRoleSubscriptionViewModel$ViewState, "it");
        WidgetServerSettingsGuildRoleSubscriptions.access$configureUI(widgetServerSettingsGuildRoleSubscriptions, serverSettingsGuildRoleSubscriptionViewModel$ViewState);
    }
}
