package com.discord.stores;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$deferredInit$1$5 extends k implements Function1<Long, Unit> {
    public StoreStream$deferredInit$1$5(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleChannelSelected", "handleChannelSelected(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        StoreStream.access$handleChannelSelected((StoreStream) this.receiver, j);
    }
}
