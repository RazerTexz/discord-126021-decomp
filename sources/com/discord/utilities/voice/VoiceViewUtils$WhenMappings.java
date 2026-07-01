package com.discord.utilities.voice;

import com.discord.rtcconnection.RtcConnection$Quality;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class VoiceViewUtils$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        RtcConnection$Quality.values();
        int[] iArr = new int[4];
        $EnumSwitchMapping$0 = iArr;
        RtcConnection$Quality rtcConnection$Quality = RtcConnection$Quality.BAD;
        iArr[rtcConnection$Quality.ordinal()] = 1;
        RtcConnection$Quality rtcConnection$Quality2 = RtcConnection$Quality.AVERAGE;
        iArr[rtcConnection$Quality2.ordinal()] = 2;
        RtcConnection$Quality rtcConnection$Quality3 = RtcConnection$Quality.FINE;
        iArr[rtcConnection$Quality3.ordinal()] = 3;
        RtcConnection$Quality rtcConnection$Quality4 = RtcConnection$Quality.UNKNOWN;
        iArr[rtcConnection$Quality4.ordinal()] = 4;
        RtcConnection$Quality.values();
        int[] iArr2 = new int[4];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[rtcConnection$Quality.ordinal()] = 1;
        iArr2[rtcConnection$Quality2.ordinal()] = 2;
        iArr2[rtcConnection$Quality3.ordinal()] = 3;
        iArr2[rtcConnection$Quality4.ordinal()] = 4;
    }
}
