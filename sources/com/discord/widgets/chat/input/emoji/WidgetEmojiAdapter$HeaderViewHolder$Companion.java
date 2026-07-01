package com.discord.widgets.chat.input.emoji;

import androidx.annotation.StringRes;
import com.discord.models.domain.emoji.EmojiCategory;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiAdapter$HeaderViewHolder$Companion {
    private WidgetEmojiAdapter$HeaderViewHolder$Companion() {
    }

    @StringRes
    public final int getCategoryString(EmojiCategory emojiCategory) {
        m.checkNotNullParameter(emojiCategory, "emojiCategory");
        switch (emojiCategory) {
            case FAVORITE:
                return 2131887466;
            case RECENT:
                return 2131888760;
            case CUSTOM:
                return 2131888753;
            case PEOPLE:
                return 2131888758;
            case NATURE:
                return 2131888756;
            case FOOD:
                return 2131888755;
            case ACTIVITY:
                return 2131888752;
            case TRAVEL:
                return 2131888762;
            case OBJECTS:
                return 2131888757;
            case SYMBOLS:
                return 2131888761;
            case FLAGS:
                return 2131888754;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public /* synthetic */ WidgetEmojiAdapter$HeaderViewHolder$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
