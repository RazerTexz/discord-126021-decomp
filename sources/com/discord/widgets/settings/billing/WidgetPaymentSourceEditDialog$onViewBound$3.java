package com.discord.widgets.settings.billing;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$onViewBound$3 extends o implements Function1<PaymentSourceAdapter$PaymentSourceItem, Unit> {
    public final /* synthetic */ WidgetPaymentSourceEditDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPaymentSourceEditDialog$onViewBound$3(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog) {
        super(1);
        this.this$0 = widgetPaymentSourceEditDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PaymentSourceAdapter$PaymentSourceItem paymentSourceAdapter$PaymentSourceItem) {
        invoke2(paymentSourceAdapter$PaymentSourceItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PaymentSourceAdapter$PaymentSourceItem paymentSourceAdapter$PaymentSourceItem) {
        if (paymentSourceAdapter$PaymentSourceItem == null) {
            this.this$0.dismiss();
        } else {
            WidgetPaymentSourceEditDialog.access$initPaymentSourceInfo(this.this$0, paymentSourceAdapter$PaymentSourceItem);
        }
    }
}
