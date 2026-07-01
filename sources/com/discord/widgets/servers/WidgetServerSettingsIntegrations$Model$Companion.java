package com.discord.widgets.servers;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrations$Model$Companion {
    private WidgetServerSettingsIntegrations$Model$Companion() {
    }

    public final Observable<WidgetServerSettingsIntegrations$Model> get(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableG = Observable.g(storeStream$Companion.getGuildIntegrations().get(guildId), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getPermissions().observePermissionsForGuild(guildId), storeStream$Companion.getGuilds().observeGuild(guildId), storeStream$Companion.getGuilds().observeRoles(guildId), WidgetServerSettingsIntegrations$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "Observable\n             …        }\n              }");
        Observable<WidgetServerSettingsIntegrations$Model> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetServerSettingsIntegrations$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
