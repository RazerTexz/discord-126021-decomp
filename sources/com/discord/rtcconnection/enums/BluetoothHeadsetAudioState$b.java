package com.discord.rtcconnection.enums;

import android.bluetooth.BluetoothDevice;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: BluetoothHeadsetAudioState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BluetoothHeadsetAudioState$b {
    public final BluetoothHeadsetAudioState a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BluetoothHeadsetAudioState f2790b;
    public final BluetoothDevice c;

    public BluetoothHeadsetAudioState$b(BluetoothHeadsetAudioState bluetoothHeadsetAudioState, BluetoothHeadsetAudioState bluetoothHeadsetAudioState2, BluetoothDevice bluetoothDevice) {
        this.a = bluetoothHeadsetAudioState;
        this.f2790b = bluetoothHeadsetAudioState2;
        this.c = bluetoothDevice;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BluetoothHeadsetAudioState$b)) {
            return false;
        }
        BluetoothHeadsetAudioState$b bluetoothHeadsetAudioState$b = (BluetoothHeadsetAudioState$b) obj;
        return m.areEqual(this.a, bluetoothHeadsetAudioState$b.a) && m.areEqual(this.f2790b, bluetoothHeadsetAudioState$b.f2790b) && m.areEqual(this.c, bluetoothHeadsetAudioState$b.c);
    }

    public int hashCode() {
        BluetoothHeadsetAudioState bluetoothHeadsetAudioState = this.a;
        int iHashCode = (bluetoothHeadsetAudioState != null ? bluetoothHeadsetAudioState.hashCode() : 0) * 31;
        BluetoothHeadsetAudioState bluetoothHeadsetAudioState2 = this.f2790b;
        int iHashCode2 = (iHashCode + (bluetoothHeadsetAudioState2 != null ? bluetoothHeadsetAudioState2.hashCode() : 0)) * 31;
        BluetoothDevice bluetoothDevice = this.c;
        return iHashCode2 + (bluetoothDevice != null ? bluetoothDevice.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Update(current=");
        sbU.append(this.a);
        sbU.append(", previous=");
        sbU.append(this.f2790b);
        sbU.append(", device=");
        sbU.append(this.c);
        sbU.append(")");
        return sbU.toString();
    }
}
