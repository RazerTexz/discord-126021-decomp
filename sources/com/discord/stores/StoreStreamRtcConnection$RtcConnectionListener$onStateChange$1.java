package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStreamRtcConnection$RtcConnectionListener$onStateChange$1 extends o implements Function1<StoreStreamRtcConnection$Listener, Unit> {
    public static final StoreStreamRtcConnection$RtcConnectionListener$onStateChange$1 INSTANCE = new StoreStreamRtcConnection$RtcConnectionListener$onStateChange$1();

    public StoreStreamRtcConnection$RtcConnectionListener$onStateChange$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreStreamRtcConnection$Listener storeStreamRtcConnection$Listener) {
        invoke2(storeStreamRtcConnection$Listener);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreStreamRtcConnection$Listener storeStreamRtcConnection$Listener) {
        m.checkNotNullParameter(storeStreamRtcConnection$Listener, "it");
        storeStreamRtcConnection$Listener.onConnected();
    }
}
