package com.discord.widgets.settings.account;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$Model$Companion {
    private WidgetSettingsAccount$Model$Companion() {
    }

    public final Observable<WidgetSettingsAccount$Model> get() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetSettingsAccount$Model> observableG = Observable.g(StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getMFA().observeState(), storeStream$Companion.getGuilds().observeGuilds(), storeStream$Companion.getUserConnections().observeConnectedAccounts(), storeStream$Companion.getExperiments().observeUserExperiment("2021-04_contact_sync_android_main", true), WidgetSettingsAccount$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "Observable.combineLatest…            )\n          }");
        return observableG;
    }

    public /* synthetic */ WidgetSettingsAccount$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
