package com.discord.widgets.chat.input.sticker;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerAdapterItems.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HeaderItem implements MGRecyclerDataPayload {
    private final HeaderType headerType;
    private final String key;
    private final int type;

    public HeaderItem(HeaderType headerType) {
        C12238m.checkNotNullParameter(headerType, "headerType");
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
        C12238m.checkNotNullParameter(headerType, "headerType");
        return new HeaderItem(headerType);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HeaderItem) && C12238m.areEqual(this.headerType, ((HeaderItem) other).headerType);
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
        StringBuilder sbM833U = C1643a.m833U("HeaderItem(headerType=");
        sbM833U.append(this.headerType);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
