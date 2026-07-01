package com.discord.utilities.analytics;

import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import d0.z.d.m;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AppStartAnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppStartAnalyticsTracker$Companion {
    private AppStartAnalyticsTracker$Companion() {
    }

    public static final /* synthetic */ Map access$insertUriProperties(AppStartAnalyticsTracker$Companion appStartAnalyticsTracker$Companion, Map map, Uri uri) {
        return appStartAnalyticsTracker$Companion.insertUriProperties(map, uri);
    }

    private final Map<String, Object> insertUriProperties(Map<String, Object> map, Uri uri) {
        String host = uri.getHost();
        if (host != null) {
            m.checkNotNullExpressionValue(host, "it");
            map.put("uri_host", host);
        }
        String scheme = uri.getScheme();
        if (scheme != null) {
            m.checkNotNullExpressionValue(scheme, "it");
            map.put("uri_scheme", scheme);
        }
        String path = uri.getPath();
        if (!(path == null || path.length() == 0)) {
            if (path.length() > 100) {
                path = path.substring(0, 99);
                m.checkNotNullExpressionValue(path, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            map.put("uri_path", path);
        }
        return map;
    }

    public final AppStartAnalyticsTracker getInstance() {
        Lazy lazyAccess$getInstance$cp = AppStartAnalyticsTracker.access$getInstance$cp();
        AppStartAnalyticsTracker$Companion appStartAnalyticsTracker$Companion = AppStartAnalyticsTracker.Companion;
        return (AppStartAnalyticsTracker) lazyAccess$getInstance$cp.getValue();
    }

    public /* synthetic */ AppStartAnalyticsTracker$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
