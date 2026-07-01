package com.discord.rtcconnection.mediaengine;

import b.a.q.m0.a;
import co.discord.media_engine.StreamParameters;
import com.discord.rtcconnection.KrispOveruseDetector$Status;
import java.util.List;

/* JADX INFO: compiled from: MediaEngineConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public interface MediaEngineConnection$d {
    void onConnected(MediaEngineConnection mediaEngineConnection, MediaEngineConnection$TransportInfo mediaEngineConnection$TransportInfo, List<a> list);

    void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, MediaEngineConnection$ConnectionState mediaEngineConnection$ConnectionState);

    void onDestroy(MediaEngineConnection mediaEngineConnection);

    void onError(MediaEngineConnection mediaEngineConnection, MediaEngineConnection$FailedConnectionException mediaEngineConnection$FailedConnectionException);

    void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector$Status krispOveruseDetector$Status);

    void onLocalMute(long j, boolean z2);

    void onLocalVideoOffScreen(long j, boolean z2);

    void onSpeaking(long j, int i, boolean z2);

    void onTargetBitrate(int i);

    void onTargetFrameRate(int i);

    void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr);
}
