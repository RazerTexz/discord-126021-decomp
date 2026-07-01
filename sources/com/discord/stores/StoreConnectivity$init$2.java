package com.discord.stores;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreConnectivity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreConnectivity$init$2 extends k implements Function1<Boolean, Unit> {
    public StoreConnectivity$init$2(StoreConnectivity storeConnectivity) {
        super(1, storeConnectivity, StoreConnectivity.class, "handleChannelMessagesLoading", "handleChannelMessagesLoading(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        StoreConnectivity.access$handleChannelMessagesLoading((StoreConnectivity) this.receiver, z2);
    }
}
