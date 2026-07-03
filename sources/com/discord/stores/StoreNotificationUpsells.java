package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreNotificationUpsells.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotificationUpsells extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* JADX INFO: renamed from: com.discord.stores.StoreNotificationUpsells$dismissPushNotificationsUpsell$1 */
    /* JADX INFO: compiled from: StoreNotificationUpsells.kt */
    public static final class C62911 extends AbstractC12240o implements Function0<Unit> {
        public C62911() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreNotificationUpsells.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNotificationUpsells$observePushNotificationUpsellDismissed$1 */
    /* JADX INFO: compiled from: StoreNotificationUpsells.kt */
    public static final class C62921 extends AbstractC12240o implements Function0<Boolean> {
        public C62921() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreNotificationUpsells.this.getPushNotificationsUpsellDismissed();
        }
    }

    public /* synthetic */ StoreNotificationUpsells(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public final void dismissPushNotificationsUpsell() {
        getPrefsSessionDurable().edit().putBoolean("PUSH_NOTIFICATIONS_DISMISS_UPSELL", true).apply();
        this.dispatcher.schedule(new C62911());
    }

    public final boolean getPushNotificationsUpsellDismissed() {
        return getPrefsSessionDurable().getBoolean("PUSH_NOTIFICATIONS_DISMISS_UPSELL", false);
    }

    public final Observable<Boolean> observePushNotificationUpsellDismissed() {
        Observable<Boolean> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C62921(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public StoreNotificationUpsells(Dispatcher dispatcher, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
    }
}
