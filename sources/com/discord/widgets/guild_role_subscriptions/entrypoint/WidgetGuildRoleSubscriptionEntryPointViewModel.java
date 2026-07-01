package com.discord.widgets.guild_role_subscriptions.entrypoint;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreConnectivity;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.t;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionEntryPointViewModel extends d0<WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState> {
    private final StoreConnectivity connectivityStore;
    private final StoreExperiments experimentsStore;
    private final StoreGuildRoleSubscriptions guildRoleSubscriptionsStore;
    private final StoreGuilds guildsStore;
    private boolean hasSubmittedAnalytics;
    private final ObservationDeck observationDeck;
    private Subscription storeObservableSubscription;
    private final StoreSubscriptions subscriptionsStore;
    private String trackingSourceLocation;

    public WidgetGuildRoleSubscriptionEntryPointViewModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ WidgetGuildRoleSubscriptionEntryPointViewModel(StoreConnectivity storeConnectivity, StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreSubscriptions storeSubscriptions, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getConnectivity() : storeConnectivity, (i & 2) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments, (i & 4) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 8) != 0 ? StoreStream.Companion.getSubscriptions() : storeSubscriptions, (i & 16) != 0 ? StoreStream.Companion.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions, (i & 32) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ StoreConnectivity access$getConnectivityStore$p(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel) {
        return widgetGuildRoleSubscriptionEntryPointViewModel.connectivityStore;
    }

    public static final /* synthetic */ StoreGuildRoleSubscriptions access$getGuildRoleSubscriptionsStore$p(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel) {
        return widgetGuildRoleSubscriptionEntryPointViewModel.guildRoleSubscriptionsStore;
    }

    public static final /* synthetic */ StoreGuilds access$getGuildsStore$p(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel) {
        return widgetGuildRoleSubscriptionEntryPointViewModel.guildsStore;
    }

    public static final /* synthetic */ Subscription access$getStoreObservableSubscription$p(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel) {
        return widgetGuildRoleSubscriptionEntryPointViewModel.storeObservableSubscription;
    }

    public static final /* synthetic */ StoreSubscriptions access$getSubscriptionsStore$p(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel) {
        return widgetGuildRoleSubscriptionEntryPointViewModel.subscriptionsStore;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel, WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState widgetGuildRoleSubscriptionEntryPointViewModel$StoreState) {
        widgetGuildRoleSubscriptionEntryPointViewModel.handleStoreState(widgetGuildRoleSubscriptionEntryPointViewModel$StoreState);
    }

    public static final /* synthetic */ void access$setStoreObservableSubscription$p(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel, Subscription subscription) {
        widgetGuildRoleSubscriptionEntryPointViewModel.storeObservableSubscription = subscription;
    }

    private final void handleStoreState(WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState state) {
        if (state.getGuild() != null && state.isAccessible()) {
            updateViewState(new WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid(state.getGuild()));
        } else if (state.isConnected()) {
            updateViewState(WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Invalid.INSTANCE);
        }
        String str = this.trackingSourceLocation;
        if (state.getHasUserActiveSubscription() == null || state.getGuildRoleSubscriptionGroupListingId() == null) {
            return;
        }
        if ((str == null || t.isBlank(str)) || this.hasSubmittedAnalytics) {
            return;
        }
        AnalyticsTracker.guildRoleSubscriptionUpsellOpened$default(AnalyticsTracker.INSTANCE, state.getGuildRoleSubscriptionGroupListingId().longValue(), null, state.getHasUserActiveSubscription().booleanValue(), str, 2, null);
        this.hasSubmittedAnalytics = true;
    }

    private final Observable<WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState> observeStoreState(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.connectivityStore, this.experimentsStore, this.guildsStore, this.subscriptionsStore, this.guildRoleSubscriptionsStore}, false, null, null, new WidgetGuildRoleSubscriptionEntryPointViewModel$observeStoreState$1(this, guildId), 14, null);
    }

    public static /* synthetic */ void setTrackingSourceLocation$default(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Role Subscriptions Tab";
        }
        widgetGuildRoleSubscriptionEntryPointViewModel.setTrackingSourceLocation(str);
    }

    public final void setGuildId(long id2) {
        Subscription subscription = this.storeObservableSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.guildRoleSubscriptionsStore.fetchGuildRoleSubscriptionGroupsForGuild(id2);
        Observable<WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState> observableR = observeStoreState(id2).r();
        m.checkNotNullExpressionValue(observableR, "observeStoreState(id)\n  …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetGuildRoleSubscriptionEntryPointViewModel.class, (Context) null, new WidgetGuildRoleSubscriptionEntryPointViewModel$setGuildId$1(this), (Function1) null, (Function0) null, (Function0) null, new WidgetGuildRoleSubscriptionEntryPointViewModel$setGuildId$2(this), 58, (Object) null);
    }

    public final void setTrackingSourceLocation(String trackingSourceLocation) {
        if (!m.areEqual(this.trackingSourceLocation, trackingSourceLocation)) {
            this.hasSubmittedAnalytics = false;
        }
        this.trackingSourceLocation = trackingSourceLocation;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionEntryPointViewModel(StoreConnectivity storeConnectivity, StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreSubscriptions storeSubscriptions, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck) {
        super(WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(storeConnectivity, "connectivityStore");
        m.checkNotNullParameter(storeExperiments, "experimentsStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(storeSubscriptions, "subscriptionsStore");
        m.checkNotNullParameter(storeGuildRoleSubscriptions, "guildRoleSubscriptionsStore");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.connectivityStore = storeConnectivity;
        this.experimentsStore = storeExperiments;
        this.guildsStore = storeGuilds;
        this.subscriptionsStore = storeSubscriptions;
        this.guildRoleSubscriptionsStore = storeGuildRoleSubscriptions;
        this.observationDeck = observationDeck;
        storeSubscriptions.fetchSubscriptions();
    }
}
