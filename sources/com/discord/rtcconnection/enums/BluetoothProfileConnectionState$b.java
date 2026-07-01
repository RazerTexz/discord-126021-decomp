package com.discord.rtcconnection.enums;

import android.bluetooth.BluetoothDevice;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: BluetoothProfileConnectionState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BluetoothProfileConnectionState$b {
    public final BluetoothProfileConnectionState a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BluetoothProfileConnectionState f2791b;
    public final BluetoothDevice c;

    public BluetoothProfileConnectionState$b(BluetoothProfileConnectionState bluetoothProfileConnectionState, BluetoothProfileConnectionState bluetoothProfileConnectionState2, BluetoothDevice bluetoothDevice) {
        this.a = bluetoothProfileConnectionState;
        this.f2791b = bluetoothProfileConnectionState2;
        this.c = bluetoothDevice;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BluetoothProfileConnectionState$b)) {
            return false;
        }
        BluetoothProfileConnectionState$b bluetoothProfileConnectionState$b = (BluetoothProfileConnectionState$b) obj;
        return m.areEqual(this.a, bluetoothProfileConnectionState$b.a) && m.areEqual(this.f2791b, bluetoothProfileConnectionState$b.f2791b) && m.areEqual(this.c, bluetoothProfileConnectionState$b.c);
    }

    public int hashCode() {
        BluetoothProfileConnectionState bluetoothProfileConnectionState = this.a;
        int iHashCode = (bluetoothProfileConnectionState != null ? bluetoothProfileConnectionState.hashCode() : 0) * 31;
        BluetoothProfileConnectionState bluetoothProfileConnectionState2 = this.f2791b;
        int iHashCode2 = (iHashCode + (bluetoothProfileConnectionState2 != null ? bluetoothProfileConnectionState2.hashCode() : 0)) * 31;
        BluetoothDevice bluetoothDevice = this.c;
        return iHashCode2 + (bluetoothDevice != null ? bluetoothDevice.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Update(previous=");
        sbU.append(this.a);
        sbU.append(", current=");
        sbU.append(this.f2791b);
        sbU.append(", device=");
        sbU.append(this.c);
        sbU.append(")");
        return sbU.toString();
    }
}
