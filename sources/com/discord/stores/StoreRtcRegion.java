package com.discord.stores;

import com.discord.app.AppLog;
import com.discord.models.domain.ModelRtcLatencyRegion;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreRtcRegion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcRegion {
    private static final int LATENCY_TEST_CACHE_TTL_MS = 86400000;
    private static final int MAX_LATENCY_TEST_CONN_OPEN_JITTER_MS = 30000;
    private static final int MIN_LATENCY_TEST_CONN_OPEN_JITTER_MS = 1000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private RtcLatencyTestResult lastTestResult;
    private final Persister<RtcLatencyTestResult> lastTestResultCache;
    private final RestAPI restAPI;
    private final StoreExperiments storeExperiments;
    private final StoreMediaEngine storeMediaEngine;

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcRegion$fetchRtcLatencyTestRegionsIps$1 */
    /* JADX INFO: compiled from: StoreRtcRegion.kt */
    public static final class C63741 extends AbstractC12240o implements Function1<List<? extends ModelRtcLatencyRegion>, Unit> {
        public C63741() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelRtcLatencyRegion> list) {
            invoke2((List<ModelRtcLatencyRegion>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelRtcLatencyRegion> list) {
            C12238m.checkNotNullParameter(list, "it");
            StoreRtcRegion.this.maybePerformLatencyTest(list);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcRegion$maybePerformLatencyTest$1 */
    /* JADX INFO: compiled from: StoreRtcRegion.kt */
    public static final class C63751 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ List $regionsWithIps;

        /* JADX INFO: renamed from: com.discord.stores.StoreRtcRegion$maybePerformLatencyTest$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreRtcRegion.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<List<? extends String>, Unit> {
            public final /* synthetic */ List $newGeoRankedRegions;
            public final /* synthetic */ long $timeNowMs;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list, long j) {
                super(1);
                this.$newGeoRankedRegions = list;
                this.$timeNowMs = j;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                C12238m.checkNotNullParameter(list, "latencyRankedRegions");
                AppLog.m8358i("RTC region latency test ranking is " + list);
                StoreRtcRegion.this.updateLastTestResult(new RtcLatencyTestResult(list, this.$newGeoRankedRegions, this.$timeNowMs));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63751(List list) {
            super(0);
            this.$regionsWithIps = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            List list = this.$regionsWithIps;
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((ModelRtcLatencyRegion) it.next()).getRegion());
            }
            long jCurrentTimeMillis = StoreRtcRegion.this.clock.currentTimeMillis();
            if (StoreRtcRegion.this.shouldPerformLatencyTest(arrayList, jCurrentTimeMillis)) {
                StoreRtcRegion.this.storeMediaEngine.getRankedRtcRegions(this.$regionsWithIps, new AnonymousClass1(arrayList, jCurrentTimeMillis));
                return;
            }
            StringBuilder sbM833U = C1643a.m833U("RTC region latency test cached preferred region is ");
            sbM833U.append(StoreRtcRegion.this.getPreferredRegion());
            AppLog.m8358i(sbM833U.toString());
        }
    }

    public StoreRtcRegion(Dispatcher dispatcher, Clock clock, StoreMediaEngine storeMediaEngine, StoreExperiments storeExperiments, RestAPI restAPI) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(storeMediaEngine, "storeMediaEngine");
        C12238m.checkNotNullParameter(storeExperiments, "storeExperiments");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
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
        this.lastTestResultCache = new Persister<>("CACHE_KEY_LATENCY_TEST_RESULT", new RtcLatencyTestResult(list, list2, j, i, defaultConstructorMarker));
        this.lastTestResult = new RtcLatencyTestResult(list, list2, j, i, defaultConstructorMarker);
    }

    private final boolean areStringListsEqual(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        Iterator<T> it = list1.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!C12238m.areEqual(list2.get(i), (String) it.next())) {
                return false;
            }
            i++;
        }
        return true;
    }

    private final void fetchRtcLatencyTestRegionsIps() {
        if (this.storeMediaEngine.hasNativeEngineEverInitialized()) {
            ObservableExtensionsKt.appSubscribe(this.restAPI.getRtcLatencyTestRegionsIps(), (Class<?>) StoreRtcRegion.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C63741());
        }
    }

    private final void maybePerformLatencyTest(List<ModelRtcLatencyRegion> regionsWithIps) {
        this.dispatcher.schedule(new C63751(regionsWithIps));
    }

    private final boolean shouldPerformLatencyTest(List<String> newGeoRankedRegions, long timeNowMs) {
        return this.lastTestResult.getLatencyRankedRegions().isEmpty() || !areStringListsEqual(newGeoRankedRegions, this.lastTestResult.getGeoRankedRegions()) || timeNowMs - this.lastTestResult.getLastTestTimestampMs() >= ((long) LATENCY_TEST_CACHE_TTL_MS);
    }

    private final void updateLastTestResult(RtcLatencyTestResult lastTestResult) {
        this.lastTestResult = lastTestResult;
        this.lastTestResultCache.set(lastTestResult, true);
    }

    @StoreThread
    public final String getPreferredRegion() {
        if (!this.lastTestResult.getLatencyRankedRegions().isEmpty()) {
            return this.lastTestResult.getLatencyRankedRegions().get(0);
        }
        return null;
    }

    @StoreThread
    public final void handleConnectionOpen$app_productionGoogleRelease() {
        Observable<Long> observableM11068d0 = Observable.m11068d0(new Random().nextInt(29000) + 1000, TimeUnit.MILLISECONDS);
        C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable.timer(fetchJi…), TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(observableM11068d0, (Class<?>) StoreRtcRegion.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new StoreRtcRegion$handleConnectionOpen$1(this));
    }

    public final void init() {
        this.lastTestResult = this.lastTestResultCache.get();
    }

    @StoreThread
    public final boolean shouldIncludePreferredRegion(Long guildId) {
        return getPreferredRegion() != null;
    }

    public /* synthetic */ StoreRtcRegion(Dispatcher dispatcher, Clock clock, StoreMediaEngine storeMediaEngine, StoreExperiments storeExperiments, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, clock, storeMediaEngine, storeExperiments, (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }
}
