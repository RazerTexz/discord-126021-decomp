package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelect$Companion {
    private WidgetGuildScheduledEventLocationSelect$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetGuildScheduledEventLocationSelect$Companion widgetGuildScheduledEventLocationSelect$Companion, Context context, long j, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        widgetGuildScheduledEventLocationSelect$Companion.launch(context, j, l);
    }

    public final void launch(Context context, long guildId, Long channelId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        if (channelId != null) {
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId.longValue());
        }
        j.d(context, WidgetGuildScheduledEventLocationSelect.class, intent);
    }

    public final void launchForEdit(Context context, long guildId, long guildScheduledEventId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId);
        j.d(context, WidgetGuildScheduledEventLocationSelect.class, intent);
    }

    public /* synthetic */ WidgetGuildScheduledEventLocationSelect$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
