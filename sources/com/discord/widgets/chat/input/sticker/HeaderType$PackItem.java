package com.discord.widgets.chat.input.sticker;

import b.d.b.a.a;
import com.discord.models.sticker.dto.ModelStickerPack;
import d0.z.d.m;

/* JADX INFO: compiled from: StickerAdapterItems.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HeaderType$PackItem extends HeaderType {
    private final ModelStickerPack pack;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderType$PackItem(ModelStickerPack modelStickerPack) {
        super(null);
        m.checkNotNullParameter(modelStickerPack, "pack");
        this.pack = modelStickerPack;
    }

    public static /* synthetic */ HeaderType$PackItem copy$default(HeaderType$PackItem headerType$PackItem, ModelStickerPack modelStickerPack, int i, Object obj) {
        if ((i & 1) != 0) {
            modelStickerPack = headerType$PackItem.pack;
        }
        return headerType$PackItem.copy(modelStickerPack);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelStickerPack getPack() {
        return this.pack;
    }

    public final HeaderType$PackItem copy(ModelStickerPack pack) {
        m.checkNotNullParameter(pack, "pack");
        return new HeaderType$PackItem(pack);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HeaderType$PackItem) && m.areEqual(this.pack, ((HeaderType$PackItem) other).pack);
        }
        return true;
    }

    @Override // com.discord.widgets.chat.input.sticker.HeaderType
    public String getId() {
        StringBuilder sbU = a.U("owned-header:");
        sbU.append(this.pack.getId());
        return sbU.toString();
    }

    public final ModelStickerPack getPack() {
        return this.pack;
    }

    public int hashCode() {
        ModelStickerPack modelStickerPack = this.pack;
        if (modelStickerPack != null) {
            return modelStickerPack.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("PackItem(pack=");
        sbU.append(this.pack);
        sbU.append(")");
        return sbU.toString();
    }
}
