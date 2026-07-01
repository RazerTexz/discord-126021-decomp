package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier$Companion {
    private WidgetServerSettingsGuildRoleSubscriptionEditTier$Companion() {
    }

    public final void launch(Context context, long guildId, long guildRoleSubscriptionGroupListingId, long guildRoleSubscriptionTierListingId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        intent.putExtra("INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_GROUP_LISTING_ID", guildRoleSubscriptionGroupListingId);
        intent.putExtra("INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_TIER_LISTING_ID", guildRoleSubscriptionTierListingId);
        j.d(context, WidgetServerSettingsGuildRoleSubscriptionEditTier.class, intent);
    }

    public /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
