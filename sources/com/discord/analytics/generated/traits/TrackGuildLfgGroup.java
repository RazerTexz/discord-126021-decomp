package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGuildLfgGroup.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildLfgGroup {
    private final Long lfgGroupChannelId = null;
    private final Long lfgGroupOwnerId = null;
    private final Long lfgDirectoryChannelId = null;
    private final Long lfgDirectoryGuildId = null;
    private final CharSequence lfgDirectoryGuildName = null;
    private final Long lfgGroupMaxSize = null;
    private final Long lfgGroupCurrentSize = null;
    private final CharSequence lfgGroupDescription = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildLfgGroup)) {
            return false;
        }
        TrackGuildLfgGroup trackGuildLfgGroup = (TrackGuildLfgGroup) other;
        return Intrinsics3.areEqual(this.lfgGroupChannelId, trackGuildLfgGroup.lfgGroupChannelId) && Intrinsics3.areEqual(this.lfgGroupOwnerId, trackGuildLfgGroup.lfgGroupOwnerId) && Intrinsics3.areEqual(this.lfgDirectoryChannelId, trackGuildLfgGroup.lfgDirectoryChannelId) && Intrinsics3.areEqual(this.lfgDirectoryGuildId, trackGuildLfgGroup.lfgDirectoryGuildId) && Intrinsics3.areEqual(this.lfgDirectoryGuildName, trackGuildLfgGroup.lfgDirectoryGuildName) && Intrinsics3.areEqual(this.lfgGroupMaxSize, trackGuildLfgGroup.lfgGroupMaxSize) && Intrinsics3.areEqual(this.lfgGroupCurrentSize, trackGuildLfgGroup.lfgGroupCurrentSize) && Intrinsics3.areEqual(this.lfgGroupDescription, trackGuildLfgGroup.lfgGroupDescription);
    }

    public int hashCode() {
        Long l = this.lfgGroupChannelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.lfgGroupOwnerId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.lfgDirectoryChannelId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.lfgDirectoryGuildId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence = this.lfgDirectoryGuildName;
        int iHashCode5 = (iHashCode4 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l5 = this.lfgGroupMaxSize;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.lfgGroupCurrentSize;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.lfgGroupDescription;
        return iHashCode7 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildLfgGroup(lfgGroupChannelId=");
        sbU.append(this.lfgGroupChannelId);
        sbU.append(", lfgGroupOwnerId=");
        sbU.append(this.lfgGroupOwnerId);
        sbU.append(", lfgDirectoryChannelId=");
        sbU.append(this.lfgDirectoryChannelId);
        sbU.append(", lfgDirectoryGuildId=");
        sbU.append(this.lfgDirectoryGuildId);
        sbU.append(", lfgDirectoryGuildName=");
        sbU.append(this.lfgDirectoryGuildName);
        sbU.append(", lfgGroupMaxSize=");
        sbU.append(this.lfgGroupMaxSize);
        sbU.append(", lfgGroupCurrentSize=");
        sbU.append(this.lfgGroupCurrentSize);
        sbU.append(", lfgGroupDescription=");
        return outline.E(sbU, this.lfgGroupDescription, ")");
    }
}
