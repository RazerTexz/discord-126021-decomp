package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackChannel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChannel {
    private final Boolean channelHidden;
    private final Long channelId;
    private final Long channelMemberPerms;
    private final Long channelSizeOnline;
    private final Long channelSizeTotal;
    private final Long channelType;

    public TrackChannel() {
        this(null, null, null, null, null, null, 63);
    }

    public TrackChannel(Long l, Long l2, Long l3, Long l4, Long l5, Boolean bool, int i) {
        int i2 = i & 2;
        int i3 = i & 4;
        int i4 = i & 8;
        int i5 = i & 16;
        int i6 = i & 32;
        this.channelId = (i & 1) != 0 ? null : l;
        this.channelType = null;
        this.channelSizeTotal = null;
        this.channelSizeOnline = null;
        this.channelMemberPerms = null;
        this.channelHidden = null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackChannel)) {
            return false;
        }
        TrackChannel trackChannel = (TrackChannel) other;
        return m.areEqual(this.channelId, trackChannel.channelId) && m.areEqual(this.channelType, trackChannel.channelType) && m.areEqual(this.channelSizeTotal, trackChannel.channelSizeTotal) && m.areEqual(this.channelSizeOnline, trackChannel.channelSizeOnline) && m.areEqual(this.channelMemberPerms, trackChannel.channelMemberPerms) && m.areEqual(this.channelHidden, trackChannel.channelHidden);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelSizeTotal;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.channelSizeOnline;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.channelMemberPerms;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool = this.channelHidden;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackChannel(channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", channelSizeTotal=");
        sbU.append(this.channelSizeTotal);
        sbU.append(", channelSizeOnline=");
        sbU.append(this.channelSizeOnline);
        sbU.append(", channelMemberPerms=");
        sbU.append(this.channelMemberPerms);
        sbU.append(", channelHidden=");
        return a.D(sbU, this.channelHidden, ")");
    }
}
