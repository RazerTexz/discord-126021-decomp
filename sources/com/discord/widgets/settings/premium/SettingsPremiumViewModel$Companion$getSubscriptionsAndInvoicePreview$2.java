package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import j0.k.b;

/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsPremiumViewModel$Companion$getSubscriptionsAndInvoicePreview$2<T, R> implements b<Throwable, SettingsPremiumViewModel$SubscriptionAndInvoice> {
    public final /* synthetic */ StoreSubscriptions$SubscriptionsState $state;

    public SettingsPremiumViewModel$Companion$getSubscriptionsAndInvoicePreview$2(StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState) {
        this.$state = storeSubscriptions$SubscriptionsState;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ SettingsPremiumViewModel$SubscriptionAndInvoice call(Throwable th) {
        return call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final SettingsPremiumViewModel$SubscriptionAndInvoice call2(Throwable th) {
        return new SettingsPremiumViewModel$SubscriptionAndInvoice(this.$state, SettingsPremiumViewModel$InvoicePreviewFetch$Error.INSTANCE);
    }
}
