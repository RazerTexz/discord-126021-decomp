package com.discord.widgets.chat.list.entries;

import com.discord.api.sticker.BaseSticker;
import com.discord.models.message.Message;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerEntry extends ChatListEntry {
    private final String key;
    private final Message message;
    private final BaseSticker sticker;
    private final int type;

    public StickerEntry(Message message, BaseSticker baseSticker) {
        C12238m.checkNotNullParameter(message, "message");
        C12238m.checkNotNullParameter(baseSticker, "sticker");
        this.message = message;
        this.sticker = baseSticker;
        this.type = 31;
        this.key = getType() + " -- " + message.getId() + " -- " + baseSticker.getId();
    }

    public static /* synthetic */ StickerEntry copy$default(StickerEntry stickerEntry, Message message, BaseSticker baseSticker, int i, Object obj) {
        if ((i & 1) != 0) {
            message = stickerEntry.message;
        }
        if ((i & 2) != 0) {
            baseSticker = stickerEntry.sticker;
        }
        return stickerEntry.copy(message, baseSticker);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final BaseSticker getSticker() {
        return this.sticker;
    }

    public final StickerEntry copy(Message message, BaseSticker sticker) {
        C12238m.checkNotNullParameter(message, "message");
        C12238m.checkNotNullParameter(sticker, "sticker");
        return new StickerEntry(message, sticker);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerEntry)) {
            return false;
        }
        StickerEntry stickerEntry = (StickerEntry) other;
        return C12238m.areEqual(this.message, stickerEntry.message) && C12238m.areEqual(this.sticker, stickerEntry.sticker);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final BaseSticker getSticker() {
        return this.sticker;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Message message = this.message;
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        BaseSticker baseSticker = this.sticker;
        return iHashCode + (baseSticker != null ? baseSticker.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("StickerEntry(message=");
        sbM833U.append(this.message);
        sbM833U.append(", sticker=");
        sbM833U.append(this.sticker);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
