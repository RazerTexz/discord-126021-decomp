package com.discord.rtcconnection.enums;


/* JADX INFO: compiled from: BluetoothAdapterConnectionState.kt */
/* JADX INFO: loaded from: classes.dex */
public enum BluetoothAdapterConnectionState {
    Disconnected(0),
    Connecting(1),
    Connected(2),
    Disconnecting(3);

    public static final BluetoothAdapterConnectionState$a Companion = new BluetoothAdapterConnectionState$a(null);
    private final int value;

    BluetoothAdapterConnectionState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
