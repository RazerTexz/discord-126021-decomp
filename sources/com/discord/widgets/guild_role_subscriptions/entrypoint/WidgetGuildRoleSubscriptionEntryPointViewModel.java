package com.discord.widgets.guild_role_subscriptions.entrypoint;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreConnectivity;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtilsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionEntryPointViewModel extends AbstractC0859d0<ViewState> {
    private final StoreConnectivity connectivityStore;
    private final StoreExperiments experimentsStore;
    private final StoreGuildRoleSubscriptions guildRoleSubscriptionsStore;
    private final StoreGuilds guildsStore;
    private boolean hasSubmittedAnalytics;
    private final ObservationDeck observationDeck;
    private Subscription storeObservableSubscription;
    private final StoreSubscriptions subscriptionsStore;
    private String trackingSourceLocation;

    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final Long guildRoleSubscriptionGroupListingId;
        private final Boolean hasUserActiveSubscription;
        private final boolean isAccessible;
        private final boolean isConnected;

        public StoreState(boolean z2, boolean z3, Guild guild, Boolean bool, Long l) {
            this.isConnected = z2;
            this.isAccessible = z3;
            this.guild = guild;
            this.hasUserActiveSubscription = bool;
            this.guildRoleSubscriptionGroupListingId = l;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, boolean z2, boolean z3, Guild guild, Boolean bool, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = storeState.isConnected;
            }
            if ((i & 2) != 0) {
                z3 = storeState.isAccessible;
            }
            boolean z4 = z3;
            if ((i & 4) != 0) {
                guild = storeState.guild;
            }
            Guild guild2 = guild;
            if ((i & 8) != 0) {
                bool = storeState.hasUserActiveSubscription;
            }
            Boolean bool2 = bool;
            if ((i & 16) != 0) {
                l = storeState.guildRoleSubscriptionGroupListingId;
            }
            return storeState.copy(z2, z4, guild2, bool2, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsConnected() {
            return this.isConnected;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsAccessible() {
            return this.isAccessible;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getHasUserActiveSubscription() {
            return this.hasUserActiveSubscription;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Long getGuildRoleSubscriptionGroupListingId() {
            return this.guildRoleSubscriptionGroupListingId;
        }

        public final StoreState copy(boolean isConnected, boolean isAccessible, Guild guild, Boolean hasUserActiveSubscription, Long guildRoleSubscriptionGroupListingId) {
            return new StoreState(isConnected, isAccessible, guild, hasUserActiveSubscription, guildRoleSubscriptionGroupListingId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.isConnected == storeState.isConnected && this.isAccessible == storeState.isAccessible && C12238m.areEqual(this.guild, storeState.guild) && C12238m.areEqual(this.hasUserActiveSubscription, storeState.hasUserActiveSubscription) && C12238m.areEqual(this.guildRoleSubscriptionGroupListingId, storeState.guildRoleSubscriptionGroupListingId);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Long getGuildRoleSubscriptionGroupListingId() {
            return this.guildRoleSubscriptionGroupListingId;
        }

        public final Boolean getHasUserActiveSubscription() {
            return this.hasUserActiveSubscription;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11 */
        public int hashCode() {
            boolean z2 = this.isConnected;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isAccessible;
            int i2 = (i + (z3 ? 1 : z3)) * 31;
            Guild guild = this.guild;
            int iHashCode = (i2 + (guild != null ? guild.hashCode() : 0)) * 31;
            Boolean bool = this.hasUserActiveSubscription;
            int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
            Long l = this.guildRoleSubscriptionGroupListingId;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public final boolean isAccessible() {
            return this.isAccessible;
        }

        public final boolean isConnected() {
            return this.isConnected;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(isConnected=");
            sbM833U.append(this.isConnected);
            sbM833U.append(", isAccessible=");
            sbM833U.append(this.isAccessible);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", hasUserActiveSubscription=");
            sbM833U.append(this.hasUserActiveSubscription);
            sbM833U.append(", guildRoleSubscriptionGroupListingId=");
            return C1643a.m819G(sbM833U, this.guildRoleSubscriptionGroupListingId, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final Guild guild;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild) {
                super(null);
                C12238m.checkNotNullParameter(guild, "guild");
                this.guild = guild;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                return valid.copy(guild);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final Valid copy(Guild guild) {
                C12238m.checkNotNullParameter(guild, "guild");
                return new Valid(guild);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Valid) && C12238m.areEqual(this.guild, ((Valid) other).guild);
                }
                return true;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public int hashCode() {
                Guild guild = this.guild;
                if (guild != null) {
                    return guild.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Valid(guild=");
                sbM833U.append(this.guild);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPointViewModel$observeStoreState$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
    public static final class C84461 extends AbstractC12240o implements Function0<StoreState> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C84461(long j) {
            super(0);
            this.$guildId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StoreState invoke() {
            StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionState = WidgetGuildRoleSubscriptionEntryPointViewModel.this.guildRoleSubscriptionsStore.getGuildRoleSubscriptionState(this.$guildId);
            Boolean boolValueOf = null;
            if (!(guildRoleSubscriptionState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded)) {
                guildRoleSubscriptionState = null;
            }
            StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded loaded = (StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded) guildRoleSubscriptionState;
            GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = loaded != null ? loaded.getGuildRoleSubscriptionGroupListing() : null;
            StoreSubscriptions.SubscriptionsState subscriptionsStateSnapshot = WidgetGuildRoleSubscriptionEntryPointViewModel.this.subscriptionsStore.getSubscriptionsStateSnapshot();
            if (!(subscriptionsStateSnapshot instanceof StoreSubscriptions.SubscriptionsState.Loaded)) {
                subscriptionsStateSnapshot = null;
            }
            StoreSubscriptions.SubscriptionsState.Loaded loaded2 = (StoreSubscriptions.SubscriptionsState.Loaded) subscriptionsStateSnapshot;
            List<ModelSubscription> subscriptions = loaded2 != null ? loaded2.getSubscriptions() : null;
            Long lValueOf = guildRoleSubscriptionGroupListing != null ? Long.valueOf(guildRoleSubscriptionGroupListing.getId()) : null;
            if (subscriptions != null && guildRoleSubscriptionGroupListing != null) {
                boolValueOf = Boolean.valueOf(GuildRoleSubscriptionUtilsKt.hasUserActiveSubscriptionFor(guildRoleSubscriptionGroupListing, subscriptions));
            }
            return new StoreState(WidgetGuildRoleSubscriptionEntryPointViewModel.this.connectivityStore.isConnected(), GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().canGuildSeePremiumMemberships(this.$guildId), WidgetGuildRoleSubscriptionEntryPointViewModel.this.guildsStore.getGuild(this.$guildId), boolValueOf, lValueOf);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPointViewModel$setGuildId$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
    public static final class C84471 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C84471() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            WidgetGuildRoleSubscriptionEntryPointViewModel.this.storeObservableSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPointViewModel$setGuildId$2 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
    public static final class C84482 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C84482() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel = WidgetGuildRoleSubscriptionEntryPointViewModel.this;
            C12238m.checkNotNullExpressionValue(storeState, "storeState");
            widgetGuildRoleSubscriptionEntryPointViewModel.handleStoreState(storeState);
        }
    }

    public WidgetGuildRoleSubscriptionEntryPointViewModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ WidgetGuildRoleSubscriptionEntryPointViewModel(StoreConnectivity storeConnectivity, StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreSubscriptions storeSubscriptions, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getConnectivity() : storeConnectivity, (i & 2) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 8) != 0 ? StoreStream.INSTANCE.getSubscriptions() : storeSubscriptions, (i & 16) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions, (i & 32) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    private final void handleStoreState(StoreState state) {
        if (state.getGuild() != null && state.isAccessible()) {
            updateViewState(new ViewState.Valid(state.getGuild()));
        } else if (state.isConnected()) {
            updateViewState(ViewState.Invalid.INSTANCE);
        }
        String str = this.trackingSourceLocation;
        if (state.getHasUserActiveSubscription() == null || state.getGuildRoleSubscriptionGroupListingId() == null) {
            return;
        }
        if ((str == null || C12103t.isBlank(str)) || this.hasSubmittedAnalytics) {
            return;
        }
        AnalyticsTracker.guildRoleSubscriptionUpsellOpened$default(AnalyticsTracker.INSTANCE, state.getGuildRoleSubscriptionGroupListingId().longValue(), null, state.getHasUserActiveSubscription().booleanValue(), str, 2, null);
        this.hasSubmittedAnalytics = true;
    }

    private final Observable<StoreState> observeStoreState(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.connectivityStore, this.experimentsStore, this.guildsStore, this.subscriptionsStore, this.guildRoleSubscriptionsStore}, false, null, null, new C84461(guildId), 14, null);
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
        Observable<StoreState> observableM11112r = observeStoreState(id2).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeStoreState(id)\n  …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionEntryPointViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C84471()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84482());
    }

    public final void setTrackingSourceLocation(String trackingSourceLocation) {
        if (!C12238m.areEqual(this.trackingSourceLocation, trackingSourceLocation)) {
            this.hasSubmittedAnalytics = false;
        }
        this.trackingSourceLocation = trackingSourceLocation;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionEntryPointViewModel(StoreConnectivity storeConnectivity, StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreSubscriptions storeSubscriptions, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck) {
        super(ViewState.Uninitialized.INSTANCE);
        C12238m.checkNotNullParameter(storeConnectivity, "connectivityStore");
        C12238m.checkNotNullParameter(storeExperiments, "experimentsStore");
        C12238m.checkNotNullParameter(storeGuilds, "guildsStore");
        C12238m.checkNotNullParameter(storeSubscriptions, "subscriptionsStore");
        C12238m.checkNotNullParameter(storeGuildRoleSubscriptions, "guildRoleSubscriptionsStore");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.connectivityStore = storeConnectivity;
        this.experimentsStore = storeExperiments;
        this.guildsStore = storeGuilds;
        this.subscriptionsStore = storeSubscriptions;
        this.guildRoleSubscriptionsStore = storeGuildRoleSubscriptions;
        this.observationDeck = observationDeck;
        storeSubscriptions.fetchSubscriptions();
    }
}
