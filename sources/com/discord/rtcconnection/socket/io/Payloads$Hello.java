package com.discord.rtcconnection.socket.io;

import b.d.b.a.a;
import b.i.d.p.b;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$Hello {

    @b("heartbeat_interval")
    private final long heartbeatIntervalMs;

    @b("v")
    private final int serverVersion;

    public Payloads$Hello(long j, int i) {
        this.heartbeatIntervalMs = j;
        this.serverVersion = i;
    }

    public static /* synthetic */ Payloads$Hello copy$default(Payloads$Hello payloads$Hello, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = payloads$Hello.heartbeatIntervalMs;
        }
        if ((i2 & 2) != 0) {
            i = payloads$Hello.serverVersion;
        }
        return payloads$Hello.copy(j, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getHeartbeatIntervalMs() {
        return this.heartbeatIntervalMs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getServerVersion() {
        return this.serverVersion;
    }

    public final Payloads$Hello copy(long heartbeatIntervalMs, int serverVersion) {
        return new Payloads$Hello(heartbeatIntervalMs, serverVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Payloads$Hello)) {
            return false;
        }
        Payloads$Hello payloads$Hello = (Payloads$Hello) other;
        return this.heartbeatIntervalMs == payloads$Hello.heartbeatIntervalMs && this.serverVersion == payloads$Hello.serverVersion;
    }

    public final long getHeartbeatIntervalMs() {
        return this.heartbeatIntervalMs;
    }

    public final int getServerVersion() {
        return this.serverVersion;
    }

    public int hashCode() {
        return (a0.a.a.b.a(this.heartbeatIntervalMs) * 31) + this.serverVersion;
    }

    public String toString() {
        StringBuilder sbU = a.U("Hello(heartbeatIntervalMs=");
        sbU.append(this.heartbeatIntervalMs);
        sbU.append(", serverVersion=");
        return a.B(sbU, this.serverVersion, ")");
    }
}
