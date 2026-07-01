package com.discord.gateway.io;

import d0.z.d.m;

/* JADX INFO: compiled from: Outgoing.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OutgoingPayload$StreamPing extends OutgoingPayload {
    private final String streamKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutgoingPayload$StreamPing(String str) {
        super(null);
        m.checkNotNullParameter(str, "streamKey");
        this.streamKey = str;
    }

    public final String getStreamKey() {
        return this.streamKey;
    }
}
