package com.discord.widgets.servers.guild_role_subscription;

import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanDetailsViewModel;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions$planDetailsViewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptions4 extends Lambda implements Function0<GuildRoleSubscriptionPlanDetailsViewModel> {
    public static final WidgetServerSettingsGuildRoleSubscriptions4 INSTANCE = new WidgetServerSettingsGuildRoleSubscriptions4();

    public WidgetServerSettingsGuildRoleSubscriptions4() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionPlanDetailsViewModel invoke() {
        return new GuildRoleSubscriptionPlanDetailsViewModel();
    }
}
