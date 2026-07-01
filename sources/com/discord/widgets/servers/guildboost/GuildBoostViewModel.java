package com.discord.widgets.servers.guildboost;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.android.billingclient.api.Purchase;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.ModelSubscription$Status;
import com.discord.stores.StoreGooglePlayPurchases$State;
import com.discord.stores.StoreGooglePlayPurchases$State$Loaded;
import com.discord.stores.StoreGooglePlayPurchases$State$Uninitialized;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreGuildBoost$State;
import com.discord.stores.StoreGuildBoost$State$Failure;
import com.discord.stores.StoreGuildBoost$State$Loaded;
import com.discord.stores.StoreGuildBoost$State$Loading;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Failure;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Loaded;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Loading;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostViewModel extends d0<GuildBoostViewModel$ViewState> {
    public static final GuildBoostViewModel$Companion Companion = new GuildBoostViewModel$Companion(null);
    private final Clock clock;
    private final PublishSubject<GuildBoostViewModel$Event> eventSubject;
    private final long guildId;
    private final StoreGuildBoost storeGuildBoost;
    private final StoreSubscriptions storeSubscriptions;

    public /* synthetic */ GuildBoostViewModel(long j, StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? StoreStream.Companion.getGuildBoosts() : storeGuildBoost, (i & 4) != 0 ? StoreStream.Companion.getSubscriptions() : storeSubscriptions, (i & 8) != 0 ? ClockFactory.get() : clock, (i & 16) != 0 ? GuildBoostViewModel$Companion.access$observeStores(Companion, j) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildBoostViewModel guildBoostViewModel, GuildBoostViewModel$StoreState guildBoostViewModel$StoreState) {
        guildBoostViewModel.handleStoreState(guildBoostViewModel$StoreState);
    }

    private final void fetchData() {
        this.storeGuildBoost.fetchUserGuildBoostState();
        this.storeSubscriptions.fetchSubscriptions();
        GooglePlayBillingManager.INSTANCE.queryPurchases();
    }

    @MainThread
    private final void handleStoreState(GuildBoostViewModel$StoreState storeState) {
        GuildBoostViewModel$ViewState guildBoostViewModel$ViewState$Loaded;
        StoreGuildBoost$State guildBoostState = storeState.getGuildBoostState();
        StoreSubscriptions$SubscriptionsState subscriptionState = storeState.getSubscriptionState();
        StoreGooglePlayPurchases$State purchasesState = storeState.getPurchasesState();
        if ((guildBoostState instanceof StoreGuildBoost$State$Loading) || (subscriptionState instanceof StoreSubscriptions$SubscriptionsState$Loading) || (purchasesState instanceof StoreGooglePlayPurchases$State$Uninitialized)) {
            guildBoostViewModel$ViewState$Loaded = GuildBoostViewModel$ViewState$Loading.INSTANCE;
        } else if ((guildBoostState instanceof StoreGuildBoost$State$Failure) || (subscriptionState instanceof StoreSubscriptions$SubscriptionsState$Failure) || !(guildBoostState instanceof StoreGuildBoost$State$Loaded) || !(subscriptionState instanceof StoreSubscriptions$SubscriptionsState$Loaded) || !(purchasesState instanceof StoreGooglePlayPurchases$State$Loaded)) {
            guildBoostViewModel$ViewState$Loaded = GuildBoostViewModel$ViewState$Failure.INSTANCE;
        } else {
            if (storeState.getGuild() == null) {
                GuildBoostViewModel$ViewState$Failure guildBoostViewModel$ViewState$Failure = GuildBoostViewModel$ViewState$Failure.INSTANCE;
                return;
            }
            guildBoostViewModel$ViewState$Loaded = new GuildBoostViewModel$ViewState$Loaded(((StoreGuildBoost$State$Loaded) guildBoostState).getBoostSlotMap(), ((StoreSubscriptions$SubscriptionsState$Loaded) subscriptionState).getPremiumSubscription(), ((StoreGooglePlayPurchases$State$Loaded) purchasesState).getPurchases(), storeState.getMeUser(), storeState.getGuild());
        }
        updateViewState(guildBoostViewModel$ViewState$Loaded);
    }

    public final Observable<GuildBoostViewModel$Event> observeEvents() {
        PublishSubject<GuildBoostViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void retryClicked() {
        fetchData();
    }

    @MainThread
    public final void subscribeClicked(String section) {
        boolean z2;
        m.checkNotNullParameter(section, "section");
        GuildBoostViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof GuildBoostViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        GuildBoostViewModel$ViewState$Loaded guildBoostViewModel$ViewState$Loaded = (GuildBoostViewModel$ViewState$Loaded) viewState;
        if (guildBoostViewModel$ViewState$Loaded != null) {
            Map<Long, ModelGuildBoostSlot> boostSlotMap = guildBoostViewModel$ViewState$Loaded.getBoostSlotMap();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map$Entry<Long, ModelGuildBoostSlot>> it = boostSlotMap.entrySet().iterator();
            while (true) {
                z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Map$Entry<Long, ModelGuildBoostSlot> next = it.next();
                ModelGuildBoostSlot value = next.getValue();
                if (value.getCooldownExpiresAtTimestamp() < this.clock.currentTimeMillis()) {
                    ModelAppliedGuildBoost premiumGuildSubscription = value.getPremiumGuildSubscription();
                    if ((premiumGuildSubscription != null ? Long.valueOf(premiumGuildSubscription.getGuildId()) : null) == null) {
                        z2 = true;
                    }
                }
                if (z2) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            if (!linkedHashMap.isEmpty()) {
                this.eventSubject.k.onNext(new GuildBoostViewModel$Event$LaunchSubscriptionConfirmation(guildBoostViewModel$ViewState$Loaded.getGuild().getId(), ((ModelGuildBoostSlot) u.first(linkedHashMap.values())).getId()));
                return;
            }
            ModelSubscription premiumSubscription = guildBoostViewModel$ViewState$Loaded.getPremiumSubscription();
            if (premiumSubscription != null && !premiumSubscription.isGoogleSubscription()) {
                this.eventSubject.k.onNext(GuildBoostViewModel$Event$ShowDesktopAlertDialog.INSTANCE);
                return;
            }
            if ((premiumSubscription != null ? premiumSubscription.getRenewalMutations() : null) != null) {
                this.eventSubject.k.onNext(new GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog(2131894139, 2131894137));
                return;
            }
            if ((premiumSubscription != null ? premiumSubscription.getStatus() : null) == ModelSubscription$Status.CANCELED) {
                this.eventSubject.k.onNext(new GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog(2131894139, 2131894136));
                return;
            }
            if ((premiumSubscription != null ? premiumSubscription.getStatus() : null) == ModelSubscription$Status.ACCOUNT_HOLD) {
                this.eventSubject.k.onNext(new GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog(2131894135, 2131894134));
                return;
            }
            List<Purchase> purchases = guildBoostViewModel$ViewState$Loaded.getPurchases();
            if (!(purchases instanceof Collection) || !purchases.isEmpty()) {
                Iterator<T> it2 = purchases.iterator();
                while (it2.hasNext()) {
                    if (!((Purchase) it2.next()).c()) {
                        z2 = true;
                        break;
                    }
                }
            }
            if (z2) {
                this.eventSubject.k.onNext(GuildBoostViewModel$Event$UnacknowledgedPurchase.INSTANCE);
            } else {
                PublishSubject<GuildBoostViewModel$Event> publishSubject = this.eventSubject;
                long id2 = guildBoostViewModel$ViewState$Loaded.getGuild().getId();
                ModelSubscription premiumSubscription2 = guildBoostViewModel$ViewState$Loaded.getPremiumSubscription();
                publishSubject.k.onNext(new GuildBoostViewModel$Event$LaunchPurchaseSubscription(section, id2, premiumSubscription2 != null ? premiumSubscription2.getPaymentGatewayPlanId() : null));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostViewModel(long j, StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, Clock clock, Observable<GuildBoostViewModel$StoreState> observable) {
        super(GuildBoostViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        m.checkNotNullParameter(storeSubscriptions, "storeSubscriptions");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.storeGuildBoost = storeGuildBoost;
        this.storeSubscriptions = storeSubscriptions;
        this.clock = clock;
        this.eventSubject = PublishSubject.k0();
        fetchData();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildBoostViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildBoostViewModel$1(this), 62, (Object) null);
    }
}
