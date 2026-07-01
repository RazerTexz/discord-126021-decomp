package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.outline;
import com.android.billingclient.api.Purchase;
import com.discord.restapi.RestAPIParams;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.BillingUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.p.Schedulers2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import retrofit2.HttpException;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGooglePlayPurchases extends StoreV2 {
    private static final long CACHED_ANALYTICS_TTL = 259200000;
    private static final String CACHE_KEY_PAYMENT_FLOW_ANALYTICS = "CACHE_KEY_PAYMENT_FLOW_ANALYTICS";
    private static final String VIEWED_GIFTING_WARNING_DIALOG = "VIEWED_GIFTING_WARNING_DIALOG";
    private final AnalyticsTracker analyticsTracker;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final PublishSubject<Event> eventSubject;
    private final Gson gson;
    private final ObservationDeck observationDeck;
    private QueryState queryState;
    private QueryState queryStateSnapshot;
    private final RestAPI restAPI;
    private State storeState;
    private State storeStateSnapshot;

    /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
    public static final /* data */ class AnalyticsTrait {
        private final Traits.Location locationTrait;
        private final Traits.Payment paymentTrait;
        private final long skuId;
        private final Traits.StoreSku storeSkuTrait;
        private final long timestamp;

        public AnalyticsTrait(long j, long j2, Traits.Location location, Traits.StoreSku storeSku, Traits.Payment payment) {
            Intrinsics3.checkNotNullParameter(location, "locationTrait");
            Intrinsics3.checkNotNullParameter(storeSku, "storeSkuTrait");
            Intrinsics3.checkNotNullParameter(payment, "paymentTrait");
            this.skuId = j;
            this.timestamp = j2;
            this.locationTrait = location;
            this.storeSkuTrait = storeSku;
            this.paymentTrait = payment;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getSkuId() {
            return this.skuId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Traits.Location getLocationTrait() {
            return this.locationTrait;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Traits.StoreSku getStoreSkuTrait() {
            return this.storeSkuTrait;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Traits.Payment getPaymentTrait() {
            return this.paymentTrait;
        }

        public final AnalyticsTrait copy(long skuId, long timestamp, Traits.Location locationTrait, Traits.StoreSku storeSkuTrait, Traits.Payment paymentTrait) {
            Intrinsics3.checkNotNullParameter(locationTrait, "locationTrait");
            Intrinsics3.checkNotNullParameter(storeSkuTrait, "storeSkuTrait");
            Intrinsics3.checkNotNullParameter(paymentTrait, "paymentTrait");
            return new AnalyticsTrait(skuId, timestamp, locationTrait, storeSkuTrait, paymentTrait);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnalyticsTrait)) {
                return false;
            }
            AnalyticsTrait analyticsTrait = (AnalyticsTrait) other;
            return this.skuId == analyticsTrait.skuId && this.timestamp == analyticsTrait.timestamp && Intrinsics3.areEqual(this.locationTrait, analyticsTrait.locationTrait) && Intrinsics3.areEqual(this.storeSkuTrait, analyticsTrait.storeSkuTrait) && Intrinsics3.areEqual(this.paymentTrait, analyticsTrait.paymentTrait);
        }

        public final Traits.Location getLocationTrait() {
            return this.locationTrait;
        }

        public final Traits.Payment getPaymentTrait() {
            return this.paymentTrait;
        }

        public final long getSkuId() {
            return this.skuId;
        }

        public final Traits.StoreSku getStoreSkuTrait() {
            return this.storeSkuTrait;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            int iA = (b.a(this.timestamp) + (b.a(this.skuId) * 31)) * 31;
            Traits.Location location = this.locationTrait;
            int iHashCode = (iA + (location != null ? location.hashCode() : 0)) * 31;
            Traits.StoreSku storeSku = this.storeSkuTrait;
            int iHashCode2 = (iHashCode + (storeSku != null ? storeSku.hashCode() : 0)) * 31;
            Traits.Payment payment = this.paymentTrait;
            return iHashCode2 + (payment != null ? payment.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("AnalyticsTrait(skuId=");
            sbU.append(this.skuId);
            sbU.append(", timestamp=");
            sbU.append(this.timestamp);
            sbU.append(", locationTrait=");
            sbU.append(this.locationTrait);
            sbU.append(", storeSkuTrait=");
            sbU.append(this.storeSkuTrait);
            sbU.append(", paymentTrait=");
            sbU.append(this.paymentTrait);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
        public static final /* data */ class PurchaseQueryFailure extends Event {
            private final String newSkuName;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PurchaseQueryFailure(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "newSkuName");
                this.newSkuName = str;
            }

            public static /* synthetic */ PurchaseQueryFailure copy$default(PurchaseQueryFailure purchaseQueryFailure, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = purchaseQueryFailure.newSkuName;
                }
                return purchaseQueryFailure.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getNewSkuName() {
                return this.newSkuName;
            }

            public final PurchaseQueryFailure copy(String newSkuName) {
                Intrinsics3.checkNotNullParameter(newSkuName, "newSkuName");
                return new PurchaseQueryFailure(newSkuName);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof PurchaseQueryFailure) && Intrinsics3.areEqual(this.newSkuName, ((PurchaseQueryFailure) other).newSkuName);
                }
                return true;
            }

            public final String getNewSkuName() {
                return this.newSkuName;
            }

            public int hashCode() {
                String str = this.newSkuName;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("PurchaseQueryFailure(newSkuName="), this.newSkuName, ")");
            }
        }

        /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
        public static final /* data */ class PurchaseQuerySuccess extends Event {
            private final String giftCode;
            private final String newSkuName;
            private final Long skuId;
            private final Long subscriptionPlanId;

            public /* synthetic */ PurchaseQuerySuccess(String str, Long l, Long l2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : str2);
            }

            public static /* synthetic */ PurchaseQuerySuccess copy$default(PurchaseQuerySuccess purchaseQuerySuccess, String str, Long l, Long l2, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = purchaseQuerySuccess.newSkuName;
                }
                if ((i & 2) != 0) {
                    l = purchaseQuerySuccess.skuId;
                }
                if ((i & 4) != 0) {
                    l2 = purchaseQuerySuccess.subscriptionPlanId;
                }
                if ((i & 8) != 0) {
                    str2 = purchaseQuerySuccess.giftCode;
                }
                return purchaseQuerySuccess.copy(str, l, l2, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getNewSkuName() {
                return this.newSkuName;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Long getSkuId() {
                return this.skuId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Long getSubscriptionPlanId() {
                return this.subscriptionPlanId;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getGiftCode() {
                return this.giftCode;
            }

            public final PurchaseQuerySuccess copy(String newSkuName, Long skuId, Long subscriptionPlanId, String giftCode) {
                Intrinsics3.checkNotNullParameter(newSkuName, "newSkuName");
                return new PurchaseQuerySuccess(newSkuName, skuId, subscriptionPlanId, giftCode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PurchaseQuerySuccess)) {
                    return false;
                }
                PurchaseQuerySuccess purchaseQuerySuccess = (PurchaseQuerySuccess) other;
                return Intrinsics3.areEqual(this.newSkuName, purchaseQuerySuccess.newSkuName) && Intrinsics3.areEqual(this.skuId, purchaseQuerySuccess.skuId) && Intrinsics3.areEqual(this.subscriptionPlanId, purchaseQuerySuccess.subscriptionPlanId) && Intrinsics3.areEqual(this.giftCode, purchaseQuerySuccess.giftCode);
            }

            public final String getGiftCode() {
                return this.giftCode;
            }

            public final String getNewSkuName() {
                return this.newSkuName;
            }

            public final Long getSkuId() {
                return this.skuId;
            }

            public final Long getSubscriptionPlanId() {
                return this.subscriptionPlanId;
            }

            public int hashCode() {
                String str = this.newSkuName;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                Long l = this.skuId;
                int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
                Long l2 = this.subscriptionPlanId;
                int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
                String str2 = this.giftCode;
                return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("PurchaseQuerySuccess(newSkuName=");
                sbU.append(this.newSkuName);
                sbU.append(", skuId=");
                sbU.append(this.skuId);
                sbU.append(", subscriptionPlanId=");
                sbU.append(this.subscriptionPlanId);
                sbU.append(", giftCode=");
                return outline.J(sbU, this.giftCode, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PurchaseQuerySuccess(String str, Long l, Long l2, String str2) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "newSkuName");
                this.newSkuName = str;
                this.skuId = l;
                this.subscriptionPlanId = l2;
                this.giftCode = str2;
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
    public static abstract class QueryState {

        /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
        public static final class InProgress extends QueryState {
            public static final InProgress INSTANCE = new InProgress();

            private InProgress() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
        public static final class NotInProgress extends QueryState {
            public static final NotInProgress INSTANCE = new NotInProgress();

            private NotInProgress() {
                super(null);
            }
        }

        private QueryState() {
        }

        public /* synthetic */ QueryState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
    public static abstract class State {

        /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
        public static final class Uninitialized extends State {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private State() {
        }

        /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
        public static final /* data */ class Loaded extends State {
            private final List<Purchase> iapPurchases;
            private final StoreGooglePlayPurchases2 pendingDowngrade;
            private final List<Purchase> subscriptionPurchases;

            public /* synthetic */ Loaded(List list, List list2, StoreGooglePlayPurchases2 storeGooglePlayPurchases2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? Collections2.emptyList() : list, (i & 2) != 0 ? Collections2.emptyList() : list2, storeGooglePlayPurchases2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, List list2, StoreGooglePlayPurchases2 storeGooglePlayPurchases2, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.subscriptionPurchases;
                }
                if ((i & 2) != 0) {
                    list2 = loaded.iapPurchases;
                }
                if ((i & 4) != 0) {
                    storeGooglePlayPurchases2 = loaded.pendingDowngrade;
                }
                return loaded.copy(list, list2, storeGooglePlayPurchases2);
            }

            public final List<Purchase> component1() {
                return this.subscriptionPurchases;
            }

            public final List<Purchase> component2() {
                return this.iapPurchases;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final StoreGooglePlayPurchases2 getPendingDowngrade() {
                return this.pendingDowngrade;
            }

            public final Loaded copy(List<? extends Purchase> subscriptionPurchases, List<? extends Purchase> iapPurchases, StoreGooglePlayPurchases2 pendingDowngrade) {
                Intrinsics3.checkNotNullParameter(subscriptionPurchases, "subscriptionPurchases");
                Intrinsics3.checkNotNullParameter(iapPurchases, "iapPurchases");
                return new Loaded(subscriptionPurchases, iapPurchases, pendingDowngrade);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.subscriptionPurchases, loaded.subscriptionPurchases) && Intrinsics3.areEqual(this.iapPurchases, loaded.iapPurchases) && Intrinsics3.areEqual(this.pendingDowngrade, loaded.pendingDowngrade);
            }

            public final List<Purchase> getIapPurchases() {
                return this.iapPurchases;
            }

            public final StoreGooglePlayPurchases2 getPendingDowngrade() {
                return this.pendingDowngrade;
            }

            public final List<Purchase> getPurchases() {
                return _Collections.plus((Collection) this.subscriptionPurchases, (Iterable) this.iapPurchases);
            }

            public final List<Purchase> getSubscriptionPurchases() {
                return this.subscriptionPurchases;
            }

            public int hashCode() {
                List<Purchase> list = this.subscriptionPurchases;
                int iHashCode = (list != null ? list.hashCode() : 0) * 31;
                List<Purchase> list2 = this.iapPurchases;
                int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
                StoreGooglePlayPurchases2 storeGooglePlayPurchases2 = this.pendingDowngrade;
                return iHashCode2 + (storeGooglePlayPurchases2 != null ? storeGooglePlayPurchases2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(subscriptionPurchases=");
                sbU.append(this.subscriptionPurchases);
                sbU.append(", iapPurchases=");
                sbU.append(this.iapPurchases);
                sbU.append(", pendingDowngrade=");
                sbU.append(this.pendingDowngrade);
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends Purchase> list, List<? extends Purchase> list2, StoreGooglePlayPurchases2 storeGooglePlayPurchases2) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "subscriptionPurchases");
                Intrinsics3.checkNotNullParameter(list2, "iapPurchases");
                this.subscriptionPurchases = list;
                this.iapPurchases = list2;
                this.pendingDowngrade = storeGooglePlayPurchases2;
            }
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
    public static final /* data */ class VerificationResult {
        private final RestAPIParams.VerifyPurchaseResponse apiResponse;
        private final Purchase purchase;

        public VerificationResult(Purchase purchase, RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse) {
            Intrinsics3.checkNotNullParameter(purchase, "purchase");
            this.purchase = purchase;
            this.apiResponse = verifyPurchaseResponse;
        }

        public static /* synthetic */ VerificationResult copy$default(VerificationResult verificationResult, Purchase purchase, RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse, int i, Object obj) {
            if ((i & 1) != 0) {
                purchase = verificationResult.purchase;
            }
            if ((i & 2) != 0) {
                verifyPurchaseResponse = verificationResult.apiResponse;
            }
            return verificationResult.copy(purchase, verifyPurchaseResponse);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Purchase getPurchase() {
            return this.purchase;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final RestAPIParams.VerifyPurchaseResponse getApiResponse() {
            return this.apiResponse;
        }

        public final VerificationResult copy(Purchase purchase, RestAPIParams.VerifyPurchaseResponse apiResponse) {
            Intrinsics3.checkNotNullParameter(purchase, "purchase");
            return new VerificationResult(purchase, apiResponse);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerificationResult)) {
                return false;
            }
            VerificationResult verificationResult = (VerificationResult) other;
            return Intrinsics3.areEqual(this.purchase, verificationResult.purchase) && Intrinsics3.areEqual(this.apiResponse, verificationResult.apiResponse);
        }

        public final RestAPIParams.VerifyPurchaseResponse getApiResponse() {
            return this.apiResponse;
        }

        public final Purchase getPurchase() {
            return this.purchase;
        }

        public int hashCode() {
            Purchase purchase = this.purchase;
            int iHashCode = (purchase != null ? purchase.hashCode() : 0) * 31;
            RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse = this.apiResponse;
            return iHashCode + (verifyPurchaseResponse != null ? verifyPurchaseResponse.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("VerificationResult(purchase=");
            sbU.append(this.purchase);
            sbU.append(", apiResponse=");
            sbU.append(this.apiResponse);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlayPurchases$doDowngrade$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Throwable, Boolean> {
        public AnonymousClass1(StoreGooglePlayPurchases storeGooglePlayPurchases) {
            super(1, storeGooglePlayPurchases, StoreGooglePlayPurchases.class, "shouldRetryDowngrade", "shouldRetryDowngrade(Ljava/lang/Throwable;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
            return Boolean.valueOf(invoke2(th));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Throwable th) {
            Intrinsics3.checkNotNullParameter(th, "p1");
            return ((StoreGooglePlayPurchases) this.receiver).shouldRetryDowngrade(th);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlayPurchases$doDowngrade$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Object, Unit> {
        public final /* synthetic */ String $newSkuName;

        /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlayPurchases$doDowngrade$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreGooglePlayPurchases.this.handleDowngradeSuccess(anonymousClass2.$newSkuName);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$newSkuName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            StoreGooglePlayPurchases.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlayPurchases$doDowngrade$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $newSkuName;

        /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlayPurchases$doDowngrade$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreGooglePlayPurchases.this.handleDowngradeFailure(anonymousClass3.$newSkuName);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str) {
            super(1);
            this.$newSkuName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreGooglePlayPurchases.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlayPurchases$downgradePurchase$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            State state = StoreGooglePlayPurchases.this.storeState;
            if (state instanceof State.Loaded) {
                State.Loaded loaded = (State.Loaded) state;
                if (loaded.getPendingDowngrade() != null) {
                    StoreGooglePlayPurchases.this.queryState = QueryState.InProgress.INSTANCE;
                    StoreGooglePlayPurchases.this.markChanged();
                    StoreGooglePlayPurchases.this.doDowngrade(loaded.getPendingDowngrade());
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlayPurchases$observeQueryState$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<QueryState> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final QueryState invoke() {
            return StoreGooglePlayPurchases.this.getQueryStateSnapshot();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlayPurchases$observeState$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<State> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreGooglePlayPurchases.this.getStoreStateSnapshot();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlayPurchases$onVerificationFailure$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ VerificationResult $verificationResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(VerificationResult verificationResult) {
            super(0);
            this.$verificationResult = verificationResult;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ArrayList<String> arrayListB = this.$verificationResult.getPurchase().b();
            Intrinsics3.checkNotNullExpressionValue(arrayListB, "verificationResult.purchase.skus");
            for (String str : arrayListB) {
                PublishSubject publishSubject = StoreGooglePlayPurchases.this.eventSubject;
                Intrinsics3.checkNotNullExpressionValue(str, "sku");
                publishSubject.k.onNext((T) new Event.PurchaseQueryFailure(str));
            }
            StoreGooglePlayPurchases.this.queryState = QueryState.NotInProgress.INSTANCE;
            StoreGooglePlayPurchases.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlayPurchases$onVerificationStart$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGooglePlayPurchases.this.queryState = QueryState.InProgress.INSTANCE;
            StoreGooglePlayPurchases.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlayPurchases$processPurchases$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $purchases;
        public final /* synthetic */ String $skuType;

        /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlayPurchases$processPurchases$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
        public static final class C01161 extends Lambda implements Function1<QueryState, Unit> {
            public C01161() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QueryState queryState) {
                invoke2(queryState);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QueryState queryState) {
                if (queryState instanceof QueryState.NotInProgress) {
                    BillingUtils.INSTANCE.verifyPurchases(AnonymousClass1.this.$purchases);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, String str) {
            super(0);
            this.$purchases = list;
            this.$skuType = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGooglePlayPurchases.this.handlePurchases(this.$purchases, this.$skuType);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreGooglePlayPurchases.this.observeQueryState(), 0L, false, 3, null), (Class<?>) StoreGooglePlayPurchases.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C01161());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlayPurchases$updatePendingDowngrade$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ StoreGooglePlayPurchases2 $newPendingDowngrade;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreGooglePlayPurchases2 storeGooglePlayPurchases2) {
            super(0);
            this.$newPendingDowngrade = storeGooglePlayPurchases2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGooglePlayPurchases storeGooglePlayPurchases = StoreGooglePlayPurchases.this;
            storeGooglePlayPurchases.storeState = new State.Loaded(storeGooglePlayPurchases.getSubscriptionPurchases(), StoreGooglePlayPurchases.this.getIapPurchases(), this.$newPendingDowngrade);
            StoreGooglePlayPurchases.this.markChanged();
        }
    }

    public StoreGooglePlayPurchases(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI, Clock clock, Gson gson, AnalyticsTracker analyticsTracker) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(gson, "gson");
        Intrinsics3.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.clock = clock;
        this.gson = gson;
        this.analyticsTracker = analyticsTracker;
        State.Uninitialized uninitialized = State.Uninitialized.INSTANCE;
        this.storeState = uninitialized;
        this.storeStateSnapshot = uninitialized;
        QueryState.NotInProgress notInProgress = QueryState.NotInProgress.INSTANCE;
        this.queryState = notInProgress;
        this.queryStateSnapshot = notInProgress;
        this.eventSubject = PublishSubject.k0();
    }

    private final void cacheAnalyticsTraits(Map<String, AnalyticsTrait> analyticsTraitsMap) {
        getPrefs().edit().putString(CACHE_KEY_PAYMENT_FLOW_ANALYTICS, this.gson.m(analyticsTraitsMap)).apply();
    }

    private final void clearAnalyticsTraits(String paymentGatewaySkuId) {
        Map<String, AnalyticsTrait> cachedAnalyticsTraitsMap = getCachedAnalyticsTraitsMap();
        cachedAnalyticsTraitsMap.remove(paymentGatewaySkuId);
        cacheAnalyticsTraits(cachedAnalyticsTraitsMap);
    }

    @Store3
    private final void doDowngrade(StoreGooglePlayPurchases2 downgrade) {
        String purchaseToken = downgrade.getPurchaseToken();
        String subscriptionId = downgrade.getSubscriptionId();
        String newSkuName = downgrade.getNewSkuName();
        RestAPIParams.DowngradeSubscriptionBody downgradeSubscriptionBody = new RestAPIParams.DowngradeSubscriptionBody(subscriptionId, purchaseToken, newSkuName);
        RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
        Observable<Object> observableX = this.restAPI.downgradeSubscription(downgradeSubscriptionBody).X(Schedulers2.c());
        Intrinsics3.checkNotNullExpressionValue(observableX, "restAPI\n        .downgra…scribeOn(Schedulers.io())");
        ObservableExtensionsKt.appSubscribe(RetryWithDelay.restRetry$default(retryWithDelay, observableX, 0L, null, null, new AnonymousClass1(this), 1, null), (Class<?>) StoreGooglePlayPurchases.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3(newSkuName)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(newSkuName));
    }

    private final Map<String, AnalyticsTrait> getCachedAnalyticsTraitsMap() {
        String string = getPrefs().getString(CACHE_KEY_PAYMENT_FLOW_ANALYTICS, null);
        if (string != null) {
            Map<String, AnalyticsTrait> map = (Map) this.gson.g(string, new TypeToken<Map<String, ? extends AnalyticsTrait>>() { // from class: com.discord.stores.StoreGooglePlayPurchases$getCachedAnalyticsTraitsMap$1$typeToken$1
            }.getType());
            if (map != null) {
                return map;
            }
        }
        return new LinkedHashMap();
    }

    private final List<Purchase> getIapPurchases() {
        State storeStateSnapshot = getStoreStateSnapshot();
        if (!(storeStateSnapshot instanceof State.Loaded)) {
            storeStateSnapshot = null;
        }
        State.Loaded loaded = (State.Loaded) storeStateSnapshot;
        List<Purchase> iapPurchases = loaded != null ? loaded.getIapPurchases() : null;
        return iapPurchases != null ? iapPurchases : Collections2.emptyList();
    }

    private final AnalyticsTrait getOrClearAnalyticsTraits(String paymentGatewaySkuId) {
        AnalyticsTrait analyticsTrait = getCachedAnalyticsTraitsMap().get(paymentGatewaySkuId);
        if (analyticsTrait == null) {
            return null;
        }
        if (!(this.clock.currentTimeMillis() - analyticsTrait.getTimestamp() > CACHED_ANALYTICS_TTL)) {
            return analyticsTrait;
        }
        clearAnalyticsTraits(paymentGatewaySkuId);
        return null;
    }

    private final StoreGooglePlayPurchases2 getPendingDowngrade() {
        State storeStateSnapshot = getStoreStateSnapshot();
        if (!(storeStateSnapshot instanceof State.Loaded)) {
            storeStateSnapshot = null;
        }
        State.Loaded loaded = (State.Loaded) storeStateSnapshot;
        if (loaded != null) {
            return loaded.getPendingDowngrade();
        }
        return null;
    }

    private final List<Purchase> getSubscriptionPurchases() {
        State storeStateSnapshot = getStoreStateSnapshot();
        if (!(storeStateSnapshot instanceof State.Loaded)) {
            storeStateSnapshot = null;
        }
        State.Loaded loaded = (State.Loaded) storeStateSnapshot;
        List<Purchase> subscriptionPurchases = loaded != null ? loaded.getSubscriptionPurchases() : null;
        return subscriptionPurchases != null ? subscriptionPurchases : Collections2.emptyList();
    }

    @Store3
    private final void handleDowngradeFailure(String newSkuName) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.PurchaseQueryFailure(newSkuName));
        updatePendingDowngrade(null);
        this.queryState = QueryState.NotInProgress.INSTANCE;
        markChanged();
    }

    @Store3
    private final void handleDowngradeSuccess(String newSkuName) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.PurchaseQuerySuccess(newSkuName, null, null, null, 14, null));
        updatePendingDowngrade(null);
        this.queryState = QueryState.NotInProgress.INSTANCE;
        markChanged();
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00b7  */
    @Store3
    private final void handlePurchases(List<? extends Purchase> newPurchases, String skuType) {
        State loaded;
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
                    newPurchases = Collections2.emptyList();
                }
                loaded = new State.Loaded(getSubscriptionPurchases(), newPurchases, getPendingDowngrade());
            } else {
                loaded = State.Uninitialized.INSTANCE;
            }
        } else if (skuType.equals("subs")) {
            if (newPurchases == null) {
                newPurchases = Collections2.emptyList();
            }
            loaded = new State.Loaded(newPurchases, getIapPurchases(), getPendingDowngrade());
        } else {
            loaded = State.Uninitialized.INSTANCE;
        }
        this.storeState = loaded;
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
        this.dispatcher.schedule(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: getQueryState, reason: from getter */
    public final QueryState getQueryStateSnapshot() {
        return this.queryStateSnapshot;
    }

    /* JADX INFO: renamed from: getState, reason: from getter */
    public final State getStoreStateSnapshot() {
        return this.storeStateSnapshot;
    }

    public final boolean hasSeenGiftingWarning() {
        return getPrefs().getBoolean(VIEWED_GIFTING_WARNING_DIALOG, false);
    }

    public final void markViewedGiftingWarning() {
        getPrefs().edit().putBoolean(VIEWED_GIFTING_WARNING_DIALOG, true).apply();
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final Observable<QueryState> observeQueryState() {
        Observable<QueryState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<State> observeState() {
        Observable<State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void onVerificationFailure(VerificationResult verificationResult) {
        Intrinsics3.checkNotNullParameter(verificationResult, "verificationResult");
        this.dispatcher.schedule(new AnonymousClass1(verificationResult));
    }

    public final void onVerificationStart() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void onVerificationSuccess(VerificationResult verificationResult) {
        Intrinsics3.checkNotNullParameter(verificationResult, "verificationResult");
        ArrayList<String> arrayListB = verificationResult.getPurchase().b();
        Intrinsics3.checkNotNullExpressionValue(arrayListB, "verificationResult.purchase.skus");
        Iterator<T> it = arrayListB.iterator();
        while (it.hasNext()) {
            this.dispatcher.schedule(new StoreGooglePlayPurchases4((String) it.next(), this, verificationResult));
        }
    }

    public final void processPurchases(List<? extends Purchase> purchases, String skuType) {
        Intrinsics3.checkNotNullParameter(skuType, "skuType");
        this.dispatcher.schedule(new AnonymousClass1(purchases, skuType));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        State stateCopy$default = this.storeState;
        if (stateCopy$default instanceof State.Loaded) {
            State.Loaded loaded = (State.Loaded) stateCopy$default;
            stateCopy$default = State.Loaded.copy$default(loaded, new ArrayList(loaded.getSubscriptionPurchases()), new ArrayList(loaded.getIapPurchases()), null, 4, null);
        } else if (!Intrinsics3.areEqual(stateCopy$default, State.Uninitialized.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.storeStateSnapshot = stateCopy$default;
        this.queryStateSnapshot = this.queryState;
    }

    public final void trackPaymentFlowCompleted(String paymentGatewaySkuId) {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        AnalyticsTrait orClearAnalyticsTraits = getOrClearAnalyticsTraits(paymentGatewaySkuId);
        if (orClearAnalyticsTraits != null) {
            this.analyticsTracker.paymentFlowCompleted(orClearAnalyticsTraits.getLocationTrait(), (18 & 2) != 0 ? null : null, (18 & 4) != 0 ? null : orClearAnalyticsTraits.getPaymentTrait(), (18 & 8) != 0 ? null : orClearAnalyticsTraits.getStoreSkuTrait(), (18 & 16) != 0 ? null : null);
            clearAnalyticsTraits(paymentGatewaySkuId);
        }
    }

    public final void trackPaymentFlowFailed(String paymentGatewaySkuId) {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        AnalyticsTrait orClearAnalyticsTraits = getOrClearAnalyticsTraits(paymentGatewaySkuId);
        if (orClearAnalyticsTraits != null) {
            AnalyticsTracker.paymentFlowFailed$default(this.analyticsTracker, orClearAnalyticsTraits.getLocationTrait(), null, orClearAnalyticsTraits.getStoreSkuTrait(), orClearAnalyticsTraits.getPaymentTrait(), 2, null);
            clearAnalyticsTraits(paymentGatewaySkuId);
        }
    }

    public final void trackPaymentFlowStarted(String paymentGatewaySkuId, long skuId, Traits.Location locationTrait, Traits.StoreSku storeSkuTrait, Traits.Payment paymentTrait) {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        Intrinsics3.checkNotNullParameter(locationTrait, "locationTrait");
        Intrinsics3.checkNotNullParameter(storeSkuTrait, "storeSkuTrait");
        Intrinsics3.checkNotNullParameter(paymentTrait, "paymentTrait");
        AnalyticsTrait analyticsTrait = new AnalyticsTrait(skuId, this.clock.currentTimeMillis(), locationTrait, storeSkuTrait, paymentTrait);
        Map<String, AnalyticsTrait> cachedAnalyticsTraitsMap = getCachedAnalyticsTraitsMap();
        cachedAnalyticsTraitsMap.put(paymentGatewaySkuId, analyticsTrait);
        cacheAnalyticsTraits(cachedAnalyticsTraitsMap);
        AnalyticsTracker.paymentFlowStarted$default(this.analyticsTracker, analyticsTrait.getLocationTrait(), null, analyticsTrait.getStoreSkuTrait(), analyticsTrait.getPaymentTrait(), 2, null);
    }

    public final void trackPaymentFlowStep(String paymentGatewaySkuId, String fromStep, String toStep) {
        outline.q0(paymentGatewaySkuId, "paymentGatewaySkuId", fromStep, "fromStep", toStep, "toStep");
        AnalyticsTrait orClearAnalyticsTraits = getOrClearAnalyticsTraits(paymentGatewaySkuId);
        if (orClearAnalyticsTraits != null) {
            this.analyticsTracker.paymentFlowStep(orClearAnalyticsTraits.getLocationTrait(), (48 & 2) != 0 ? null : null, toStep, fromStep, (48 & 16) != 0 ? null : orClearAnalyticsTraits.getStoreSkuTrait(), (48 & 32) != 0 ? null : orClearAnalyticsTraits.getPaymentTrait());
        }
    }

    public final void updatePendingDowngrade(StoreGooglePlayPurchases2 newPendingDowngrade) {
        this.dispatcher.schedule(new AnonymousClass1(newPendingDowngrade));
    }
}
