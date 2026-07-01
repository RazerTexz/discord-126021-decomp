package com.discord.widgets.guildscheduledevent;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventListBottomSheet$Companion {
    private WidgetGuildScheduledEventListBottomSheet$Companion() {
    }

    public static /* synthetic */ void show$default(WidgetGuildScheduledEventListBottomSheet$Companion widgetGuildScheduledEventListBottomSheet$Companion, FragmentManager fragmentManager, long j, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        widgetGuildScheduledEventListBottomSheet$Companion.show(fragmentManager, j, l);
    }

    public final void show(FragmentManager fragmentManager, long guildId, Long channelId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet = new WidgetGuildScheduledEventListBottomSheet();
        Bundle bundleT = a.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        if (channelId != null) {
            bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId.longValue());
        }
        widgetGuildScheduledEventListBottomSheet.setArguments(bundleT);
        widgetGuildScheduledEventListBottomSheet.show(fragmentManager, WidgetGuildScheduledEventListBottomSheet.class.getName());
    }

    public /* synthetic */ WidgetGuildScheduledEventListBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
