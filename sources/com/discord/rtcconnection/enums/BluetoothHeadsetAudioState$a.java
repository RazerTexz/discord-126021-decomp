package com.discord.rtcconnection.enums;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import b.c.a.a0.d;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BluetoothHeadsetAudioState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BluetoothHeadsetAudioState$a {
    public BluetoothHeadsetAudioState$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final BluetoothHeadsetAudioState a(int i) {
        BluetoothHeadsetAudioState[] bluetoothHeadsetAudioStateArrValues = BluetoothHeadsetAudioState.values();
        for (int i2 = 0; i2 < 3; i2++) {
            BluetoothHeadsetAudioState bluetoothHeadsetAudioState = bluetoothHeadsetAudioStateArrValues[i2];
            if (bluetoothHeadsetAudioState.getValue() == i) {
                return bluetoothHeadsetAudioState;
            }
        }
        return null;
    }

    public final BluetoothHeadsetAudioState$b b(Intent intent) {
        m.checkNotNullParameter(intent, "intent");
        if (!m.areEqual(intent.getAction(), "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        m.checkNotNullParameter(intent, "$this$getBluetoothDeviceExtra");
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        Integer numX0 = d.x0(intent, "android.bluetooth.profile.extra.PREVIOUS_STATE");
        BluetoothHeadsetAudioState bluetoothHeadsetAudioStateA = numX0 != null ? BluetoothHeadsetAudioState.Companion.a(numX0.intValue()) : null;
        Integer numX1 = d.x0(intent, "android.bluetooth.profile.extra.STATE");
        return new BluetoothHeadsetAudioState$b(numX1 != null ? BluetoothHeadsetAudioState.Companion.a(numX1.intValue()) : null, bluetoothHeadsetAudioStateA, bluetoothDevice);
    }
}
