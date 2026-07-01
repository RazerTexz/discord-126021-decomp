package com.discord.utilities.voice;


/* JADX INFO: compiled from: Bitrate.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum Bitrate {
    MIN(8),
    DEFAULT(64),
    MAX(96),
    PREMIUM_TIER_1(128),
    PREMIUM_TIER_2(256),
    PREMIUM_TIER_3(384);

    private final int kbps;

    Bitrate(int i) {
        this.kbps = i;
    }

    public final int getKbps() {
        return this.kbps;
    }
}
