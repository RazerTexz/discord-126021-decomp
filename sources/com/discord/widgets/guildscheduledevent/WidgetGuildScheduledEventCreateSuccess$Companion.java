package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess$Companion {
    private WidgetGuildScheduledEventCreateSuccess$Companion() {
    }

    public final void launch(Context context, Long channelId, long guildId, long guildScheduledEventId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId);
        j.d(context, WidgetGuildScheduledEventCreateSuccess.class, intent);
    }

    public /* synthetic */ WidgetGuildScheduledEventCreateSuccess$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
