package com.discord.stores;

import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.persister.Persister;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;

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
                C12238m.checkNotNullParameter(map, "relationships");
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
                C12238m.checkNotNullParameter(relationships, "relationships");
                return new Loaded(relationships);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.relationships, ((Loaded) other).relationships);
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
                return C1643a.m825M(C1643a.m833U("Loaded(relationships="), this.relationships, ")");
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

    /* JADX INFO: renamed from: com.discord.stores.StoreUserRelationships$observe$1 */
    /* JADX INFO: compiled from: StoreUserRelationships.kt */
    public static final class C65911 extends AbstractC12240o implements Function0<Map<Long, ? extends Integer>> {
        public C65911() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Integer> invoke() {
            UserRelationshipsState userRelationshipsState = StoreUserRelationships.this.relationshipsStateSnapshot;
            if (C12238m.areEqual(userRelationshipsState, UserRelationshipsState.Unloaded.INSTANCE)) {
                return C12136h0.emptyMap();
            }
            if (!(userRelationshipsState instanceof UserRelationshipsState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            UserRelationshipsState userRelationshipsState2 = StoreUserRelationships.this.relationshipsStateSnapshot;
            Objects.requireNonNull(userRelationshipsState2, "null cannot be cast to non-null type com.discord.stores.StoreUserRelationships.UserRelationshipsState.Loaded");
            return ((UserRelationshipsState.Loaded) userRelationshipsState2).getRelationships();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserRelationships$observeUserRelationshipsState$1 */
    /* JADX INFO: compiled from: StoreUserRelationships.kt */
    public static final class C65951 extends AbstractC12240o implements Function0<UserRelationshipsState> {
        public C65951() {
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
        this((i & 1) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    @StoreThread
    private final UserRelationshipsState.Loaded ensureRelationshipLoaded() {
        UserRelationshipsState userRelationshipsState = this.relationshipsState;
        if (!(userRelationshipsState instanceof UserRelationshipsState.Loaded)) {
            userRelationshipsState = null;
        }
        UserRelationshipsState.Loaded loaded = (UserRelationshipsState.Loaded) userRelationshipsState;
        if (loaded == null) {
            loaded = new UserRelationshipsState.Loaded(C12136h0.emptyMap());
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
        return (loaded == null || (relationships = loaded.getRelationships()) == null) ? C12136h0.emptyMap() : relationships;
    }

    /* JADX INFO: renamed from: getRelationshipsState, reason: from getter */
    public final UserRelationshipsState getRelationshipsStateSnapshot() {
        return this.relationshipsStateSnapshot;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        List<ModelUserRelationship> relationships = payload.getRelationships();
        C12238m.checkNotNullExpressionValue(relationships, "payload\n        .relationships");
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(relationships, 10)), 16));
        for (ModelUserRelationship modelUserRelationship : relationships) {
            C12238m.checkNotNullExpressionValue(modelUserRelationship, "it");
            Long lValueOf = Long.valueOf(modelUserRelationship.getId());
            C12238m.checkNotNullExpressionValue(modelUserRelationship, "it");
            linkedHashMap.put(lValueOf, Integer.valueOf(modelUserRelationship.getType()));
        }
        this.relationshipsState = new UserRelationshipsState.Loaded(linkedHashMap);
        markChanged();
    }

    @StoreThread
    public final void handlePreLogout() {
        this.relationshipsState = UserRelationshipsState.Unloaded.INSTANCE;
        markChanged();
    }

    @StoreThread
    public final void handleRelationshipAdd(ModelUserRelationship relationship) {
        C12238m.checkNotNullParameter(relationship, "relationship");
        Map mutableMap = C12136h0.toMutableMap(ensureRelationshipLoaded().getRelationships());
        Integer num = (Integer) mutableMap.get(Long.valueOf(relationship.getId()));
        int type = relationship.getType();
        if (num != null && num.intValue() == type) {
            return;
        }
        mutableMap.put(Long.valueOf(relationship.getId()), Integer.valueOf(relationship.getType()));
        this.relationshipsState = new UserRelationshipsState.Loaded(mutableMap);
        markChanged();
    }

    @StoreThread
    public final void handleRelationshipRemove(ModelUserRelationship relationship) {
        C12238m.checkNotNullParameter(relationship, "relationship");
        Map mutableMap = C12136h0.toMutableMap(ensureRelationshipLoaded().getRelationships());
        if (mutableMap.remove(Long.valueOf(relationship.getId())) != null) {
            this.relationshipsState = new UserRelationshipsState.Loaded(mutableMap);
            markChanged();
        }
    }

    public final void init() {
        Map<Long, Integer> map = this.relationshipsCache.get();
        if (!C12238m.areEqual(map, StoreUserRelationshipsKt.UNLOADED_RELATIONSHIPS_SENTINEL)) {
            this.relationshipsState = new UserRelationshipsState.Loaded(map);
            markChanged();
        }
    }

    public final Observable<Map<Long, Integer>> observe() {
        Observable<Map<Long, Integer>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C65911(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Integer>> observeForType(final int relationshipType) {
        Observable<Map<Long, Integer>> observableM11112r = observe().m11083G(new InterfaceC12589b<Map<Long, ? extends Integer>, Map<Long, ? extends Integer>>() { // from class: com.discord.stores.StoreUserRelationships.observeForType.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> call(Map<Long, ? extends Integer> map) {
                return call2((Map<Long, Integer>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, Integer> call2(Map<Long, Integer> map) {
                C12238m.checkNotNullExpressionValue(map, "relationships");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                    if (entry.getValue().intValue() == relationshipType) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                return linkedHashMap;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observe()\n          .map…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<UserRelationshipsState> observeUserRelationshipsState() {
        Observable<UserRelationshipsState> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C65951(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
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
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        UserRelationshipsState.Unloaded unloaded = UserRelationshipsState.Unloaded.INSTANCE;
        this.relationshipsState = unloaded;
        this.relationshipsStateSnapshot = unloaded;
        this.relationshipsCache = new Persister<>("STORE_USER_RELATIONSHIPS_V9", StoreUserRelationshipsKt.UNLOADED_RELATIONSHIPS_SENTINEL);
    }

    public final Observable<Map<Long, Integer>> observe(final Collection<Long> userIds) {
        C12238m.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, Integer>> observableM11112r = observe().m11083G(new InterfaceC12589b<Map<Long, ? extends Integer>, Map<Long, ? extends Integer>>() { // from class: com.discord.stores.StoreUserRelationships.observe.2
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> call(Map<Long, ? extends Integer> map) {
                return call2((Map<Long, Integer>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, Integer> call2(Map<Long, Integer> map) {
                C12238m.checkNotNullExpressionValue(map, "it");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                    if (userIds.contains(Long.valueOf(entry.getKey().longValue()))) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                return linkedHashMap;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observe()\n          .map…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Integer> observe(final long userId) {
        Observable observableM11083G = observe().m11083G(new InterfaceC12589b<Map<Long, ? extends Integer>, Integer>() { // from class: com.discord.stores.StoreUserRelationships.observe.3
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Integer call(Map<Long, ? extends Integer> map) {
                return call2((Map<Long, Integer>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Integer call2(Map<Long, Integer> map) {
                return map.get(Long.valueOf(userId));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "observe()\n          .map…> relationships[userId] }");
        return observableM11083G;
    }
}
