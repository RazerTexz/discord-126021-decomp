package com.discord.rtcconnection.enums;


/* JADX INFO: compiled from: BluetoothBroadcastAction.kt */
/* JADX INFO: loaded from: classes.dex */
public enum BluetoothBroadcastAction {
    HeadsetConnectionStateChanged("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"),
    HeadsetAudioStateChanged("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED"),
    AdapterConnectionStateChanged("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED"),
    AdapterStateChanged("android.bluetooth.adapter.action.STATE_CHANGED"),
    ActiveDeviceChanged("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED");

    public static final BluetoothBroadcastAction$a Companion = new BluetoothBroadcastAction$a(null);
    private final String action;

    BluetoothBroadcastAction(String str) {
        this.action = str;
    }

    public final String getAction() {
        return this.action;
    }
}
