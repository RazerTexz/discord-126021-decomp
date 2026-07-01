package com.discord.utilities.analytics;

import android.content.Context;
import android.os.Bundle;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.api.science.Science;
import com.discord.api.science.Science$Event;
import com.discord.api.science.Science$Event$MapObject;
import com.discord.api.science.Science$Event$SchemaObject;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.google.firebase.analytics.FirebaseAnalytics;
import d0.g;
import d0.g0.t;
import d0.t.h0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map$Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: AnalyticsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsUtils$Tracker {
    public static final AnalyticsUtils$Tracker$Companion Companion = new AnalyticsUtils$Tracker$Companion(null);
    private static final Lazy instance$delegate = g.lazy(AnalyticsUtils$Tracker$Companion$instance$2.INSTANCE);
    private String analyticsToken;
    private final Clock clock;
    private final ConcurrentLinkedQueue<Science$Event> eventsQueue;
    private final ConcurrentHashMap<Pair<String, Long>, Long> eventsThrottledUntilMillis;
    private boolean fingerprinted;
    private final RestAPI restAPI;

    public AnalyticsUtils$Tracker(Clock clock, RestAPI restAPI, ConcurrentLinkedQueue<Science$Event> concurrentLinkedQueue) {
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(concurrentLinkedQueue, "eventsQueue");
        this.clock = clock;
        this.restAPI = restAPI;
        this.eventsQueue = concurrentLinkedQueue;
        this.eventsThrottledUntilMillis = new ConcurrentHashMap<>();
    }

    public static final /* synthetic */ void access$drainEventsQueue(AnalyticsUtils$Tracker analyticsUtils$Tracker) {
        analyticsUtils$Tracker.drainEventsQueue();
    }

    public static final /* synthetic */ ConcurrentLinkedQueue access$getEventsQueue$p(AnalyticsUtils$Tracker analyticsUtils$Tracker) {
        return analyticsUtils$Tracker.eventsQueue;
    }

    public static final /* synthetic */ Lazy access$getInstance$cp() {
        return instance$delegate;
    }

    private final synchronized void drainEventsQueue() {
        if (getCanDrain()) {
            ArrayList arrayList = new ArrayList(this.eventsQueue);
            this.eventsQueue.clear();
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.science(new Science(this.analyticsToken, arrayList)), false, 1, null), getClass(), (Context) null, (Function1) null, new AnalyticsUtils$Tracker$drainEventsQueue$2(this, arrayList), (Function0) null, (Function0) null, AnalyticsUtils$Tracker$drainEventsQueue$1.INSTANCE, 54, (Object) null);
        }
    }

    private final boolean getCanDrain() {
        return (this.eventsQueue.isEmpty() ^ true) && (this.fingerprinted || isAuthed$app_productionGoogleRelease());
    }

    private final boolean isEventThrottled(Pair<String, Long> throttleKey) {
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        Long l = this.eventsThrottledUntilMillis.get(throttleKey);
        if (l == null) {
            l = 0L;
        }
        m.checkNotNullExpressionValue(l, "eventsThrottledUntilMillis[throttleKey] ?: 0");
        return jCurrentTimeMillis < l.longValue();
    }

    private final Bundle putMap(Bundle bundle, Map<String, ? extends Object> map) {
        try {
            for (Map$Entry<String, ? extends Object> map$Entry : map.entrySet()) {
                String key = map$Entry.getKey();
                Object value = map$Entry.getValue();
                if (value instanceof String) {
                    bundle.putString(key, (String) value);
                } else if (value instanceof Integer) {
                    bundle.putInt(key, ((Number) value).intValue());
                } else if (value instanceof Long) {
                    bundle.putLong(key, ((Number) value).longValue());
                } else if (value instanceof Double) {
                    bundle.putDouble(key, ((Number) value).doubleValue());
                } else if (value instanceof Float) {
                    bundle.putFloat(key, ((Number) value).floatValue());
                }
            }
        } catch (Throwable th) {
            Logger.e$default(AppLog.g, bundle.getClass().getSimpleName() + " putMap", th, null, 4, null);
        }
        return bundle;
    }

    public static /* synthetic */ void setTrackingData$default(AnalyticsUtils$Tracker analyticsUtils$Tracker, String str, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        analyticsUtils$Tracker.setTrackingData(str, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void track$default(AnalyticsUtils$Tracker analyticsUtils$Tracker, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        analyticsUtils$Tracker.track(str, map);
    }

    public final boolean isAuthed$app_productionGoogleRelease() {
        String str = this.analyticsToken;
        return !(str == null || t.isBlank(str));
    }

    public final synchronized void setTrackingData(String analyticsToken, boolean fingerprinted) {
        drainEventsQueue();
        this.analyticsToken = analyticsToken;
        this.fingerprinted = fingerprinted;
        drainEventsQueue();
    }

    public final void track(Pair<String, Long> throttleKey, long throttleTimeMs, Function0<? extends Map<String, ? extends Object>> lazyPropertyProvider) {
        m.checkNotNullParameter(throttleKey, "throttleKey");
        m.checkNotNullParameter(lazyPropertyProvider, "lazyPropertyProvider");
        if (isEventThrottled(throttleKey)) {
            return;
        }
        track(throttleKey.component1(), lazyPropertyProvider.invoke());
        this.eventsThrottledUntilMillis.put(throttleKey, Long.valueOf(this.clock.currentTimeMillis() + throttleTimeMs));
    }

    public final void trackFireBase(String event, Map<String, ? extends Object> properties) {
        m.checkNotNullParameter(event, "event");
        m.checkNotNullParameter(properties, "properties");
        Bundle bundlePutMap = putMap(new Bundle(), properties);
        FirebaseAnalytics firebaseAnalyticsAccess$getFireBaseInstance$p = AnalyticsUtils.access$getFireBaseInstance$p(AnalyticsUtils.INSTANCE);
        if (firebaseAnalyticsAccess$getFireBaseInstance$p != null) {
            firebaseAnalyticsAccess$getFireBaseInstance$p.f3109b.c(null, event, bundlePutMap, false, true, null);
        }
    }

    public final void track(String event, Map<String, ? extends Object> properties) {
        m.checkNotNullParameter(event, "event");
        if (properties == null) {
            properties = h0.emptyMap();
        }
        track(new Science$Event$MapObject(event, properties));
    }

    public final void track(AnalyticsSchema analyticsSchema) {
        m.checkNotNullParameter(analyticsSchema, "analyticsSchema");
        if (analyticsSchema instanceof TrackGuildReceiver) {
            TrackGuildReceiver trackGuildReceiver = (TrackGuildReceiver) analyticsSchema;
            trackGuildReceiver.c(AnalyticsUtilsKt.access$fill(trackGuildReceiver.getTrackGuild()));
        }
        track(new Science$Event$SchemaObject(analyticsSchema));
    }

    public final void track(Science$Event event) {
        m.checkNotNullParameter(event, "event");
        this.eventsQueue.add(event);
        Observable<Long> observableD0 = Observable.d0(1500L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableD0, AnalyticsUtils$Tracker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnalyticsUtils$Tracker$track$1(this), 62, (Object) null);
    }
}
