package com.discord.models.domain;

import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NonceGenerator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NonceGenerator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static long previousNonce;

    /* JADX INFO: compiled from: NonceGenerator.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ long computeNonce$default(Companion companion, Clock clock, int i, Object obj) {
            if ((i & 1) != 0) {
                clock = ClockFactory.get();
            }
            return companion.computeNonce(clock);
        }

        public final synchronized long computeNonce(Clock clock) {
            long jCurrentTimeMillis;
            Intrinsics3.checkNotNullParameter(clock, "clock");
            jCurrentTimeMillis = ((clock.currentTimeMillis() + 1471228928) - SnowflakeUtils.DISCORD_EPOCH) << 22;
            if (jCurrentTimeMillis <= NonceGenerator.previousNonce) {
                jCurrentTimeMillis = NonceGenerator.previousNonce + 1;
            }
            NonceGenerator.previousNonce = jCurrentTimeMillis;
            return jCurrentTimeMillis;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final synchronized long computeNonce(Clock clock) {
        return INSTANCE.computeNonce(clock);
    }

    public final long nonce() {
        return Companion.computeNonce$default(INSTANCE, null, 1, null);
    }
}
