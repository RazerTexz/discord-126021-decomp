package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBoundOrOnResume$3 extends o implements Function1<ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event, Unit> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBoundOrOnResume$3(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        super(1);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionEditTier;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event serverSettingsGuildRoleSubscriptionEditTierViewModel$Event) {
        invoke2(serverSettingsGuildRoleSubscriptionEditTierViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event serverSettingsGuildRoleSubscriptionEditTierViewModel$Event) {
        m.checkNotNullParameter(serverSettingsGuildRoleSubscriptionEditTierViewModel$Event, "it");
        WidgetServerSettingsGuildRoleSubscriptionEditTier.access$handleEvents(this.this$0, serverSettingsGuildRoleSubscriptionEditTierViewModel$Event);
    }
}
