package com.discord.widgets.settings.connections;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsViewModel$Companion {
    private WidgetSettingsUserConnectionsViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(WidgetSettingsUserConnectionsViewModel$Companion widgetSettingsUserConnectionsViewModel$Companion) {
        return widgetSettingsUserConnectionsViewModel$Companion.observeStores();
    }

    private final Observable<WidgetSettingsUserConnectionsViewModel$StoreState> observeStores() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetSettingsUserConnectionsViewModel$StoreState> observableJ = Observable.j(storeStream$Companion.getUserConnections().observeConnectedAccounts(), storeStream$Companion.getGuilds().observeGuilds(), WidgetSettingsUserConnectionsViewModel$Companion$observeStores$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…= \"contacts\" }, guilds) }");
        return observableJ;
    }

    public /* synthetic */ WidgetSettingsUserConnectionsViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
