package com.discord.utilities.messagesend;

import android.content.Context;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$processNextRequest$listener$1 extends o implements Function1<MessageResult, Unit> {
    public final /* synthetic */ MessageRequest $request;
    public final /* synthetic */ MessageQueue this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageQueue$processNextRequest$listener$1(MessageQueue messageQueue, MessageRequest messageRequest) {
        super(1);
        this.this$0 = messageQueue;
        this.$request = messageRequest;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult) {
        invoke2(messageResult);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageResult messageResult) {
        m.checkNotNullParameter(messageResult, "result");
        if (!(messageResult instanceof MessageResult$RateLimited)) {
            if (messageResult instanceof MessageResult$NetworkFailure) {
                MessageQueue.access$getExecutorService$p(this.this$0).submit(new MessageQueue$processNextRequest$listener$1$3(this));
                return;
            } else {
                MessageQueue.access$getExecutorService$p(this.this$0).submit(new MessageQueue$processNextRequest$listener$1$4(this, messageResult));
                return;
            }
        }
        Observable<Long> observableD0 = Observable.d0(((MessageResult$RateLimited) messageResult).getRetryAfterMs(), TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable\n             …s, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableD0, this.this$0.getClass(), (Context) null, new MessageQueue$processNextRequest$listener$1$2(this), (Function1) null, (Function0) null, (Function0) null, new MessageQueue$processNextRequest$listener$1$1(this), 58, (Object) null);
    }
}
