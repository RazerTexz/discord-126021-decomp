package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreNotificationUpsells.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotificationUpsells extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* JADX INFO: renamed from: com.discord.stores.StoreNotificationUpsells$dismissPushNotificationsUpsell$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreNotificationUpsells.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreNotificationUpsells.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNotificationUpsells$observePushNotificationUpsellDismissed$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreNotificationUpsells.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public AnonymousClass1() {
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
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public final void dismissPushNotificationsUpsell() {
        getPrefsSessionDurable().edit().putBoolean("PUSH_NOTIFICATIONS_DISMISS_UPSELL", true).apply();
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final boolean getPushNotificationsUpsellDismissed() {
        return getPrefsSessionDurable().getBoolean("PUSH_NOTIFICATIONS_DISMISS_UPSELL", false);
    }

    public final Observable<Boolean> observePushNotificationUpsellDismissed() {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public StoreNotificationUpsells(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
    }
}
