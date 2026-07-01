package com.discord.models.domain.emoji;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;

/* JADX INFO: loaded from: classes.dex */
public enum EmojiCategory {
    FAVORITE("favorite", false),
    RECENT("recent", false),
    CUSTOM("custom", false),
    PEOPLE("people", true),
    NATURE("nature", true),
    FOOD("food", true),
    ACTIVITY(ActivityChooserModel.ATTRIBUTE_ACTIVITY, true),
    TRAVEL("travel", true),
    OBJECTS("objects", true),
    SYMBOLS("symbols", true),
    FLAGS("flags", true);

    public final boolean containsOnlyUnicode;
    private final String stringRep;

    EmojiCategory(String str, boolean z2) {
        this.stringRep = str;
        this.containsOnlyUnicode = z2;
    }

    @Nullable
    public static EmojiCategory getByString(String str) {
        EmojiCategory[] emojiCategoryArrValues = values();
        for (int i = 0; i < 11; i++) {
            EmojiCategory emojiCategory = emojiCategoryArrValues[i];
            if (emojiCategory.stringRep.equals(str)) {
                return emojiCategory;
            }
        }
        return null;
    }
}
