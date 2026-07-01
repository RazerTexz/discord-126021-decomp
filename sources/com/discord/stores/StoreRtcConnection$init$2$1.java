package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcConnection$init$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $isDeafened;
    public final /* synthetic */ StoreRtcConnection$init$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRtcConnection$init$2$1(StoreRtcConnection$init$2 storeRtcConnection$init$2, boolean z2) {
        super(0);
        this.this$0 = storeRtcConnection$init$2;
        this.$isDeafened = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreRtcConnection.access$handleSelfDeafened(this.this$0.this$0, this.$isDeafened);
    }
}
