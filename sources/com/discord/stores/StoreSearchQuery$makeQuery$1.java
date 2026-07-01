package com.discord.stores;

import com.discord.models.domain.ModelSearchResponse;
import com.discord.utilities.search.network.SearchQuery;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreSearchQuery.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearchQuery$makeQuery$1 extends o implements Function1<ModelSearchResponse, Unit> {
    public final /* synthetic */ boolean $isInitialLoad;
    public final /* synthetic */ SearchQuery $query;
    public final /* synthetic */ StoreSearchQuery this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreSearchQuery$makeQuery$1(StoreSearchQuery storeSearchQuery, SearchQuery searchQuery, boolean z2) {
        super(1);
        this.this$0 = storeSearchQuery;
        this.$query = searchQuery;
        this.$isInitialLoad = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelSearchResponse modelSearchResponse) {
        invoke2(modelSearchResponse);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelSearchResponse modelSearchResponse) {
        m.checkNotNullParameter(modelSearchResponse, "searchResponse");
        StoreSearchQuery.access$handleResponse(this.this$0, this.$query, modelSearchResponse, this.$isInitialLoad);
    }
}
