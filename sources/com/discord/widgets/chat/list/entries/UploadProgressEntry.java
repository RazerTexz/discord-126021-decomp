package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: UploadProgressEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class UploadProgressEntry extends ChatListEntry {
    private final long channelId;
    private final String key;
    private final String messageNonce;
    private final int type;

    public UploadProgressEntry(String str, long j) {
        Intrinsics3.checkNotNullParameter(str, "messageNonce");
        this.messageNonce = str;
        this.channelId = j;
        this.type = 6;
        this.key = getType() + ' ' + str;
    }

    public static /* synthetic */ UploadProgressEntry copy$default(UploadProgressEntry uploadProgressEntry, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadProgressEntry.messageNonce;
        }
        if ((i & 2) != 0) {
            j = uploadProgressEntry.channelId;
        }
        return uploadProgressEntry.copy(str, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessageNonce() {
        return this.messageNonce;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final UploadProgressEntry copy(String messageNonce, long channelId) {
        Intrinsics3.checkNotNullParameter(messageNonce, "messageNonce");
        return new UploadProgressEntry(messageNonce, channelId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadProgressEntry)) {
            return false;
        }
        UploadProgressEntry uploadProgressEntry = (UploadProgressEntry) other;
        return Intrinsics3.areEqual(this.messageNonce, uploadProgressEntry.messageNonce) && this.channelId == uploadProgressEntry.channelId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getMessageNonce() {
        return this.messageNonce;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.messageNonce;
        return b.a(this.channelId) + ((str != null ? str.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("UploadProgressEntry(messageNonce=");
        sbU.append(this.messageNonce);
        sbU.append(", channelId=");
        return outline.C(sbU, this.channelId, ")");
    }
}
