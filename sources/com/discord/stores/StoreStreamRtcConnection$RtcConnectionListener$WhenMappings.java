package com.discord.stores;

import com.discord.rtcconnection.RtcConnection$AnalyticsEvent;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStreamRtcConnection$RtcConnectionListener$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        RtcConnection$AnalyticsEvent.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        iArr[RtcConnection$AnalyticsEvent.VIDEO_STREAM_ENDED.ordinal()] = 1;
        iArr[RtcConnection$AnalyticsEvent.MEDIA_SESSION_JOINED.ordinal()] = 2;
    }
}
