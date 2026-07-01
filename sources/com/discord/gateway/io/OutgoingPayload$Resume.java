package com.discord.gateway.io;


/* JADX INFO: compiled from: Outgoing.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OutgoingPayload$Resume extends OutgoingPayload {
    private final int seq;
    private final String sessionId;
    private final String token;

    public OutgoingPayload$Resume(String str, String str2, int i) {
        super(null);
        this.token = str;
        this.sessionId = str2;
        this.seq = i;
    }
}
