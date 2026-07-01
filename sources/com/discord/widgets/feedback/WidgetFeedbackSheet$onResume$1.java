package com.discord.widgets.feedback;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFeedbackSheet$onResume$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetFeedbackSheet this$0;

    public WidgetFeedbackSheet$onResume$1(WidgetFeedbackSheet widgetFeedbackSheet) {
        this.this$0 = widgetFeedbackSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetFeedbackSheet.access$getViewModel$p(this.this$0).submitForm();
    }
}
