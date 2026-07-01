package com.discord.widgets.search.suggestions;

import androidx.annotation.DrawableRes;
import com.discord.utilities.search.query.node.answer.HasAnswerOption;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$HasViewHolder$Companion {
    private WidgetSearchSuggestionsAdapter$HasViewHolder$Companion() {
    }

    public static final /* synthetic */ int access$getIconRes(WidgetSearchSuggestionsAdapter$HasViewHolder$Companion widgetSearchSuggestionsAdapter$HasViewHolder$Companion, HasAnswerOption hasAnswerOption) {
        return widgetSearchSuggestionsAdapter$HasViewHolder$Companion.getIconRes(hasAnswerOption);
    }

    @DrawableRes
    private final int getIconRes(HasAnswerOption hasAnswerOption) {
        switch (hasAnswerOption) {
            case LINK:
                return 2131231715;
            case EMBED:
                return 2131231732;
            case FILE:
                return 2131231534;
            case VIDEO:
                return 2131232035;
            case IMAGE:
                return 2131232187;
            case SOUND:
                return 2131232135;
            case STICKER:
                return 2131232165;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public /* synthetic */ WidgetSearchSuggestionsAdapter$HasViewHolder$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
