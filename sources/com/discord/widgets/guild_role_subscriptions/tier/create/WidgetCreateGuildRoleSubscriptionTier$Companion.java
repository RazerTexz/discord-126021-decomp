package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateGuildRoleSubscriptionTier$Companion {
    private WidgetCreateGuildRoleSubscriptionTier$Companion() {
    }

    public final void launch(Context context, long guildId, long groupListingId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        intent.putExtra("INTENT_EXTRA_GROUP_LISTING_ID", groupListingId);
        j.d(context, WidgetCreateGuildRoleSubscriptionTier.class, intent);
    }

    public /* synthetic */ WidgetCreateGuildRoleSubscriptionTier$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
