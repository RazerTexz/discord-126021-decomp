package com.discord.stores;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStreamRtcConnection$RtcConnectionListener$onStateChange$1 extends AbstractC12240o implements Function1<StoreStreamRtcConnection.Listener, Unit> {
    public static final StoreStreamRtcConnection$RtcConnectionListener$onStateChange$1 INSTANCE = new StoreStreamRtcConnection$RtcConnectionListener$onStateChange$1();

    public StoreStreamRtcConnection$RtcConnectionListener$onStateChange$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreStreamRtcConnection.Listener listener) {
        invoke2(listener);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreStreamRtcConnection.Listener listener) {
        C12238m.checkNotNullParameter(listener, "it");
        listener.onConnected();
    }
}
