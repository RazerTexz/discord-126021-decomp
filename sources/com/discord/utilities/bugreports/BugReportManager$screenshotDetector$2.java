package com.discord.utilities.bugreports;

import com.discord.screenshot_detection.ScreenshotDetector;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: BugReportManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportManager$screenshotDetector$2 extends AbstractC12240o implements Function0<ScreenshotDetector> {
    public static final BugReportManager$screenshotDetector$2 INSTANCE = new BugReportManager$screenshotDetector$2();

    public BugReportManager$screenshotDetector$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ScreenshotDetector invoke() {
        ScreenshotDetector screenshotDetector = ScreenshotDetector.f18938a;
        if (screenshotDetector == null) {
            C12238m.throwUninitializedPropertyAccessException("screenshotDetector");
        }
        return screenshotDetector;
    }
}
