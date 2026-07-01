package com.discord.widgets.servers;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditMember$Model$Companion {
    private WidgetServerSettingsEditMember$Model$Companion() {
    }

    public final Observable<WidgetServerSettingsEditMember$Model> get(long guildId, long userId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableR = Observable.f(StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getUsers().observeUser(userId), storeStream$Companion.getGuilds().observeComputed(guildId), storeStream$Companion.getGuilds().observeGuild(guildId), storeStream$Companion.getGuilds().observeRoles(guildId), storeStream$Companion.getPermissions().observePermissionsForGuild(guildId), new WidgetServerSettingsEditMember$Model$Companion$get$1(guildId, userId)).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return ObservableExtensionsKt.computationLatest(observableR);
    }

    public /* synthetic */ WidgetServerSettingsEditMember$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
