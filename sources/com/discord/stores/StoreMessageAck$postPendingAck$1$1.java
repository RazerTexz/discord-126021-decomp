package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$postPendingAck$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreMessageAck$Ack $ack;
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreMessageAck$postPendingAck$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageAck$postPendingAck$1$1(StoreMessageAck$postPendingAck$1 storeMessageAck$postPendingAck$1, long j, StoreMessageAck$Ack storeMessageAck$Ack) {
        super(0);
        this.this$0 = storeMessageAck$postPendingAck$1;
        this.$channelId = j;
        this.$ack = storeMessageAck$Ack;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreMessageAck.access$updateAcks(this.this$0.this$0, this.$channelId, this.$ack);
    }
}
