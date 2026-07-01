package com.discord.widgets.settings.billing;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.ModelSubscription;
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
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: SettingsBillingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsBillingViewModel extends d0<SettingsBillingViewModel$ViewState> {
    private final StorePaymentSources storePaymentSources;
    private final StoreSubscriptions storeSubscriptions;

    public SettingsBillingViewModel() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SettingsBillingViewModel(StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storePaymentSources = (i & 1) != 0 ? StoreStream.Companion.getPaymentSources() : storePaymentSources;
        storeSubscriptions = (i & 2) != 0 ? StoreStream.Companion.getSubscriptions() : storeSubscriptions;
        if ((i & 4) != 0) {
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observable = Observable.j(storeStream$Companion.getPaymentSources().observePaymentSourcesState(), storeStream$Companion.getSubscriptions().observeSubscriptions(), SettingsBillingViewModel$1.INSTANCE);
            m.checkNotNullExpressionValue(observable, "Observable\n      .combin…nsState\n        )\n      }");
        }
        this(storePaymentSources, storeSubscriptions, observable);
    }

    public static final /* synthetic */ void access$handleStoreState(SettingsBillingViewModel settingsBillingViewModel, SettingsBillingViewModel$StoreState settingsBillingViewModel$StoreState) {
        settingsBillingViewModel.handleStoreState(settingsBillingViewModel$StoreState);
    }

    private final void fetchData() {
        this.storePaymentSources.fetchPaymentSources();
        this.storeSubscriptions.fetchSubscriptions();
    }

    private final List<PaymentSourceAdapter$Item> generateListItems(List<? extends ModelPaymentSource> paymentSources, ModelSubscription premiumSubscription) {
        ArrayList arrayList = new ArrayList();
        if (!paymentSources.isEmpty()) {
            int i = 0;
            for (Object obj : paymentSources) {
                int i2 = i + 1;
                if (i < 0) {
                    n.throwIndexOverflow();
                }
                ModelPaymentSource modelPaymentSource = (ModelPaymentSource) obj;
                PaymentSourceAdapter$PaymentSourceHeader$Type paymentSourceAdapter$PaymentSourceHeader$Type = i != 0 ? i != 1 ? null : PaymentSourceAdapter$PaymentSourceHeader$Type.OTHER : PaymentSourceAdapter$PaymentSourceHeader$Type.DEFAULT;
                PaymentSourceAdapter$PaymentSourceHeader paymentSourceAdapter$PaymentSourceHeader = paymentSourceAdapter$PaymentSourceHeader$Type != null ? new PaymentSourceAdapter$PaymentSourceHeader(paymentSourceAdapter$PaymentSourceHeader$Type) : null;
                if (paymentSourceAdapter$PaymentSourceHeader != null) {
                    arrayList.add(paymentSourceAdapter$PaymentSourceHeader);
                }
                arrayList.add(new PaymentSourceAdapter$PaymentSourceItem(modelPaymentSource, m.areEqual(modelPaymentSource.getId(), premiumSubscription != null ? premiumSubscription.getPaymentSourceId() : null) && !premiumSubscription.getStatus().isCanceled()));
                i = i2;
            }
            arrayList.add(new PaymentSourceAdapter$PaymentSourceAddItem());
        }
        return arrayList;
    }

    private final void handleStoreState(SettingsBillingViewModel$StoreState storeState) {
        StorePaymentSources$PaymentSourcesState paymentSourceState = storeState.getPaymentSourceState();
        StoreSubscriptions$SubscriptionsState subscriptionsState = storeState.getSubscriptionsState();
        if ((paymentSourceState instanceof StorePaymentSources$PaymentSourcesState$Loaded) && (subscriptionsState instanceof StoreSubscriptions$SubscriptionsState$Loaded)) {
            updateViewState(new SettingsBillingViewModel$ViewState$Loaded(generateListItems(((StorePaymentSources$PaymentSourcesState$Loaded) paymentSourceState).getPaymentSources(), ((StoreSubscriptions$SubscriptionsState$Loaded) subscriptionsState).getPremiumSubscription())));
        } else if ((paymentSourceState instanceof StorePaymentSources$PaymentSourcesState$Failure) || (subscriptionsState instanceof StoreSubscriptions$SubscriptionsState$Failure)) {
            updateViewState(SettingsBillingViewModel$ViewState$Failure.INSTANCE);
        } else {
            updateViewState(SettingsBillingViewModel$ViewState$Loading.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsBillingViewModel(StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, Observable<SettingsBillingViewModel$StoreState> observable) {
        super(SettingsBillingViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(storePaymentSources, "storePaymentSources");
        m.checkNotNullParameter(storeSubscriptions, "storeSubscriptions");
        m.checkNotNullParameter(observable, "storeObservable");
        this.storePaymentSources = storePaymentSources;
        this.storeSubscriptions = storeSubscriptions;
        fetchData();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), SettingsBillingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new SettingsBillingViewModel$2(this), 62, (Object) null);
    }
}
