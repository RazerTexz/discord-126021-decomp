package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildsSorted.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildsSorted$init$1 extends o implements Function1<StoreGuildsSorted$State, Unit> {
    public final /* synthetic */ StoreGuildsSorted this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildsSorted$init$1(StoreGuildsSorted storeGuildsSorted) {
        super(1);
        this.this$0 = storeGuildsSorted;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreGuildsSorted$State storeGuildsSorted$State) {
        invoke2(storeGuildsSorted$State);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreGuildsSorted$State storeGuildsSorted$State) {
        m.checkNotNullParameter(storeGuildsSorted$State, "state");
        StoreGuildsSorted.access$getDispatcher$p(this.this$0).schedule(new StoreGuildsSorted$init$1$1(this, storeGuildsSorted$State));
    }
}
