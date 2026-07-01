package b.a.q.o0;

import b.a.q.o0.VideoQuality;
import co.discord.media_engine.InboundRtpVideo;
import co.discord.media_engine.OutboundRtpAudio;
import co.discord.media_engine.OutboundRtpVideo;
import co.discord.media_engine.ReceiverReport;
import co.discord.media_engine.Stats;
import co.discord.media_engine.Transport;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import java.util.Map;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.q.o0.a, reason: use source file name */
/* JADX INFO: compiled from: RtcStatsCollector.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RtcStatsCollector extends FunctionReferenceImpl implements Function1<Stats, Unit> {
    public RtcStatsCollector(RtcStatsCollector4 rtcStatsCollector4) {
        super(1, rtcStatsCollector4, RtcStatsCollector4.class, "onStatsReceived", "onStatsReceived(Lco/discord/media_engine/Stats;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Stats stats) {
        long j;
        OutboundRtpVideo outboundRtpVideo;
        ReceiverReport[] receiverReports;
        Stats stats2 = stats;
        Intrinsics3.checkNotNullParameter(stats2, "p1");
        RtcStatsCollector4 rtcStatsCollector4 = (RtcStatsCollector4) this.receiver;
        rtcStatsCollector4.a.add(stats2);
        if (rtcStatsCollector4.a.size() > rtcStatsCollector4.i) {
            rtcStatsCollector4.a.removeFirst();
        }
        rtcStatsCollector4.f.update(stats2);
        VideoQuality videoQuality = rtcStatsCollector4.g;
        synchronized (videoQuality) {
            Intrinsics3.checkNotNullParameter(stats2, "stats");
            long jCurrentTimeMillis = videoQuality.q.currentTimeMillis();
            Transport transport = stats2.getTransport();
            videoQuality.g(null, Integer.valueOf((transport == null || (receiverReports = transport.getReceiverReports()) == null) ? 0 : receiverReports.length), jCurrentTimeMillis);
            if (!videoQuality.k.a() && (outboundRtpVideo = stats2.getOutboundRtpVideo()) != null) {
                videoQuality.a(videoQuality.l, new VideoQuality.g(outboundRtpVideo.getResolution().getHeight(), jCurrentTimeMillis, new VideoQuality.a(outboundRtpVideo.getFramesEncoded(), outboundRtpVideo.getFramesSent(), outboundRtpVideo.getPacketsSent(), outboundRtpVideo.getPacketsLost(), 0L, outboundRtpVideo.getBytesSent(), outboundRtpVideo.getNackCount(), outboundRtpVideo.getPliCount(), outboundRtpVideo.getQpSum(), 0L, 0L, 0L, 0L, 0L)));
                if (videoQuality.l.d == null && outboundRtpVideo.getFramesEncoded() > 0) {
                    videoQuality.l.d = Long.valueOf(jCurrentTimeMillis - videoQuality.g);
                    Logger.i$default(videoQuality.p, "VideoQuality: outboundStats.timeToFirstFrame: " + videoQuality.l.d, null, 2, null);
                }
                videoQuality.b(outboundRtpVideo.getBitrateTarget());
            }
            if (!videoQuality.i.a()) {
                for (Map.Entry<String, InboundRtpVideo> entry : stats2.getInboundRtpVideo().entrySet()) {
                    String key = entry.getKey();
                    InboundRtpVideo value = entry.getValue();
                    Map<String, VideoQuality.e> map = videoQuality.m;
                    VideoQuality.e eVar = map.get(key);
                    if (eVar == null) {
                        eVar = new VideoQuality.e();
                        map.put(key, eVar);
                    }
                    VideoQuality.e eVar2 = eVar;
                    videoQuality.a(eVar2, videoQuality.f(value, jCurrentTimeMillis));
                    if (eVar2.d == null && value.getFramesDecoded() > 0) {
                        byte[] bArr = Util7.a;
                        Intrinsics3.checkParameterIsNotNull(key, "$this$toLongOrDefault");
                        try {
                            j = Long.parseLong(key);
                        } catch (NumberFormatException unused) {
                            j = 0;
                        }
                        Long l = videoQuality.n.get(Long.valueOf(value.getSsrc()));
                        if (l != null) {
                            eVar2.d = Long.valueOf(jCurrentTimeMillis - l.longValue());
                            Logger.i$default(videoQuality.p, "VideoQuality: inbound.timeToFirstFrame: " + eVar2.d + " (userId: " + j + ", ssrc: " + value.getSsrc() + ')', null, 2, null);
                        } else {
                            Logger.e$default(videoQuality.p, "VideoQuality: inbound.timeToFirstFrame: Unable to locate start time. (userId: " + j + ", ssrc: " + value.getSsrc() + ')', null, null, 6, null);
                        }
                    }
                }
            }
        }
        KrispOveruseDetector krispOveruseDetector = rtcStatsCollector4.h;
        Objects.requireNonNull(krispOveruseDetector);
        Intrinsics3.checkNotNullParameter(stats2, "stats");
        if (krispOveruseDetector.d.getType() == MediaEngineConnection.Type.DEFAULT && krispOveruseDetector.d.b()) {
            OutboundRtpAudio outboundRtpAudio = stats2.getOutboundRtpAudio();
            if (outboundRtpAudio != null && outboundRtpAudio.getNoiseCancellerIsEnabled()) {
                OutboundRtpAudio outboundRtpAudio2 = krispOveruseDetector.f2770b;
                if (outboundRtpAudio2 != null) {
                    Tuples2<Boolean, Long> tuples2A = krispOveruseDetector.a(outboundRtpAudio2, stats2.getOutboundRtpAudio(), 8.0d);
                    boolean zBooleanValue = tuples2A.component1().booleanValue();
                    long jLongValue = tuples2A.component2().longValue();
                    if (zBooleanValue) {
                        krispOveruseDetector.d.f(KrispOveruseDetector.Status.CPU_OVERUSE);
                    } else if (jLongValue == 0) {
                        int i = krispOveruseDetector.c + 1;
                        krispOveruseDetector.c = i;
                        if (i > 2) {
                            krispOveruseDetector.d.f(KrispOveruseDetector.Status.FAILED);
                        }
                    } else {
                        krispOveruseDetector.c = 0;
                    }
                }
                krispOveruseDetector.f2770b = stats2.getOutboundRtpAudio();
            }
            OutboundRtpAudio outboundRtpAudio3 = stats2.getOutboundRtpAudio();
            if (outboundRtpAudio3 != null && outboundRtpAudio3.getVoiceActivityDetectorIsEnabled()) {
                OutboundRtpAudio outboundRtpAudio4 = krispOveruseDetector.a;
                if (outboundRtpAudio4 != null && krispOveruseDetector.a(outboundRtpAudio4, stats2.getOutboundRtpAudio(), 4.0d).component1().booleanValue()) {
                    krispOveruseDetector.d.f(KrispOveruseDetector.Status.VAD_CPU_OVERUSE);
                }
                krispOveruseDetector.a = stats2.getOutboundRtpAudio();
            }
        }
        return Unit.a;
    }
}
