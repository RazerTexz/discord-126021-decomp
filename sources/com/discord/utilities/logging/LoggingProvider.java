package com.discord.utilities.logging;

import d0.z.d.m;

/* JADX INFO: compiled from: LoggingProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LoggingProvider {
    public static final LoggingProvider INSTANCE = new LoggingProvider();
    private static Logger logger;

    private LoggingProvider() {
    }

    public final Logger get() {
        Logger logger2 = logger;
        if (logger2 == null) {
            m.throwUninitializedPropertyAccessException("logger");
        }
        return logger2;
    }

    public final void init(Logger logger2) {
        m.checkNotNullParameter(logger2, "logger");
        logger = logger2;
    }
}
