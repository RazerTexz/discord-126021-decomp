package com.discord.widgets.servers.guild_role_subscription;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmptyGuildRoleSubscriptions$viewModel$2 extends AbstractC12240o implements Function0<ServerSettingsEmptyGuildRoleSubscriptionsViewModel> {
    public final /* synthetic */ WidgetServerSettingsEmptyGuildRoleSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEmptyGuildRoleSubscriptions$viewModel$2(WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions) {
        super(0);
        this.this$0 = widgetServerSettingsEmptyGuildRoleSubscriptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsEmptyGuildRoleSubscriptionsViewModel invoke() {
        return new ServerSettingsEmptyGuildRoleSubscriptionsViewModel(this.this$0.getGuildId(), null, 2, null);
    }
}
