package com.discord.utilities.messagesend;


/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$enqueue$1 implements Runnable {
    public final /* synthetic */ MessageRequest $request;
    public final /* synthetic */ MessageQueue this$0;

    public MessageQueue$enqueue$1(MessageQueue messageQueue, MessageRequest messageRequest) {
        this.this$0 = messageQueue;
        this.$request = messageRequest;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MessageQueue.access$getQueue$p(this.this$0).add(this.$request);
        MessageQueue.access$processNextRequest(this.this$0);
    }
}
