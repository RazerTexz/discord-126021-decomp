package com.discord.stores;

import com.discord.utilities.search.network.SearchQuery;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreSearchQuery.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearchQuery$parseAndQuery$4 extends o implements Function1<SearchQuery, Unit> {
    public final /* synthetic */ StoreSearch$SearchTarget $searchTarget;
    public final /* synthetic */ StoreSearchQuery this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreSearchQuery$parseAndQuery$4(StoreSearchQuery storeSearchQuery, StoreSearch$SearchTarget storeSearch$SearchTarget) {
        super(1);
        this.this$0 = storeSearchQuery;
        this.$searchTarget = storeSearch$SearchTarget;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SearchQuery searchQuery) {
        invoke2(searchQuery);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SearchQuery searchQuery) {
        if (searchQuery == null) {
            StoreSearchQuery.access$handleError(this.this$0);
        } else {
            StoreSearchQuery.access$performInitialLoad(this.this$0, this.$searchTarget, searchQuery);
        }
    }
}
