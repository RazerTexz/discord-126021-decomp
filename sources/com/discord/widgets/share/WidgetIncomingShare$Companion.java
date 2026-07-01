package com.discord.widgets.share;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$Companion {
    private WidgetIncomingShare$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetIncomingShare$Companion widgetIncomingShare$Companion, Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        widgetIncomingShare$Companion.launch(context, str, str2);
    }

    public final void launch(Context context, String text, String recipient) {
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent().putExtra("android.intent.extra.TEXT", text).putExtra("EXTRA_RECIPIENT", recipient);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…TRA_RECIPIENT, recipient)");
        j.d(context, WidgetIncomingShare.class, intentPutExtra);
    }

    public /* synthetic */ WidgetIncomingShare$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
