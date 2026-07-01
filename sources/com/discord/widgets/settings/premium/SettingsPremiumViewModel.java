package com.discord.widgets.settings.premium;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.stores.StoreEntitlements;
import com.discord.stores.StoreEntitlements$State;
import com.discord.stores.StoreEntitlements$State$Loaded;
import com.discord.stores.StoreGooglePlayPurchases$State;
import com.discord.stores.StoreGooglePlayPurchases$State$Loaded;
import com.discord.stores.StoreGooglePlaySkuDetails$State;
import com.discord.stores.StoreGooglePlaySkuDetails$State$Failure;
import com.discord.stores.StoreGooglePlaySkuDetails$State$Loaded;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreGuildBoost$State;
import com.discord.stores.StoreGuildBoost$State$Failure;
import com.discord.stores.StoreGuildBoost$State$Loaded;
import com.discord.stores.StorePaymentSources;
import com.discord.stores.StorePaymentSources$PaymentSourcesState;
import com.discord.stores.StorePaymentSources$PaymentSourcesState$Failure;
import com.discord.stores.StorePaymentSources$PaymentSourcesState$Loaded;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Failure;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Loaded;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.t;
import d0.t.n;
import d0.t.n0;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsPremiumViewModel extends d0<SettingsPremiumViewModel$ViewState> {
    public static final SettingsPremiumViewModel$Companion Companion = new SettingsPremiumViewModel$Companion(null);
    private final PublishSubject<SettingsPremiumViewModel$Event> eventSubject;
    private final RestAPI restAPI;
    private final StoreEntitlements storeEntitlements;
    private final StoreGuildBoost storeGuildBoost;
    private final StorePaymentSources storePaymentsSources;
    private final StoreSubscriptions storeSubscriptions;

    public SettingsPremiumViewModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SettingsPremiumViewModel(StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, StoreEntitlements storeEntitlements, StoreGuildBoost storeGuildBoost, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStores;
        StorePaymentSources paymentSources = (i & 1) != 0 ? StoreStream.Companion.getPaymentSources() : storePaymentSources;
        StoreSubscriptions subscriptions = (i & 2) != 0 ? StoreStream.Companion.getSubscriptions() : storeSubscriptions;
        StoreEntitlements entitlements = (i & 4) != 0 ? StoreStream.Companion.getEntitlements() : storeEntitlements;
        StoreGuildBoost guildBoosts = (i & 8) != 0 ? StoreStream.Companion.getGuildBoosts() : storeGuildBoost;
        RestAPI api = (i & 16) != 0 ? RestAPI.Companion.getApi() : restAPI;
        if ((i & 32) != 0) {
            SettingsPremiumViewModel$Companion settingsPremiumViewModel$Companion = Companion;
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observableAccess$observeStores = SettingsPremiumViewModel$Companion.access$observeStores(settingsPremiumViewModel$Companion, storeStream$Companion.getPaymentSources(), storeStream$Companion.getSubscriptions(), storeStream$Companion.getEntitlements(), storeStream$Companion.getGuildBoosts(), storeStream$Companion.getGooglePlaySkuDetails(), storeStream$Companion.getGooglePlayPurchases(), storeStream$Companion.getExperiments(), RestAPI.Companion.getApi());
        } else {
            observableAccess$observeStores = observable;
        }
        this(paymentSources, subscriptions, entitlements, guildBoosts, api, observableAccess$observeStores);
    }

    public static final /* synthetic */ void access$fetchData(SettingsPremiumViewModel settingsPremiumViewModel) {
        settingsPremiumViewModel.fetchData();
    }

    public static final /* synthetic */ void access$handleStoreState(SettingsPremiumViewModel settingsPremiumViewModel, SettingsPremiumViewModel$StoreState settingsPremiumViewModel$StoreState) {
        settingsPremiumViewModel.handleStoreState(settingsPremiumViewModel$StoreState);
    }

    public static final /* synthetic */ void access$onCancelError(SettingsPremiumViewModel settingsPremiumViewModel) {
        settingsPremiumViewModel.onCancelError();
    }

    private final void fetchData() {
        this.storePaymentsSources.fetchPaymentSources();
        this.storeSubscriptions.fetchSubscriptions();
        this.storeEntitlements.fetchMyEntitlementsForApplication(521842831262875670L);
        this.storeGuildBoost.fetchUserGuildBoostState();
        GooglePlayBillingManager.INSTANCE.querySkuDetails();
    }

    private final int getPastDueGracePeriodDays(ModelSubscription sub) {
        if (sub != null && !sub.isMobileManaged()) {
            String paymentSourceId = sub.getPaymentSourceId();
            if (!(paymentSourceId == null || t.isBlank(paymentSourceId))) {
                return 7;
            }
        }
        return 3;
    }

    private final void handleStoreState(SettingsPremiumViewModel$StoreState storeState) {
        SettingsPremiumViewModel$ViewState settingsPremiumViewModel$ViewState$Loaded;
        StorePaymentSources$PaymentSourcesState paymentSourcesState = storeState.getPaymentSourcesState();
        StoreSubscriptions$SubscriptionsState subscriptionsState = storeState.getSubscriptionsState();
        StoreEntitlements$State entitlementState = storeState.getEntitlementState();
        StoreGuildBoost$State guildBoostState = storeState.getGuildBoostState();
        SettingsPremiumViewModel$InvoicePreviewFetch renewalInvoicePreviewFetch = storeState.getRenewalInvoicePreviewFetch();
        SettingsPremiumViewModel$InvoicePreviewFetch currentInvoicePreviewFetch = storeState.getCurrentInvoicePreviewFetch();
        StoreGooglePlaySkuDetails$State skuDetailsState = storeState.getSkuDetailsState();
        StoreGooglePlayPurchases$State purchaseState = storeState.getPurchaseState();
        if ((paymentSourcesState instanceof StorePaymentSources$PaymentSourcesState$Loaded) && (subscriptionsState instanceof StoreSubscriptions$SubscriptionsState$Loaded) && (entitlementState instanceof StoreEntitlements$State$Loaded) && (guildBoostState instanceof StoreGuildBoost$State$Loaded) && (renewalInvoicePreviewFetch instanceof SettingsPremiumViewModel$InvoicePreviewFetch$Invoice) && (currentInvoicePreviewFetch instanceof SettingsPremiumViewModel$InvoicePreviewFetch$Invoice) && (skuDetailsState instanceof StoreGooglePlaySkuDetails$State$Loaded) && (purchaseState instanceof StoreGooglePlayPurchases$State$Loaded)) {
            ModelSubscription premiumSubscription = ((StoreSubscriptions$SubscriptionsState$Loaded) subscriptionsState).getPremiumSubscription();
            boolean zHasAnyOfPlans = premiumSubscription != null ? premiumSubscription.hasAnyOfPlans(n0.setOf((Object[]) new Long[]{Long.valueOf(SubscriptionPlanType.PREMIUM_GUILD_MONTH.getPlanId()), Long.valueOf(SubscriptionPlanType.PREMIUM_GUILD_3_MONTH.getPlanId()), Long.valueOf(SubscriptionPlanType.PREMIUM_GUILD_6_MONTH.getPlanId()), Long.valueOf(SubscriptionPlanType.PREMIUM_GUILD_YEAR.getPlanId())})) : false;
            List<ModelPaymentSource> paymentSources = ((StorePaymentSources$PaymentSourcesState$Loaded) paymentSourcesState).getPaymentSources();
            List<ModelEntitlement> listEmptyList = ((StoreEntitlements$State$Loaded) entitlementState).getOwnedEntitlements().get(521842831262875670L);
            if (listEmptyList == null) {
                listEmptyList = n.emptyList();
            }
            settingsPremiumViewModel$ViewState$Loaded = new SettingsPremiumViewModel$ViewState$Loaded(premiumSubscription, paymentSources, false, listEmptyList, ((StoreGuildBoost$State$Loaded) guildBoostState).getBoostSlotMap(), zHasAnyOfPlans, ((SettingsPremiumViewModel$InvoicePreviewFetch$Invoice) renewalInvoicePreviewFetch).getModelInvoicePreview(), ((SettingsPremiumViewModel$InvoicePreviewFetch$Invoice) currentInvoicePreviewFetch).getModelInvoicePreview(), ((StoreGooglePlaySkuDetails$State$Loaded) skuDetailsState).getSkuDetails(), ((StoreGooglePlayPurchases$State$Loaded) purchaseState).getPurchases(), getPastDueGracePeriodDays(premiumSubscription));
        } else {
            settingsPremiumViewModel$ViewState$Loaded = ((paymentSourcesState instanceof StorePaymentSources$PaymentSourcesState$Failure) || (subscriptionsState instanceof StoreSubscriptions$SubscriptionsState$Failure) || (guildBoostState instanceof StoreGuildBoost$State$Failure) || (renewalInvoicePreviewFetch instanceof SettingsPremiumViewModel$InvoicePreviewFetch$Error) || (skuDetailsState instanceof StoreGooglePlaySkuDetails$State$Failure)) ? SettingsPremiumViewModel$ViewState$Failure.INSTANCE : SettingsPremiumViewModel$ViewState$Loading.INSTANCE;
        }
        updateViewState(settingsPremiumViewModel$ViewState$Loaded);
    }

    private final void markBusy() {
        SettingsPremiumViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsPremiumViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsPremiumViewModel$ViewState$Loaded settingsPremiumViewModel$ViewState$Loaded = (SettingsPremiumViewModel$ViewState$Loaded) viewState;
        if (settingsPremiumViewModel$ViewState$Loaded != null) {
            updateViewState(SettingsPremiumViewModel$ViewState$Loaded.copy$default(settingsPremiumViewModel$ViewState$Loaded, null, null, true, null, null, false, null, null, null, null, 0, 2043, null));
        }
    }

    private final void onCancelError() {
        if (getViewState() instanceof SettingsPremiumViewModel$ViewState$Loaded) {
            PublishSubject<SettingsPremiumViewModel$Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new SettingsPremiumViewModel$Event$ErrorToast(2131893944));
        }
    }

    @MainThread
    public final void cancelSubscription() {
        ModelSubscription premiumSubscription;
        SettingsPremiumViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsPremiumViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsPremiumViewModel$ViewState$Loaded settingsPremiumViewModel$ViewState$Loaded = (SettingsPremiumViewModel$ViewState$Loaded) viewState;
        if (settingsPremiumViewModel$ViewState$Loaded == null || (premiumSubscription = settingsPremiumViewModel$ViewState$Loaded.getPremiumSubscription()) == null) {
            return;
        }
        markBusy();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.deleteSubscription(premiumSubscription.getId()), false, 1, null), this, null, 2, null), SettingsPremiumViewModel.class, (Context) null, (Function1) null, new SettingsPremiumViewModel$cancelSubscription$2(this), (Function0) null, (Function0) null, new SettingsPremiumViewModel$cancelSubscription$1(this), 54, (Object) null);
    }

    @MainThread
    public final Observable<SettingsPremiumViewModel$Event> getEventSubject() {
        PublishSubject<SettingsPremiumViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onRetryClicked() {
        fetchData();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsPremiumViewModel(StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, StoreEntitlements storeEntitlements, StoreGuildBoost storeGuildBoost, RestAPI restAPI, Observable<SettingsPremiumViewModel$StoreState> observable) {
        super(SettingsPremiumViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(storePaymentSources, "storePaymentsSources");
        m.checkNotNullParameter(storeSubscriptions, "storeSubscriptions");
        m.checkNotNullParameter(storeEntitlements, "storeEntitlements");
        m.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observable, "storeObservable");
        this.storePaymentsSources = storePaymentSources;
        this.storeSubscriptions = storeSubscriptions;
        this.storeEntitlements = storeEntitlements;
        this.storeGuildBoost = storeGuildBoost;
        this.restAPI = restAPI;
        this.eventSubject = PublishSubject.k0();
        fetchData();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), SettingsPremiumViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new SettingsPremiumViewModel$1(this), 62, (Object) null);
    }
}
