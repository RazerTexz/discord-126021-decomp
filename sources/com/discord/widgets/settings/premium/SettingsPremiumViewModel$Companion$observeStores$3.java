package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreEntitlements$State;
import com.discord.stores.StoreGooglePlayPurchases$State;
import com.discord.stores.StoreGooglePlaySkuDetails$State;
import com.discord.stores.StoreGuildBoost$State;
import com.discord.stores.StorePaymentSources$PaymentSourcesState;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import d0.z.d.m;
import rx.functions.Func7;

/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsPremiumViewModel$Companion$observeStores$3<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<StorePaymentSources$PaymentSourcesState, SettingsPremiumViewModel$SubscriptionAndInvoice, SettingsPremiumViewModel$SubscriptionAndInvoice, StoreEntitlements$State, StoreGuildBoost$State, StoreGooglePlaySkuDetails$State, StoreGooglePlayPurchases$State, SettingsPremiumViewModel$StoreState> {
    public static final SettingsPremiumViewModel$Companion$observeStores$3 INSTANCE = new SettingsPremiumViewModel$Companion$observeStores$3();

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ SettingsPremiumViewModel$StoreState call(StorePaymentSources$PaymentSourcesState storePaymentSources$PaymentSourcesState, SettingsPremiumViewModel$SubscriptionAndInvoice settingsPremiumViewModel$SubscriptionAndInvoice, SettingsPremiumViewModel$SubscriptionAndInvoice settingsPremiumViewModel$SubscriptionAndInvoice2, StoreEntitlements$State storeEntitlements$State, StoreGuildBoost$State storeGuildBoost$State, StoreGooglePlaySkuDetails$State storeGooglePlaySkuDetails$State, StoreGooglePlayPurchases$State storeGooglePlayPurchases$State) {
        return call2(storePaymentSources$PaymentSourcesState, settingsPremiumViewModel$SubscriptionAndInvoice, settingsPremiumViewModel$SubscriptionAndInvoice2, storeEntitlements$State, storeGuildBoost$State, storeGooglePlaySkuDetails$State, storeGooglePlayPurchases$State);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final SettingsPremiumViewModel$StoreState call2(StorePaymentSources$PaymentSourcesState storePaymentSources$PaymentSourcesState, SettingsPremiumViewModel$SubscriptionAndInvoice settingsPremiumViewModel$SubscriptionAndInvoice, SettingsPremiumViewModel$SubscriptionAndInvoice settingsPremiumViewModel$SubscriptionAndInvoice2, StoreEntitlements$State storeEntitlements$State, StoreGuildBoost$State storeGuildBoost$State, StoreGooglePlaySkuDetails$State storeGooglePlaySkuDetails$State, StoreGooglePlayPurchases$State storeGooglePlayPurchases$State) {
        m.checkNotNullExpressionValue(storePaymentSources$PaymentSourcesState, "paymentSourcesState");
        StoreSubscriptions$SubscriptionsState subscriptionsState = settingsPremiumViewModel$SubscriptionAndInvoice.getSubscriptionsState();
        m.checkNotNullExpressionValue(storeEntitlements$State, "entitlementsState");
        m.checkNotNullExpressionValue(storeGuildBoost$State, "guildSubscriptionState");
        SettingsPremiumViewModel$InvoicePreviewFetch invoicePreviewFetch = settingsPremiumViewModel$SubscriptionAndInvoice.getInvoicePreviewFetch();
        SettingsPremiumViewModel$InvoicePreviewFetch invoicePreviewFetch2 = settingsPremiumViewModel$SubscriptionAndInvoice2.getInvoicePreviewFetch();
        m.checkNotNullExpressionValue(storeGooglePlaySkuDetails$State, "skuDetailsState");
        m.checkNotNullExpressionValue(storeGooglePlayPurchases$State, "purchaseState");
        return new SettingsPremiumViewModel$StoreState(storePaymentSources$PaymentSourcesState, subscriptionsState, storeEntitlements$State, storeGuildBoost$State, invoicePreviewFetch, invoicePreviewFetch2, storeGooglePlaySkuDetails$State, storeGooglePlayPurchases$State);
    }
}
