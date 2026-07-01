package com.discord.utilities.messagesend;


/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$processNextRequest$listener$1$3 implements Runnable {
    public final /* synthetic */ MessageQueue$processNextRequest$listener$1 this$0;

    public MessageQueue$processNextRequest$listener$1$3(MessageQueue$processNextRequest$listener$1 messageQueue$processNextRequest$listener$1) {
        this.this$0 = messageQueue$processNextRequest$listener$1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MessageQueue.access$onDrainingCompleted(this.this$0.this$0);
        MessageQueue.access$getQueue$p(this.this$0.this$0).addFirst(this.this$0.$request);
        MessageQueue.access$getNetworkBackoff$p(this.this$0.this$0).fail(new MessageQueue$processNextRequest$listener$1$3$1(this));
    }
}
