package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.message.Message;
import com.discord.models.domain.ModelMessageDelete;
import d0.Tuples;
import d0.t.CollectionsJVM;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

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
            Intrinsics3.checkNotNullParameter(set, "visibleSpoilerNodeIndices");
            Intrinsics3.checkNotNullParameter(map, "visibleSpoilerEmbedMap");
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
            Intrinsics3.checkNotNullParameter(visibleSpoilerNodeIndices, "visibleSpoilerNodeIndices");
            Intrinsics3.checkNotNullParameter(visibleSpoilerEmbedMap, "visibleSpoilerEmbedMap");
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
            return Intrinsics3.areEqual(this.visibleSpoilerNodeIndices, state.visibleSpoilerNodeIndices) && Intrinsics3.areEqual(this.visibleSpoilerEmbedMap, state.visibleSpoilerEmbedMap);
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
            StringBuilder sbU = outline.U("State(visibleSpoilerNodeIndices=");
            sbU.append(this.visibleSpoilerNodeIndices);
            sbU.append(", visibleSpoilerEmbedMap=");
            return outline.M(sbU, this.visibleSpoilerEmbedMap, ")");
        }

        public /* synthetic */ State(Set set, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Sets5.emptySet() : set, (i & 2) != 0 ? Maps6.emptyMap() : map);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageState$revealSpoiler$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageState.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ int $spoilerIndex;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageState$revealSpoiler$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreMessageState.kt */
        public static final class C01541 extends Lambda implements Function1<State, State> {
            public C01541() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final State invoke(State state) {
                Intrinsics3.checkNotNullParameter(state, "currentState");
                return State.copy$default(state, _Sets.plus(state.getVisibleSpoilerNodeIndices(), Integer.valueOf(AnonymousClass1.this.$spoilerIndex)), null, 2, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, int i) {
            super(0);
            this.$messageId = j;
            this.$spoilerIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageState.this.updateState(this.$messageId, new C01541());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbed$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageState.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ int $spoilerEmbedIndex;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbed$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreMessageState.kt */
        public static final class C01551 extends Lambda implements Function1<State, State> {
            public C01551() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final State invoke(State state) {
                Intrinsics3.checkNotNullParameter(state, "currentState");
                return State.copy$default(state, null, Maps6.plus(state.getVisibleSpoilerEmbedMap(), Tuples.to(Integer.valueOf(AnonymousClass1.this.$spoilerEmbedIndex), Sets5.emptySet())), 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, int i) {
            super(0);
            this.$messageId = j;
            this.$spoilerEmbedIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageState.this.updateState(this.$messageId, new C01551());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbedData$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageState.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $key;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ int $spoilerEmbedIndex;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbedData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreMessageState.kt */
        public static final class C01561 extends Lambda implements Function1<State, State> {
            public C01561() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final State invoke(State state) {
                Intrinsics3.checkNotNullParameter(state, "currentState");
                Set<String> setEmptySet = state.getVisibleSpoilerEmbedMap().get(Integer.valueOf(AnonymousClass1.this.$spoilerEmbedIndex));
                if (setEmptySet == null) {
                    setEmptySet = Sets5.emptySet();
                }
                return State.copy$default(state, null, Maps6.plus(state.getVisibleSpoilerEmbedMap(), Tuples.to(Integer.valueOf(AnonymousClass1.this.$spoilerEmbedIndex), _Sets.plus(setEmptySet, AnonymousClass1.this.$key))), 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, int i, String str) {
            super(0);
            this.$messageId = j;
            this.$spoilerEmbedIndex = i;
            this.$key = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageState.this.updateState(this.$messageId, new C01561());
        }
    }

    public StoreMessageState(Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        BehaviorSubject<Map<Long, State>> behaviorSubjectL0 = BehaviorSubject.l0(Maps6.emptyMap());
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(emptyMap())");
        this.messageStateSubject = behaviorSubjectL0;
    }

    @Store3
    private final void resetState(List<Long> messagesList) {
        Map<Long, State> mapN0 = this.messageStateSubject.n0();
        ArrayList arrayList = new ArrayList();
        for (Object obj : messagesList) {
            long jLongValue = ((Number) obj).longValue();
            Intrinsics3.checkNotNullExpressionValue(mapN0, "messageStateMap");
            if (mapN0.containsKey(Long.valueOf(jLongValue))) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        BehaviorSubject<Map<Long, State>> behaviorSubject = this.messageStateSubject;
        Intrinsics3.checkNotNullExpressionValue(mapN0, "messageStateMap");
        behaviorSubject.onNext(Maps6.minus((Map) mapN0, (Iterable) arrayList));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Store3
    private final void updateState(long messageId, Function1<? super State, State> updateFunction) {
        Map<Long, State> mapN0 = this.messageStateSubject.n0();
        State state = mapN0.get(Long.valueOf(messageId));
        if (state == null) {
            state = new State(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
        State stateInvoke = updateFunction.invoke(state);
        BehaviorSubject<Map<Long, State>> behaviorSubject = this.messageStateSubject;
        Intrinsics3.checkNotNullExpressionValue(mapN0, "messageStateMap");
        behaviorSubject.onNext(Maps6.plus(mapN0, Tuples.to(Long.valueOf(messageId), stateInvoke)));
    }

    public final Observable<Map<Long, State>> getMessageState() {
        Observable<Map<Long, State>> observableR = this.messageStateSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "messageStateSubject.distinctUntilChanged()");
        return observableR;
    }

    @Store3
    public final void handleChannelSelected() {
        this.messageStateSubject.onNext(Maps6.emptyMap());
    }

    @Store3
    public final void handleMessageDelete(ModelMessageDelete messageDelete) {
        Intrinsics3.checkNotNullParameter(messageDelete, "messageDelete");
        List<Long> messageIds = messageDelete.getMessageIds();
        Intrinsics3.checkNotNullExpressionValue(messageIds, "messageDelete.messageIds");
        resetState(messageIds);
    }

    @Store3
    public final void handleMessageUpdate(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        resetState(CollectionsJVM.listOf(Long.valueOf(message.getId())));
    }

    public final void revealSpoiler(long messageId, int spoilerIndex) {
        if (spoilerIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(messageId, spoilerIndex));
    }

    public final void revealSpoilerEmbed(long messageId, int spoilerEmbedIndex) {
        if (spoilerEmbedIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(messageId, spoilerEmbedIndex));
    }

    public final void revealSpoilerEmbedData(long messageId, int spoilerEmbedIndex, String key) {
        Intrinsics3.checkNotNullParameter(key, "key");
        if (spoilerEmbedIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(messageId, spoilerEmbedIndex, key));
    }
}
