package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcConnection$onFirstFrameSent$1 extends o implements Function1<StoreRtcConnection$Listener, Unit> {
    public static final StoreRtcConnection$onFirstFrameSent$1 INSTANCE = new StoreRtcConnection$onFirstFrameSent$1();

    public StoreRtcConnection$onFirstFrameSent$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreRtcConnection$Listener storeRtcConnection$Listener) {
        invoke2(storeRtcConnection$Listener);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreRtcConnection$Listener storeRtcConnection$Listener) {
        m.checkNotNullParameter(storeRtcConnection$Listener, "it");
        storeRtcConnection$Listener.onFirstFrameSent();
    }
}
