package com.discord.gateway;

import d0.z.d.m;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class GatewaySocket$DefaultListener implements GatewaySocket$Listener {
    @Override // com.discord.gateway.GatewaySocket$Listener
    public void onConnected(GatewaySocket gatewaySocket) {
        m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
    }

    @Override // com.discord.gateway.GatewaySocket$Listener
    public void onConnecting(GatewaySocket gatewaySocket) {
        m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
    }

    @Override // com.discord.gateway.GatewaySocket$Listener
    public void onDisconnected(GatewaySocket gatewaySocket) {
        m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
    }

    @Override // com.discord.gateway.GatewaySocket$Listener
    public void onHello(GatewaySocket gatewaySocket) {
        m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
    }
}
