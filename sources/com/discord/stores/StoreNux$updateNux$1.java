package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreNux.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNux$updateNux$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Function1 $updateFunction;
    public final /* synthetic */ StoreNux this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNux$updateNux$1(StoreNux storeNux, Function1 function1) {
        super(0);
        this.this$0 = storeNux;
        this.$updateFunction = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreNux storeNux = this.this$0;
        StoreNux.access$setNuxState$p(storeNux, (StoreNux$NuxState) this.$updateFunction.invoke(StoreNux.access$getNuxState$p(storeNux)));
        StoreNux storeNux2 = this.this$0;
        StoreNux.access$publishNuxUpdated(storeNux2, StoreNux.access$getNuxState$p(storeNux2));
    }
}
