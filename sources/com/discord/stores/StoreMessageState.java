package com.discord.stores;

import com.discord.api.message.Message;
import com.discord.models.domain.ModelMessageDelete;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12150o0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreMessageState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageState {
    private final Dispatcher dispatcher;
    private final BehaviorSubject<Map<Long, State>> messageStateSubject;

    /* JADX INFO: compiled from: StoreMessageState.kt */
    public static final /* data */ class State {
        private final Map<Integer, Set<String>> visibleSpoilerEmbedMap;
        private final Set<Integer> visibleSpoilerNodeIndices;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(Set<Integer> set, Map<Integer, ? extends Set<String>> map) {
            C12238m.checkNotNullParameter(set, "visibleSpoilerNodeIndices");
            C12238m.checkNotNullParameter(map, "visibleSpoilerEmbedMap");
            this.visibleSpoilerNodeIndices = set;
            this.visibleSpoilerEmbedMap = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Set set, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                set = state.visibleSpoilerNodeIndices;
            }
            if ((i & 2) != 0) {
                map = state.visibleSpoilerEmbedMap;
            }
            return state.copy(set, map);
        }

        public final Set<Integer> component1() {
            return this.visibleSpoilerNodeIndices;
        }

        public final Map<Integer, Set<String>> component2() {
            return this.visibleSpoilerEmbedMap;
        }

        public final State copy(Set<Integer> visibleSpoilerNodeIndices, Map<Integer, ? extends Set<String>> visibleSpoilerEmbedMap) {
            C12238m.checkNotNullParameter(visibleSpoilerNodeIndices, "visibleSpoilerNodeIndices");
            C12238m.checkNotNullParameter(visibleSpoilerEmbedMap, "visibleSpoilerEmbedMap");
            return new State(visibleSpoilerNodeIndices, visibleSpoilerEmbedMap);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return C12238m.areEqual(this.visibleSpoilerNodeIndices, state.visibleSpoilerNodeIndices) && C12238m.areEqual(this.visibleSpoilerEmbedMap, state.visibleSpoilerEmbedMap);
        }

        public final Map<Integer, Set<String>> getVisibleSpoilerEmbedMap() {
            return this.visibleSpoilerEmbedMap;
        }

        public final Set<Integer> getVisibleSpoilerNodeIndices() {
            return this.visibleSpoilerNodeIndices;
        }

        public int hashCode() {
            Set<Integer> set = this.visibleSpoilerNodeIndices;
            int iHashCode = (set != null ? set.hashCode() : 0) * 31;
            Map<Integer, Set<String>> map = this.visibleSpoilerEmbedMap;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("State(visibleSpoilerNodeIndices=");
            sbM833U.append(this.visibleSpoilerNodeIndices);
            sbM833U.append(", visibleSpoilerEmbedMap=");
            return C1643a.m825M(sbM833U, this.visibleSpoilerEmbedMap, ")");
        }

        public /* synthetic */ State(Set set, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? C12148n0.emptySet() : set, (i & 2) != 0 ? C12136h0.emptyMap() : map);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageState$revealSpoiler$1 */
    /* JADX INFO: compiled from: StoreMessageState.kt */
    public static final class C62211 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ int $spoilerIndex;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageState$revealSpoiler$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessageState.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<State, State> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final State invoke(State state) {
                C12238m.checkNotNullParameter(state, "currentState");
                return State.copy$default(state, C12150o0.plus(state.getVisibleSpoilerNodeIndices(), Integer.valueOf(C62211.this.$spoilerIndex)), null, 2, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62211(long j, int i) {
            super(0);
            this.$messageId = j;
            this.$spoilerIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageState.this.updateState(this.$messageId, new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbed$1 */
    /* JADX INFO: compiled from: StoreMessageState.kt */
    public static final class C62221 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ int $spoilerEmbedIndex;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbed$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessageState.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<State, State> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final State invoke(State state) {
                C12238m.checkNotNullParameter(state, "currentState");
                return State.copy$default(state, null, C12136h0.plus(state.getVisibleSpoilerEmbedMap(), C12116o.m10073to(Integer.valueOf(C62221.this.$spoilerEmbedIndex), C12148n0.emptySet())), 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62221(long j, int i) {
            super(0);
            this.$messageId = j;
            this.$spoilerEmbedIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageState.this.updateState(this.$messageId, new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbedData$1 */
    /* JADX INFO: compiled from: StoreMessageState.kt */
    public static final class C62231 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $key;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ int $spoilerEmbedIndex;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbedData$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessageState.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<State, State> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final State invoke(State state) {
                C12238m.checkNotNullParameter(state, "currentState");
                Set<String> setEmptySet = state.getVisibleSpoilerEmbedMap().get(Integer.valueOf(C62231.this.$spoilerEmbedIndex));
                if (setEmptySet == null) {
                    setEmptySet = C12148n0.emptySet();
                }
                return State.copy$default(state, null, C12136h0.plus(state.getVisibleSpoilerEmbedMap(), C12116o.m10073to(Integer.valueOf(C62231.this.$spoilerEmbedIndex), C12150o0.plus(setEmptySet, C62231.this.$key))), 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62231(long j, int i, String str) {
            super(0);
            this.$messageId = j;
            this.$spoilerEmbedIndex = i;
            this.$key = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageState.this.updateState(this.$messageId, new AnonymousClass1());
        }
    }

    public StoreMessageState(Dispatcher dispatcher) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        BehaviorSubject<Map<Long, State>> behaviorSubjectM11130l0 = BehaviorSubject.m11130l0(C12136h0.emptyMap());
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(emptyMap())");
        this.messageStateSubject = behaviorSubjectM11130l0;
    }

    @StoreThread
    private final void resetState(List<Long> messagesList) {
        Map<Long, State> mapM11132n0 = this.messageStateSubject.m11132n0();
        ArrayList arrayList = new ArrayList();
        for (Object obj : messagesList) {
            long jLongValue = ((Number) obj).longValue();
            C12238m.checkNotNullExpressionValue(mapM11132n0, "messageStateMap");
            if (mapM11132n0.containsKey(Long.valueOf(jLongValue))) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        BehaviorSubject<Map<Long, State>> behaviorSubject = this.messageStateSubject;
        C12238m.checkNotNullExpressionValue(mapM11132n0, "messageStateMap");
        behaviorSubject.onNext(C12136h0.minus((Map) mapM11132n0, (Iterable) arrayList));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @StoreThread
    private final void updateState(long messageId, Function1<? super State, State> updateFunction) {
        Map<Long, State> mapM11132n0 = this.messageStateSubject.m11132n0();
        State state = mapM11132n0.get(Long.valueOf(messageId));
        if (state == null) {
            state = new State(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
        State stateInvoke = updateFunction.invoke(state);
        BehaviorSubject<Map<Long, State>> behaviorSubject = this.messageStateSubject;
        C12238m.checkNotNullExpressionValue(mapM11132n0, "messageStateMap");
        behaviorSubject.onNext(C12136h0.plus(mapM11132n0, C12116o.m10073to(Long.valueOf(messageId), stateInvoke)));
    }

    public final Observable<Map<Long, State>> getMessageState() {
        Observable<Map<Long, State>> observableM11112r = this.messageStateSubject.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "messageStateSubject.distinctUntilChanged()");
        return observableM11112r;
    }

    @StoreThread
    public final void handleChannelSelected() {
        this.messageStateSubject.onNext(C12136h0.emptyMap());
    }

    @StoreThread
    public final void handleMessageDelete(ModelMessageDelete messageDelete) {
        C12238m.checkNotNullParameter(messageDelete, "messageDelete");
        List<Long> messageIds = messageDelete.getMessageIds();
        C12238m.checkNotNullExpressionValue(messageIds, "messageDelete.messageIds");
        resetState(messageIds);
    }

    @StoreThread
    public final void handleMessageUpdate(Message message) {
        C12238m.checkNotNullParameter(message, "message");
        resetState(C12145m.listOf(Long.valueOf(message.getId())));
    }

    public final void revealSpoiler(long messageId, int spoilerIndex) {
        if (spoilerIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new C62211(messageId, spoilerIndex));
    }

    public final void revealSpoilerEmbed(long messageId, int spoilerEmbedIndex) {
        if (spoilerEmbedIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new C62221(messageId, spoilerEmbedIndex));
    }

    public final void revealSpoilerEmbedData(long messageId, int spoilerEmbedIndex, String key) {
        C12238m.checkNotNullParameter(key, "key");
        if (spoilerEmbedIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new C62231(messageId, spoilerEmbedIndex, key));
    }
}
