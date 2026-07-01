package com.discord.widgets.channels.settings;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettings$Companion {
    private WidgetThreadSettings$Companion() {
    }

    public final void launch(long channelId, Context context) {
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_CHANNEL_ID, channelId)");
        j.d(context, WidgetThreadSettings.class, intentPutExtra);
    }

    public /* synthetic */ WidgetThreadSettings$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
