package com.discord.widgets.search.suggestions;

import com.discord.utilities.search.query.FilterType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSearchSuggestionsAdapter$FilterViewHolder$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;

    static {
        FilterType.values();
        int[] iArr = new int[4];
        $EnumSwitchMapping$0 = iArr;
        FilterType filterType = FilterType.FROM;
        iArr[filterType.ordinal()] = 1;
        FilterType filterType2 = FilterType.MENTIONS;
        iArr[filterType2.ordinal()] = 2;
        FilterType filterType3 = FilterType.HAS;
        iArr[filterType3.ordinal()] = 3;
        FilterType filterType4 = FilterType.IN;
        iArr[filterType4.ordinal()] = 4;
        FilterType.values();
        int[] iArr2 = new int[4];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[filterType.ordinal()] = 1;
        iArr2[filterType2.ordinal()] = 2;
        iArr2[filterType3.ordinal()] = 3;
        iArr2[filterType4.ordinal()] = 4;
        FilterType.values();
        int[] iArr3 = new int[4];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[filterType.ordinal()] = 1;
        iArr3[filterType2.ordinal()] = 2;
        iArr3[filterType3.ordinal()] = 3;
        iArr3[filterType4.ordinal()] = 4;
    }
}
