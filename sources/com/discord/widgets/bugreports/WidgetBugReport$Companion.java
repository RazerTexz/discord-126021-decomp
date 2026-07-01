package com.discord.widgets.bugreports;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.screenshot_detection.ScreenshotDetector$Screenshot;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetBugReport$Companion {
    private WidgetBugReport$Companion() {
    }

    public final List<Priority> getPriorityLevels() {
        return WidgetBugReport.access$getPriorityLevels$cp();
    }

    public final void launch(Context context, ScreenshotDetector$Screenshot screenshot) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(screenshot, "screenshot");
        Intent intent = new Intent();
        intent.putExtra(WidgetBugReport.INTENT_EXTRA_SCREENSHOT_URI, screenshot.androidx.core.app.NotificationCompat$MessagingStyle$Message.KEY_DATA_URI java.lang.String.toString());
        intent.putExtra(WidgetBugReport.INTENT_EXTRA_SCREENSHOT_FILENAME, screenshot.filename);
        j.d(context, WidgetBugReport.class, intent);
    }

    public /* synthetic */ WidgetBugReport$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
