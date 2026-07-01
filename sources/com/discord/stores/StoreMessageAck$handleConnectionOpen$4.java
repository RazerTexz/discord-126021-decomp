package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$handleConnectionOpen$4 extends o implements Function1<Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>>, Unit> {
    public final /* synthetic */ StoreMessageAck this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageAck$handleConnectionOpen$4(StoreMessageAck storeMessageAck) {
        super(1);
        this.this$0 = storeMessageAck;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>> pair) {
        invoke2((Pair<? extends Set<Long>, ? extends Set<Long>>) pair);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<? extends Set<Long>, ? extends Set<Long>> pair) {
        m.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        StoreMessageAck.access$getDispatcher$p(this.this$0).schedule(new StoreMessageAck$handleConnectionOpen$4$1(this, pair.component1(), pair.component2()));
    }
}
