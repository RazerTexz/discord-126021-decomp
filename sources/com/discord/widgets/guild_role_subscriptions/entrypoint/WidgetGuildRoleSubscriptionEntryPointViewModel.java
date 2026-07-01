package com.discord.widgets.guild_role_subscriptions.entrypoint;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
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
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils2;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionEntryPointViewModel extends AppViewModel<ViewState> {
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
            return this.isConnected == storeState.isConnected && this.isAccessible == storeState.isAccessible && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.hasUserActiveSubscription, storeState.hasUserActiveSubscription) && Intrinsics3.areEqual(this.guildRoleSubscriptionGroupListingId, storeState.guildRoleSubscriptionGroupListingId);
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
            StringBuilder sbU = outline.U("StoreState(isConnected=");
            sbU.append(this.isConnected);
            sbU.append(", isAccessible=");
            sbU.append(this.isAccessible);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", hasUserActiveSubscription=");
            sbU.append(this.hasUserActiveSubscription);
            sbU.append(", guildRoleSubscriptionGroupListingId=");
            return outline.G(sbU, this.guildRoleSubscriptionGroupListingId, ")");
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
                Intrinsics3.checkNotNullParameter(guild, "guild");
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
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Valid(guild);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Valid) && Intrinsics3.areEqual(this.guild, ((Valid) other).guild);
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
                StringBuilder sbU = outline.U("Valid(guild=");
                sbU.append(this.guild);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPointViewModel$observeStoreState$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<StoreState> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
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
                boolValueOf = Boolean.valueOf(GuildRoleSubscriptionUtils2.hasUserActiveSubscriptionFor(guildRoleSubscriptionGroupListing, subscriptions));
            }
            return new StoreState(WidgetGuildRoleSubscriptionEntryPointViewModel.this.connectivityStore.isConnected(), GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().canGuildSeePremiumMemberships(this.$guildId), WidgetGuildRoleSubscriptionEntryPointViewModel.this.guildsStore.getGuild(this.$guildId), boolValueOf, lValueOf);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPointViewModel$setGuildId$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetGuildRoleSubscriptionEntryPointViewModel.this.storeObservableSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPointViewModel$setGuildId$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel = WidgetGuildRoleSubscriptionEntryPointViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            widgetGuildRoleSubscriptionEntryPointViewModel.handleStoreState(storeState);
        }
    }

    public WidgetGuildRoleSubscriptionEntryPointViewModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ WidgetGuildRoleSubscriptionEntryPointViewModel(StoreConnectivity storeConnectivity, StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreSubscriptions storeSubscriptions, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getConnectivity() : storeConnectivity, (i & 2) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 8) != 0 ? StoreStream.INSTANCE.getSubscriptions() : storeSubscriptions, (i & 16) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions, (i & 32) != 0 ? ObservationDeck4.get() : observationDeck);
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
        if ((str == null || StringsJVM.isBlank(str)) || this.hasSubmittedAnalytics) {
            return;
        }
        AnalyticsTracker.guildRoleSubscriptionUpsellOpened$default(AnalyticsTracker.INSTANCE, state.getGuildRoleSubscriptionGroupListingId().longValue(), null, state.getHasUserActiveSubscription().booleanValue(), str, 2, null);
        this.hasSubmittedAnalytics = true;
    }

    private final Observable<StoreState> observeStoreState(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.connectivityStore, this.experimentsStore, this.guildsStore, this.subscriptionsStore, this.guildRoleSubscriptionsStore}, false, null, null, new AnonymousClass1(guildId), 14, null);
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
        Observable<StoreState> observableR = observeStoreState(id2).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeStoreState(id)\n  …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionEntryPointViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass1()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    public final void setTrackingSourceLocation(String trackingSourceLocation) {
        if (!Intrinsics3.areEqual(this.trackingSourceLocation, trackingSourceLocation)) {
            this.hasSubmittedAnalytics = false;
        }
        this.trackingSourceLocation = trackingSourceLocation;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionEntryPointViewModel(StoreConnectivity storeConnectivity, StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreSubscriptions storeSubscriptions, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeConnectivity, "connectivityStore");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentsStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeSubscriptions, "subscriptionsStore");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "guildRoleSubscriptionsStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.connectivityStore = storeConnectivity;
        this.experimentsStore = storeExperiments;
        this.guildsStore = storeGuilds;
        this.subscriptionsStore = storeSubscriptions;
        this.guildRoleSubscriptionsStore = storeGuildRoleSubscriptions;
        this.observationDeck = observationDeck;
        storeSubscriptions.fetchSubscriptions();
    }
}
