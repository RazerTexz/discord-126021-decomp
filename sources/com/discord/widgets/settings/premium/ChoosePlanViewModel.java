package com.discord.widgets.settings.premium;

import android.text.TextUtils;
import androidx.annotation.StringRes;
import b.a.d.AppViewModel;
import b.d.a.a.c;
import b.d.b.a.outline;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.R;
import com.discord.api.premium.SubscriptionInterval;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGooglePlayPurchases2;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.billing.GooglePlaySku2;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.settings.premium.WidgetChoosePlan;
import com.discord.widgets.settings.premium.WidgetChoosePlanAdapter;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func4;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ChoosePlanViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChoosePlanViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private Traits.Location locationTrait;
    private final String oldSkuName;
    private final WidgetChoosePlan.ViewType viewType;

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.ChoosePlanViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChoosePlanViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(ChoosePlanViewModel choosePlanViewModel) {
            super(1, choosePlanViewModel, ChoosePlanViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/settings/premium/ChoosePlanViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ((ChoosePlanViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.ChoosePlanViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: ChoosePlanViewModel.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<StoreGooglePlayPurchases.Event, Unit> {
        public AnonymousClass2(ChoosePlanViewModel choosePlanViewModel) {
            super(1, choosePlanViewModel, ChoosePlanViewModel.class, "handleEvent", "handleEvent(Lcom/discord/stores/StoreGooglePlayPurchases$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreGooglePlayPurchases.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreGooglePlayPurchases.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((ChoosePlanViewModel) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: compiled from: ChoosePlanViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreGooglePlaySkuDetails.State> observableObserveState = companion.getGooglePlaySkuDetails().observeState();
            Observable<StoreGooglePlayPurchases.State> observableObserveState2 = companion.getGooglePlayPurchases().observeState();
            Observable<StoreGooglePlayPurchases.QueryState> observableObserveQueryState = companion.getGooglePlayPurchases().observeQueryState();
            Observable<StoreSubscriptions.SubscriptionsState> observableObserveSubscriptions = companion.getSubscriptions().observeSubscriptions();
            final ChoosePlanViewModel2 choosePlanViewModel2 = ChoosePlanViewModel2.INSTANCE;
            Object obj = choosePlanViewModel2;
            if (choosePlanViewModel2 != null) {
                obj = new Func4() { // from class: com.discord.widgets.settings.premium.ChoosePlanViewModel$sam$rx_functions_Func4$0
                    @Override // rx.functions.Func4
                    public final /* synthetic */ Object call(Object obj2, Object obj3, Object obj4, Object obj5) {
                        return choosePlanViewModel2.invoke(obj2, obj3, obj4, obj5);
                    }
                };
            }
            Observable<StoreState> observableH = Observable.h(observableObserveState, observableObserveState2, observableObserveQueryState, observableObserveSubscriptions, (Func4) obj);
            Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…     ::StoreState\n      )");
            return observableH;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ChoosePlanViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: ChoosePlanViewModel.kt */
        public static final /* data */ class CompleteSkuPurchase extends Event {
            private final String planName;
            private final String skuName;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CompleteSkuPurchase(String str, String str2) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "skuName");
                Intrinsics3.checkNotNullParameter(str2, "planName");
                this.skuName = str;
                this.planName = str2;
            }

            public static /* synthetic */ CompleteSkuPurchase copy$default(CompleteSkuPurchase completeSkuPurchase, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = completeSkuPurchase.skuName;
                }
                if ((i & 2) != 0) {
                    str2 = completeSkuPurchase.planName;
                }
                return completeSkuPurchase.copy(str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getSkuName() {
                return this.skuName;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getPlanName() {
                return this.planName;
            }

            public final CompleteSkuPurchase copy(String skuName, String planName) {
                Intrinsics3.checkNotNullParameter(skuName, "skuName");
                Intrinsics3.checkNotNullParameter(planName, "planName");
                return new CompleteSkuPurchase(skuName, planName);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CompleteSkuPurchase)) {
                    return false;
                }
                CompleteSkuPurchase completeSkuPurchase = (CompleteSkuPurchase) other;
                return Intrinsics3.areEqual(this.skuName, completeSkuPurchase.skuName) && Intrinsics3.areEqual(this.planName, completeSkuPurchase.planName);
            }

            public final String getPlanName() {
                return this.planName;
            }

            public final String getSkuName() {
                return this.skuName;
            }

            public int hashCode() {
                String str = this.skuName;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.planName;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("CompleteSkuPurchase(skuName=");
                sbU.append(this.skuName);
                sbU.append(", planName=");
                return outline.J(sbU, this.planName, ")");
            }
        }

        /* JADX INFO: compiled from: ChoosePlanViewModel.kt */
        public static final /* data */ class ErrorSkuPurchase extends Event {
            private final int message;

            public ErrorSkuPurchase(@StringRes int i) {
                super(null);
                this.message = i;
            }

            public static /* synthetic */ ErrorSkuPurchase copy$default(ErrorSkuPurchase errorSkuPurchase, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = errorSkuPurchase.message;
                }
                return errorSkuPurchase.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getMessage() {
                return this.message;
            }

            public final ErrorSkuPurchase copy(@StringRes int message) {
                return new ErrorSkuPurchase(message);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ErrorSkuPurchase) && this.message == ((ErrorSkuPurchase) other).message;
                }
                return true;
            }

            public final int getMessage() {
                return this.message;
            }

            public int hashCode() {
                return this.message;
            }

            public String toString() {
                return outline.B(outline.U("ErrorSkuPurchase(message="), this.message, ")");
            }
        }

        /* JADX INFO: compiled from: ChoosePlanViewModel.kt */
        public static final /* data */ class StartSkuPurchase extends Event {
            private final BillingFlowParams billingParams;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StartSkuPurchase(BillingFlowParams billingFlowParams) {
                super(null);
                Intrinsics3.checkNotNullParameter(billingFlowParams, "billingParams");
                this.billingParams = billingFlowParams;
            }

            public static /* synthetic */ StartSkuPurchase copy$default(StartSkuPurchase startSkuPurchase, BillingFlowParams billingFlowParams, int i, Object obj) {
                if ((i & 1) != 0) {
                    billingFlowParams = startSkuPurchase.billingParams;
                }
                return startSkuPurchase.copy(billingFlowParams);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BillingFlowParams getBillingParams() {
                return this.billingParams;
            }

            public final StartSkuPurchase copy(BillingFlowParams billingParams) {
                Intrinsics3.checkNotNullParameter(billingParams, "billingParams");
                return new StartSkuPurchase(billingParams);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof StartSkuPurchase) && Intrinsics3.areEqual(this.billingParams, ((StartSkuPurchase) other).billingParams);
                }
                return true;
            }

            public final BillingFlowParams getBillingParams() {
                return this.billingParams;
            }

            public int hashCode() {
                BillingFlowParams billingFlowParams = this.billingParams;
                if (billingFlowParams != null) {
                    return billingFlowParams.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("StartSkuPurchase(billingParams=");
                sbU.append(this.billingParams);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ChoosePlanViewModel.kt */
    public static final /* data */ class StoreState {
        private final StoreGooglePlayPurchases.QueryState purchasesQueryState;
        private final StoreGooglePlayPurchases.State purchasesState;
        private final StoreGooglePlaySkuDetails.State skuDetailsState;
        private final StoreSubscriptions.SubscriptionsState subscriptionsState;

        public StoreState(StoreGooglePlaySkuDetails.State state, StoreGooglePlayPurchases.State state2, StoreGooglePlayPurchases.QueryState queryState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
            Intrinsics3.checkNotNullParameter(state, "skuDetailsState");
            Intrinsics3.checkNotNullParameter(state2, "purchasesState");
            Intrinsics3.checkNotNullParameter(queryState, "purchasesQueryState");
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            this.skuDetailsState = state;
            this.purchasesState = state2;
            this.purchasesQueryState = queryState;
            this.subscriptionsState = subscriptionsState;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreGooglePlaySkuDetails.State state, StoreGooglePlayPurchases.State state2, StoreGooglePlayPurchases.QueryState queryState, StoreSubscriptions.SubscriptionsState subscriptionsState, int i, Object obj) {
            if ((i & 1) != 0) {
                state = storeState.skuDetailsState;
            }
            if ((i & 2) != 0) {
                state2 = storeState.purchasesState;
            }
            if ((i & 4) != 0) {
                queryState = storeState.purchasesQueryState;
            }
            if ((i & 8) != 0) {
                subscriptionsState = storeState.subscriptionsState;
            }
            return storeState.copy(state, state2, queryState, subscriptionsState);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreGooglePlaySkuDetails.State getSkuDetailsState() {
            return this.skuDetailsState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StoreGooglePlayPurchases.State getPurchasesState() {
            return this.purchasesState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final StoreGooglePlayPurchases.QueryState getPurchasesQueryState() {
            return this.purchasesQueryState;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        public final StoreState copy(StoreGooglePlaySkuDetails.State skuDetailsState, StoreGooglePlayPurchases.State purchasesState, StoreGooglePlayPurchases.QueryState purchasesQueryState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
            Intrinsics3.checkNotNullParameter(skuDetailsState, "skuDetailsState");
            Intrinsics3.checkNotNullParameter(purchasesState, "purchasesState");
            Intrinsics3.checkNotNullParameter(purchasesQueryState, "purchasesQueryState");
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            return new StoreState(skuDetailsState, purchasesState, purchasesQueryState, subscriptionsState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.skuDetailsState, storeState.skuDetailsState) && Intrinsics3.areEqual(this.purchasesState, storeState.purchasesState) && Intrinsics3.areEqual(this.purchasesQueryState, storeState.purchasesQueryState) && Intrinsics3.areEqual(this.subscriptionsState, storeState.subscriptionsState);
        }

        public final StoreGooglePlayPurchases.QueryState getPurchasesQueryState() {
            return this.purchasesQueryState;
        }

        public final StoreGooglePlayPurchases.State getPurchasesState() {
            return this.purchasesState;
        }

        public final StoreGooglePlaySkuDetails.State getSkuDetailsState() {
            return this.skuDetailsState;
        }

        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        public int hashCode() {
            StoreGooglePlaySkuDetails.State state = this.skuDetailsState;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            StoreGooglePlayPurchases.State state2 = this.purchasesState;
            int iHashCode2 = (iHashCode + (state2 != null ? state2.hashCode() : 0)) * 31;
            StoreGooglePlayPurchases.QueryState queryState = this.purchasesQueryState;
            int iHashCode3 = (iHashCode2 + (queryState != null ? queryState.hashCode() : 0)) * 31;
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.subscriptionsState;
            return iHashCode3 + (subscriptionsState != null ? subscriptionsState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(skuDetailsState=");
            sbU.append(this.skuDetailsState);
            sbU.append(", purchasesState=");
            sbU.append(this.purchasesState);
            sbU.append(", purchasesQueryState=");
            sbU.append(this.purchasesQueryState);
            sbU.append(", subscriptionsState=");
            sbU.append(this.subscriptionsState);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: ChoosePlanViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: ChoosePlanViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean isEmpty;
            private final List<WidgetChoosePlanAdapter.Item> items;
            private final List<Purchase> purchases;
            private final StoreGooglePlayPurchases.QueryState purchasesQueryState;
            private final Map<String, SkuDetails> skuDetails;
            private final List<ModelSubscription> subscriptions;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(StoreGooglePlayPurchases.QueryState queryState, List<? extends WidgetChoosePlanAdapter.Item> list, Map<String, ? extends SkuDetails> map, List<? extends Purchase> list2, List<ModelSubscription> list3, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(queryState, "purchasesQueryState");
                Intrinsics3.checkNotNullParameter(list, "items");
                Intrinsics3.checkNotNullParameter(map, "skuDetails");
                Intrinsics3.checkNotNullParameter(list2, "purchases");
                Intrinsics3.checkNotNullParameter(list3, "subscriptions");
                this.purchasesQueryState = queryState;
                this.items = list;
                this.skuDetails = map;
                this.purchases = list2;
                this.subscriptions = list3;
                this.isEmpty = z2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, StoreGooglePlayPurchases.QueryState queryState, List list, Map map, List list2, List list3, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    queryState = loaded.purchasesQueryState;
                }
                if ((i & 2) != 0) {
                    list = loaded.items;
                }
                List list4 = list;
                if ((i & 4) != 0) {
                    map = loaded.skuDetails;
                }
                Map map2 = map;
                if ((i & 8) != 0) {
                    list2 = loaded.purchases;
                }
                List list5 = list2;
                if ((i & 16) != 0) {
                    list3 = loaded.subscriptions;
                }
                List list6 = list3;
                if ((i & 32) != 0) {
                    z2 = loaded.isEmpty;
                }
                return loaded.copy(queryState, list4, map2, list5, list6, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final StoreGooglePlayPurchases.QueryState getPurchasesQueryState() {
                return this.purchasesQueryState;
            }

            public final List<WidgetChoosePlanAdapter.Item> component2() {
                return this.items;
            }

            public final Map<String, SkuDetails> component3() {
                return this.skuDetails;
            }

            public final List<Purchase> component4() {
                return this.purchases;
            }

            public final List<ModelSubscription> component5() {
                return this.subscriptions;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getIsEmpty() {
                return this.isEmpty;
            }

            public final Loaded copy(StoreGooglePlayPurchases.QueryState purchasesQueryState, List<? extends WidgetChoosePlanAdapter.Item> items, Map<String, ? extends SkuDetails> skuDetails, List<? extends Purchase> purchases, List<ModelSubscription> subscriptions, boolean isEmpty) {
                Intrinsics3.checkNotNullParameter(purchasesQueryState, "purchasesQueryState");
                Intrinsics3.checkNotNullParameter(items, "items");
                Intrinsics3.checkNotNullParameter(skuDetails, "skuDetails");
                Intrinsics3.checkNotNullParameter(purchases, "purchases");
                Intrinsics3.checkNotNullParameter(subscriptions, "subscriptions");
                return new Loaded(purchasesQueryState, items, skuDetails, purchases, subscriptions, isEmpty);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.purchasesQueryState, loaded.purchasesQueryState) && Intrinsics3.areEqual(this.items, loaded.items) && Intrinsics3.areEqual(this.skuDetails, loaded.skuDetails) && Intrinsics3.areEqual(this.purchases, loaded.purchases) && Intrinsics3.areEqual(this.subscriptions, loaded.subscriptions) && this.isEmpty == loaded.isEmpty;
            }

            public final List<WidgetChoosePlanAdapter.Item> getItems() {
                return this.items;
            }

            public final List<Purchase> getPurchases() {
                return this.purchases;
            }

            public final StoreGooglePlayPurchases.QueryState getPurchasesQueryState() {
                return this.purchasesQueryState;
            }

            public final Map<String, SkuDetails> getSkuDetails() {
                return this.skuDetails;
            }

            public final List<ModelSubscription> getSubscriptions() {
                return this.subscriptions;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v12, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v6 */
            public int hashCode() {
                StoreGooglePlayPurchases.QueryState queryState = this.purchasesQueryState;
                int iHashCode = (queryState != null ? queryState.hashCode() : 0) * 31;
                List<WidgetChoosePlanAdapter.Item> list = this.items;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                Map<String, SkuDetails> map = this.skuDetails;
                int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
                List<Purchase> list2 = this.purchases;
                int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
                List<ModelSubscription> list3 = this.subscriptions;
                int iHashCode5 = (iHashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31;
                boolean z2 = this.isEmpty;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode5 + r1;
            }

            public final boolean isEmpty() {
                return this.isEmpty;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(purchasesQueryState=");
                sbU.append(this.purchasesQueryState);
                sbU.append(", items=");
                sbU.append(this.items);
                sbU.append(", skuDetails=");
                sbU.append(this.skuDetails);
                sbU.append(", purchases=");
                sbU.append(this.purchases);
                sbU.append(", subscriptions=");
                sbU.append(this.subscriptions);
                sbU.append(", isEmpty=");
                return outline.O(sbU, this.isEmpty, ")");
            }
        }

        /* JADX INFO: compiled from: ChoosePlanViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WidgetChoosePlan.ViewType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[WidgetChoosePlan.ViewType.BUY_PREMIUM_TIER_2.ordinal()] = 1;
            iArr[WidgetChoosePlan.ViewType.BUY_PREMIUM_TIER_1.ordinal()] = 2;
            iArr[WidgetChoosePlan.ViewType.BUY_PREMIUM_GUILD.ordinal()] = 3;
            iArr[WidgetChoosePlan.ViewType.SWITCH_PLANS.ordinal()] = 4;
        }
    }

    public /* synthetic */ ChoosePlanViewModel(WidgetChoosePlan.ViewType viewType, String str, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewType, str, (i & 4) != 0 ? INSTANCE.observeStores() : observable);
    }

    public static /* synthetic */ void buy$default(ChoosePlanViewModel choosePlanViewModel, GooglePlaySku googlePlaySku, String str, Traits.Location location, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        choosePlanViewModel.buy(googlePlaySku, str, location, str2);
    }

    private final void fetchData() {
        GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
        googlePlayBillingManager.queryPurchases();
        googlePlayBillingManager.querySkuDetails();
    }

    private final List<WidgetChoosePlanAdapter.Item> getCurrentPlanItems(Map<String, ? extends SkuDetails> skuDetailsMap) {
        GooglePlaySku.Companion companion;
        GooglePlaySku googlePlaySkuFromSkuName;
        String str = this.oldSkuName;
        if (str == null || (googlePlaySkuFromSkuName = (companion = GooglePlaySku.INSTANCE).fromSkuName(str)) == null) {
            return Collections2.emptyList();
        }
        SkuDetails skuDetails = skuDetailsMap.get(this.oldSkuName);
        if (skuDetails == null) {
            return Collections2.emptyList();
        }
        GooglePlaySku upgrade = googlePlaySkuFromSkuName.getUpgrade();
        GooglePlaySku upgrade2 = googlePlaySkuFromSkuName.getUpgrade();
        GooglePlaySku googlePlaySku = null;
        SkuDetails skuDetails2 = skuDetailsMap.get(upgrade2 != null ? upgrade2.getSkuName() : null);
        GooglePlaySku downgrade = companion.getDowngrade(this.oldSkuName);
        SkuDetails skuDetails3 = skuDetailsMap.get(downgrade != null ? downgrade.getSkuName() : null);
        if (upgrade != null && skuDetails2 != null) {
            googlePlaySku = googlePlaySkuFromSkuName;
        } else if (downgrade != null && skuDetails3 != null) {
            googlePlaySku = downgrade;
        }
        return Collections2.listOf((Object[]) new WidgetChoosePlanAdapter.Item[]{new WidgetChoosePlanAdapter.Item.Header(R.string.billing_switch_plan_current_plan), new WidgetChoosePlanAdapter.Item.Plan(googlePlaySkuFromSkuName, skuDetails, googlePlaySku, this.oldSkuName, skuDetails2, true), new WidgetChoosePlanAdapter.Item.Divider()});
    }

    private final List<WidgetChoosePlanAdapter.Item> getGuildBoostPlans(Map<String, ? extends SkuDetails> skuDetailsMap, SubscriptionInterval skuInterval) {
        GooglePlaySku googlePlaySkuFromSkuName;
        String str = this.oldSkuName;
        if (str == null || (googlePlaySkuFromSkuName = GooglePlaySku.INSTANCE.fromSkuName(str)) == null) {
            GooglePlaySku[] googlePlaySkuArrValues = GooglePlaySku.values();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 19; i++) {
                GooglePlaySku googlePlaySku = googlePlaySkuArrValues[i];
                if (googlePlaySku.getInterval() == skuInterval && googlePlaySku.getPremiumSubscriptionCount() > 0) {
                    arrayList.add(googlePlaySku);
                }
            }
            return getPlansWithHeaders(arrayList, skuDetailsMap);
        }
        GooglePlaySku[] googlePlaySkuArrValues2 = GooglePlaySku.values();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < 19; i2++) {
            GooglePlaySku googlePlaySku2 = googlePlaySkuArrValues2[i2];
            if (googlePlaySku2.getInterval() == googlePlaySkuFromSkuName.getInterval() && googlePlaySku2.getPremiumSubscriptionCount() > googlePlaySkuFromSkuName.getPremiumSubscriptionCount()) {
                arrayList2.add(googlePlaySku2);
            }
        }
        return getPlansWithHeaders(arrayList2, skuDetailsMap);
    }

    private final WidgetChoosePlanAdapter.Item.Header getHeaderForSkuSection(GooglePlaySku.Section section) {
        return new WidgetChoosePlanAdapter.Item.Header(GooglePlaySku.Section.INSTANCE.getHeaderResource(section));
    }

    private final List<WidgetChoosePlanAdapter.Item> getItemsForViewType(WidgetChoosePlan.ViewType viewType, Map<String, ? extends SkuDetails> skuDetailsMap, SubscriptionInterval skuInterval) {
        int iOrdinal = viewType.ordinal();
        if (iOrdinal == 0) {
            GooglePlaySku[] googlePlaySkuArrValues = GooglePlaySku.values();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 19; i++) {
                GooglePlaySku googlePlaySku = googlePlaySkuArrValues[i];
                if (googlePlaySku.getInterval() == skuInterval && GooglePlaySku2.isTier2(googlePlaySku)) {
                    arrayList.add(googlePlaySku);
                }
            }
            return getPlansWithHeaders(arrayList, skuDetailsMap);
        }
        if (iOrdinal == 1) {
            GooglePlaySku[] googlePlaySkuArrValues2 = GooglePlaySku.values();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 19; i2++) {
                GooglePlaySku googlePlaySku2 = googlePlaySkuArrValues2[i2];
                if (googlePlaySku2.getInterval() == skuInterval && GooglePlaySku2.isTier1(googlePlaySku2)) {
                    arrayList2.add(googlePlaySku2);
                }
            }
            return getPlansWithHeaders(arrayList2, skuDetailsMap);
        }
        if (iOrdinal == 2) {
            return getGuildBoostPlans(skuDetailsMap, skuInterval);
        }
        if (iOrdinal != 3) {
            throw new NoWhenBranchMatchedException();
        }
        GooglePlaySku[] googlePlaySkuArrValues3 = GooglePlaySku.values();
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < 19; i3++) {
            GooglePlaySku googlePlaySku3 = googlePlaySkuArrValues3[i3];
            if (googlePlaySku3.getInterval() == skuInterval) {
                arrayList3.add(googlePlaySku3);
            }
        }
        return getPlansWithHeaders(arrayList3, skuDetailsMap);
    }

    public static /* synthetic */ List getItemsForViewType$default(ChoosePlanViewModel choosePlanViewModel, WidgetChoosePlan.ViewType viewType, Map map, SubscriptionInterval subscriptionInterval, int i, Object obj) {
        if ((i & 4) != 0) {
            subscriptionInterval = SubscriptionInterval.MONTHLY;
        }
        return choosePlanViewModel.getItemsForViewType(viewType, map, subscriptionInterval);
    }

    private final WidgetChoosePlanAdapter.Item.Plan getPlanForSku(GooglePlaySku sku, Map<String, ? extends SkuDetails> skuDetailsMap) {
        SkuDetails skuDetails = skuDetailsMap.get(sku.getSkuName());
        if (skuDetails == null) {
            return null;
        }
        GooglePlaySku upgrade = sku.getUpgrade();
        SkuDetails skuDetails2 = skuDetailsMap.get(upgrade != null ? upgrade.getSkuName() : null);
        boolean zAreEqual = Intrinsics3.areEqual(this.oldSkuName, sku.getSkuName());
        String str = this.oldSkuName;
        GooglePlaySku upgrade2 = sku.getUpgrade();
        boolean z2 = Intrinsics3.areEqual(str, upgrade2 != null ? upgrade2.getSkuName() : null) && sku.getType() != GooglePlaySku.Type.PREMIUM_GUILD;
        if (this.oldSkuName == null || !(zAreEqual || z2)) {
            return new WidgetChoosePlanAdapter.Item.Plan(sku, skuDetails, sku, this.oldSkuName, skuDetails2, false, 32, null);
        }
        return null;
    }

    private final List<WidgetChoosePlanAdapter.Item> getPlansWithHeaders(List<? extends GooglePlaySku> skus, Map<String, ? extends SkuDetails> skuDetailsMap) {
        List<GooglePlaySku.Section> listListOf = Collections2.listOf((Object[]) new GooglePlaySku.Section[]{GooglePlaySku.Section.PREMIUM, GooglePlaySku.Section.PREMIUM_AND_PREMIUM_GUILD, GooglePlaySku.Section.PREMIUM_GUILD});
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listListOf, 10));
        for (GooglePlaySku.Section section : listListOf) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : skus) {
                if (GooglePlaySku2.getSection((GooglePlaySku) obj) == section) {
                    arrayList2.add(obj);
                }
            }
            arrayList.add(arrayList2);
        }
        ArrayList<List> arrayList3 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!((List) obj2).isEmpty()) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList3, 10));
        for (List list : arrayList3) {
            List listListOf2 = CollectionsJVM.listOf(getHeaderForSkuSection(GooglePlaySku2.getSection((GooglePlaySku) _Collections.first(list))));
            ArrayList arrayList5 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                WidgetChoosePlanAdapter.Item.Plan planForSku = getPlanForSku((GooglePlaySku) it.next(), skuDetailsMap);
                if (planForSku != null) {
                    arrayList5.add(planForSku);
                }
            }
            arrayList4.add(_Collections.plus((Collection) listListOf2, (Iterable) arrayList5));
        }
        return Iterables2.flatten(arrayList4);
    }

    private final int getProrationMode(SkuDetails oldSkuDetails, SkuDetails newSkuDetails) {
        return (newSkuDetails.c() > oldSkuDetails.c() ? 1 : (newSkuDetails.c() == oldSkuDetails.c() ? 0 : -1)) < 0 ? 4 : 2;
    }

    private final void handleEvent(StoreGooglePlayPurchases.Event event) {
        String strA;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            if (event instanceof StoreGooglePlayPurchases.Event.PurchaseQuerySuccess) {
                StoreGooglePlayPurchases.Event.PurchaseQuerySuccess purchaseQuerySuccess = (StoreGooglePlayPurchases.Event.PurchaseQuerySuccess) event;
                SkuDetails skuDetails = loaded.getSkuDetails().get(purchaseQuerySuccess.getNewSkuName());
                if (skuDetails == null || (strA = skuDetails.a()) == null) {
                    return;
                }
                Intrinsics3.checkNotNullExpressionValue(strA, "loadedViewState.skuDetai…e]?.description ?: return");
                AnalyticsTracker.INSTANCE.paymentFlowCompleted(this.locationTrait, (18 & 2) != 0 ? null : Traits.Subscription.INSTANCE.withGatewayPlanId(purchaseQuerySuccess.getNewSkuName()), (18 & 4) != 0 ? null : null, (18 & 8) != 0 ? null : null, (18 & 16) != 0 ? null : null);
                this.eventSubject.k.onNext(new Event.CompleteSkuPurchase(purchaseQuerySuccess.getNewSkuName(), strA));
                return;
            }
            if (event instanceof StoreGooglePlayPurchases.Event.PurchaseQueryFailure) {
                StoreGooglePlayPurchases.Event.PurchaseQueryFailure purchaseQueryFailure = (StoreGooglePlayPurchases.Event.PurchaseQueryFailure) event;
                AnalyticsTracker.paymentFlowFailed$default(AnalyticsTracker.INSTANCE, this.locationTrait, Traits.Subscription.INSTANCE.withGatewayPlanId(purchaseQueryFailure.getNewSkuName()), null, null, 12, null);
                AppLog appLog = AppLog.g;
                StringBuilder sbU = outline.U("Purchase query failure. ");
                sbU.append(purchaseQueryFailure.getNewSkuName());
                Logger.e$default(appLog, sbU.toString(), new Exception(), null, 4, null);
                this.eventSubject.k.onNext(new Event.ErrorSkuPurchase(R.string.billing_error_purchase));
            }
        }
    }

    private final void handleStoreState(StoreState storeState) {
        ViewState loaded;
        if ((storeState.getPurchasesState() instanceof StoreGooglePlayPurchases.State.Loaded) && (storeState.getSkuDetailsState() instanceof StoreGooglePlaySkuDetails.State.Loaded) && (storeState.getSubscriptionsState() instanceof StoreSubscriptions.SubscriptionsState.Loaded)) {
            List<WidgetChoosePlanAdapter.Item> currentPlanItems = getCurrentPlanItems(((StoreGooglePlaySkuDetails.State.Loaded) storeState.getSkuDetailsState()).getSkuDetails());
            List itemsForViewType$default = getItemsForViewType$default(this, this.viewType, ((StoreGooglePlaySkuDetails.State.Loaded) storeState.getSkuDetailsState()).getSkuDetails(), null, 4, null);
            loaded = new ViewState.Loaded(storeState.getPurchasesQueryState(), _Collections.filterNotNull(_Collections.plus((Collection) currentPlanItems, (Iterable) itemsForViewType$default)), ((StoreGooglePlaySkuDetails.State.Loaded) storeState.getSkuDetailsState()).getSkuDetails(), ((StoreGooglePlayPurchases.State.Loaded) storeState.getPurchasesState()).getPurchases(), ((StoreSubscriptions.SubscriptionsState.Loaded) storeState.getSubscriptionsState()).getSubscriptions(), itemsForViewType$default.isEmpty());
        } else {
            loaded = ViewState.Loading.INSTANCE;
        }
        updateViewState(loaded);
    }

    public final void buy(GooglePlaySku sku, String oldSkuName, Traits.Location locationTrait, String fromStep) {
        Intrinsics3.checkNotNullParameter(sku, "sku");
        Intrinsics3.checkNotNullParameter(locationTrait, "locationTrait");
        Intrinsics3.checkNotNullParameter(fromStep, "fromStep");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            Map<String, SkuDetails> skuDetails = loaded.getSkuDetails();
            SkuDetails skuDetails2 = skuDetails.get(sku.getSkuName());
            SkuDetails skuDetails3 = skuDetails.get(oldSkuName);
            Traits.Subscription subscriptionWithGatewayPlanId = Traits.Subscription.INSTANCE.withGatewayPlanId(sku.getSkuName());
            this.locationTrait = locationTrait;
            if (skuDetails2 == null || (oldSkuName != null && skuDetails3 == null)) {
                AnalyticsTracker.paymentFlowFailed$default(AnalyticsTracker.INSTANCE, locationTrait, subscriptionWithGatewayPlanId, null, null, 12, null);
                AppLog appLog = AppLog.g;
                StringBuilder sb = new StringBuilder();
                sb.append("Purchase details not found.");
                sb.append("oldSku: ");
                sb.append(oldSkuName);
                sb.append("; hasOldSkuDetails: ");
                sb.append(skuDetails3 == null);
                sb.append("; ");
                sb.append("hasNewSkuDetails: ");
                sb.append(skuDetails2 == null);
                Logger.e$default(appLog, sb.toString(), new Exception(), null, 4, null);
                this.eventSubject.k.onNext(new Event.ErrorSkuPurchase(R.string.billing_error_purchase_details_not_found));
                return;
            }
            BillingFlowParams.a aVar = new BillingFlowParams.a();
            ArrayList<SkuDetails> arrayList = new ArrayList<>();
            arrayList.add(skuDetails2);
            aVar.d = arrayList;
            Intrinsics3.checkNotNullExpressionValue(aVar, "BillingFlowParams.newBui…SkuDetails(newSkuDetails)");
            if (oldSkuName != null && skuDetails3 != null && (!Intrinsics3.areEqual(sku.getSkuName(), oldSkuName))) {
                PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
                Purchase purchaseFindPurchaseForSkuName = premiumUtils.findPurchaseForSkuName(loaded.getPurchases(), oldSkuName);
                if (purchaseFindPurchaseForSkuName == null) {
                    AnalyticsTracker.paymentFlowFailed$default(AnalyticsTracker.INSTANCE, locationTrait, subscriptionWithGatewayPlanId, null, null, 12, null);
                    AppLog appLog2 = AppLog.g;
                    StringBuilder sbY = outline.Y("Subscription without matching purchase. oldSkuName: ", oldSkuName, "; skuName: ");
                    sbY.append(sku.getSkuName());
                    Logger.e$default(appLog2, sbY.toString(), new Exception(), null, 4, null);
                    this.eventSubject.k.onNext(new Event.ErrorSkuPurchase(R.string.billing_error_purchase));
                    return;
                }
                int prorationMode = getProrationMode(skuDetails3, skuDetails2);
                c cVar = new c();
                Intrinsics3.checkNotNullExpressionValue(cVar, "BillingFlowParams.Subscr…UpdateParams.newBuilder()");
                String strA = purchaseFindPurchaseForSkuName.a();
                cVar.a = strA;
                cVar.f449b = prorationMode;
                if (TextUtils.isEmpty(strA) && TextUtils.isEmpty(null)) {
                    throw new IllegalArgumentException("Old SKU purchase token/id must be provided.");
                }
                String str = cVar.a;
                int i = cVar.f449b;
                aVar.f2002b = str;
                aVar.c = i;
                if (prorationMode == 4) {
                    ModelSubscription modelSubscriptionFindSubscriptionForSku = premiumUtils.findSubscriptionForSku(loaded.getSubscriptions(), oldSkuName);
                    String id2 = modelSubscriptionFindSubscriptionForSku != null ? modelSubscriptionFindSubscriptionForSku.getId() : null;
                    if (id2 == null) {
                        AnalyticsTracker.paymentFlowFailed$default(AnalyticsTracker.INSTANCE, locationTrait, subscriptionWithGatewayPlanId, null, null, 12, null);
                        AppLog appLog3 = AppLog.g;
                        StringBuilder sbY2 = outline.Y("No premium subscription for downgrade found. oldSkuName: ", oldSkuName, "; skuName: ");
                        sbY2.append(sku.getSkuName());
                        Logger.e$default(appLog3, sbY2.toString(), new Exception(), null, 4, null);
                        this.eventSubject.k.onNext(new Event.ErrorSkuPurchase(R.string.billing_error_purchase));
                        return;
                    }
                    StoreGooglePlayPurchases googlePlayPurchases = StoreStream.INSTANCE.getGooglePlayPurchases();
                    String strA2 = purchaseFindPurchaseForSkuName.a();
                    Intrinsics3.checkNotNullExpressionValue(strA2, "purchase.purchaseToken");
                    googlePlayPurchases.updatePendingDowngrade(new StoreGooglePlayPurchases2(strA2, id2, sku.getSkuName()));
                }
            }
            String obfuscatedUserId = UserUtils.INSTANCE.getObfuscatedUserId(Long.valueOf(StoreStream.INSTANCE.getUsers().getMe().getId()));
            if (obfuscatedUserId != null) {
                aVar.a = obfuscatedUserId;
            }
            AnalyticsTracker.INSTANCE.paymentFlowStep(locationTrait, (48 & 2) != 0 ? null : subscriptionWithGatewayPlanId, "external_payment", fromStep, (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? null : null);
            PublishSubject<Event> publishSubject = this.eventSubject;
            BillingFlowParams billingFlowParamsA = aVar.a();
            Intrinsics3.checkNotNullExpressionValue(billingFlowParamsA, "builder.build()");
            publishSubject.k.onNext(new Event.StartSkuPurchase(billingFlowParamsA));
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChoosePlanViewModel(WidgetChoosePlan.ViewType viewType, String str, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(viewType, "viewType");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.viewType = viewType;
        this.oldSkuName = str;
        this.eventSubject = PublishSubject.k0();
        fetchData();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) ChoosePlanViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getGooglePlayPurchases().observeEvents(), this, null, 2, null), (Class<?>) ChoosePlanViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }
}
