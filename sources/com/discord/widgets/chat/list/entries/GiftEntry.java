package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: GiftEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GiftEntry extends ChatListEntry {
    private final long channelId;
    private final String giftCode;
    private final String key;
    private final long messageId;
    private final int type;
    private final long userId;

    public GiftEntry(long j, long j2, long j3, String str) {
        m.checkNotNullParameter(str, "giftCode");
        this.userId = j;
        this.messageId = j2;
        this.channelId = j3;
        this.giftCode = str;
        this.type = 26;
        this.key = "26 -- " + j2 + " -- " + str;
    }

    public static /* synthetic */ GiftEntry copy$default(GiftEntry giftEntry, long j, long j2, long j3, String str, int i, Object obj) {
        return giftEntry.copy((i & 1) != 0 ? giftEntry.userId : j, (i & 2) != 0 ? giftEntry.messageId : j2, (i & 4) != 0 ? giftEntry.channelId : j3, (i & 8) != 0 ? giftEntry.giftCode : str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getGiftCode() {
        return this.giftCode;
    }

    public final GiftEntry copy(long userId, long messageId, long channelId, String giftCode) {
        m.checkNotNullParameter(giftCode, "giftCode");
        return new GiftEntry(userId, messageId, channelId, giftCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftEntry)) {
            return false;
        }
        GiftEntry giftEntry = (GiftEntry) other;
        return this.userId == giftEntry.userId && this.messageId == giftEntry.messageId && this.channelId == giftEntry.channelId && m.areEqual(this.giftCode, giftEntry.giftCode);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getGiftCode() {
        return this.giftCode;
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

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iA = (b.a(this.channelId) + ((b.a(this.messageId) + (b.a(this.userId) * 31)) * 31)) * 31;
        String str = this.giftCode;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GiftEntry(userId=");
        sbU.append(this.userId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", giftCode=");
        return a.J(sbU, this.giftCode, ")");
    }
}
