package com.discord.widgets.guild_role_subscriptions.setup;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanDetails$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanDetails4 extends Lambda implements Function0<GuildRoleSubscriptionPlanDetailsViewModel> {
    public static final WidgetGuildRoleSubscriptionPlanDetails4 INSTANCE = new WidgetGuildRoleSubscriptionPlanDetails4();

    public WidgetGuildRoleSubscriptionPlanDetails4() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionPlanDetailsViewModel invoke() {
        return new GuildRoleSubscriptionPlanDetailsViewModel();
    }
}
