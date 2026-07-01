package com.discord.widgets.chat.input.emoji;

import androidx.annotation.DrawableRes;
import com.discord.models.domain.emoji.EmojiCategory;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EmojiCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiCategoryViewHolder$Companion {
    private EmojiCategoryViewHolder$Companion() {
    }

    @DrawableRes
    public final int getCategoryIconResId(EmojiCategory emojiCategory) {
        m.checkNotNullParameter(emojiCategory, "emojiCategory");
        switch (emojiCategory) {
            case FAVORITE:
                return 2131231737;
            case RECENT:
                return 2131231743;
            case CUSTOM:
            default:
                return 2131231736;
            case PEOPLE:
                return 2131231742;
            case NATURE:
                return 2131231740;
            case FOOD:
                return 2131231739;
            case ACTIVITY:
                return 2131231735;
            case TRAVEL:
                return 2131231745;
            case OBJECTS:
                return 2131231741;
            case SYMBOLS:
                return 2131231744;
            case FLAGS:
                return 2131231738;
        }
    }

    public /* synthetic */ EmojiCategoryViewHolder$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
