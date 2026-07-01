package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildsSorted.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildsSorted$init$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreGuildsSorted$State $state;
    public final /* synthetic */ StoreGuildsSorted$init$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildsSorted$init$1$1(StoreGuildsSorted$init$1 storeGuildsSorted$init$1, StoreGuildsSorted$State storeGuildsSorted$State) {
        super(0);
        this.this$0 = storeGuildsSorted$init$1;
        this.$state = storeGuildsSorted$State;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildsSorted.access$handleNewState(this.this$0.this$0, this.$state);
    }
}
