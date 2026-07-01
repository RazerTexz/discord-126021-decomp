package com.discord.widgets.chat.input.sticker;

import b.d.b.a.outline;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.HeaderItem, reason: use source file name */
/* JADX INFO: compiled from: StickerAdapterItems.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerAdapterItems implements MGRecyclerDataPayload {
    private final StickerAdapterItems2 headerType;
    private final String key;
    private final int type;

    public StickerAdapterItems(StickerAdapterItems2 stickerAdapterItems2) {
        Intrinsics3.checkNotNullParameter(stickerAdapterItems2, "headerType");
        this.headerType = stickerAdapterItems2;
        this.key = stickerAdapterItems2.getId();
    }

    public static /* synthetic */ StickerAdapterItems copy$default(StickerAdapterItems stickerAdapterItems, StickerAdapterItems2 stickerAdapterItems2, int i, Object obj) {
        if ((i & 1) != 0) {
            stickerAdapterItems2 = stickerAdapterItems.headerType;
        }
        return stickerAdapterItems.copy(stickerAdapterItems2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StickerAdapterItems2 getHeaderType() {
        return this.headerType;
    }

    public final StickerAdapterItems copy(StickerAdapterItems2 headerType) {
        Intrinsics3.checkNotNullParameter(headerType, "headerType");
        return new StickerAdapterItems(headerType);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StickerAdapterItems) && Intrinsics3.areEqual(this.headerType, ((StickerAdapterItems) other).headerType);
        }
        return true;
    }

    public final StickerAdapterItems2 getHeaderType() {
        return this.headerType;
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
        StickerAdapterItems2 stickerAdapterItems2 = this.headerType;
        if (stickerAdapterItems2 != null) {
            return stickerAdapterItems2.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("HeaderItem(headerType=");
        sbU.append(this.headerType);
        sbU.append(")");
        return sbU.toString();
    }
}
