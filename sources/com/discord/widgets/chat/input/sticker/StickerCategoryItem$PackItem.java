package com.discord.widgets.chat.input.sticker;

import b.d.b.a.a;
import com.discord.models.sticker.dto.ModelStickerPack;
import d0.z.d.m;
import kotlin.Pair;

/* JADX INFO: compiled from: StickerCategoryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerCategoryItem$PackItem extends StickerCategoryItem {
    private final Pair<Integer, Integer> categoryRange;
    private final boolean isSelected;
    private final String key;
    private final ModelStickerPack pack;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerCategoryItem$PackItem(ModelStickerPack modelStickerPack, Pair<Integer, Integer> pair, boolean z2) {
        super(z2, pair, modelStickerPack.getId(), null);
        m.checkNotNullParameter(modelStickerPack, "pack");
        m.checkNotNullParameter(pair, "categoryRange");
        this.pack = modelStickerPack;
        this.categoryRange = pair;
        this.isSelected = z2;
        this.key = String.valueOf(modelStickerPack.getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StickerCategoryItem$PackItem copy$default(StickerCategoryItem$PackItem stickerCategoryItem$PackItem, ModelStickerPack modelStickerPack, Pair pair, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            modelStickerPack = stickerCategoryItem$PackItem.pack;
        }
        if ((i & 2) != 0) {
            pair = stickerCategoryItem$PackItem.getCategoryRange();
        }
        if ((i & 4) != 0) {
            z2 = stickerCategoryItem$PackItem.getIsSelected();
        }
        return stickerCategoryItem$PackItem.copy(modelStickerPack, pair, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelStickerPack getPack() {
        return this.pack;
    }

    public final Pair<Integer, Integer> component2() {
        return getCategoryRange();
    }

    public final boolean component3() {
        return getIsSelected();
    }

    public final StickerCategoryItem$PackItem copy(ModelStickerPack pack, Pair<Integer, Integer> categoryRange, boolean isSelected) {
        m.checkNotNullParameter(pack, "pack");
        m.checkNotNullParameter(categoryRange, "categoryRange");
        return new StickerCategoryItem$PackItem(pack, categoryRange, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerCategoryItem$PackItem)) {
            return false;
        }
        StickerCategoryItem$PackItem stickerCategoryItem$PackItem = (StickerCategoryItem$PackItem) other;
        return m.areEqual(this.pack, stickerCategoryItem$PackItem.pack) && m.areEqual(getCategoryRange(), stickerCategoryItem$PackItem.getCategoryRange()) && getIsSelected() == stickerCategoryItem$PackItem.getIsSelected();
    }

    @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
    public Pair<Integer, Integer> getCategoryRange() {
        return this.categoryRange;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final ModelStickerPack getPack() {
        return this.pack;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        ModelStickerPack modelStickerPack = this.pack;
        int iHashCode = (modelStickerPack != null ? modelStickerPack.hashCode() : 0) * 31;
        Pair<Integer, Integer> categoryRange = getCategoryRange();
        int iHashCode2 = (iHashCode + (categoryRange != null ? categoryRange.hashCode() : 0)) * 31;
        boolean isSelected = getIsSelected();
        ?? r1 = isSelected;
        if (isSelected) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public boolean getIsSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sbU = a.U("PackItem(pack=");
        sbU.append(this.pack);
        sbU.append(", categoryRange=");
        sbU.append(getCategoryRange());
        sbU.append(", isSelected=");
        sbU.append(getIsSelected());
        sbU.append(")");
        return sbU.toString();
    }
}
