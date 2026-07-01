package com.discord.widgets.channels.settings;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelGroupDMSettings$Companion {
    private WidgetChannelGroupDMSettings$Companion() {
    }

    public final void create(long channelId, Context context) {
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_CHANNEL_ID", channelId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT…RA_CHANNEL_ID, channelId)");
        j.d(context, WidgetChannelGroupDMSettings.class, intentPutExtra);
    }

    public /* synthetic */ WidgetChannelGroupDMSettings$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
