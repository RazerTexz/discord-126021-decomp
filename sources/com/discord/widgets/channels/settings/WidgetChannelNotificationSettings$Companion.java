package com.discord.widgets.channels.settings;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings$Companion {
    private WidgetChannelNotificationSettings$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetChannelNotificationSettings$Companion widgetChannelNotificationSettings$Companion, Context context, long j, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        widgetChannelNotificationSettings$Companion.launch(context, j, z2);
    }

    public final void launch(Context context, long channelId, boolean showSystemSetting) {
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId).putExtra("SHOW_SYSTEM_SETTING", showSystemSetting);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…TINGS, showSystemSetting)");
        j.d(context, WidgetChannelNotificationSettings.class, intentPutExtra);
    }

    public /* synthetic */ WidgetChannelNotificationSettings$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
