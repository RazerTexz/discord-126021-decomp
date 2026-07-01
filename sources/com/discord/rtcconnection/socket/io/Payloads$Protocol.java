package com.discord.rtcconnection.socket.io;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$Protocol {
    private final List<Payloads$Protocol$CodecInfo> codecs;
    private final Payloads$Protocol$ProtocolInfo data;
    private final String protocol;

    public Payloads$Protocol(String str, Payloads$Protocol$ProtocolInfo payloads$Protocol$ProtocolInfo, List<Payloads$Protocol$CodecInfo> list) {
        m.checkNotNullParameter(str, "protocol");
        m.checkNotNullParameter(payloads$Protocol$ProtocolInfo, "data");
        this.protocol = str;
        this.data = payloads$Protocol$ProtocolInfo;
        this.codecs = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Payloads$Protocol copy$default(Payloads$Protocol payloads$Protocol, String str, Payloads$Protocol$ProtocolInfo payloads$Protocol$ProtocolInfo, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payloads$Protocol.protocol;
        }
        if ((i & 2) != 0) {
            payloads$Protocol$ProtocolInfo = payloads$Protocol.data;
        }
        if ((i & 4) != 0) {
            list = payloads$Protocol.codecs;
        }
        return payloads$Protocol.copy(str, payloads$Protocol$ProtocolInfo, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProtocol() {
        return this.protocol;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Payloads$Protocol$ProtocolInfo getData() {
        return this.data;
    }

    public final List<Payloads$Protocol$CodecInfo> component3() {
        return this.codecs;
    }

    public final Payloads$Protocol copy(String protocol, Payloads$Protocol$ProtocolInfo data, List<Payloads$Protocol$CodecInfo> codecs) {
        m.checkNotNullParameter(protocol, "protocol");
        m.checkNotNullParameter(data, "data");
        return new Payloads$Protocol(protocol, data, codecs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Payloads$Protocol)) {
            return false;
        }
        Payloads$Protocol payloads$Protocol = (Payloads$Protocol) other;
        return m.areEqual(this.protocol, payloads$Protocol.protocol) && m.areEqual(this.data, payloads$Protocol.data) && m.areEqual(this.codecs, payloads$Protocol.codecs);
    }

    public final List<Payloads$Protocol$CodecInfo> getCodecs() {
        return this.codecs;
    }

    public final Payloads$Protocol$ProtocolInfo getData() {
        return this.data;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public int hashCode() {
        String str = this.protocol;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Payloads$Protocol$ProtocolInfo payloads$Protocol$ProtocolInfo = this.data;
        int iHashCode2 = (iHashCode + (payloads$Protocol$ProtocolInfo != null ? payloads$Protocol$ProtocolInfo.hashCode() : 0)) * 31;
        List<Payloads$Protocol$CodecInfo> list = this.codecs;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Protocol(protocol=");
        sbU.append(this.protocol);
        sbU.append(", data=");
        sbU.append(this.data);
        sbU.append(", codecs=");
        return a.L(sbU, this.codecs, ")");
    }
}
