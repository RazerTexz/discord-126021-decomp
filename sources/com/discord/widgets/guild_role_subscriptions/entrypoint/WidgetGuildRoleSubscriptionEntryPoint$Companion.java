package com.discord.widgets.guild_role_subscriptions.entrypoint;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionEntryPoint$Companion {
    private WidgetGuildRoleSubscriptionEntryPoint$Companion() {
    }

    public final void launch(Context context, long guildId, String trackingSourceLocation) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(trackingSourceLocation, "trackingSourceLocation");
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        intent.putExtra("INTENT_EXTRA_TRACKING_SOURCE_LOCATION", trackingSourceLocation);
        j.d(context, WidgetGuildRoleSubscriptionEntryPoint.class, intent);
    }

    public /* synthetic */ WidgetGuildRoleSubscriptionEntryPoint$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
