package com.discord.rtcconnection;

import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class RtcConnection$b implements RtcConnection$c {
    @Override // com.discord.rtcconnection.RtcConnection$c
    public void onAnalyticsEvent(RtcConnection$AnalyticsEvent rtcConnection$AnalyticsEvent, Map<String, Object> map) {
        m.checkNotNullParameter(rtcConnection$AnalyticsEvent, "event");
        m.checkNotNullParameter(map, "properties");
    }

    @Override // com.discord.rtcconnection.RtcConnection$c
    public void onFatalClose() {
    }

    public void onFirstFrameReceived(long j) {
    }

    public void onFirstFrameSent() {
    }

    @Override // com.discord.rtcconnection.RtcConnection$c
    public void onMediaEngineConnectionConnected(RtcConnection rtcConnection) {
        m.checkNotNullParameter(rtcConnection, "connection");
    }

    @Override // com.discord.rtcconnection.RtcConnection$c
    public void onMediaSessionIdReceived() {
    }

    @Override // com.discord.rtcconnection.RtcConnection$c
    public void onQualityUpdate(RtcConnection$Quality rtcConnection$Quality) {
        m.checkNotNullParameter(rtcConnection$Quality, "quality");
    }

    @Override // com.discord.rtcconnection.RtcConnection$c
    public void onSpeaking(long j, boolean z2) {
    }

    @Override // com.discord.rtcconnection.RtcConnection$c
    public abstract void onStateChange(RtcConnection$StateChange rtcConnection$StateChange);

    @Override // com.discord.rtcconnection.RtcConnection$c
    public void onUserCreated(RtcConnection rtcConnection, long j) {
        m.checkNotNullParameter(rtcConnection, "connection");
    }

    @Override // com.discord.rtcconnection.RtcConnection$c
    public void onVideoMetadata(VideoMetadata videoMetadata) {
        m.checkNotNullParameter(videoMetadata, "metadata");
    }

    @Override // com.discord.rtcconnection.RtcConnection$c
    public void onVideoStream(long j, Integer num, int i, int i2, int i3) {
    }
}
