package com.discord.utilities.logging;

import com.discord.gateway.GatewaySocketLogger;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AppGatewaySocketLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppGatewaySocketLogger implements GatewaySocketLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AppGatewaySocketLogger INSTANCE = new AppGatewaySocketLogger();
    private final GatewaySocketLogger.LogLevel logLevel = GatewaySocketLogger.LogLevel.NONE;

    /* JADX INFO: compiled from: AppGatewaySocketLogger.kt */
    public static final class Companion {
        private Companion() {
        }

        public final AppGatewaySocketLogger getINSTANCE() {
            return AppGatewaySocketLogger.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public GatewaySocketLogger.LogLevel getLogLevel() {
        return this.logLevel;
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public void logInboundMessage(String rawMessage) {
        Intrinsics3.checkNotNullParameter(rawMessage, "rawMessage");
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public void logMessageInflateFailed(Throwable throwable) {
        Intrinsics3.checkNotNullParameter(throwable, "throwable");
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public void logOutboundMessage(String rawMessage) {
        Intrinsics3.checkNotNullParameter(rawMessage, "rawMessage");
    }
}
