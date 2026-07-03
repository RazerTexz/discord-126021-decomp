package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier$viewModel$2 extends AbstractC12240o implements Function0<ServerSettingsGuildRoleSubscriptionEditTierViewModel> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptionEditTier$viewModel$2(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        super(0);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionEditTier;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsGuildRoleSubscriptionEditTierViewModel invoke() {
        return new ServerSettingsGuildRoleSubscriptionEditTierViewModel(this.this$0.getGuildId(), this.this$0.getGuildRoleSubscriptionTierListingId(), this.this$0.getGuildRoleSubscriptionGroupListingId(), null, null, null, null, null, null, 504, null);
    }
}
