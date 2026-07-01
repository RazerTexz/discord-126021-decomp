package com.discord.api.message.call;

import b.d.b.a.outline;
import com.discord.api.utcdatetime.UtcDateTime;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: MessageCall.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MessageCall {
    private final UtcDateTime endedTimestamp;
    private final List<Long> participants;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final UtcDateTime getEndedTimestamp() {
        return this.endedTimestamp;
    }

    public final List<Long> b() {
        return this.participants;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageCall)) {
            return false;
        }
        MessageCall messageCall = (MessageCall) other;
        return Intrinsics3.areEqual(this.participants, messageCall.participants) && Intrinsics3.areEqual(this.endedTimestamp, messageCall.endedTimestamp);
    }

    public int hashCode() {
        List<Long> list = this.participants;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        UtcDateTime utcDateTime = this.endedTimestamp;
        return iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageCall(participants=");
        sbU.append(this.participants);
        sbU.append(", endedTimestamp=");
        sbU.append(this.endedTimestamp);
        sbU.append(")");
        return sbU.toString();
    }
}
