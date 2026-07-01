package com.discord.widgets.servers;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration$Model$Companion {
    private WidgetServerSettingsEditIntegration$Model$Companion() {
    }

    public final Observable<WidgetServerSettingsEditIntegration$Model> get(long guildId, long integrationId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableG = Observable.g(StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getGuilds().observeGuild(guildId), storeStream$Companion.getGuilds().observeRoles(guildId), storeStream$Companion.getPermissions().observePermissionsForGuild(guildId), storeStream$Companion.getGuildIntegrations().get(guildId, integrationId), WidgetServerSettingsEditIntegration$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "Observable.combineLatest…  }\n          }\n        }");
        Observable<WidgetServerSettingsEditIntegration$Model> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetServerSettingsEditIntegration$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
