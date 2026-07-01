package com.discord.widgets.guild_role_subscriptions.setup;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanFormat$onViewBoundOrOnResume$1 extends o implements Function1<GuildRoleSubscriptionPlanDetailsViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionPlanFormat this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionPlanFormat$onViewBoundOrOnResume$1(WidgetGuildRoleSubscriptionPlanFormat widgetGuildRoleSubscriptionPlanFormat) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionPlanFormat;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanDetailsViewModel$ViewState guildRoleSubscriptionPlanDetailsViewModel$ViewState) {
        invoke2(guildRoleSubscriptionPlanDetailsViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionPlanDetailsViewModel$ViewState guildRoleSubscriptionPlanDetailsViewModel$ViewState) {
        m.checkNotNullParameter(guildRoleSubscriptionPlanDetailsViewModel$ViewState, "it");
        WidgetGuildRoleSubscriptionPlanFormat.access$configureUI(this.this$0, guildRoleSubscriptionPlanDetailsViewModel$ViewState);
    }
}
