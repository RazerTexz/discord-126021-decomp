package com.discord.widgets.home;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetMainSurveyDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMainSurveyDialog$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetMainSurveyDialog this$0;

    public WidgetMainSurveyDialog$onViewBound$1(WidgetMainSurveyDialog widgetMainSurveyDialog) {
        this.this$0 = widgetMainSurveyDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
