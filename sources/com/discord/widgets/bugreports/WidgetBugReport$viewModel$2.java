package com.discord.widgets.bugreports;

import android.net.Uri;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetBugReport$viewModel$2 extends Lambda implements Function0<BugReportViewModel> {
    public final /* synthetic */ WidgetBugReport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetBugReport$viewModel$2(WidgetBugReport widgetBugReport) {
        super(0);
        this.this$0 = widgetBugReport;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final BugReportViewModel invoke() {
        Uri uri = Uri.parse(this.this$0.getMostRecentIntent().getStringExtra(WidgetBugReport.INTENT_EXTRA_SCREENSHOT_URI));
        String stringExtra = this.this$0.getMostRecentIntent().getStringExtra(WidgetBugReport.INTENT_EXTRA_SCREENSHOT_FILENAME);
        if (stringExtra == null) {
            stringExtra = "";
        }
        Intrinsics3.checkNotNullExpressionValue(uri, "screenshotUri");
        return new BugReportViewModel(uri, stringExtra, null, 4, null);
    }
}
