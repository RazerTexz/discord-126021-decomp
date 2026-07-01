package com.discord.gateway;

import com.discord.gateway.io.OutgoingPayload$IdentifyClientState;
import d0.z.d.m;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$IdentifyData {
    private final OutgoingPayload$IdentifyClientState clientState;
    private final String token;

    public GatewaySocket$IdentifyData(String str, OutgoingPayload$IdentifyClientState outgoingPayload$IdentifyClientState) {
        m.checkNotNullParameter(str, "token");
        this.token = str;
        this.clientState = outgoingPayload$IdentifyClientState;
    }

    public final OutgoingPayload$IdentifyClientState getClientState() {
        return this.clientState;
    }

    public final String getToken() {
        return this.token;
    }
}
