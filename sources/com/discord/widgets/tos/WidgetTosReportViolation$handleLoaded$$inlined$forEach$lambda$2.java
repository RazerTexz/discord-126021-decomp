package com.discord.widgets.tos;

import android.view.View;
import android.view.View$OnLayoutChangeListener;
import com.discord.api.report.ReportReason;
import d0.z.d.m;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2 implements View$OnLayoutChangeListener {
    public final /* synthetic */ ReportReason $reason$inlined;
    public final /* synthetic */ WidgetTosReportViolationReasonView $reasonView$inlined;
    public final /* synthetic */ WidgetTosReportViolation this$0;

    public WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2(WidgetTosReportViolationReasonView widgetTosReportViolationReasonView, ReportReason reportReason, WidgetTosReportViolation widgetTosReportViolation) {
        this.$reasonView$inlined = widgetTosReportViolationReasonView;
        this.$reason$inlined = reportReason;
        this.this$0 = widgetTosReportViolation;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        m.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        this.$reasonView$inlined.setReason(this.$reason$inlined);
        this.$reasonView$inlined.setChecked(m.areEqual(this.$reason$inlined, WidgetTosReportViolation.access$getViewModel$p(this.this$0).getReasonSelected()));
        this.$reasonView$inlined.setOnClickListener(new WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2$1(this));
    }
}
