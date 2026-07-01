package b.i.a.c;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Timeline;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.p0.AdPlaybackState;
import b.i.a.c.s2.AnalyticsCollector;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableList2;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.s1, reason: use source file name */
/* JADX INFO: compiled from: MediaPeriodQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaPeriodQueue {
    public final Timeline.b a = new Timeline.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Timeline.c f1062b = new Timeline.c();

    @Nullable
    public final AnalyticsCollector c;
    public final Handler d;
    public long e;
    public int f;
    public boolean g;

    @Nullable
    public MediaPeriodHolder h;

    @Nullable
    public MediaPeriodHolder i;

    @Nullable
    public MediaPeriodHolder j;
    public int k;

    @Nullable
    public Object l;
    public long m;

    public MediaPeriodQueue(@Nullable AnalyticsCollector analyticsCollector, Handler handler) {
        this.c = analyticsCollector;
        this.d = handler;
    }

    public static MediaSource2.a p(Timeline timeline, Object obj, long j, long j2, Timeline.b bVar) {
        timeline.h(obj, bVar);
        AdPlaybackState adPlaybackState = bVar.p;
        long j3 = bVar.m;
        int i = adPlaybackState.n - 1;
        while (i >= 0) {
            boolean z2 = false;
            if (j != Long.MIN_VALUE) {
                long j4 = adPlaybackState.a(i).k;
                if (j4 != Long.MIN_VALUE ? j < j4 : !(j3 != -9223372036854775807L && j >= j3)) {
                    z2 = true;
                }
            }
            if (!z2) {
                break;
            }
            i--;
        }
        if (i < 0 || !adPlaybackState.a(i).b()) {
            i = -1;
        }
        if (i == -1) {
            return new MediaSource2.a(obj, j2, bVar.b(j));
        }
        return new MediaSource2.a(obj, i, bVar.d(i), j2);
    }

    @Nullable
    public MediaPeriodHolder a() {
        MediaPeriodHolder mediaPeriodHolder = this.h;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.i) {
            this.i = mediaPeriodHolder.l;
        }
        mediaPeriodHolder.h();
        int i = this.k - 1;
        this.k = i;
        if (i == 0) {
            this.j = null;
            MediaPeriodHolder mediaPeriodHolder2 = this.h;
            this.l = mediaPeriodHolder2.f1056b;
            this.m = mediaPeriodHolder2.f.a.d;
        }
        this.h = this.h.l;
        l();
        return this.h;
    }

    public void b() {
        if (this.k == 0) {
            return;
        }
        MediaPeriodHolder mediaPeriodHolder = this.h;
        AnimatableValueParser.H(mediaPeriodHolder);
        MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodHolder;
        this.l = mediaPeriodHolder2.f1056b;
        this.m = mediaPeriodHolder2.f.a.d;
        while (mediaPeriodHolder2 != null) {
            mediaPeriodHolder2.h();
            mediaPeriodHolder2 = mediaPeriodHolder2.l;
        }
        this.h = null;
        this.j = null;
        this.i = null;
        this.k = 0;
        l();
    }

    @Nullable
    public final MediaPeriodInfo c(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j) {
        long j2;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f;
        long j3 = (mediaPeriodHolder.o + mediaPeriodInfo.e) - j;
        long j4 = 0;
        if (mediaPeriodInfo.g) {
            int iD = timeline.d(timeline.b(mediaPeriodInfo.a.a), this.a, this.f1062b, this.f, this.g);
            if (iD == -1) {
                return null;
            }
            int i = timeline.g(iD, this.a, true).l;
            Object obj = this.a.k;
            long j5 = mediaPeriodInfo.a.d;
            if (timeline.n(i, this.f1062b).B == iD) {
                Pair<Object, Long> pairK = timeline.k(this.f1062b, this.a, i, -9223372036854775807L, Math.max(0L, j3));
                if (pairK == null) {
                    return null;
                }
                obj = pairK.first;
                long jLongValue = ((Long) pairK.second).longValue();
                MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodHolder.l;
                if (mediaPeriodHolder2 == null || !mediaPeriodHolder2.f1056b.equals(obj)) {
                    j5 = this.e;
                    this.e = 1 + j5;
                } else {
                    j5 = mediaPeriodHolder2.f.a.d;
                }
                j2 = jLongValue;
                j4 = -9223372036854775807L;
            } else {
                j2 = 0;
            }
            return d(timeline, p(timeline, obj, j2, j5, this.a), j4, j2);
        }
        MediaSource2.a aVar = mediaPeriodInfo.a;
        timeline.h(aVar.a, this.a);
        if (!aVar.a()) {
            int iD2 = this.a.d(aVar.e);
            if (iD2 != this.a.p.a(aVar.e).l) {
                return e(timeline, aVar.a, aVar.e, iD2, mediaPeriodInfo.e, aVar.d);
            }
            return f(timeline, aVar.a, g(timeline, aVar.a, aVar.e), mediaPeriodInfo.e, aVar.d);
        }
        int i2 = aVar.f835b;
        int i3 = this.a.p.a(i2).l;
        if (i3 == -1) {
            return null;
        }
        int iA = this.a.p.a(i2).a(aVar.c);
        if (iA < i3) {
            return e(timeline, aVar.a, i2, iA, mediaPeriodInfo.c, aVar.d);
        }
        long jLongValue2 = mediaPeriodInfo.c;
        if (jLongValue2 == -9223372036854775807L) {
            Timeline.c cVar = this.f1062b;
            Timeline.b bVar = this.a;
            Pair<Object, Long> pairK2 = timeline.k(cVar, bVar, bVar.l, -9223372036854775807L, Math.max(0L, j3));
            if (pairK2 == null) {
                return null;
            }
            jLongValue2 = ((Long) pairK2.second).longValue();
        }
        return f(timeline, aVar.a, Math.max(g(timeline, aVar.a, aVar.f835b), jLongValue2), mediaPeriodInfo.c, aVar.d);
    }

    @Nullable
    public final MediaPeriodInfo d(Timeline timeline, MediaSource2.a aVar, long j, long j2) {
        timeline.h(aVar.a, this.a);
        return aVar.a() ? e(timeline, aVar.a, aVar.f835b, aVar.c, j, aVar.d) : f(timeline, aVar.a, j2, j, aVar.d);
    }

    public final MediaPeriodInfo e(Timeline timeline, Object obj, int i, int i2, long j, long j2) {
        MediaSource2.a aVar = new MediaSource2.a(obj, i, i2, j2);
        long jA = timeline.h(obj, this.a).a(i, i2);
        long j3 = i2 == this.a.p.a(i).a(-1) ? this.a.p.o : 0L;
        return new MediaPeriodInfo(aVar, (jA == -9223372036854775807L || j3 < jA) ? j3 : Math.max(0L, jA - 1), j, -9223372036854775807L, jA, this.a.p.a(i).q, false, false, false);
    }

    public final MediaPeriodInfo f(Timeline timeline, Object obj, long j, long j2, long j3) {
        long jMax = j;
        timeline.h(obj, this.a);
        int iB = this.a.b(jMax);
        MediaSource2.a aVar = new MediaSource2.a(obj, j3, iB);
        boolean zI = i(aVar);
        boolean zK = k(timeline, aVar);
        boolean zJ = j(timeline, aVar, zI);
        boolean z2 = iB != -1 && this.a.e(iB);
        long jC = iB != -1 ? this.a.c(iB) : -9223372036854775807L;
        long j4 = (jC == -9223372036854775807L || jC == Long.MIN_VALUE) ? this.a.m : jC;
        if (j4 != -9223372036854775807L && jMax >= j4) {
            jMax = Math.max(0L, j4 - 1);
        }
        return new MediaPeriodInfo(aVar, jMax, j2, jC, j4, z2, zI, zK, zJ);
    }

    public final long g(Timeline timeline, Object obj, int i) {
        timeline.h(obj, this.a);
        long j = this.a.p.a(i).k;
        return j == Long.MIN_VALUE ? this.a.m : j + this.a.p.a(i).p;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0060  */
    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    /* JADX WARN: Code duplicated, block: B:28:0x0079  */
    public MediaPeriodInfo h(Timeline timeline, MediaPeriodInfo mediaPeriodInfo) {
        long jA;
        long j;
        int i;
        boolean zE;
        int i2;
        MediaSource2.a aVar = mediaPeriodInfo.a;
        boolean zI = i(aVar);
        boolean zK = k(timeline, aVar);
        boolean zJ = j(timeline, aVar, zI);
        timeline.h(mediaPeriodInfo.a.a, this.a);
        long jC = (aVar.a() || (i2 = aVar.e) == -1) ? -9223372036854775807L : this.a.c(i2);
        if (!aVar.a()) {
            if (jC == -9223372036854775807L || jC == Long.MIN_VALUE) {
                jA = this.a.m;
            } else {
                j = jC;
            }
            if (aVar.a()) {
                zE = this.a.e(aVar.f835b);
            } else {
                i = aVar.e;
                if (i == -1 && this.a.e(i)) {
                    zE = true;
                } else {
                    zE = false;
                }
            }
            return new MediaPeriodInfo(aVar, mediaPeriodInfo.f1058b, mediaPeriodInfo.c, jC, j, zE, zI, zK, zJ);
        }
        jA = this.a.a(aVar.f835b, aVar.c);
        j = jA;
        if (aVar.a()) {
            zE = this.a.e(aVar.f835b);
        } else {
            i = aVar.e;
            if (i == -1) {
                zE = false;
            } else {
                zE = false;
            }
        }
        return new MediaPeriodInfo(aVar, mediaPeriodInfo.f1058b, mediaPeriodInfo.c, jC, j, zE, zI, zK, zJ);
    }

    public final boolean i(MediaSource2.a aVar) {
        return !aVar.a() && aVar.e == -1;
    }

    public final boolean j(Timeline timeline, MediaSource2.a aVar, boolean z2) {
        int iB = timeline.b(aVar.a);
        if (timeline.n(timeline.f(iB, this.a).l, this.f1062b).v) {
            return false;
        }
        return (timeline.d(iB, this.a, this.f1062b, this.f, this.g) == -1) && z2;
    }

    public final boolean k(Timeline timeline, MediaSource2.a aVar) {
        if (i(aVar)) {
            return timeline.n(timeline.h(aVar.a, this.a).l, this.f1062b).C == timeline.b(aVar.a);
        }
        return false;
    }

    public final void l() {
        if (this.c != null) {
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
            final ImmutableList2.a aVar = new ImmutableList2.a();
            for (MediaPeriodHolder mediaPeriodHolder = this.h; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.l) {
                aVar.b(mediaPeriodHolder.f.a);
            }
            MediaPeriodHolder mediaPeriodHolder2 = this.i;
            final MediaSource2.a aVar2 = mediaPeriodHolder2 == null ? null : mediaPeriodHolder2.f.a;
            this.d.post(new Runnable() { // from class: b.i.a.c.m0
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public final void run() {
                    MediaPeriodQueue mediaPeriodQueue = this.j;
                    ImmutableList2.a aVar3 = aVar;
                    MediaSource2.a aVar4 = aVar2;
                    AnalyticsCollector analyticsCollector = mediaPeriodQueue.c;
                    ImmutableList2 immutableList2C = aVar3.c();
                    AnalyticsCollector.a aVar5 = analyticsCollector.m;
                    Player2 player2 = analyticsCollector.p;
                    Objects.requireNonNull(player2);
                    Objects.requireNonNull(aVar5);
                    aVar5.f1081b = ImmutableList2.n(immutableList2C);
                    if (!immutableList2C.isEmpty()) {
                        aVar5.e = (MediaSource2.a) immutableList2C.get(0);
                        Objects.requireNonNull(aVar4);
                        aVar5.f = aVar4;
                    }
                    if (aVar5.d == null) {
                        aVar5.d = AnalyticsCollector.a.b(player2, aVar5.f1081b, aVar5.e, aVar5.a);
                    }
                    aVar5.d(player2.K());
                }
            });
        }
    }

    public void m(long j) {
        MediaPeriodHolder mediaPeriodHolder = this.j;
        if (mediaPeriodHolder != null) {
            AnimatableValueParser.D(mediaPeriodHolder.g());
            if (mediaPeriodHolder.d) {
                mediaPeriodHolder.a.s(j - mediaPeriodHolder.o);
            }
        }
    }

    public boolean n(MediaPeriodHolder mediaPeriodHolder) {
        boolean z2 = false;
        AnimatableValueParser.D(mediaPeriodHolder != null);
        if (mediaPeriodHolder.equals(this.j)) {
            return false;
        }
        this.j = mediaPeriodHolder;
        while (true) {
            mediaPeriodHolder = mediaPeriodHolder.l;
            if (mediaPeriodHolder == null) {
                break;
            }
            if (mediaPeriodHolder == this.i) {
                this.i = this.h;
                z2 = true;
            }
            mediaPeriodHolder.h();
            this.k--;
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.j;
        if (mediaPeriodHolder2.l != null) {
            mediaPeriodHolder2.b();
            mediaPeriodHolder2.l = null;
            mediaPeriodHolder2.c();
        }
        l();
        return z2;
    }

    public MediaSource2.a o(Timeline timeline, Object obj, long j) {
        long j2;
        int iB;
        int i = timeline.h(obj, this.a).l;
        Object obj2 = this.l;
        if (obj2 == null || (iB = timeline.b(obj2)) == -1 || timeline.f(iB, this.a).l != i) {
            for (MediaPeriodHolder mediaPeriodHolder = this.h; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.l) {
                if (mediaPeriodHolder.f1056b.equals(obj)) {
                    j2 = mediaPeriodHolder.f.a.d;
                }
            }
            for (MediaPeriodHolder mediaPeriodHolder2 = this.h; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.l) {
                int iB2 = timeline.b(mediaPeriodHolder2.f1056b);
                if (iB2 != -1 && timeline.f(iB2, this.a).l == i) {
                    j2 = mediaPeriodHolder2.f.a.d;
                }
            }
            j2 = this.e;
            this.e = 1 + j2;
            if (this.h == null) {
                this.l = obj;
                this.m = j2;
            }
        } else {
            j2 = this.m;
        }
        return p(timeline, obj, j, j2, this.a);
    }

    public final boolean q(Timeline timeline) {
        MediaPeriodHolder mediaPeriodHolder;
        MediaPeriodHolder mediaPeriodHolder2 = this.h;
        if (mediaPeriodHolder2 == null) {
            return true;
        }
        int iB = timeline.b(mediaPeriodHolder2.f1056b);
        while (true) {
            iB = timeline.d(iB, this.a, this.f1062b, this.f, this.g);
            while (true) {
                mediaPeriodHolder = mediaPeriodHolder2.l;
                if (mediaPeriodHolder == null || mediaPeriodHolder2.f.g) {
                    break;
                }
                mediaPeriodHolder2 = mediaPeriodHolder;
            }
            if (iB == -1 || mediaPeriodHolder == null || timeline.b(mediaPeriodHolder.f1056b) != iB) {
                break;
            }
            mediaPeriodHolder2 = mediaPeriodHolder;
        }
        boolean zN = n(mediaPeriodHolder2);
        mediaPeriodHolder2.f = h(timeline, mediaPeriodHolder2.f);
        return !zN;
    }

    public boolean r(Timeline timeline, long j, long j2) {
        boolean zN;
        MediaPeriodInfo mediaPeriodInfoH;
        MediaPeriodHolder mediaPeriodHolder = this.h;
        MediaPeriodHolder mediaPeriodHolder2 = null;
        while (mediaPeriodHolder != null) {
            MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f;
            if (mediaPeriodHolder2 != null) {
                MediaPeriodInfo mediaPeriodInfoC = c(timeline, mediaPeriodHolder2, j);
                if (mediaPeriodInfoC == null) {
                    zN = n(mediaPeriodHolder2);
                } else {
                    if (mediaPeriodInfo.f1058b == mediaPeriodInfoC.f1058b && mediaPeriodInfo.a.equals(mediaPeriodInfoC.a)) {
                        mediaPeriodInfoH = mediaPeriodInfoC;
                    } else {
                        zN = n(mediaPeriodHolder2);
                    }
                }
                return !zN;
            }
            mediaPeriodInfoH = h(timeline, mediaPeriodInfo);
            mediaPeriodHolder.f = mediaPeriodInfoH.a(mediaPeriodInfo.c);
            long j3 = mediaPeriodInfo.e;
            if (!(j3 == -9223372036854775807L || j3 == mediaPeriodInfoH.e)) {
                mediaPeriodHolder.j();
                long j4 = mediaPeriodInfoH.e;
                return (n(mediaPeriodHolder) || (mediaPeriodHolder == this.i && !mediaPeriodHolder.f.f && ((j2 > Long.MIN_VALUE ? 1 : (j2 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j2 > ((j4 > (-9223372036854775807L) ? 1 : (j4 == (-9223372036854775807L) ? 0 : -1)) == 0 ? RecyclerView.FOREVER_NS : j4 + mediaPeriodHolder.o) ? 1 : (j2 == ((j4 > (-9223372036854775807L) ? 1 : (j4 == (-9223372036854775807L) ? 0 : -1)) == 0 ? RecyclerView.FOREVER_NS : j4 + mediaPeriodHolder.o) ? 0 : -1)) >= 0))) ? false : true;
            }
            mediaPeriodHolder2 = mediaPeriodHolder;
            mediaPeriodHolder = mediaPeriodHolder.l;
        }
        return true;
    }
}
