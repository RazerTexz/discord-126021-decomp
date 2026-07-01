package com.discord.widgets.guilds.profile;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$Companion {
    private WidgetGuildProfileSheet$Companion() {
    }

    public static /* synthetic */ void show$default(WidgetGuildProfileSheet$Companion widgetGuildProfileSheet$Companion, FragmentManager fragmentManager, boolean z2, long j, long j2, boolean z3, int i, Object obj) {
        widgetGuildProfileSheet$Companion.show(fragmentManager, z2, j, (i & 8) != 0 ? 0L : j2, (i & 16) != 0 ? false : z3);
    }

    public final void show(FragmentManager fragmentManager, boolean viewingGuild, long guildId, long channelId, boolean fromGuildEventUpsell) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetGuildProfileSheet widgetGuildProfileSheet = new WidgetGuildProfileSheet();
        Bundle bundleT = a.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        bundleT.putBoolean("com.discord.intent.extra.EXTRA_VIEWING_GUILD", viewingGuild);
        bundleT.putBoolean("EXTRA_FROM_UPSELL", fromGuildEventUpsell);
        widgetGuildProfileSheet.setArguments(bundleT);
        widgetGuildProfileSheet.show(fragmentManager, WidgetGuildProfileSheet.class.getName());
    }

    public /* synthetic */ WidgetGuildProfileSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
