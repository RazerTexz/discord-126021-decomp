package com.discord.widgets.guild_role_subscriptions.tier.create;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateGuildRoleSubscriptionTier$createTierViewModel$2 extends Lambda implements Function0<CreateGuildRoleSubscriptionTierViewModel> {
    public final /* synthetic */ WidgetCreateGuildRoleSubscriptionTier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreateGuildRoleSubscriptionTier$createTierViewModel$2(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier) {
        super(0);
        this.this$0 = widgetCreateGuildRoleSubscriptionTier;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CreateGuildRoleSubscriptionTierViewModel invoke() {
        return new CreateGuildRoleSubscriptionTierViewModel(this.this$0.getGuildId(), this.this$0.getGroupListingId(), null, null, null, null, null, 124, null);
    }
}
