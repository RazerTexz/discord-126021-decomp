package com.discord.widgets.hubs;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetHubAddServerConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServerConfirmationDialog$onViewBoundOrOnResume$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetHubAddServerConfirmationDialog this$0;

    public WidgetHubAddServerConfirmationDialog$onViewBoundOrOnResume$1(WidgetHubAddServerConfirmationDialog widgetHubAddServerConfirmationDialog) {
        this.this$0 = widgetHubAddServerConfirmationDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
