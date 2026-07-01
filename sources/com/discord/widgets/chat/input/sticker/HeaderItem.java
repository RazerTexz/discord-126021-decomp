package com.discord.widgets.chat.input.sticker;

import b.d.b.a.a;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: StickerAdapterItems.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HeaderItem implements MGRecyclerDataPayload {
    private final HeaderType headerType;
    private final String key;
    private final int type;

    public HeaderItem(HeaderType headerType) {
        m.checkNotNullParameter(headerType, "headerType");
        this.headerType = headerType;
        this.key = headerType.getId();
    }

    public static /* synthetic */ HeaderItem copy$default(HeaderItem headerItem, HeaderType headerType, int i, Object obj) {
        if ((i & 1) != 0) {
            headerType = headerItem.headerType;
        }
        return headerItem.copy(headerType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HeaderType getHeaderType() {
        return this.headerType;
    }

    public final HeaderItem copy(HeaderType headerType) {
        m.checkNotNullParameter(headerType, "headerType");
        return new HeaderItem(headerType);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HeaderItem) && m.areEqual(this.headerType, ((HeaderItem) other).headerType);
        }
        return true;
    }

    public final HeaderType getHeaderType() {
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
        HeaderType headerType = this.headerType;
        if (headerType != null) {
            return headerType.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("HeaderItem(headerType=");
        sbU.append(this.headerType);
        sbU.append(")");
        return sbU.toString();
    }
}
