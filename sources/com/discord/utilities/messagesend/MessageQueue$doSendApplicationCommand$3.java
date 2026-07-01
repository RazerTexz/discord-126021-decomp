package com.discord.utilities.messagesend;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$doSendApplicationCommand$3 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ MessageQueue$DrainListener $drainListener;
    public final /* synthetic */ MessageRequest$SendApplicationCommand $sendApplicationCommandRequest;
    public final /* synthetic */ MessageQueue this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageQueue$doSendApplicationCommand$3(MessageQueue messageQueue, MessageRequest$SendApplicationCommand messageRequest$SendApplicationCommand, MessageQueue$DrainListener messageQueue$DrainListener) {
        super(1);
        this.this$0 = messageQueue;
        this.$sendApplicationCommandRequest = messageRequest$SendApplicationCommand;
        this.$drainListener = messageQueue$DrainListener;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r3) {
        MessageQueue.access$handleSuccess(this.this$0, this.$sendApplicationCommandRequest.getMessage(), this.$drainListener);
    }
}
