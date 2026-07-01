package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackActivityInternalMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalMetadata {
    private final Long activityApplicationId = null;
    private final CharSequence groupSessionId = null;
    private final CharSequence userSessionId = null;
    private final CharSequence activityInstanceId = null;
    private final CharSequence activityVersion = null;
    private final Long numConcurrentUsers = null;
    private final Long activityGuildId = null;
    private final CharSequence participationMode = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalMetadata)) {
            return false;
        }
        TrackActivityInternalMetadata trackActivityInternalMetadata = (TrackActivityInternalMetadata) other;
        return Intrinsics3.areEqual(this.activityApplicationId, trackActivityInternalMetadata.activityApplicationId) && Intrinsics3.areEqual(this.groupSessionId, trackActivityInternalMetadata.groupSessionId) && Intrinsics3.areEqual(this.userSessionId, trackActivityInternalMetadata.userSessionId) && Intrinsics3.areEqual(this.activityInstanceId, trackActivityInternalMetadata.activityInstanceId) && Intrinsics3.areEqual(this.activityVersion, trackActivityInternalMetadata.activityVersion) && Intrinsics3.areEqual(this.numConcurrentUsers, trackActivityInternalMetadata.numConcurrentUsers) && Intrinsics3.areEqual(this.activityGuildId, trackActivityInternalMetadata.activityGuildId) && Intrinsics3.areEqual(this.participationMode, trackActivityInternalMetadata.participationMode);
    }

    public int hashCode() {
        Long l = this.activityApplicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.groupSessionId;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.userSessionId;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.activityInstanceId;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.activityVersion;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l2 = this.numConcurrentUsers;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.activityGuildId;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.participationMode;
        return iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalMetadata(activityApplicationId=");
        sbU.append(this.activityApplicationId);
        sbU.append(", groupSessionId=");
        sbU.append(this.groupSessionId);
        sbU.append(", userSessionId=");
        sbU.append(this.userSessionId);
        sbU.append(", activityInstanceId=");
        sbU.append(this.activityInstanceId);
        sbU.append(", activityVersion=");
        sbU.append(this.activityVersion);
        sbU.append(", numConcurrentUsers=");
        sbU.append(this.numConcurrentUsers);
        sbU.append(", activityGuildId=");
        sbU.append(this.activityGuildId);
        sbU.append(", participationMode=");
        return outline.E(sbU, this.participationMode, ")");
    }
}
