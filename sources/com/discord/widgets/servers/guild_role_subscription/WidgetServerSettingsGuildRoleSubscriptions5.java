package com.discord.widgets.servers.guild_role_subscription;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptions5 extends Lambda implements Function0<ServerSettingsGuildRoleSubscriptionViewModel> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptions5(WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions) {
        super(0);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsGuildRoleSubscriptionViewModel invoke() {
        return new ServerSettingsGuildRoleSubscriptionViewModel(this.this$0.getGuildId(), null, null, null, null, null, 62, null);
    }
}
