package com.discord.stores;

import b.d.b.a.outline;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelRtcLatencyRegion;
import com.discord.utilities.error.Error;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreRtcRegion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcRegion {
    private static final int LATENCY_TEST_CACHE_TTL_MS = 86400000;
    private static final int MAX_LATENCY_TEST_CONN_OPEN_JITTER_MS = 30000;
    private static final int MIN_LATENCY_TEST_CONN_OPEN_JITTER_MS = 1000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private StoreRtcRegion2 lastTestResult;
    private final Persister<StoreRtcRegion2> lastTestResultCache;
    private final RestAPI restAPI;
    private final StoreExperiments storeExperiments;
    private final StoreMediaEngine storeMediaEngine;

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcRegion$fetchRtcLatencyTestRegionsIps$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcRegion.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ModelRtcLatencyRegion>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelRtcLatencyRegion> list) {
            invoke2((List<ModelRtcLatencyRegion>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelRtcLatencyRegion> list) {
            Intrinsics3.checkNotNullParameter(list, "it");
            StoreRtcRegion.this.maybePerformLatencyTest(list);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcRegion$maybePerformLatencyTest$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcRegion.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $regionsWithIps;

        /* JADX INFO: renamed from: com.discord.stores.StoreRtcRegion$maybePerformLatencyTest$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreRtcRegion.kt */
        public static final class C01701 extends Lambda implements Function1<List<? extends String>, Unit> {
            public final /* synthetic */ List $newGeoRankedRegions;
            public final /* synthetic */ long $timeNowMs;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01701(List list, long j) {
                super(1);
                this.$newGeoRankedRegions = list;
                this.$timeNowMs = j;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                Intrinsics3.checkNotNullParameter(list, "latencyRankedRegions");
                AppLog.i("RTC region latency test ranking is " + list);
                StoreRtcRegion.this.updateLastTestResult(new StoreRtcRegion2(list, this.$newGeoRankedRegions, this.$timeNowMs));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$regionsWithIps = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            List list = this.$regionsWithIps;
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((ModelRtcLatencyRegion) it.next()).getRegion());
            }
            long jCurrentTimeMillis = StoreRtcRegion.this.clock.currentTimeMillis();
            if (StoreRtcRegion.this.shouldPerformLatencyTest(arrayList, jCurrentTimeMillis)) {
                StoreRtcRegion.this.storeMediaEngine.getRankedRtcRegions(this.$regionsWithIps, new C01701(arrayList, jCurrentTimeMillis));
                return;
            }
            StringBuilder sbU = outline.U("RTC region latency test cached preferred region is ");
            sbU.append(StoreRtcRegion.this.getPreferredRegion());
            AppLog.i(sbU.toString());
        }
    }

    public StoreRtcRegion(Dispatcher dispatcher, Clock clock, StoreMediaEngine storeMediaEngine, StoreExperiments storeExperiments, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeMediaEngine, "storeMediaEngine");
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.storeMediaEngine = storeMediaEngine;
        this.storeExperiments = storeExperiments;
        this.restAPI = restAPI;
        List list = null;
        List list2 = null;
        long j = 0;
        int i = 7;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.lastTestResultCache = new Persister<>("CACHE_KEY_LATENCY_TEST_RESULT", new StoreRtcRegion2(list, list2, j, i, defaultConstructorMarker));
        this.lastTestResult = new StoreRtcRegion2(list, list2, j, i, defaultConstructorMarker);
    }

    private final boolean areStringListsEqual(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        Iterator<T> it = list1.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!Intrinsics3.areEqual(list2.get(i), (String) it.next())) {
                return false;
            }
            i++;
        }
        return true;
    }

    private final void fetchRtcLatencyTestRegionsIps() {
        if (this.storeMediaEngine.hasNativeEngineEverInitialized()) {
            ObservableExtensionsKt.appSubscribe(this.restAPI.getRtcLatencyTestRegionsIps(), (Class<?>) StoreRtcRegion.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        }
    }

    private final void maybePerformLatencyTest(List<ModelRtcLatencyRegion> regionsWithIps) {
        this.dispatcher.schedule(new AnonymousClass1(regionsWithIps));
    }

    private final boolean shouldPerformLatencyTest(List<String> newGeoRankedRegions, long timeNowMs) {
        return this.lastTestResult.getLatencyRankedRegions().isEmpty() || !areStringListsEqual(newGeoRankedRegions, this.lastTestResult.getGeoRankedRegions()) || timeNowMs - this.lastTestResult.getLastTestTimestampMs() >= ((long) LATENCY_TEST_CACHE_TTL_MS);
    }

    private final void updateLastTestResult(StoreRtcRegion2 lastTestResult) {
        this.lastTestResult = lastTestResult;
        this.lastTestResultCache.set(lastTestResult, true);
    }

    @Store3
    public final String getPreferredRegion() {
        if (!this.lastTestResult.getLatencyRankedRegions().isEmpty()) {
            return this.lastTestResult.getLatencyRankedRegions().get(0);
        }
        return null;
    }

    @Store3
    public final void handleConnectionOpen$app_productionGoogleRelease() {
        Observable<Long> observableD0 = Observable.d0(new Random().nextInt(29000) + 1000, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable.timer(fetchJi…), TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(observableD0, (Class<?>) StoreRtcRegion.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new StoreRtcRegion3(this));
    }

    public final void init() {
        this.lastTestResult = this.lastTestResultCache.get();
    }

    @Store3
    public final boolean shouldIncludePreferredRegion(Long guildId) {
        return getPreferredRegion() != null;
    }

    public /* synthetic */ StoreRtcRegion(Dispatcher dispatcher, Clock clock, StoreMediaEngine storeMediaEngine, StoreExperiments storeExperiments, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, clock, storeMediaEngine, storeExperiments, (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }
}
