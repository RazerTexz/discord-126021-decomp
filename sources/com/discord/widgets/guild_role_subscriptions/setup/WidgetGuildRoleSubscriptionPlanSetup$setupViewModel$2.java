package com.discord.widgets.guild_role_subscriptions.setup;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanSetup$setupViewModel$2 extends Lambda implements Function0<GuildRoleSubscriptionPlanSetupViewModel> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionPlanSetup this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionPlanSetup$setupViewModel$2(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionPlanSetup;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionPlanSetupViewModel invoke() {
        return new GuildRoleSubscriptionPlanSetupViewModel(this.this$0.getGuildId(), null, null, 6, null);
    }
}
