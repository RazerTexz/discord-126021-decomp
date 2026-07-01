package com.discord.widgets.guild_role_subscriptions.setup;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$2 extends o implements Function1<GuildRoleSubscriptionPlanSetupViewModel$Event, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionPlanSetup this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$2(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionPlanSetup;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanSetupViewModel$Event guildRoleSubscriptionPlanSetupViewModel$Event) {
        invoke2(guildRoleSubscriptionPlanSetupViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionPlanSetupViewModel$Event guildRoleSubscriptionPlanSetupViewModel$Event) {
        m.checkNotNullParameter(guildRoleSubscriptionPlanSetupViewModel$Event, "it");
        WidgetGuildRoleSubscriptionPlanSetup.access$handleEvents(this.this$0, guildRoleSubscriptionPlanSetupViewModel$Event);
    }
}
