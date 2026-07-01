package com.discord.rtcconnection.enums;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

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

        public final b b(Intent intent) {
            Intrinsics3.checkNotNullParameter(intent, "intent");
            if (!Intrinsics3.areEqual(intent.getAction(), "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            Intrinsics3.checkNotNullParameter(intent, "$this$getBluetoothDeviceExtra");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            Integer numX0 = AnimatableValueParser.x0(intent, "android.bluetooth.profile.extra.PREVIOUS_STATE");
            BluetoothHeadsetAudioState bluetoothHeadsetAudioStateA = numX0 != null ? BluetoothHeadsetAudioState.INSTANCE.a(numX0.intValue()) : null;
            Integer numX1 = AnimatableValueParser.x0(intent, "android.bluetooth.profile.extra.STATE");
            return new b(numX1 != null ? BluetoothHeadsetAudioState.INSTANCE.a(numX1.intValue()) : null, bluetoothHeadsetAudioStateA, bluetoothDevice);
        }
    }

    /* JADX INFO: compiled from: BluetoothHeadsetAudioState.kt */
    public static final class b {
        public final BluetoothHeadsetAudioState a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BluetoothHeadsetAudioState f2790b;
        public final BluetoothDevice c;

        public b(BluetoothHeadsetAudioState bluetoothHeadsetAudioState, BluetoothHeadsetAudioState bluetoothHeadsetAudioState2, BluetoothDevice bluetoothDevice) {
            this.a = bluetoothHeadsetAudioState;
            this.f2790b = bluetoothHeadsetAudioState2;
            this.c = bluetoothDevice;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics3.areEqual(this.a, bVar.a) && Intrinsics3.areEqual(this.f2790b, bVar.f2790b) && Intrinsics3.areEqual(this.c, bVar.c);
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
            StringBuilder sbU = outline.U("Update(current=");
            sbU.append(this.a);
            sbU.append(", previous=");
            sbU.append(this.f2790b);
            sbU.append(", device=");
            sbU.append(this.c);
            sbU.append(")");
            return sbU.toString();
        }
    }

    BluetoothHeadsetAudioState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
