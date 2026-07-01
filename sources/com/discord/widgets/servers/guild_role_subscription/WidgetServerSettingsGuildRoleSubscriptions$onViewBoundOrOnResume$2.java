package com.discord.widgets.servers.guild_role_subscription;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$2 extends o implements Function1<ServerSettingsGuildRoleSubscriptionViewModel$Event, Unit> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$2(WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions) {
        super(1);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionViewModel$Event serverSettingsGuildRoleSubscriptionViewModel$Event) {
        invoke2(serverSettingsGuildRoleSubscriptionViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ServerSettingsGuildRoleSubscriptionViewModel$Event serverSettingsGuildRoleSubscriptionViewModel$Event) {
        WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions = this.this$0;
        m.checkNotNullExpressionValue(serverSettingsGuildRoleSubscriptionViewModel$Event, "it");
        WidgetServerSettingsGuildRoleSubscriptions.access$handleEvents(widgetServerSettingsGuildRoleSubscriptions, serverSettingsGuildRoleSubscriptionViewModel$Event);
    }
}
