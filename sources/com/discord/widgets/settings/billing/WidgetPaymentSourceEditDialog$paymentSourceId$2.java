package com.discord.widgets.settings.billing;

import android.os.Bundle;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$paymentSourceId$2 extends o implements Function0<String> {
    public final /* synthetic */ WidgetPaymentSourceEditDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPaymentSourceEditDialog$paymentSourceId$2(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog) {
        super(0);
        this.this$0 = widgetPaymentSourceEditDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        String string;
        Bundle arguments = this.this$0.getArguments();
        if (arguments == null || (string = arguments.getString("ARG_PAYMENT_SOURCE_ID")) == null) {
            string = "";
        }
        m.checkNotNullExpressionValue(string, "arguments?.getString(ARG_PAYMENT_SOURCE_ID) ?: \"\"");
        return string;
    }
}
