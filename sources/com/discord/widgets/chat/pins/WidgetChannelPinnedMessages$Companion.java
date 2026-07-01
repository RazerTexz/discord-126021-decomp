package com.discord.widgets.chat.pins;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPinnedMessages$Companion {
    private WidgetChannelPinnedMessages$Companion() {
    }

    public final void show(Context context, long channelId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("INTENT_EXTRA_CHANNEL_ID", channelId);
        j.d(context, WidgetChannelPinnedMessages.class, intent);
    }

    public /* synthetic */ WidgetChannelPinnedMessages$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
