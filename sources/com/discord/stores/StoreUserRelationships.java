package com.discord.stores;

import b.d.b.a.outline;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.persister.Persister;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreUserRelationships.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserRelationships extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final Persister<Map<Long, Integer>> relationshipsCache;
    private UserRelationshipsState relationshipsState;
    private UserRelationshipsState relationshipsStateSnapshot;

    /* JADX INFO: compiled from: StoreUserRelationships.kt */
    public static abstract class UserRelationshipsState {

        /* JADX INFO: compiled from: StoreUserRelationships.kt */
        public static final /* data */ class Loaded extends UserRelationshipsState {
            private final Map<Long, Integer> relationships;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Map<Long, Integer> map) {
                super(null);
                Intrinsics3.checkNotNullParameter(map, "relationships");
                this.relationships = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.relationships;
                }
                return loaded.copy(map);
            }

            public final Map<Long, Integer> component1() {
                return this.relationships;
            }

            public final Loaded copy(Map<Long, Integer> relationships) {
                Intrinsics3.checkNotNullParameter(relationships, "relationships");
                return new Loaded(relationships);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.relationships, ((Loaded) other).relationships);
                }
                return true;
            }

            public final Map<Long, Integer> getRelationships() {
                return this.relationships;
            }

            public int hashCode() {
                Map<Long, Integer> map = this.relationships;
                if (map != null) {
                    return map.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.M(outline.U("Loaded(relationships="), this.relationships, ")");
            }
        }

        /* JADX INFO: compiled from: StoreUserRelationships.kt */
        public static final class Unloaded extends UserRelationshipsState {
            public static final Unloaded INSTANCE = new Unloaded();

            private Unloaded() {
                super(null);
            }
        }

        private UserRelationshipsState() {
        }

        public /* synthetic */ UserRelationshipsState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserRelationships$observe$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserRelationships.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Integer>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Integer> invoke() {
            UserRelationshipsState userRelationshipsState = StoreUserRelationships.this.relationshipsStateSnapshot;
            if (Intrinsics3.areEqual(userRelationshipsState, UserRelationshipsState.Unloaded.INSTANCE)) {
                return Maps6.emptyMap();
            }
            if (!(userRelationshipsState instanceof UserRelationshipsState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            UserRelationshipsState userRelationshipsState2 = StoreUserRelationships.this.relationshipsStateSnapshot;
            Objects.requireNonNull(userRelationshipsState2, "null cannot be cast to non-null type com.discord.stores.StoreUserRelationships.UserRelationshipsState.Loaded");
            return ((UserRelationshipsState.Loaded) userRelationshipsState2).getRelationships();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserRelationships$observeUserRelationshipsState$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserRelationships.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<UserRelationshipsState> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserRelationshipsState invoke() {
            return StoreUserRelationships.this.getRelationshipsStateSnapshot();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreUserRelationships() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ StoreUserRelationships(ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    @Store3
    private final UserRelationshipsState.Loaded ensureRelationshipLoaded() {
        UserRelationshipsState userRelationshipsState = this.relationshipsState;
        if (!(userRelationshipsState instanceof UserRelationshipsState.Loaded)) {
            userRelationshipsState = null;
        }
        UserRelationshipsState.Loaded loaded = (UserRelationshipsState.Loaded) userRelationshipsState;
        if (loaded == null) {
            loaded = new UserRelationshipsState.Loaded(Maps6.emptyMap());
        }
        this.relationshipsState = loaded;
        return loaded;
    }

    public final Map<Long, Integer> getRelationships() {
        Map<Long, Integer> relationships;
        UserRelationshipsState userRelationshipsState = this.relationshipsStateSnapshot;
        if (!(userRelationshipsState instanceof UserRelationshipsState.Loaded)) {
            userRelationshipsState = null;
        }
        UserRelationshipsState.Loaded loaded = (UserRelationshipsState.Loaded) userRelationshipsState;
        return (loaded == null || (relationships = loaded.getRelationships()) == null) ? Maps6.emptyMap() : relationships;
    }

    /* JADX INFO: renamed from: getRelationshipsState, reason: from getter */
    public final UserRelationshipsState getRelationshipsStateSnapshot() {
        return this.relationshipsStateSnapshot;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<ModelUserRelationship> relationships = payload.getRelationships();
        Intrinsics3.checkNotNullExpressionValue(relationships, "payload\n        .relationships");
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(relationships, 10)), 16));
        for (ModelUserRelationship modelUserRelationship : relationships) {
            Intrinsics3.checkNotNullExpressionValue(modelUserRelationship, "it");
            Long lValueOf = Long.valueOf(modelUserRelationship.getId());
            Intrinsics3.checkNotNullExpressionValue(modelUserRelationship, "it");
            linkedHashMap.put(lValueOf, Integer.valueOf(modelUserRelationship.getType()));
        }
        this.relationshipsState = new UserRelationshipsState.Loaded(linkedHashMap);
        markChanged();
    }

    @Store3
    public final void handlePreLogout() {
        this.relationshipsState = UserRelationshipsState.Unloaded.INSTANCE;
        markChanged();
    }

    @Store3
    public final void handleRelationshipAdd(ModelUserRelationship relationship) {
        Intrinsics3.checkNotNullParameter(relationship, "relationship");
        Map mutableMap = Maps6.toMutableMap(ensureRelationshipLoaded().getRelationships());
        Integer num = (Integer) mutableMap.get(Long.valueOf(relationship.getId()));
        int type = relationship.getType();
        if (num != null && num.intValue() == type) {
            return;
        }
        mutableMap.put(Long.valueOf(relationship.getId()), Integer.valueOf(relationship.getType()));
        this.relationshipsState = new UserRelationshipsState.Loaded(mutableMap);
        markChanged();
    }

    @Store3
    public final void handleRelationshipRemove(ModelUserRelationship relationship) {
        Intrinsics3.checkNotNullParameter(relationship, "relationship");
        Map mutableMap = Maps6.toMutableMap(ensureRelationshipLoaded().getRelationships());
        if (mutableMap.remove(Long.valueOf(relationship.getId())) != null) {
            this.relationshipsState = new UserRelationshipsState.Loaded(mutableMap);
            markChanged();
        }
    }

    public final void init() {
        Map<Long, Integer> map = this.relationshipsCache.get();
        if (!Intrinsics3.areEqual(map, StoreUserRelationships2.UNLOADED_RELATIONSHIPS_SENTINEL)) {
            this.relationshipsState = new UserRelationshipsState.Loaded(map);
            markChanged();
        }
    }

    public final Observable<Map<Long, Integer>> observe() {
        Observable<Map<Long, Integer>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Integer>> observeForType(final int relationshipType) {
        Observable<Map<Long, Integer>> observableR = observe().G(new Func1<Map<Long, ? extends Integer>, Map<Long, ? extends Integer>>() { // from class: com.discord.stores.StoreUserRelationships.observeForType.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> call(Map<Long, ? extends Integer> map) {
                return call2((Map<Long, Integer>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, Integer> call2(Map<Long, Integer> map) {
                Intrinsics3.checkNotNullExpressionValue(map, "relationships");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                    if (entry.getValue().intValue() == relationshipType) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                return linkedHashMap;
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observe()\n          .map…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<UserRelationshipsState> observeUserRelationshipsState() {
        Observable<UserRelationshipsState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        UserRelationshipsState loaded;
        super.snapshotData();
        UserRelationshipsState userRelationshipsState = this.relationshipsState;
        if (userRelationshipsState instanceof UserRelationshipsState.Loaded) {
            HashMap map = new HashMap(((UserRelationshipsState.Loaded) userRelationshipsState).getRelationships());
            Persister.set$default(this.relationshipsCache, map, false, 2, null);
            loaded = new UserRelationshipsState.Loaded(map);
        } else {
            Persister.clear$default(this.relationshipsCache, false, 1, null);
            loaded = UserRelationshipsState.Unloaded.INSTANCE;
        }
        this.relationshipsStateSnapshot = loaded;
    }

    public StoreUserRelationships(ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        UserRelationshipsState.Unloaded unloaded = UserRelationshipsState.Unloaded.INSTANCE;
        this.relationshipsState = unloaded;
        this.relationshipsStateSnapshot = unloaded;
        this.relationshipsCache = new Persister<>("STORE_USER_RELATIONSHIPS_V9", StoreUserRelationships2.UNLOADED_RELATIONSHIPS_SENTINEL);
    }

    public final Observable<Map<Long, Integer>> observe(final Collection<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, Integer>> observableR = observe().G(new Func1<Map<Long, ? extends Integer>, Map<Long, ? extends Integer>>() { // from class: com.discord.stores.StoreUserRelationships.observe.2
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> call(Map<Long, ? extends Integer> map) {
                return call2((Map<Long, Integer>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, Integer> call2(Map<Long, Integer> map) {
                Intrinsics3.checkNotNullExpressionValue(map, "it");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                    if (userIds.contains(Long.valueOf(entry.getKey().longValue()))) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                return linkedHashMap;
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observe()\n          .map…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Integer> observe(final long userId) {
        Observable observableG = observe().G(new Func1<Map<Long, ? extends Integer>, Integer>() { // from class: com.discord.stores.StoreUserRelationships.observe.3
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Integer call(Map<Long, ? extends Integer> map) {
                return call2((Map<Long, Integer>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Integer call2(Map<Long, Integer> map) {
                return map.get(Long.valueOf(userId));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "observe()\n          .map…> relationships[userId] }");
        return observableG;
    }
}
