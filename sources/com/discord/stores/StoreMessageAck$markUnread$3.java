package com.discord.stores;

import com.discord.models.message.Message;
import d0.z.d.o;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$markUnread$3 extends o implements Function1<Pair<? extends List<? extends Message>, ? extends StoreMessageAck$Companion$ThreadAckState>, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ StoreMessageAck this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageAck$markUnread$3(StoreMessageAck storeMessageAck, long j, long j2) {
        super(1);
        this.this$0 = storeMessageAck;
        this.$messageId = j;
        this.$channelId = j2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends List<? extends Message>, ? extends StoreMessageAck$Companion$ThreadAckState> pair) {
        invoke2((Pair<? extends List<Message>, ? extends StoreMessageAck$Companion$ThreadAckState>) pair);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<? extends List<Message>, ? extends StoreMessageAck$Companion$ThreadAckState> pair) {
        List<Message> listComponent1 = pair.component1();
        if (StoreMessageAck.Companion.isThreadAndUnableToAck(pair.component2())) {
            return;
        }
        StoreMessageAck.access$getDispatcher$p(this.this$0).schedule(new StoreMessageAck$markUnread$3$1(this, listComponent1));
    }
}
