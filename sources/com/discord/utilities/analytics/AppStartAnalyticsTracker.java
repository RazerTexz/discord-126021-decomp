package com.discord.utilities.analytics;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.time.Clock;
import d0.LazyJVM;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AppStartAnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppStartAnalyticsTracker {
    private static final String APP_FIRST_LAUNCHED = "app_first_launched";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy instance$delegate = LazyJVM.lazy(AppStartAnalyticsTracker2.INSTANCE);
    private Long appOpenTimestamp;
    private final Clock clock;
    private final String openAppLoadId;
    private final StoreUserSettingsSystem storeUserSettingsSystem;
    private final AnalyticsUtils.Tracker tracker;

    /* JADX INFO: compiled from: AppStartAnalyticsTracker.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Map<String, Object> insertUriProperties(Map<String, Object> map, Uri uri) {
            String host = uri.getHost();
            if (host != null) {
                Intrinsics3.checkNotNullExpressionValue(host, "it");
                map.put("uri_host", host);
            }
            String scheme = uri.getScheme();
            if (scheme != null) {
                Intrinsics3.checkNotNullExpressionValue(scheme, "it");
                map.put("uri_scheme", scheme);
            }
            String path = uri.getPath();
            if (!(path == null || path.length() == 0)) {
                if (path.length() > 100) {
                    path = path.substring(0, 99);
                    Intrinsics3.checkNotNullExpressionValue(path, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                map.put("uri_path", path);
            }
            return map;
        }

        public final AppStartAnalyticsTracker getInstance() {
            Lazy lazy = AppStartAnalyticsTracker.instance$delegate;
            Companion companion = AppStartAnalyticsTracker.INSTANCE;
            return (AppStartAnalyticsTracker) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.analytics.AppStartAnalyticsTracker$appOpen$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppStartAnalyticsTracker.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<String, ? extends Object>> {
        public final /* synthetic */ boolean $isNotificationRoute;
        public final /* synthetic */ Uri $uri;
        public final /* synthetic */ boolean $uriCanBeRouted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, boolean z3, Uri uri) {
            super(0);
            this.$isNotificationRoute = z2;
            this.$uriCanBeRouted = z3;
            this.$uri = uri;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends Object> invoke() {
            String str;
            Tuples2[] tuples2Arr = new Tuples2[2];
            if (this.$isNotificationRoute) {
                str = "notification";
            } else {
                str = this.$uriCanBeRouted ? Constants.DEEPLINK : "launcher";
            }
            tuples2Arr[0] = Tuples.to("opened_from", str);
            tuples2Arr[1] = Tuples.to("theme", AppStartAnalyticsTracker.this.storeUserSettingsSystem.getTheme());
            Map<String, ? extends Object> mapMutableMapOf = Maps6.mutableMapOf(tuples2Arr);
            AppStartAnalyticsTracker.INSTANCE.insertUriProperties(mapMutableMapOf, this.$uri);
            if (AppStartAnalyticsTracker.this.appOpenTimestamp == null) {
                mapMutableMapOf.put("load_id", AppStartAnalyticsTracker.this.openAppLoadId);
                AppStartAnalyticsTracker appStartAnalyticsTracker = AppStartAnalyticsTracker.this;
                appStartAnalyticsTracker.appOpenTimestamp = Long.valueOf(appStartAnalyticsTracker.clock.currentTimeMillis());
            }
            return mapMutableMapOf;
        }
    }

    public AppStartAnalyticsTracker(AnalyticsUtils.Tracker tracker, Clock clock, StoreUserSettingsSystem storeUserSettingsSystem) {
        Intrinsics3.checkNotNullParameter(tracker, "tracker");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeUserSettingsSystem, "storeUserSettingsSystem");
        this.tracker = tracker;
        this.clock = clock;
        this.storeUserSettingsSystem = storeUserSettingsSystem;
        String string = UUID.randomUUID().toString();
        Intrinsics3.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
        this.openAppLoadId = string;
    }

    public final void appOpen(Uri uri, boolean uriCanBeRouted, boolean isNotificationRoute) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        this.tracker.track(Tuples.to("app_opened", null), 300000L, new AnonymousClass1(isNotificationRoute, uriCanBeRouted, uri));
        Persister persister = new Persister(APP_FIRST_LAUNCHED, Boolean.TRUE);
        if (((Boolean) persister.get()).booleanValue()) {
            this.tracker.track(APP_FIRST_LAUNCHED, MapsJVM.mapOf(Tuples.to("platform", "Android")));
            persister.set(Boolean.FALSE, true);
        }
    }

    public final void appUiViewed(String screenName, long time) {
        Intrinsics3.checkNotNullParameter(screenName, "screenName");
        Long l = this.appOpenTimestamp;
        this.tracker.track("app_ui_viewed", Maps6.mutableMapOf(Tuples.to("screen_name", screenName), Tuples.to("load_id", this.openAppLoadId), Tuples.to("duration_ms_since_app_opened", Long.valueOf(l != null ? time - l.longValue() : -1L)), Tuples.to("has_cached_data", Boolean.TRUE), Tuples.to("theme", this.storeUserSettingsSystem.getTheme())));
    }
}
