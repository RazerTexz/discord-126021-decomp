package com.discord.widgets.settings.premium;

import com.discord.models.domain.ModelSubscription;
import com.discord.restapi.RestAPIParams$InvoicePreviewBody;
import com.discord.stores.StoreEntitlements;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StorePaymentSources;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Loaded;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import j0.l.a.d;
import j0.l.e.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsPremiumViewModel$Companion {
    private SettingsPremiumViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$getSubscriptionsAndInvoicePreview(SettingsPremiumViewModel$Companion settingsPremiumViewModel$Companion, RestAPI restAPI, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState, boolean z2) {
        return settingsPremiumViewModel$Companion.getSubscriptionsAndInvoicePreview(restAPI, storeSubscriptions$SubscriptionsState, z2);
    }

    public static final /* synthetic */ Observable access$observeStores(SettingsPremiumViewModel$Companion settingsPremiumViewModel$Companion, StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, StoreEntitlements storeEntitlements, StoreGuildBoost storeGuildBoost, StoreGooglePlaySkuDetails storeGooglePlaySkuDetails, StoreGooglePlayPurchases storeGooglePlayPurchases, StoreExperiments storeExperiments, RestAPI restAPI) {
        return settingsPremiumViewModel$Companion.observeStores(storePaymentSources, storeSubscriptions, storeEntitlements, storeGuildBoost, storeGooglePlaySkuDetails, storeGooglePlayPurchases, storeExperiments, restAPI);
    }

    private final Observable<SettingsPremiumViewModel$SubscriptionAndInvoice> getSubscriptionsAndInvoicePreview(RestAPI restAPI, StoreSubscriptions$SubscriptionsState state, boolean applyEntitlements) {
        String id2;
        if (!(state instanceof StoreSubscriptions$SubscriptionsState$Loaded)) {
            Observable observable = d.k;
            m.checkNotNullExpressionValue(observable, "Observable.never()");
            return observable;
        }
        ModelSubscription premiumSubscription = ((StoreSubscriptions$SubscriptionsState$Loaded) state).getPremiumSubscription();
        if (premiumSubscription == null || (id2 = premiumSubscription.getId()) == null) {
            k kVar = new k(new SettingsPremiumViewModel$SubscriptionAndInvoice(state, new SettingsPremiumViewModel$InvoicePreviewFetch$Invoice(null)));
            m.checkNotNullExpressionValue(kVar, "Observable.just(\n       …nvoice(null))\n          )");
            return kVar;
        }
        Observable<SettingsPremiumViewModel$SubscriptionAndInvoice> observableM = ObservableExtensionsKt.restSubscribeOn$default(restAPI.getInvoicePreview(new RestAPIParams$InvoicePreviewBody(id2, true, applyEntitlements && !premiumSubscription.isGoogleSubscription())), false, 1, null).G(new SettingsPremiumViewModel$Companion$getSubscriptionsAndInvoicePreview$1(state)).M(new SettingsPremiumViewModel$Companion$getSubscriptionsAndInvoicePreview$2(state));
        m.checkNotNullExpressionValue(observableM, "restAPI\n              .g…ch.Error)\n              }");
        return observableM;
    }

    private final Observable<SettingsPremiumViewModel$StoreState> observeStores(StorePaymentSources storePaymentsSources, StoreSubscriptions storeSubscriptions, StoreEntitlements storeEntitlements, StoreGuildBoost storeGuildBoost, StoreGooglePlaySkuDetails storeGooglePlaySkuDetails, StoreGooglePlayPurchases storeGooglePlayPurchases, StoreExperiments storeExperiments, RestAPI restAPI) {
        Observable<SettingsPremiumViewModel$StoreState> observableE = Observable.e(storePaymentsSources.observePaymentSourcesState(), storeSubscriptions.observeSubscriptions().Y(new SettingsPremiumViewModel$Companion$observeStores$1(restAPI)), storeSubscriptions.observeSubscriptions().Y(new SettingsPremiumViewModel$Companion$observeStores$2(restAPI)), storeEntitlements.observeEntitlementState(), StoreGuildBoost.observeGuildBoostState$default(storeGuildBoost, null, 1, null), storeGooglePlaySkuDetails.observeState(), storeGooglePlayPurchases.observeState(), SettingsPremiumViewModel$Companion$observeStores$3.INSTANCE);
        m.checkNotNullExpressionValue(observableE, "Observable\n          .co…            )\n          }");
        return observableE;
    }

    public /* synthetic */ SettingsPremiumViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
