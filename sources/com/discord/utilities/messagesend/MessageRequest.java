package com.discord.utilities.messagesend;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MessageRequest {
    private final long attemptTimestamp;
    private final Function2<MessageResult, Boolean, Unit> onCompleted;
    private final String requestId;

    /* JADX WARN: Multi-variable type inference failed */
    private MessageRequest(String str, Function2<? super MessageResult, ? super Boolean, Unit> function2, long j) {
        this.requestId = str;
        this.onCompleted = function2;
        this.attemptTimestamp = j;
    }

    public final long getAttemptTimestamp() {
        return this.attemptTimestamp;
    }

    public final Function2<MessageResult, Boolean, Unit> getOnCompleted() {
        return this.onCompleted;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public /* synthetic */ MessageRequest(String str, Function2 function2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function2, j);
    }
}
