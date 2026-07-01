package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: NewMessagesEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class NewMessagesEntry extends ChatListEntry {
    private final long channelId;
    private final String key;
    private final long messageId;
    private final int type = 8;

    public NewMessagesEntry(long j, long j2) {
        this.channelId = j;
        this.messageId = j2;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        this.key = sb.toString();
    }

    public static /* synthetic */ NewMessagesEntry copy$default(NewMessagesEntry newMessagesEntry, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = newMessagesEntry.channelId;
        }
        if ((i & 2) != 0) {
            j2 = newMessagesEntry.messageId;
        }
        return newMessagesEntry.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    public final NewMessagesEntry copy(long channelId, long messageId) {
        return new NewMessagesEntry(channelId, messageId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewMessagesEntry)) {
            return false;
        }
        NewMessagesEntry newMessagesEntry = (NewMessagesEntry) other;
        return this.channelId == newMessagesEntry.channelId && this.messageId == newMessagesEntry.messageId;
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
        return b.a(this.messageId) + (b.a(this.channelId) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("NewMessagesEntry(channelId=");
        sbU.append(this.channelId);
        sbU.append(", messageId=");
        return a.C(sbU, this.messageId, ")");
    }
}
