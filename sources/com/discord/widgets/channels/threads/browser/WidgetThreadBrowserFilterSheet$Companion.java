package com.discord.widgets.channels.threads.browser;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetThreadBrowserFilterSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserFilterSheet$Companion {
    private WidgetThreadBrowserFilterSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long guildId, long channelId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet = new WidgetThreadBrowserFilterSheet();
        Bundle bundleT = a.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        widgetThreadBrowserFilterSheet.setArguments(bundleT);
        widgetThreadBrowserFilterSheet.show(fragmentManager, WidgetThreadBrowserFilterSheet.class.getName());
    }

    public /* synthetic */ WidgetThreadBrowserFilterSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
