package com.discord.widgets.settings.billing;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$onViewBound$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetPaymentSourceEditDialog this$0;

    public WidgetPaymentSourceEditDialog$onViewBound$5(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog) {
        this.this$0 = widgetPaymentSourceEditDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
