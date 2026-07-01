package com.discord.widgets.settings.premium;

import android.content.Context;
import android.text.TextUtils;
import b.a.d.d0;
import b.d.a.a.c;
import b.d.b.a.a;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingFlowParams$a;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.api.premium.SubscriptionInterval;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.PendingDowngrade;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGooglePlayPurchases$Event;
import com.discord.stores.StoreGooglePlayPurchases$Event$PurchaseQueryFailure;
import com.discord.stores.StoreGooglePlayPurchases$Event$PurchaseQuerySuccess;
import com.discord.stores.StoreGooglePlayPurchases$State$Loaded;
import com.discord.stores.StoreGooglePlaySkuDetails$State$Loaded;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Loaded;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$ObjType;
import com.discord.utilities.analytics.Traits$Subscription;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.billing.GooglePlaySku$Companion;
import com.discord.utilities.billing.GooglePlaySku$Section;
import com.discord.utilities.billing.GooglePlaySku$Type;
import com.discord.utilities.billing.GooglePlaySkuKt;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ChoosePlanViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChoosePlanViewModel extends d0<ChoosePlanViewModel$ViewState> {
    public static final ChoosePlanViewModel$Companion Companion = new ChoosePlanViewModel$Companion(null);
    private final PublishSubject<ChoosePlanViewModel$Event> eventSubject;
    private Traits$Location locationTrait;
    private final String oldSkuName;
    private final WidgetChoosePlan$ViewType viewType;

    public /* synthetic */ ChoosePlanViewModel(WidgetChoosePlan$ViewType widgetChoosePlan$ViewType, String str, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetChoosePlan$ViewType, str, (i & 4) != 0 ? ChoosePlanViewModel$Companion.access$observeStores(Companion) : observable);
    }

    public static final /* synthetic */ void access$handleEvent(ChoosePlanViewModel choosePlanViewModel, StoreGooglePlayPurchases$Event storeGooglePlayPurchases$Event) {
        choosePlanViewModel.handleEvent(storeGooglePlayPurchases$Event);
    }

    public static final /* synthetic */ void access$handleStoreState(ChoosePlanViewModel choosePlanViewModel, ChoosePlanViewModel$StoreState choosePlanViewModel$StoreState) {
        choosePlanViewModel.handleStoreState(choosePlanViewModel$StoreState);
    }

    public static /* synthetic */ void buy$default(ChoosePlanViewModel choosePlanViewModel, GooglePlaySku googlePlaySku, String str, Traits$Location traits$Location, String str2, int i, Object obj) throws NoSuchAlgorithmException {
        if ((i & 2) != 0) {
            str = null;
        }
        choosePlanViewModel.buy(googlePlaySku, str, traits$Location, str2);
    }

    private final void fetchData() {
        GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
        googlePlayBillingManager.queryPurchases();
        googlePlayBillingManager.querySkuDetails();
    }

    private final List<WidgetChoosePlanAdapter$Item> getCurrentPlanItems(Map<String, ? extends SkuDetails> skuDetailsMap) {
        GooglePlaySku$Companion googlePlaySku$Companion;
        GooglePlaySku googlePlaySkuFromSkuName;
        String str = this.oldSkuName;
        if (str == null || (googlePlaySkuFromSkuName = (googlePlaySku$Companion = GooglePlaySku.Companion).fromSkuName(str)) == null) {
            return n.emptyList();
        }
        SkuDetails skuDetails = skuDetailsMap.get(this.oldSkuName);
        if (skuDetails == null) {
            return n.emptyList();
        }
        GooglePlaySku upgrade = googlePlaySkuFromSkuName.getUpgrade();
        GooglePlaySku upgrade2 = googlePlaySkuFromSkuName.getUpgrade();
        GooglePlaySku googlePlaySku = null;
        SkuDetails skuDetails2 = skuDetailsMap.get(upgrade2 != null ? upgrade2.getSkuName() : null);
        GooglePlaySku downgrade = googlePlaySku$Companion.getDowngrade(this.oldSkuName);
        SkuDetails skuDetails3 = skuDetailsMap.get(downgrade != null ? downgrade.getSkuName() : null);
        if (upgrade != null && skuDetails2 != null) {
            googlePlaySku = googlePlaySkuFromSkuName;
        } else if (downgrade != null && skuDetails3 != null) {
            googlePlaySku = downgrade;
        }
        return n.listOf((Object[]) new WidgetChoosePlanAdapter$Item[]{new WidgetChoosePlanAdapter$Item$Header(2131887234), new WidgetChoosePlanAdapter$Item$Plan(googlePlaySkuFromSkuName, skuDetails, googlePlaySku, this.oldSkuName, skuDetails2, true), new WidgetChoosePlanAdapter$Item$Divider()});
    }

    private final List<WidgetChoosePlanAdapter$Item> getGuildBoostPlans(Map<String, ? extends SkuDetails> skuDetailsMap, SubscriptionInterval skuInterval) {
        GooglePlaySku googlePlaySkuFromSkuName;
        String str = this.oldSkuName;
        if (str == null || (googlePlaySkuFromSkuName = GooglePlaySku.Companion.fromSkuName(str)) == null) {
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

    private final WidgetChoosePlanAdapter$Item$Header getHeaderForSkuSection(GooglePlaySku$Section section) {
        return new WidgetChoosePlanAdapter$Item$Header(GooglePlaySku$Section.Companion.getHeaderResource(section));
    }

    private final List<WidgetChoosePlanAdapter$Item> getItemsForViewType(WidgetChoosePlan$ViewType viewType, Map<String, ? extends SkuDetails> skuDetailsMap, SubscriptionInterval skuInterval) {
        int iOrdinal = viewType.ordinal();
        if (iOrdinal == 0) {
            GooglePlaySku[] googlePlaySkuArrValues = GooglePlaySku.values();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 19; i++) {
                GooglePlaySku googlePlaySku = googlePlaySkuArrValues[i];
                if (googlePlaySku.getInterval() == skuInterval && GooglePlaySkuKt.isTier2(googlePlaySku)) {
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
                if (googlePlaySku2.getInterval() == skuInterval && GooglePlaySkuKt.isTier1(googlePlaySku2)) {
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

    public static /* synthetic */ List getItemsForViewType$default(ChoosePlanViewModel choosePlanViewModel, WidgetChoosePlan$ViewType widgetChoosePlan$ViewType, Map map, SubscriptionInterval subscriptionInterval, int i, Object obj) {
        if ((i & 4) != 0) {
            subscriptionInterval = SubscriptionInterval.MONTHLY;
        }
        return choosePlanViewModel.getItemsForViewType(widgetChoosePlan$ViewType, map, subscriptionInterval);
    }

    private final WidgetChoosePlanAdapter$Item$Plan getPlanForSku(GooglePlaySku sku, Map<String, ? extends SkuDetails> skuDetailsMap) {
        SkuDetails skuDetails = skuDetailsMap.get(sku.getSkuName());
        if (skuDetails == null) {
            return null;
        }
        GooglePlaySku upgrade = sku.getUpgrade();
        SkuDetails skuDetails2 = skuDetailsMap.get(upgrade != null ? upgrade.getSkuName() : null);
        boolean zAreEqual = m.areEqual(this.oldSkuName, sku.getSkuName());
        String str = this.oldSkuName;
        GooglePlaySku upgrade2 = sku.getUpgrade();
        boolean z2 = m.areEqual(str, upgrade2 != null ? upgrade2.getSkuName() : null) && sku.getType() != GooglePlaySku$Type.PREMIUM_GUILD;
        if (this.oldSkuName == null || !(zAreEqual || z2)) {
            return new WidgetChoosePlanAdapter$Item$Plan(sku, skuDetails, sku, this.oldSkuName, skuDetails2, false, 32, null);
        }
        return null;
    }

    private final List<WidgetChoosePlanAdapter$Item> getPlansWithHeaders(List<? extends GooglePlaySku> skus, Map<String, ? extends SkuDetails> skuDetailsMap) {
        List<GooglePlaySku$Section> listListOf = n.listOf((Object[]) new GooglePlaySku$Section[]{GooglePlaySku$Section.PREMIUM, GooglePlaySku$Section.PREMIUM_AND_PREMIUM_GUILD, GooglePlaySku$Section.PREMIUM_GUILD});
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listListOf, 10));
        for (GooglePlaySku$Section googlePlaySku$Section : listListOf) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : skus) {
                if (GooglePlaySkuKt.getSection((GooglePlaySku) obj) == googlePlaySku$Section) {
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
        ArrayList arrayList4 = new ArrayList(o.collectionSizeOrDefault(arrayList3, 10));
        for (List list : arrayList3) {
            List listListOf2 = d0.t.m.listOf(getHeaderForSkuSection(GooglePlaySkuKt.getSection((GooglePlaySku) u.first(list))));
            ArrayList arrayList5 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                WidgetChoosePlanAdapter$Item$Plan planForSku = getPlanForSku((GooglePlaySku) it.next(), skuDetailsMap);
                if (planForSku != null) {
                    arrayList5.add(planForSku);
                }
            }
            arrayList4.add(u.plus((Collection) listListOf2, (Iterable) arrayList5));
        }
        return o.flatten(arrayList4);
    }

    private final int getProrationMode(SkuDetails oldSkuDetails, SkuDetails newSkuDetails) {
        return (newSkuDetails.c() > oldSkuDetails.c() ? 1 : (newSkuDetails.c() == oldSkuDetails.c() ? 0 : -1)) < 0 ? 4 : 2;
    }

    private final void handleEvent(StoreGooglePlayPurchases$Event event) {
        String strA;
        ChoosePlanViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChoosePlanViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        ChoosePlanViewModel$ViewState$Loaded choosePlanViewModel$ViewState$Loaded = (ChoosePlanViewModel$ViewState$Loaded) viewState;
        if (choosePlanViewModel$ViewState$Loaded != null) {
            if (event instanceof StoreGooglePlayPurchases$Event$PurchaseQuerySuccess) {
                StoreGooglePlayPurchases$Event$PurchaseQuerySuccess storeGooglePlayPurchases$Event$PurchaseQuerySuccess = (StoreGooglePlayPurchases$Event$PurchaseQuerySuccess) event;
                SkuDetails skuDetails = choosePlanViewModel$ViewState$Loaded.getSkuDetails().get(storeGooglePlayPurchases$Event$PurchaseQuerySuccess.getNewSkuName());
                if (skuDetails == null || (strA = skuDetails.a()) == null) {
                    return;
                }
                m.checkNotNullExpressionValue(strA, "loadedViewState.skuDetai…e]?.description ?: return");
                AnalyticsTracker.paymentFlowCompleted$default(AnalyticsTracker.INSTANCE, this.locationTrait, Traits$Subscription.Companion.withGatewayPlanId(storeGooglePlayPurchases$Event$PurchaseQuerySuccess.getNewSkuName()), null, null, null, 28, null);
                this.eventSubject.k.onNext(new ChoosePlanViewModel$Event$CompleteSkuPurchase(storeGooglePlayPurchases$Event$PurchaseQuerySuccess.getNewSkuName(), strA));
                return;
            }
            if (event instanceof StoreGooglePlayPurchases$Event$PurchaseQueryFailure) {
                StoreGooglePlayPurchases$Event$PurchaseQueryFailure storeGooglePlayPurchases$Event$PurchaseQueryFailure = (StoreGooglePlayPurchases$Event$PurchaseQueryFailure) event;
                AnalyticsTracker.paymentFlowFailed$default(AnalyticsTracker.INSTANCE, this.locationTrait, Traits$Subscription.Companion.withGatewayPlanId(storeGooglePlayPurchases$Event$PurchaseQueryFailure.getNewSkuName()), null, null, 12, null);
                AppLog appLog = AppLog.g;
                StringBuilder sbU = a.U("Purchase query failure. ");
                sbU.append(storeGooglePlayPurchases$Event$PurchaseQueryFailure.getNewSkuName());
                Logger.e$default(appLog, sbU.toString(), new Exception(), null, 4, null);
                this.eventSubject.k.onNext(new ChoosePlanViewModel$Event$ErrorSkuPurchase(2131887073));
            }
        }
    }

    private final void handleStoreState(ChoosePlanViewModel$StoreState storeState) {
        ChoosePlanViewModel$ViewState choosePlanViewModel$ViewState$Loaded;
        if ((storeState.getPurchasesState() instanceof StoreGooglePlayPurchases$State$Loaded) && (storeState.getSkuDetailsState() instanceof StoreGooglePlaySkuDetails$State$Loaded) && (storeState.getSubscriptionsState() instanceof StoreSubscriptions$SubscriptionsState$Loaded)) {
            List<WidgetChoosePlanAdapter$Item> currentPlanItems = getCurrentPlanItems(((StoreGooglePlaySkuDetails$State$Loaded) storeState.getSkuDetailsState()).getSkuDetails());
            List itemsForViewType$default = getItemsForViewType$default(this, this.viewType, ((StoreGooglePlaySkuDetails$State$Loaded) storeState.getSkuDetailsState()).getSkuDetails(), null, 4, null);
            choosePlanViewModel$ViewState$Loaded = new ChoosePlanViewModel$ViewState$Loaded(storeState.getPurchasesQueryState(), u.filterNotNull(u.plus((Collection) currentPlanItems, (Iterable) itemsForViewType$default)), ((StoreGooglePlaySkuDetails$State$Loaded) storeState.getSkuDetailsState()).getSkuDetails(), ((StoreGooglePlayPurchases$State$Loaded) storeState.getPurchasesState()).getPurchases(), ((StoreSubscriptions$SubscriptionsState$Loaded) storeState.getSubscriptionsState()).getSubscriptions(), itemsForViewType$default.isEmpty());
        } else {
            choosePlanViewModel$ViewState$Loaded = ChoosePlanViewModel$ViewState$Loading.INSTANCE;
        }
        updateViewState(choosePlanViewModel$ViewState$Loaded);
    }

    public final void buy(GooglePlaySku sku, String oldSkuName, Traits$Location locationTrait, String fromStep) throws NoSuchAlgorithmException {
        m.checkNotNullParameter(sku, "sku");
        m.checkNotNullParameter(locationTrait, "locationTrait");
        m.checkNotNullParameter(fromStep, "fromStep");
        ChoosePlanViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChoosePlanViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        ChoosePlanViewModel$ViewState$Loaded choosePlanViewModel$ViewState$Loaded = (ChoosePlanViewModel$ViewState$Loaded) viewState;
        if (choosePlanViewModel$ViewState$Loaded != null) {
            Map<String, SkuDetails> skuDetails = choosePlanViewModel$ViewState$Loaded.getSkuDetails();
            SkuDetails skuDetails2 = skuDetails.get(sku.getSkuName());
            SkuDetails skuDetails3 = skuDetails.get(oldSkuName);
            Traits$Subscription traits$SubscriptionWithGatewayPlanId = Traits$Subscription.Companion.withGatewayPlanId(sku.getSkuName());
            this.locationTrait = locationTrait;
            if (skuDetails2 == null || (oldSkuName != null && skuDetails3 == null)) {
                AnalyticsTracker.paymentFlowFailed$default(AnalyticsTracker.INSTANCE, locationTrait, traits$SubscriptionWithGatewayPlanId, null, null, 12, null);
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
                this.eventSubject.k.onNext(new ChoosePlanViewModel$Event$ErrorSkuPurchase(2131887074));
                return;
            }
            BillingFlowParams$a billingFlowParams$a = new BillingFlowParams$a();
            ArrayList<SkuDetails> arrayList = new ArrayList<>();
            arrayList.add(skuDetails2);
            billingFlowParams$a.d = arrayList;
            m.checkNotNullExpressionValue(billingFlowParams$a, "BillingFlowParams.newBui…SkuDetails(newSkuDetails)");
            if (oldSkuName != null && skuDetails3 != null && (!m.areEqual(sku.getSkuName(), oldSkuName))) {
                PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
                Purchase purchaseFindPurchaseForSkuName = premiumUtils.findPurchaseForSkuName(choosePlanViewModel$ViewState$Loaded.getPurchases(), oldSkuName);
                if (purchaseFindPurchaseForSkuName == null) {
                    AnalyticsTracker.paymentFlowFailed$default(AnalyticsTracker.INSTANCE, locationTrait, traits$SubscriptionWithGatewayPlanId, null, null, 12, null);
                    AppLog appLog2 = AppLog.g;
                    StringBuilder sbY = a.Y("Subscription without matching purchase. oldSkuName: ", oldSkuName, "; skuName: ");
                    sbY.append(sku.getSkuName());
                    Logger.e$default(appLog2, sbY.toString(), new Exception(), null, 4, null);
                    this.eventSubject.k.onNext(new ChoosePlanViewModel$Event$ErrorSkuPurchase(2131887073));
                    return;
                }
                int prorationMode = getProrationMode(skuDetails3, skuDetails2);
                c cVar = new c();
                m.checkNotNullExpressionValue(cVar, "BillingFlowParams.Subscr…UpdateParams.newBuilder()");
                String strA = purchaseFindPurchaseForSkuName.a();
                cVar.a = strA;
                cVar.f449b = prorationMode;
                if (TextUtils.isEmpty(strA) && TextUtils.isEmpty(null)) {
                    throw new IllegalArgumentException("Old SKU purchase token/id must be provided.");
                }
                String str = cVar.a;
                int i = cVar.f449b;
                billingFlowParams$a.f2002b = str;
                billingFlowParams$a.c = i;
                if (prorationMode == 4) {
                    ModelSubscription modelSubscriptionFindSubscriptionForSku = premiumUtils.findSubscriptionForSku(choosePlanViewModel$ViewState$Loaded.getSubscriptions(), oldSkuName);
                    String id2 = modelSubscriptionFindSubscriptionForSku != null ? modelSubscriptionFindSubscriptionForSku.getId() : null;
                    if (id2 == null) {
                        AnalyticsTracker.paymentFlowFailed$default(AnalyticsTracker.INSTANCE, locationTrait, traits$SubscriptionWithGatewayPlanId, null, null, 12, null);
                        AppLog appLog3 = AppLog.g;
                        StringBuilder sbY2 = a.Y("No premium subscription for downgrade found. oldSkuName: ", oldSkuName, "; skuName: ");
                        sbY2.append(sku.getSkuName());
                        Logger.e$default(appLog3, sbY2.toString(), new Exception(), null, 4, null);
                        this.eventSubject.k.onNext(new ChoosePlanViewModel$Event$ErrorSkuPurchase(2131887073));
                        return;
                    }
                    StoreGooglePlayPurchases googlePlayPurchases = StoreStream.Companion.getGooglePlayPurchases();
                    String strA2 = purchaseFindPurchaseForSkuName.a();
                    m.checkNotNullExpressionValue(strA2, "purchase.purchaseToken");
                    googlePlayPurchases.updatePendingDowngrade(new PendingDowngrade(strA2, id2, sku.getSkuName()));
                }
            }
            String obfuscatedUserId = UserUtils.INSTANCE.getObfuscatedUserId(Long.valueOf(StoreStream.Companion.getUsers().getMe().getId()));
            if (obfuscatedUserId != null) {
                billingFlowParams$a.a = obfuscatedUserId;
            }
            AnalyticsTracker.paymentFlowStep$default(AnalyticsTracker.INSTANCE, locationTrait, traits$SubscriptionWithGatewayPlanId, "external_payment", fromStep, null, null, 48, null);
            PublishSubject<ChoosePlanViewModel$Event> publishSubject = this.eventSubject;
            BillingFlowParams billingFlowParamsA = billingFlowParams$a.a();
            m.checkNotNullExpressionValue(billingFlowParamsA, "builder.build()");
            publishSubject.k.onNext(new ChoosePlanViewModel$Event$StartSkuPurchase(billingFlowParamsA));
        }
    }

    public final Observable<ChoosePlanViewModel$Event> observeEvents() {
        PublishSubject<ChoosePlanViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChoosePlanViewModel(WidgetChoosePlan$ViewType widgetChoosePlan$ViewType, String str, Observable<ChoosePlanViewModel$StoreState> observable) {
        super(ChoosePlanViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(widgetChoosePlan$ViewType, "viewType");
        m.checkNotNullParameter(observable, "storeObservable");
        this.viewType = widgetChoosePlan$ViewType;
        this.oldSkuName = str;
        this.eventSubject = PublishSubject.k0();
        fetchData();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ChoosePlanViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ChoosePlanViewModel$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.Companion.getGooglePlayPurchases().observeEvents(), this, null, 2, null), ChoosePlanViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ChoosePlanViewModel$2(this), 62, (Object) null);
    }
}
