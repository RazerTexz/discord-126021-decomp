package com.discord.widgets.servers.guild_role_subscription;

import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanDetailsViewModel$ViewState;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$3 extends o implements Function1<GuildRoleSubscriptionPlanDetailsViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$3(WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions) {
        super(1);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanDetailsViewModel$ViewState guildRoleSubscriptionPlanDetailsViewModel$ViewState) {
        invoke2(guildRoleSubscriptionPlanDetailsViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionPlanDetailsViewModel$ViewState guildRoleSubscriptionPlanDetailsViewModel$ViewState) {
        WidgetServerSettingsGuildRoleSubscriptions.access$getViewModel$p(this.this$0).onGuildRoleSubscriptionGroupUpdated(guildRoleSubscriptionPlanDetailsViewModel$ViewState.getDescription(), guildRoleSubscriptionPlanDetailsViewModel$ViewState.getCoverImage(), guildRoleSubscriptionPlanDetailsViewModel$ViewState.isFullServerGate());
    }
}
