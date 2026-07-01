package com.discord.widgets.settings.premium;

import com.discord.stores.StoreGooglePlayPurchases$QueryState;
import com.discord.stores.StoreGooglePlayPurchases$State;
import com.discord.stores.StoreGooglePlaySkuDetails$State;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func4;

/* JADX INFO: compiled from: ChoosePlanViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChoosePlanViewModel$Companion {
    private ChoosePlanViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(ChoosePlanViewModel$Companion choosePlanViewModel$Companion) {
        return choosePlanViewModel$Companion.observeStores();
    }

    private final Observable<ChoosePlanViewModel$StoreState> observeStores() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<StoreGooglePlaySkuDetails$State> observableObserveState = storeStream$Companion.getGooglePlaySkuDetails().observeState();
        Observable<StoreGooglePlayPurchases$State> observableObserveState2 = storeStream$Companion.getGooglePlayPurchases().observeState();
        Observable<StoreGooglePlayPurchases$QueryState> observableObserveQueryState = storeStream$Companion.getGooglePlayPurchases().observeQueryState();
        Observable<StoreSubscriptions$SubscriptionsState> observableObserveSubscriptions = storeStream$Companion.getSubscriptions().observeSubscriptions();
        ChoosePlanViewModel$Companion$observeStores$1 choosePlanViewModel$Companion$observeStores$1 = ChoosePlanViewModel$Companion$observeStores$1.INSTANCE;
        Object choosePlanViewModel$sam$rx_functions_Func4$0 = choosePlanViewModel$Companion$observeStores$1;
        if (choosePlanViewModel$Companion$observeStores$1 != null) {
            choosePlanViewModel$sam$rx_functions_Func4$0 = new ChoosePlanViewModel$sam$rx_functions_Func4$0(choosePlanViewModel$Companion$observeStores$1);
        }
        Observable<ChoosePlanViewModel$StoreState> observableH = Observable.h(observableObserveState, observableObserveState2, observableObserveQueryState, observableObserveSubscriptions, (Func4) choosePlanViewModel$sam$rx_functions_Func4$0);
        m.checkNotNullExpressionValue(observableH, "Observable.combineLatest…     ::StoreState\n      )");
        return observableH;
    }

    public /* synthetic */ ChoosePlanViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
