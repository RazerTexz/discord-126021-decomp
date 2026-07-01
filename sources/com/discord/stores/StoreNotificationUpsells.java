package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreNotificationUpsells.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotificationUpsells extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    public /* synthetic */ StoreNotificationUpsells(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public final void dismissPushNotificationsUpsell() {
        getPrefsSessionDurable().edit().putBoolean("PUSH_NOTIFICATIONS_DISMISS_UPSELL", true).apply();
        this.dispatcher.schedule(new StoreNotificationUpsells$dismissPushNotificationsUpsell$1(this));
    }

    public final boolean getPushNotificationsUpsellDismissed() {
        return getPrefsSessionDurable().getBoolean("PUSH_NOTIFICATIONS_DISMISS_UPSELL", false);
    }

    public final Observable<Boolean> observePushNotificationUpsellDismissed() {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreNotificationUpsells$observePushNotificationUpsellDismissed$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public StoreNotificationUpsells(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
    }
}
