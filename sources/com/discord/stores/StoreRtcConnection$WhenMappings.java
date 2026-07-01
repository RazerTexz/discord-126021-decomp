package com.discord.stores;

import com.discord.rtcconnection.RtcConnection$AnalyticsEvent;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreRtcConnection$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        RtcConnection$AnalyticsEvent.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        iArr[RtcConnection$AnalyticsEvent.VOICE_CONNECTION_SUCCESS.ordinal()] = 1;
        iArr[RtcConnection$AnalyticsEvent.VOICE_CONNECTION_FAILURE.ordinal()] = 2;
        iArr[RtcConnection$AnalyticsEvent.VOICE_DISCONNECT.ordinal()] = 3;
        iArr[RtcConnection$AnalyticsEvent.VIDEO_STREAM_ENDED.ordinal()] = 4;
        iArr[RtcConnection$AnalyticsEvent.MEDIA_SESSION_JOINED.ordinal()] = 5;
    }
}
