package com.discord.widgets.channels.threads.browser;

import android.os.Bundle;
import b.d.b.a.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetThreadBrowserArchived.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserArchived$Companion {
    private WidgetThreadBrowserArchived$Companion() {
    }

    public final WidgetThreadBrowserArchived create(long guildId, long channelId) {
        WidgetThreadBrowserArchived widgetThreadBrowserArchived = new WidgetThreadBrowserArchived();
        Bundle bundleT = a.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        widgetThreadBrowserArchived.setArguments(bundleT);
        return widgetThreadBrowserArchived;
    }

    public /* synthetic */ WidgetThreadBrowserArchived$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
