package com.discord.gateway;


/* JADX INFO: compiled from: GatewaySocketLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public interface GatewaySocketLogger {

    /* JADX INFO: compiled from: GatewaySocketLogger.kt */
    public enum LogLevel {
        NONE,
        VERBOSE
    }

    LogLevel getLogLevel();

    void logInboundMessage(String rawMessage);

    void logMessageInflateFailed(Throwable throwable);

    void logOutboundMessage(String rawMessage);
}
