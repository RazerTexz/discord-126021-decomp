package com.discord.widgets.settings;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance$Model$Companion {
    private WidgetSettingsAppearance$Model$Companion() {
    }

    public final Observable<WidgetSettingsAppearance$Model> get(Observable<Boolean> easterEggPureEvil) {
        m.checkNotNullParameter(easterEggPureEvil, "easterEggPureEvil");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetSettingsAppearance$Model> observableI = Observable.i(StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getUserSettingsSystem().observeSettings(false), easterEggPureEvil, WidgetSettingsAppearance$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable\n            .…          )\n            }");
        return observableI;
    }

    public /* synthetic */ WidgetSettingsAppearance$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
