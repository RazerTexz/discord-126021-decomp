package com.discord.utilities.messagesend;

import d0.z.d.m;
import rx.Subscription;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$InflightRequest {
    private final MessageRequest baseRequest;
    private final MessageQueue$DrainListener drainListener;
    private final Subscription networkSubscription;

    public MessageQueue$InflightRequest(MessageRequest messageRequest, Subscription subscription, MessageQueue$DrainListener messageQueue$DrainListener) {
        m.checkNotNullParameter(messageRequest, "baseRequest");
        m.checkNotNullParameter(subscription, "networkSubscription");
        m.checkNotNullParameter(messageQueue$DrainListener, "drainListener");
        this.baseRequest = messageRequest;
        this.networkSubscription = subscription;
        this.drainListener = messageQueue$DrainListener;
    }

    public final MessageRequest getBaseRequest() {
        return this.baseRequest;
    }

    public final MessageQueue$DrainListener getDrainListener() {
        return this.drainListener;
    }

    public final Subscription getNetworkSubscription() {
        return this.networkSubscription;
    }
}
