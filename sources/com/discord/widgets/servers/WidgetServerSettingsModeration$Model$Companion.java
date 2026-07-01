package com.discord.widgets.servers;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsModeration$Model$Companion {
    private WidgetServerSettingsModeration$Model$Companion() {
    }

    public final Observable<WidgetServerSettingsModeration$Model> get(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableI = Observable.i(storeStream$Companion.getGuilds().observeGuild(guildId), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getPermissions().observePermissionsForGuild(guildId), WidgetServerSettingsModeration$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable\n             …        }\n              }");
        Observable<WidgetServerSettingsModeration$Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetServerSettingsModeration$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
