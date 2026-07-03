package com.discord.api.message.call;

import com.discord.api.utcdatetime.UtcDateTime;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MessageCall.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MessageCall {
    private final UtcDateTime endedTimestamp;
    private final List<Long> participants;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final UtcDateTime getEndedTimestamp() {
        return this.endedTimestamp;
    }

    /* JADX INFO: renamed from: b */
    public final List<Long> m8075b() {
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
        return C12238m.areEqual(this.participants, messageCall.participants) && C12238m.areEqual(this.endedTimestamp, messageCall.endedTimestamp);
    }

    public int hashCode() {
        List<Long> list = this.participants;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        UtcDateTime utcDateTime = this.endedTimestamp;
        return iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("MessageCall(participants=");
        sbM833U.append(this.participants);
        sbM833U.append(", endedTimestamp=");
        sbM833U.append(this.endedTimestamp);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
