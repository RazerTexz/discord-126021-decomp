package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: TimestampEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class TimestampEntry extends ChatListEntry {
    private final String key;
    private final long messageId;
    private final long timestamp;
    private final int type = 9;

    public TimestampEntry(long j, long j2) {
        this.messageId = j;
        this.timestamp = j2;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        this.key = sb.toString();
    }

    public static /* synthetic */ TimestampEntry copy$default(TimestampEntry timestampEntry, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = timestampEntry.messageId;
        }
        if ((i & 2) != 0) {
            j2 = timestampEntry.timestamp;
        }
        return timestampEntry.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final TimestampEntry copy(long messageId, long timestamp) {
        return new TimestampEntry(messageId, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimestampEntry)) {
            return false;
        }
        TimestampEntry timestampEntry = (TimestampEntry) other;
        return this.messageId == timestampEntry.messageId && this.timestamp == timestampEntry.timestamp;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return b.a(this.timestamp) + (b.a(this.messageId) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("TimestampEntry(messageId=");
        sbU.append(this.messageId);
        sbU.append(", timestamp=");
        return a.C(sbU, this.timestamp, ")");
    }
}
