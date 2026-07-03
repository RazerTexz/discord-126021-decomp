package com.discord.widgets.settings.billing;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$paymentSourceId$2 extends AbstractC12240o implements Function0<String> {
    public final /* synthetic */ WidgetPaymentSourceEditDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPaymentSourceEditDialog$paymentSourceId$2(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog) {
        super(0);
        this.this$0 = widgetPaymentSourceEditDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        String string;
        Bundle arguments = this.this$0.getArguments();
        if (arguments == null || (string = arguments.getString("ARG_PAYMENT_SOURCE_ID")) == null) {
            string = "";
        }
        C12238m.checkNotNullExpressionValue(string, "arguments?.getString(ARG_PAYMENT_SOURCE_ID) ?: \"\"");
        return string;
    }
}
