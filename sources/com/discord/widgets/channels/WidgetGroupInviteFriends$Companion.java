package com.discord.widgets.channels;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Companion {
    private WidgetGroupInviteFriends$Companion() {
    }

    public final void launch(Context context, String source) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(source, "source");
        AnalyticsTracker.openModal$default("DM Group Create", source, null, 4, null);
        j.e(context, WidgetGroupInviteFriends.class, null, 4);
    }

    public /* synthetic */ WidgetGroupInviteFriends$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void launch(Context context, long channelId, String source) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(source, "source");
        AnalyticsTracker.openModal$default("DM Group Add", source, null, 4, null);
        Intent intent = new Intent();
        intent.putExtra("INTENT_EXTRA_CHANNEL_ID", channelId);
        j.d(context, WidgetGroupInviteFriends.class, intent);
    }
}
