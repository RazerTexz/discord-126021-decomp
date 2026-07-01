package com.discord.stores;

import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.time.Clock;
import d0.o;
import d0.t.h0;
import d0.t.u;
import d0.z.d.m;

/* JADX INFO: compiled from: ConnectionTimeStats.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionTimeStats$Stat {
    private final Clock clock;
    private Long endTime;
    private final ConnectionTimeStats owner;
    private Long startTime;
    private final ConnectionTimeStats$StatType type;

    public ConnectionTimeStats$Stat(Clock clock, ConnectionTimeStats connectionTimeStats, ConnectionTimeStats$StatType connectionTimeStats$StatType) {
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(connectionTimeStats, "owner");
        m.checkNotNullParameter(connectionTimeStats$StatType, "type");
        this.clock = clock;
        this.owner = connectionTimeStats;
        this.type = connectionTimeStats$StatType;
    }

    public static /* synthetic */ void end$default(ConnectionTimeStats$Stat connectionTimeStats$Stat, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        connectionTimeStats$Stat.end(z2);
    }

    public static /* synthetic */ void start$default(ConnectionTimeStats$Stat connectionTimeStats$Stat, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        connectionTimeStats$Stat.start(z2);
    }

    public final void clear() {
        this.startTime = null;
        this.endTime = null;
    }

    public final Long elapsed() {
        Long l = this.startTime;
        Long l2 = this.endTime;
        if (l == null || l2 == null) {
            return null;
        }
        return Long.valueOf(l2.longValue() - l.longValue());
    }

    public final void end(boolean ignoreSubsequentCalls) {
        if (this.endTime != null) {
            if (ignoreSubsequentCalls) {
                return;
            }
            AppLog appLog = AppLog.g;
            StringBuilder sbU = a.U("ConnectionTimeStats: \"");
            sbU.append(this.type);
            sbU.append("\" attempting to end while endTime is set!");
            Logger.w$default(appLog, sbU.toString(), null, 2, null);
            return;
        }
        Long l = this.startTime;
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        if (l == null) {
            AppLog appLog2 = AppLog.g;
            StringBuilder sbU2 = a.U("ConnectionTimeStats: \"");
            sbU2.append(this.type);
            sbU2.append("\" ended without starting!");
            Logger.w$default(appLog2, sbU2.toString(), null, 2, null);
            return;
        }
        long jLongValue = jCurrentTimeMillis - l.longValue();
        if (jLongValue < 0) {
            AppLog appLog3 = AppLog.g;
            StringBuilder sbU3 = a.U("ConnectionTimeStats: \"");
            sbU3.append(this.type);
            sbU3.append("\" has a negative time!");
            sbU3.append(u.joinToString$default(h0.mapOf(o.to(this.type.toString(), "type"), o.to(String.valueOf(jLongValue), "elapsedMs"), o.to(String.valueOf(l.longValue()), "start"), o.to(String.valueOf(jCurrentTimeMillis), "end")).entrySet(), "\n\t", null, null, 0, null, null, 62, null));
            Logger.w$default(appLog3, sbU3.toString(), null, 2, null);
            return;
        }
        this.endTime = Long.valueOf(jCurrentTimeMillis);
        StringBuilder sbU4 = a.U("ConnectionTimeStats: \"");
        sbU4.append(this.type);
        sbU4.append("\" took ");
        sbU4.append(jLongValue);
        sbU4.append(" ms (");
        sbU4.append(l);
        sbU4.append(" to ");
        sbU4.append(jCurrentTimeMillis);
        sbU4.append(')');
        AppLog.i(sbU4.toString());
        ConnectionTimeStats.access$sendAnalyticsEvent(this.owner, this.type);
    }

    public final void start(boolean ignoreSubsequentCalls) {
        if (this.startTime != null) {
            if (ignoreSubsequentCalls) {
                return;
            }
            AppLog appLog = AppLog.g;
            StringBuilder sbU = a.U("ConnectionTimeStats: \"");
            sbU.append(this.type);
            sbU.append("\" attempting to re-start without reset!");
            Logger.w$default(appLog, sbU.toString(), null, 2, null);
            return;
        }
        if (this.endTime != null) {
            AppLog appLog2 = AppLog.g;
            StringBuilder sbU2 = a.U("ConnectionTimeStats: \"");
            sbU2.append(this.type);
            sbU2.append("\" attempting to re-start while endTime is set!");
            Logger.w$default(appLog2, sbU2.toString(), null, 2, null);
            return;
        }
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        this.startTime = Long.valueOf(jCurrentTimeMillis);
        StringBuilder sbU3 = a.U("ConnectionTimeStats: \"");
        sbU3.append(this.type);
        sbU3.append("\" started @ ");
        sbU3.append(jCurrentTimeMillis);
        AppLog.i(sbU3.toString());
    }
}
