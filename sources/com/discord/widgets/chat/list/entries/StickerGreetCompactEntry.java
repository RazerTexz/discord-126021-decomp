package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: StickerGreetCompactEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerGreetCompactEntry extends ChatListEntry {
    private final long channelId;
    private final String channelName;
    private final int channelType;
    private final String key;
    private final Sticker sticker;
    private final int type;

    public StickerGreetCompactEntry(Sticker sticker, long j, String str, int i) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(str, "channelName");
        this.sticker = sticker;
        this.channelId = j;
        this.channelName = str;
        this.channelType = i;
        this.type = 42;
        this.key = getType() + " -- " + sticker.getId();
    }

    public static /* synthetic */ StickerGreetCompactEntry copy$default(StickerGreetCompactEntry stickerGreetCompactEntry, Sticker sticker, long j, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sticker = stickerGreetCompactEntry.sticker;
        }
        if ((i2 & 2) != 0) {
            j = stickerGreetCompactEntry.channelId;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            str = stickerGreetCompactEntry.channelName;
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            i = stickerGreetCompactEntry.channelType;
        }
        return stickerGreetCompactEntry.copy(sticker, j2, str2, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Sticker getSticker() {
        return this.sticker;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getChannelType() {
        return this.channelType;
    }

    public final StickerGreetCompactEntry copy(Sticker sticker, long channelId, String channelName, int channelType) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(channelName, "channelName");
        return new StickerGreetCompactEntry(sticker, channelId, channelName, channelType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerGreetCompactEntry)) {
            return false;
        }
        StickerGreetCompactEntry stickerGreetCompactEntry = (StickerGreetCompactEntry) other;
        return Intrinsics3.areEqual(this.sticker, stickerGreetCompactEntry.sticker) && this.channelId == stickerGreetCompactEntry.channelId && Intrinsics3.areEqual(this.channelName, stickerGreetCompactEntry.channelName) && this.channelType == stickerGreetCompactEntry.channelType;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final int getChannelType() {
        return this.channelType;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Sticker getSticker() {
        return this.sticker;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Sticker sticker = this.sticker;
        int iA = (b.a(this.channelId) + ((sticker != null ? sticker.hashCode() : 0) * 31)) * 31;
        String str = this.channelName;
        return ((iA + (str != null ? str.hashCode() : 0)) * 31) + this.channelType;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StickerGreetCompactEntry(sticker=");
        sbU.append(this.sticker);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelName=");
        sbU.append(this.channelName);
        sbU.append(", channelType=");
        return outline.B(sbU, this.channelType, ")");
    }
}
