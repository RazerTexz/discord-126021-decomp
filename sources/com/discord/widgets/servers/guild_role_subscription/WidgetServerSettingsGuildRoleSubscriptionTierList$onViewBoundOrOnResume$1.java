package com.discord.widgets.servers.guild_role_subscription;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionTierList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionTierList$onViewBoundOrOnResume$1 extends o implements Function1<ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionTierList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptionTierList$onViewBoundOrOnResume$1(WidgetServerSettingsGuildRoleSubscriptionTierList widgetServerSettingsGuildRoleSubscriptionTierList) {
        super(1);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionTierList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState serverSettingsGuildRoleSubscriptionTierListViewModel$ViewState) {
        invoke2(serverSettingsGuildRoleSubscriptionTierListViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState serverSettingsGuildRoleSubscriptionTierListViewModel$ViewState) {
        WidgetServerSettingsGuildRoleSubscriptionTierList widgetServerSettingsGuildRoleSubscriptionTierList = this.this$0;
        m.checkNotNullExpressionValue(serverSettingsGuildRoleSubscriptionTierListViewModel$ViewState, "it");
        WidgetServerSettingsGuildRoleSubscriptionTierList.access$configureUI(widgetServerSettingsGuildRoleSubscriptionTierList, serverSettingsGuildRoleSubscriptionTierListViewModel$ViewState);
    }
}
