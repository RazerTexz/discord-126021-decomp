package com.discord.utilities.messagesend;


/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$processNextRequest$listener$1$4 implements Runnable {
    public final /* synthetic */ MessageResult $result;
    public final /* synthetic */ MessageQueue$processNextRequest$listener$1 this$0;

    public MessageQueue$processNextRequest$listener$1$4(MessageQueue$processNextRequest$listener$1 messageQueue$processNextRequest$listener$1, MessageResult messageResult) {
        this.this$0 = messageQueue$processNextRequest$listener$1;
        this.$result = messageResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MessageQueue.access$onDrainingCompleted(this.this$0.this$0);
        this.this$0.$request.getOnCompleted().invoke(this.$result, Boolean.valueOf(MessageQueue.access$getQueue$p(this.this$0.this$0).isEmpty()));
        MessageQueue.access$getNetworkBackoff$p(this.this$0.this$0).succeed();
        MessageQueue.access$processNextRequest(this.this$0.this$0);
    }
}
