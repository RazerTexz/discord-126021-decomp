package com.discord.widgets.bugreports;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetBugReport$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetBugReport this$0;

    public WidgetBugReport$onViewBound$1(WidgetBugReport widgetBugReport) {
        this.this$0 = widgetBugReport;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetBugReport.access$getViewModel$p(this.this$0).useScreenshot(false);
    }
}
