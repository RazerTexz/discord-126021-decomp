package com.discord.utilities.search.network;

import com.discord.stores.StoreSearch$SearchTarget$Type;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SearchFetcher$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        StoreSearch$SearchTarget$Type.values();
        int[] iArr = new int[2];
        $EnumSwitchMapping$0 = iArr;
        iArr[StoreSearch$SearchTarget$Type.GUILD.ordinal()] = 1;
        iArr[StoreSearch$SearchTarget$Type.CHANNEL.ordinal()] = 2;
    }
}
