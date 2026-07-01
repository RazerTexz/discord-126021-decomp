package com.discord.widgets.tos;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetTosReportViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolation$handleLoaded$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetTosReportViolation this$0;

    public WidgetTosReportViolation$handleLoaded$1(WidgetTosReportViolation widgetTosReportViolation) {
        this.this$0 = widgetTosReportViolation;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetTosReportViolation.access$getViewModel$p(this.this$0).sendReport();
    }
}
