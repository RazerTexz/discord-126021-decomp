package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview$Companion {
    private WidgetChannelSettingsPermissionsOverview$Companion() {
    }

    public final void launch(Context context, long channelId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        j.d(context, WidgetChannelSettingsPermissionsOverview.class, intent);
    }

    public /* synthetic */ WidgetChannelSettingsPermissionsOverview$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
