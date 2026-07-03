package com.discord.widgets.chat.list.entries;

import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: compiled from: ThreadStarterDividerEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ThreadStarterDividerEntry extends ChatListEntry {
    private final long channelId;
    private final String key;
    private final long messageId;
    private final int type = 40;

    public ThreadStarterDividerEntry(long j, long j2) {
        this.channelId = j;
        this.messageId = j2;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        this.key = sb.toString();
    }

    public static /* synthetic */ ThreadStarterDividerEntry copy$default(ThreadStarterDividerEntry threadStarterDividerEntry, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = threadStarterDividerEntry.channelId;
        }
        if ((i & 2) != 0) {
            j2 = threadStarterDividerEntry.messageId;
        }
        return threadStarterDividerEntry.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    public final ThreadStarterDividerEntry copy(long channelId, long messageId) {
        return new ThreadStarterDividerEntry(channelId, messageId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadStarterDividerEntry)) {
            return false;
        }
        ThreadStarterDividerEntry threadStarterDividerEntry = (ThreadStarterDividerEntry) other;
        return this.channelId == threadStarterDividerEntry.channelId && this.messageId == threadStarterDividerEntry.messageId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return C0002b.m3a(this.messageId) + (C0002b.m3a(this.channelId) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ThreadStarterDividerEntry(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", messageId=");
        return C1643a.m815C(sbM833U, this.messageId, ")");
    }
}
