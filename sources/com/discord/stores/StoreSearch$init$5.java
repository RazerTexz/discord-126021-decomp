package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearch$init$5 extends o implements Function1<StoreSearch$DisplayState, Unit> {
    public final /* synthetic */ StoreSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreSearch$init$5(StoreSearch storeSearch) {
        super(1);
        this.this$0 = storeSearch;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreSearch$DisplayState storeSearch$DisplayState) {
        invoke2(storeSearch$DisplayState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreSearch$DisplayState storeSearch$DisplayState) {
        if (storeSearch$DisplayState != StoreSearch$DisplayState.RESULTS) {
            this.this$0.getStoreSearchQuery().clear();
        }
        StoreSearch storeSearch = this.this$0;
        m.checkNotNullExpressionValue(storeSearch$DisplayState, "it");
        StoreSearch.access$onStateChanged(storeSearch, storeSearch$DisplayState);
    }
}
