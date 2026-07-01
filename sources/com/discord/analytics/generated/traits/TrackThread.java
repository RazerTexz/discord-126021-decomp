package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

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
        return Intrinsics3.areEqual(this.threadApproximateMemberCount, trackThread.threadApproximateMemberCount) && Intrinsics3.areEqual(this.threadApproximateMessageCount, trackThread.threadApproximateMessageCount) && Intrinsics3.areEqual(this.threadArchived, trackThread.threadArchived) && Intrinsics3.areEqual(this.threadLocked, trackThread.threadLocked) && Intrinsics3.areEqual(this.threadAutoArchiveDurationMinutes, trackThread.threadAutoArchiveDurationMinutes) && Intrinsics3.areEqual(this.threadApproximateCreationDate, trackThread.threadApproximateCreationDate);
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
        StringBuilder sbU = outline.U("TrackThread(threadApproximateMemberCount=");
        sbU.append(this.threadApproximateMemberCount);
        sbU.append(", threadApproximateMessageCount=");
        sbU.append(this.threadApproximateMessageCount);
        sbU.append(", threadArchived=");
        sbU.append(this.threadArchived);
        sbU.append(", threadLocked=");
        sbU.append(this.threadLocked);
        sbU.append(", threadAutoArchiveDurationMinutes=");
        sbU.append(this.threadAutoArchiveDurationMinutes);
        sbU.append(", threadApproximateCreationDate=");
        return outline.G(sbU, this.threadApproximateCreationDate, ")");
    }
}
