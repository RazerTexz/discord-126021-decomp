package com.discord.utilities.messagesend;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$processNextRequest$listener$1$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ MessageQueue$processNextRequest$listener$1$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageQueue$processNextRequest$listener$1$3$1(MessageQueue$processNextRequest$listener$1$3 messageQueue$processNextRequest$listener$1$3) {
        super(0);
        this.this$0 = messageQueue$processNextRequest$listener$1$3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        MessageQueue.access$getExecutorService$p(this.this$0.this$0.this$0).submit(new MessageQueue$processNextRequest$listener$1$3$1$1(this));
    }
}
