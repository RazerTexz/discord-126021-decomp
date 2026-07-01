package com.discord.stores;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$2 extends k implements Function1<Boolean, Unit> {
    public StoreStream$initGatewaySocketListeners$2(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleConnected", "handleConnected(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        StoreStream.access$handleConnected((StoreStream) this.receiver, z2);
    }
}
