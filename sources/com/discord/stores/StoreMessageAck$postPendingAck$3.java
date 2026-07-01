package com.discord.stores;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreMessageAck$postPendingAck$3 extends k implements Function1<StoreMessageAck$PendingAck, Unit> {
    public final /* synthetic */ StoreMessageAck$postPendingAck$1 $postChannelMessagesAck$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageAck$postPendingAck$3(StoreMessageAck$postPendingAck$1 storeMessageAck$postPendingAck$1) {
        super(1, null, "postChannelMessagesAck", "invoke(Lcom/discord/stores/StoreMessageAck$PendingAck;)V", 0);
        this.$postChannelMessagesAck$1 = storeMessageAck$postPendingAck$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreMessageAck$PendingAck storeMessageAck$PendingAck) {
        invoke2(storeMessageAck$PendingAck);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreMessageAck$PendingAck storeMessageAck$PendingAck) {
        m.checkNotNullParameter(storeMessageAck$PendingAck, "p1");
        this.$postChannelMessagesAck$1.invoke2(storeMessageAck$PendingAck);
    }
}
