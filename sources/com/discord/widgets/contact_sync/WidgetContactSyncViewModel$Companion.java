package com.discord.widgets.contact_sync;

import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSyncViewModel$Companion {
    private WidgetContactSyncViewModel$Companion() {
    }

    public final Observable<WidgetContactSyncViewModel$StoreState> observeStores() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreUser users = storeStream$Companion.getUsers();
        StorePhone phone = storeStream$Companion.getPhone();
        StoreUserConnections userConnections = storeStream$Companion.getUserConnections();
        Observable<WidgetContactSyncViewModel$StoreState> observableG = ObservableExtensionsKt.leadingEdgeThrottle(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{users, phone, userConnections}, false, null, null, 14, null), 1L, TimeUnit.SECONDS).G(new WidgetContactSyncViewModel$Companion$observeStores$1(users, phone, userConnections));
        m.checkNotNullExpressionValue(observableG, "ObservationDeckProvider\n…            )\n          }");
        return observableG;
    }

    public /* synthetic */ WidgetContactSyncViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
