package com.discord.stores;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$deferredInit$1$10 extends k implements Function1<Boolean, Unit> {
    public StoreStream$deferredInit$1$10(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleBackgrounded", "handleBackgrounded(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        StoreStream.access$handleBackgrounded((StoreStream) this.receiver, z2);
    }
}
