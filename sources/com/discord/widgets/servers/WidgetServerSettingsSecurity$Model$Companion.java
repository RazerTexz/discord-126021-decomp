package com.discord.widgets.servers;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity$Model$Companion {
    private WidgetServerSettingsSecurity$Model$Companion() {
    }

    public final Observable<WidgetServerSettingsSecurity$Model> get(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableJ = Observable.j(StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getGuilds().observeGuild(guildId), WidgetServerSettingsSecurity$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable\n             …        )\n              }");
        Observable<WidgetServerSettingsSecurity$Model> observableR = ObservableExtensionsKt.computationLatest(observableJ).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetServerSettingsSecurity$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
