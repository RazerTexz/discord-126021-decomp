package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.lfgGroupChannelId, trackGuildLfgGroup.lfgGroupChannelId) && C12238m.areEqual(this.lfgGroupOwnerId, trackGuildLfgGroup.lfgGroupOwnerId) && C12238m.areEqual(this.lfgDirectoryChannelId, trackGuildLfgGroup.lfgDirectoryChannelId) && C12238m.areEqual(this.lfgDirectoryGuildId, trackGuildLfgGroup.lfgDirectoryGuildId) && C12238m.areEqual(this.lfgDirectoryGuildName, trackGuildLfgGroup.lfgDirectoryGuildName) && C12238m.areEqual(this.lfgGroupMaxSize, trackGuildLfgGroup.lfgGroupMaxSize) && C12238m.areEqual(this.lfgGroupCurrentSize, trackGuildLfgGroup.lfgGroupCurrentSize) && C12238m.areEqual(this.lfgGroupDescription, trackGuildLfgGroup.lfgGroupDescription);
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
        StringBuilder sbM833U = C1643a.m833U("TrackGuildLfgGroup(lfgGroupChannelId=");
        sbM833U.append(this.lfgGroupChannelId);
        sbM833U.append(", lfgGroupOwnerId=");
        sbM833U.append(this.lfgGroupOwnerId);
        sbM833U.append(", lfgDirectoryChannelId=");
        sbM833U.append(this.lfgDirectoryChannelId);
        sbM833U.append(", lfgDirectoryGuildId=");
        sbM833U.append(this.lfgDirectoryGuildId);
        sbM833U.append(", lfgDirectoryGuildName=");
        sbM833U.append(this.lfgDirectoryGuildName);
        sbM833U.append(", lfgGroupMaxSize=");
        sbM833U.append(this.lfgGroupMaxSize);
        sbM833U.append(", lfgGroupCurrentSize=");
        sbM833U.append(this.lfgGroupCurrentSize);
        sbM833U.append(", lfgGroupDescription=");
        return C1643a.m817E(sbM833U, this.lfgGroupDescription, ")");
    }
}
