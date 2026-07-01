package com.discord.rtcconnection.enums;


/* JADX INFO: compiled from: BluetoothHeadsetAudioState.kt */
/* JADX INFO: loaded from: classes.dex */
public enum BluetoothHeadsetAudioState {
    Disconnected(10),
    Connecting(11),
    Connected(12);

    public static final BluetoothHeadsetAudioState$a Companion = new BluetoothHeadsetAudioState$a(null);
    private final int value;

    BluetoothHeadsetAudioState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
