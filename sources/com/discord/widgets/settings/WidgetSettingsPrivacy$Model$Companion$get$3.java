package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$Model$Companion$get$3<T, R> implements b<WidgetSettingsPrivacy$LocalState, Observable<? extends WidgetSettingsPrivacy$Model>> {
    public static final WidgetSettingsPrivacy$Model$Companion$get$3 INSTANCE = new WidgetSettingsPrivacy$Model$Companion$get$3();

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetSettingsPrivacy$Model> call2(WidgetSettingsPrivacy$LocalState widgetSettingsPrivacy$LocalState) {
        k kVar = new k(widgetSettingsPrivacy$LocalState);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.i(kVar, storeStream$Companion.getUserSettings().observeConsents(), Observable.I(new k(null), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null).y(WidgetSettingsPrivacy$Model$Companion$get$3$1.INSTANCE).A(WidgetSettingsPrivacy$Model$Companion$get$3$2.INSTANCE)), WidgetSettingsPrivacy$Model$Companion$get$3$3.INSTANCE);
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetSettingsPrivacy$Model> call(WidgetSettingsPrivacy$LocalState widgetSettingsPrivacy$LocalState) {
        return call2(widgetSettingsPrivacy$LocalState);
    }
}
