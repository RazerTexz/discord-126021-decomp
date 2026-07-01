package com.discord.rtcconnection.audio;


/* JADX INFO: compiled from: DiscordAudioManager.kt */
/* JADX INFO: loaded from: classes.dex */
public enum DiscordAudioManager$BluetoothScoState {
    INVALID(-1),
    OFF(0),
    ON(1),
    TURNING_ON(2),
    TURNING_OFF(3);

    private final int value;

    DiscordAudioManager$BluetoothScoState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
