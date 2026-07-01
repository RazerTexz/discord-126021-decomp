package com.discord.rtcconnection.mediaengine;

import b.a.q.m0.a;
import co.discord.media_engine.StreamParameters;
import com.discord.rtcconnection.KrispOveruseDetector$Status;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: MediaEngineConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class MediaEngineConnection$a implements MediaEngineConnection$d {
    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onConnected(MediaEngineConnection mediaEngineConnection, MediaEngineConnection$TransportInfo mediaEngineConnection$TransportInfo, List<a> list) {
        m.checkNotNullParameter(mediaEngineConnection, "connection");
        m.checkNotNullParameter(mediaEngineConnection$TransportInfo, "transportInfo");
        m.checkNotNullParameter(list, "supportedVideoCodecs");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, MediaEngineConnection$ConnectionState mediaEngineConnection$ConnectionState) {
        m.checkNotNullParameter(mediaEngineConnection, "connection");
        m.checkNotNullParameter(mediaEngineConnection$ConnectionState, "connectionState");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public abstract void onDestroy(MediaEngineConnection mediaEngineConnection);

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onError(MediaEngineConnection mediaEngineConnection, MediaEngineConnection$FailedConnectionException mediaEngineConnection$FailedConnectionException) {
        m.checkNotNullParameter(mediaEngineConnection, "connection");
        m.checkNotNullParameter(mediaEngineConnection$FailedConnectionException, "exception");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector$Status krispOveruseDetector$Status) {
        m.checkNotNullParameter(mediaEngineConnection, "connection");
        m.checkNotNullParameter(krispOveruseDetector$Status, "status");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onLocalMute(long j, boolean z2) {
    }

    public void onLocalVideoDisabled(long j, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onLocalVideoOffScreen(long j, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onSpeaking(long j, int i, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onTargetBitrate(int i) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onTargetFrameRate(int i) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr) {
        m.checkNotNullParameter(streamParametersArr, "streams");
    }
}
