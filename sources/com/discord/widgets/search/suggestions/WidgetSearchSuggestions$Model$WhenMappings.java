package com.discord.widgets.search.suggestions;

import com.discord.utilities.search.suggestion.entries.SearchSuggestion$Category;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSearchSuggestions$Model$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        SearchSuggestion$Category.values();
        int[] iArr = new int[7];
        $EnumSwitchMapping$0 = iArr;
        iArr[SearchSuggestion$Category.FILTER.ordinal()] = 1;
        iArr[SearchSuggestion$Category.FROM_USER.ordinal()] = 2;
        iArr[SearchSuggestion$Category.MENTIONS_USER.ordinal()] = 3;
        iArr[SearchSuggestion$Category.IN_CHANNEL.ordinal()] = 4;
        iArr[SearchSuggestion$Category.HAS.ordinal()] = 5;
        iArr[SearchSuggestion$Category.RECENT_QUERY.ordinal()] = 6;
    }
}
