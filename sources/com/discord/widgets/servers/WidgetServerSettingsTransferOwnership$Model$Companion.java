package com.discord.widgets.servers;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsTransferOwnership.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsTransferOwnership$Model$Companion {
    private WidgetServerSettingsTransferOwnership$Model$Companion() {
    }

    public final Observable<WidgetServerSettingsTransferOwnership$Model> get(long guildId, long userId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableR = Observable.i(storeStream$Companion.getGuilds().observeGuild(guildId), storeStream$Companion.getUsers().observeUser(userId), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), WidgetServerSettingsTransferOwnership$Model$Companion$get$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return ObservableExtensionsKt.computationLatest(observableR);
    }

    public /* synthetic */ WidgetServerSettingsTransferOwnership$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
