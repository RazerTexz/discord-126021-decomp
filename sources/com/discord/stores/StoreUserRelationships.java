package com.discord.stores;

import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.persister.Persister;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.t.o;
import d0.z.d.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreUserRelationships.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserRelationships extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final Persister<Map<Long, Integer>> relationshipsCache;
    private StoreUserRelationships$UserRelationshipsState relationshipsState;
    private StoreUserRelationships$UserRelationshipsState relationshipsStateSnapshot;

    public StoreUserRelationships() {
        this(null, 1, null);
    }

    public /* synthetic */ StoreUserRelationships(ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ StoreUserRelationships$UserRelationshipsState access$getRelationshipsStateSnapshot$p(StoreUserRelationships storeUserRelationships) {
        return storeUserRelationships.relationshipsStateSnapshot;
    }

    public static final /* synthetic */ void access$setRelationshipsStateSnapshot$p(StoreUserRelationships storeUserRelationships, StoreUserRelationships$UserRelationshipsState storeUserRelationships$UserRelationshipsState) {
        storeUserRelationships.relationshipsStateSnapshot = storeUserRelationships$UserRelationshipsState;
    }

    @StoreThread
    private final StoreUserRelationships$UserRelationshipsState$Loaded ensureRelationshipLoaded() {
        StoreUserRelationships$UserRelationshipsState storeUserRelationships$UserRelationshipsState = this.relationshipsState;
        if (!(storeUserRelationships$UserRelationshipsState instanceof StoreUserRelationships$UserRelationshipsState$Loaded)) {
            storeUserRelationships$UserRelationshipsState = null;
        }
        StoreUserRelationships$UserRelationshipsState$Loaded storeUserRelationships$UserRelationshipsState$Loaded = (StoreUserRelationships$UserRelationshipsState$Loaded) storeUserRelationships$UserRelationshipsState;
        if (storeUserRelationships$UserRelationshipsState$Loaded == null) {
            storeUserRelationships$UserRelationshipsState$Loaded = new StoreUserRelationships$UserRelationshipsState$Loaded(h0.emptyMap());
        }
        this.relationshipsState = storeUserRelationships$UserRelationshipsState$Loaded;
        return storeUserRelationships$UserRelationshipsState$Loaded;
    }

    public final Map<Long, Integer> getRelationships() {
        Map<Long, Integer> relationships;
        StoreUserRelationships$UserRelationshipsState storeUserRelationships$UserRelationshipsState = this.relationshipsStateSnapshot;
        if (!(storeUserRelationships$UserRelationshipsState instanceof StoreUserRelationships$UserRelationshipsState$Loaded)) {
            storeUserRelationships$UserRelationshipsState = null;
        }
        StoreUserRelationships$UserRelationshipsState$Loaded storeUserRelationships$UserRelationshipsState$Loaded = (StoreUserRelationships$UserRelationshipsState$Loaded) storeUserRelationships$UserRelationshipsState;
        return (storeUserRelationships$UserRelationshipsState$Loaded == null || (relationships = storeUserRelationships$UserRelationshipsState$Loaded.getRelationships()) == null) ? h0.emptyMap() : relationships;
    }

    /* JADX INFO: renamed from: getRelationshipsState, reason: from getter */
    public final StoreUserRelationships$UserRelationshipsState getRelationshipsStateSnapshot() {
        return this.relationshipsStateSnapshot;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        List<ModelUserRelationship> relationships = payload.getRelationships();
        m.checkNotNullExpressionValue(relationships, "payload\n        .relationships");
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(relationships, 10)), 16));
        for (ModelUserRelationship modelUserRelationship : relationships) {
            m.checkNotNullExpressionValue(modelUserRelationship, "it");
            Long lValueOf = Long.valueOf(modelUserRelationship.getId());
            m.checkNotNullExpressionValue(modelUserRelationship, "it");
            linkedHashMap.put(lValueOf, Integer.valueOf(modelUserRelationship.getType()));
        }
        this.relationshipsState = new StoreUserRelationships$UserRelationshipsState$Loaded(linkedHashMap);
        markChanged();
    }

    @StoreThread
    public final void handlePreLogout() {
        this.relationshipsState = StoreUserRelationships$UserRelationshipsState$Unloaded.INSTANCE;
        markChanged();
    }

    @StoreThread
    public final void handleRelationshipAdd(ModelUserRelationship relationship) {
        m.checkNotNullParameter(relationship, "relationship");
        Map mutableMap = h0.toMutableMap(ensureRelationshipLoaded().getRelationships());
        Integer num = (Integer) mutableMap.get(Long.valueOf(relationship.getId()));
        int type = relationship.getType();
        if (num != null && num.intValue() == type) {
            return;
        }
        mutableMap.put(Long.valueOf(relationship.getId()), Integer.valueOf(relationship.getType()));
        this.relationshipsState = new StoreUserRelationships$UserRelationshipsState$Loaded(mutableMap);
        markChanged();
    }

    @StoreThread
    public final void handleRelationshipRemove(ModelUserRelationship relationship) {
        m.checkNotNullParameter(relationship, "relationship");
        Map mutableMap = h0.toMutableMap(ensureRelationshipLoaded().getRelationships());
        if (mutableMap.remove(Long.valueOf(relationship.getId())) != null) {
            this.relationshipsState = new StoreUserRelationships$UserRelationshipsState$Loaded(mutableMap);
            markChanged();
        }
    }

    public final void init() {
        Map<Long, Integer> map = this.relationshipsCache.get();
        if (!m.areEqual(map, StoreUserRelationshipsKt.access$getUNLOADED_RELATIONSHIPS_SENTINEL$p())) {
            this.relationshipsState = new StoreUserRelationships$UserRelationshipsState$Loaded(map);
            markChanged();
        }
    }

    public final Observable<Map<Long, Integer>> observe() {
        Observable<Map<Long, Integer>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreUserRelationships$observe$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Integer>> observeForType(int relationshipType) {
        Observable<Map<Long, Integer>> observableR = observe().G(new StoreUserRelationships$observeForType$1(relationshipType)).r();
        m.checkNotNullExpressionValue(observableR, "observe()\n          .map…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<StoreUserRelationships$UserRelationshipsState> observeUserRelationshipsState() {
        Observable<StoreUserRelationships$UserRelationshipsState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreUserRelationships$observeUserRelationshipsState$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        StoreUserRelationships$UserRelationshipsState storeUserRelationships$UserRelationshipsState$Loaded;
        super.snapshotData();
        StoreUserRelationships$UserRelationshipsState storeUserRelationships$UserRelationshipsState = this.relationshipsState;
        if (storeUserRelationships$UserRelationshipsState instanceof StoreUserRelationships$UserRelationshipsState$Loaded) {
            HashMap map = new HashMap(((StoreUserRelationships$UserRelationshipsState$Loaded) storeUserRelationships$UserRelationshipsState).getRelationships());
            Persister.set$default(this.relationshipsCache, map, false, 2, null);
            storeUserRelationships$UserRelationshipsState$Loaded = new StoreUserRelationships$UserRelationshipsState$Loaded(map);
        } else {
            Persister.clear$default(this.relationshipsCache, false, 1, null);
            storeUserRelationships$UserRelationshipsState$Loaded = StoreUserRelationships$UserRelationshipsState$Unloaded.INSTANCE;
        }
        this.relationshipsStateSnapshot = storeUserRelationships$UserRelationshipsState$Loaded;
    }

    public StoreUserRelationships(ObservationDeck observationDeck) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        StoreUserRelationships$UserRelationshipsState$Unloaded storeUserRelationships$UserRelationshipsState$Unloaded = StoreUserRelationships$UserRelationshipsState$Unloaded.INSTANCE;
        this.relationshipsState = storeUserRelationships$UserRelationshipsState$Unloaded;
        this.relationshipsStateSnapshot = storeUserRelationships$UserRelationshipsState$Unloaded;
        this.relationshipsCache = new Persister<>("STORE_USER_RELATIONSHIPS_V9", StoreUserRelationshipsKt.access$getUNLOADED_RELATIONSHIPS_SENTINEL$p());
    }

    public final Observable<Map<Long, Integer>> observe(Collection<Long> userIds) {
        m.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, Integer>> observableR = observe().G(new StoreUserRelationships$observe$2(userIds)).r();
        m.checkNotNullExpressionValue(observableR, "observe()\n          .map…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Integer> observe(long userId) {
        Observable observableG = observe().G(new StoreUserRelationships$observe$3(userId));
        m.checkNotNullExpressionValue(observableG, "observe()\n          .map…> relationships[userId] }");
        return observableG;
    }
}
