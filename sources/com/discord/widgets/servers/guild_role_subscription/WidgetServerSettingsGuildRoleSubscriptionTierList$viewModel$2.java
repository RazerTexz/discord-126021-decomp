package com.discord.widgets.servers.guild_role_subscription;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionTierList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionTierList$viewModel$2 extends AbstractC12240o implements Function0<ServerSettingsGuildRoleSubscriptionTierListViewModel> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionTierList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptionTierList$viewModel$2(WidgetServerSettingsGuildRoleSubscriptionTierList widgetServerSettingsGuildRoleSubscriptionTierList) {
        super(0);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionTierList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsGuildRoleSubscriptionTierListViewModel invoke() {
        return new ServerSettingsGuildRoleSubscriptionTierListViewModel(this.this$0.getGuildId(), null, null, null, 14, null);
    }
}
