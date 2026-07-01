package com.discord.stores;

import b.d.b.a.outline;
import com.discord.models.domain.ModelChannelFollowerStats;
import com.discord.models.domain.ModelChannelFollowerStatsDto;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreChannelFollowerStats.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelFollowerStats extends StoreV2 {
    private static final int STALE_TIME_DIFF_MS = 3600000;
    private final Map<Long, ChannelFollowerStatData> channelFollowerStatsState;
    private Map<Long, ChannelFollowerStatData> channelFollowerStatsStateSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* JADX INFO: compiled from: StoreChannelFollowerStats.kt */
    public static final /* data */ class ChannelFollowerStatData {
        private final ModelChannelFollowerStats data;
        private final FetchState fetchState;

        public ChannelFollowerStatData(FetchState fetchState, ModelChannelFollowerStats modelChannelFollowerStats) {
            Intrinsics3.checkNotNullParameter(fetchState, "fetchState");
            Intrinsics3.checkNotNullParameter(modelChannelFollowerStats, "data");
            this.fetchState = fetchState;
            this.data = modelChannelFollowerStats;
        }

        public static /* synthetic */ ChannelFollowerStatData copy$default(ChannelFollowerStatData channelFollowerStatData, FetchState fetchState, ModelChannelFollowerStats modelChannelFollowerStats, int i, Object obj) {
            if ((i & 1) != 0) {
                fetchState = channelFollowerStatData.fetchState;
            }
            if ((i & 2) != 0) {
                modelChannelFollowerStats = channelFollowerStatData.data;
            }
            return channelFollowerStatData.copy(fetchState, modelChannelFollowerStats);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FetchState getFetchState() {
            return this.fetchState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ModelChannelFollowerStats getData() {
            return this.data;
        }

        public final ChannelFollowerStatData copy(FetchState fetchState, ModelChannelFollowerStats data) {
            Intrinsics3.checkNotNullParameter(fetchState, "fetchState");
            Intrinsics3.checkNotNullParameter(data, "data");
            return new ChannelFollowerStatData(fetchState, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelFollowerStatData)) {
                return false;
            }
            ChannelFollowerStatData channelFollowerStatData = (ChannelFollowerStatData) other;
            return Intrinsics3.areEqual(this.fetchState, channelFollowerStatData.fetchState) && Intrinsics3.areEqual(this.data, channelFollowerStatData.data);
        }

        public final ModelChannelFollowerStats getData() {
            return this.data;
        }

        public final FetchState getFetchState() {
            return this.fetchState;
        }

        public int hashCode() {
            FetchState fetchState = this.fetchState;
            int iHashCode = (fetchState != null ? fetchState.hashCode() : 0) * 31;
            ModelChannelFollowerStats modelChannelFollowerStats = this.data;
            return iHashCode + (modelChannelFollowerStats != null ? modelChannelFollowerStats.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelFollowerStatData(fetchState=");
            sbU.append(this.fetchState);
            sbU.append(", data=");
            sbU.append(this.data);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ChannelFollowerStatData(FetchState fetchState, ModelChannelFollowerStats modelChannelFollowerStats, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fetchState, (i & 2) != 0 ? new ModelChannelFollowerStats(0L, null, null, null, null, null, null, Opcodes.LAND, null) : modelChannelFollowerStats);
        }
    }

    /* JADX INFO: compiled from: StoreChannelFollowerStats.kt */
    public enum FetchState {
        FETCHING,
        FAILED,
        SUCCEEDED
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannelFollowerStats$fetchIfNonexistingOrStale$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannelFollowerStats.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX INFO: renamed from: com.discord.stores.StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreChannelFollowerStats.kt */
        public static final class C01001 extends Lambda implements Function1<ModelChannelFollowerStatsDto, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreChannelFollowerStats.kt */
            public static final class C01011 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ ModelChannelFollowerStatsDto $channelFollowerStats;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01011(ModelChannelFollowerStatsDto modelChannelFollowerStatsDto) {
                    super(0);
                    this.$channelFollowerStats = modelChannelFollowerStatsDto;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreChannelFollowerStats.this.handleChannelFollowerStatsFetchSuccess(anonymousClass1.$channelId, ModelChannelFollowerStats.INSTANCE.fromResponse(this.$channelFollowerStats));
                }
            }

            public C01001() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelChannelFollowerStatsDto modelChannelFollowerStatsDto) {
                invoke2(modelChannelFollowerStatsDto);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelChannelFollowerStatsDto modelChannelFollowerStatsDto) {
                StoreChannelFollowerStats.this.dispatcher.schedule(new C01011(modelChannelFollowerStatsDto));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreChannelFollowerStats.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreChannelFollowerStats.kt */
            public static final class C01021 extends Lambda implements Function0<Unit> {
                public C01021() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreChannelFollowerStats.this.handleChannelFollowerStatsFetchFailed(anonymousClass1.$channelId);
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreChannelFollowerStats.this.dispatcher.schedule(new C01021());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            boolean z2 = StoreChannelFollowerStats.this.isExisting(this.$channelId) && !StoreChannelFollowerStats.this.isStale(this.$channelId);
            ChannelFollowerStatData channelFollowerStatData = (ChannelFollowerStatData) StoreChannelFollowerStats.this.channelFollowerStatsState.get(Long.valueOf(this.$channelId));
            boolean z3 = (channelFollowerStatData != null ? channelFollowerStatData.getFetchState() : null) == FetchState.FETCHING;
            if (z2 || z3) {
                return;
            }
            StoreChannelFollowerStats.this.handleChannelFollowerStatsFetchStart(this.$channelId);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getChannelFollowerStats(this.$channelId), false, 1, null), (Class<?>) StoreChannelFollowerStats.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C01001());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannelFollowerStats$observeChannelFollowerStats$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannelFollowerStats.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<ModelChannelFollowerStats> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ModelChannelFollowerStats invoke() {
            ChannelFollowerStatData channelFollowerStatData = (ChannelFollowerStatData) StoreChannelFollowerStats.this.channelFollowerStatsStateSnapshot.get(Long.valueOf(this.$channelId));
            if (channelFollowerStatData != null) {
                return channelFollowerStatData.getData();
            }
            return null;
        }
    }

    public StoreChannelFollowerStats(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.channelFollowerStatsState = new HashMap();
        this.channelFollowerStatsStateSnapshot = new HashMap();
    }

    @Store3
    private final void fetchIfNonexistingOrStale(long channelId) {
        this.dispatcher.schedule(new AnonymousClass1(channelId));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Store3
    private final void handleChannelFollowerStatsFetchFailed(long channelId) {
        this.channelFollowerStatsState.put(Long.valueOf(channelId), new ChannelFollowerStatData(FetchState.FAILED, null, 2, 0 == true ? 1 : 0));
        markChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Store3
    private final void handleChannelFollowerStatsFetchStart(long channelId) {
        this.channelFollowerStatsState.put(Long.valueOf(channelId), new ChannelFollowerStatData(FetchState.FETCHING, null, 2, 0 == true ? 1 : 0));
        markChanged();
    }

    @Store3
    private final void handleChannelFollowerStatsFetchSuccess(long channelId, ModelChannelFollowerStats channelFollowerStats) {
        this.channelFollowerStatsState.put(Long.valueOf(channelId), new ChannelFollowerStatData(FetchState.SUCCEEDED, channelFollowerStats));
        markChanged();
    }

    @Store3
    private final boolean isExisting(long channelId) {
        ChannelFollowerStatData channelFollowerStatData = this.channelFollowerStatsState.get(Long.valueOf(channelId));
        return (channelFollowerStatData == null || channelFollowerStatData.getFetchState() == FetchState.FAILED) ? false : true;
    }

    @Store3
    private final boolean isStale(long channelId) {
        ModelChannelFollowerStats data;
        ChannelFollowerStatData channelFollowerStatData = this.channelFollowerStatsState.get(Long.valueOf(channelId));
        return ((channelFollowerStatData == null || (data = channelFollowerStatData.getData()) == null) ? 0L : data.getLastFetched() + ((long) 3600000)) <= ClockFactory.get().currentTimeMillis();
    }

    public final void fetchChannelFollowerStats(long channelId) {
        fetchIfNonexistingOrStale(channelId);
    }

    public final Observable<ModelChannelFollowerStats> observeChannelFollowerStats(long channelId) {
        Observable<ModelChannelFollowerStats> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.channelFollowerStatsStateSnapshot = new HashMap(this.channelFollowerStatsState);
    }
}
