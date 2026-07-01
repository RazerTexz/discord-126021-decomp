package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.t.o;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildBoost extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private StoreGuildBoost$State state;
    private StoreGuildBoost$State stateSnapshot;

    public StoreGuildBoost(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        StoreGuildBoost$State$Loading storeGuildBoost$State$Loading = StoreGuildBoost$State$Loading.INSTANCE;
        this.state = storeGuildBoost$State$Loading;
        this.stateSnapshot = storeGuildBoost$State$Loading;
    }

    public static final /* synthetic */ StoreGuildBoost$State access$getState$p(StoreGuildBoost storeGuildBoost) {
        return storeGuildBoost.state;
    }

    public static final /* synthetic */ void access$setState$p(StoreGuildBoost storeGuildBoost, StoreGuildBoost$State storeGuildBoost$State) {
        storeGuildBoost.state = storeGuildBoost$State;
    }

    public static /* synthetic */ StoreGuildBoost$State getGuildBoostsState$default(StoreGuildBoost storeGuildBoost, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return storeGuildBoost.getGuildBoostsState(l);
    }

    public static /* synthetic */ Observable observeGuildBoostState$default(StoreGuildBoost storeGuildBoost, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return storeGuildBoost.observeGuildBoostState(l);
    }

    public final void fetchUserGuildBoostState() {
        this.dispatcher.schedule(new StoreGuildBoost$fetchUserGuildBoostState$1(this));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getSubscriptionSlots(), false, 1, null), StoreGuildBoost.class, (Context) null, (Function1) null, new StoreGuildBoost$fetchUserGuildBoostState$2(this), (Function0) null, (Function0) null, new StoreGuildBoost$fetchUserGuildBoostState$3(this), 54, (Object) null);
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final StoreGuildBoost$State getGuildBoostsState(Long guildId) {
        StoreGuildBoost$State stateSnapshot = getStateSnapshot();
        return stateSnapshot instanceof StoreGuildBoost$State$Loaded ? ((StoreGuildBoost$State$Loaded) stateSnapshot).filterByGuildId(guildId) : stateSnapshot;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    /* JADX INFO: renamed from: getState, reason: from getter */
    public final StoreGuildBoost$State getStateSnapshot() {
        return this.stateSnapshot;
    }

    @StoreThread
    public final void handleFetchError() {
        this.state = StoreGuildBoost$State$Failure.INSTANCE;
        markChanged();
    }

    @StoreThread
    public final void handleFetchStateSuccess(List<ModelGuildBoostSlot> guildBoostSlots) {
        m.checkNotNullParameter(guildBoostSlots, "guildBoostSlots");
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(guildBoostSlots, 10)), 16));
        for (Object obj : guildBoostSlots) {
            linkedHashMap.put(Long.valueOf(((ModelGuildBoostSlot) obj).getId()), obj);
        }
        this.state = new StoreGuildBoost$State$Loaded(linkedHashMap);
        markChanged();
    }

    @StoreThread
    public final void handleFetchingState() {
        this.state = StoreGuildBoost$State$Loading.INSTANCE;
        markChanged();
    }

    public final Observable<StoreGuildBoost$State> observeGuildBoostState(Long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildBoost$observeGuildBoostState$1(this, guildId), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        StoreGuildBoost$State storeGuildBoost$State$Loaded = this.state;
        if (!(storeGuildBoost$State$Loaded instanceof StoreGuildBoost$State$Loading) && !(storeGuildBoost$State$Loaded instanceof StoreGuildBoost$State$Failure)) {
            if (!(storeGuildBoost$State$Loaded instanceof StoreGuildBoost$State$Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            storeGuildBoost$State$Loaded = new StoreGuildBoost$State$Loaded(h0.toMap(((StoreGuildBoost$State$Loaded) storeGuildBoost$State$Loaded).getBoostSlotMap()));
        }
        this.stateSnapshot = storeGuildBoost$State$Loaded;
    }

    public final void updateGuildBoostSlot(ModelGuildBoostSlot newSlot) {
        m.checkNotNullParameter(newSlot, "newSlot");
        this.dispatcher.schedule(new StoreGuildBoost$updateGuildBoostSlot$1(this, newSlot));
    }
}
