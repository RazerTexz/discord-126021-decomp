package com.discord.widgets.chat.list.entries;

import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: compiled from: SpacerEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SpacerEntry extends ChatListEntry {
    private final long channelId;
    private final String key;
    private final int type = 7;

    public SpacerEntry(long j) {
        this.channelId = j;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        this.key = sb.toString();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final long getChannelId() {
        return this.channelId;
    }

    public static /* synthetic */ SpacerEntry copy$default(SpacerEntry spacerEntry, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = spacerEntry.channelId;
        }
        return spacerEntry.copy(j);
    }

    public final SpacerEntry copy(long channelId) {
        return new SpacerEntry(channelId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SpacerEntry) && this.channelId == ((SpacerEntry) other).channelId;
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return C0002b.m3a(this.channelId);
    }

    public String toString() {
        return C1643a.m815C(C1643a.m833U("SpacerEntry(channelId="), this.channelId, ")");
    }
}
