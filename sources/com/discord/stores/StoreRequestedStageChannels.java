package com.discord.stores;

import androidx.annotation.MainThread;
import com.discord.api.stageinstance.RecommendedStageInstance;
import com.discord.api.stageinstance.StageInstance;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12163u;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p659s.p660a.C13124k0;
import p659s.p660a.C13163x0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRequestedStageChannels extends StoreV2 {
    private static final long ENQUEUE_DEBOUNCE_DELAY_MS = 22;
    private final Dispatcher dispatcher;
    private Job enqueuedChannelFetchJob;
    private Set<Long> enqueuedChannelFetches;
    private final ObservationDeck observationDeck;
    private final Map<Long, StageInstanceState> requestedStageChannels;
    private Map<Long, StageInstanceState> requestedStageChannelsSnapshot;
    private final RestAPI restAPI;

    /* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
    public enum FetchStatus {
        ERROR,
        LOADING,
        LOADED
    }

    /* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
    public static final /* data */ class StageInstanceState {
        private final RecommendedStageInstance stageInstance;
        private final FetchStatus status;

        public StageInstanceState(RecommendedStageInstance recommendedStageInstance, FetchStatus fetchStatus) {
            C12238m.checkNotNullParameter(fetchStatus, "status");
            this.stageInstance = recommendedStageInstance;
            this.status = fetchStatus;
        }

        public static /* synthetic */ StageInstanceState copy$default(StageInstanceState stageInstanceState, RecommendedStageInstance recommendedStageInstance, FetchStatus fetchStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                recommendedStageInstance = stageInstanceState.stageInstance;
            }
            if ((i & 2) != 0) {
                fetchStatus = stageInstanceState.status;
            }
            return stageInstanceState.copy(recommendedStageInstance, fetchStatus);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RecommendedStageInstance getStageInstance() {
            return this.stageInstance;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final FetchStatus getStatus() {
            return this.status;
        }

        public final StageInstanceState copy(RecommendedStageInstance stageInstance, FetchStatus status) {
            C12238m.checkNotNullParameter(status, "status");
            return new StageInstanceState(stageInstance, status);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StageInstanceState)) {
                return false;
            }
            StageInstanceState stageInstanceState = (StageInstanceState) other;
            return C12238m.areEqual(this.stageInstance, stageInstanceState.stageInstance) && C12238m.areEqual(this.status, stageInstanceState.status);
        }

        public final RecommendedStageInstance getStageInstance() {
            return this.stageInstance;
        }

        public final FetchStatus getStatus() {
            return this.status;
        }

        public int hashCode() {
            RecommendedStageInstance recommendedStageInstance = this.stageInstance;
            int iHashCode = (recommendedStageInstance != null ? recommendedStageInstance.hashCode() : 0) * 31;
            FetchStatus fetchStatus = this.status;
            return iHashCode + (fetchStatus != null ? fetchStatus.hashCode() : 0);
        }

        public final boolean isError() {
            return this.status == FetchStatus.ERROR;
        }

        public final boolean isLoaded() {
            return this.status == FetchStatus.LOADED;
        }

        public final boolean isLoading() {
            return this.status == FetchStatus.LOADING;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StageInstanceState(stageInstance=");
            sbM833U.append(this.stageInstance);
            sbM833U.append(", status=");
            sbM833U.append(this.status);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRequestedStageChannels$enqueueStageChannelFetch$1 */
    /* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
    @InterfaceC12188e(m10084c = "com.discord.stores.StoreRequestedStageChannels$enqueueStageChannelFetch$1", m10085f = "StoreRequestedStageChannels.kt", m10086l = {60}, m10087m = "invokeSuspend")
    public static final class C63531 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public C63531(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return StoreRequestedStageChannels.this.new C63531(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63531) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                this.label = 1;
                if (C3404f.m4234P(StoreRequestedStageChannels.ENQUEUE_DEBOUNCE_DELAY_MS, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            Set<Long> set = StoreRequestedStageChannels.this.enqueuedChannelFetches;
            StoreRequestedStageChannels.this.enqueuedChannelFetches = new LinkedHashSet();
            StoreRequestedStageChannels.this.fetchStageChannels(set);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRequestedStageChannels$fetchStageChannels$1 */
    /* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
    public static final class C63541 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Set $channelIds;

        /* JADX INFO: renamed from: com.discord.stores.StoreRequestedStageChannels$fetchStageChannels$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Error, Unit> {
            public final /* synthetic */ Set $channelIdsToRequest;

            /* JADX INFO: renamed from: com.discord.stores.StoreRequestedStageChannels$fetchStageChannels$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
            public static final class C132621 extends AbstractC12240o implements Function0<Unit> {
                public C132621() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreRequestedStageChannels.this.updateStatus(anonymousClass1.$channelIdsToRequest, FetchStatus.ERROR);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Set set) {
                super(1);
                this.$channelIdsToRequest = set;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                C12238m.checkNotNullParameter(error, "it");
                StoreRequestedStageChannels.this.dispatcher.schedule(new C132621());
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreRequestedStageChannels$fetchStageChannels$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<List<? extends RecommendedStageInstance>, Unit> {
            public final /* synthetic */ Set $channelIdsToRequest;

            /* JADX INFO: renamed from: com.discord.stores.StoreRequestedStageChannels$fetchStageChannels$1$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ List $stageInstances;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(List list) {
                    super(0);
                    this.$stageInstances = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    StoreRequestedStageChannels.this.onLoaded(anonymousClass2.$channelIdsToRequest, this.$stageInstances);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Set set) {
                super(1);
                this.$channelIdsToRequest = set;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends RecommendedStageInstance> list) {
                invoke2((List<RecommendedStageInstance>) list);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<RecommendedStageInstance> list) {
                C12238m.checkNotNullParameter(list, "stageInstances");
                StoreRequestedStageChannels.this.dispatcher.schedule(new AnonymousClass1(list));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63541(Set set) {
            super(0);
            this.$channelIds = set;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Set set = this.$channelIds;
            ArrayList arrayList = new ArrayList();
            Iterator it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    Set<Long> set2 = C12163u.toSet(arrayList);
                    StoreRequestedStageChannels.this.updateStatus(set2, FetchStatus.LOADING);
                    ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(StoreRequestedStageChannels.this.restAPI.getStageInstancesForChannels(set2), false, 1, null), (Class<?>) StoreRequestedStageChannels.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1(set2)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass2(set2));
                    return;
                } else {
                    Object next = it.next();
                    StageInstanceState stageInstanceState = (StageInstanceState) StoreRequestedStageChannels.this.requestedStageChannelsSnapshot.get(Long.valueOf(((Number) next).longValue()));
                    if (stageInstanceState == null || !stageInstanceState.isLoading()) {
                        arrayList.add(next);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRequestedStageChannels$observeRequestedStageChannels$1 */
    /* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
    public static final class C63561 extends AbstractC12240o implements Function0<Map<Long, ? extends StageInstanceState>> {
        public C63561() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends StageInstanceState> invoke() {
            return StoreRequestedStageChannels.this.getRequestedInstanceStatesByChannel();
        }
    }

    public /* synthetic */ StoreRequestedStageChannels(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    @StoreThread
    private final void onLoaded(Set<Long> channelIds, List<RecommendedStageInstance> stageInstances) {
        Set mutableSet = C12163u.toMutableSet(channelIds);
        for (RecommendedStageInstance recommendedStageInstance : stageInstances) {
            this.requestedStageChannels.put(Long.valueOf(recommendedStageInstance.getInstance().getChannelId()), new StageInstanceState(recommendedStageInstance, FetchStatus.LOADED));
            mutableSet.remove(Long.valueOf(recommendedStageInstance.getInstance().getChannelId()));
        }
        Iterator it = mutableSet.iterator();
        while (it.hasNext()) {
            this.requestedStageChannels.put(Long.valueOf(((Number) it.next()).longValue()), new StageInstanceState(null, FetchStatus.LOADED));
        }
        markChanged();
    }

    @StoreThread
    private final void updateStatus(Set<Long> channelIds, FetchStatus status) {
        Iterator<T> it = channelIds.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            StageInstanceState stageInstanceState = this.requestedStageChannels.get(Long.valueOf(jLongValue));
            this.requestedStageChannels.put(Long.valueOf(jLongValue), new StageInstanceState(stageInstanceState != null ? stageInstanceState.getStageInstance() : null, status));
        }
        markChanged();
    }

    @MainThread
    public final void enqueueStageChannelFetch(long channelId) {
        StageInstanceState stageInstanceState = this.requestedStageChannelsSnapshot.get(Long.valueOf(channelId));
        if (stageInstanceState == null || stageInstanceState.isError()) {
            this.enqueuedChannelFetches.add(Long.valueOf(channelId));
            Job job = this.enqueuedChannelFetchJob;
            if (job == null || !job.mo10910a()) {
                C13163x0 c13163x0 = C13163x0.f27919j;
                CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
                this.enqueuedChannelFetchJob = C3404f.m4211H0(c13163x0, C13031n.f27700b, null, new C63531(null), 2, null);
            }
        }
    }

    public final void fetchStageChannels(Set<Long> channelIds) {
        C12238m.checkNotNullParameter(channelIds, "channelIds");
        this.dispatcher.schedule(new C63541(channelIds));
    }

    public final Map<Long, StageInstanceState> getRequestedInstanceStatesByChannel() {
        return this.requestedStageChannelsSnapshot;
    }

    public final StageInstance getStageInstanceForChannel(long channelId) {
        RecommendedStageInstance stageInstance;
        StageInstanceState stageInstanceState = getRequestedInstanceStatesByChannel().get(Long.valueOf(channelId));
        if (stageInstanceState == null || (stageInstance = stageInstanceState.getStageInstance()) == null) {
            return null;
        }
        return stageInstance.getInstance();
    }

    public final Observable<StageInstanceState> observeRequestedStageChannel(final long channelId) {
        Observable observableM11083G = observeRequestedStageChannels().m11083G(new InterfaceC12589b<Map<Long, ? extends StageInstanceState>, StageInstanceState>() { // from class: com.discord.stores.StoreRequestedStageChannels.observeRequestedStageChannel.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ StageInstanceState call(Map<Long, ? extends StageInstanceState> map) {
                return call2((Map<Long, StageInstanceState>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final StageInstanceState call2(Map<Long, StageInstanceState> map) {
                return map.get(Long.valueOf(channelId));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "observeRequestedStageCha…s().map { it[channelId] }");
        return observableM11083G;
    }

    public final Observable<Map<Long, StageInstanceState>> observeRequestedStageChannels() {
        Observable<Map<Long, StageInstanceState>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C63561(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.requestedStageChannelsSnapshot = C12136h0.toMap(this.requestedStageChannels);
    }

    public StoreRequestedStageChannels(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.requestedStageChannels = new LinkedHashMap();
        this.requestedStageChannelsSnapshot = C12136h0.emptyMap();
        this.enqueuedChannelFetches = new LinkedHashSet();
    }
}
