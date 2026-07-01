package com.discord.utilities.search.suggestion.entries;

import b.d.b.a.outline;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FilterSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FilterSuggestion implements SearchSuggestion {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SearchSuggestion.Category category;
    private final FilterType filterType;

    /* JADX INFO: compiled from: FilterSuggestion.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                FilterType.values();
                int[] iArr = new int[4];
                $EnumSwitchMapping$0 = iArr;
                iArr[FilterType.FROM.ordinal()] = 1;
                iArr[FilterType.MENTIONS.ordinal()] = 2;
                iArr[FilterType.HAS.ordinal()] = 3;
                iArr[FilterType.IN.ordinal()] = 4;
            }
        }

        private Companion() {
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
            return fromFilterString + MentionUtils.EMOJIS_AND_STICKERS_CHAR;
        }

        public final boolean canComplete(CharSequence currentInput, FilterType filterType, SearchStringProvider searchStringProvider) {
            Intrinsics3.checkNotNullParameter(currentInput, "currentInput");
            Intrinsics3.checkNotNullParameter(filterType, "filterType");
            Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
            return Strings4.contains$default((CharSequence) getStringRepresentation(filterType, searchStringProvider), currentInput, false, 2, (Object) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FilterSuggestion(FilterType filterType) {
        Intrinsics3.checkNotNullParameter(filterType, "filterType");
        this.filterType = filterType;
        this.category = SearchSuggestion.Category.FILTER;
    }

    public static /* synthetic */ FilterSuggestion copy$default(FilterSuggestion filterSuggestion, FilterType filterType, int i, Object obj) {
        if ((i & 1) != 0) {
            filterType = filterSuggestion.filterType;
        }
        return filterSuggestion.copy(filterType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FilterType getFilterType() {
        return this.filterType;
    }

    public final FilterSuggestion copy(FilterType filterType) {
        Intrinsics3.checkNotNullParameter(filterType, "filterType");
        return new FilterSuggestion(filterType);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof FilterSuggestion) && Intrinsics3.areEqual(this.filterType, ((FilterSuggestion) other).filterType);
        }
        return true;
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion.Category getCategory() {
        return this.category;
    }

    public final FilterType getFilterType() {
        return this.filterType;
    }

    public int hashCode() {
        FilterType filterType = this.filterType;
        if (filterType != null) {
            return filterType.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("FilterSuggestion(filterType=");
        sbU.append(this.filterType);
        sbU.append(")");
        return sbU.toString();
    }
}
