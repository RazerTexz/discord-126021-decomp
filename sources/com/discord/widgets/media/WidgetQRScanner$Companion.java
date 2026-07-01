package com.discord.widgets.media;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetQRScanner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetQRScanner$Companion {
    private WidgetQRScanner$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetQRScanner$Companion widgetQRScanner$Companion, Context context, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        widgetQRScanner$Companion.launch(context, z2);
    }

    public final void launch(Context context, boolean showHelpChip) {
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent("android.intent.action.VIEW").putExtra("SHOW_HELP_CHIP", showHelpChip);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent(Intent.ACTION_VIE…_HELP_CHIP, showHelpChip)");
        j.d(context, WidgetQRScanner.class, intentPutExtra);
    }

    public /* synthetic */ WidgetQRScanner$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
