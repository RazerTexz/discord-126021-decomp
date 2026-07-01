package com.discord.rtcconnection.enums;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import b.c.a.a0.d;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BluetoothProfileConnectionState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BluetoothProfileConnectionState$a {
    public BluetoothProfileConnectionState$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final BluetoothProfileConnectionState a(int i) {
        BluetoothProfileConnectionState[] bluetoothProfileConnectionStateArrValues = BluetoothProfileConnectionState.values();
        for (int i2 = 0; i2 < 4; i2++) {
            BluetoothProfileConnectionState bluetoothProfileConnectionState = bluetoothProfileConnectionStateArrValues[i2];
            if (bluetoothProfileConnectionState.getValue() == i) {
                return bluetoothProfileConnectionState;
            }
        }
        return null;
    }

    public final BluetoothProfileConnectionState$b b(Intent intent) {
        m.checkNotNullParameter(intent, "intent");
        if (!m.areEqual(intent.getAction(), "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Integer numX0 = d.x0(intent, "android.bluetooth.profile.extra.PREVIOUS_STATE");
        BluetoothProfileConnectionState bluetoothProfileConnectionStateA = numX0 != null ? BluetoothProfileConnectionState.Companion.a(numX0.intValue()) : null;
        Integer numX1 = d.x0(intent, "android.bluetooth.profile.extra.STATE");
        return new BluetoothProfileConnectionState$b(bluetoothProfileConnectionStateA, numX1 != null ? BluetoothProfileConnectionState.Companion.a(numX1.intValue()) : null, (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"));
    }
}
