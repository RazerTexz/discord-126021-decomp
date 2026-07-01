package com.discord.rtcconnection.enums;


/* JADX INFO: compiled from: ScoAudioState.kt */
/* JADX INFO: loaded from: classes.dex */
public enum ScoAudioState {
    Disconnected(0),
    Connected(1),
    Connecting(2),
    Error(-1);

    public static final ScoAudioState$a Companion = new ScoAudioState$a(null);
    private final int value;

    ScoAudioState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
