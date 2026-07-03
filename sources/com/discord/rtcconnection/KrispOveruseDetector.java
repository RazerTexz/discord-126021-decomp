package com.discord.rtcconnection;

import co.discord.media_engine.OutboundRtpAudio;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import kotlin.Pair;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: KrispOveruseDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class KrispOveruseDetector {

    /* JADX INFO: renamed from: a */
    public OutboundRtpAudio f18736a;

    /* JADX INFO: renamed from: b */
    public OutboundRtpAudio f18737b;

    /* JADX INFO: renamed from: c */
    public int f18738c;

    /* JADX INFO: renamed from: d */
    public final MediaEngineConnection f18739d;

    /* JADX INFO: compiled from: KrispOveruseDetector.kt */
    public enum Status {
        CPU_OVERUSE,
        FAILED,
        VAD_CPU_OVERUSE
    }

    public KrispOveruseDetector(MediaEngineConnection mediaEngineConnection) {
        C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
        this.f18739d = mediaEngineConnection;
    }

    /* JADX INFO: renamed from: a */
    public final Pair<Boolean, Long> m8451a(OutboundRtpAudio outboundRtpAudio, OutboundRtpAudio outboundRtpAudio2, double d) {
        if (outboundRtpAudio == null || outboundRtpAudio2 == null) {
            return new Pair<>(Boolean.FALSE, 0L);
        }
        long noiseCancellerProcessTime = outboundRtpAudio2.getNoiseCancellerProcessTime() - outboundRtpAudio.getNoiseCancellerProcessTime();
        long framesCaptured = outboundRtpAudio2.getFramesCaptured() - outboundRtpAudio.getFramesCaptured();
        if (framesCaptured == 0) {
            return new Pair<>(Boolean.FALSE, Long.valueOf(noiseCancellerProcessTime));
        }
        return new Pair<>(Boolean.valueOf(((double) noiseCancellerProcessTime) / ((double) framesCaptured) > d), Long.valueOf(noiseCancellerProcessTime));
    }
}
