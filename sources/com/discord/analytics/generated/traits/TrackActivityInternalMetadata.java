package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.activityApplicationId, trackActivityInternalMetadata.activityApplicationId) && C12238m.areEqual(this.groupSessionId, trackActivityInternalMetadata.groupSessionId) && C12238m.areEqual(this.userSessionId, trackActivityInternalMetadata.userSessionId) && C12238m.areEqual(this.activityInstanceId, trackActivityInternalMetadata.activityInstanceId) && C12238m.areEqual(this.activityVersion, trackActivityInternalMetadata.activityVersion) && C12238m.areEqual(this.numConcurrentUsers, trackActivityInternalMetadata.numConcurrentUsers) && C12238m.areEqual(this.activityGuildId, trackActivityInternalMetadata.activityGuildId) && C12238m.areEqual(this.participationMode, trackActivityInternalMetadata.participationMode);
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
        StringBuilder sbM833U = C1643a.m833U("TrackActivityInternalMetadata(activityApplicationId=");
        sbM833U.append(this.activityApplicationId);
        sbM833U.append(", groupSessionId=");
        sbM833U.append(this.groupSessionId);
        sbM833U.append(", userSessionId=");
        sbM833U.append(this.userSessionId);
        sbM833U.append(", activityInstanceId=");
        sbM833U.append(this.activityInstanceId);
        sbM833U.append(", activityVersion=");
        sbM833U.append(this.activityVersion);
        sbM833U.append(", numConcurrentUsers=");
        sbM833U.append(this.numConcurrentUsers);
        sbM833U.append(", activityGuildId=");
        sbM833U.append(this.activityGuildId);
        sbM833U.append(", participationMode=");
        return C1643a.m817E(sbM833U, this.participationMode, ")");
    }
}
