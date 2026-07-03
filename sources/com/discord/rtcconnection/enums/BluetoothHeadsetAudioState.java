package com.discord.rtcconnection.enums;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: BluetoothHeadsetAudioState.kt */
/* JADX INFO: loaded from: classes.dex */
public enum BluetoothHeadsetAudioState {
    Disconnected(10),
    Connecting(11),
    Connected(12);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* JADX INFO: renamed from: com.discord.rtcconnection.enums.BluetoothHeadsetAudioState$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: BluetoothHeadsetAudioState.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final BluetoothHeadsetAudioState m8494a(int i) {
            BluetoothHeadsetAudioState[] bluetoothHeadsetAudioStateArrValues = BluetoothHeadsetAudioState.values();
            for (int i2 = 0; i2 < 3; i2++) {
                BluetoothHeadsetAudioState bluetoothHeadsetAudioState = bluetoothHeadsetAudioStateArrValues[i2];
                if (bluetoothHeadsetAudioState.getValue() == i) {
                    return bluetoothHeadsetAudioState;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: b */
        public final C5633b m8495b(Intent intent) {
            C12238m.checkNotNullParameter(intent, "intent");
            if (!C12238m.areEqual(intent.getAction(), "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            C12238m.checkNotNullParameter(intent, "$this$getBluetoothDeviceExtra");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            Integer numM588x0 = C1460d.m588x0(intent, "android.bluetooth.profile.extra.PREVIOUS_STATE");
            BluetoothHeadsetAudioState bluetoothHeadsetAudioStateM8494a = numM588x0 != null ? BluetoothHeadsetAudioState.INSTANCE.m8494a(numM588x0.intValue()) : null;
            Integer numM588x1 = C1460d.m588x0(intent, "android.bluetooth.profile.extra.STATE");
            return new C5633b(numM588x1 != null ? BluetoothHeadsetAudioState.INSTANCE.m8494a(numM588x1.intValue()) : null, bluetoothHeadsetAudioStateM8494a, bluetoothDevice);
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.enums.BluetoothHeadsetAudioState$b */
    /* JADX INFO: compiled from: BluetoothHeadsetAudioState.kt */
    public static final class C5633b {

        /* JADX INFO: renamed from: a */
        public final BluetoothHeadsetAudioState f18868a;

        /* JADX INFO: renamed from: b */
        public final BluetoothHeadsetAudioState f18869b;

        /* JADX INFO: renamed from: c */
        public final BluetoothDevice f18870c;

        public C5633b(BluetoothHeadsetAudioState bluetoothHeadsetAudioState, BluetoothHeadsetAudioState bluetoothHeadsetAudioState2, BluetoothDevice bluetoothDevice) {
            this.f18868a = bluetoothHeadsetAudioState;
            this.f18869b = bluetoothHeadsetAudioState2;
            this.f18870c = bluetoothDevice;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C5633b)) {
                return false;
            }
            C5633b c5633b = (C5633b) obj;
            return C12238m.areEqual(this.f18868a, c5633b.f18868a) && C12238m.areEqual(this.f18869b, c5633b.f18869b) && C12238m.areEqual(this.f18870c, c5633b.f18870c);
        }

        public int hashCode() {
            BluetoothHeadsetAudioState bluetoothHeadsetAudioState = this.f18868a;
            int iHashCode = (bluetoothHeadsetAudioState != null ? bluetoothHeadsetAudioState.hashCode() : 0) * 31;
            BluetoothHeadsetAudioState bluetoothHeadsetAudioState2 = this.f18869b;
            int iHashCode2 = (iHashCode + (bluetoothHeadsetAudioState2 != null ? bluetoothHeadsetAudioState2.hashCode() : 0)) * 31;
            BluetoothDevice bluetoothDevice = this.f18870c;
            return iHashCode2 + (bluetoothDevice != null ? bluetoothDevice.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Update(current=");
            sbM833U.append(this.f18868a);
            sbM833U.append(", previous=");
            sbM833U.append(this.f18869b);
            sbM833U.append(", device=");
            sbM833U.append(this.f18870c);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    BluetoothHeadsetAudioState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
