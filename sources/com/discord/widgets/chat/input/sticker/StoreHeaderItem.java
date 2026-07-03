package com.discord.widgets.chat.input.sticker;

import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerAdapterItems.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreHeaderItem implements MGRecyclerDataPayload {
    private final boolean isNewPack;
    private final String key;
    private final ModelStickerPack pack;
    private final int type;

    public StoreHeaderItem(ModelStickerPack modelStickerPack, boolean z2) {
        C12238m.checkNotNullParameter(modelStickerPack, "pack");
        this.pack = modelStickerPack;
        this.isNewPack = z2;
        this.type = 2;
        StringBuilder sbM833U = C1643a.m833U("store-header:");
        sbM833U.append(modelStickerPack.getId());
        this.key = sbM833U.toString();
    }

    public static /* synthetic */ StoreHeaderItem copy$default(StoreHeaderItem storeHeaderItem, ModelStickerPack modelStickerPack, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            modelStickerPack = storeHeaderItem.pack;
        }
        if ((i & 2) != 0) {
            z2 = storeHeaderItem.isNewPack;
        }
        return storeHeaderItem.copy(modelStickerPack, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelStickerPack getPack() {
        return this.pack;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsNewPack() {
        return this.isNewPack;
    }

    public final StoreHeaderItem copy(ModelStickerPack pack, boolean isNewPack) {
        C12238m.checkNotNullParameter(pack, "pack");
        return new StoreHeaderItem(pack, isNewPack);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreHeaderItem)) {
            return false;
        }
        StoreHeaderItem storeHeaderItem = (StoreHeaderItem) other;
        return C12238m.areEqual(this.pack, storeHeaderItem.pack) && this.isNewPack == storeHeaderItem.isNewPack;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final ModelStickerPack getPack() {
        return this.pack;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        ModelStickerPack modelStickerPack = this.pack;
        int iHashCode = (modelStickerPack != null ? modelStickerPack.hashCode() : 0) * 31;
        boolean z2 = this.isNewPack;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isNewPack() {
        return this.isNewPack;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("StoreHeaderItem(pack=");
        sbM833U.append(this.pack);
        sbM833U.append(", isNewPack=");
        return C1643a.m827O(sbM833U, this.isNewPack, ")");
    }
}
