package com.discord.stores;

import d0.z.d.o;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates$computeUnreadChannelIds$2 extends o implements Function1<Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>>, Unit> {
    public final /* synthetic */ StoreReadStates this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreReadStates$computeUnreadChannelIds$2(StoreReadStates storeReadStates) {
        super(1);
        this.this$0 = storeReadStates;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>> pair) {
        invoke2((Pair<? extends Set<Long>, ? extends Set<Long>>) pair);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<? extends Set<Long>, ? extends Set<Long>> pair) {
        Set<Long> setComponent1 = pair.component1();
        Set<Long> setComponent2 = pair.component2();
        StoreReadStates.access$getUnreadChannelIds$p(this.this$0).k.onNext((T) setComponent1);
        StoreReadStates.access$getUnreadGuildIds$p(this.this$0).k.onNext((T) setComponent2);
    }
}
