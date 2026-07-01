package com.discord.utilities.messagesend;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$processNextRequest$listener$1$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ MessageQueue$processNextRequest$listener$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageQueue$processNextRequest$listener$1$1(MessageQueue$processNextRequest$listener$1 messageQueue$processNextRequest$listener$1) {
        super(1);
        this.this$0 = messageQueue$processNextRequest$listener$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        MessageQueue.access$getExecutorService$p(this.this$0.this$0).submit(new MessageQueue$processNextRequest$listener$1$1$1(this));
    }
}
