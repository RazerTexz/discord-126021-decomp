package com.discord.models.domain;

import com.discord.utilities.time.Clock;

/* JADX INFO: compiled from: NonceGenerator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NonceGenerator {
    public static final NonceGenerator$Companion Companion = new NonceGenerator$Companion(null);
    private static long previousNonce;

    public static final /* synthetic */ long access$getPreviousNonce$cp() {
        return previousNonce;
    }

    public static final /* synthetic */ void access$setPreviousNonce$cp(long j) {
        previousNonce = j;
    }

    public static final synchronized long computeNonce(Clock clock) {
        return Companion.computeNonce(clock);
    }

    public final long nonce() {
        return NonceGenerator$Companion.computeNonce$default(Companion, null, 1, null);
    }
}
