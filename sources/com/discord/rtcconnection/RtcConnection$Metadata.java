package com.discord.rtcconnection;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RtcConnection$Metadata {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final String rtcConnectionId;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String mediaSessionId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Long channelId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Long guildId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final String streamKey;

    public RtcConnection$Metadata(String str, String str2, Long l, Long l2, String str3) {
        m.checkNotNullParameter(str, "rtcConnectionId");
        this.rtcConnectionId = str;
        this.mediaSessionId = str2;
        this.channelId = l;
        this.guildId = l2;
        this.streamKey = str3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RtcConnection$Metadata)) {
            return false;
        }
        RtcConnection$Metadata rtcConnection$Metadata = (RtcConnection$Metadata) other;
        return m.areEqual(this.rtcConnectionId, rtcConnection$Metadata.rtcConnectionId) && m.areEqual(this.mediaSessionId, rtcConnection$Metadata.mediaSessionId) && m.areEqual(this.channelId, rtcConnection$Metadata.channelId) && m.areEqual(this.guildId, rtcConnection$Metadata.guildId) && m.areEqual(this.streamKey, rtcConnection$Metadata.streamKey);
    }

    public int hashCode() {
        String str = this.rtcConnectionId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mediaSessionId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.channelId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.guildId;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str3 = this.streamKey;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Metadata(rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", streamKey=");
        return a.J(sbU, this.streamKey, ")");
    }
}
