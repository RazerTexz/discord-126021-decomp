package com.discord.p000native.engine;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ConnectionInfo.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ConnectionInfo {
    private final boolean isConnected;
    private final String localAddress;
    private final int localPort;
    private final String protocol;

    public ConnectionInfo(boolean z2, String str, String str2, int i) {
        Intrinsics3.checkNotNullParameter(str, "protocol");
        Intrinsics3.checkNotNullParameter(str2, "localAddress");
        this.isConnected = z2;
        this.protocol = str;
        this.localAddress = str2;
        this.localPort = i;
    }

    public static /* synthetic */ ConnectionInfo copy$default(ConnectionInfo connectionInfo, boolean z2, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = connectionInfo.isConnected;
        }
        if ((i2 & 2) != 0) {
            str = connectionInfo.protocol;
        }
        if ((i2 & 4) != 0) {
            str2 = connectionInfo.localAddress;
        }
        if ((i2 & 8) != 0) {
            i = connectionInfo.localPort;
        }
        return connectionInfo.copy(z2, str, str2, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsConnected() {
        return this.isConnected;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProtocol() {
        return this.protocol;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLocalAddress() {
        return this.localAddress;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getLocalPort() {
        return this.localPort;
    }

    public final ConnectionInfo copy(boolean isConnected, String protocol, String localAddress, int localPort) {
        Intrinsics3.checkNotNullParameter(protocol, "protocol");
        Intrinsics3.checkNotNullParameter(localAddress, "localAddress");
        return new ConnectionInfo(isConnected, protocol, localAddress, localPort);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectionInfo)) {
            return false;
        }
        ConnectionInfo connectionInfo = (ConnectionInfo) other;
        return this.isConnected == connectionInfo.isConnected && Intrinsics3.areEqual(this.protocol, connectionInfo.protocol) && Intrinsics3.areEqual(this.localAddress, connectionInfo.localAddress) && this.localPort == connectionInfo.localPort;
    }

    public final String getLocalAddress() {
        return this.localAddress;
    }

    public final int getLocalPort() {
        return this.localPort;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z2 = this.isConnected;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.protocol;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.localAddress;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.localPort;
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ConnectionInfo(isConnected=");
        sbU.append(this.isConnected);
        sbU.append(", protocol=");
        sbU.append(this.protocol);
        sbU.append(", localAddress=");
        sbU.append(this.localAddress);
        sbU.append(", localPort=");
        return outline.B(sbU, this.localPort, ")");
    }
}
