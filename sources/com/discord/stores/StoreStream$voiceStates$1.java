package com.discord.stores;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.C12236k;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$voiceStates$1 extends C12236k implements Function3<Long, Long, Long, Unit> {
    public StoreStream$voiceStates$1(StoreStream storeStream) {
        super(3, storeStream, StoreStream.class, "handleVoiceStatesUpdated", "handleVoiceStatesUpdated(JJJ)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2, Long l3) {
        invoke(l.longValue(), l2.longValue(), l3.longValue());
        return Unit.f27425a;
    }

    public final void invoke(long j, long j2, long j3) {
        ((StoreStream) this.receiver).handleVoiceStatesUpdated(j, j2, j3);
    }
}
