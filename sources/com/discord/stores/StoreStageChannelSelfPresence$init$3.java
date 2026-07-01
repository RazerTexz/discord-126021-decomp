package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStageChannelSelfPresence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannelSelfPresence$init$3 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ StoreStageChannelSelfPresence this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStageChannelSelfPresence$init$3(StoreStageChannelSelfPresence storeStageChannelSelfPresence) {
        super(1);
        this.this$0 = storeStageChannelSelfPresence;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        this.this$0.getDispatcher().schedule(new StoreStageChannelSelfPresence$init$3$1(this, bool));
    }
}
