package com.discord.stores;

import com.discord.rtcconnection.RtcConnection$StateChange;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$deferredInit$1$8 extends k implements Function1<RtcConnection$StateChange, Unit> {
    public StoreStream$deferredInit$1$8(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleRtcConnectionStateChanged", "handleRtcConnectionStateChanged(Lcom/discord/rtcconnection/RtcConnection$StateChange;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RtcConnection$StateChange rtcConnection$StateChange) {
        invoke2(rtcConnection$StateChange);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RtcConnection$StateChange rtcConnection$StateChange) {
        m.checkNotNullParameter(rtcConnection$StateChange, "p1");
        StoreStream.access$handleRtcConnectionStateChanged((StoreStream) this.receiver, rtcConnection$StateChange);
    }
}
