package com.discord.utilities.analytics;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.time.Clock;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AppStartAnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppStartAnalyticsTracker {
    private static final String APP_FIRST_LAUNCHED = "app_first_launched";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy instance$delegate = C12083g.lazy(AppStartAnalyticsTracker$Companion$instance$2.INSTANCE);
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
                C12238m.checkNotNullExpressionValue(host, "it");
                map.put("uri_host", host);
            }
            String scheme = uri.getScheme();
            if (scheme != null) {
                C12238m.checkNotNullExpressionValue(scheme, "it");
                map.put("uri_scheme", scheme);
            }
            String path = uri.getPath();
            if (!(path == null || path.length() == 0)) {
                if (path.length() > 100) {
                    path = path.substring(0, 99);
                    C12238m.checkNotNullExpressionValue(path, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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

    /* JADX INFO: renamed from: com.discord.utilities.analytics.AppStartAnalyticsTracker$appOpen$1 */
    /* JADX INFO: compiled from: AppStartAnalyticsTracker.kt */
    public static final class C66831 extends AbstractC12240o implements Function0<Map<String, ? extends Object>> {
        public final /* synthetic */ boolean $isNotificationRoute;
        public final /* synthetic */ Uri $uri;
        public final /* synthetic */ boolean $uriCanBeRouted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66831(boolean z2, boolean z3, Uri uri) {
            super(0);
            this.$isNotificationRoute = z2;
            this.$uriCanBeRouted = z3;
            this.$uri = uri;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends Object> invoke() {
            String str;
            Pair[] pairArr = new Pair[2];
            if (this.$isNotificationRoute) {
                str = "notification";
            } else {
                str = this.$uriCanBeRouted ? Constants.DEEPLINK : "launcher";
            }
            pairArr[0] = C12116o.m10073to("opened_from", str);
            pairArr[1] = C12116o.m10073to("theme", AppStartAnalyticsTracker.this.storeUserSettingsSystem.getTheme());
            Map<String, ? extends Object> mapMutableMapOf = C12136h0.mutableMapOf(pairArr);
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
        C12238m.checkNotNullParameter(tracker, "tracker");
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(storeUserSettingsSystem, "storeUserSettingsSystem");
        this.tracker = tracker;
        this.clock = clock;
        this.storeUserSettingsSystem = storeUserSettingsSystem;
        String string = UUID.randomUUID().toString();
        C12238m.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
        this.openAppLoadId = string;
    }

    public final void appOpen(Uri uri, boolean uriCanBeRouted, boolean isNotificationRoute) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        this.tracker.track(C12116o.m10073to("app_opened", null), 300000L, new C66831(isNotificationRoute, uriCanBeRouted, uri));
        Persister persister = new Persister(APP_FIRST_LAUNCHED, Boolean.TRUE);
        if (((Boolean) persister.get()).booleanValue()) {
            this.tracker.track(APP_FIRST_LAUNCHED, C12134g0.mapOf(C12116o.m10073to("platform", "Android")));
            persister.set(Boolean.FALSE, true);
        }
    }

    public final void appUiViewed(String screenName, long time) {
        C12238m.checkNotNullParameter(screenName, "screenName");
        Long l = this.appOpenTimestamp;
        this.tracker.track("app_ui_viewed", C12136h0.mutableMapOf(C12116o.m10073to("screen_name", screenName), C12116o.m10073to("load_id", this.openAppLoadId), C12116o.m10073to("duration_ms_since_app_opened", Long.valueOf(l != null ? time - l.longValue() : -1L)), C12116o.m10073to("has_cached_data", Boolean.TRUE), C12116o.m10073to("theme", this.storeUserSettingsSystem.getTheme())));
    }
}
