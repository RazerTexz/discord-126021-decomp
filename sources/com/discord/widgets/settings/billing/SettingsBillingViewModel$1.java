package com.discord.widgets.settings.billing;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StorePaymentSources$PaymentSourcesState;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: SettingsBillingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsBillingViewModel$1<T1, T2, R> implements Func2<StorePaymentSources$PaymentSourcesState, StoreSubscriptions$SubscriptionsState, SettingsBillingViewModel$StoreState> {
    public static final SettingsBillingViewModel$1 INSTANCE = new SettingsBillingViewModel$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ SettingsBillingViewModel$StoreState call(StorePaymentSources$PaymentSourcesState storePaymentSources$PaymentSourcesState, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState) {
        return call2(storePaymentSources$PaymentSourcesState, storeSubscriptions$SubscriptionsState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final SettingsBillingViewModel$StoreState call2(StorePaymentSources$PaymentSourcesState storePaymentSources$PaymentSourcesState, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState) {
        m.checkNotNullExpressionValue(storePaymentSources$PaymentSourcesState, "paymentSourcesState");
        m.checkNotNullExpressionValue(storeSubscriptions$SubscriptionsState, "subscriptionsState");
        return new SettingsBillingViewModel$StoreState(storePaymentSources$PaymentSourcesState, storeSubscriptions$SubscriptionsState);
    }
}
