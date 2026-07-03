package com.discord.analytics.generated.traits;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackLfgGroup.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLfgGroup {
    private final CharSequence gameName = null;
    private final Long gameId = null;
    private final Long totalSize = null;
    private final Long freeSize = null;
    private final Long ownerId = null;
    private final CharSequence title = null;
    private final CharSequence description = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLfgGroup)) {
            return false;
        }
        TrackLfgGroup trackLfgGroup = (TrackLfgGroup) other;
        return C12238m.areEqual(this.gameName, trackLfgGroup.gameName) && C12238m.areEqual(this.gameId, trackLfgGroup.gameId) && C12238m.areEqual(this.totalSize, trackLfgGroup.totalSize) && C12238m.areEqual(this.freeSize, trackLfgGroup.freeSize) && C12238m.areEqual(this.ownerId, trackLfgGroup.ownerId) && C12238m.areEqual(this.title, trackLfgGroup.title) && C12238m.areEqual(this.description, trackLfgGroup.description);
    }

    public int hashCode() {
        CharSequence charSequence = this.gameName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.gameId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.totalSize;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.freeSize;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.ownerId;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.title;
        int iHashCode6 = (iHashCode5 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.description;
        return iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackLfgGroup(gameName=");
        sbM833U.append(this.gameName);
        sbM833U.append(", gameId=");
        sbM833U.append(this.gameId);
        sbM833U.append(", totalSize=");
        sbM833U.append(this.totalSize);
        sbM833U.append(", freeSize=");
        sbM833U.append(this.freeSize);
        sbM833U.append(", ownerId=");
        sbM833U.append(this.ownerId);
        sbM833U.append(", title=");
        sbM833U.append(this.title);
        sbM833U.append(", description=");
        return C1643a.m817E(sbM833U, this.description, ")");
    }
}
