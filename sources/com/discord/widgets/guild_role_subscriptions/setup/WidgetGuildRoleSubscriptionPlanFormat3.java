package com.discord.widgets.guild_role_subscriptions.setup;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanFormat$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanFormat3 extends Lambda implements Function0<GuildRoleSubscriptionPlanDetailsViewModel> {
    public static final WidgetGuildRoleSubscriptionPlanFormat3 INSTANCE = new WidgetGuildRoleSubscriptionPlanFormat3();

    public WidgetGuildRoleSubscriptionPlanFormat3() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionPlanDetailsViewModel invoke() {
        return new GuildRoleSubscriptionPlanDetailsViewModel();
    }
}
