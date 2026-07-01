package com.discord.rtcconnection.mediaengine;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: MediaEngineConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MediaEngineConnection$TransportInfo {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final String address;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int port;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final MediaEngineConnection$TransportInfo$Protocol protocol;

    public MediaEngineConnection$TransportInfo(String str, int i, MediaEngineConnection$TransportInfo$Protocol mediaEngineConnection$TransportInfo$Protocol) {
        m.checkNotNullParameter(str, "address");
        m.checkNotNullParameter(mediaEngineConnection$TransportInfo$Protocol, "protocol");
        this.address = str;
        this.port = i;
        this.protocol = mediaEngineConnection$TransportInfo$Protocol;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaEngineConnection$TransportInfo)) {
            return false;
        }
        MediaEngineConnection$TransportInfo mediaEngineConnection$TransportInfo = (MediaEngineConnection$TransportInfo) other;
        return m.areEqual(this.address, mediaEngineConnection$TransportInfo.address) && this.port == mediaEngineConnection$TransportInfo.port && m.areEqual(this.protocol, mediaEngineConnection$TransportInfo.protocol);
    }

    public int hashCode() {
        String str = this.address;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.port) * 31;
        MediaEngineConnection$TransportInfo$Protocol mediaEngineConnection$TransportInfo$Protocol = this.protocol;
        return iHashCode + (mediaEngineConnection$TransportInfo$Protocol != null ? mediaEngineConnection$TransportInfo$Protocol.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TransportInfo(address=");
        sbU.append(this.address);
        sbU.append(", port=");
        sbU.append(this.port);
        sbU.append(", protocol=");
        sbU.append(this.protocol);
        sbU.append(")");
        return sbU.toString();
    }
}
