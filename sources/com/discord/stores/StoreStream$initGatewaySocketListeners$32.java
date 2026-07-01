package com.discord.stores;

import com.discord.api.message.Message;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$32 extends k implements Function1<Message, Unit> {
    public StoreStream$initGatewaySocketListeners$32(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleMessageUpdate", "handleMessageUpdate(Lcom/discord/api/message/Message;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Message message) {
        invoke2(message);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Message message) {
        m.checkNotNullParameter(message, "p1");
        StoreStream.access$handleMessageUpdate((StoreStream) this.receiver, message);
    }
}
