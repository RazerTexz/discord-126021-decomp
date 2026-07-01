package com.discord.stores;

import com.discord.stores.StoreStreamRtcConnection;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStreamRtcConnection$RtcConnectionListener$onFirstFrameSent$1 extends Lambda implements Function1<StoreStreamRtcConnection.Listener, Unit> {
    public static final StoreStreamRtcConnection$RtcConnectionListener$onFirstFrameSent$1 INSTANCE = new StoreStreamRtcConnection$RtcConnectionListener$onFirstFrameSent$1();

    public StoreStreamRtcConnection$RtcConnectionListener$onFirstFrameSent$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreStreamRtcConnection.Listener listener) {
        invoke2(listener);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreStreamRtcConnection.Listener listener) {
        Intrinsics3.checkNotNullParameter(listener, "it");
        listener.onFirstFrameSent();
    }
}
