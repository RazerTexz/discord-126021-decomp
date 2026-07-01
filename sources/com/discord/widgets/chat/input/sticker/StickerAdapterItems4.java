package com.discord.widgets.chat.input.sticker;

import b.d.b.a.outline;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StoreHeaderItem, reason: use source file name */
/* JADX INFO: compiled from: StickerAdapterItems.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerAdapterItems4 implements MGRecyclerDataPayload {
    private final boolean isNewPack;
    private final String key;
    private final ModelStickerPack pack;
    private final int type;

    public StickerAdapterItems4(ModelStickerPack modelStickerPack, boolean z2) {
        Intrinsics3.checkNotNullParameter(modelStickerPack, "pack");
        this.pack = modelStickerPack;
        this.isNewPack = z2;
        this.type = 2;
        StringBuilder sbU = outline.U("store-header:");
        sbU.append(modelStickerPack.getId());
        this.key = sbU.toString();
    }

    public static /* synthetic */ StickerAdapterItems4 copy$default(StickerAdapterItems4 stickerAdapterItems4, ModelStickerPack modelStickerPack, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            modelStickerPack = stickerAdapterItems4.pack;
        }
        if ((i & 2) != 0) {
            z2 = stickerAdapterItems4.isNewPack;
        }
        return stickerAdapterItems4.copy(modelStickerPack, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelStickerPack getPack() {
        return this.pack;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsNewPack() {
        return this.isNewPack;
    }

    public final StickerAdapterItems4 copy(ModelStickerPack pack, boolean isNewPack) {
        Intrinsics3.checkNotNullParameter(pack, "pack");
        return new StickerAdapterItems4(pack, isNewPack);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerAdapterItems4)) {
            return false;
        }
        StickerAdapterItems4 stickerAdapterItems4 = (StickerAdapterItems4) other;
        return Intrinsics3.areEqual(this.pack, stickerAdapterItems4.pack) && this.isNewPack == stickerAdapterItems4.isNewPack;
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
        StringBuilder sbU = outline.U("StoreHeaderItem(pack=");
        sbU.append(this.pack);
        sbU.append(", isNewPack=");
        return outline.O(sbU, this.isNewPack, ")");
    }
}
