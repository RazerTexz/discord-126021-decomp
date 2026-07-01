package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelRtcLatencyRegion;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreRtcRegion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcRegion {
    public static final StoreRtcRegion$Companion Companion = new StoreRtcRegion$Companion(null);
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

    public StoreRtcRegion(Dispatcher dispatcher, Clock clock, StoreMediaEngine storeMediaEngine, StoreExperiments storeExperiments, RestAPI restAPI) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeMediaEngine, "storeMediaEngine");
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.storeMediaEngine = storeMediaEngine;
        this.storeExperiments = storeExperiments;
        this.restAPI = restAPI;
        this.lastTestResultCache = new Persister<>("CACHE_KEY_LATENCY_TEST_RESULT", new RtcLatencyTestResult(null, null, 0L, 7, null));
        this.lastTestResult = new RtcLatencyTestResult(null, null, 0L, 7, null);
    }

    public static final /* synthetic */ void access$fetchRtcLatencyTestRegionsIps(StoreRtcRegion storeRtcRegion) {
        storeRtcRegion.fetchRtcLatencyTestRegionsIps();
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreRtcRegion storeRtcRegion) {
        return storeRtcRegion.clock;
    }

    public static final /* synthetic */ StoreMediaEngine access$getStoreMediaEngine$p(StoreRtcRegion storeRtcRegion) {
        return storeRtcRegion.storeMediaEngine;
    }

    public static final /* synthetic */ void access$maybePerformLatencyTest(StoreRtcRegion storeRtcRegion, List list) {
        storeRtcRegion.maybePerformLatencyTest(list);
    }

    public static final /* synthetic */ boolean access$shouldPerformLatencyTest(StoreRtcRegion storeRtcRegion, List list, long j) {
        return storeRtcRegion.shouldPerformLatencyTest(list, j);
    }

    public static final /* synthetic */ void access$updateLastTestResult(StoreRtcRegion storeRtcRegion, RtcLatencyTestResult rtcLatencyTestResult) {
        storeRtcRegion.updateLastTestResult(rtcLatencyTestResult);
    }

    private final boolean areStringListsEqual(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        Iterator<T> it = list1.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!m.areEqual(list2.get(i), (String) it.next())) {
                return false;
            }
            i++;
        }
        return true;
    }

    private final void fetchRtcLatencyTestRegionsIps() {
        if (this.storeMediaEngine.hasNativeEngineEverInitialized()) {
            ObservableExtensionsKt.appSubscribe$default(this.restAPI.getRtcLatencyTestRegionsIps(), StoreRtcRegion.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreRtcRegion$fetchRtcLatencyTestRegionsIps$1(this), 62, (Object) null);
        }
    }

    private final void maybePerformLatencyTest(List<ModelRtcLatencyRegion> regionsWithIps) {
        this.dispatcher.schedule(new StoreRtcRegion$maybePerformLatencyTest$1(this, regionsWithIps));
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
        Observable<Long> observableD0 = Observable.d0(new Random().nextInt(29000) + 1000, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable.timer(fetchJi…), TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableD0, StoreRtcRegion.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreRtcRegion$handleConnectionOpen$1(this), 62, (Object) null);
    }

    public final void init() {
        this.lastTestResult = this.lastTestResultCache.get();
    }

    @StoreThread
    public final boolean shouldIncludePreferredRegion(Long guildId) {
        return getPreferredRegion() != null;
    }

    public /* synthetic */ StoreRtcRegion(Dispatcher dispatcher, Clock clock, StoreMediaEngine storeMediaEngine, StoreExperiments storeExperiments, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, clock, storeMediaEngine, storeExperiments, (i & 16) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }
}
