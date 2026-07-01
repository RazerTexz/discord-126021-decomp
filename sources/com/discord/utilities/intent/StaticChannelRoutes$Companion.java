package com.discord.utilities.intent;

import android.net.Uri;
import b.a.d.m0.a;
import d0.g0.s;
import d0.t.u;
import d0.z.d.m;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: compiled from: StaticChannelRoutes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StaticChannelRoutes$Companion {
    private StaticChannelRoutes$Companion() {
    }

    private final StaticChannelRoutes fromRoute(String route) {
        return getRouteToName().get(route);
    }

    private final Map<String, StaticChannelRoutes> getRouteToName() {
        Lazy lazyAccess$getRouteToName$cp = StaticChannelRoutes.access$getRouteToName$cp();
        StaticChannelRoutes$Companion staticChannelRoutes$Companion = StaticChannelRoutes.Companion;
        return (Map) lazyAccess$getRouteToName$cp.getValue();
    }

    public final StaticChannelRoutes$WithGuild extractStaticRoute(Uri uri) {
        String path;
        StaticChannelRoutes staticChannelRoutesFromRoute;
        Long longOrNull;
        m.checkNotNullParameter(uri, "$this$extractStaticRoute");
        if ((uri.getHost() == null || IntentUtils.INSTANCE.isHttpDomainUrl(uri)) && (path = uri.getPath()) != null) {
            a aVar = a.G;
            Regex regex = a.u;
            m.checkNotNullExpressionValue(path, "path");
            MatchResult matchResultMatchEntire = regex.matchEntire(path);
            if (matchResultMatchEntire != null && (staticChannelRoutesFromRoute = fromRoute((String) u.getOrNull(matchResultMatchEntire.getGroupValues(), 2))) != null) {
                String str = (String) u.getOrNull(matchResultMatchEntire.getGroupValues(), 1);
                return new StaticChannelRoutes$WithGuild(staticChannelRoutesFromRoute, (str == null || (longOrNull = s.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue());
            }
        }
        return null;
    }

    public /* synthetic */ StaticChannelRoutes$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
