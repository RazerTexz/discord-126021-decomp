package com.discord.utilities.messagesend;

import com.discord.api.message.Message;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$doSend$3 extends o implements Function1<Message, Unit> {
    public final /* synthetic */ MessageQueue$DrainListener $drainListener;
    public final /* synthetic */ MessageQueue this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageQueue$doSend$3(MessageQueue messageQueue, MessageQueue$DrainListener messageQueue$DrainListener) {
        super(1);
        this.this$0 = messageQueue;
        this.$drainListener = messageQueue$DrainListener;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Message message) {
        invoke2(message);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Message message) {
        MessageQueue messageQueue = this.this$0;
        m.checkNotNullExpressionValue(message, "resultMessage");
        MessageQueue.access$handleSuccess(messageQueue, message, this.$drainListener);
    }
}
