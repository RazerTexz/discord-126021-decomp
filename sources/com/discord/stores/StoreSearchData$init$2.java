package com.discord.stores;

import com.discord.utilities.search.validation.SearchData;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreSearchData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreSearchData$init$2 extends k implements Function1<SearchData, Unit> {
    public StoreSearchData$init$2(StoreSearchData storeSearchData) {
        super(1, storeSearchData, StoreSearchData.class, "handleNewData", "handleNewData(Lcom/discord/utilities/search/validation/SearchData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SearchData searchData) {
        invoke2(searchData);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SearchData searchData) {
        m.checkNotNullParameter(searchData, "p1");
        StoreSearchData.access$handleNewData((StoreSearchData) this.receiver, searchData);
    }
}
