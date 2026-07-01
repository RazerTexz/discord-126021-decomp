package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsPremiumViewModel$Companion$observeStores$1<T, R> implements b<StoreSubscriptions$SubscriptionsState, Observable<? extends SettingsPremiumViewModel$SubscriptionAndInvoice>> {
    public final /* synthetic */ RestAPI $restAPI;

    public SettingsPremiumViewModel$Companion$observeStores$1(RestAPI restAPI) {
        this.$restAPI = restAPI;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends SettingsPremiumViewModel$SubscriptionAndInvoice> call(StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState) {
        return call2(storeSubscriptions$SubscriptionsState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends SettingsPremiumViewModel$SubscriptionAndInvoice> call2(StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState) {
        SettingsPremiumViewModel$Companion settingsPremiumViewModel$Companion = SettingsPremiumViewModel.Companion;
        RestAPI restAPI = this.$restAPI;
        m.checkNotNullExpressionValue(storeSubscriptions$SubscriptionsState, "state");
        return SettingsPremiumViewModel$Companion.access$getSubscriptionsAndInvoicePreview(settingsPremiumViewModel$Companion, restAPI, storeSubscriptions$SubscriptionsState, true);
    }
}
