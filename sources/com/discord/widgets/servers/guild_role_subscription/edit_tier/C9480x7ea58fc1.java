package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$guildRoleSubscriptionTierListingId$2 */
/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9480x7ea58fc1 extends AbstractC12240o implements Function0<Long> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9480x7ea58fc1(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        super(0);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionEditTier;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_TIER_LISTING_ID", -1L);
    }
}
