package com.discord.stores;

import com.discord.api.message.reaction.MessageReactionUpdate;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$37 extends k implements Function1<MessageReactionUpdate, Unit> {
    public StoreStream$initGatewaySocketListeners$37(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleReactionRemoveAll", "handleReactionRemoveAll(Lcom/discord/api/message/reaction/MessageReactionUpdate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageReactionUpdate messageReactionUpdate) {
        invoke2(messageReactionUpdate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageReactionUpdate messageReactionUpdate) {
        m.checkNotNullParameter(messageReactionUpdate, "p1");
        StoreStream.access$handleReactionRemoveAll((StoreStream) this.receiver, messageReactionUpdate);
    }
}
