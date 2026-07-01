package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

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
        return Intrinsics3.areEqual(this.channelId, trackChannel.channelId) && Intrinsics3.areEqual(this.channelType, trackChannel.channelType) && Intrinsics3.areEqual(this.channelSizeTotal, trackChannel.channelSizeTotal) && Intrinsics3.areEqual(this.channelSizeOnline, trackChannel.channelSizeOnline) && Intrinsics3.areEqual(this.channelMemberPerms, trackChannel.channelMemberPerms) && Intrinsics3.areEqual(this.channelHidden, trackChannel.channelHidden);
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
        StringBuilder sbU = outline.U("TrackChannel(channelId=");
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
        return outline.D(sbU, this.channelHidden, ")");
    }
}
