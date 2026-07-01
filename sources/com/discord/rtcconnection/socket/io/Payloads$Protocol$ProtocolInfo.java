package com.discord.rtcconnection.socket.io;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$Protocol$ProtocolInfo {
    private final String address;
    private final String mode;
    private final int port;

    public Payloads$Protocol$ProtocolInfo(String str, int i, String str2) {
        m.checkNotNullParameter(str, "address");
        m.checkNotNullParameter(str2, "mode");
        this.address = str;
        this.port = i;
        this.mode = str2;
    }

    public static /* synthetic */ Payloads$Protocol$ProtocolInfo copy$default(Payloads$Protocol$ProtocolInfo payloads$Protocol$ProtocolInfo, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = payloads$Protocol$ProtocolInfo.address;
        }
        if ((i2 & 2) != 0) {
            i = payloads$Protocol$ProtocolInfo.port;
        }
        if ((i2 & 4) != 0) {
            str2 = payloads$Protocol$ProtocolInfo.mode;
        }
        return payloads$Protocol$ProtocolInfo.copy(str, i, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    public final Payloads$Protocol$ProtocolInfo copy(String address, int port, String mode) {
        m.checkNotNullParameter(address, "address");
        m.checkNotNullParameter(mode, "mode");
        return new Payloads$Protocol$ProtocolInfo(address, port, mode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Payloads$Protocol$ProtocolInfo)) {
            return false;
        }
        Payloads$Protocol$ProtocolInfo payloads$Protocol$ProtocolInfo = (Payloads$Protocol$ProtocolInfo) other;
        return m.areEqual(this.address, payloads$Protocol$ProtocolInfo.address) && this.port == payloads$Protocol$ProtocolInfo.port && m.areEqual(this.mode, payloads$Protocol$ProtocolInfo.mode);
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getMode() {
        return this.mode;
    }

    public final int getPort() {
        return this.port;
    }

    public int hashCode() {
        String str = this.address;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.port) * 31;
        String str2 = this.mode;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ProtocolInfo(address=");
        sbU.append(this.address);
        sbU.append(", port=");
        sbU.append(this.port);
        sbU.append(", mode=");
        return a.J(sbU, this.mode, ")");
    }
}
