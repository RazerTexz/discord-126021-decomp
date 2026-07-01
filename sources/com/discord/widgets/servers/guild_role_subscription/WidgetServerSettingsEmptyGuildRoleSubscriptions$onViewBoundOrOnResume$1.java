package com.discord.widgets.servers.guild_role_subscription;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmptyGuildRoleSubscriptions$onViewBoundOrOnResume$1 extends o implements Function1<ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetServerSettingsEmptyGuildRoleSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEmptyGuildRoleSubscriptions$onViewBoundOrOnResume$1(WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions) {
        super(1);
        this.this$0 = widgetServerSettingsEmptyGuildRoleSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState) {
        invoke2(serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState) {
        WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions = this.this$0;
        m.checkNotNullExpressionValue(serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState, "it");
        WidgetServerSettingsEmptyGuildRoleSubscriptions.access$configureUI(widgetServerSettingsEmptyGuildRoleSubscriptions, serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState);
    }
}
