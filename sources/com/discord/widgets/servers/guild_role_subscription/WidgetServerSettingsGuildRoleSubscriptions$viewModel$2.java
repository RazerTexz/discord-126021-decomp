package com.discord.widgets.servers.guild_role_subscription;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptions$viewModel$2 extends AbstractC12240o implements Function0<ServerSettingsGuildRoleSubscriptionViewModel> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptions$viewModel$2(WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions) {
        super(0);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsGuildRoleSubscriptionViewModel invoke() {
        return new ServerSettingsGuildRoleSubscriptionViewModel(this.this$0.getGuildId(), null, null, null, null, null, 62, null);
    }
}
