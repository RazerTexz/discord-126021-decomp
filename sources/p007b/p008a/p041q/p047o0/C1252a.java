package p007b.p008a.p041q.p047o0;

import co.discord.media_engine.InboundRtpVideo;
import co.discord.media_engine.OutboundRtpAudio;
import co.discord.media_engine.OutboundRtpVideo;
import co.discord.media_engine.ReceiverReport;
import co.discord.media_engine.Stats;
import co.discord.media_engine.Transport;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p041q.p047o0.C1256e;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;

/* JADX INFO: renamed from: b.a.q.o0.a */
/* JADX INFO: compiled from: RtcStatsCollector.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1252a extends C12236k implements Function1<Stats, Unit> {
    public C1252a(C1255d c1255d) {
        super(1, c1255d, C1255d.class, "onStatsReceived", "onStatsReceived(Lco/discord/media_engine/Stats;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Stats stats) {
        long j;
        OutboundRtpVideo outboundRtpVideo;
        ReceiverReport[] receiverReports;
        Stats stats2 = stats;
        C12238m.checkNotNullParameter(stats2, "p1");
        C1255d c1255d = (C1255d) this.receiver;
        c1255d.f1807a.add(stats2);
        if (c1255d.f1807a.size() > c1255d.f1815i) {
            c1255d.f1807a.removeFirst();
        }
        c1255d.f1812f.update(stats2);
        C1256e c1256e = c1255d.f1813g;
        synchronized (c1256e) {
            C12238m.checkNotNullParameter(stats2, "stats");
            long jCurrentTimeMillis = c1256e.f1832q.currentTimeMillis();
            Transport transport = stats2.getTransport();
            c1256e.m358g(null, Integer.valueOf((transport == null || (receiverReports = transport.getReceiverReports()) == null) ? 0 : receiverReports.length), jCurrentTimeMillis);
            if (!c1256e.f1826k.m360a() && (outboundRtpVideo = stats2.getOutboundRtpVideo()) != null) {
                c1256e.m352a(c1256e.f1827l, new C1256e.g(outboundRtpVideo.getResolution().getHeight(), jCurrentTimeMillis, new C1256e.a(outboundRtpVideo.getFramesEncoded(), outboundRtpVideo.getFramesSent(), outboundRtpVideo.getPacketsSent(), outboundRtpVideo.getPacketsLost(), 0L, outboundRtpVideo.getBytesSent(), outboundRtpVideo.getNackCount(), outboundRtpVideo.getPliCount(), outboundRtpVideo.getQpSum(), 0L, 0L, 0L, 0L, 0L)));
                if (c1256e.f1827l.f1852d == null && outboundRtpVideo.getFramesEncoded() > 0) {
                    c1256e.f1827l.f1852d = Long.valueOf(jCurrentTimeMillis - c1256e.f1822g);
                    Logger.i$default(c1256e.f1831p, "VideoQuality: outboundStats.timeToFirstFrame: " + c1256e.f1827l.f1852d, null, 2, null);
                }
                c1256e.m353b(outboundRtpVideo.getBitrateTarget());
            }
            if (!c1256e.f1824i.m360a()) {
                for (Map.Entry<String, InboundRtpVideo> entry : stats2.getInboundRtpVideo().entrySet()) {
                    String key = entry.getKey();
                    InboundRtpVideo value = entry.getValue();
                    Map<String, C1256e.e> map = c1256e.f1828m;
                    C1256e.e eVar = map.get(key);
                    if (eVar == null) {
                        eVar = new C1256e.e();
                        map.put(key, eVar);
                    }
                    C1256e.e eVar2 = eVar;
                    c1256e.m352a(eVar2, c1256e.m357f(value, jCurrentTimeMillis));
                    if (eVar2.f1852d == null && value.getFramesDecoded() > 0) {
                        byte[] bArr = C12272c.f25397a;
                        C12238m.checkParameterIsNotNull(key, "$this$toLongOrDefault");
                        try {
                            j = Long.parseLong(key);
                        } catch (NumberFormatException unused) {
                            j = 0;
                        }
                        Long l = c1256e.f1829n.get(Long.valueOf(value.getSsrc()));
                        if (l != null) {
                            eVar2.f1852d = Long.valueOf(jCurrentTimeMillis - l.longValue());
                            Logger.i$default(c1256e.f1831p, "VideoQuality: inbound.timeToFirstFrame: " + eVar2.f1852d + " (userId: " + j + ", ssrc: " + value.getSsrc() + ')', null, 2, null);
                        } else {
                            Logger.e$default(c1256e.f1831p, "VideoQuality: inbound.timeToFirstFrame: Unable to locate start time. (userId: " + j + ", ssrc: " + value.getSsrc() + ')', null, null, 6, null);
                        }
                    }
                }
            }
        }
        KrispOveruseDetector krispOveruseDetector = c1255d.f1814h;
        Objects.requireNonNull(krispOveruseDetector);
        C12238m.checkNotNullParameter(stats2, "stats");
        if (krispOveruseDetector.f18739d.getType() == MediaEngineConnection.Type.DEFAULT && krispOveruseDetector.f18739d.mo296b()) {
            OutboundRtpAudio outboundRtpAudio = stats2.getOutboundRtpAudio();
            if (outboundRtpAudio != null && outboundRtpAudio.getNoiseCancellerIsEnabled()) {
                OutboundRtpAudio outboundRtpAudio2 = krispOveruseDetector.f18737b;
                if (outboundRtpAudio2 != null) {
                    Pair<Boolean, Long> pairM8451a = krispOveruseDetector.m8451a(outboundRtpAudio2, stats2.getOutboundRtpAudio(), 8.0d);
                    boolean zBooleanValue = pairM8451a.component1().booleanValue();
                    long jLongValue = pairM8451a.component2().longValue();
                    if (zBooleanValue) {
                        krispOveruseDetector.f18739d.mo300f(KrispOveruseDetector.Status.CPU_OVERUSE);
                    } else if (jLongValue == 0) {
                        int i = krispOveruseDetector.f18738c + 1;
                        krispOveruseDetector.f18738c = i;
                        if (i > 2) {
                            krispOveruseDetector.f18739d.mo300f(KrispOveruseDetector.Status.FAILED);
                        }
                    } else {
                        krispOveruseDetector.f18738c = 0;
                    }
                }
                krispOveruseDetector.f18737b = stats2.getOutboundRtpAudio();
            }
            OutboundRtpAudio outboundRtpAudio3 = stats2.getOutboundRtpAudio();
            if (outboundRtpAudio3 != null && outboundRtpAudio3.getVoiceActivityDetectorIsEnabled()) {
                OutboundRtpAudio outboundRtpAudio4 = krispOveruseDetector.f18736a;
                if (outboundRtpAudio4 != null && krispOveruseDetector.m8451a(outboundRtpAudio4, stats2.getOutboundRtpAudio(), 4.0d).component1().booleanValue()) {
                    krispOveruseDetector.f18739d.mo300f(KrispOveruseDetector.Status.VAD_CPU_OVERUSE);
                }
                krispOveruseDetector.f18736a = stats2.getOutboundRtpAudio();
            }
        }
        return Unit.f27425a;
    }
}
