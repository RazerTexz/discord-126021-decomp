package com.discord.stores;

import com.discord.gateway.GatewaySocket;
import com.discord.gateway.GatewaySocket$DefaultListener;
import d0.z.d.m;

/* JADX INFO: compiled from: ConnectionTimeStats.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionTimeStats$addListener$1 extends GatewaySocket$DefaultListener {
    public final /* synthetic */ ConnectionTimeStats this$0;

    public ConnectionTimeStats$addListener$1(ConnectionTimeStats connectionTimeStats) {
        this.this$0 = connectionTimeStats;
    }

    @Override // com.discord.gateway.GatewaySocket$DefaultListener, com.discord.gateway.GatewaySocket$Listener
    public void onConnected(GatewaySocket gatewaySocket) {
        m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        ConnectionTimeStats$Stat.end$default(ConnectionTimeStats.access$getGatewayConnection$p(this.this$0), false, 1, null);
        ConnectionTimeStats$Stat.start$default(ConnectionTimeStats.access$getGatewayHello$p(this.this$0), false, 1, null);
    }

    @Override // com.discord.gateway.GatewaySocket$DefaultListener, com.discord.gateway.GatewaySocket$Listener
    public void onConnecting(GatewaySocket gatewaySocket) {
        m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        ConnectionTimeStats$Stat.start$default(ConnectionTimeStats.access$getGatewayConnection$p(this.this$0), false, 1, null);
    }

    @Override // com.discord.gateway.GatewaySocket$DefaultListener, com.discord.gateway.GatewaySocket$Listener
    public void onDisconnected(GatewaySocket gatewaySocket) {
        m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        ConnectionTimeStats.access$getGatewayConnection$p(this.this$0).clear();
        ConnectionTimeStats.access$getGatewayHello$p(this.this$0).clear();
    }

    @Override // com.discord.gateway.GatewaySocket$DefaultListener, com.discord.gateway.GatewaySocket$Listener
    public void onHello(GatewaySocket gatewaySocket) {
        m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        ConnectionTimeStats$Stat.end$default(ConnectionTimeStats.access$getGatewayHello$p(this.this$0), false, 1, null);
    }
}
