package com.discord.widgets.auth;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetAgeVerifyViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerifyViewModel$Companion {
    private WidgetAgeVerifyViewModel$Companion() {
    }

    public final Observable<WidgetAgeVerifyViewModel$StoreState> observeStores() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetAgeVerifyViewModel$StoreState> observableI = Observable.i(StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getAuthentication().observeIsAuthed$app_productionGoogleRelease(), storeStream$Companion.getChannelsSelected().observeSelectedChannel().Y(WidgetAgeVerifyViewModel$Companion$observeStores$1.INSTANCE), WidgetAgeVerifyViewModel$Companion$observeStores$2.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…hed\n          )\n        }");
        return observableI;
    }

    public /* synthetic */ WidgetAgeVerifyViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
