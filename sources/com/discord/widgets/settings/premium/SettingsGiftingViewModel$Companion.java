package com.discord.widgets.settings.premium;

import com.discord.stores.StoreEntitlements$State;
import com.discord.stores.StoreOutboundPromotions$State;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func4;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGiftingViewModel$Companion {
    private SettingsGiftingViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(SettingsGiftingViewModel$Companion settingsGiftingViewModel$Companion) {
        return settingsGiftingViewModel$Companion.observeStores();
    }

    private final Observable<SettingsGiftingViewModel$StoreState> observeStores() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<StoreEntitlements$State> observableObserveEntitlementState = storeStream$Companion.getEntitlements().observeEntitlementState();
        Observable<R> observableY = storeStream$Companion.getUsers().observeMeId().Y(SettingsGiftingViewModel$Companion$observeStores$1.INSTANCE);
        Observable<StoreOutboundPromotions$State> observableObserveState = storeStream$Companion.getOutboundPromotions().observeState();
        Observable observableG = StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null).G(SettingsGiftingViewModel$Companion$observeStores$2.INSTANCE);
        SettingsGiftingViewModel$Companion$observeStores$3 settingsGiftingViewModel$Companion$observeStores$3 = SettingsGiftingViewModel$Companion$observeStores$3.INSTANCE;
        Object settingsGiftingViewModel$sam$rx_functions_Func4$0 = settingsGiftingViewModel$Companion$observeStores$3;
        if (settingsGiftingViewModel$Companion$observeStores$3 != null) {
            settingsGiftingViewModel$sam$rx_functions_Func4$0 = new SettingsGiftingViewModel$sam$rx_functions_Func4$0(settingsGiftingViewModel$Companion$observeStores$3);
        }
        Observable<SettingsGiftingViewModel$StoreState> observableR = Observable.h(observableObserveEntitlementState, observableY, observableObserveState, observableG, (Func4) settingsGiftingViewModel$sam$rx_functions_Func4$0).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ SettingsGiftingViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
