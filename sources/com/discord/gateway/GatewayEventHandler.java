package com.discord.gateway;


/* JADX INFO: compiled from: GatewayEventHandler.kt */
/* JADX INFO: loaded from: classes.dex */
public interface GatewayEventHandler {
    void handleConnected(boolean connected);

    void handleConnectionReady(boolean connectionReady);

    void handleDisconnect(boolean authenticationFailed);

    void handleDispatch(String type, Object data);
}
