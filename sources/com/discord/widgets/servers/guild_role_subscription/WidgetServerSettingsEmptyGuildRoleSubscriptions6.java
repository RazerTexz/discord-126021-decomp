package com.discord.widgets.servers.guild_role_subscription;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmptyGuildRoleSubscriptions6 extends Lambda implements Function0<ServerSettingsEmptyGuildRoleSubscriptionsViewModel> {
    public final /* synthetic */ WidgetServerSettingsEmptyGuildRoleSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEmptyGuildRoleSubscriptions6(WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions) {
        super(0);
        this.this$0 = widgetServerSettingsEmptyGuildRoleSubscriptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsEmptyGuildRoleSubscriptionsViewModel invoke() {
        return new ServerSettingsEmptyGuildRoleSubscriptionsViewModel(this.this$0.getGuildId(), null, 2, null);
    }
}
