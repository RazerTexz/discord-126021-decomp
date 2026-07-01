package com.discord.widgets.servers;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl$Model$Companion {
    private WidgetServerSettingsVanityUrl$Model$Companion() {
    }

    public final Observable<WidgetServerSettingsVanityUrl$Model> get(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetServerSettingsVanityUrl$Model> observableH = Observable.h(StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getPermissions().observePermissionsForGuild(guildId), storeStream$Companion.getGuilds().observeGuild(guildId), ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getVanityUrl(guildId), false, 1, null), new WidgetServerSettingsVanityUrl$Model$Companion$get$1(guildId));
        m.checkNotNullExpressionValue(observableH, "Observable.combineLatest…ull\n          }\n        }");
        return observableH;
    }

    public /* synthetic */ WidgetServerSettingsVanityUrl$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
