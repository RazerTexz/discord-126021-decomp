package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierBenefitsViewModel extends AppViewModel<ViewState> {
    private final GuildRoleSubscriptionTierBenefitListType benefitListType;
    private final StoreExperiments experimentsStore;
    private final long guildId;
    private GuildRoleSubscriptionTier guildRoleSubscriptionTier;
    private final StoreGuildRoleSubscriptions guildRoleSubscriptionsStore;
    private Boolean isFullServerGating;
    private final ObservationDeck observationDeck;
    private StoreState storeState;

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            GuildRoleSubscriptionTierBenefitsViewModel guildRoleSubscriptionTierBenefitsViewModel = GuildRoleSubscriptionTierBenefitsViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            guildRoleSubscriptionTierBenefitsViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitsViewModel.kt */
    public static final /* data */ class StoreState {
        private final List<Integer> activeTrialUserLimitOptions;
        private final boolean isGuildEligibleForTrials;
        private final List<SubscriptionTrialInterval> trialIntervalOptions;

        public StoreState(boolean z2, List<Integer> list, List<SubscriptionTrialInterval> list2) {
            Intrinsics3.checkNotNullParameter(list, "activeTrialUserLimitOptions");
            Intrinsics3.checkNotNullParameter(list2, "trialIntervalOptions");
            this.isGuildEligibleForTrials = z2;
            this.activeTrialUserLimitOptions = list;
            this.trialIntervalOptions = list2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, boolean z2, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = storeState.isGuildEligibleForTrials;
            }
            if ((i & 2) != 0) {
                list = storeState.activeTrialUserLimitOptions;
            }
            if ((i & 4) != 0) {
                list2 = storeState.trialIntervalOptions;
            }
            return storeState.copy(z2, list, list2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsGuildEligibleForTrials() {
            return this.isGuildEligibleForTrials;
        }

        public final List<Integer> component2() {
            return this.activeTrialUserLimitOptions;
        }

        public final List<SubscriptionTrialInterval> component3() {
            return this.trialIntervalOptions;
        }

        public final StoreState copy(boolean isGuildEligibleForTrials, List<Integer> activeTrialUserLimitOptions, List<SubscriptionTrialInterval> trialIntervalOptions) {
            Intrinsics3.checkNotNullParameter(activeTrialUserLimitOptions, "activeTrialUserLimitOptions");
            Intrinsics3.checkNotNullParameter(trialIntervalOptions, "trialIntervalOptions");
            return new StoreState(isGuildEligibleForTrials, activeTrialUserLimitOptions, trialIntervalOptions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.isGuildEligibleForTrials == storeState.isGuildEligibleForTrials && Intrinsics3.areEqual(this.activeTrialUserLimitOptions, storeState.activeTrialUserLimitOptions) && Intrinsics3.areEqual(this.trialIntervalOptions, storeState.trialIntervalOptions);
        }

        public final List<Integer> getActiveTrialUserLimitOptions() {
            return this.activeTrialUserLimitOptions;
        }

        public final List<SubscriptionTrialInterval> getTrialIntervalOptions() {
            return this.trialIntervalOptions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.isGuildEligibleForTrials;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            List<Integer> list = this.activeTrialUserLimitOptions;
            int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
            List<SubscriptionTrialInterval> list2 = this.trialIntervalOptions;
            return iHashCode + (list2 != null ? list2.hashCode() : 0);
        }

        public final boolean isGuildEligibleForTrials() {
            return this.isGuildEligibleForTrials;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(isGuildEligibleForTrials=");
            sbU.append(this.isGuildEligibleForTrials);
            sbU.append(", activeTrialUserLimitOptions=");
            sbU.append(this.activeTrialUserLimitOptions);
            sbU.append(", trialIntervalOptions=");
            return outline.L(sbU, this.trialIntervalOptions, ")");
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitsViewModel.kt */
    public static final /* data */ class ViewState {
        private final List<Integer> activeTrialUserLimitOptions;
        private final Boolean canAccessAllChannels;
        private final boolean canChangeChannelSettings;
        private final List<GuildRoleSubscriptionBenefitAdapterItem> items;
        private final List<SubscriptionTrialInterval> trialIntervalOptions;

        public ViewState() {
            this(false, null, null, null, null, 31, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(boolean z2, List<? extends GuildRoleSubscriptionBenefitAdapterItem> list, Boolean bool, List<Integer> list2, List<SubscriptionTrialInterval> list3) {
            Intrinsics3.checkNotNullParameter(list, "items");
            Intrinsics3.checkNotNullParameter(list2, "activeTrialUserLimitOptions");
            Intrinsics3.checkNotNullParameter(list3, "trialIntervalOptions");
            this.canChangeChannelSettings = z2;
            this.items = list;
            this.canAccessAllChannels = bool;
            this.activeTrialUserLimitOptions = list2;
            this.trialIntervalOptions = list3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, List list, Boolean bool, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = viewState.canChangeChannelSettings;
            }
            if ((i & 2) != 0) {
                list = viewState.items;
            }
            List list4 = list;
            if ((i & 4) != 0) {
                bool = viewState.canAccessAllChannels;
            }
            Boolean bool2 = bool;
            if ((i & 8) != 0) {
                list2 = viewState.activeTrialUserLimitOptions;
            }
            List list5 = list2;
            if ((i & 16) != 0) {
                list3 = viewState.trialIntervalOptions;
            }
            return viewState.copy(z2, list4, bool2, list5, list3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getCanChangeChannelSettings() {
            return this.canChangeChannelSettings;
        }

        public final List<GuildRoleSubscriptionBenefitAdapterItem> component2() {
            return this.items;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getCanAccessAllChannels() {
            return this.canAccessAllChannels;
        }

        public final List<Integer> component4() {
            return this.activeTrialUserLimitOptions;
        }

        public final List<SubscriptionTrialInterval> component5() {
            return this.trialIntervalOptions;
        }

        public final ViewState copy(boolean canChangeChannelSettings, List<? extends GuildRoleSubscriptionBenefitAdapterItem> items, Boolean canAccessAllChannels, List<Integer> activeTrialUserLimitOptions, List<SubscriptionTrialInterval> trialIntervalOptions) {
            Intrinsics3.checkNotNullParameter(items, "items");
            Intrinsics3.checkNotNullParameter(activeTrialUserLimitOptions, "activeTrialUserLimitOptions");
            Intrinsics3.checkNotNullParameter(trialIntervalOptions, "trialIntervalOptions");
            return new ViewState(canChangeChannelSettings, items, canAccessAllChannels, activeTrialUserLimitOptions, trialIntervalOptions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.canChangeChannelSettings == viewState.canChangeChannelSettings && Intrinsics3.areEqual(this.items, viewState.items) && Intrinsics3.areEqual(this.canAccessAllChannels, viewState.canAccessAllChannels) && Intrinsics3.areEqual(this.activeTrialUserLimitOptions, viewState.activeTrialUserLimitOptions) && Intrinsics3.areEqual(this.trialIntervalOptions, viewState.trialIntervalOptions);
        }

        public final List<Integer> getActiveTrialUserLimitOptions() {
            return this.activeTrialUserLimitOptions;
        }

        public final Boolean getCanAccessAllChannels() {
            return this.canAccessAllChannels;
        }

        public final boolean getCanChangeChannelSettings() {
            return this.canChangeChannelSettings;
        }

        public final List<GuildRoleSubscriptionBenefitAdapterItem> getItems() {
            return this.items;
        }

        public final List<SubscriptionTrialInterval> getTrialIntervalOptions() {
            return this.trialIntervalOptions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        public int hashCode() {
            boolean z2 = this.canChangeChannelSettings;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            List<GuildRoleSubscriptionBenefitAdapterItem> list = this.items;
            int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
            Boolean bool = this.canAccessAllChannels;
            int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
            List<Integer> list2 = this.activeTrialUserLimitOptions;
            int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<SubscriptionTrialInterval> list3 = this.trialIntervalOptions;
            return iHashCode3 + (list3 != null ? list3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(canChangeChannelSettings=");
            sbU.append(this.canChangeChannelSettings);
            sbU.append(", items=");
            sbU.append(this.items);
            sbU.append(", canAccessAllChannels=");
            sbU.append(this.canAccessAllChannels);
            sbU.append(", activeTrialUserLimitOptions=");
            sbU.append(this.activeTrialUserLimitOptions);
            sbU.append(", trialIntervalOptions=");
            return outline.L(sbU, this.trialIntervalOptions, ")");
        }

        public /* synthetic */ ViewState(boolean z2, List list, Boolean bool, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? Collections2.emptyList() : list, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? Collections2.emptyList() : list2, (i & 16) != 0 ? Collections2.emptyList() : list3);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitsViewModel$observeStoreState$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitsViewModel.kt */
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
            return new StoreState(GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().isGuildEligibleForGuildRoleSubscriptionTrials(this.$guildId), GuildRoleSubscriptionTierBenefitsViewModel.this.guildRoleSubscriptionsStore.getGuildRoleSubscriptionFreeTrialActiveUserLimitOptions(), GuildRoleSubscriptionTierBenefitsViewModel.this.guildRoleSubscriptionsStore.getGuildRoleSubscriptionFreeTrialIntervalOptions());
        }
    }

    public /* synthetic */ GuildRoleSubscriptionTierBenefitsViewModel(long j, GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType, StoreExperiments storeExperiments, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, guildRoleSubscriptionTierBenefitListType, (i & 4) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 8) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions, (i & 16) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    private final void handleStoreState(StoreState storeState) {
        this.storeState = storeState;
        updateList();
    }

    private final Observable<StoreState> observeStoreState(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.experimentsStore, this.guildRoleSubscriptionsStore}, false, null, null, new AnonymousClass1(guildId), 14, null);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003e  */
    private final void updateList() {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier;
        boolean z2;
        List<Integer> listEmptyList;
        List<SubscriptionTrialInterval> listEmptyList2;
        if (this.storeState == null || (guildRoleSubscriptionTier = this.guildRoleSubscriptionTier) == null) {
            return;
        }
        List<Benefit.ChannelBenefit> channelBenefits = guildRoleSubscriptionTier.getChannelBenefits();
        List<Benefit.IntangibleBenefit> intangibleBenefits = guildRoleSubscriptionTier.getIntangibleBenefits();
        GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType = this.benefitListType;
        long j = this.guildId;
        String name = guildRoleSubscriptionTier.getName();
        Boolean boolValueOf = Boolean.valueOf(guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(this.isFullServerGating));
        if (this.benefitListType != GuildRoleSubscriptionTierBenefitListType.ALL) {
            z2 = false;
        } else {
            StoreState storeState = this.storeState;
            if (storeState != null ? storeState.isGuildEligibleForTrials() : false) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        List<GuildRoleSubscriptionBenefitAdapterItem> listGenerateGuildRoleSubscriptionBenefitListItems = GuildRoleSubscriptionBenefitListItemGenerator.generateGuildRoleSubscriptionBenefitListItems(channelBenefits, intangibleBenefits, guildRoleSubscriptionTierBenefitListType, j, name, boolValueOf, z2, guildRoleSubscriptionTier.getTrialInterval(), guildRoleSubscriptionTier.getActiveTrialUserLimit());
        boolean z3 = Intrinsics3.areEqual(this.isFullServerGating, Boolean.TRUE) && this.benefitListType != GuildRoleSubscriptionTierBenefitListType.INTANGIBLE;
        Boolean boolValueOf2 = Boolean.valueOf(guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(this.isFullServerGating));
        StoreState storeState2 = this.storeState;
        if (storeState2 == null || (listEmptyList = storeState2.getActiveTrialUserLimitOptions()) == null) {
            listEmptyList = Collections2.emptyList();
        }
        StoreState storeState3 = this.storeState;
        if (storeState3 == null || (listEmptyList2 = storeState3.getTrialIntervalOptions()) == null) {
            listEmptyList2 = Collections2.emptyList();
        }
        updateViewState(new ViewState(z3, listGenerateGuildRoleSubscriptionBenefitListItems, boolValueOf2, listEmptyList, listEmptyList2));
    }

    public final void updateBenefits(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean isFullServerGating) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
        this.isFullServerGating = isFullServerGating;
        updateList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionTierBenefitsViewModel(long j, GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType, StoreExperiments storeExperiments, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierBenefitListType, "benefitListType");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentsStore");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "guildRoleSubscriptionsStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.guildId = j;
        this.benefitListType = guildRoleSubscriptionTierBenefitListType;
        this.experimentsStore = storeExperiments;
        this.guildRoleSubscriptionsStore = storeGuildRoleSubscriptions;
        this.observationDeck = observationDeck;
        Observable<StoreState> observableR = observeStoreState(j).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeStoreState(guildI…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) GuildRoleSubscriptionTierBenefitsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
