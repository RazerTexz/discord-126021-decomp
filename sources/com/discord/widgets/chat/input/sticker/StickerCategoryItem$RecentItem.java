package com.discord.widgets.chat.input.sticker;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.Pair;

/* JADX INFO: compiled from: StickerCategoryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerCategoryItem$RecentItem extends StickerCategoryItem {
    private final Pair<Integer, Integer> categoryRange;
    private final boolean isSelected;
    private final String key;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerCategoryItem$RecentItem(boolean z2, Pair<Integer, Integer> pair) {
        super(z2, pair, -1L, null);
        m.checkNotNullParameter(pair, "categoryRange");
        this.isSelected = z2;
        this.categoryRange = pair;
        this.key = "recent";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StickerCategoryItem$RecentItem copy$default(StickerCategoryItem$RecentItem stickerCategoryItem$RecentItem, boolean z2, Pair pair, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = stickerCategoryItem$RecentItem.getIsSelected();
        }
        if ((i & 2) != 0) {
            pair = stickerCategoryItem$RecentItem.getCategoryRange();
        }
        return stickerCategoryItem$RecentItem.copy(z2, pair);
    }

    public final boolean component1() {
        return getIsSelected();
    }

    public final Pair<Integer, Integer> component2() {
        return getCategoryRange();
    }

    public final StickerCategoryItem$RecentItem copy(boolean isSelected, Pair<Integer, Integer> categoryRange) {
        m.checkNotNullParameter(categoryRange, "categoryRange");
        return new StickerCategoryItem$RecentItem(isSelected, categoryRange);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerCategoryItem$RecentItem)) {
            return false;
        }
        StickerCategoryItem$RecentItem stickerCategoryItem$RecentItem = (StickerCategoryItem$RecentItem) other;
        return getIsSelected() == stickerCategoryItem$RecentItem.getIsSelected() && m.areEqual(getCategoryRange(), stickerCategoryItem$RecentItem.getCategoryRange());
    }

    @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
    public Pair<Integer, Integer> getCategoryRange() {
        return this.categoryRange;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean isSelected = getIsSelected();
        ?? r0 = isSelected;
        if (isSelected) {
            r0 = 1;
        }
        int i = r0 * 31;
        Pair<Integer, Integer> categoryRange = getCategoryRange();
        return i + (categoryRange != null ? categoryRange.hashCode() : 0);
    }

    @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public boolean getIsSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sbU = a.U("RecentItem(isSelected=");
        sbU.append(getIsSelected());
        sbU.append(", categoryRange=");
        sbU.append(getCategoryRange());
        sbU.append(")");
        return sbU.toString();
    }
}
