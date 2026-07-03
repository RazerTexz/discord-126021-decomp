package p007b.p008a.p041q.p047o0;

import androidx.annotation.AnyThread;
import co.discord.media_engine.InboundRtpVideo;
import com.discord.utilities.collections.Histogram;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollectionSubject;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.system.DeviceResourceUsageMonitor;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p508a0.C11210a;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12160r;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.o0.e */
/* JADX INFO: compiled from: VideoQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1256e {

    /* JADX INFO: renamed from: e */
    public final ListenerCollectionSubject<?> f1820e;

    /* JADX INFO: renamed from: f */
    public final ListenerCollection<?> f1821f;

    /* JADX INFO: renamed from: g */
    public final long f1822g;

    /* JADX INFO: renamed from: h */
    public Long f1823h;

    /* JADX INFO: renamed from: i */
    public final d f1824i;

    /* JADX INFO: renamed from: j */
    public final d f1825j;

    /* JADX INFO: renamed from: k */
    public final d f1826k;

    /* JADX INFO: renamed from: l */
    public final f f1827l;

    /* JADX INFO: renamed from: m */
    public final Map<String, e> f1828m;

    /* JADX INFO: renamed from: n */
    public final Map<Long, Long> f1829n;

    /* JADX INFO: renamed from: o */
    public final DeviceResourceUsageMonitor f1830o;

    /* JADX INFO: renamed from: p */
    public final Logger f1831p;

    /* JADX INFO: renamed from: q */
    public final Clock f1832q;

    /* JADX INFO: renamed from: d */
    public static final b f1819d = new b(null);

    /* JADX INFO: renamed from: a */
    public static final List<Integer> f1816a = C12147n.listOf((Object[]) new Integer[]{0, 500000, 1000000, 1500000, 2000000, 3000000, 4000000, 5000000, 6000000, 7000000, 8000000});

    /* JADX INFO: renamed from: b */
    public static final List<Integer> f1817b = C12147n.listOf((Object[]) new Integer[]{0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60});

    /* JADX INFO: renamed from: c */
    public static final List<Integer> f1818c = C12147n.listOf((Object[]) new Integer[]{720, 480, 360});

    /* JADX INFO: renamed from: b.a.q.o0.e$a */
    /* JADX INFO: compiled from: VideoQuality.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public long f1833a;

        /* JADX INFO: renamed from: b */
        public long f1834b;

        /* JADX INFO: renamed from: c */
        public long f1835c;

        /* JADX INFO: renamed from: d */
        public long f1836d;

        /* JADX INFO: renamed from: e */
        public long f1837e;

        /* JADX INFO: renamed from: f */
        public long f1838f;

        /* JADX INFO: renamed from: g */
        public long f1839g;

        /* JADX INFO: renamed from: h */
        public long f1840h;

        /* JADX INFO: renamed from: i */
        public long f1841i;

        /* JADX INFO: renamed from: j */
        public long f1842j;

        /* JADX INFO: renamed from: k */
        public long f1843k;

        /* JADX INFO: renamed from: l */
        public long f1844l;

        /* JADX INFO: renamed from: m */
        public long f1845m;

        /* JADX INFO: renamed from: n */
        public long f1846n;

        public a() {
            this(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 16383);
        }

        public a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
            this.f1833a = j;
            this.f1834b = j2;
            this.f1835c = j3;
            this.f1836d = j4;
            this.f1837e = j5;
            this.f1838f = j6;
            this.f1839g = j7;
            this.f1840h = j8;
            this.f1841i = j9;
            this.f1842j = j10;
            this.f1843k = j11;
            this.f1844l = j12;
            this.f1845m = j13;
            this.f1846n = j14;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1833a == aVar.f1833a && this.f1834b == aVar.f1834b && this.f1835c == aVar.f1835c && this.f1836d == aVar.f1836d && this.f1837e == aVar.f1837e && this.f1838f == aVar.f1838f && this.f1839g == aVar.f1839g && this.f1840h == aVar.f1840h && this.f1841i == aVar.f1841i && this.f1842j == aVar.f1842j && this.f1843k == aVar.f1843k && this.f1844l == aVar.f1844l && this.f1845m == aVar.f1845m && this.f1846n == aVar.f1846n;
        }

        public int hashCode() {
            return C0002b.m3a(this.f1846n) + ((C0002b.m3a(this.f1845m) + ((C0002b.m3a(this.f1844l) + ((C0002b.m3a(this.f1843k) + ((C0002b.m3a(this.f1842j) + ((C0002b.m3a(this.f1841i) + ((C0002b.m3a(this.f1840h) + ((C0002b.m3a(this.f1839g) + ((C0002b.m3a(this.f1838f) + ((C0002b.m3a(this.f1837e) + ((C0002b.m3a(this.f1836d) + ((C0002b.m3a(this.f1835c) + ((C0002b.m3a(this.f1834b) + (C0002b.m3a(this.f1833a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("AggregatedProperties(framesCodec=");
            sbM833U.append(this.f1833a);
            sbM833U.append(", framesNetwork=");
            sbM833U.append(this.f1834b);
            sbM833U.append(", packets=");
            sbM833U.append(this.f1835c);
            sbM833U.append(", packetsLost=");
            sbM833U.append(this.f1836d);
            sbM833U.append(", framesDropped=");
            sbM833U.append(this.f1837e);
            sbM833U.append(", bytes=");
            sbM833U.append(this.f1838f);
            sbM833U.append(", nackCount=");
            sbM833U.append(this.f1839g);
            sbM833U.append(", pliCount=");
            sbM833U.append(this.f1840h);
            sbM833U.append(", qpSum=");
            sbM833U.append(this.f1841i);
            sbM833U.append(", freezeCount=");
            sbM833U.append(this.f1842j);
            sbM833U.append(", pauseCount=");
            sbM833U.append(this.f1843k);
            sbM833U.append(", totalFreezesDuration=");
            sbM833U.append(this.f1844l);
            sbM833U.append(", totalPausesDuration=");
            sbM833U.append(this.f1845m);
            sbM833U.append(", totalFramesDuration=");
            return C1643a.m815C(sbM833U, this.f1846n, ")");
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

        /* JADX INFO: renamed from: a */
        public static final long m359a(b bVar, Float f) {
            if (f != null) {
                return C11210a.roundToLong(f.floatValue());
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

        /* JADX INFO: renamed from: a */
        public Long f1847a;

        /* JADX INFO: renamed from: b */
        public long f1848b;

        public d(boolean z2, long j) {
            this.f1847a = z2 ? Long.valueOf(j) : null;
        }

        /* JADX INFO: renamed from: a */
        public final boolean m360a() {
            return this.f1847a != null;
        }

        /* JADX INFO: renamed from: b */
        public final void m361b(boolean z2, long j) {
            Long l = this.f1847a;
            if (l == null) {
                if (z2) {
                    this.f1847a = Long.valueOf(j);
                }
            } else if (l != null) {
                long jLongValue = l.longValue();
                if (z2) {
                    return;
                }
                this.f1848b = (j - jLongValue) + this.f1848b;
                this.f1847a = null;
            }
        }

        /* JADX INFO: renamed from: c */
        public final long m362c(long j) {
            Long l = this.f1847a;
            if (l == null) {
                return this.f1848b;
            }
            return (this.f1848b + j) - l.longValue();
        }
    }

    /* JADX INFO: renamed from: b.a.q.o0.e$e */
    /* JADX INFO: compiled from: VideoQuality.kt */
    public static class e {

        /* JADX INFO: renamed from: b */
        public final Histogram f1850b;

        /* JADX INFO: renamed from: c */
        public final Histogram f1851c;

        /* JADX INFO: renamed from: d */
        public Long f1852d;

        /* JADX INFO: renamed from: f */
        public long f1854f;

        /* JADX INFO: renamed from: i */
        public float f1857i;

        /* JADX INFO: renamed from: a */
        public List<g> f1849a = new ArrayList();

        /* JADX INFO: renamed from: e */
        public a f1853e = new a(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16383);

        /* JADX INFO: renamed from: g */
        public Map<Integer, Float> f1855g = new LinkedHashMap();

        /* JADX INFO: renamed from: h */
        public Map<Integer, Float> f1856h = new LinkedHashMap();

        /* JADX INFO: renamed from: j */
        public Map<Integer, Float> f1858j = new LinkedHashMap();

        public e() {
            int i = 0;
            int i2 = 2;
            DefaultConstructorMarker defaultConstructorMarker = null;
            this.f1850b = new Histogram(5, i, i2, defaultConstructorMarker);
            this.f1851c = new Histogram(25600, i, i2, defaultConstructorMarker);
            Iterator<T> it = C1256e.f1816a.iterator();
            while (it.hasNext()) {
                this.f1855g.put(Integer.valueOf(((Number) it.next()).intValue()), Float.valueOf(0.0f));
            }
            Iterator<T> it2 = C1256e.f1817b.iterator();
            while (it2.hasNext()) {
                this.f1856h.put(Integer.valueOf(((Number) it2.next()).intValue()), Float.valueOf(0.0f));
            }
            Iterator<T> it3 = C1256e.f1818c.iterator();
            while (it3.hasNext()) {
                this.f1858j.put(Integer.valueOf(((Number) it3.next()).intValue()), Float.valueOf(0.0f));
            }
        }
    }

    /* JADX INFO: renamed from: b.a.q.o0.e$f */
    /* JADX INFO: compiled from: VideoQuality.kt */
    public static final class f extends e {

        /* JADX INFO: renamed from: k */
        public int f1859k = 2500000;

        /* JADX INFO: renamed from: l */
        public int f1860l = 30;

        /* JADX INFO: renamed from: m */
        public long f1861m;

        /* JADX INFO: renamed from: n */
        public long f1862n;

        /* JADX INFO: renamed from: o */
        public long f1863o;
    }

    /* JADX INFO: renamed from: b.a.q.o0.e$g */
    /* JADX INFO: compiled from: VideoQuality.kt */
    public static final class g {

        /* JADX INFO: renamed from: a */
        public final long f1864a;

        /* JADX INFO: renamed from: b */
        public final long f1865b;

        /* JADX INFO: renamed from: c */
        public final a f1866c;

        public g(long j, long j2, a aVar) {
            C12238m.checkNotNullParameter(aVar, "aggregatedProperties");
            this.f1864a = j;
            this.f1865b = j2;
            this.f1866c = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f1864a == gVar.f1864a && this.f1865b == gVar.f1865b && C12238m.areEqual(this.f1866c, gVar.f1866c);
        }

        public int hashCode() {
            int iM3a = (C0002b.m3a(this.f1865b) + (C0002b.m3a(this.f1864a) * 31)) * 31;
            a aVar = this.f1866c;
            return iM3a + (aVar != null ? aVar.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("RawVideoStats(resolution=");
            sbM833U.append(this.f1864a);
            sbM833U.append(", timestamp=");
            sbM833U.append(this.f1865b);
            sbM833U.append(", aggregatedProperties=");
            sbM833U.append(this.f1866c);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public g() {
            this(0L, 0L, new a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 16383));
        }
    }

    /* JADX INFO: renamed from: b.a.q.o0.e$h */
    /* JADX INFO: compiled from: VideoQuality.kt */
    public static final class h extends AbstractC12240o implements Function1<DeviceResourceUsageMonitor.ResourceUsage, Unit> {
        public h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DeviceResourceUsageMonitor.ResourceUsage resourceUsage) {
            DeviceResourceUsageMonitor.ResourceUsage resourceUsage2 = resourceUsage;
            C12238m.checkNotNullParameter(resourceUsage2, "it");
            C1256e c1256e = C1256e.this;
            List<Integer> list = C1256e.f1816a;
            synchronized (c1256e) {
                Iterator<Map.Entry<String, e>> it = c1256e.f1828m.entrySet().iterator();
                while (it.hasNext()) {
                    e value = it.next().getValue();
                    value.f1850b.addSample(resourceUsage2.getCpuUsagePercent());
                    value.f1851c.addSample(resourceUsage2.getMemoryRssBytes());
                }
                c1256e.f1827l.f1850b.addSample(resourceUsage2.getCpuUsagePercent());
                c1256e.f1827l.f1851c.addSample(resourceUsage2.getMemoryRssBytes());
            }
            return Unit.f27425a;
        }
    }

    public C1256e(Logger logger, Clock clock) {
        C12238m.checkNotNullParameter(logger, "logger");
        C12238m.checkNotNullParameter(clock, "clock");
        this.f1831p = logger;
        this.f1832q = clock;
        ListenerCollectionSubject<?> listenerCollectionSubject = new ListenerCollectionSubject<>();
        this.f1820e = listenerCollectionSubject;
        this.f1821f = listenerCollectionSubject;
        long jCurrentTimeMillis = clock.currentTimeMillis();
        this.f1822g = jCurrentTimeMillis;
        this.f1824i = new d(false, jCurrentTimeMillis);
        this.f1825j = new d(false, jCurrentTimeMillis);
        this.f1826k = new d(false, jCurrentTimeMillis);
        this.f1827l = new f();
        this.f1828m = new LinkedHashMap();
        this.f1829n = new LinkedHashMap();
        DeviceResourceUsageMonitor deviceResourceUsageMonitor = new DeviceResourceUsageMonitor(new TimeSpan(1L, TimeUnit.SECONDS), clock, new h());
        this.f1830o = deviceResourceUsageMonitor;
        deviceResourceUsageMonitor.start();
    }

    /* JADX INFO: renamed from: a */
    public final void m352a(e eVar, g gVar) {
        eVar.f1849a.add(gVar);
        if (eVar.f1849a.size() < 2) {
            return;
        }
        List<g> list = eVar.f1849a;
        g gVar2 = list.get(list.size() - 1);
        List<g> list2 = eVar.f1849a;
        g gVar3 = list2.get(list2.size() - 2);
        C1257f c1257f = C1257f.f1867j;
        eVar.f1854f = (gVar2.f1865b - gVar3.f1865b) + eVar.f1854f;
        a aVar = eVar.f1853e;
        a aVar2 = gVar2.f1866c;
        a aVar3 = gVar3.f1866c;
        aVar.f1833a = c1257f.m363a(aVar2.f1833a, aVar3.f1833a) + aVar.f1833a;
        aVar.f1834b = c1257f.m363a(aVar2.f1834b, aVar3.f1834b) + aVar.f1834b;
        aVar.f1835c = c1257f.m363a(aVar2.f1835c, aVar3.f1835c) + aVar.f1835c;
        aVar.f1836d = c1257f.m363a(aVar2.f1836d, aVar3.f1836d) + aVar.f1836d;
        aVar.f1837e = c1257f.m363a(aVar2.f1837e, aVar3.f1837e) + aVar.f1837e;
        aVar.f1838f = c1257f.m363a(aVar2.f1838f, aVar3.f1838f) + aVar.f1838f;
        aVar.f1839g = c1257f.m363a(aVar2.f1839g, aVar3.f1839g) + aVar.f1839g;
        aVar.f1840h = c1257f.m363a(aVar2.f1840h, aVar3.f1840h) + aVar.f1840h;
        aVar.f1841i = c1257f.m363a(aVar2.f1841i, aVar3.f1841i) + aVar.f1841i;
        aVar.f1842j = c1257f.m363a(aVar2.f1842j, aVar3.f1842j) + aVar.f1842j;
        aVar.f1843k = c1257f.m363a(aVar2.f1842j, aVar3.f1842j) + aVar.f1843k;
        aVar.f1844l = c1257f.m363a(aVar2.f1844l, aVar3.f1844l) + aVar.f1844l;
        aVar.f1845m = c1257f.m363a(aVar2.f1845m, aVar3.f1845m) + aVar.f1845m;
        aVar.f1846n = c1257f.m363a(aVar2.f1846n, aVar3.f1846n) + aVar.f1846n;
        a aVar4 = gVar2.f1866c;
        long j = aVar4.f1838f;
        long j2 = aVar4.f1833a;
        long j3 = gVar2.f1865b;
        long j4 = gVar2.f1864a;
        float f2 = (j3 - gVar3.f1865b) / 1000.0f;
        eVar.f1857i = (j4 * f2) + eVar.f1857i;
        if (eVar.f1849a.size() < 6) {
            return;
        }
        List<g> list3 = eVar.f1849a;
        g gVar4 = list3.get(list3.size() - 3);
        a aVar5 = gVar4.f1866c;
        long j5 = aVar5.f1838f;
        long j6 = aVar5.f1833a;
        long j7 = gVar4.f1865b;
        Iterator<T> it = f1818c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            long j8 = j2;
            int iIntValue = ((Number) it.next()).intValue();
            long j9 = j6;
            if (j4 <= iIntValue) {
                Map<Integer, Float> map = eVar.f1858j;
                Integer numValueOf = Integer.valueOf(iIntValue);
                Float f3 = eVar.f1858j.get(Integer.valueOf(iIntValue));
                map.put(numValueOf, Float.valueOf((f3 != null ? f3.floatValue() : 0.0f) + f2));
            }
            j2 = j8;
            j6 = j9;
        }
        float f4 = (j3 - j7) / 1000.0f;
        float f5 = ((j - j5) * ((long) 8)) / f4;
        float f6 = (j2 - j6) / f4;
        Iterator<T> it2 = f1816a.iterator();
        while (it2.hasNext()) {
            int iIntValue2 = ((Number) it2.next()).intValue();
            if (f5 <= iIntValue2) {
                Map<Integer, Float> map2 = eVar.f1855g;
                Integer numValueOf2 = Integer.valueOf(iIntValue2);
                Float f7 = eVar.f1855g.get(Integer.valueOf(iIntValue2));
                map2.put(numValueOf2, Float.valueOf((f7 != null ? f7.floatValue() : 0.0f) + f2));
            }
        }
        Iterator<T> it3 = f1817b.iterator();
        while (it3.hasNext()) {
            int iIntValue3 = ((Number) it3.next()).intValue();
            if (f6 <= iIntValue3) {
                Map<Integer, Float> map3 = eVar.f1856h;
                Integer numValueOf3 = Integer.valueOf(iIntValue3);
                Float f8 = eVar.f1856h.get(Integer.valueOf(iIntValue3));
                map3.put(numValueOf3, Float.valueOf((f8 != null ? f8.floatValue() : 0.0f) + f2));
            }
        }
        C12160r.removeFirst(eVar.f1849a);
    }

    /* JADX INFO: renamed from: b */
    public final void m353b(int i) {
        if (this.f1827l.f1849a.size() < 2) {
            return;
        }
        List<g> list = this.f1827l.f1849a;
        long j = list.get(list.size() - 1).f1865b;
        List<g> list2 = this.f1827l.f1849a;
        float f2 = (j - list2.get(list2.size() - 2).f1865b) / 1000.0f;
        f fVar = this.f1827l;
        long j2 = fVar.f1861m;
        Float fValueOf = Float.valueOf(fVar.f1860l * f2);
        fVar.f1861m = j2 + (fValueOf != null ? C11210a.roundToLong(fValueOf.floatValue()) : 0L);
        f fVar2 = this.f1827l;
        long j3 = fVar2.f1862n;
        Float fValueOf2 = Float.valueOf((i / 8.0f) * f2);
        fVar2.f1862n = j3 + (fValueOf2 != null ? C11210a.roundToLong(fValueOf2.floatValue()) : 0L);
        f fVar3 = this.f1827l;
        long j4 = fVar3.f1863o;
        Float fValueOf3 = Float.valueOf((fVar3.f1859k / 8.0f) * f2);
        fVar3.f1863o = j4 + (fValueOf3 != null ? C11210a.roundToLong(fValueOf3.floatValue()) : 0L);
    }

    @AnyThread
    /* JADX INFO: renamed from: c */
    public final synchronized Map<String, Object> m354c(String str) {
        e eVar;
        C12238m.checkNotNullParameter(str, "userId");
        eVar = this.f1828m.get(str);
        return eVar != null ? m356e(eVar) : null;
    }

    @AnyThread
    /* JADX INFO: renamed from: d */
    public final synchronized Map<String, Object> m355d() {
        f fVar;
        float f2;
        float f3;
        Float fValueOf;
        Float fValueOf2;
        Float fValueOf3;
        fVar = this.f1827l;
        f2 = fVar.f1854f / 1000.0f;
        f3 = 0;
        return C12136h0.plus(m356e(this.f1827l), C12136h0.mapOf(C12116o.m10073to("target_bitrate_max", Long.valueOf((f2 <= f3 || (fValueOf3 = Float.valueOf(((float) (fVar.f1863o * ((long) 8))) / f2)) == null) ? 0L : C11210a.roundToLong(fValueOf3.floatValue()))), C12116o.m10073to("target_bitrate_network", Long.valueOf((f2 <= f3 || (fValueOf2 = Float.valueOf(((float) (this.f1827l.f1862n * ((long) 8))) / f2)) == null) ? 0L : C11210a.roundToLong(fValueOf2.floatValue()))), C12116o.m10073to("target_fps", Long.valueOf((f2 <= f3 || (fValueOf = Float.valueOf(((float) this.f1827l.f1861m) / f2)) == null) ? 0L : C11210a.roundToLong(fValueOf.floatValue()))), C12116o.m10073to("duration_encoder_nvidia_cuda", 0L), C12116o.m10073to("duration_encoder_nvidia_direct3d", 0L), C12116o.m10073to("duration_encoder_openh264", 0L), C12116o.m10073to("duration_encoder_videotoolbox", 0L), C12116o.m10073to("duration_encoder_amd_direct3d", 0L), C12116o.m10073to("duration_encoder_intel", 0L), C12116o.m10073to("duration_encoder_intel_direct3d", 0L), C12116o.m10073to("duration_encoder_unknown", 0L)));
    }

    /* JADX INFO: renamed from: e */
    public final Map<String, Object> m356e(e eVar) {
        Float fValueOf;
        long jCurrentTimeMillis = this.f1832q.currentTimeMillis();
        Long l = this.f1823h;
        float fLongValue = (l != null ? l.longValue() - this.f1822g : jCurrentTimeMillis - this.f1822g) / 1000.0f;
        float f2 = eVar.f1854f / 1000.0f;
        float f3 = 0;
        long jRoundToLong = (f2 <= f3 || (fValueOf = Float.valueOf(eVar.f1857i / f2)) == null) ? 0L : C11210a.roundToLong(fValueOf.floatValue());
        Histogram.Report report = eVar.f1850b.getReport();
        Histogram.Report report2 = eVar.f1851c.getReport();
        b bVar = f1819d;
        long j = 1024;
        Map mapMapOf = C12136h0.mapOf(C12116o.m10073to("duration", Double.valueOf(Math.floor(fLongValue))), C1643a.m842b0(bVar, eVar.f1855g.get(8000000), "duration_stream_under_8mbps"), C1643a.m842b0(bVar, eVar.f1855g.get(7000000), "duration_stream_under_7mbps"), C1643a.m842b0(bVar, eVar.f1855g.get(6000000), "duration_stream_under_6mbps"), C1643a.m842b0(bVar, eVar.f1855g.get(5000000), "duration_stream_under_5mbps"), C1643a.m842b0(bVar, eVar.f1855g.get(4000000), "duration_stream_under_4mbps"), C1643a.m842b0(bVar, eVar.f1855g.get(3000000), "duration_stream_under_3mbps"), C1643a.m842b0(bVar, eVar.f1855g.get(2000000), "duration_stream_under_2mbps"), C1643a.m842b0(bVar, eVar.f1855g.get(1500000), "duration_stream_under_1_5mbps"), C1643a.m842b0(bVar, eVar.f1855g.get(1000000), "duration_stream_under_1mbps"), C1643a.m842b0(bVar, eVar.f1855g.get(500000), "duration_stream_under_0_5mbps"), C1643a.m842b0(bVar, eVar.f1855g.get(0), "duration_stream_at_0mbps"), C1643a.m842b0(bVar, eVar.f1856h.get(60), "duration_fps_under_60"), C1643a.m842b0(bVar, eVar.f1856h.get(55), "duration_fps_under_55"), C1643a.m842b0(bVar, eVar.f1856h.get(50), "duration_fps_under_50"), C1643a.m842b0(bVar, eVar.f1856h.get(45), "duration_fps_under_45"), C1643a.m842b0(bVar, eVar.f1856h.get(40), "duration_fps_under_40"), C1643a.m842b0(bVar, eVar.f1856h.get(35), "duration_fps_under_35"), C1643a.m842b0(bVar, eVar.f1856h.get(30), "duration_fps_under_30"), C1643a.m842b0(bVar, eVar.f1856h.get(25), "duration_fps_under_25"), C1643a.m842b0(bVar, eVar.f1856h.get(20), "duration_fps_under_20"), C1643a.m842b0(bVar, eVar.f1856h.get(15), "duration_fps_under_15"), C1643a.m842b0(bVar, eVar.f1856h.get(10), "duration_fps_under_10"), C1643a.m842b0(bVar, eVar.f1856h.get(5), "duration_fps_under_5"), C1643a.m842b0(bVar, eVar.f1856h.get(0), "duration_fps_at_0"), C12116o.m10073to("avg_resolution", Long.valueOf(jRoundToLong)), C1643a.m842b0(bVar, eVar.f1858j.get(720), "duration_resolution_under_720"), C1643a.m842b0(bVar, eVar.f1858j.get(480), "duration_resolution_under_480"), C1643a.m842b0(bVar, eVar.f1858j.get(360), "duration_resolution_under_360"), C12116o.m10073to("num_pauses", 0), C12116o.m10073to("duration_paused", Long.valueOf(b.m359a(bVar, Float.valueOf(this.f1824i.m362c(jCurrentTimeMillis) / 1000.0f)))), C12116o.m10073to("duration_zero_receivers", Long.valueOf(b.m359a(bVar, Float.valueOf(this.f1825j.m362c(jCurrentTimeMillis) / 1000.0f)))), C12116o.m10073to("duration_video_stopped", Long.valueOf(b.m359a(bVar, Float.valueOf(this.f1826k.m362c(jCurrentTimeMillis) / 1000.0f)))), C12116o.m10073to("client_performance_cpu_percentile25", Long.valueOf(report.getPercentile25())), C12116o.m10073to("client_performance_cpu_percentile50", Long.valueOf(report.getPercentile50())), C12116o.m10073to("client_performance_cpu_percentile75", Long.valueOf(report.getPercentile75())), C12116o.m10073to("client_performance_cpu_percentile90", Long.valueOf(report.getPercentile90())), C12116o.m10073to("client_performance_cpu_percentile95", Long.valueOf(report.getPercentile95())), C12116o.m10073to("client_performance_memory_percentile25", Long.valueOf(report2.getPercentile25() / j)), C12116o.m10073to("client_performance_memory_percentile50", Long.valueOf(report2.getPercentile50() / j)), C12116o.m10073to("client_performance_memory_percentile75", Long.valueOf(report2.getPercentile75() / j)), C12116o.m10073to("client_performance_memory_percentile90", Long.valueOf(report2.getPercentile90() / j)), C12116o.m10073to("client_performance_memory_percentile95", Long.valueOf(report2.getPercentile95() / j)), C12116o.m10073to("client_performance_memory_min", Long.valueOf(report2.getMin() / j)), C12116o.m10073to("client_performance_memory_max", Long.valueOf(report2.getMax() / j)));
        a aVar = eVar.f1853e;
        long jM359a = f2 > f3 ? b.m359a(bVar, Float.valueOf((aVar.f1838f * ((long) 8)) / f2)) : 0L;
        long jM359a2 = f2 > f3 ? b.m359a(bVar, Float.valueOf(aVar.f1833a / f2)) : 0L;
        Pair[] pairArr = new Pair[16];
        pairArr[0] = C12116o.m10073to("avg_bitrate", Long.valueOf(jM359a));
        pairArr[1] = C12116o.m10073to("avg_fps", Long.valueOf(jM359a2));
        pairArr[2] = C12116o.m10073to("num_bytes", Long.valueOf(aVar.f1838f));
        pairArr[3] = C12116o.m10073to("num_packets_lost", Long.valueOf(aVar.f1836d));
        pairArr[4] = C12116o.m10073to("num_packets", Long.valueOf(aVar.f1835c));
        pairArr[5] = C12116o.m10073to("num_frames", Long.valueOf(aVar.f1834b));
        Long l2 = eVar.f1852d;
        pairArr[6] = C12116o.m10073to("time_to_first_frame_ms", Long.valueOf(l2 != null ? l2.longValue() : 0L));
        pairArr[7] = C12116o.m10073to("num_frames_dropped", Long.valueOf(aVar.f1837e));
        pairArr[8] = C12116o.m10073to("num_nacks", Long.valueOf(aVar.f1839g));
        pairArr[9] = C12116o.m10073to("num_plis", Long.valueOf(aVar.f1840h));
        pairArr[10] = C12116o.m10073to("qp_sum", Long.valueOf(aVar.f1841i));
        pairArr[11] = C12116o.m10073to("receiver_freeze_count", Long.valueOf(aVar.f1842j));
        pairArr[12] = C12116o.m10073to("receiver_pause_count", Long.valueOf(aVar.f1843k));
        pairArr[13] = C12116o.m10073to("receiver_total_freezes_duration", Long.valueOf(aVar.f1844l));
        pairArr[14] = C12116o.m10073to("receiver_total_pauses_duration", Long.valueOf(aVar.f1845m));
        pairArr[15] = C12116o.m10073to("receiver_total_frames_duration", Long.valueOf(aVar.f1846n));
        return C12136h0.plus(mapMapOf, C12136h0.mapOf(pairArr));
    }

    /* JADX INFO: renamed from: f */
    public final g m357f(InboundRtpVideo inboundRtpVideo, long j) {
        return new g(inboundRtpVideo.getResolution().getHeight(), j, new a(inboundRtpVideo.getFramesDecoded(), inboundRtpVideo.getFramesReceived(), inboundRtpVideo.getPacketsReceived(), inboundRtpVideo.getPacketsLost(), inboundRtpVideo.getFramesDropped(), inboundRtpVideo.getBytesReceived(), inboundRtpVideo.getNackCount(), inboundRtpVideo.getPliCount(), inboundRtpVideo.getQpSum(), inboundRtpVideo.getFreezeCount(), inboundRtpVideo.getPauseCount(), inboundRtpVideo.getTotalFreezesDuration(), inboundRtpVideo.getTotalPausesDuration(), inboundRtpVideo.getTotalFramesDuration()));
    }

    /* JADX INFO: renamed from: g */
    public final void m358g(Boolean bool, Integer num, long j) {
        if (num != null) {
            this.f1825j.m361b(num.intValue() == 0, j);
        }
        boolean z2 = this.f1824i.m360a() || this.f1825j.m360a();
        if (z2 != this.f1826k.m360a()) {
            this.f1826k.m361b(z2, j);
            this.f1827l.f1849a.clear();
        }
    }
}
