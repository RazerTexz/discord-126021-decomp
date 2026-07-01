package com.discord.widgets.channels.threads.browser;

import android.os.Bundle;
import b.d.b.a.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetThreadBrowserActive.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserActive$Companion {
    private WidgetThreadBrowserActive$Companion() {
    }

    public final WidgetThreadBrowserActive create(long guildId, long channelId) {
        WidgetThreadBrowserActive widgetThreadBrowserActive = new WidgetThreadBrowserActive();
        Bundle bundleT = a.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        widgetThreadBrowserActive.setArguments(bundleT);
        return widgetThreadBrowserActive;
    }

    public /* synthetic */ WidgetThreadBrowserActive$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
