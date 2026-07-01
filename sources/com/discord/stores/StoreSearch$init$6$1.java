package com.discord.stores;

import com.discord.utilities.search.network.state.SearchState;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearch$init$6$1 extends o implements Function0<Unit> {
    public final /* synthetic */ SearchState $searchState;
    public final /* synthetic */ StoreSearch$init$6 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreSearch$init$6$1(StoreSearch$init$6 storeSearch$init$6, SearchState searchState) {
        super(0);
        this.this$0 = storeSearch$init$6;
        this.$searchState = searchState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreSearch.access$getStream$p(this.this$0.this$0).handleSearchFinish(this.$searchState);
    }
}
