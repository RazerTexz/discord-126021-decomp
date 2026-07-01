package com.discord.stores;

import com.discord.utilities.search.network.SearchQuery;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreSearchQuery.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearchQuery$parseAndQuery$3 extends o implements Function1<SearchQuery, Boolean> {
    public static final StoreSearchQuery$parseAndQuery$3 INSTANCE = new StoreSearchQuery$parseAndQuery$3();

    public StoreSearchQuery$parseAndQuery$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(SearchQuery searchQuery) {
        return Boolean.valueOf(invoke2(searchQuery));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(SearchQuery searchQuery) {
        return searchQuery != null && searchQuery.isValid();
    }
}
