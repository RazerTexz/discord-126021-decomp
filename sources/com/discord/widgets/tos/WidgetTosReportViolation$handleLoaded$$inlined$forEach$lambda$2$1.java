package com.discord.widgets.tos;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.discord.views.LoadingButton;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetTosReportViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2 this$0;

    public WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2$1(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2 widgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2) {
        this.this$0 = widgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (!m.areEqual(WidgetTosReportViolation.access$getViewModel$p(this.this$0.this$0).getReasonSelected(), this.this$0.$reasonView$inlined.getReason())) {
            WidgetTosReportViolation.access$getViewModel$p(this.this$0.this$0).setReasonSelected(this.this$0.$reasonView$inlined.getReason());
            LoadingButton loadingButton = WidgetTosReportViolation.access$getBinding$p(this.this$0.this$0).f2675b;
            m.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
            loadingButton.setEnabled(false);
            LinearLayout linearLayout = WidgetTosReportViolation.access$getBinding$p(this.this$0.this$0).d;
            m.checkNotNullExpressionValue(linearLayout, "binding.reportReasonsContainer");
            for (View view2 : ViewGroupKt.getChildren(linearLayout)) {
                Objects.requireNonNull(view2, "null cannot be cast to non-null type com.discord.widgets.tos.WidgetTosReportViolationReasonView");
                ((WidgetTosReportViolationReasonView) view2).setChecked(false);
            }
            this.this$0.$reasonView$inlined.setChecked(true);
        }
        LoadingButton loadingButton2 = WidgetTosReportViolation.access$getBinding$p(this.this$0.this$0).f2675b;
        m.checkNotNullExpressionValue(loadingButton2, "binding.reportButton");
        loadingButton2.setEnabled(WidgetTosReportViolation.access$getViewModel$p(this.this$0.this$0).getReasonSelected() != null);
    }
}
