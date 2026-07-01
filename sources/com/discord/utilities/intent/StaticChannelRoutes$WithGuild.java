package com.discord.utilities.intent;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StaticChannelRoutes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StaticChannelRoutes$WithGuild {
    private final long guildId;
    private final StaticChannelRoutes route;

    public StaticChannelRoutes$WithGuild(StaticChannelRoutes staticChannelRoutes, long j) {
        m.checkNotNullParameter(staticChannelRoutes, "route");
        this.route = staticChannelRoutes;
        this.guildId = j;
    }

    public static /* synthetic */ StaticChannelRoutes$WithGuild copy$default(StaticChannelRoutes$WithGuild staticChannelRoutes$WithGuild, StaticChannelRoutes staticChannelRoutes, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            staticChannelRoutes = staticChannelRoutes$WithGuild.route;
        }
        if ((i & 2) != 0) {
            j = staticChannelRoutes$WithGuild.guildId;
        }
        return staticChannelRoutes$WithGuild.copy(staticChannelRoutes, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StaticChannelRoutes getRoute() {
        return this.route;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final StaticChannelRoutes$WithGuild copy(StaticChannelRoutes route, long guildId) {
        m.checkNotNullParameter(route, "route");
        return new StaticChannelRoutes$WithGuild(route, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StaticChannelRoutes$WithGuild)) {
            return false;
        }
        StaticChannelRoutes$WithGuild staticChannelRoutes$WithGuild = (StaticChannelRoutes$WithGuild) other;
        return m.areEqual(this.route, staticChannelRoutes$WithGuild.route) && this.guildId == staticChannelRoutes$WithGuild.guildId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final StaticChannelRoutes getRoute() {
        return this.route;
    }

    public int hashCode() {
        StaticChannelRoutes staticChannelRoutes = this.route;
        return b.a(this.guildId) + ((staticChannelRoutes != null ? staticChannelRoutes.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("WithGuild(route=");
        sbU.append(this.route);
        sbU.append(", guildId=");
        return a.C(sbU, this.guildId, ")");
    }
}
