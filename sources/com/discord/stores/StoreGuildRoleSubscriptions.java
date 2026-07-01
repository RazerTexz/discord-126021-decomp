package com.discord.stores;

import android.content.Context;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionFreeTrialIntervalTypes;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.api.premium.PriceTierType;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, Map<Long, GuildRoleSubscriptionTierFreeTrial>> guildRoleSubscriptionFreeTrials;
    private Map<Long, ? extends Map<Long, GuildRoleSubscriptionTierFreeTrial>> guildRoleSubscriptionFreeTrialsSnapshot;
    private final Map<Long, StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState> guildRoleSubscriptionGroups;
    private Map<Long, ? extends StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState> guildRoleSubscriptionGroupsSnapshot;
    private final Map<Long, Map<Long, GuildRoleSubscriptionTierListing>> guildRoleSubscriptionTiers;
    private Map<Long, ? extends Map<Long, GuildRoleSubscriptionTierListing>> guildRoleSubscriptionTiersSnapshot;
    private StoreGuildRoleSubscriptions$PriceTierState priceTierState;
    private StoreGuildRoleSubscriptions$PriceTierState priceTierStateSnapshot;
    private final RestAPI restAPI;

    public /* synthetic */ StoreGuildRoleSubscriptions(Dispatcher dispatcher, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return storeGuildRoleSubscriptions.dispatcher;
    }

    public static final /* synthetic */ Map access$getGuildRoleSubscriptionFreeTrials$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return storeGuildRoleSubscriptions.guildRoleSubscriptionFreeTrials;
    }

    public static final /* synthetic */ Map access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return storeGuildRoleSubscriptions.guildRoleSubscriptionGroups;
    }

    public static final /* synthetic */ Map access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return storeGuildRoleSubscriptions.guildRoleSubscriptionTiers;
    }

    public static final /* synthetic */ StoreGuildRoleSubscriptions$PriceTierState access$getPriceTierState$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return storeGuildRoleSubscriptions.priceTierState;
    }

    public static final /* synthetic */ void access$handleGuildRoleSubscriptionFreeTrialListFetch(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, List list) {
        storeGuildRoleSubscriptions.handleGuildRoleSubscriptionFreeTrialListFetch(j, list);
    }

    public static final /* synthetic */ void access$handleGuildRoleSubscriptionGroupFetch(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        storeGuildRoleSubscriptions.handleGuildRoleSubscriptionGroupFetch(j, guildRoleSubscriptionGroupListing);
    }

    public static final /* synthetic */ void access$setPriceTierState$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuildRoleSubscriptions$PriceTierState storeGuildRoleSubscriptions$PriceTierState) {
        storeGuildRoleSubscriptions.priceTierState = storeGuildRoleSubscriptions$PriceTierState;
    }

    private final void handleGuildRoleSubscriptionFreeTrialListFetch(long guildId, List<GuildRoleSubscriptionTierFreeTrial> guildRoleSubscriptionFreeTrialList) {
        this.dispatcher.schedule(new StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionFreeTrialListFetch$1(this, guildRoleSubscriptionFreeTrialList, guildId));
    }

    private final void handleGuildRoleSubscriptionGroupFetch(long guildId, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        this.dispatcher.schedule(new StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionGroupFetch$1(this, guildRoleSubscriptionGroupListing, guildId));
    }

    public final void fetchGuildRoleSubscriptionGroup(long guildId, long guildRoleSubscriptionGroupId) {
        if (this.guildRoleSubscriptionGroupsSnapshot.get(Long.valueOf(guildId)) instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loading) {
            return;
        }
        this.dispatcher.schedule(new StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$1(this, guildId));
        Observable observableJ0 = GuildRoleSubscriptionsFeatureFlag.Companion.getINSTANCE().isGuildEligibleForGuildRoleSubscriptionTrials(guildId) ? Observable.j0(this.restAPI.getGuildRoleSubscriptionGroupListing(guildId, guildRoleSubscriptionGroupId), this.restAPI.getGuildRoleSubscriptionFreeTrials(guildId), StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$1.INSTANCE) : this.restAPI.getGuildRoleSubscriptionGroupListing(guildId, guildRoleSubscriptionGroupId).G(StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$2.INSTANCE);
        m.checkNotNullExpressionValue(observableJ0, "observable");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observableJ0, false, 1, null), StoreGuildRoleSubscriptions.class, (Context) null, (Function1) null, new StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3(this, guildId), (Function0) null, (Function0) null, new StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2(this, guildId), 54, (Object) null);
    }

    public final void fetchGuildRoleSubscriptionGroupsForGuild(long guildId) {
        if (this.guildRoleSubscriptionGroupsSnapshot.get(Long.valueOf(guildId)) instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loading) {
            return;
        }
        this.dispatcher.schedule(new StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$1(this, guildId));
        Observable observableJ0 = GuildRoleSubscriptionsFeatureFlag.Companion.getINSTANCE().isGuildEligibleForGuildRoleSubscriptionTrials(guildId) ? Observable.j0(this.restAPI.getGuildRoleSubscriptionGroupListings(guildId), this.restAPI.getGuildRoleSubscriptionFreeTrials(guildId), StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$observable$1.INSTANCE) : this.restAPI.getGuildRoleSubscriptionGroupListings(guildId).G(StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$observable$2.INSTANCE);
        m.checkNotNullExpressionValue(observableJ0, "observable");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observableJ0, false, 1, null), StoreGuildRoleSubscriptions.class, (Context) null, (Function1) null, new StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$3(this, guildId), (Function0) null, (Function0) null, new StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2(this, guildId), 54, (Object) null);
    }

    public final void fetchPriceTiersIfNonExisting() {
        StoreGuildRoleSubscriptions$PriceTierState storeGuildRoleSubscriptions$PriceTierState = this.priceTierState;
        if ((storeGuildRoleSubscriptions$PriceTierState instanceof StoreGuildRoleSubscriptions$PriceTierState$Loading) || (storeGuildRoleSubscriptions$PriceTierState instanceof StoreGuildRoleSubscriptions$PriceTierState$Loaded)) {
            return;
        }
        this.dispatcher.schedule(new StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$1(this));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getPriceTiers(PriceTierType.GUILD_ROLE_SUBSCRIPTIONS.getApiValue()), false, 1, null), StoreGuildRoleSubscriptions.class, (Context) null, (Function1) null, new StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$3(this), (Function0) null, (Function0) null, new StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$2(this), 54, (Object) null);
    }

    public final List<Integer> getGuildRoleSubscriptionFreeTrialActiveUserLimitOptions() {
        return n.listOf((Object[]) new Integer[]{null, 10, 25, 50, 100});
    }

    public final GuildRoleSubscriptionTierFreeTrial getGuildRoleSubscriptionFreeTrialForListing(long guildId, long listingId) {
        Map<Long, GuildRoleSubscriptionTierFreeTrial> map = this.guildRoleSubscriptionFreeTrialsSnapshot.get(Long.valueOf(guildId));
        if (map != null) {
            return map.get(Long.valueOf(listingId));
        }
        return null;
    }

    public final List<SubscriptionTrialInterval> getGuildRoleSubscriptionFreeTrialIntervalOptions() {
        GuildRoleSubscriptionFreeTrialIntervalTypes guildRoleSubscriptionFreeTrialIntervalTypes = GuildRoleSubscriptionFreeTrialIntervalTypes.DAILY;
        return n.listOf((Object[]) new SubscriptionTrialInterval[]{new SubscriptionTrialInterval(guildRoleSubscriptionFreeTrialIntervalTypes, 1), new SubscriptionTrialInterval(guildRoleSubscriptionFreeTrialIntervalTypes, 7)});
    }

    public final Map<Long, GuildRoleSubscriptionTierFreeTrial> getGuildRoleSubscriptionFreeTrials(long guildId) {
        return this.guildRoleSubscriptionFreeTrialsSnapshot.get(Long.valueOf(guildId));
    }

    public final StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState getGuildRoleSubscriptionState(long guildId) {
        List listEmptyList;
        List<Long> listI;
        StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState = this.guildRoleSubscriptionGroupsSnapshot.get(Long.valueOf(guildId));
        if (storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState == null) {
            return null;
        }
        if (!(storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded)) {
            return storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;
        }
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = ((StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded) storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState).getGuildRoleSubscriptionGroupListing();
        if (guildRoleSubscriptionGroupListing == null || (listI = guildRoleSubscriptionGroupListing.i()) == null) {
            listEmptyList = n.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listI.iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                Map<Long, GuildRoleSubscriptionTierListing> map = this.guildRoleSubscriptionTiersSnapshot.get(Long.valueOf(guildId));
                GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing = map != null ? map.get(Long.valueOf(jLongValue)) : null;
                if (guildRoleSubscriptionTierListing != null) {
                    arrayList.add(guildRoleSubscriptionTierListing);
                }
            }
            listEmptyList = arrayList;
        }
        return new StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded(guildRoleSubscriptionGroupListing != null ? GuildRoleSubscriptionGroupListing.a(guildRoleSubscriptionGroupListing, 0L, 0L, 0L, null, null, null, listEmptyList, false, Opcodes.ATHROW) : null);
    }

    /* JADX INFO: renamed from: getPriceTiersState, reason: from getter */
    public final StoreGuildRoleSubscriptions$PriceTierState getPriceTierStateSnapshot() {
        return this.priceTierStateSnapshot;
    }

    public final void handleGuildRoleSubscriptionGroupUpdate(long guildId, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        m.checkNotNullParameter(guildRoleSubscriptionGroupListing, "guildRoleSubscriptionGroupListing");
        this.dispatcher.schedule(new StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionGroupUpdate$1(this, guildId, guildRoleSubscriptionGroupListing));
    }

    public final void handleGuildRoleSubscriptionTierListingCreate(long guildId, long guildRoleSubscriptionGroupListingId, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        m.checkNotNullParameter(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
        handleGuildRoleSubscriptionTierListingUpdate(guildId, guildRoleSubscriptionTierListing);
        fetchGuildRoleSubscriptionGroup(guildId, guildRoleSubscriptionGroupListingId);
    }

    public final void handleGuildRoleSubscriptionTierListingDelete(long guildId, long guildRoleSubscriptionGroupListingId, long guildRoleSubscriptionTierListingId) {
        this.dispatcher.schedule(new StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierListingDelete$1(this, guildId, guildRoleSubscriptionTierListingId));
        fetchGuildRoleSubscriptionGroup(guildId, guildRoleSubscriptionGroupListingId);
    }

    public final void handleGuildRoleSubscriptionTierListingUpdate(long guildId, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        m.checkNotNullParameter(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
        this.dispatcher.schedule(new StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierListingUpdate$1(this, guildId, guildRoleSubscriptionTierListing));
    }

    public final void handleGuildRoleSubscriptionTierTrialUpdate(long guildId, long guildRoleSubscriptionGroupListingId, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
        m.checkNotNullParameter(guildRoleSubscriptionTierFreeTrial, "guildRoleSubscriptionTierFreeTrial");
        this.dispatcher.schedule(new StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierTrialUpdate$1(this, guildId, guildRoleSubscriptionTierFreeTrial, guildRoleSubscriptionGroupListingId));
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.priceTierStateSnapshot = this.priceTierState;
        this.guildRoleSubscriptionGroupsSnapshot = new HashMap(this.guildRoleSubscriptionGroups);
        this.guildRoleSubscriptionTiersSnapshot = new HashMap(this.guildRoleSubscriptionTiers);
        this.guildRoleSubscriptionFreeTrialsSnapshot = new HashMap(this.guildRoleSubscriptionFreeTrials);
    }

    public StoreGuildRoleSubscriptions(Dispatcher dispatcher, RestAPI restAPI) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        StoreGuildRoleSubscriptions$PriceTierState$Uninitialized storeGuildRoleSubscriptions$PriceTierState$Uninitialized = StoreGuildRoleSubscriptions$PriceTierState$Uninitialized.INSTANCE;
        this.priceTierState = storeGuildRoleSubscriptions$PriceTierState$Uninitialized;
        this.priceTierStateSnapshot = storeGuildRoleSubscriptions$PriceTierState$Uninitialized;
        this.guildRoleSubscriptionGroups = new LinkedHashMap();
        this.guildRoleSubscriptionGroupsSnapshot = h0.emptyMap();
        this.guildRoleSubscriptionTiers = new LinkedHashMap();
        this.guildRoleSubscriptionTiersSnapshot = h0.emptyMap();
        this.guildRoleSubscriptionFreeTrials = new LinkedHashMap();
        this.guildRoleSubscriptionFreeTrialsSnapshot = h0.emptyMap();
    }
}
