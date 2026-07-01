package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier8 extends Lambda implements Function0<ServerSettingsGuildRoleSubscriptionEditTierViewModel> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptionEditTier8(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        super(0);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionEditTier;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsGuildRoleSubscriptionEditTierViewModel invoke() {
        return new ServerSettingsGuildRoleSubscriptionEditTierViewModel(this.this$0.getGuildId(), this.this$0.getGuildRoleSubscriptionTierListingId(), this.this$0.getGuildRoleSubscriptionGroupListingId(), null, null, null, null, null, null, 504, null);
    }
}
