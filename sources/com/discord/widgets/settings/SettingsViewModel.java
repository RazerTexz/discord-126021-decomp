package com.discord.widgets.settings;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.FrameMetricsAggregator;
import b.a.d.d0;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNotificationUpsells;
import com.discord.stores.StoreOutboundPromotions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.handoff.MobileWebHandoff;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: SettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsViewModel extends d0<SettingsViewModel$ViewState> {
    public static final SettingsViewModel$Companion Companion = new SettingsViewModel$Companion(null);
    private static final String MANAGE_SUBSCRIPTIONS_URL = "/settings/subscriptions/role-subscriptions";
    private final StoreSubscriptions subscriptionsStore;

    public SettingsViewModel() {
        this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SettingsViewModel(StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreNotificationUpsells storeNotificationUpsells, StoreOutboundPromotions storeOutboundPromotions, StoreSubscriptions storeSubscriptions, StoreUser storeUser, StoreUserPresence storeUserPresence, ObservationDeck observationDeck, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreExperiments experiments = (i & 1) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments;
        StoreGuilds guilds = (i & 2) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        StoreNotificationUpsells notificationUpsells = (i & 4) != 0 ? StoreStream.Companion.getNotificationUpsells() : storeNotificationUpsells;
        StoreOutboundPromotions outboundPromotions = (i & 8) != 0 ? StoreStream.Companion.getOutboundPromotions() : storeOutboundPromotions;
        StoreSubscriptions subscriptions = (i & 16) != 0 ? StoreStream.Companion.getSubscriptions() : storeSubscriptions;
        StoreUser users = (i & 32) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        StoreUserPresence presences = (i & 64) != 0 ? StoreStream.Companion.getPresences() : storeUserPresence;
        ObservationDeck observationDeck2 = (i & 128) != 0 ? ObservationDeckProvider.get() : observationDeck;
        this(experiments, guilds, notificationUpsells, outboundPromotions, subscriptions, users, presences, observationDeck2, (i & 256) != 0 ? SettingsViewModel$Companion.access$observeStoreState(Companion, users, guilds, presences, outboundPromotions, notificationUpsells, experiments, subscriptions, observationDeck2) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(SettingsViewModel settingsViewModel, SettingsViewModel$StoreState settingsViewModel$StoreState) {
        settingsViewModel.handleStoreState(settingsViewModel$StoreState);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003c  */
    @MainThread
    private final void handleStoreState(SettingsViewModel$StoreState storeState) {
        boolean z2;
        boolean z3;
        if (storeState.isEligibleForMobileWebSubscriptions()) {
            List<ModelSubscription> subscriptions = storeState.getSubscriptions();
            if (subscriptions == null) {
                subscriptions = n.emptyList();
            }
            if (!(subscriptions instanceof Collection) || !subscriptions.isEmpty()) {
                Iterator<T> it = subscriptions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    }
                    if (SettingsViewModel$Companion.access$isActiveGuildSubscription$p(Companion, (ModelSubscription) it.next())) {
                        z3 = true;
                        break;
                    }
                }
            } else {
                z3 = false;
                break;
            }
            if (z3) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        updateViewState(new SettingsViewModel$ViewState$Loaded(storeState.getMeUser(), storeState.isStaffOrAlpha(), storeState.getPresence(), storeState.getPromoCount(), storeState.getPushNotificationUpsellDismissed(), z2));
    }

    public final void openRoleSubscriptionsManagement(Context context) {
        m.checkNotNullParameter(context, "context");
        MobileWebHandoff.tryLaunchRedirectTo$default(new MobileWebHandoff(context, null, null, null, 14, null), MANAGE_SUBSCRIPTIONS_URL, false, false, 6, null);
    }

    public final void refreshSubscriptions() {
        if (this.subscriptionsStore.isFetchingSubscriptions()) {
            return;
        }
        this.subscriptionsStore.fetchSubscriptions();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsViewModel(StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreNotificationUpsells storeNotificationUpsells, StoreOutboundPromotions storeOutboundPromotions, StoreSubscriptions storeSubscriptions, StoreUser storeUser, StoreUserPresence storeUserPresence, ObservationDeck observationDeck, Observable<SettingsViewModel$StoreState> observable) {
        super(SettingsViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(storeExperiments, "experimentsStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(storeNotificationUpsells, "notificationUpsellsStore");
        m.checkNotNullParameter(storeOutboundPromotions, "outboundPromotionsStore");
        m.checkNotNullParameter(storeSubscriptions, "subscriptionsStore");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(storeUserPresence, "userPresenceStore");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.subscriptionsStore = storeSubscriptions;
        Observable<SettingsViewModel$StoreState> observableR = observable.r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), SettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new SettingsViewModel$1(this), 62, (Object) null);
    }
}
