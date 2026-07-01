package com.discord.gateway;


/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public interface GatewaySocket$Listener {
    void onConnected(GatewaySocket gatewaySocket);

    void onConnecting(GatewaySocket gatewaySocket);

    void onDisconnected(GatewaySocket gatewaySocket);

    void onHello(GatewaySocket gatewaySocket);
}
