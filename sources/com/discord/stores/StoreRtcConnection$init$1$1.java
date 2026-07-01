package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcConnection$init$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $isMuted;
    public final /* synthetic */ StoreRtcConnection$init$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRtcConnection$init$1$1(StoreRtcConnection$init$1 storeRtcConnection$init$1, boolean z2) {
        super(0);
        this.this$0 = storeRtcConnection$init$1;
        this.$isMuted = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreRtcConnection.access$handleSelfMuted(this.this$0.this$0, this.$isMuted);
    }
}
