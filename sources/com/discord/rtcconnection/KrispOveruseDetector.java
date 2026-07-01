package com.discord.rtcconnection;

import co.discord.media_engine.OutboundRtpAudio;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import d0.z.d.Intrinsics3;
import kotlin.Tuples2;

/* JADX INFO: compiled from: KrispOveruseDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class KrispOveruseDetector {
    public OutboundRtpAudio a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OutboundRtpAudio f2770b;
    public int c;
    public final MediaEngineConnection d;

    /* JADX INFO: compiled from: KrispOveruseDetector.kt */
    public enum Status {
        CPU_OVERUSE,
        FAILED,
        VAD_CPU_OVERUSE
    }

    public KrispOveruseDetector(MediaEngineConnection mediaEngineConnection) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        this.d = mediaEngineConnection;
    }

    public final Tuples2<Boolean, Long> a(OutboundRtpAudio outboundRtpAudio, OutboundRtpAudio outboundRtpAudio2, double d) {
        if (outboundRtpAudio == null || outboundRtpAudio2 == null) {
            return new Tuples2<>(Boolean.FALSE, 0L);
        }
        long noiseCancellerProcessTime = outboundRtpAudio2.getNoiseCancellerProcessTime() - outboundRtpAudio.getNoiseCancellerProcessTime();
        long framesCaptured = outboundRtpAudio2.getFramesCaptured() - outboundRtpAudio.getFramesCaptured();
        if (framesCaptured == 0) {
            return new Tuples2<>(Boolean.FALSE, Long.valueOf(noiseCancellerProcessTime));
        }
        return new Tuples2<>(Boolean.valueOf(((double) noiseCancellerProcessTime) / ((double) framesCaptured) > d), Long.valueOf(noiseCancellerProcessTime));
    }
}
