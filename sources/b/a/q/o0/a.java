package b.a.q.o0;

import co.discord.media_engine.InboundRtpVideo;
import co.discord.media_engine.OutboundRtpAudio;
import co.discord.media_engine.OutboundRtpVideo;
import co.discord.media_engine.ReceiverReport;
import co.discord.media_engine.Stats;
import co.discord.media_engine.Transport;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.KrispOveruseDetector$Status;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$Type;
import com.discord.utilities.logging.Logger;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RtcStatsCollector.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a extends k implements Function1<Stats, Unit> {
    public a(d dVar) {
        super(1, dVar, d.class, "onStatsReceived", "onStatsReceived(Lco/discord/media_engine/Stats;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Stats stats) {
        long j;
        OutboundRtpVideo outboundRtpVideo;
        ReceiverReport[] receiverReports;
        Stats stats2 = stats;
        m.checkNotNullParameter(stats2, "p1");
        d dVar = (d) this.receiver;
        dVar.a.add(stats2);
        if (dVar.a.size() > dVar.i) {
            dVar.a.removeFirst();
        }
        dVar.f.update(stats2);
        e eVar = dVar.g;
        synchronized (eVar) {
            m.checkNotNullParameter(stats2, "stats");
            long jCurrentTimeMillis = eVar.q.currentTimeMillis();
            Transport transport = stats2.getTransport();
            eVar.g(null, Integer.valueOf((transport == null || (receiverReports = transport.getReceiverReports()) == null) ? 0 : receiverReports.length), jCurrentTimeMillis);
            if (!eVar.k.a() && (outboundRtpVideo = stats2.getOutboundRtpVideo()) != null) {
                eVar.a(eVar.l, new e$g(outboundRtpVideo.getResolution().getHeight(), jCurrentTimeMillis, new e$a(outboundRtpVideo.getFramesEncoded(), outboundRtpVideo.getFramesSent(), outboundRtpVideo.getPacketsSent(), outboundRtpVideo.getPacketsLost(), 0L, outboundRtpVideo.getBytesSent(), outboundRtpVideo.getNackCount(), outboundRtpVideo.getPliCount(), outboundRtpVideo.getQpSum(), 0L, 0L, 0L, 0L, 0L)));
                if (eVar.l.d == null && outboundRtpVideo.getFramesEncoded() > 0) {
                    eVar.l.d = Long.valueOf(jCurrentTimeMillis - eVar.g);
                    Logger.i$default(eVar.p, "VideoQuality: outboundStats.timeToFirstFrame: " + eVar.l.d, null, 2, null);
                }
                eVar.b(outboundRtpVideo.getBitrateTarget());
            }
            if (!eVar.i.a()) {
                for (Map$Entry<String, InboundRtpVideo> map$Entry : stats2.getInboundRtpVideo().entrySet()) {
                    String key = map$Entry.getKey();
                    InboundRtpVideo value = map$Entry.getValue();
                    Map<String, e$e> map = eVar.m;
                    e$e e_e = map.get(key);
                    if (e_e == null) {
                        e_e = new e$e();
                        map.put(key, e_e);
                    }
                    e$e e_e2 = e_e;
                    eVar.a(e_e2, eVar.f(value, jCurrentTimeMillis));
                    if (e_e2.d == null && value.getFramesDecoded() > 0) {
                        byte[] bArr = f0.e0.c.a;
                        m.checkParameterIsNotNull(key, "$this$toLongOrDefault");
                        try {
                            j = Long.parseLong(key);
                        } catch (NumberFormatException unused) {
                            j = 0;
                        }
                        Long l = eVar.n.get(Long.valueOf(value.getSsrc()));
                        if (l != null) {
                            e_e2.d = Long.valueOf(jCurrentTimeMillis - l.longValue());
                            Logger.i$default(eVar.p, "VideoQuality: inbound.timeToFirstFrame: " + e_e2.d + " (userId: " + j + ", ssrc: " + value.getSsrc() + ')', null, 2, null);
                        } else {
                            Logger.e$default(eVar.p, "VideoQuality: inbound.timeToFirstFrame: Unable to locate start time. (userId: " + j + ", ssrc: " + value.getSsrc() + ')', null, null, 6, null);
                        }
                    }
                }
            }
        }
        KrispOveruseDetector krispOveruseDetector = dVar.h;
        Objects.requireNonNull(krispOveruseDetector);
        m.checkNotNullParameter(stats2, "stats");
        if (krispOveruseDetector.d.getType() == MediaEngineConnection$Type.DEFAULT && krispOveruseDetector.d.b()) {
            OutboundRtpAudio outboundRtpAudio = stats2.getOutboundRtpAudio();
            if (outboundRtpAudio != null && outboundRtpAudio.getNoiseCancellerIsEnabled()) {
                OutboundRtpAudio outboundRtpAudio2 = krispOveruseDetector.f2770b;
                if (outboundRtpAudio2 != null) {
                    Pair<Boolean, Long> pairA = krispOveruseDetector.a(outboundRtpAudio2, stats2.getOutboundRtpAudio(), 8.0d);
                    boolean zBooleanValue = pairA.component1().booleanValue();
                    long jLongValue = pairA.component2().longValue();
                    if (zBooleanValue) {
                        krispOveruseDetector.d.f(KrispOveruseDetector$Status.CPU_OVERUSE);
                    } else if (jLongValue == 0) {
                        int i = krispOveruseDetector.c + 1;
                        krispOveruseDetector.c = i;
                        if (i > 2) {
                            krispOveruseDetector.d.f(KrispOveruseDetector$Status.FAILED);
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
                    krispOveruseDetector.d.f(KrispOveruseDetector$Status.VAD_CPU_OVERUSE);
                }
                krispOveruseDetector.a = stats2.getOutboundRtpAudio();
            }
        }
        return Unit.a;
    }
}
