package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBoundOrOnResume$1 extends o implements Function1<ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBoundOrOnResume$1(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        super(1);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionEditTier;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState) {
        invoke2(serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState) {
        WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier = this.this$0;
        m.checkNotNullExpressionValue(serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState, "it");
        WidgetServerSettingsGuildRoleSubscriptionEditTier.access$configureUI(widgetServerSettingsGuildRoleSubscriptionEditTier, serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState);
    }
}
