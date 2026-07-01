package com.discord.widgets.settings;

import com.discord.models.domain.ModelUserSettings$FriendSourceFlags;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func7;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$Model$Companion {
    private WidgetSettingsPrivacy$Model$Companion() {
    }

    public final Observable<WidgetSettingsPrivacy$Model> get() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableObserveMe$default = StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null);
        Observable<Integer> observableObserveExplicitContentFilter = storeStream$Companion.getUserSettings().observeExplicitContentFilter();
        Observable<Boolean> observableObserveIsDefaultGuildsRestricted = storeStream$Companion.getUserSettings().observeIsDefaultGuildsRestricted();
        Observable<ModelUserSettings$FriendSourceFlags> observableObserveFriendSourceFlags = storeStream$Companion.getUserSettings().observeFriendSourceFlags();
        Observable<R> observableG = storeStream$Companion.getUserConnections().observeConnectedAccounts().G(WidgetSettingsPrivacy$Model$Companion$get$1.INSTANCE);
        Observable<Experiment> observableObserveUserExperiment = storeStream$Companion.getExperiments().observeUserExperiment("2021-04_contact_sync_android_main", true);
        Observable<Integer> observableObserveFriendDiscoveryFlags = storeStream$Companion.getUserSettings().observeFriendDiscoveryFlags();
        WidgetSettingsPrivacy$Model$Companion$get$2 widgetSettingsPrivacy$Model$Companion$get$2 = WidgetSettingsPrivacy$Model$Companion$get$2.INSTANCE;
        Object widgetSettingsPrivacy$sam$rx_functions_Func7$0 = widgetSettingsPrivacy$Model$Companion$get$2;
        if (widgetSettingsPrivacy$Model$Companion$get$2 != null) {
            widgetSettingsPrivacy$sam$rx_functions_Func7$0 = new WidgetSettingsPrivacy$sam$rx_functions_Func7$0(widgetSettingsPrivacy$Model$Companion$get$2);
        }
        Observable observableY = Observable.e(observableObserveMe$default, observableObserveExplicitContentFilter, observableObserveIsDefaultGuildsRestricted, observableObserveFriendSourceFlags, observableG, observableObserveUserExperiment, observableObserveFriendDiscoveryFlags, (Func7) widgetSettingsPrivacy$sam$rx_functions_Func7$0).Y(WidgetSettingsPrivacy$Model$Companion$get$3.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "Observable\n          .co…            }\n          }");
        Observable<WidgetSettingsPrivacy$Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetSettingsPrivacy$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
