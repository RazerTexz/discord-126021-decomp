package com.discord.widgets.voice.settings;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings$Companion {
    private WidgetVoiceChannelSettings$Companion() {
    }

    public final void launch(long channelId, Context context) {
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_CHANNEL_ID", channelId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT…RA_CHANNEL_ID, channelId)");
        j.d(context, WidgetVoiceChannelSettings.class, intentPutExtra);
    }

    public /* synthetic */ WidgetVoiceChannelSettings$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
