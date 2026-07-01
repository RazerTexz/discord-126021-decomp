package com.discord.widgets.guild_automod;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetReportIssueWithAutoMod$Companion {
    private WidgetReportIssueWithAutoMod$Companion() {
    }

    public final void launch(Context context, long channelId, long messageId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        intent.putExtra("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
        j.d(context, WidgetReportIssueWithAutoMod.class, intent);
    }

    public /* synthetic */ WidgetReportIssueWithAutoMod$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
