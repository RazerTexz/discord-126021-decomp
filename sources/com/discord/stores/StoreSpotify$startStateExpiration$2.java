package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreSpotify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSpotify$startStateExpiration$2 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ StoreSpotify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreSpotify$startStateExpiration$2(StoreSpotify storeSpotify) {
        super(1);
        this.this$0 = storeSpotify;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        StoreSpotify.access$getDispatcher$p(this.this$0).schedule(new StoreSpotify$startStateExpiration$2$1(this));
    }
}
