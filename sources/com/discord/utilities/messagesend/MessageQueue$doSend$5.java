package com.discord.utilities.messagesend;

import com.discord.utilities.analytics.Traits$Payment$Type;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$doSend$5 extends o implements Function1<Subscription, Unit> {
    public final /* synthetic */ MessageQueue$DrainListener $drainListener;
    public final /* synthetic */ MessageRequest$Send $request;
    public final /* synthetic */ MessageQueue this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageQueue$doSend$5(MessageQueue messageQueue, MessageRequest$Send messageRequest$Send, MessageQueue$DrainListener messageQueue$DrainListener) {
        super(1);
        this.this$0 = messageQueue;
        this.$request = messageRequest$Send;
        this.$drainListener = messageQueue$DrainListener;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        m.checkNotNullParameter(subscription, Traits$Payment$Type.SUBSCRIPTION);
        MessageQueue.access$setInFlightRequest$p(this.this$0, new MessageQueue$InflightRequest(this.$request, subscription, this.$drainListener));
    }
}
