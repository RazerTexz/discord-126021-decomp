package com.discord.stores;

import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.discord.restapi.RestAPIParams$DowngradeSubscriptionBody;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Payment;
import com.discord.utilities.analytics.Traits$StoreSku;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.google.gson.Gson;
import d0.t.n;
import d0.z.d.m;
import j0.p.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import retrofit2.HttpException;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGooglePlayPurchases extends StoreV2 {
    private static final long CACHED_ANALYTICS_TTL = 259200000;
    private static final String CACHE_KEY_PAYMENT_FLOW_ANALYTICS = "CACHE_KEY_PAYMENT_FLOW_ANALYTICS";
    public static final StoreGooglePlayPurchases$Companion Companion = new StoreGooglePlayPurchases$Companion(null);
    private static final String VIEWED_GIFTING_WARNING_DIALOG = "VIEWED_GIFTING_WARNING_DIALOG";
    private final AnalyticsTracker analyticsTracker;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final PublishSubject<StoreGooglePlayPurchases$Event> eventSubject;
    private final Gson gson;
    private final ObservationDeck observationDeck;
    private StoreGooglePlayPurchases$QueryState queryState;
    private StoreGooglePlayPurchases$QueryState queryStateSnapshot;
    private final RestAPI restAPI;
    private StoreGooglePlayPurchases$State storeState;
    private StoreGooglePlayPurchases$State storeStateSnapshot;

    public StoreGooglePlayPurchases(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI, Clock clock, Gson gson, AnalyticsTracker analyticsTracker) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(gson, "gson");
        m.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.clock = clock;
        this.gson = gson;
        this.analyticsTracker = analyticsTracker;
        StoreGooglePlayPurchases$State$Uninitialized storeGooglePlayPurchases$State$Uninitialized = StoreGooglePlayPurchases$State$Uninitialized.INSTANCE;
        this.storeState = storeGooglePlayPurchases$State$Uninitialized;
        this.storeStateSnapshot = storeGooglePlayPurchases$State$Uninitialized;
        StoreGooglePlayPurchases$QueryState$NotInProgress storeGooglePlayPurchases$QueryState$NotInProgress = StoreGooglePlayPurchases$QueryState$NotInProgress.INSTANCE;
        this.queryState = storeGooglePlayPurchases$QueryState$NotInProgress;
        this.queryStateSnapshot = storeGooglePlayPurchases$QueryState$NotInProgress;
        this.eventSubject = PublishSubject.k0();
    }

    public static final /* synthetic */ void access$doDowngrade(StoreGooglePlayPurchases storeGooglePlayPurchases, PendingDowngrade pendingDowngrade) {
        storeGooglePlayPurchases.doDowngrade(pendingDowngrade);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.dispatcher;
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.eventSubject;
    }

    public static final /* synthetic */ List access$getIapPurchases$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.getIapPurchases();
    }

    public static final /* synthetic */ StoreGooglePlayPurchases$QueryState access$getQueryState$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.queryState;
    }

    public static final /* synthetic */ StoreGooglePlayPurchases$State access$getStoreState$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.storeState;
    }

    public static final /* synthetic */ List access$getSubscriptionPurchases$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.getSubscriptionPurchases();
    }

    public static final /* synthetic */ void access$handleDowngradeFailure(StoreGooglePlayPurchases storeGooglePlayPurchases, String str) {
        storeGooglePlayPurchases.handleDowngradeFailure(str);
    }

    public static final /* synthetic */ void access$handleDowngradeSuccess(StoreGooglePlayPurchases storeGooglePlayPurchases, String str) {
        storeGooglePlayPurchases.handleDowngradeSuccess(str);
    }

    public static final /* synthetic */ void access$handlePurchases(StoreGooglePlayPurchases storeGooglePlayPurchases, List list, String str) {
        storeGooglePlayPurchases.handlePurchases(list, str);
    }

    public static final /* synthetic */ void access$setQueryState$p(StoreGooglePlayPurchases storeGooglePlayPurchases, StoreGooglePlayPurchases$QueryState storeGooglePlayPurchases$QueryState) {
        storeGooglePlayPurchases.queryState = storeGooglePlayPurchases$QueryState;
    }

    public static final /* synthetic */ void access$setStoreState$p(StoreGooglePlayPurchases storeGooglePlayPurchases, StoreGooglePlayPurchases$State storeGooglePlayPurchases$State) {
        storeGooglePlayPurchases.storeState = storeGooglePlayPurchases$State;
    }

    public static final /* synthetic */ boolean access$shouldRetryDowngrade(StoreGooglePlayPurchases storeGooglePlayPurchases, Throwable th) {
        return storeGooglePlayPurchases.shouldRetryDowngrade(th);
    }

    private final void cacheAnalyticsTraits(Map<String, StoreGooglePlayPurchases$AnalyticsTrait> analyticsTraitsMap) {
        getPrefs().edit().putString(CACHE_KEY_PAYMENT_FLOW_ANALYTICS, this.gson.m(analyticsTraitsMap)).apply();
    }

    private final void clearAnalyticsTraits(String paymentGatewaySkuId) {
        Map<String, StoreGooglePlayPurchases$AnalyticsTrait> cachedAnalyticsTraitsMap = getCachedAnalyticsTraitsMap();
        cachedAnalyticsTraitsMap.remove(paymentGatewaySkuId);
        cacheAnalyticsTraits(cachedAnalyticsTraitsMap);
    }

    @StoreThread
    private final void doDowngrade(PendingDowngrade downgrade) {
        String purchaseToken = downgrade.getPurchaseToken();
        String subscriptionId = downgrade.getSubscriptionId();
        String newSkuName = downgrade.getNewSkuName();
        RestAPIParams$DowngradeSubscriptionBody restAPIParams$DowngradeSubscriptionBody = new RestAPIParams$DowngradeSubscriptionBody(subscriptionId, purchaseToken, newSkuName);
        RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
        Observable<Object> observableX = this.restAPI.downgradeSubscription(restAPIParams$DowngradeSubscriptionBody).X(a.c());
        m.checkNotNullExpressionValue(observableX, "restAPI\n        .downgra…scribeOn(Schedulers.io())");
        ObservableExtensionsKt.appSubscribe$default(RetryWithDelay.restRetry$default(retryWithDelay, observableX, 0L, null, null, new StoreGooglePlayPurchases$doDowngrade$1(this), 1, null), StoreGooglePlayPurchases.class, (Context) null, (Function1) null, new StoreGooglePlayPurchases$doDowngrade$3(this, newSkuName), (Function0) null, (Function0) null, new StoreGooglePlayPurchases$doDowngrade$2(this, newSkuName), 54, (Object) null);
    }

    private final Map<String, StoreGooglePlayPurchases$AnalyticsTrait> getCachedAnalyticsTraitsMap() {
        String string = getPrefs().getString(CACHE_KEY_PAYMENT_FLOW_ANALYTICS, null);
        if (string != null) {
            Map<String, StoreGooglePlayPurchases$AnalyticsTrait> map = (Map) this.gson.g(string, new StoreGooglePlayPurchases$getCachedAnalyticsTraitsMap$1$typeToken$1().getType());
            if (map != null) {
                return map;
            }
        }
        return new LinkedHashMap();
    }

    private final List<Purchase> getIapPurchases() {
        StoreGooglePlayPurchases$State storeStateSnapshot = getStoreStateSnapshot();
        if (!(storeStateSnapshot instanceof StoreGooglePlayPurchases$State$Loaded)) {
            storeStateSnapshot = null;
        }
        StoreGooglePlayPurchases$State$Loaded storeGooglePlayPurchases$State$Loaded = (StoreGooglePlayPurchases$State$Loaded) storeStateSnapshot;
        List<Purchase> iapPurchases = storeGooglePlayPurchases$State$Loaded != null ? storeGooglePlayPurchases$State$Loaded.getIapPurchases() : null;
        return iapPurchases != null ? iapPurchases : n.emptyList();
    }

    private final StoreGooglePlayPurchases$AnalyticsTrait getOrClearAnalyticsTraits(String paymentGatewaySkuId) {
        StoreGooglePlayPurchases$AnalyticsTrait storeGooglePlayPurchases$AnalyticsTrait = getCachedAnalyticsTraitsMap().get(paymentGatewaySkuId);
        if (storeGooglePlayPurchases$AnalyticsTrait == null) {
            return null;
        }
        if (!(this.clock.currentTimeMillis() - storeGooglePlayPurchases$AnalyticsTrait.getTimestamp() > CACHED_ANALYTICS_TTL)) {
            return storeGooglePlayPurchases$AnalyticsTrait;
        }
        clearAnalyticsTraits(paymentGatewaySkuId);
        return null;
    }

    private final PendingDowngrade getPendingDowngrade() {
        StoreGooglePlayPurchases$State storeStateSnapshot = getStoreStateSnapshot();
        if (!(storeStateSnapshot instanceof StoreGooglePlayPurchases$State$Loaded)) {
            storeStateSnapshot = null;
        }
        StoreGooglePlayPurchases$State$Loaded storeGooglePlayPurchases$State$Loaded = (StoreGooglePlayPurchases$State$Loaded) storeStateSnapshot;
        if (storeGooglePlayPurchases$State$Loaded != null) {
            return storeGooglePlayPurchases$State$Loaded.getPendingDowngrade();
        }
        return null;
    }

    private final List<Purchase> getSubscriptionPurchases() {
        StoreGooglePlayPurchases$State storeStateSnapshot = getStoreStateSnapshot();
        if (!(storeStateSnapshot instanceof StoreGooglePlayPurchases$State$Loaded)) {
            storeStateSnapshot = null;
        }
        StoreGooglePlayPurchases$State$Loaded storeGooglePlayPurchases$State$Loaded = (StoreGooglePlayPurchases$State$Loaded) storeStateSnapshot;
        List<Purchase> subscriptionPurchases = storeGooglePlayPurchases$State$Loaded != null ? storeGooglePlayPurchases$State$Loaded.getSubscriptionPurchases() : null;
        return subscriptionPurchases != null ? subscriptionPurchases : n.emptyList();
    }

    @StoreThread
    private final void handleDowngradeFailure(String newSkuName) {
        PublishSubject<StoreGooglePlayPurchases$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new StoreGooglePlayPurchases$Event$PurchaseQueryFailure(newSkuName));
        updatePendingDowngrade(null);
        this.queryState = StoreGooglePlayPurchases$QueryState$NotInProgress.INSTANCE;
        markChanged();
    }

    @StoreThread
    private final void handleDowngradeSuccess(String newSkuName) {
        PublishSubject<StoreGooglePlayPurchases$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new StoreGooglePlayPurchases$Event$PurchaseQuerySuccess(newSkuName, null, null, null, 14, null));
        updatePendingDowngrade(null);
        this.queryState = StoreGooglePlayPurchases$QueryState$NotInProgress.INSTANCE;
        markChanged();
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00b7  */
    @StoreThread
    private final void handlePurchases(List<? extends Purchase> newPurchases, String skuType) {
        StoreGooglePlayPurchases$State storeGooglePlayPurchases$State$Loaded;
        int iHashCode = skuType.hashCode();
        boolean z2 = false;
        if (iHashCode == 3541555 ? !(!skuType.equals("subs") || newPurchases == null || newPurchases.size() != getSubscriptionPurchases().size() || !newPurchases.containsAll(getSubscriptionPurchases()) || !getSubscriptionPurchases().containsAll(newPurchases)) : !(iHashCode != 100343516 || !skuType.equals("inapp") || newPurchases == null || newPurchases.size() != getIapPurchases().size() || !newPurchases.containsAll(getIapPurchases()) || !getIapPurchases().containsAll(newPurchases))) {
            z2 = true;
        }
        if (newPurchases != null && (!newPurchases.isEmpty()) && z2) {
            return;
        }
        int iHashCode2 = skuType.hashCode();
        if (iHashCode2 != 3541555) {
            if (iHashCode2 == 100343516 && skuType.equals("inapp")) {
                if (newPurchases == null) {
                    newPurchases = n.emptyList();
                }
                storeGooglePlayPurchases$State$Loaded = new StoreGooglePlayPurchases$State$Loaded(getSubscriptionPurchases(), newPurchases, getPendingDowngrade());
            } else {
                storeGooglePlayPurchases$State$Loaded = StoreGooglePlayPurchases$State$Uninitialized.INSTANCE;
            }
        } else if (skuType.equals("subs")) {
            if (newPurchases == null) {
                newPurchases = n.emptyList();
            }
            storeGooglePlayPurchases$State$Loaded = new StoreGooglePlayPurchases$State$Loaded(newPurchases, getIapPurchases(), getPendingDowngrade());
        } else {
            storeGooglePlayPurchases$State$Loaded = StoreGooglePlayPurchases$State$Uninitialized.INSTANCE;
        }
        this.storeState = storeGooglePlayPurchases$State$Loaded;
        markChanged();
    }

    private final boolean shouldRetryDowngrade(Throwable throwable) {
        if (throwable instanceof TimeoutException) {
            return false;
        }
        if (!(throwable instanceof HttpException)) {
            return throwable instanceof IOException;
        }
        int iA = ((HttpException) throwable).a();
        return 500 <= iA && 599 >= iA;
    }

    public final void downgradePurchase() {
        this.dispatcher.schedule(new StoreGooglePlayPurchases$downgradePurchase$1(this));
    }

    /* JADX INFO: renamed from: getQueryState, reason: from getter */
    public final StoreGooglePlayPurchases$QueryState getQueryStateSnapshot() {
        return this.queryStateSnapshot;
    }

    /* JADX INFO: renamed from: getState, reason: from getter */
    public final StoreGooglePlayPurchases$State getStoreStateSnapshot() {
        return this.storeStateSnapshot;
    }

    public final boolean hasSeenGiftingWarning() {
        return getPrefs().getBoolean(VIEWED_GIFTING_WARNING_DIALOG, false);
    }

    public final void markViewedGiftingWarning() {
        getPrefs().edit().putBoolean(VIEWED_GIFTING_WARNING_DIALOG, true).apply();
    }

    public final Observable<StoreGooglePlayPurchases$Event> observeEvents() {
        PublishSubject<StoreGooglePlayPurchases$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final Observable<StoreGooglePlayPurchases$QueryState> observeQueryState() {
        Observable<StoreGooglePlayPurchases$QueryState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGooglePlayPurchases$observeQueryState$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<StoreGooglePlayPurchases$State> observeState() {
        Observable<StoreGooglePlayPurchases$State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGooglePlayPurchases$observeState$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void onVerificationFailure(StoreGooglePlayPurchases$VerificationResult verificationResult) {
        m.checkNotNullParameter(verificationResult, "verificationResult");
        this.dispatcher.schedule(new StoreGooglePlayPurchases$onVerificationFailure$1(this, verificationResult));
    }

    public final void onVerificationStart() {
        this.dispatcher.schedule(new StoreGooglePlayPurchases$onVerificationStart$1(this));
    }

    public final void onVerificationSuccess(StoreGooglePlayPurchases$VerificationResult verificationResult) {
        m.checkNotNullParameter(verificationResult, "verificationResult");
        ArrayList<String> arrayListB = verificationResult.getPurchase().b();
        m.checkNotNullExpressionValue(arrayListB, "verificationResult.purchase.skus");
        Iterator<T> it = arrayListB.iterator();
        while (it.hasNext()) {
            this.dispatcher.schedule(new StoreGooglePlayPurchases$onVerificationSuccess$$inlined$forEach$lambda$1((String) it.next(), this, verificationResult));
        }
    }

    public final void processPurchases(List<? extends Purchase> purchases, String skuType) {
        m.checkNotNullParameter(skuType, "skuType");
        this.dispatcher.schedule(new StoreGooglePlayPurchases$processPurchases$1(this, purchases, skuType));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        StoreGooglePlayPurchases$State storeGooglePlayPurchases$StateCopy$default = this.storeState;
        if (storeGooglePlayPurchases$StateCopy$default instanceof StoreGooglePlayPurchases$State$Loaded) {
            StoreGooglePlayPurchases$State$Loaded storeGooglePlayPurchases$State$Loaded = (StoreGooglePlayPurchases$State$Loaded) storeGooglePlayPurchases$StateCopy$default;
            storeGooglePlayPurchases$StateCopy$default = StoreGooglePlayPurchases$State$Loaded.copy$default(storeGooglePlayPurchases$State$Loaded, new ArrayList(storeGooglePlayPurchases$State$Loaded.getSubscriptionPurchases()), new ArrayList(storeGooglePlayPurchases$State$Loaded.getIapPurchases()), null, 4, null);
        } else if (!m.areEqual(storeGooglePlayPurchases$StateCopy$default, StoreGooglePlayPurchases$State$Uninitialized.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.storeStateSnapshot = storeGooglePlayPurchases$StateCopy$default;
        this.queryStateSnapshot = this.queryState;
    }

    public final void trackPaymentFlowCompleted(String paymentGatewaySkuId) {
        m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        StoreGooglePlayPurchases$AnalyticsTrait orClearAnalyticsTraits = getOrClearAnalyticsTraits(paymentGatewaySkuId);
        if (orClearAnalyticsTraits != null) {
            AnalyticsTracker.paymentFlowCompleted$default(this.analyticsTracker, orClearAnalyticsTraits.getLocationTrait(), null, orClearAnalyticsTraits.getPaymentTrait(), orClearAnalyticsTraits.getStoreSkuTrait(), null, 18, null);
            clearAnalyticsTraits(paymentGatewaySkuId);
        }
    }

    public final void trackPaymentFlowFailed(String paymentGatewaySkuId) {
        m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        StoreGooglePlayPurchases$AnalyticsTrait orClearAnalyticsTraits = getOrClearAnalyticsTraits(paymentGatewaySkuId);
        if (orClearAnalyticsTraits != null) {
            AnalyticsTracker.paymentFlowFailed$default(this.analyticsTracker, orClearAnalyticsTraits.getLocationTrait(), null, orClearAnalyticsTraits.getStoreSkuTrait(), orClearAnalyticsTraits.getPaymentTrait(), 2, null);
            clearAnalyticsTraits(paymentGatewaySkuId);
        }
    }

    public final void trackPaymentFlowStarted(String paymentGatewaySkuId, long skuId, Traits$Location locationTrait, Traits$StoreSku storeSkuTrait, Traits$Payment paymentTrait) {
        m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        m.checkNotNullParameter(locationTrait, "locationTrait");
        m.checkNotNullParameter(storeSkuTrait, "storeSkuTrait");
        m.checkNotNullParameter(paymentTrait, "paymentTrait");
        StoreGooglePlayPurchases$AnalyticsTrait storeGooglePlayPurchases$AnalyticsTrait = new StoreGooglePlayPurchases$AnalyticsTrait(skuId, this.clock.currentTimeMillis(), locationTrait, storeSkuTrait, paymentTrait);
        Map<String, StoreGooglePlayPurchases$AnalyticsTrait> cachedAnalyticsTraitsMap = getCachedAnalyticsTraitsMap();
        cachedAnalyticsTraitsMap.put(paymentGatewaySkuId, storeGooglePlayPurchases$AnalyticsTrait);
        cacheAnalyticsTraits(cachedAnalyticsTraitsMap);
        AnalyticsTracker.paymentFlowStarted$default(this.analyticsTracker, storeGooglePlayPurchases$AnalyticsTrait.getLocationTrait(), null, storeGooglePlayPurchases$AnalyticsTrait.getStoreSkuTrait(), storeGooglePlayPurchases$AnalyticsTrait.getPaymentTrait(), 2, null);
    }

    public final void trackPaymentFlowStep(String paymentGatewaySkuId, String fromStep, String toStep) {
        b.d.b.a.a.q0(paymentGatewaySkuId, "paymentGatewaySkuId", fromStep, "fromStep", toStep, "toStep");
        StoreGooglePlayPurchases$AnalyticsTrait orClearAnalyticsTraits = getOrClearAnalyticsTraits(paymentGatewaySkuId);
        if (orClearAnalyticsTraits != null) {
            AnalyticsTracker.paymentFlowStep$default(this.analyticsTracker, orClearAnalyticsTraits.getLocationTrait(), null, toStep, fromStep, orClearAnalyticsTraits.getStoreSkuTrait(), orClearAnalyticsTraits.getPaymentTrait(), 2, null);
        }
    }

    public final void updatePendingDowngrade(PendingDowngrade newPendingDowngrade) {
        this.dispatcher.schedule(new StoreGooglePlayPurchases$updatePendingDowngrade$1(this, newPendingDowngrade));
    }
}
