package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.channelId, trackChannel.channelId) && C12238m.areEqual(this.channelType, trackChannel.channelType) && C12238m.areEqual(this.channelSizeTotal, trackChannel.channelSizeTotal) && C12238m.areEqual(this.channelSizeOnline, trackChannel.channelSizeOnline) && C12238m.areEqual(this.channelMemberPerms, trackChannel.channelMemberPerms) && C12238m.areEqual(this.channelHidden, trackChannel.channelHidden);
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
        StringBuilder sbM833U = C1643a.m833U("TrackChannel(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", channelSizeTotal=");
        sbM833U.append(this.channelSizeTotal);
        sbM833U.append(", channelSizeOnline=");
        sbM833U.append(this.channelSizeOnline);
        sbM833U.append(", channelMemberPerms=");
        sbM833U.append(this.channelMemberPerms);
        sbM833U.append(", channelHidden=");
        return C1643a.m816D(sbM833U, this.channelHidden, ")");
    }
}
