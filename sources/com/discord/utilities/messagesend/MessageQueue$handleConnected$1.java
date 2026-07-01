package com.discord.utilities.messagesend;


/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$handleConnected$1 implements Runnable {
    public final /* synthetic */ MessageQueue this$0;

    public MessageQueue$handleConnected$1(MessageQueue messageQueue) {
        this.this$0 = messageQueue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (MessageQueue.access$getNetworkBackoff$p(this.this$0).getIsPending()) {
            MessageQueue.access$getNetworkBackoff$p(this.this$0).cancel();
            MessageQueue.access$processNextRequest(this.this$0);
        }
    }
}
