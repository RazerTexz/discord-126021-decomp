package com.discord.widgets.servers;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoles$Model$Companion {
    private WidgetServerSettingsRoles$Model$Companion() {
    }

    public final Observable<WidgetServerSettingsRoles$Model> get(long guildId) {
        Observable<WidgetServerSettingsRoles$Model> observableR = StoreUser.observeMe$default(StoreStream.Companion.getUsers(), false, 1, null).Y(new WidgetServerSettingsRoles$Model$Companion$get$1(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetServerSettingsRoles$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
