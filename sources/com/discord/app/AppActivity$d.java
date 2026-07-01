package com.discord.app;

import com.discord.screenshot_detection.ScreenshotDetector$Screenshot;
import com.discord.utilities.bugreports.BugReportManager;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppActivity$d extends o implements Function1<ScreenshotDetector$Screenshot, Unit> {
    public final /* synthetic */ AppActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppActivity$d(AppActivity appActivity) {
        super(1);
        this.this$0 = appActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ScreenshotDetector$Screenshot screenshotDetector$Screenshot) {
        ScreenshotDetector$Screenshot screenshotDetector$Screenshot2 = screenshotDetector$Screenshot;
        m.checkNotNullParameter(screenshotDetector$Screenshot2, "screenshot");
        BugReportManager.Companion.get().onScreenshot(this.this$0, screenshotDetector$Screenshot2);
        return Unit.a;
    }
}
