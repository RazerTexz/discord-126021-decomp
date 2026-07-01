package com.discord.utilities.search.suggestion.entries;

import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.g0.w;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FilterSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FilterSuggestion$Companion {
    private FilterSuggestion$Companion() {
    }

    private final String getStringRepresentation(FilterType filterType, SearchStringProvider searchStringProvider) {
        String fromFilterString;
        int iOrdinal = filterType.ordinal();
        if (iOrdinal == 0) {
            fromFilterString = searchStringProvider.getFromFilterString();
        } else if (iOrdinal == 1 || iOrdinal == 2) {
            fromFilterString = searchStringProvider.getMentionsFilterString();
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            fromFilterString = searchStringProvider.getInFilterString();
        }
        return fromFilterString + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR;
    }

    public final boolean canComplete(CharSequence currentInput, FilterType filterType, SearchStringProvider searchStringProvider) {
        m.checkNotNullParameter(currentInput, "currentInput");
        m.checkNotNullParameter(filterType, "filterType");
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        return w.contains$default((CharSequence) getStringRepresentation(filterType, searchStringProvider), currentInput, false, 2, (Object) null);
    }

    public /* synthetic */ FilterSuggestion$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
