package com.discord.widgets.settings.premium;

import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.C5419R;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.billing.ModelInvoicePreview;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreEntitlements;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StorePaymentSources;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.settings.premium.SettingsPremiumViewModel;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.EnumC12610d;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func7;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsPremiumViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final RestAPI restAPI;
    private final StoreEntitlements storeEntitlements;
    private final StoreGuildBoost storeGuildBoost;
    private final StorePaymentSources storePaymentsSources;
    private final StoreSubscriptions storeSubscriptions;

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsPremiumViewModel$1 */
    /* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
    public static final class C98861 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C98861() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            SettingsPremiumViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<SubscriptionAndInvoice> getSubscriptionsAndInvoicePreview(RestAPI restAPI, final StoreSubscriptions.SubscriptionsState state, boolean applyEntitlements) {
            String id2;
            if (!(state instanceof StoreSubscriptions.SubscriptionsState.Loaded)) {
                Observable observable = EnumC12610d.f26760k;
                C12238m.checkNotNullExpressionValue(observable, "Observable.never()");
                return observable;
            }
            ModelSubscription premiumSubscription = ((StoreSubscriptions.SubscriptionsState.Loaded) state).getPremiumSubscription();
            if (premiumSubscription == null || (id2 = premiumSubscription.getId()) == null) {
                C12721k c12721k = new C12721k(new SubscriptionAndInvoice(state, new InvoicePreviewFetch.Invoice(null)));
                C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(\n       …nvoice(null))\n          )");
                return c12721k;
            }
            Observable<SubscriptionAndInvoice> observableM11087M = ObservableExtensionsKt.restSubscribeOn$default(restAPI.getInvoicePreview(new RestAPIParams.InvoicePreviewBody(id2, true, applyEntitlements && !premiumSubscription.isGoogleSubscription())), false, 1, null).m11083G(new InterfaceC12589b<ModelInvoicePreview, SubscriptionAndInvoice>() { // from class: com.discord.widgets.settings.premium.SettingsPremiumViewModel$Companion$getSubscriptionsAndInvoicePreview$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final SettingsPremiumViewModel.SubscriptionAndInvoice call(ModelInvoicePreview modelInvoicePreview) {
                    return new SettingsPremiumViewModel.SubscriptionAndInvoice(state, new SettingsPremiumViewModel.InvoicePreviewFetch.Invoice(modelInvoicePreview));
                }
            }).m11087M(new InterfaceC12589b<Throwable, SubscriptionAndInvoice>() { // from class: com.discord.widgets.settings.premium.SettingsPremiumViewModel$Companion$getSubscriptionsAndInvoicePreview$2
                @Override // p637j0.p641k.InterfaceC12589b
                public final SettingsPremiumViewModel.SubscriptionAndInvoice call(Throwable th) {
                    return new SettingsPremiumViewModel.SubscriptionAndInvoice(state, SettingsPremiumViewModel.InvoicePreviewFetch.Error.INSTANCE);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11087M, "restAPI\n              .g…ch.Error)\n              }");
            return observableM11087M;
        }

        private final Observable<StoreState> observeStores(StorePaymentSources storePaymentsSources, StoreSubscriptions storeSubscriptions, StoreEntitlements storeEntitlements, StoreGuildBoost storeGuildBoost, StoreGooglePlaySkuDetails storeGooglePlaySkuDetails, StoreGooglePlayPurchases storeGooglePlayPurchases, StoreExperiments storeExperiments, final RestAPI restAPI) {
            Observable<StoreState> observableM11069e = Observable.m11069e(storePaymentsSources.observePaymentSourcesState(), storeSubscriptions.observeSubscriptions().m11099Y(new InterfaceC12589b<StoreSubscriptions.SubscriptionsState, Observable<? extends SubscriptionAndInvoice>>() { // from class: com.discord.widgets.settings.premium.SettingsPremiumViewModel$Companion$observeStores$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends SettingsPremiumViewModel.SubscriptionAndInvoice> call(StoreSubscriptions.SubscriptionsState subscriptionsState) {
                    SettingsPremiumViewModel.Companion companion = SettingsPremiumViewModel.INSTANCE;
                    RestAPI restAPI2 = restAPI;
                    C12238m.checkNotNullExpressionValue(subscriptionsState, "state");
                    return companion.getSubscriptionsAndInvoicePreview(restAPI2, subscriptionsState, true);
                }
            }), storeSubscriptions.observeSubscriptions().m11099Y(new InterfaceC12589b<StoreSubscriptions.SubscriptionsState, Observable<? extends SubscriptionAndInvoice>>() { // from class: com.discord.widgets.settings.premium.SettingsPremiumViewModel$Companion$observeStores$2
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends SettingsPremiumViewModel.SubscriptionAndInvoice> call(StoreSubscriptions.SubscriptionsState subscriptionsState) {
                    SettingsPremiumViewModel.Companion companion = SettingsPremiumViewModel.INSTANCE;
                    RestAPI restAPI2 = restAPI;
                    C12238m.checkNotNullExpressionValue(subscriptionsState, "state");
                    return companion.getSubscriptionsAndInvoicePreview(restAPI2, subscriptionsState, false);
                }
            }), storeEntitlements.observeEntitlementState(), StoreGuildBoost.observeGuildBoostState$default(storeGuildBoost, null, 1, null), storeGooglePlaySkuDetails.observeState(), storeGooglePlayPurchases.observeState(), new Func7<StorePaymentSources.PaymentSourcesState, SubscriptionAndInvoice, SubscriptionAndInvoice, StoreEntitlements.State, StoreGuildBoost.State, StoreGooglePlaySkuDetails.State, StoreGooglePlayPurchases.State, StoreState>() { // from class: com.discord.widgets.settings.premium.SettingsPremiumViewModel$Companion$observeStores$3
                @Override // p658rx.functions.Func7
                public final SettingsPremiumViewModel.StoreState call(StorePaymentSources.PaymentSourcesState paymentSourcesState, SettingsPremiumViewModel.SubscriptionAndInvoice subscriptionAndInvoice, SettingsPremiumViewModel.SubscriptionAndInvoice subscriptionAndInvoice2, StoreEntitlements.State state, StoreGuildBoost.State state2, StoreGooglePlaySkuDetails.State state3, StoreGooglePlayPurchases.State state4) {
                    C12238m.checkNotNullExpressionValue(paymentSourcesState, "paymentSourcesState");
                    StoreSubscriptions.SubscriptionsState subscriptionsState = subscriptionAndInvoice.getSubscriptionsState();
                    C12238m.checkNotNullExpressionValue(state, "entitlementsState");
                    C12238m.checkNotNullExpressionValue(state2, "guildSubscriptionState");
                    SettingsPremiumViewModel.InvoicePreviewFetch invoicePreviewFetch = subscriptionAndInvoice.getInvoicePreviewFetch();
                    SettingsPremiumViewModel.InvoicePreviewFetch invoicePreviewFetch2 = subscriptionAndInvoice2.getInvoicePreviewFetch();
                    C12238m.checkNotNullExpressionValue(state3, "skuDetailsState");
                    C12238m.checkNotNullExpressionValue(state4, "purchaseState");
                    return new SettingsPremiumViewModel.StoreState(paymentSourcesState, subscriptionsState, state, state2, invoicePreviewFetch, invoicePreviewFetch2, state3, state4);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11069e, "Observable\n          .co…            )\n          }");
            return observableM11069e;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
        public static final /* data */ class ErrorToast extends Event {
            private final int errorStringResId;

            public ErrorToast(@StringRes int i) {
                super(null);
                this.errorStringResId = i;
            }

            public static /* synthetic */ ErrorToast copy$default(ErrorToast errorToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = errorToast.errorStringResId;
                }
                return errorToast.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getErrorStringResId() {
                return this.errorStringResId;
            }

            public final ErrorToast copy(@StringRes int errorStringResId) {
                return new ErrorToast(errorStringResId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ErrorToast) && this.errorStringResId == ((ErrorToast) other).errorStringResId;
                }
                return true;
            }

            public final int getErrorStringResId() {
                return this.errorStringResId;
            }

            public int hashCode() {
                return this.errorStringResId;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("ErrorToast(errorStringResId="), this.errorStringResId, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
    public static abstract class InvoicePreviewFetch {

        /* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
        public static final class Error extends InvoicePreviewFetch {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
        public static final /* data */ class Invoice extends InvoicePreviewFetch {
            private final ModelInvoicePreview modelInvoicePreview;

            public Invoice(ModelInvoicePreview modelInvoicePreview) {
                super(null);
                this.modelInvoicePreview = modelInvoicePreview;
            }

            public static /* synthetic */ Invoice copy$default(Invoice invoice, ModelInvoicePreview modelInvoicePreview, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvoicePreview = invoice.modelInvoicePreview;
                }
                return invoice.copy(modelInvoicePreview);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelInvoicePreview getModelInvoicePreview() {
                return this.modelInvoicePreview;
            }

            public final Invoice copy(ModelInvoicePreview modelInvoicePreview) {
                return new Invoice(modelInvoicePreview);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Invoice) && C12238m.areEqual(this.modelInvoicePreview, ((Invoice) other).modelInvoicePreview);
                }
                return true;
            }

            public final ModelInvoicePreview getModelInvoicePreview() {
                return this.modelInvoicePreview;
            }

            public int hashCode() {
                ModelInvoicePreview modelInvoicePreview = this.modelInvoicePreview;
                if (modelInvoicePreview != null) {
                    return modelInvoicePreview.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Invoice(modelInvoicePreview=");
                sbM833U.append(this.modelInvoicePreview);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private InvoicePreviewFetch() {
        }

        public /* synthetic */ InvoicePreviewFetch(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
    public static final /* data */ class StoreState {
        private final InvoicePreviewFetch currentInvoicePreviewFetch;
        private final StoreEntitlements.State entitlementState;
        private final StoreGuildBoost.State guildBoostState;
        private final StorePaymentSources.PaymentSourcesState paymentSourcesState;
        private final StoreGooglePlayPurchases.State purchaseState;
        private final InvoicePreviewFetch renewalInvoicePreviewFetch;
        private final StoreGooglePlaySkuDetails.State skuDetailsState;
        private final StoreSubscriptions.SubscriptionsState subscriptionsState;

        public StoreState(StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState, StoreEntitlements.State state, StoreGuildBoost.State state2, InvoicePreviewFetch invoicePreviewFetch, InvoicePreviewFetch invoicePreviewFetch2, StoreGooglePlaySkuDetails.State state3, StoreGooglePlayPurchases.State state4) {
            C12238m.checkNotNullParameter(paymentSourcesState, "paymentSourcesState");
            C12238m.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            C12238m.checkNotNullParameter(state, "entitlementState");
            C12238m.checkNotNullParameter(state2, "guildBoostState");
            C12238m.checkNotNullParameter(invoicePreviewFetch, "renewalInvoicePreviewFetch");
            C12238m.checkNotNullParameter(invoicePreviewFetch2, "currentInvoicePreviewFetch");
            C12238m.checkNotNullParameter(state3, "skuDetailsState");
            C12238m.checkNotNullParameter(state4, "purchaseState");
            this.paymentSourcesState = paymentSourcesState;
            this.subscriptionsState = subscriptionsState;
            this.entitlementState = state;
            this.guildBoostState = state2;
            this.renewalInvoicePreviewFetch = invoicePreviewFetch;
            this.currentInvoicePreviewFetch = invoicePreviewFetch2;
            this.skuDetailsState = state3;
            this.purchaseState = state4;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StorePaymentSources.PaymentSourcesState getPaymentSourcesState() {
            return this.paymentSourcesState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final StoreEntitlements.State getEntitlementState() {
            return this.entitlementState;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final InvoicePreviewFetch getRenewalInvoicePreviewFetch() {
            return this.renewalInvoicePreviewFetch;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final InvoicePreviewFetch getCurrentInvoicePreviewFetch() {
            return this.currentInvoicePreviewFetch;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final StoreGooglePlaySkuDetails.State getSkuDetailsState() {
            return this.skuDetailsState;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final StoreGooglePlayPurchases.State getPurchaseState() {
            return this.purchaseState;
        }

        public final StoreState copy(StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState, StoreEntitlements.State entitlementState, StoreGuildBoost.State guildBoostState, InvoicePreviewFetch renewalInvoicePreviewFetch, InvoicePreviewFetch currentInvoicePreviewFetch, StoreGooglePlaySkuDetails.State skuDetailsState, StoreGooglePlayPurchases.State purchaseState) {
            C12238m.checkNotNullParameter(paymentSourcesState, "paymentSourcesState");
            C12238m.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            C12238m.checkNotNullParameter(entitlementState, "entitlementState");
            C12238m.checkNotNullParameter(guildBoostState, "guildBoostState");
            C12238m.checkNotNullParameter(renewalInvoicePreviewFetch, "renewalInvoicePreviewFetch");
            C12238m.checkNotNullParameter(currentInvoicePreviewFetch, "currentInvoicePreviewFetch");
            C12238m.checkNotNullParameter(skuDetailsState, "skuDetailsState");
            C12238m.checkNotNullParameter(purchaseState, "purchaseState");
            return new StoreState(paymentSourcesState, subscriptionsState, entitlementState, guildBoostState, renewalInvoicePreviewFetch, currentInvoicePreviewFetch, skuDetailsState, purchaseState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.paymentSourcesState, storeState.paymentSourcesState) && C12238m.areEqual(this.subscriptionsState, storeState.subscriptionsState) && C12238m.areEqual(this.entitlementState, storeState.entitlementState) && C12238m.areEqual(this.guildBoostState, storeState.guildBoostState) && C12238m.areEqual(this.renewalInvoicePreviewFetch, storeState.renewalInvoicePreviewFetch) && C12238m.areEqual(this.currentInvoicePreviewFetch, storeState.currentInvoicePreviewFetch) && C12238m.areEqual(this.skuDetailsState, storeState.skuDetailsState) && C12238m.areEqual(this.purchaseState, storeState.purchaseState);
        }

        public final InvoicePreviewFetch getCurrentInvoicePreviewFetch() {
            return this.currentInvoicePreviewFetch;
        }

        public final StoreEntitlements.State getEntitlementState() {
            return this.entitlementState;
        }

        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        public final StorePaymentSources.PaymentSourcesState getPaymentSourcesState() {
            return this.paymentSourcesState;
        }

        public final StoreGooglePlayPurchases.State getPurchaseState() {
            return this.purchaseState;
        }

        public final InvoicePreviewFetch getRenewalInvoicePreviewFetch() {
            return this.renewalInvoicePreviewFetch;
        }

        public final StoreGooglePlaySkuDetails.State getSkuDetailsState() {
            return this.skuDetailsState;
        }

        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        public int hashCode() {
            StorePaymentSources.PaymentSourcesState paymentSourcesState = this.paymentSourcesState;
            int iHashCode = (paymentSourcesState != null ? paymentSourcesState.hashCode() : 0) * 31;
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.subscriptionsState;
            int iHashCode2 = (iHashCode + (subscriptionsState != null ? subscriptionsState.hashCode() : 0)) * 31;
            StoreEntitlements.State state = this.entitlementState;
            int iHashCode3 = (iHashCode2 + (state != null ? state.hashCode() : 0)) * 31;
            StoreGuildBoost.State state2 = this.guildBoostState;
            int iHashCode4 = (iHashCode3 + (state2 != null ? state2.hashCode() : 0)) * 31;
            InvoicePreviewFetch invoicePreviewFetch = this.renewalInvoicePreviewFetch;
            int iHashCode5 = (iHashCode4 + (invoicePreviewFetch != null ? invoicePreviewFetch.hashCode() : 0)) * 31;
            InvoicePreviewFetch invoicePreviewFetch2 = this.currentInvoicePreviewFetch;
            int iHashCode6 = (iHashCode5 + (invoicePreviewFetch2 != null ? invoicePreviewFetch2.hashCode() : 0)) * 31;
            StoreGooglePlaySkuDetails.State state3 = this.skuDetailsState;
            int iHashCode7 = (iHashCode6 + (state3 != null ? state3.hashCode() : 0)) * 31;
            StoreGooglePlayPurchases.State state4 = this.purchaseState;
            return iHashCode7 + (state4 != null ? state4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(paymentSourcesState=");
            sbM833U.append(this.paymentSourcesState);
            sbM833U.append(", subscriptionsState=");
            sbM833U.append(this.subscriptionsState);
            sbM833U.append(", entitlementState=");
            sbM833U.append(this.entitlementState);
            sbM833U.append(", guildBoostState=");
            sbM833U.append(this.guildBoostState);
            sbM833U.append(", renewalInvoicePreviewFetch=");
            sbM833U.append(this.renewalInvoicePreviewFetch);
            sbM833U.append(", currentInvoicePreviewFetch=");
            sbM833U.append(this.currentInvoicePreviewFetch);
            sbM833U.append(", skuDetailsState=");
            sbM833U.append(this.skuDetailsState);
            sbM833U.append(", purchaseState=");
            sbM833U.append(this.purchaseState);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
    public static final /* data */ class SubscriptionAndInvoice {
        private final InvoicePreviewFetch invoicePreviewFetch;
        private final StoreSubscriptions.SubscriptionsState subscriptionsState;

        public SubscriptionAndInvoice(StoreSubscriptions.SubscriptionsState subscriptionsState, InvoicePreviewFetch invoicePreviewFetch) {
            C12238m.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            C12238m.checkNotNullParameter(invoicePreviewFetch, "invoicePreviewFetch");
            this.subscriptionsState = subscriptionsState;
            this.invoicePreviewFetch = invoicePreviewFetch;
        }

        public static /* synthetic */ SubscriptionAndInvoice copy$default(SubscriptionAndInvoice subscriptionAndInvoice, StoreSubscriptions.SubscriptionsState subscriptionsState, InvoicePreviewFetch invoicePreviewFetch, int i, Object obj) {
            if ((i & 1) != 0) {
                subscriptionsState = subscriptionAndInvoice.subscriptionsState;
            }
            if ((i & 2) != 0) {
                invoicePreviewFetch = subscriptionAndInvoice.invoicePreviewFetch;
            }
            return subscriptionAndInvoice.copy(subscriptionsState, invoicePreviewFetch);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final InvoicePreviewFetch getInvoicePreviewFetch() {
            return this.invoicePreviewFetch;
        }

        public final SubscriptionAndInvoice copy(StoreSubscriptions.SubscriptionsState subscriptionsState, InvoicePreviewFetch invoicePreviewFetch) {
            C12238m.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            C12238m.checkNotNullParameter(invoicePreviewFetch, "invoicePreviewFetch");
            return new SubscriptionAndInvoice(subscriptionsState, invoicePreviewFetch);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubscriptionAndInvoice)) {
                return false;
            }
            SubscriptionAndInvoice subscriptionAndInvoice = (SubscriptionAndInvoice) other;
            return C12238m.areEqual(this.subscriptionsState, subscriptionAndInvoice.subscriptionsState) && C12238m.areEqual(this.invoicePreviewFetch, subscriptionAndInvoice.invoicePreviewFetch);
        }

        public final InvoicePreviewFetch getInvoicePreviewFetch() {
            return this.invoicePreviewFetch;
        }

        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        public int hashCode() {
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.subscriptionsState;
            int iHashCode = (subscriptionsState != null ? subscriptionsState.hashCode() : 0) * 31;
            InvoicePreviewFetch invoicePreviewFetch = this.invoicePreviewFetch;
            return iHashCode + (invoicePreviewFetch != null ? invoicePreviewFetch.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("SubscriptionAndInvoice(subscriptionsState=");
            sbM833U.append(this.subscriptionsState);
            sbM833U.append(", invoicePreviewFetch=");
            sbM833U.append(this.invoicePreviewFetch);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
        public static final class Failure extends ViewState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final ModelInvoicePreview currentInvoicePreview;
            private final List<ModelEntitlement> entitlements;
            private final Map<Long, ModelGuildBoostSlot> guildSubscriptions;
            private final boolean hasAnyGuildBoosts;
            private final boolean isBusy;
            private final int pastDueGracePeriodDays;
            private final List<ModelPaymentSource> paymentSources;
            private final ModelSubscription premiumSubscription;
            private final List<Purchase> purchases;
            private final ModelInvoicePreview renewalInvoicePreview;
            private final Map<String, SkuDetails> skuDetails;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(ModelSubscription modelSubscription, List<? extends ModelPaymentSource> list, boolean z2, List<ModelEntitlement> list2, Map<Long, ModelGuildBoostSlot> map, boolean z3, ModelInvoicePreview modelInvoicePreview, ModelInvoicePreview modelInvoicePreview2, Map<String, ? extends SkuDetails> map2, List<? extends Purchase> list3, int i) {
                super(null);
                C12238m.checkNotNullParameter(list, "paymentSources");
                C12238m.checkNotNullParameter(list2, "entitlements");
                C12238m.checkNotNullParameter(map, "guildSubscriptions");
                C12238m.checkNotNullParameter(map2, "skuDetails");
                C12238m.checkNotNullParameter(list3, "purchases");
                this.premiumSubscription = modelSubscription;
                this.paymentSources = list;
                this.isBusy = z2;
                this.entitlements = list2;
                this.guildSubscriptions = map;
                this.hasAnyGuildBoosts = z3;
                this.renewalInvoicePreview = modelInvoicePreview;
                this.currentInvoicePreview = modelInvoicePreview2;
                this.skuDetails = map2;
                this.purchases = list3;
                this.pastDueGracePeriodDays = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, ModelSubscription modelSubscription, List list, boolean z2, List list2, Map map, boolean z3, ModelInvoicePreview modelInvoicePreview, ModelInvoicePreview modelInvoicePreview2, Map map2, List list3, int i, int i2, Object obj) {
                return loaded.copy((i2 & 1) != 0 ? loaded.premiumSubscription : modelSubscription, (i2 & 2) != 0 ? loaded.paymentSources : list, (i2 & 4) != 0 ? loaded.isBusy : z2, (i2 & 8) != 0 ? loaded.entitlements : list2, (i2 & 16) != 0 ? loaded.guildSubscriptions : map, (i2 & 32) != 0 ? loaded.hasAnyGuildBoosts : z3, (i2 & 64) != 0 ? loaded.renewalInvoicePreview : modelInvoicePreview, (i2 & 128) != 0 ? loaded.currentInvoicePreview : modelInvoicePreview2, (i2 & 256) != 0 ? loaded.skuDetails : map2, (i2 & 512) != 0 ? loaded.purchases : list3, (i2 & 1024) != 0 ? loaded.pastDueGracePeriodDays : i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelSubscription getPremiumSubscription() {
                return this.premiumSubscription;
            }

            public final List<Purchase> component10() {
                return this.purchases;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final int getPastDueGracePeriodDays() {
                return this.pastDueGracePeriodDays;
            }

            public final List<ModelPaymentSource> component2() {
                return this.paymentSources;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsBusy() {
                return this.isBusy;
            }

            public final List<ModelEntitlement> component4() {
                return this.entitlements;
            }

            public final Map<Long, ModelGuildBoostSlot> component5() {
                return this.guildSubscriptions;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getHasAnyGuildBoosts() {
                return this.hasAnyGuildBoosts;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final ModelInvoicePreview getRenewalInvoicePreview() {
                return this.renewalInvoicePreview;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final ModelInvoicePreview getCurrentInvoicePreview() {
                return this.currentInvoicePreview;
            }

            public final Map<String, SkuDetails> component9() {
                return this.skuDetails;
            }

            public final Loaded copy(ModelSubscription premiumSubscription, List<? extends ModelPaymentSource> paymentSources, boolean isBusy, List<ModelEntitlement> entitlements, Map<Long, ModelGuildBoostSlot> guildSubscriptions, boolean hasAnyGuildBoosts, ModelInvoicePreview renewalInvoicePreview, ModelInvoicePreview currentInvoicePreview, Map<String, ? extends SkuDetails> skuDetails, List<? extends Purchase> purchases, int pastDueGracePeriodDays) {
                C12238m.checkNotNullParameter(paymentSources, "paymentSources");
                C12238m.checkNotNullParameter(entitlements, "entitlements");
                C12238m.checkNotNullParameter(guildSubscriptions, "guildSubscriptions");
                C12238m.checkNotNullParameter(skuDetails, "skuDetails");
                C12238m.checkNotNullParameter(purchases, "purchases");
                return new Loaded(premiumSubscription, paymentSources, isBusy, entitlements, guildSubscriptions, hasAnyGuildBoosts, renewalInvoicePreview, currentInvoicePreview, skuDetails, purchases, pastDueGracePeriodDays);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.premiumSubscription, loaded.premiumSubscription) && C12238m.areEqual(this.paymentSources, loaded.paymentSources) && this.isBusy == loaded.isBusy && C12238m.areEqual(this.entitlements, loaded.entitlements) && C12238m.areEqual(this.guildSubscriptions, loaded.guildSubscriptions) && this.hasAnyGuildBoosts == loaded.hasAnyGuildBoosts && C12238m.areEqual(this.renewalInvoicePreview, loaded.renewalInvoicePreview) && C12238m.areEqual(this.currentInvoicePreview, loaded.currentInvoicePreview) && C12238m.areEqual(this.skuDetails, loaded.skuDetails) && C12238m.areEqual(this.purchases, loaded.purchases) && this.pastDueGracePeriodDays == loaded.pastDueGracePeriodDays;
            }

            public final ModelInvoicePreview getCurrentInvoicePreview() {
                return this.currentInvoicePreview;
            }

            public final List<ModelEntitlement> getEntitlements() {
                return this.entitlements;
            }

            public final Map<Long, ModelGuildBoostSlot> getGuildSubscriptions() {
                return this.guildSubscriptions;
            }

            public final boolean getHasAnyGuildBoosts() {
                return this.hasAnyGuildBoosts;
            }

            public final int getPastDueGracePeriodDays() {
                return this.pastDueGracePeriodDays;
            }

            public final List<ModelPaymentSource> getPaymentSources() {
                return this.paymentSources;
            }

            public final ModelSubscription getPremiumSubscription() {
                return this.premiumSubscription;
            }

            public final List<Purchase> getPurchases() {
                return this.purchases;
            }

            public final ModelInvoicePreview getRenewalInvoicePreview() {
                return this.renewalInvoicePreview;
            }

            public final Map<String, SkuDetails> getSkuDetails() {
                return this.skuDetails;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r2v27 */
            /* JADX WARN: Type inference failed for: r2v29 */
            /* JADX WARN: Type inference failed for: r2v4, types: [int] */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                ModelSubscription modelSubscription = this.premiumSubscription;
                int iHashCode = (modelSubscription != null ? modelSubscription.hashCode() : 0) * 31;
                List<ModelPaymentSource> list = this.paymentSources;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                boolean z2 = this.isBusy;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode2 + r2) * 31;
                List<ModelEntitlement> list2 = this.entitlements;
                int iHashCode3 = (i + (list2 != null ? list2.hashCode() : 0)) * 31;
                Map<Long, ModelGuildBoostSlot> map = this.guildSubscriptions;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                boolean z3 = this.hasAnyGuildBoosts;
                int i2 = (iHashCode4 + (z3 ? 1 : z3)) * 31;
                ModelInvoicePreview modelInvoicePreview = this.renewalInvoicePreview;
                int iHashCode5 = (i2 + (modelInvoicePreview != null ? modelInvoicePreview.hashCode() : 0)) * 31;
                ModelInvoicePreview modelInvoicePreview2 = this.currentInvoicePreview;
                int iHashCode6 = (iHashCode5 + (modelInvoicePreview2 != null ? modelInvoicePreview2.hashCode() : 0)) * 31;
                Map<String, SkuDetails> map2 = this.skuDetails;
                int iHashCode7 = (iHashCode6 + (map2 != null ? map2.hashCode() : 0)) * 31;
                List<Purchase> list3 = this.purchases;
                return ((iHashCode7 + (list3 != null ? list3.hashCode() : 0)) * 31) + this.pastDueGracePeriodDays;
            }

            public final boolean isBusy() {
                return this.isBusy;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(premiumSubscription=");
                sbM833U.append(this.premiumSubscription);
                sbM833U.append(", paymentSources=");
                sbM833U.append(this.paymentSources);
                sbM833U.append(", isBusy=");
                sbM833U.append(this.isBusy);
                sbM833U.append(", entitlements=");
                sbM833U.append(this.entitlements);
                sbM833U.append(", guildSubscriptions=");
                sbM833U.append(this.guildSubscriptions);
                sbM833U.append(", hasAnyGuildBoosts=");
                sbM833U.append(this.hasAnyGuildBoosts);
                sbM833U.append(", renewalInvoicePreview=");
                sbM833U.append(this.renewalInvoicePreview);
                sbM833U.append(", currentInvoicePreview=");
                sbM833U.append(this.currentInvoicePreview);
                sbM833U.append(", skuDetails=");
                sbM833U.append(this.skuDetails);
                sbM833U.append(", purchases=");
                sbM833U.append(this.purchases);
                sbM833U.append(", pastDueGracePeriodDays=");
                return C1643a.m814B(sbM833U, this.pastDueGracePeriodDays, ")");
            }
        }

        /* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
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

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsPremiumViewModel$cancelSubscription$1 */
    /* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
    public static final class C98891 extends AbstractC12240o implements Function1<Void, Unit> {
        public C98891() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            SettingsPremiumViewModel.this.fetchData();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsPremiumViewModel$cancelSubscription$2 */
    /* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
    public static final class C98902 extends AbstractC12240o implements Function1<Error, Unit> {
        public C98902() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            SettingsPremiumViewModel.this.onCancelError();
        }
    }

    public SettingsPremiumViewModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SettingsPremiumViewModel(StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, StoreEntitlements storeEntitlements, StoreGuildBoost storeGuildBoost, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStores;
        StorePaymentSources paymentSources = (i & 1) != 0 ? StoreStream.INSTANCE.getPaymentSources() : storePaymentSources;
        StoreSubscriptions subscriptions = (i & 2) != 0 ? StoreStream.INSTANCE.getSubscriptions() : storeSubscriptions;
        StoreEntitlements entitlements = (i & 4) != 0 ? StoreStream.INSTANCE.getEntitlements() : storeEntitlements;
        StoreGuildBoost guildBoosts = (i & 8) != 0 ? StoreStream.INSTANCE.getGuildBoosts() : storeGuildBoost;
        RestAPI api = (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 32) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStores = companion.observeStores(companion2.getPaymentSources(), companion2.getSubscriptions(), companion2.getEntitlements(), companion2.getGuildBoosts(), companion2.getGooglePlaySkuDetails(), companion2.getGooglePlayPurchases(), companion2.getExperiments(), RestAPI.INSTANCE.getApi());
        } else {
            observableObserveStores = observable;
        }
        this(paymentSources, subscriptions, entitlements, guildBoosts, api, observableObserveStores);
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
            if (!(paymentSourceId == null || C12103t.isBlank(paymentSourceId))) {
                return 7;
            }
        }
        return 3;
    }

    private final void handleStoreState(StoreState storeState) {
        ViewState loaded;
        StorePaymentSources.PaymentSourcesState paymentSourcesState = storeState.getPaymentSourcesState();
        StoreSubscriptions.SubscriptionsState subscriptionsState = storeState.getSubscriptionsState();
        StoreEntitlements.State entitlementState = storeState.getEntitlementState();
        StoreGuildBoost.State guildBoostState = storeState.getGuildBoostState();
        InvoicePreviewFetch renewalInvoicePreviewFetch = storeState.getRenewalInvoicePreviewFetch();
        InvoicePreviewFetch currentInvoicePreviewFetch = storeState.getCurrentInvoicePreviewFetch();
        StoreGooglePlaySkuDetails.State skuDetailsState = storeState.getSkuDetailsState();
        StoreGooglePlayPurchases.State purchaseState = storeState.getPurchaseState();
        if ((paymentSourcesState instanceof StorePaymentSources.PaymentSourcesState.Loaded) && (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loaded) && (entitlementState instanceof StoreEntitlements.State.Loaded) && (guildBoostState instanceof StoreGuildBoost.State.Loaded) && (renewalInvoicePreviewFetch instanceof InvoicePreviewFetch.Invoice) && (currentInvoicePreviewFetch instanceof InvoicePreviewFetch.Invoice) && (skuDetailsState instanceof StoreGooglePlaySkuDetails.State.Loaded) && (purchaseState instanceof StoreGooglePlayPurchases.State.Loaded)) {
            ModelSubscription premiumSubscription = ((StoreSubscriptions.SubscriptionsState.Loaded) subscriptionsState).getPremiumSubscription();
            boolean zHasAnyOfPlans = premiumSubscription != null ? premiumSubscription.hasAnyOfPlans(C12148n0.setOf((Object[]) new Long[]{Long.valueOf(SubscriptionPlanType.PREMIUM_GUILD_MONTH.getPlanId()), Long.valueOf(SubscriptionPlanType.PREMIUM_GUILD_3_MONTH.getPlanId()), Long.valueOf(SubscriptionPlanType.PREMIUM_GUILD_6_MONTH.getPlanId()), Long.valueOf(SubscriptionPlanType.PREMIUM_GUILD_YEAR.getPlanId())})) : false;
            List<ModelPaymentSource> paymentSources = ((StorePaymentSources.PaymentSourcesState.Loaded) paymentSourcesState).getPaymentSources();
            List<ModelEntitlement> listEmptyList = ((StoreEntitlements.State.Loaded) entitlementState).getOwnedEntitlements().get(521842831262875670L);
            if (listEmptyList == null) {
                listEmptyList = C12147n.emptyList();
            }
            loaded = new ViewState.Loaded(premiumSubscription, paymentSources, false, listEmptyList, ((StoreGuildBoost.State.Loaded) guildBoostState).getBoostSlotMap(), zHasAnyOfPlans, ((InvoicePreviewFetch.Invoice) renewalInvoicePreviewFetch).getModelInvoicePreview(), ((InvoicePreviewFetch.Invoice) currentInvoicePreviewFetch).getModelInvoicePreview(), ((StoreGooglePlaySkuDetails.State.Loaded) skuDetailsState).getSkuDetails(), ((StoreGooglePlayPurchases.State.Loaded) purchaseState).getPurchases(), getPastDueGracePeriodDays(premiumSubscription));
        } else {
            loaded = ((paymentSourcesState instanceof StorePaymentSources.PaymentSourcesState.Failure) || (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Failure) || (guildBoostState instanceof StoreGuildBoost.State.Failure) || (renewalInvoicePreviewFetch instanceof InvoicePreviewFetch.Error) || (skuDetailsState instanceof StoreGooglePlaySkuDetails.State.Failure)) ? ViewState.Failure.INSTANCE : ViewState.Loading.INSTANCE;
        }
        updateViewState(loaded);
    }

    private final void markBusy() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, true, null, null, false, null, null, null, null, 0, 2043, null));
        }
    }

    private final void onCancelError() {
        if (getViewState() instanceof ViewState.Loaded) {
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.f27650k.onNext(new Event.ErrorToast(C5419R.string.premium_alert_error_title));
        }
    }

    @MainThread
    public final void cancelSubscription() {
        ModelSubscription premiumSubscription;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (premiumSubscription = loaded.getPremiumSubscription()) == null) {
            return;
        }
        markBusy();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.deleteSubscription(premiumSubscription.getId()), false, 1, null), this, null, 2, null), (Class<?>) SettingsPremiumViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C98902()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C98891());
    }

    @MainThread
    public final Observable<Event> getEventSubject() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onRetryClicked() {
        fetchData();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsPremiumViewModel(StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, StoreEntitlements storeEntitlements, StoreGuildBoost storeGuildBoost, RestAPI restAPI, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        C12238m.checkNotNullParameter(storePaymentSources, "storePaymentsSources");
        C12238m.checkNotNullParameter(storeSubscriptions, "storeSubscriptions");
        C12238m.checkNotNullParameter(storeEntitlements, "storeEntitlements");
        C12238m.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(observable, "storeObservable");
        this.storePaymentsSources = storePaymentSources;
        this.storeSubscriptions = storeSubscriptions;
        this.storeEntitlements = storeEntitlements;
        this.storeGuildBoost = storeGuildBoost;
        this.restAPI = restAPI;
        this.eventSubject = PublishSubject.m11133k0();
        fetchData();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) SettingsPremiumViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C98861());
    }
}
