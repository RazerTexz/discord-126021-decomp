package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreChannelMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelMembers$1 extends o implements Function1<Unit, Unit> {
    public final /* synthetic */ StoreChannelMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelMembers$1(StoreChannelMembers storeChannelMembers) {
        super(1);
        this.this$0 = storeChannelMembers;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke2(unit);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Unit unit) {
        StoreChannelMembers.access$getDispatcher$p(this.this$0).schedule(new StoreChannelMembers$1$1(this));
    }
}
