package com.discord.rtcconnection.audio;


/* JADX INFO: compiled from: DiscordAudioManager.kt */
/* JADX INFO: loaded from: classes.dex */
public enum DiscordAudioManager$DeviceTypes {
    DEFAULT(-2),
    INVALID(-1),
    SPEAKERPHONE(0),
    WIRED_HEADSET(1),
    EARPIECE(2),
    BLUETOOTH_HEADSET(3);

    private final int value;

    DiscordAudioManager$DeviceTypes(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
