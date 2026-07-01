package com.discord.utilities.messagesend;

import d0.z.d.m;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$DrainListener {
    private AtomicBoolean isCompleted;
    private final Function1<MessageResult, Unit> onCompleted;

    /* JADX WARN: Multi-variable type inference failed */
    public MessageQueue$DrainListener(Function1<? super MessageResult, Unit> function1) {
        m.checkNotNullParameter(function1, "onCompleted");
        this.onCompleted = function1;
        this.isCompleted = new AtomicBoolean(false);
    }

    public final synchronized void complete(MessageResult result) {
        m.checkNotNullParameter(result, "result");
        if (!this.isCompleted.getAndSet(true)) {
            this.onCompleted.invoke(result);
        }
    }
}
