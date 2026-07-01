package com.discord.rtcconnection;

import java.util.Map;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public interface RtcConnection$c {
    void onAnalyticsEvent(RtcConnection$AnalyticsEvent rtcConnection$AnalyticsEvent, Map<String, Object> map);

    void onFatalClose();

    void onMediaEngineConnectionConnected(RtcConnection rtcConnection);

    void onMediaSessionIdReceived();

    void onQualityUpdate(RtcConnection$Quality rtcConnection$Quality);

    void onSpeaking(long j, boolean z2);

    void onStateChange(RtcConnection$StateChange rtcConnection$StateChange);

    void onUserCreated(RtcConnection rtcConnection, long j);

    void onVideoMetadata(VideoMetadata videoMetadata);

    void onVideoStream(long j, Integer num, int i, int i2, int i3);
}
