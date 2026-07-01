package com.discord.widgets.announcements;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheet$Companion {
    private WidgetChannelFollowSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long channelId, long guildId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetChannelFollowSheet widgetChannelFollowSheet = new WidgetChannelFollowSheet();
        Bundle bundleT = a.T("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        bundleT.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        widgetChannelFollowSheet.setArguments(bundleT);
        widgetChannelFollowSheet.show(fragmentManager, WidgetChannelFollowSheet.class.getName());
    }

    public /* synthetic */ WidgetChannelFollowSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
