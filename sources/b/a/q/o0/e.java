package b.a.q.o0;

import androidx.annotation.AnyThread;
import co.discord.media_engine.InboundRtpVideo;
import com.discord.utilities.collections.Histogram$Report;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollectionSubject;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.system.DeviceResourceUsageMonitor;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeSpan;
import d0.o;
import d0.t.h0;
import d0.t.n;
import d0.t.r;
import d0.z.d.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;

/* JADX INFO: compiled from: VideoQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final ListenerCollectionSubject<?> e;
    public final ListenerCollection<?> f;
    public final long g;
    public Long h;
    public final e$d i;
    public final e$d j;
    public final e$d k;
    public final e$f l;
    public final Map<String, e$e> m;
    public final Map<Long, Long> n;
    public final DeviceResourceUsageMonitor o;
    public final Logger p;
    public final Clock q;
    public static final e$b d = new e$b(null);
    public static final List<Integer> a = n.listOf((Object[]) new Integer[]{0, 500000, 1000000, 1500000, 2000000, 3000000, 4000000, 5000000, 6000000, 7000000, 8000000});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Integer> f280b = n.listOf((Object[]) new Integer[]{0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60});
    public static final List<Integer> c = n.listOf((Object[]) new Integer[]{720, 480, 360});

    public e(Logger logger, Clock clock) {
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(clock, "clock");
        this.p = logger;
        this.q = clock;
        ListenerCollectionSubject<?> listenerCollectionSubject = new ListenerCollectionSubject<>();
        this.e = listenerCollectionSubject;
        this.f = listenerCollectionSubject;
        long jCurrentTimeMillis = clock.currentTimeMillis();
        this.g = jCurrentTimeMillis;
        this.i = new e$d(false, jCurrentTimeMillis);
        this.j = new e$d(false, jCurrentTimeMillis);
        this.k = new e$d(false, jCurrentTimeMillis);
        this.l = new e$f();
        this.m = new LinkedHashMap();
        this.n = new LinkedHashMap();
        DeviceResourceUsageMonitor deviceResourceUsageMonitor = new DeviceResourceUsageMonitor(new TimeSpan(1L, TimeUnit.SECONDS), clock, new e$h(this));
        this.o = deviceResourceUsageMonitor;
        deviceResourceUsageMonitor.start();
    }

    public final void a(e$e e_e, e$g e_g) {
        e_e.a.add(e_g);
        if (e_e.a.size() < 2) {
            return;
        }
        List<e$g> list = e_e.a;
        e$g e_g2 = list.get(list.size() - 1);
        List<e$g> list2 = e_e.a;
        e$g e_g3 = list2.get(list2.size() - 2);
        f fVar = f.j;
        e_e.f = (e_g2.f284b - e_g3.f284b) + e_e.f;
        e$a e_a = e_e.e;
        e$a e_a2 = e_g2.c;
        e$a e_a3 = e_g3.c;
        e_a.a = fVar.a(e_a2.a, e_a3.a) + e_a.a;
        e_a.f281b = fVar.a(e_a2.f281b, e_a3.f281b) + e_a.f281b;
        e_a.c = fVar.a(e_a2.c, e_a3.c) + e_a.c;
        e_a.d = fVar.a(e_a2.d, e_a3.d) + e_a.d;
        e_a.e = fVar.a(e_a2.e, e_a3.e) + e_a.e;
        e_a.f = fVar.a(e_a2.f, e_a3.f) + e_a.f;
        e_a.g = fVar.a(e_a2.g, e_a3.g) + e_a.g;
        e_a.h = fVar.a(e_a2.h, e_a3.h) + e_a.h;
        e_a.i = fVar.a(e_a2.i, e_a3.i) + e_a.i;
        e_a.j = fVar.a(e_a2.j, e_a3.j) + e_a.j;
        e_a.k = fVar.a(e_a2.j, e_a3.j) + e_a.k;
        e_a.l = fVar.a(e_a2.l, e_a3.l) + e_a.l;
        e_a.m = fVar.a(e_a2.m, e_a3.m) + e_a.m;
        e_a.n = fVar.a(e_a2.n, e_a3.n) + e_a.n;
        e$a e_a4 = e_g2.c;
        long j = e_a4.f;
        long j2 = e_a4.a;
        long j3 = e_g2.f284b;
        long j4 = e_g2.a;
        float f = (j3 - e_g3.f284b) / 1000.0f;
        e_e.i = (j4 * f) + e_e.i;
        if (e_e.a.size() < 6) {
            return;
        }
        List<e$g> list3 = e_e.a;
        e$g e_g4 = list3.get(list3.size() - 3);
        e$a e_a5 = e_g4.c;
        long j5 = e_a5.f;
        long j6 = e_a5.a;
        long j7 = e_g4.f284b;
        Iterator<T> it = c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            long j8 = j2;
            int iIntValue = ((Number) it.next()).intValue();
            long j9 = j6;
            if (j4 <= iIntValue) {
                Map<Integer, Float> map = e_e.j;
                Integer numValueOf = Integer.valueOf(iIntValue);
                Float f2 = e_e.j.get(Integer.valueOf(iIntValue));
                map.put(numValueOf, Float.valueOf((f2 != null ? f2.floatValue() : 0.0f) + f));
            }
            j2 = j8;
            j6 = j9;
        }
        float f3 = (j3 - j7) / 1000.0f;
        float f4 = ((j - j5) * ((long) 8)) / f3;
        float f5 = (j2 - j6) / f3;
        Iterator<T> it2 = a.iterator();
        while (it2.hasNext()) {
            int iIntValue2 = ((Number) it2.next()).intValue();
            if (f4 <= iIntValue2) {
                Map<Integer, Float> map2 = e_e.g;
                Integer numValueOf2 = Integer.valueOf(iIntValue2);
                Float f6 = e_e.g.get(Integer.valueOf(iIntValue2));
                map2.put(numValueOf2, Float.valueOf((f6 != null ? f6.floatValue() : 0.0f) + f));
            }
        }
        Iterator<T> it3 = f280b.iterator();
        while (it3.hasNext()) {
            int iIntValue3 = ((Number) it3.next()).intValue();
            if (f5 <= iIntValue3) {
                Map<Integer, Float> map3 = e_e.h;
                Integer numValueOf3 = Integer.valueOf(iIntValue3);
                Float f7 = e_e.h.get(Integer.valueOf(iIntValue3));
                map3.put(numValueOf3, Float.valueOf((f7 != null ? f7.floatValue() : 0.0f) + f));
            }
        }
        r.removeFirst(e_e.a);
    }

    public final void b(int i) {
        if (this.l.a.size() < 2) {
            return;
        }
        List<e$g> list = this.l.a;
        long j = list.get(list.size() - 1).f284b;
        List<e$g> list2 = this.l.a;
        float f = (j - list2.get(list2.size() - 2).f284b) / 1000.0f;
        e$f e_f = this.l;
        long j2 = e_f.m;
        Float fValueOf = Float.valueOf(e_f.l * f);
        e_f.m = j2 + (fValueOf != null ? d0.a0.a.roundToLong(fValueOf.floatValue()) : 0L);
        e$f e_f2 = this.l;
        long j3 = e_f2.n;
        Float fValueOf2 = Float.valueOf((i / 8.0f) * f);
        e_f2.n = j3 + (fValueOf2 != null ? d0.a0.a.roundToLong(fValueOf2.floatValue()) : 0L);
        e$f e_f3 = this.l;
        long j4 = e_f3.o;
        Float fValueOf3 = Float.valueOf((e_f3.k / 8.0f) * f);
        e_f3.o = j4 + (fValueOf3 != null ? d0.a0.a.roundToLong(fValueOf3.floatValue()) : 0L);
    }

    @AnyThread
    public final synchronized Map<String, Object> c(String str) {
        e$e e_e;
        m.checkNotNullParameter(str, "userId");
        e_e = this.m.get(str);
        return e_e != null ? e(e_e) : null;
    }

    @AnyThread
    public final synchronized Map<String, Object> d() {
        e$f e_f;
        float f;
        float f2;
        Float fValueOf;
        Float fValueOf2;
        Float fValueOf3;
        e_f = this.l;
        f = e_f.f / 1000.0f;
        f2 = 0;
        return h0.plus(e(this.l), h0.mapOf(o.to("target_bitrate_max", Long.valueOf((f <= f2 || (fValueOf3 = Float.valueOf(((float) (e_f.o * ((long) 8))) / f)) == null) ? 0L : d0.a0.a.roundToLong(fValueOf3.floatValue()))), o.to("target_bitrate_network", Long.valueOf((f <= f2 || (fValueOf2 = Float.valueOf(((float) (this.l.n * ((long) 8))) / f)) == null) ? 0L : d0.a0.a.roundToLong(fValueOf2.floatValue()))), o.to("target_fps", Long.valueOf((f <= f2 || (fValueOf = Float.valueOf(((float) this.l.m) / f)) == null) ? 0L : d0.a0.a.roundToLong(fValueOf.floatValue()))), o.to("duration_encoder_nvidia_cuda", 0L), o.to("duration_encoder_nvidia_direct3d", 0L), o.to("duration_encoder_openh264", 0L), o.to("duration_encoder_videotoolbox", 0L), o.to("duration_encoder_amd_direct3d", 0L), o.to("duration_encoder_intel", 0L), o.to("duration_encoder_intel_direct3d", 0L), o.to("duration_encoder_unknown", 0L)));
    }

    public final Map<String, Object> e(e$e e_e) {
        Float fValueOf;
        long jCurrentTimeMillis = this.q.currentTimeMillis();
        Long l = this.h;
        float fLongValue = (l != null ? l.longValue() - this.g : jCurrentTimeMillis - this.g) / 1000.0f;
        float f = e_e.f / 1000.0f;
        float f2 = 0;
        long jRoundToLong = (f <= f2 || (fValueOf = Float.valueOf(e_e.i / f)) == null) ? 0L : d0.a0.a.roundToLong(fValueOf.floatValue());
        Histogram$Report report = e_e.f283b.getReport();
        Histogram$Report report2 = e_e.c.getReport();
        e$b e_b = d;
        long j = 1024;
        Map mapMapOf = h0.mapOf(o.to("duration", Double.valueOf(Math.floor(fLongValue))), b.d.b.a.a.b0(e_b, e_e.g.get(8000000), "duration_stream_under_8mbps"), b.d.b.a.a.b0(e_b, e_e.g.get(7000000), "duration_stream_under_7mbps"), b.d.b.a.a.b0(e_b, e_e.g.get(6000000), "duration_stream_under_6mbps"), b.d.b.a.a.b0(e_b, e_e.g.get(5000000), "duration_stream_under_5mbps"), b.d.b.a.a.b0(e_b, e_e.g.get(4000000), "duration_stream_under_4mbps"), b.d.b.a.a.b0(e_b, e_e.g.get(3000000), "duration_stream_under_3mbps"), b.d.b.a.a.b0(e_b, e_e.g.get(2000000), "duration_stream_under_2mbps"), b.d.b.a.a.b0(e_b, e_e.g.get(1500000), "duration_stream_under_1_5mbps"), b.d.b.a.a.b0(e_b, e_e.g.get(1000000), "duration_stream_under_1mbps"), b.d.b.a.a.b0(e_b, e_e.g.get(500000), "duration_stream_under_0_5mbps"), b.d.b.a.a.b0(e_b, e_e.g.get(0), "duration_stream_at_0mbps"), b.d.b.a.a.b0(e_b, e_e.h.get(60), "duration_fps_under_60"), b.d.b.a.a.b0(e_b, e_e.h.get(55), "duration_fps_under_55"), b.d.b.a.a.b0(e_b, e_e.h.get(50), "duration_fps_under_50"), b.d.b.a.a.b0(e_b, e_e.h.get(45), "duration_fps_under_45"), b.d.b.a.a.b0(e_b, e_e.h.get(40), "duration_fps_under_40"), b.d.b.a.a.b0(e_b, e_e.h.get(35), "duration_fps_under_35"), b.d.b.a.a.b0(e_b, e_e.h.get(30), "duration_fps_under_30"), b.d.b.a.a.b0(e_b, e_e.h.get(25), "duration_fps_under_25"), b.d.b.a.a.b0(e_b, e_e.h.get(20), "duration_fps_under_20"), b.d.b.a.a.b0(e_b, e_e.h.get(15), "duration_fps_under_15"), b.d.b.a.a.b0(e_b, e_e.h.get(10), "duration_fps_under_10"), b.d.b.a.a.b0(e_b, e_e.h.get(5), "duration_fps_under_5"), b.d.b.a.a.b0(e_b, e_e.h.get(0), "duration_fps_at_0"), o.to("avg_resolution", Long.valueOf(jRoundToLong)), b.d.b.a.a.b0(e_b, e_e.j.get(720), "duration_resolution_under_720"), b.d.b.a.a.b0(e_b, e_e.j.get(480), "duration_resolution_under_480"), b.d.b.a.a.b0(e_b, e_e.j.get(360), "duration_resolution_under_360"), o.to("num_pauses", 0), o.to("duration_paused", Long.valueOf(e$b.a(e_b, Float.valueOf(this.i.c(jCurrentTimeMillis) / 1000.0f)))), o.to("duration_zero_receivers", Long.valueOf(e$b.a(e_b, Float.valueOf(this.j.c(jCurrentTimeMillis) / 1000.0f)))), o.to("duration_video_stopped", Long.valueOf(e$b.a(e_b, Float.valueOf(this.k.c(jCurrentTimeMillis) / 1000.0f)))), o.to("client_performance_cpu_percentile25", Long.valueOf(report.getPercentile25())), o.to("client_performance_cpu_percentile50", Long.valueOf(report.getPercentile50())), o.to("client_performance_cpu_percentile75", Long.valueOf(report.getPercentile75())), o.to("client_performance_cpu_percentile90", Long.valueOf(report.getPercentile90())), o.to("client_performance_cpu_percentile95", Long.valueOf(report.getPercentile95())), o.to("client_performance_memory_percentile25", Long.valueOf(report2.getPercentile25() / j)), o.to("client_performance_memory_percentile50", Long.valueOf(report2.getPercentile50() / j)), o.to("client_performance_memory_percentile75", Long.valueOf(report2.getPercentile75() / j)), o.to("client_performance_memory_percentile90", Long.valueOf(report2.getPercentile90() / j)), o.to("client_performance_memory_percentile95", Long.valueOf(report2.getPercentile95() / j)), o.to("client_performance_memory_min", Long.valueOf(report2.getMin() / j)), o.to("client_performance_memory_max", Long.valueOf(report2.getMax() / j)));
        e$a e_a = e_e.e;
        long jA = f > f2 ? e$b.a(e_b, Float.valueOf((e_a.f * ((long) 8)) / f)) : 0L;
        long jA2 = f > f2 ? e$b.a(e_b, Float.valueOf(e_a.a / f)) : 0L;
        Pair[] pairArr = new Pair[16];
        pairArr[0] = o.to("avg_bitrate", Long.valueOf(jA));
        pairArr[1] = o.to("avg_fps", Long.valueOf(jA2));
        pairArr[2] = o.to("num_bytes", Long.valueOf(e_a.f));
        pairArr[3] = o.to("num_packets_lost", Long.valueOf(e_a.d));
        pairArr[4] = o.to("num_packets", Long.valueOf(e_a.c));
        pairArr[5] = o.to("num_frames", Long.valueOf(e_a.f281b));
        Long l2 = e_e.d;
        pairArr[6] = o.to("time_to_first_frame_ms", Long.valueOf(l2 != null ? l2.longValue() : 0L));
        pairArr[7] = o.to("num_frames_dropped", Long.valueOf(e_a.e));
        pairArr[8] = o.to("num_nacks", Long.valueOf(e_a.g));
        pairArr[9] = o.to("num_plis", Long.valueOf(e_a.h));
        pairArr[10] = o.to("qp_sum", Long.valueOf(e_a.i));
        pairArr[11] = o.to("receiver_freeze_count", Long.valueOf(e_a.j));
        pairArr[12] = o.to("receiver_pause_count", Long.valueOf(e_a.k));
        pairArr[13] = o.to("receiver_total_freezes_duration", Long.valueOf(e_a.l));
        pairArr[14] = o.to("receiver_total_pauses_duration", Long.valueOf(e_a.m));
        pairArr[15] = o.to("receiver_total_frames_duration", Long.valueOf(e_a.n));
        return h0.plus(mapMapOf, h0.mapOf(pairArr));
    }

    public final e$g f(InboundRtpVideo inboundRtpVideo, long j) {
        return new e$g(inboundRtpVideo.getResolution().getHeight(), j, new e$a(inboundRtpVideo.getFramesDecoded(), inboundRtpVideo.getFramesReceived(), inboundRtpVideo.getPacketsReceived(), inboundRtpVideo.getPacketsLost(), inboundRtpVideo.getFramesDropped(), inboundRtpVideo.getBytesReceived(), inboundRtpVideo.getNackCount(), inboundRtpVideo.getPliCount(), inboundRtpVideo.getQpSum(), inboundRtpVideo.getFreezeCount(), inboundRtpVideo.getPauseCount(), inboundRtpVideo.getTotalFreezesDuration(), inboundRtpVideo.getTotalPausesDuration(), inboundRtpVideo.getTotalFramesDuration()));
    }

    public final void g(Boolean bool, Integer num, long j) {
        if (num != null) {
            this.j.b(num.intValue() == 0, j);
        }
        boolean z2 = this.i.a() || this.j.a();
        if (z2 != this.k.a()) {
            this.k.b(z2, j);
            this.l.a.clear();
        }
    }
}
