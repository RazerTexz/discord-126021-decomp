package com.discord.widgets.servers.guild_role_subscription;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmptyGuildRoleSubscriptions$viewModel$2 extends o implements Function0<ServerSettingsEmptyGuildRoleSubscriptionsViewModel> {
    public final /* synthetic */ WidgetServerSettingsEmptyGuildRoleSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEmptyGuildRoleSubscriptions$viewModel$2(WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions) {
        super(0);
        this.this$0 = widgetServerSettingsEmptyGuildRoleSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ServerSettingsEmptyGuildRoleSubscriptionsViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsEmptyGuildRoleSubscriptionsViewModel invoke() {
        return new ServerSettingsEmptyGuildRoleSubscriptionsViewModel(WidgetServerSettingsEmptyGuildRoleSubscriptions.access$getGuildId$p(this.this$0), null, 2, null);
    }
}
