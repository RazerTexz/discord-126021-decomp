package com.discord.stores;

import com.discord.utilities.search.query.FilterType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreSearchInput$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        FilterType.values();
        int[] iArr = new int[4];
        $EnumSwitchMapping$0 = iArr;
        iArr[FilterType.FROM.ordinal()] = 1;
        iArr[FilterType.MENTIONS.ordinal()] = 2;
        iArr[FilterType.IN.ordinal()] = 3;
        iArr[FilterType.HAS.ordinal()] = 4;
    }
}
