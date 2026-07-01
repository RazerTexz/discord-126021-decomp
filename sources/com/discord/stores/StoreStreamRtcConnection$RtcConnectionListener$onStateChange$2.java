package com.discord.stores;

import com.discord.rtcconnection.RtcConnection$StateChange;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStreamRtcConnection$RtcConnectionListener$onStateChange$2 extends o implements Function0<Unit> {
    public final /* synthetic */ RtcConnection$StateChange $stateChange;
    public final /* synthetic */ StoreStreamRtcConnection$RtcConnectionListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStreamRtcConnection$RtcConnectionListener$onStateChange$2(StoreStreamRtcConnection$RtcConnectionListener storeStreamRtcConnection$RtcConnectionListener, RtcConnection$StateChange rtcConnection$StateChange) {
        super(0);
        this.this$0 = storeStreamRtcConnection$RtcConnectionListener;
        this.$stateChange = rtcConnection$StateChange;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStreamRtcConnection.access$getStoreStream$p(this.this$0.this$0).handleStreamRtcConnectionStateChange(this.$stateChange);
    }
}
