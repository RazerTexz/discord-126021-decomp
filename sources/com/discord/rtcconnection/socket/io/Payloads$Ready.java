package com.discord.rtcconnection.socket.io;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$Ready {
    private final String ip;
    private final int port;
    private final int ssrc;
    private final List<Payloads$Stream> streams;

    public Payloads$Ready(int i, int i2, String str, List<Payloads$Stream> list) {
        m.checkNotNullParameter(str, "ip");
        m.checkNotNullParameter(list, "streams");
        this.ssrc = i;
        this.port = i2;
        this.ip = str;
        this.streams = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Payloads$Ready copy$default(Payloads$Ready payloads$Ready, int i, int i2, String str, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = payloads$Ready.ssrc;
        }
        if ((i3 & 2) != 0) {
            i2 = payloads$Ready.port;
        }
        if ((i3 & 4) != 0) {
            str = payloads$Ready.ip;
        }
        if ((i3 & 8) != 0) {
            list = payloads$Ready.streams;
        }
        return payloads$Ready.copy(i, i2, str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSsrc() {
        return this.ssrc;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIp() {
        return this.ip;
    }

    public final List<Payloads$Stream> component4() {
        return this.streams;
    }

    public final Payloads$Ready copy(int ssrc, int port, String ip, List<Payloads$Stream> streams) {
        m.checkNotNullParameter(ip, "ip");
        m.checkNotNullParameter(streams, "streams");
        return new Payloads$Ready(ssrc, port, ip, streams);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Payloads$Ready)) {
            return false;
        }
        Payloads$Ready payloads$Ready = (Payloads$Ready) other;
        return this.ssrc == payloads$Ready.ssrc && this.port == payloads$Ready.port && m.areEqual(this.ip, payloads$Ready.ip) && m.areEqual(this.streams, payloads$Ready.streams);
    }

    public final String getIp() {
        return this.ip;
    }

    public final int getPort() {
        return this.port;
    }

    public final int getSsrc() {
        return this.ssrc;
    }

    public final List<Payloads$Stream> getStreams() {
        return this.streams;
    }

    public int hashCode() {
        int i = ((this.ssrc * 31) + this.port) * 31;
        String str = this.ip;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<Payloads$Stream> list = this.streams;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Ready(ssrc=");
        sbU.append(this.ssrc);
        sbU.append(", port=");
        sbU.append(this.port);
        sbU.append(", ip=");
        sbU.append(this.ip);
        sbU.append(", streams=");
        return a.L(sbU, this.streams, ")");
    }
}
