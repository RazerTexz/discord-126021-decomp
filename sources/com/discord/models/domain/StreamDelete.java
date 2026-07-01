package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StreamDelete {
    private final StreamDelete$Reason reason;
    private final String streamKey;
    private final boolean unavailable;

    public StreamDelete(String str, StreamDelete$Reason streamDelete$Reason, boolean z2) {
        m.checkNotNullParameter(str, "streamKey");
        m.checkNotNullParameter(streamDelete$Reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        this.streamKey = str;
        this.reason = streamDelete$Reason;
        this.unavailable = z2;
    }

    public static /* synthetic */ StreamDelete copy$default(StreamDelete streamDelete, String str, StreamDelete$Reason streamDelete$Reason, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = streamDelete.streamKey;
        }
        if ((i & 2) != 0) {
            streamDelete$Reason = streamDelete.reason;
        }
        if ((i & 4) != 0) {
            z2 = streamDelete.unavailable;
        }
        return streamDelete.copy(str, streamDelete$Reason, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStreamKey() {
        return this.streamKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StreamDelete$Reason getReason() {
        return this.reason;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getUnavailable() {
        return this.unavailable;
    }

    public final StreamDelete copy(String streamKey, StreamDelete$Reason reason, boolean unavailable) {
        m.checkNotNullParameter(streamKey, "streamKey");
        m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        return new StreamDelete(streamKey, reason, unavailable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamDelete)) {
            return false;
        }
        StreamDelete streamDelete = (StreamDelete) other;
        return m.areEqual(this.streamKey, streamDelete.streamKey) && m.areEqual(this.reason, streamDelete.reason) && this.unavailable == streamDelete.unavailable;
    }

    public final StreamDelete$Reason getReason() {
        return this.reason;
    }

    public final String getStreamKey() {
        return this.streamKey;
    }

    public final boolean getUnavailable() {
        return this.unavailable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.streamKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        StreamDelete$Reason streamDelete$Reason = this.reason;
        int iHashCode2 = (iHashCode + (streamDelete$Reason != null ? streamDelete$Reason.hashCode() : 0)) * 31;
        boolean z2 = this.unavailable;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("StreamDelete(streamKey=");
        sbU.append(this.streamKey);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", unavailable=");
        return a.O(sbU, this.unavailable, ")");
    }
}
