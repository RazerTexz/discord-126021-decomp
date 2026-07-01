package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$observeForChannel$1 extends o implements Function0<StoreMessageAck$Ack> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreMessageAck this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageAck$observeForChannel$1(StoreMessageAck storeMessageAck, long j) {
        super(0);
        this.this$0 = storeMessageAck;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreMessageAck$Ack invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreMessageAck$Ack invoke() {
        return this.this$0.getForChannel(this.$channelId);
    }
}
