package com.discord.utilities.intent;

import android.net.Uri;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.p019m0.C0877a;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p579g0.C12102s;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StaticChannelRoutes.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum StaticChannelRoutes {
    ROLE_SUBSCRIPTIONS("role-subscriptions");

    private final String route;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy routeToName$delegate = C12083g.lazy(StaticChannelRoutes$Companion$routeToName$2.INSTANCE);

    /* JADX INFO: compiled from: StaticChannelRoutes.kt */
    public static final class Companion {
        private Companion() {
        }

        private final StaticChannelRoutes fromRoute(String route) {
            return getRouteToName().get(route);
        }

        private final Map<String, StaticChannelRoutes> getRouteToName() {
            Lazy lazy = StaticChannelRoutes.routeToName$delegate;
            Companion companion = StaticChannelRoutes.INSTANCE;
            return (Map) lazy.getValue();
        }

        public final WithGuild extractStaticRoute(Uri uri) {
            String path;
            StaticChannelRoutes staticChannelRoutesFromRoute;
            Long longOrNull;
            C12238m.checkNotNullParameter(uri, "$this$extractStaticRoute");
            if ((uri.getHost() == null || IntentUtils.INSTANCE.isHttpDomainUrl(uri)) && (path = uri.getPath()) != null) {
                C0877a c0877a = C0877a.f538G;
                Regex regex = C0877a.f559u;
                C12238m.checkNotNullExpressionValue(path, "path");
                MatchResult matchResultMatchEntire = regex.matchEntire(path);
                if (matchResultMatchEntire != null && (staticChannelRoutesFromRoute = fromRoute((String) C12163u.getOrNull(matchResultMatchEntire.getGroupValues(), 2))) != null) {
                    String str = (String) C12163u.getOrNull(matchResultMatchEntire.getGroupValues(), 1);
                    return new WithGuild(staticChannelRoutesFromRoute, (str == null || (longOrNull = C12102s.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue());
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StaticChannelRoutes.kt */
    public static final /* data */ class WithGuild {
        private final long guildId;
        private final StaticChannelRoutes route;

        public WithGuild(StaticChannelRoutes staticChannelRoutes, long j) {
            C12238m.checkNotNullParameter(staticChannelRoutes, "route");
            this.route = staticChannelRoutes;
            this.guildId = j;
        }

        public static /* synthetic */ WithGuild copy$default(WithGuild withGuild, StaticChannelRoutes staticChannelRoutes, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                staticChannelRoutes = withGuild.route;
            }
            if ((i & 2) != 0) {
                j = withGuild.guildId;
            }
            return withGuild.copy(staticChannelRoutes, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StaticChannelRoutes getRoute() {
            return this.route;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final WithGuild copy(StaticChannelRoutes route, long guildId) {
            C12238m.checkNotNullParameter(route, "route");
            return new WithGuild(route, guildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WithGuild)) {
                return false;
            }
            WithGuild withGuild = (WithGuild) other;
            return C12238m.areEqual(this.route, withGuild.route) && this.guildId == withGuild.guildId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final StaticChannelRoutes getRoute() {
            return this.route;
        }

        public int hashCode() {
            StaticChannelRoutes staticChannelRoutes = this.route;
            return C0002b.m3a(this.guildId) + ((staticChannelRoutes != null ? staticChannelRoutes.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("WithGuild(route=");
            sbM833U.append(this.route);
            sbM833U.append(", guildId=");
            return C1643a.m815C(sbM833U, this.guildId, ")");
        }
    }

    StaticChannelRoutes(String str) {
        this.route = str;
    }

    public final String getRoute() {
        return this.route;
    }
}
