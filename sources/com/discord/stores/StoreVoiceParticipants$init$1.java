package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants$init$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ StoreVoiceParticipants this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreVoiceParticipants$init$1(StoreVoiceParticipants storeVoiceParticipants) {
        super(1);
        this.this$0 = storeVoiceParticipants;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        this.this$0.selectParticipant(null);
    }
}
