package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackThread.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackThread {
    private final Long threadApproximateMemberCount = null;
    private final Long threadApproximateMessageCount = null;
    private final Boolean threadArchived = null;
    private final Boolean threadLocked = null;
    private final Long threadAutoArchiveDurationMinutes = null;
    private final Long threadApproximateCreationDate = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackThread)) {
            return false;
        }
        TrackThread trackThread = (TrackThread) other;
        return C12238m.areEqual(this.threadApproximateMemberCount, trackThread.threadApproximateMemberCount) && C12238m.areEqual(this.threadApproximateMessageCount, trackThread.threadApproximateMessageCount) && C12238m.areEqual(this.threadArchived, trackThread.threadArchived) && C12238m.areEqual(this.threadLocked, trackThread.threadLocked) && C12238m.areEqual(this.threadAutoArchiveDurationMinutes, trackThread.threadAutoArchiveDurationMinutes) && C12238m.areEqual(this.threadApproximateCreationDate, trackThread.threadApproximateCreationDate);
    }

    public int hashCode() {
        Long l = this.threadApproximateMemberCount;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.threadApproximateMessageCount;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.threadArchived;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.threadLocked;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l3 = this.threadAutoArchiveDurationMinutes;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.threadApproximateCreationDate;
        return iHashCode5 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackThread(threadApproximateMemberCount=");
        sbM833U.append(this.threadApproximateMemberCount);
        sbM833U.append(", threadApproximateMessageCount=");
        sbM833U.append(this.threadApproximateMessageCount);
        sbM833U.append(", threadArchived=");
        sbM833U.append(this.threadArchived);
        sbM833U.append(", threadLocked=");
        sbM833U.append(this.threadLocked);
        sbM833U.append(", threadAutoArchiveDurationMinutes=");
        sbM833U.append(this.threadAutoArchiveDurationMinutes);
        sbM833U.append(", threadApproximateCreationDate=");
        return C1643a.m819G(sbM833U, this.threadApproximateCreationDate, ")");
    }
}
