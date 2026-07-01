package com.discord.stores;

import com.discord.utilities.search.network.state.SearchState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearch$init$6 extends o implements Function1<SearchState, Unit> {
    public final /* synthetic */ StoreSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreSearch$init$6(StoreSearch storeSearch) {
        super(1);
        this.this$0 = storeSearch;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SearchState searchState) {
        invoke2(searchState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SearchState searchState) {
        m.checkNotNullParameter(searchState, "searchState");
        StoreSearch.access$getDispatcher$p(this.this$0).schedule(new StoreSearch$init$6$1(this, searchState));
    }
}
