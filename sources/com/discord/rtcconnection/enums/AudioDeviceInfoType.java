package com.discord.rtcconnection.enums;

import android.annotation.SuppressLint;
import d0.t.Sets5;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AudioDeviceInfoType.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"InlinedApi"})
public enum AudioDeviceInfoType {
    BuiltinEarpiece(1),
    BuiltinSpeaker(2),
    WiredHeadset(3),
    WiredHeadphones(4),
    BluetoothSco(7),
    BluetoothA2dp(8),
    Hdmi(9),
    Dock(13),
    UsbAccessory(12),
    UsbDevice(11),
    Telephony(18),
    LineAnalog(5),
    HdmiArc(10),
    LineDigital(6),
    Fm(14),
    AuxLine(19),
    Ip(20),
    BuiltinMic(15),
    FmTuner(16),
    TvTuner(17),
    Bus(21),
    UsbHeadset(22),
    HearingAid(23),
    Unknown(Integer.MIN_VALUE);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Set<AudioDeviceInfoType> supportedOutputTypes;
    private final int value;

    /* JADX INFO: renamed from: com.discord.rtcconnection.enums.AudioDeviceInfoType$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: AudioDeviceInfoType.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        AudioDeviceInfoType audioDeviceInfoType = BuiltinEarpiece;
        AudioDeviceInfoType audioDeviceInfoType2 = BuiltinSpeaker;
        AudioDeviceInfoType audioDeviceInfoType3 = WiredHeadset;
        AudioDeviceInfoType audioDeviceInfoType4 = WiredHeadphones;
        AudioDeviceInfoType audioDeviceInfoType5 = BluetoothSco;
        AudioDeviceInfoType audioDeviceInfoType6 = UsbAccessory;
        AudioDeviceInfoType audioDeviceInfoType7 = UsbDevice;
        AudioDeviceInfoType audioDeviceInfoType8 = UsbHeadset;
        INSTANCE = new Companion(null);
        supportedOutputTypes = Sets5.setOf((Object[]) new AudioDeviceInfoType[]{audioDeviceInfoType, audioDeviceInfoType2, audioDeviceInfoType5, audioDeviceInfoType3, audioDeviceInfoType4, audioDeviceInfoType6, audioDeviceInfoType7, audioDeviceInfoType8});
    }

    AudioDeviceInfoType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public final boolean isInputType() {
        Companion companion = INSTANCE;
        int i = this.value;
        Objects.requireNonNull(companion);
        switch (i) {
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 17:
            case 18:
            case 20:
            case 21:
            case 22:
                return true;
            case 4:
            case 10:
            case 14:
            case 19:
            default:
                return false;
        }
    }

    public final boolean isOutputType() {
        Companion companion = INSTANCE;
        int i = this.value;
        Objects.requireNonNull(companion);
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                return true;
            case 15:
            case 16:
            case 17:
            default:
                return false;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return super.toString() + "(value=" + this.value + ", isInputType=" + isInputType() + ", isOutputType=" + isOutputType() + ')';
    }
}
