package com.discord.utilities.analytics;

import android.app.Application;
import android.os.Bundle;
import androidx.annotation.MainThread;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.channel.Channel;
import com.discord.api.science.AnalyticsSchema;
import com.discord.api.science.Science;
import com.discord.api.user.User;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.MeUser;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.device.RtcCameraConfig;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;
import p007b.p225i.p226a.p288f.p313h.p325l.C3755n;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: AnalyticsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsUtils {
    public static final AnalyticsUtils INSTANCE = new AnalyticsUtils();
    private static FirebaseAnalytics fireBaseInstance;

    /* JADX INFO: renamed from: com.discord.utilities.analytics.AnalyticsUtils$initAppOpen$1 */
    /* JADX INFO: compiled from: AnalyticsUtils.kt */
    public static final class C66821 extends AbstractC12240o implements Function1<MeUser, Unit> {
        public static final C66821 INSTANCE = new C66821();

        public C66821() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            C12238m.checkNotNullParameter(meUser, "meUser");
            if (C12238m.areEqual(meUser, UserUtils.INSTANCE.getEMPTY_USER())) {
                AppLog.m8357g(0L, null, null);
                FirebaseAnalytics firebaseAnalyticsAccess$getFireBaseInstance$p = AnalyticsUtils.access$getFireBaseInstance$p(AnalyticsUtils.INSTANCE);
                if (firebaseAnalyticsAccess$getFireBaseInstance$p != null) {
                    C3661g c3661g = firebaseAnalyticsAccess$getFireBaseInstance$p.f21404b;
                    Objects.requireNonNull(c3661g);
                    c3661g.f9950e.execute(new C3755n(c3661g, null));
                    return;
                }
                return;
            }
            FirebaseAnalytics firebaseAnalyticsAccess$getFireBaseInstance$p2 = AnalyticsUtils.access$getFireBaseInstance$p(AnalyticsUtils.INSTANCE);
            if (firebaseAnalyticsAccess$getFireBaseInstance$p2 != null) {
                String strValueOf = String.valueOf(meUser.getId());
                C3661g c3661g2 = firebaseAnalyticsAccess$getFireBaseInstance$p2.f21404b;
                Objects.requireNonNull(c3661g2);
                c3661g2.f9950e.execute(new C3755n(c3661g2, strValueOf));
            }
            AppLog.m8357g(Long.valueOf(meUser.getId()), meUser.getEmail(), meUser.getUsername());
        }
    }

    private AnalyticsUtils() {
    }

    public static final /* synthetic */ FirebaseAnalytics access$getFireBaseInstance$p(AnalyticsUtils analyticsUtils) {
        return fireBaseInstance;
    }

    public final Map<String, Object> getProperties$app_productionGoogleRelease(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$properties");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = C12116o.m10073to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channel.getId()));
        pairArr[1] = C12116o.m10073to("channel_type", Integer.valueOf(channel.getType()));
        List<User> listM7659z = channel.m7659z();
        pairArr[2] = C12116o.m10073to("channel_size_total", Integer.valueOf(listM7659z != null ? listM7659z.size() : 0));
        return C12136h0.mapOf(pairArr);
    }

    @MainThread
    public final void initAppOpen(Application context) {
        C12238m.checkNotNullParameter(context, "context");
        if (fireBaseInstance != null) {
            return;
        }
        fireBaseInstance = FirebaseAnalytics.getInstance(context);
        ObservableExtensionsKt.appSubscribe(StoreStream.INSTANCE.getUsers().observeMe(true), (Class<?>) AnalyticsUtils.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C66821.INSTANCE);
        RtcCameraConfig.INSTANCE.init();
    }

    /* JADX INFO: compiled from: AnalyticsUtils.kt */
    public static final class Tracker {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy instance$delegate = C12083g.lazy(AnalyticsUtils$Tracker$Companion$instance$2.INSTANCE);
        private String analyticsToken;
        private final Clock clock;
        private final ConcurrentLinkedQueue<Science.Event> eventsQueue;
        private final ConcurrentHashMap<Pair<String, Long>, Long> eventsThrottledUntilMillis;
        private boolean fingerprinted;
        private final RestAPI restAPI;

        /* JADX INFO: compiled from: AnalyticsUtils.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Tracker getInstance() {
                Lazy lazy = Tracker.instance$delegate;
                Companion companion = Tracker.INSTANCE;
                return (Tracker) lazy.getValue();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Tracker(Clock clock, RestAPI restAPI, ConcurrentLinkedQueue<Science.Event> concurrentLinkedQueue) {
            C12238m.checkNotNullParameter(clock, "clock");
            C12238m.checkNotNullParameter(restAPI, "restAPI");
            C12238m.checkNotNullParameter(concurrentLinkedQueue, "eventsQueue");
            this.clock = clock;
            this.restAPI = restAPI;
            this.eventsQueue = concurrentLinkedQueue;
            this.eventsThrottledUntilMillis = new ConcurrentHashMap<>();
        }

        private final synchronized void drainEventsQueue() {
            if (getCanDrain()) {
                ArrayList arrayList = new ArrayList(this.eventsQueue);
                this.eventsQueue.clear();
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.science(new Science(this.analyticsToken, arrayList)), false, 1, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnalyticsUtils$Tracker$drainEventsQueue$2(this, arrayList)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), AnalyticsUtils$Tracker$drainEventsQueue$1.INSTANCE);
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
            C12238m.checkNotNullExpressionValue(l, "eventsThrottledUntilMillis[throttleKey] ?: 0");
            return jCurrentTimeMillis < l.longValue();
        }

        private final Bundle putMap(Bundle bundle, Map<String, ? extends Object> map) {
            try {
                for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
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
                Logger.e$default(AppLog.f14950g, bundle.getClass().getSimpleName() + " putMap", th, null, 4, null);
            }
            return bundle;
        }

        public static /* synthetic */ void setTrackingData$default(Tracker tracker, String str, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            tracker.setTrackingData(str, z2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void track$default(Tracker tracker, String str, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = null;
            }
            tracker.track(str, map);
        }

        public final boolean isAuthed$app_productionGoogleRelease() {
            String str = this.analyticsToken;
            return !(str == null || C12103t.isBlank(str));
        }

        public final synchronized void setTrackingData(String analyticsToken, boolean fingerprinted) {
            drainEventsQueue();
            this.analyticsToken = analyticsToken;
            this.fingerprinted = fingerprinted;
            drainEventsQueue();
        }

        public final void track(Pair<String, Long> throttleKey, long throttleTimeMs, Function0<? extends Map<String, ? extends Object>> lazyPropertyProvider) {
            C12238m.checkNotNullParameter(throttleKey, "throttleKey");
            C12238m.checkNotNullParameter(lazyPropertyProvider, "lazyPropertyProvider");
            if (isEventThrottled(throttleKey)) {
                return;
            }
            track(throttleKey.component1(), lazyPropertyProvider.invoke());
            this.eventsThrottledUntilMillis.put(throttleKey, Long.valueOf(this.clock.currentTimeMillis() + throttleTimeMs));
        }

        public final void trackFireBase(String event, Map<String, ? extends Object> properties) {
            C12238m.checkNotNullParameter(event, "event");
            C12238m.checkNotNullParameter(properties, "properties");
            Bundle bundlePutMap = putMap(new Bundle(), properties);
            FirebaseAnalytics firebaseAnalyticsAccess$getFireBaseInstance$p = AnalyticsUtils.access$getFireBaseInstance$p(AnalyticsUtils.INSTANCE);
            if (firebaseAnalyticsAccess$getFireBaseInstance$p != null) {
                firebaseAnalyticsAccess$getFireBaseInstance$p.f21404b.m4886c(null, event, bundlePutMap, false, true, null);
            }
        }

        public final void track(String event, Map<String, ? extends Object> properties) {
            C12238m.checkNotNullParameter(event, "event");
            if (properties == null) {
                properties = C12136h0.emptyMap();
            }
            track(new Science.Event.MapObject(event, properties));
        }

        public final void track(AnalyticsSchema analyticsSchema) {
            C12238m.checkNotNullParameter(analyticsSchema, "analyticsSchema");
            if (analyticsSchema instanceof TrackGuildReceiver) {
                TrackGuildReceiver trackGuildReceiver = (TrackGuildReceiver) analyticsSchema;
                trackGuildReceiver.mo7508c(AnalyticsUtilsKt.fill(trackGuildReceiver.getTrackGuild()));
            }
            track(new Science.Event.SchemaObject(analyticsSchema));
        }

        public final void track(Science.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            this.eventsQueue.add(event);
            Observable<Long> observableM11068d0 = Observable.m11068d0(1500L, TimeUnit.MILLISECONDS);
            C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable\n          .ti…0, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(observableM11068d0, (Class<?>) Tracker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnalyticsUtils$Tracker$track$1(this));
        }
    }

    public final Map<String, String> getProperties$app_productionGoogleRelease(RtcConnection rtcConnection) {
        C12238m.checkNotNullParameter(rtcConnection, "$this$properties");
        return C12134g0.mapOf(C12116o.m10073to("rtc_connection_id", rtcConnection.id));
    }
}
