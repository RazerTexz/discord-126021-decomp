package com.discord.gateway.io;

import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: Outgoing.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OutgoingPayload$Identify extends OutgoingPayload {
    private final long capabilities;
    private final OutgoingPayload$IdentifyClientState clientState;
    private final boolean compress;
    private final int largeThreshold;
    private final Map<String, Object> properties;
    private final String token;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutgoingPayload$Identify(String str, int i, boolean z2, long j, Map<String, ? extends Object> map, OutgoingPayload$IdentifyClientState outgoingPayload$IdentifyClientState) {
        super(null);
        m.checkNotNullParameter(str, "token");
        m.checkNotNullParameter(map, "properties");
        this.token = str;
        this.largeThreshold = i;
        this.compress = z2;
        this.capabilities = j;
        this.properties = map;
        this.clientState = outgoingPayload$IdentifyClientState;
    }
}
