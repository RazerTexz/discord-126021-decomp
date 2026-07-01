package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit$ChannelBenefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit$IntangibleBenefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierBenefitsViewModel extends d0<GuildRoleSubscriptionTierBenefitsViewModel$ViewState> {
    private final GuildRoleSubscriptionTierBenefitListType benefitListType;
    private final StoreExperiments experimentsStore;
    private final long guildId;
    private GuildRoleSubscriptionTier guildRoleSubscriptionTier;
    private final StoreGuildRoleSubscriptions guildRoleSubscriptionsStore;
    private Boolean isFullServerGating;
    private final ObservationDeck observationDeck;
    private GuildRoleSubscriptionTierBenefitsViewModel$StoreState storeState;

    public /* synthetic */ GuildRoleSubscriptionTierBenefitsViewModel(long j, GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType, StoreExperiments storeExperiments, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, guildRoleSubscriptionTierBenefitListType, (i & 4) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments, (i & 8) != 0 ? StoreStream.Companion.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions, (i & 16) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ StoreGuildRoleSubscriptions access$getGuildRoleSubscriptionsStore$p(GuildRoleSubscriptionTierBenefitsViewModel guildRoleSubscriptionTierBenefitsViewModel) {
        return guildRoleSubscriptionTierBenefitsViewModel.guildRoleSubscriptionsStore;
    }

    public static final /* synthetic */ void access$handleStoreState(GuildRoleSubscriptionTierBenefitsViewModel guildRoleSubscriptionTierBenefitsViewModel, GuildRoleSubscriptionTierBenefitsViewModel$StoreState guildRoleSubscriptionTierBenefitsViewModel$StoreState) {
        guildRoleSubscriptionTierBenefitsViewModel.handleStoreState(guildRoleSubscriptionTierBenefitsViewModel$StoreState);
    }

    private final void handleStoreState(GuildRoleSubscriptionTierBenefitsViewModel$StoreState storeState) {
        this.storeState = storeState;
        updateList();
    }

    private final Observable<GuildRoleSubscriptionTierBenefitsViewModel$StoreState> observeStoreState(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.experimentsStore, this.guildRoleSubscriptionsStore}, false, null, null, new GuildRoleSubscriptionTierBenefitsViewModel$observeStoreState$1(this, guildId), 14, null);
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
        List<Benefit$ChannelBenefit> channelBenefits = guildRoleSubscriptionTier.getChannelBenefits();
        List<Benefit$IntangibleBenefit> intangibleBenefits = guildRoleSubscriptionTier.getIntangibleBenefits();
        GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType = this.benefitListType;
        long j = this.guildId;
        String name = guildRoleSubscriptionTier.getName();
        Boolean boolValueOf = Boolean.valueOf(guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(this.isFullServerGating));
        if (this.benefitListType != GuildRoleSubscriptionTierBenefitListType.ALL) {
            z2 = false;
        } else {
            GuildRoleSubscriptionTierBenefitsViewModel$StoreState guildRoleSubscriptionTierBenefitsViewModel$StoreState = this.storeState;
            if (guildRoleSubscriptionTierBenefitsViewModel$StoreState != null ? guildRoleSubscriptionTierBenefitsViewModel$StoreState.isGuildEligibleForTrials() : false) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        List<GuildRoleSubscriptionBenefitAdapterItem> listGenerateGuildRoleSubscriptionBenefitListItems = GuildRoleSubscriptionBenefitListItemGeneratorKt.generateGuildRoleSubscriptionBenefitListItems(channelBenefits, intangibleBenefits, guildRoleSubscriptionTierBenefitListType, j, name, boolValueOf, z2, guildRoleSubscriptionTier.getTrialInterval(), guildRoleSubscriptionTier.getActiveTrialUserLimit());
        boolean z3 = m.areEqual(this.isFullServerGating, Boolean.TRUE) && this.benefitListType != GuildRoleSubscriptionTierBenefitListType.INTANGIBLE;
        Boolean boolValueOf2 = Boolean.valueOf(guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(this.isFullServerGating));
        GuildRoleSubscriptionTierBenefitsViewModel$StoreState guildRoleSubscriptionTierBenefitsViewModel$StoreState2 = this.storeState;
        if (guildRoleSubscriptionTierBenefitsViewModel$StoreState2 == null || (listEmptyList = guildRoleSubscriptionTierBenefitsViewModel$StoreState2.getActiveTrialUserLimitOptions()) == null) {
            listEmptyList = n.emptyList();
        }
        GuildRoleSubscriptionTierBenefitsViewModel$StoreState guildRoleSubscriptionTierBenefitsViewModel$StoreState3 = this.storeState;
        if (guildRoleSubscriptionTierBenefitsViewModel$StoreState3 == null || (listEmptyList2 = guildRoleSubscriptionTierBenefitsViewModel$StoreState3.getTrialIntervalOptions()) == null) {
            listEmptyList2 = n.emptyList();
        }
        updateViewState(new GuildRoleSubscriptionTierBenefitsViewModel$ViewState(z3, listGenerateGuildRoleSubscriptionBenefitListItems, boolValueOf2, listEmptyList, listEmptyList2));
    }

    public final void updateBenefits(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean isFullServerGating) {
        m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
        this.isFullServerGating = isFullServerGating;
        updateList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionTierBenefitsViewModel(long j, GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType, StoreExperiments storeExperiments, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck) {
        super(null, 1, null);
        m.checkNotNullParameter(guildRoleSubscriptionTierBenefitListType, "benefitListType");
        m.checkNotNullParameter(storeExperiments, "experimentsStore");
        m.checkNotNullParameter(storeGuildRoleSubscriptions, "guildRoleSubscriptionsStore");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.guildId = j;
        this.benefitListType = guildRoleSubscriptionTierBenefitListType;
        this.experimentsStore = storeExperiments;
        this.guildRoleSubscriptionsStore = storeGuildRoleSubscriptions;
        this.observationDeck = observationDeck;
        Observable<GuildRoleSubscriptionTierBenefitsViewModel$StoreState> observableR = observeStoreState(j).r();
        m.checkNotNullExpressionValue(observableR, "observeStoreState(guildI…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), GuildRoleSubscriptionTierBenefitsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildRoleSubscriptionTierBenefitsViewModel$1(this), 62, (Object) null);
    }
}
