package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.sticker.dto.ModelStickerPack;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreStickers$StickerPackState$Loaded extends StoreStickers$StickerPackState {
    private final ModelStickerPack stickerPack;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStickers$StickerPackState$Loaded(ModelStickerPack modelStickerPack) {
        super(null);
        m.checkNotNullParameter(modelStickerPack, "stickerPack");
        this.stickerPack = modelStickerPack;
    }

    public static /* synthetic */ StoreStickers$StickerPackState$Loaded copy$default(StoreStickers$StickerPackState$Loaded storeStickers$StickerPackState$Loaded, ModelStickerPack modelStickerPack, int i, Object obj) {
        if ((i & 1) != 0) {
            modelStickerPack = storeStickers$StickerPackState$Loaded.stickerPack;
        }
        return storeStickers$StickerPackState$Loaded.copy(modelStickerPack);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelStickerPack getStickerPack() {
        return this.stickerPack;
    }

    public final StoreStickers$StickerPackState$Loaded copy(ModelStickerPack stickerPack) {
        m.checkNotNullParameter(stickerPack, "stickerPack");
        return new StoreStickers$StickerPackState$Loaded(stickerPack);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreStickers$StickerPackState$Loaded) && m.areEqual(this.stickerPack, ((StoreStickers$StickerPackState$Loaded) other).stickerPack);
        }
        return true;
    }

    public final ModelStickerPack getStickerPack() {
        return this.stickerPack;
    }

    public int hashCode() {
        ModelStickerPack modelStickerPack = this.stickerPack;
        if (modelStickerPack != null) {
            return modelStickerPack.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(stickerPack=");
        sbU.append(this.stickerPack);
        sbU.append(")");
        return sbU.toString();
    }
}
