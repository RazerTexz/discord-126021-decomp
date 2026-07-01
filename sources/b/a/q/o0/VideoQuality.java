package b.a.q.o0;

import androidx.annotation.AnyThread;
import b.d.b.a.outline;
import co.discord.media_engine.InboundRtpVideo;
import com.discord.utilities.collections.Histogram;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollection2;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.system.DeviceResourceUsageMonitor;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeSpan;
import d0.Tuples;
import d0.a0.MathJVM;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.t.MutableCollections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: b.a.q.o0.e, reason: use source file name */
/* JADX INFO: compiled from: VideoQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VideoQuality {
    public final ListenerCollection2<?> e;
    public final ListenerCollection<?> f;
    public final long g;
    public Long h;
    public final d i;
    public final d j;
    public final d k;
    public final f l;
    public final Map<String, e> m;
    public final Map<Long, Long> n;
    public final DeviceResourceUsageMonitor o;
    public final Logger p;
    public final Clock q;
    public static final b d = new b(null);
    public static final List<Integer> a = Collections2.listOf((Object[]) new Integer[]{0, 500000, 1000000, 1500000, 2000000, 3000000, 4000000, 5000000, 6000000, 7000000, 8000000});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Integer> f280b = Collections2.listOf((Object[]) new Integer[]{0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60});
    public static final List<Integer> c = Collections2.listOf((Object[]) new Integer[]{720, 480, 360});

    /* JADX INFO: renamed from: b.a.q.o0.e$a */
    /* JADX INFO: compiled from: VideoQuality.kt */
    public static final class a {
        public long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f281b;
        public long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j;
        public long k;
        public long l;
        public long m;
        public long n;

        public a() {
            this(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 16383);
        }

        public a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
            this.a = j;
            this.f281b = j2;
            this.c = j3;
            this.d = j4;
            this.e = j5;
            this.f = j6;
            this.g = j7;
            this.h = j8;
            this.i = j9;
            this.j = j10;
            this.k = j11;
            this.l = j12;
            this.m = j13;
            this.n = j14;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f281b == aVar.f281b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && this.f == aVar.f && this.g == aVar.g && this.h == aVar.h && this.i == aVar.i && this.j == aVar.j && this.k == aVar.k && this.l == aVar.l && this.m == aVar.m && this.n == aVar.n;
        }

        public int hashCode() {
            return a0.a.a.b.a(this.n) + ((a0.a.a.b.a(this.m) + ((a0.a.a.b.a(this.l) + ((a0.a.a.b.a(this.k) + ((a0.a.a.b.a(this.j) + ((a0.a.a.b.a(this.i) + ((a0.a.a.b.a(this.h) + ((a0.a.a.b.a(this.g) + ((a0.a.a.b.a(this.f) + ((a0.a.a.b.a(this.e) + ((a0.a.a.b.a(this.d) + ((a0.a.a.b.a(this.c) + ((a0.a.a.b.a(this.f281b) + (a0.a.a.b.a(this.a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("AggregatedProperties(framesCodec=");
            sbU.append(this.a);
            sbU.append(", framesNetwork=");
            sbU.append(this.f281b);
            sbU.append(", packets=");
            sbU.append(this.c);
            sbU.append(", packetsLost=");
            sbU.append(this.d);
            sbU.append(", framesDropped=");
            sbU.append(this.e);
            sbU.append(", bytes=");
            sbU.append(this.f);
            sbU.append(", nackCount=");
            sbU.append(this.g);
            sbU.append(", pliCount=");
            sbU.append(this.h);
            sbU.append(", qpSum=");
            sbU.append(this.i);
            sbU.append(", freezeCount=");
            sbU.append(this.j);
            sbU.append(", pauseCount=");
            sbU.append(this.k);
            sbU.append(", totalFreezesDuration=");
            sbU.append(this.l);
            sbU.append(", totalPausesDuration=");
            sbU.append(this.m);
            sbU.append(", totalFramesDuration=");
            return outline.C(sbU, this.n, ")");
        }

        public /* synthetic */ a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, int i) {
            this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? 0L : j3, (i & 8) != 0 ? 0L : j4, (i & 16) != 0 ? 0L : j5, (i & 32) != 0 ? 0L : j6, (i & 64) != 0 ? 0L : j7, (i & 128) != 0 ? 0L : j8, (i & 256) != 0 ? 0L : j9, (i & 512) != 0 ? 0L : j10, (i & 1024) != 0 ? 0L : j11, (i & 2048) != 0 ? 0L : j12, (i & 4096) != 0 ? 0L : j13, (i & 8192) == 0 ? j14 : 0L);
        }
    }

    /* JADX INFO: renamed from: b.a.q.o0.e$b */
    /* JADX INFO: compiled from: VideoQuality.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final long a(b bVar, Float f) {
            if (f != null) {
                return MathJVM.roundToLong(f.floatValue());
            }
            return 0L;
        }
    }

    /* JADX INFO: renamed from: b.a.q.o0.e$c */
    /* JADX INFO: compiled from: VideoQuality.kt */
    public static abstract class c {
    }

    /* JADX INFO: renamed from: b.a.q.o0.e$d */
    /* JADX INFO: compiled from: VideoQuality.kt */
    public static final class d {
        public Long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f282b;

        public d(boolean z2, long j) {
            this.a = z2 ? Long.valueOf(j) : null;
        }

        public final boolean a() {
            return this.a != null;
        }

        public final void b(boolean z2, long j) {
            Long l = this.a;
            if (l == null) {
                if (z2) {
                    this.a = Long.valueOf(j);
                }
            } else if (l != null) {
                long jLongValue = l.longValue();
                if (z2) {
                    return;
                }
                this.f282b = (j - jLongValue) + this.f282b;
                this.a = null;
            }
        }

        public final long c(long j) {
            Long l = this.a;
            if (l == null) {
                return this.f282b;
            }
            return (this.f282b + j) - l.longValue();
        }
    }

    /* JADX INFO: renamed from: b.a.q.o0.e$e */
    /* JADX INFO: compiled from: VideoQuality.kt */
    public static class e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Histogram f283b;
        public final Histogram c;
        public Long d;
        public long f;
        public float i;
        public List<g> a = new ArrayList();
        public a e = new a(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16383);
        public Map<Integer, Float> g = new LinkedHashMap();
        public Map<Integer, Float> h = new LinkedHashMap();
        public Map<Integer, Float> j = new LinkedHashMap();

        public e() {
            int i = 0;
            int i2 = 2;
            DefaultConstructorMarker defaultConstructorMarker = null;
            this.f283b = new Histogram(5, i, i2, defaultConstructorMarker);
            this.c = new Histogram(25600, i, i2, defaultConstructorMarker);
            Iterator<T> it = VideoQuality.a.iterator();
            while (it.hasNext()) {
                this.g.put(Integer.valueOf(((Number) it.next()).intValue()), Float.valueOf(0.0f));
            }
            Iterator<T> it2 = VideoQuality.f280b.iterator();
            while (it2.hasNext()) {
                this.h.put(Integer.valueOf(((Number) it2.next()).intValue()), Float.valueOf(0.0f));
            }
            Iterator<T> it3 = VideoQuality.c.iterator();
            while (it3.hasNext()) {
                this.j.put(Integer.valueOf(((Number) it3.next()).intValue()), Float.valueOf(0.0f));
            }
        }
    }

    /* JADX INFO: renamed from: b.a.q.o0.e$f */
    /* JADX INFO: compiled from: VideoQuality.kt */
    public static final class f extends e {
        public int k = 2500000;
        public int l = 30;
        public long m;
        public long n;
        public long o;
    }

    /* JADX INFO: renamed from: b.a.q.o0.e$g */
    /* JADX INFO: compiled from: VideoQuality.kt */
    public static final class g {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f284b;
        public final a c;

        public g(long j, long j2, a aVar) {
            Intrinsics3.checkNotNullParameter(aVar, "aggregatedProperties");
            this.a = j;
            this.f284b = j2;
            this.c = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.a == gVar.a && this.f284b == gVar.f284b && Intrinsics3.areEqual(this.c, gVar.c);
        }

        public int hashCode() {
            int iA = (a0.a.a.b.a(this.f284b) + (a0.a.a.b.a(this.a) * 31)) * 31;
            a aVar = this.c;
            return iA + (aVar != null ? aVar.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("RawVideoStats(resolution=");
            sbU.append(this.a);
            sbU.append(", timestamp=");
            sbU.append(this.f284b);
            sbU.append(", aggregatedProperties=");
            sbU.append(this.c);
            sbU.append(")");
            return sbU.toString();
        }

        public g() {
            this(0L, 0L, new a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 16383));
        }
    }

    /* JADX INFO: renamed from: b.a.q.o0.e$h */
    /* JADX INFO: compiled from: VideoQuality.kt */
    public static final class h extends Lambda implements Function1<DeviceResourceUsageMonitor.ResourceUsage, Unit> {
        public h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DeviceResourceUsageMonitor.ResourceUsage resourceUsage) {
            DeviceResourceUsageMonitor.ResourceUsage resourceUsage2 = resourceUsage;
            Intrinsics3.checkNotNullParameter(resourceUsage2, "it");
            VideoQuality videoQuality = VideoQuality.this;
            List<Integer> list = VideoQuality.a;
            synchronized (videoQuality) {
                Iterator<Map.Entry<String, e>> it = videoQuality.m.entrySet().iterator();
                while (it.hasNext()) {
                    e value = it.next().getValue();
                    value.f283b.addSample(resourceUsage2.getCpuUsagePercent());
                    value.c.addSample(resourceUsage2.getMemoryRssBytes());
                }
                videoQuality.l.f283b.addSample(resourceUsage2.getCpuUsagePercent());
                videoQuality.l.c.addSample(resourceUsage2.getMemoryRssBytes());
            }
            return Unit.a;
        }
    }

    public VideoQuality(Logger logger, Clock clock) {
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.p = logger;
        this.q = clock;
        ListenerCollection2<?> listenerCollection2 = new ListenerCollection2<>();
        this.e = listenerCollection2;
        this.f = listenerCollection2;
        long jCurrentTimeMillis = clock.currentTimeMillis();
        this.g = jCurrentTimeMillis;
        this.i = new d(false, jCurrentTimeMillis);
        this.j = new d(false, jCurrentTimeMillis);
        this.k = new d(false, jCurrentTimeMillis);
        this.l = new f();
        this.m = new LinkedHashMap();
        this.n = new LinkedHashMap();
        DeviceResourceUsageMonitor deviceResourceUsageMonitor = new DeviceResourceUsageMonitor(new TimeSpan(1L, TimeUnit.SECONDS), clock, new h());
        this.o = deviceResourceUsageMonitor;
        deviceResourceUsageMonitor.start();
    }

    public final void a(e eVar, g gVar) {
        eVar.a.add(gVar);
        if (eVar.a.size() < 2) {
            return;
        }
        List<g> list = eVar.a;
        g gVar2 = list.get(list.size() - 1);
        List<g> list2 = eVar.a;
        g gVar3 = list2.get(list2.size() - 2);
        VideoQuality2 videoQuality2 = VideoQuality2.j;
        eVar.f = (gVar2.f284b - gVar3.f284b) + eVar.f;
        a aVar = eVar.e;
        a aVar2 = gVar2.c;
        a aVar3 = gVar3.c;
        aVar.a = videoQuality2.a(aVar2.a, aVar3.a) + aVar.a;
        aVar.f281b = videoQuality2.a(aVar2.f281b, aVar3.f281b) + aVar.f281b;
        aVar.c = videoQuality2.a(aVar2.c, aVar3.c) + aVar.c;
        aVar.d = videoQuality2.a(aVar2.d, aVar3.d) + aVar.d;
        aVar.e = videoQuality2.a(aVar2.e, aVar3.e) + aVar.e;
        aVar.f = videoQuality2.a(aVar2.f, aVar3.f) + aVar.f;
        aVar.g = videoQuality2.a(aVar2.g, aVar3.g) + aVar.g;
        aVar.h = videoQuality2.a(aVar2.h, aVar3.h) + aVar.h;
        aVar.i = videoQuality2.a(aVar2.i, aVar3.i) + aVar.i;
        aVar.j = videoQuality2.a(aVar2.j, aVar3.j) + aVar.j;
        aVar.k = videoQuality2.a(aVar2.j, aVar3.j) + aVar.k;
        aVar.l = videoQuality2.a(aVar2.l, aVar3.l) + aVar.l;
        aVar.m = videoQuality2.a(aVar2.m, aVar3.m) + aVar.m;
        aVar.n = videoQuality2.a(aVar2.n, aVar3.n) + aVar.n;
        a aVar4 = gVar2.c;
        long j = aVar4.f;
        long j2 = aVar4.a;
        long j3 = gVar2.f284b;
        long j4 = gVar2.a;
        float f2 = (j3 - gVar3.f284b) / 1000.0f;
        eVar.i = (j4 * f2) + eVar.i;
        if (eVar.a.size() < 6) {
            return;
        }
        List<g> list3 = eVar.a;
        g gVar4 = list3.get(list3.size() - 3);
        a aVar5 = gVar4.c;
        long j5 = aVar5.f;
        long j6 = aVar5.a;
        long j7 = gVar4.f284b;
        Iterator<T> it = c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            long j8 = j2;
            int iIntValue = ((Number) it.next()).intValue();
            long j9 = j6;
            if (j4 <= iIntValue) {
                Map<Integer, Float> map = eVar.j;
                Integer numValueOf = Integer.valueOf(iIntValue);
                Float f3 = eVar.j.get(Integer.valueOf(iIntValue));
                map.put(numValueOf, Float.valueOf((f3 != null ? f3.floatValue() : 0.0f) + f2));
            }
            j2 = j8;
            j6 = j9;
        }
        float f4 = (j3 - j7) / 1000.0f;
        float f5 = ((j - j5) * ((long) 8)) / f4;
        float f6 = (j2 - j6) / f4;
        Iterator<T> it2 = a.iterator();
        while (it2.hasNext()) {
            int iIntValue2 = ((Number) it2.next()).intValue();
            if (f5 <= iIntValue2) {
                Map<Integer, Float> map2 = eVar.g;
                Integer numValueOf2 = Integer.valueOf(iIntValue2);
                Float f7 = eVar.g.get(Integer.valueOf(iIntValue2));
                map2.put(numValueOf2, Float.valueOf((f7 != null ? f7.floatValue() : 0.0f) + f2));
            }
        }
        Iterator<T> it3 = f280b.iterator();
        while (it3.hasNext()) {
            int iIntValue3 = ((Number) it3.next()).intValue();
            if (f6 <= iIntValue3) {
                Map<Integer, Float> map3 = eVar.h;
                Integer numValueOf3 = Integer.valueOf(iIntValue3);
                Float f8 = eVar.h.get(Integer.valueOf(iIntValue3));
                map3.put(numValueOf3, Float.valueOf((f8 != null ? f8.floatValue() : 0.0f) + f2));
            }
        }
        MutableCollections.removeFirst(eVar.a);
    }

    public final void b(int i) {
        if (this.l.a.size() < 2) {
            return;
        }
        List<g> list = this.l.a;
        long j = list.get(list.size() - 1).f284b;
        List<g> list2 = this.l.a;
        float f2 = (j - list2.get(list2.size() - 2).f284b) / 1000.0f;
        f fVar = this.l;
        long j2 = fVar.m;
        Float fValueOf = Float.valueOf(fVar.l * f2);
        fVar.m = j2 + (fValueOf != null ? MathJVM.roundToLong(fValueOf.floatValue()) : 0L);
        f fVar2 = this.l;
        long j3 = fVar2.n;
        Float fValueOf2 = Float.valueOf((i / 8.0f) * f2);
        fVar2.n = j3 + (fValueOf2 != null ? MathJVM.roundToLong(fValueOf2.floatValue()) : 0L);
        f fVar3 = this.l;
        long j4 = fVar3.o;
        Float fValueOf3 = Float.valueOf((fVar3.k / 8.0f) * f2);
        fVar3.o = j4 + (fValueOf3 != null ? MathJVM.roundToLong(fValueOf3.floatValue()) : 0L);
    }

    @AnyThread
    public final synchronized Map<String, Object> c(String str) {
        e eVar;
        Intrinsics3.checkNotNullParameter(str, "userId");
        eVar = this.m.get(str);
        return eVar != null ? e(eVar) : null;
    }

    @AnyThread
    public final synchronized Map<String, Object> d() {
        f fVar;
        float f2;
        float f3;
        Float fValueOf;
        Float fValueOf2;
        Float fValueOf3;
        fVar = this.l;
        f2 = fVar.f / 1000.0f;
        f3 = 0;
        return Maps6.plus(e(this.l), Maps6.mapOf(Tuples.to("target_bitrate_max", Long.valueOf((f2 <= f3 || (fValueOf3 = Float.valueOf(((float) (fVar.o * ((long) 8))) / f2)) == null) ? 0L : MathJVM.roundToLong(fValueOf3.floatValue()))), Tuples.to("target_bitrate_network", Long.valueOf((f2 <= f3 || (fValueOf2 = Float.valueOf(((float) (this.l.n * ((long) 8))) / f2)) == null) ? 0L : MathJVM.roundToLong(fValueOf2.floatValue()))), Tuples.to("target_fps", Long.valueOf((f2 <= f3 || (fValueOf = Float.valueOf(((float) this.l.m) / f2)) == null) ? 0L : MathJVM.roundToLong(fValueOf.floatValue()))), Tuples.to("duration_encoder_nvidia_cuda", 0L), Tuples.to("duration_encoder_nvidia_direct3d", 0L), Tuples.to("duration_encoder_openh264", 0L), Tuples.to("duration_encoder_videotoolbox", 0L), Tuples.to("duration_encoder_amd_direct3d", 0L), Tuples.to("duration_encoder_intel", 0L), Tuples.to("duration_encoder_intel_direct3d", 0L), Tuples.to("duration_encoder_unknown", 0L)));
    }

    public final Map<String, Object> e(e eVar) {
        Float fValueOf;
        long jCurrentTimeMillis = this.q.currentTimeMillis();
        Long l = this.h;
        float fLongValue = (l != null ? l.longValue() - this.g : jCurrentTimeMillis - this.g) / 1000.0f;
        float f2 = eVar.f / 1000.0f;
        float f3 = 0;
        long jRoundToLong = (f2 <= f3 || (fValueOf = Float.valueOf(eVar.i / f2)) == null) ? 0L : MathJVM.roundToLong(fValueOf.floatValue());
        Histogram.Report report = eVar.f283b.getReport();
        Histogram.Report report2 = eVar.c.getReport();
        b bVar = d;
        long j = 1024;
        Map mapMapOf = Maps6.mapOf(Tuples.to("duration", Double.valueOf(Math.floor(fLongValue))), outline.b0(bVar, eVar.g.get(8000000), "duration_stream_under_8mbps"), outline.b0(bVar, eVar.g.get(7000000), "duration_stream_under_7mbps"), outline.b0(bVar, eVar.g.get(6000000), "duration_stream_under_6mbps"), outline.b0(bVar, eVar.g.get(5000000), "duration_stream_under_5mbps"), outline.b0(bVar, eVar.g.get(4000000), "duration_stream_under_4mbps"), outline.b0(bVar, eVar.g.get(3000000), "duration_stream_under_3mbps"), outline.b0(bVar, eVar.g.get(2000000), "duration_stream_under_2mbps"), outline.b0(bVar, eVar.g.get(1500000), "duration_stream_under_1_5mbps"), outline.b0(bVar, eVar.g.get(1000000), "duration_stream_under_1mbps"), outline.b0(bVar, eVar.g.get(500000), "duration_stream_under_0_5mbps"), outline.b0(bVar, eVar.g.get(0), "duration_stream_at_0mbps"), outline.b0(bVar, eVar.h.get(60), "duration_fps_under_60"), outline.b0(bVar, eVar.h.get(55), "duration_fps_under_55"), outline.b0(bVar, eVar.h.get(50), "duration_fps_under_50"), outline.b0(bVar, eVar.h.get(45), "duration_fps_under_45"), outline.b0(bVar, eVar.h.get(40), "duration_fps_under_40"), outline.b0(bVar, eVar.h.get(35), "duration_fps_under_35"), outline.b0(bVar, eVar.h.get(30), "duration_fps_under_30"), outline.b0(bVar, eVar.h.get(25), "duration_fps_under_25"), outline.b0(bVar, eVar.h.get(20), "duration_fps_under_20"), outline.b0(bVar, eVar.h.get(15), "duration_fps_under_15"), outline.b0(bVar, eVar.h.get(10), "duration_fps_under_10"), outline.b0(bVar, eVar.h.get(5), "duration_fps_under_5"), outline.b0(bVar, eVar.h.get(0), "duration_fps_at_0"), Tuples.to("avg_resolution", Long.valueOf(jRoundToLong)), outline.b0(bVar, eVar.j.get(720), "duration_resolution_under_720"), outline.b0(bVar, eVar.j.get(480), "duration_resolution_under_480"), outline.b0(bVar, eVar.j.get(360), "duration_resolution_under_360"), Tuples.to("num_pauses", 0), Tuples.to("duration_paused", Long.valueOf(b.a(bVar, Float.valueOf(this.i.c(jCurrentTimeMillis) / 1000.0f)))), Tuples.to("duration_zero_receivers", Long.valueOf(b.a(bVar, Float.valueOf(this.j.c(jCurrentTimeMillis) / 1000.0f)))), Tuples.to("duration_video_stopped", Long.valueOf(b.a(bVar, Float.valueOf(this.k.c(jCurrentTimeMillis) / 1000.0f)))), Tuples.to("client_performance_cpu_percentile25", Long.valueOf(report.getPercentile25())), Tuples.to("client_performance_cpu_percentile50", Long.valueOf(report.getPercentile50())), Tuples.to("client_performance_cpu_percentile75", Long.valueOf(report.getPercentile75())), Tuples.to("client_performance_cpu_percentile90", Long.valueOf(report.getPercentile90())), Tuples.to("client_performance_cpu_percentile95", Long.valueOf(report.getPercentile95())), Tuples.to("client_performance_memory_percentile25", Long.valueOf(report2.getPercentile25() / j)), Tuples.to("client_performance_memory_percentile50", Long.valueOf(report2.getPercentile50() / j)), Tuples.to("client_performance_memory_percentile75", Long.valueOf(report2.getPercentile75() / j)), Tuples.to("client_performance_memory_percentile90", Long.valueOf(report2.getPercentile90() / j)), Tuples.to("client_performance_memory_percentile95", Long.valueOf(report2.getPercentile95() / j)), Tuples.to("client_performance_memory_min", Long.valueOf(report2.getMin() / j)), Tuples.to("client_performance_memory_max", Long.valueOf(report2.getMax() / j)));
        a aVar = eVar.e;
        long jA = f2 > f3 ? b.a(bVar, Float.valueOf((aVar.f * ((long) 8)) / f2)) : 0L;
        long jA2 = f2 > f3 ? b.a(bVar, Float.valueOf(aVar.a / f2)) : 0L;
        Tuples2[] tuples2Arr = new Tuples2[16];
        tuples2Arr[0] = Tuples.to("avg_bitrate", Long.valueOf(jA));
        tuples2Arr[1] = Tuples.to("avg_fps", Long.valueOf(jA2));
        tuples2Arr[2] = Tuples.to("num_bytes", Long.valueOf(aVar.f));
        tuples2Arr[3] = Tuples.to("num_packets_lost", Long.valueOf(aVar.d));
        tuples2Arr[4] = Tuples.to("num_packets", Long.valueOf(aVar.c));
        tuples2Arr[5] = Tuples.to("num_frames", Long.valueOf(aVar.f281b));
        Long l2 = eVar.d;
        tuples2Arr[6] = Tuples.to("time_to_first_frame_ms", Long.valueOf(l2 != null ? l2.longValue() : 0L));
        tuples2Arr[7] = Tuples.to("num_frames_dropped", Long.valueOf(aVar.e));
        tuples2Arr[8] = Tuples.to("num_nacks", Long.valueOf(aVar.g));
        tuples2Arr[9] = Tuples.to("num_plis", Long.valueOf(aVar.h));
        tuples2Arr[10] = Tuples.to("qp_sum", Long.valueOf(aVar.i));
        tuples2Arr[11] = Tuples.to("receiver_freeze_count", Long.valueOf(aVar.j));
        tuples2Arr[12] = Tuples.to("receiver_pause_count", Long.valueOf(aVar.k));
        tuples2Arr[13] = Tuples.to("receiver_total_freezes_duration", Long.valueOf(aVar.l));
        tuples2Arr[14] = Tuples.to("receiver_total_pauses_duration", Long.valueOf(aVar.m));
        tuples2Arr[15] = Tuples.to("receiver_total_frames_duration", Long.valueOf(aVar.n));
        return Maps6.plus(mapMapOf, Maps6.mapOf(tuples2Arr));
    }

    public final g f(InboundRtpVideo inboundRtpVideo, long j) {
        return new g(inboundRtpVideo.getResolution().getHeight(), j, new a(inboundRtpVideo.getFramesDecoded(), inboundRtpVideo.getFramesReceived(), inboundRtpVideo.getPacketsReceived(), inboundRtpVideo.getPacketsLost(), inboundRtpVideo.getFramesDropped(), inboundRtpVideo.getBytesReceived(), inboundRtpVideo.getNackCount(), inboundRtpVideo.getPliCount(), inboundRtpVideo.getQpSum(), inboundRtpVideo.getFreezeCount(), inboundRtpVideo.getPauseCount(), inboundRtpVideo.getTotalFreezesDuration(), inboundRtpVideo.getTotalPausesDuration(), inboundRtpVideo.getTotalFramesDuration()));
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
