package com.discord.widgets.settings.billing;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$onViewBound$2<T, R> implements b<List<? extends PaymentSourceAdapter$PaymentSourceItem>, PaymentSourceAdapter$PaymentSourceItem> {
    public final /* synthetic */ WidgetPaymentSourceEditDialog this$0;

    public WidgetPaymentSourceEditDialog$onViewBound$2(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog) {
        this.this$0 = widgetPaymentSourceEditDialog;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ PaymentSourceAdapter$PaymentSourceItem call(List<? extends PaymentSourceAdapter$PaymentSourceItem> list) {
        return call2((List<PaymentSourceAdapter$PaymentSourceItem>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final PaymentSourceAdapter$PaymentSourceItem call2(List<PaymentSourceAdapter$PaymentSourceItem> list) {
        T next;
        m.checkNotNullExpressionValue(list, "paymentSources");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (m.areEqual(((PaymentSourceAdapter$PaymentSourceItem) next).getPaymentSource().getId(), WidgetPaymentSourceEditDialog.access$getPaymentSourceId$p(this.this$0))) {
                return next;
            }
        }
        next = (T) null;
        return next;
    }
}
