package com.discord.widgets.settings.billing;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelPaymentSource;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$initPaymentSourceInfo$3 implements View$OnClickListener {
    public final /* synthetic */ ModelPaymentSource $paymentSource;
    public final /* synthetic */ WidgetPaymentSourceEditDialog this$0;

    public WidgetPaymentSourceEditDialog$initPaymentSourceInfo$3(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog, ModelPaymentSource modelPaymentSource) {
        this.this$0 = widgetPaymentSourceEditDialog;
        this.$paymentSource = modelPaymentSource;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetPaymentSourceEditDialog.access$deletePaymentSource(this.this$0, this.$paymentSource);
    }
}
