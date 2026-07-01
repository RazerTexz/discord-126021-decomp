package com.discord.gateway;

import b.d.b.a.a;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.time.ClockFactory;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$Companion {
    private GatewaySocket$Companion() {
    }

    public static final /* synthetic */ void access$log(GatewaySocket$Companion gatewaySocket$Companion, Logger logger, String str, boolean z2) {
        gatewaySocket$Companion.log(logger, str, z2);
    }

    private final long getDelay(long startTime, Long currentTime) {
        return (currentTime != null ? currentTime.longValue() : ClockFactory.get().currentTimeMillis()) - startTime;
    }

    public static /* synthetic */ long getDelay$default(GatewaySocket$Companion gatewaySocket$Companion, long j, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return gatewaySocket$Companion.getDelay(j, l);
    }

    private final void log(Logger logger, String str, boolean z2) {
        Logger.v$default(logger, a.w("[GatewaySocket] ", str), null, 2, null);
        if (z2) {
            logger.recordBreadcrumb("Gateway [" + str + ']', "log");
        }
    }

    public static /* synthetic */ void log$default(GatewaySocket$Companion gatewaySocket$Companion, Logger logger, String str, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        gatewaySocket$Companion.log(logger, str, z2);
    }

    public /* synthetic */ GatewaySocket$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
