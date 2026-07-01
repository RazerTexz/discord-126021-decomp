package com.discord.models.domain;

import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NonceGenerator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NonceGenerator$Companion {
    private NonceGenerator$Companion() {
    }

    public static /* synthetic */ long computeNonce$default(NonceGenerator$Companion nonceGenerator$Companion, Clock clock, int i, Object obj) {
        if ((i & 1) != 0) {
            clock = ClockFactory.get();
        }
        return nonceGenerator$Companion.computeNonce(clock);
    }

    public final synchronized long computeNonce(Clock clock) {
        long jCurrentTimeMillis;
        m.checkNotNullParameter(clock, "clock");
        jCurrentTimeMillis = ((clock.currentTimeMillis() + 1471228928) - SnowflakeUtils.DISCORD_EPOCH) << 22;
        if (jCurrentTimeMillis <= NonceGenerator.access$getPreviousNonce$cp()) {
            jCurrentTimeMillis = NonceGenerator.access$getPreviousNonce$cp() + 1;
        }
        NonceGenerator.access$setPreviousNonce$cp(jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    public /* synthetic */ NonceGenerator$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
