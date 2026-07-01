package com.discord.rtcconnection.enums;


/* JADX INFO: compiled from: BluetoothProfileConnectionState.kt */
/* JADX INFO: loaded from: classes.dex */
public enum BluetoothProfileConnectionState {
    Disconnected(0),
    Connecting(1),
    Connected(2),
    Disconnecting(3);

    public static final BluetoothProfileConnectionState$a Companion = new BluetoothProfileConnectionState$a(null);
    private final int value;

    BluetoothProfileConnectionState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
