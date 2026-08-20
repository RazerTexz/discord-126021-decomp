package com.discord.stores;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.stores.StoreStreamRtcConnection$RtcConnectionListener$onMediaSessionIdReceived$1 */
/* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6518x43e4131 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ StoreStreamRtcConnection.RtcConnectionListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6518x43e4131(StoreStreamRtcConnection.RtcConnectionListener rtcConnectionListener) {
        super(0);
        this.this$0 = rtcConnectionListener;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStreamRtcConnection.this.handleMediaSessionIdReceived();
    }
}
