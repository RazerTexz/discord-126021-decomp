package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetThreadBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowser$Companion {
    private WidgetThreadBrowser$Companion() {
    }

    public final void show(Context context, long guildId, long channelId, String location) {
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        if (context != null) {
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            j.d(context, WidgetThreadBrowser.class, intent);
            AnalyticsTracker.openModal("Thread Browser", location, Long.valueOf(guildId));
        }
    }

    public /* synthetic */ WidgetThreadBrowser$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
