package com.discord.widgets.guilds.join;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheet$Companion {
    private WidgetGuildWelcomeSheet$Companion() {
    }

    public static /* synthetic */ void show$default(WidgetGuildWelcomeSheet$Companion widgetGuildWelcomeSheet$Companion, FragmentManager fragmentManager, long j, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        widgetGuildWelcomeSheet$Companion.show(fragmentManager, j, l);
    }

    public final void show(FragmentManager fragmentManager, long guildId, Long guildScheduledEventId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetGuildWelcomeSheet widgetGuildWelcomeSheet = new WidgetGuildWelcomeSheet();
        Bundle bundleT = a.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        if (guildScheduledEventId != null) {
            bundleT.putLong("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId.longValue());
        }
        widgetGuildWelcomeSheet.setArguments(bundleT);
        widgetGuildWelcomeSheet.show(fragmentManager, WidgetGuildWelcomeSheet.class.getName());
    }

    public /* synthetic */ WidgetGuildWelcomeSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
