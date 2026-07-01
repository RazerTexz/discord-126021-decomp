package com.discord.widgets.tos;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetTosReportViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolation$Companion {
    private WidgetTosReportViolation$Companion() {
    }

    public static /* synthetic */ void show$default(WidgetTosReportViolation$Companion widgetTosReportViolation$Companion, Context context, String str, Long l, Long l2, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        if ((i & 8) != 0) {
            l2 = null;
        }
        widgetTosReportViolation$Companion.show(context, str, l, l2);
    }

    public final void show(Context context, String target, Long channelId, Long messageId) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(target, "target");
        Intent intent = new Intent();
        intent.putExtra("EXTRA_CHANNEL_ID", channelId);
        intent.putExtra("EXTRA_MESSAGE_ID", messageId);
        intent.putExtra("EXTRA_TARGET", target);
        j.d(context, WidgetTosReportViolation.class, intent);
    }

    public /* synthetic */ WidgetTosReportViolation$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
