package com.discord.stores;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$voiceStates$1 extends k implements Function3<Long, Long, Long, Unit> {
    public StoreStream$voiceStates$1(StoreStream storeStream) {
        super(3, storeStream, StoreStream.class, "handleVoiceStatesUpdated", "handleVoiceStatesUpdated(JJJ)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2, Long l3) {
        invoke(l.longValue(), l2.longValue(), l3.longValue());
        return Unit.a;
    }

    public final void invoke(long j, long j2, long j3) {
        ((StoreStream) this.receiver).handleVoiceStatesUpdated(j, j2, j3);
    }
}
