package com.discord.widgets.settings.billing;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$onViewBound$1<T, R> implements b<SettingsBillingViewModel$ViewState$Loaded, List<? extends PaymentSourceAdapter$PaymentSourceItem>> {
    public static final WidgetPaymentSourceEditDialog$onViewBound$1 INSTANCE = new WidgetPaymentSourceEditDialog$onViewBound$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends PaymentSourceAdapter$PaymentSourceItem> call(SettingsBillingViewModel$ViewState$Loaded settingsBillingViewModel$ViewState$Loaded) {
        return call2(settingsBillingViewModel$ViewState$Loaded);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<PaymentSourceAdapter$PaymentSourceItem> call2(SettingsBillingViewModel$ViewState$Loaded settingsBillingViewModel$ViewState$Loaded) {
        List<PaymentSourceAdapter$Item> paymentSourceItems = settingsBillingViewModel$ViewState$Loaded.getPaymentSourceItems();
        ArrayList arrayList = new ArrayList();
        for (PaymentSourceAdapter$Item paymentSourceAdapter$Item : paymentSourceItems) {
            if (!(paymentSourceAdapter$Item instanceof PaymentSourceAdapter$PaymentSourceItem)) {
                paymentSourceAdapter$Item = null;
            }
            PaymentSourceAdapter$PaymentSourceItem paymentSourceAdapter$PaymentSourceItem = (PaymentSourceAdapter$PaymentSourceItem) paymentSourceAdapter$Item;
            if (paymentSourceAdapter$PaymentSourceItem != null) {
                arrayList.add(paymentSourceAdapter$PaymentSourceItem);
            }
        }
        return arrayList;
    }
}
