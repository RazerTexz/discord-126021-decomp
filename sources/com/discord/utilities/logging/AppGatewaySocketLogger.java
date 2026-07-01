package com.discord.utilities.logging;

import com.discord.gateway.GatewaySocketLogger;
import com.discord.gateway.GatewaySocketLogger$LogLevel;
import d0.z.d.m;

/* JADX INFO: compiled from: AppGatewaySocketLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppGatewaySocketLogger implements GatewaySocketLogger {
    public static final AppGatewaySocketLogger$Companion Companion = new AppGatewaySocketLogger$Companion(null);
    private static final AppGatewaySocketLogger INSTANCE = new AppGatewaySocketLogger();
    private final GatewaySocketLogger$LogLevel logLevel = GatewaySocketLogger$LogLevel.NONE;

    public static final /* synthetic */ AppGatewaySocketLogger access$getINSTANCE$cp() {
        return INSTANCE;
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public GatewaySocketLogger$LogLevel getLogLevel() {
        return this.logLevel;
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public void logInboundMessage(String rawMessage) {
        m.checkNotNullParameter(rawMessage, "rawMessage");
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public void logMessageInflateFailed(Throwable throwable) {
        m.checkNotNullParameter(throwable, "throwable");
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public void logOutboundMessage(String rawMessage) {
        m.checkNotNullParameter(rawMessage, "rawMessage");
    }
}
