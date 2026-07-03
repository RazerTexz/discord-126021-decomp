package com.discord.widgets.chat.list.entries;

import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(str, "giftCode");
        this.userId = j;
        this.messageId = j2;
        this.channelId = j3;
        this.giftCode = str;
        this.type = 26;
        this.key = "26 -- " + j2 + " -- " + str;
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
        C12238m.checkNotNullParameter(giftCode, "giftCode");
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
        return this.userId == giftEntry.userId && this.messageId == giftEntry.messageId && this.channelId == giftEntry.channelId && C12238m.areEqual(this.giftCode, giftEntry.giftCode);
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
        int iM3a = (C0002b.m3a(this.channelId) + ((C0002b.m3a(this.messageId) + (C0002b.m3a(this.userId) * 31)) * 31)) * 31;
        String str = this.giftCode;
        return iM3a + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GiftEntry(userId=");
        sbM833U.append(this.userId);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", giftCode=");
        return C1643a.m822J(sbM833U, this.giftCode, ")");
    }
}
