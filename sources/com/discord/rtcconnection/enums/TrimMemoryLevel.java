package com.discord.rtcconnection.enums;


/* JADX INFO: compiled from: TrimMemoryLevel.kt */
/* JADX INFO: loaded from: classes.dex */
public enum TrimMemoryLevel {
    Background(40),
    RunningModerate(5),
    Moderate(60),
    RunningLow(10),
    Complete(80),
    RunningCritical(15),
    UiHidden(20);

    public static final TrimMemoryLevel$a Companion = new TrimMemoryLevel$a(null);
    private final int value;

    TrimMemoryLevel(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
