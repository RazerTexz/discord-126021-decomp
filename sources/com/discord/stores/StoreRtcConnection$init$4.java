package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcConnection$init$4 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ StoreRtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRtcConnection$init$4(StoreRtcConnection storeRtcConnection) {
        super(1);
        this.this$0 = storeRtcConnection;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        StoreRtcConnection.access$getDispatcher$p(this.this$0).schedule(new StoreRtcConnection$init$4$1(this, bool));
    }
}
