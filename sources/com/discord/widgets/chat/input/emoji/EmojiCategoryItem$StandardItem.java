package com.discord.widgets.chat.input.emoji;

import b.d.b.a.a;
import com.discord.models.domain.emoji.EmojiCategory;
import d0.z.d.m;
import kotlin.Pair;

/* JADX INFO: compiled from: EmojiCategoryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiCategoryItem$StandardItem extends EmojiCategoryItem {
    private final Pair<Integer, Integer> categoryRange;
    private final EmojiCategory emojiCategory;
    private final boolean isSelected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiCategoryItem$StandardItem(EmojiCategory emojiCategory, Pair<Integer, Integer> pair, boolean z2) {
        super(EmojiCategoryItem.Companion.mapEmojiCategoryToItemId(emojiCategory), pair, z2, null);
        m.checkNotNullParameter(emojiCategory, "emojiCategory");
        m.checkNotNullParameter(pair, "categoryRange");
        this.emojiCategory = emojiCategory;
        this.categoryRange = pair;
        this.isSelected = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmojiCategoryItem$StandardItem copy$default(EmojiCategoryItem$StandardItem emojiCategoryItem$StandardItem, EmojiCategory emojiCategory, Pair pair, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            emojiCategory = emojiCategoryItem$StandardItem.emojiCategory;
        }
        if ((i & 2) != 0) {
            pair = emojiCategoryItem$StandardItem.getCategoryRange();
        }
        if ((i & 4) != 0) {
            z2 = emojiCategoryItem$StandardItem.getIsSelected();
        }
        return emojiCategoryItem$StandardItem.copy(emojiCategory, pair, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EmojiCategory getEmojiCategory() {
        return this.emojiCategory;
    }

    public final Pair<Integer, Integer> component2() {
        return getCategoryRange();
    }

    public final boolean component3() {
        return getIsSelected();
    }

    public final EmojiCategoryItem$StandardItem copy(EmojiCategory emojiCategory, Pair<Integer, Integer> categoryRange, boolean isSelected) {
        m.checkNotNullParameter(emojiCategory, "emojiCategory");
        m.checkNotNullParameter(categoryRange, "categoryRange");
        return new EmojiCategoryItem$StandardItem(emojiCategory, categoryRange, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiCategoryItem$StandardItem)) {
            return false;
        }
        EmojiCategoryItem$StandardItem emojiCategoryItem$StandardItem = (EmojiCategoryItem$StandardItem) other;
        return m.areEqual(this.emojiCategory, emojiCategoryItem$StandardItem.emojiCategory) && m.areEqual(getCategoryRange(), emojiCategoryItem$StandardItem.getCategoryRange()) && getIsSelected() == emojiCategoryItem$StandardItem.getIsSelected();
    }

    @Override // com.discord.widgets.chat.input.emoji.EmojiCategoryItem
    public Pair<Integer, Integer> getCategoryRange() {
        return this.categoryRange;
    }

    public final EmojiCategory getEmojiCategory() {
        return this.emojiCategory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        EmojiCategory emojiCategory = this.emojiCategory;
        int iHashCode = (emojiCategory != null ? emojiCategory.hashCode() : 0) * 31;
        Pair<Integer, Integer> categoryRange = getCategoryRange();
        int iHashCode2 = (iHashCode + (categoryRange != null ? categoryRange.hashCode() : 0)) * 31;
        boolean isSelected = getIsSelected();
        ?? r1 = isSelected;
        if (isSelected) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    @Override // com.discord.widgets.chat.input.emoji.EmojiCategoryItem
    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public boolean getIsSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sbU = a.U("StandardItem(emojiCategory=");
        sbU.append(this.emojiCategory);
        sbU.append(", categoryRange=");
        sbU.append(getCategoryRange());
        sbU.append(", isSelected=");
        sbU.append(getIsSelected());
        sbU.append(")");
        return sbU.toString();
    }
}
