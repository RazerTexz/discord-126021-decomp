package com.discord.widgets.settings.developer;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.bugreports.BugReportManager;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupScreenshotDetector$1<T> implements Action1<Boolean> {
    public final /* synthetic */ BugReportManager $bugReportProvider;

    public WidgetSettingsDeveloper$setupScreenshotDetector$1(BugReportManager bugReportManager) {
        this.$bugReportProvider = bugReportManager;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        BugReportManager bugReportManager = this.$bugReportProvider;
        m.checkNotNullExpressionValue(bool, "isChecked");
        bugReportManager.setBugReportingSettingEnabled(bool.booleanValue());
    }
}
