package com.discord.utilities.bugreports;

import com.discord.screenshot_detection.ScreenshotDetector;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: BugReportManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportManager$screenshotDetector$2 extends o implements Function0<ScreenshotDetector> {
    public static final BugReportManager$screenshotDetector$2 INSTANCE = new BugReportManager$screenshotDetector$2();

    public BugReportManager$screenshotDetector$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ScreenshotDetector invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ScreenshotDetector invoke() {
        ScreenshotDetector screenshotDetector = ScreenshotDetector.a;
        if (screenshotDetector == null) {
            m.throwUninitializedPropertyAccessException("screenshotDetector");
        }
        return screenshotDetector;
    }
}
