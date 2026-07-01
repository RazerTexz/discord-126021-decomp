package com.discord.utilities.analytics;

import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.time.Clock;
import d0.g;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import java.util.UUID;
import kotlin.Lazy;

/* JADX INFO: compiled from: AppStartAnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppStartAnalyticsTracker {
    private static final String APP_FIRST_LAUNCHED = "app_first_launched";
    public static final AppStartAnalyticsTracker$Companion Companion = new AppStartAnalyticsTracker$Companion(null);
    private static final Lazy instance$delegate = g.lazy(AppStartAnalyticsTracker$Companion$instance$2.INSTANCE);
    private Long appOpenTimestamp;
    private final Clock clock;
    private final String openAppLoadId;
    private final StoreUserSettingsSystem storeUserSettingsSystem;
    private final AnalyticsUtils$Tracker tracker;

    public AppStartAnalyticsTracker(AnalyticsUtils$Tracker analyticsUtils$Tracker, Clock clock, StoreUserSettingsSystem storeUserSettingsSystem) {
        m.checkNotNullParameter(analyticsUtils$Tracker, "tracker");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeUserSettingsSystem, "storeUserSettingsSystem");
        this.tracker = analyticsUtils$Tracker;
        this.clock = clock;
        this.storeUserSettingsSystem = storeUserSettingsSystem;
        String string = UUID.randomUUID().toString();
        m.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
        this.openAppLoadId = string;
    }

    public static final /* synthetic */ Long access$getAppOpenTimestamp$p(AppStartAnalyticsTracker appStartAnalyticsTracker) {
        return appStartAnalyticsTracker.appOpenTimestamp;
    }

    public static final /* synthetic */ Clock access$getClock$p(AppStartAnalyticsTracker appStartAnalyticsTracker) {
        return appStartAnalyticsTracker.clock;
    }

    public static final /* synthetic */ Lazy access$getInstance$cp() {
        return instance$delegate;
    }

    public static final /* synthetic */ String access$getOpenAppLoadId$p(AppStartAnalyticsTracker appStartAnalyticsTracker) {
        return appStartAnalyticsTracker.openAppLoadId;
    }

    public static final /* synthetic */ StoreUserSettingsSystem access$getStoreUserSettingsSystem$p(AppStartAnalyticsTracker appStartAnalyticsTracker) {
        return appStartAnalyticsTracker.storeUserSettingsSystem;
    }

    public static final /* synthetic */ void access$setAppOpenTimestamp$p(AppStartAnalyticsTracker appStartAnalyticsTracker, Long l) {
        appStartAnalyticsTracker.appOpenTimestamp = l;
    }

    public final void appOpen(Uri uri, boolean uriCanBeRouted, boolean isNotificationRoute) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        this.tracker.track(o.to("app_opened", null), 300000L, new AppStartAnalyticsTracker$appOpen$1(this, isNotificationRoute, uriCanBeRouted, uri));
        Persister persister = new Persister(APP_FIRST_LAUNCHED, Boolean.TRUE);
        if (((Boolean) persister.get()).booleanValue()) {
            this.tracker.track(APP_FIRST_LAUNCHED, g0.mapOf(o.to("platform", "Android")));
            persister.set(Boolean.FALSE, true);
        }
    }

    public final void appUiViewed(String screenName, long time) {
        m.checkNotNullParameter(screenName, "screenName");
        Long l = this.appOpenTimestamp;
        this.tracker.track("app_ui_viewed", h0.mutableMapOf(o.to("screen_name", screenName), o.to("load_id", this.openAppLoadId), o.to("duration_ms_since_app_opened", Long.valueOf(l != null ? time - l.longValue() : -1L)), o.to("has_cached_data", Boolean.TRUE), o.to("theme", this.storeUserSettingsSystem.getTheme())));
    }
}
