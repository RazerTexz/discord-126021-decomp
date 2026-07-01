package com.discord.utilities.messagesend;

import d0.z.d.m;
import java.util.Iterator;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$cancel$1 implements Runnable {
    public final /* synthetic */ String $requestId;
    public final /* synthetic */ MessageQueue this$0;

    public MessageQueue$cancel$1(MessageQueue messageQueue, String str) {
        this.this$0 = messageQueue;
        this.$requestId = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object next;
        MessageQueue$InflightRequest messageQueue$InflightRequestAccess$getInFlightRequest$p = MessageQueue.access$getInFlightRequest$p(this.this$0);
        if (messageQueue$InflightRequestAccess$getInFlightRequest$p != null && m.areEqual(messageQueue$InflightRequestAccess$getInFlightRequest$p.getBaseRequest().getRequestId(), this.$requestId)) {
            messageQueue$InflightRequestAccess$getInFlightRequest$p.getNetworkSubscription().unsubscribe();
            messageQueue$InflightRequestAccess$getInFlightRequest$p.getDrainListener().complete(MessageResult$UserCancelled.INSTANCE);
            return;
        }
        Iterator it = MessageQueue.access$getQueue$p(this.this$0).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!m.areEqual(((MessageRequest) next).getRequestId(), this.$requestId));
        MessageRequest messageRequest = (MessageRequest) next;
        if (messageRequest != null) {
            MessageQueue.access$getQueue$p(this.this$0).remove(messageRequest);
            messageRequest.getOnCompleted().invoke(MessageResult$UserCancelled.INSTANCE, Boolean.valueOf(MessageQueue.access$getQueue$p(this.this$0).isEmpty()));
        }
    }
}
