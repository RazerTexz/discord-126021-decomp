package b.i.a.c;

import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Bundleable;
import b.i.a.c.MediaItem2;
import b.i.a.c.Timeline;
import b.i.a.c.a3.p0.AdPlaybackState;
import b.i.a.c.f3.Util2;
import b.i.b.b.ImmutableList2;
import b.i.b.b.RegularImmutableList;
import com.google.errorprone.annotations.InlineMe;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.o2, reason: use source file name */
/* JADX INFO: compiled from: Timeline.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Timeline implements Bundleable {
    public static final Timeline j = new a();

    /* JADX INFO: renamed from: b.i.a.c.o2$a */
    /* JADX INFO: compiled from: Timeline.java */
    public class a extends Timeline {
        @Override // b.i.a.c.Timeline
        public int b(Object obj) {
            return -1;
        }

        @Override // b.i.a.c.Timeline
        public b g(int i, b bVar, boolean z2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // b.i.a.c.Timeline
        public int i() {
            return 0;
        }

        @Override // b.i.a.c.Timeline
        public Object m(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // b.i.a.c.Timeline
        public c o(int i, c cVar, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // b.i.a.c.Timeline
        public int p() {
            return 0;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.o2$b */
    /* JADX INFO: compiled from: Timeline.java */
    public static final class b implements Bundleable {

        @Nullable
        public Object j;

        @Nullable
        public Object k;
        public int l;
        public long m;
        public long n;
        public boolean o;
        public AdPlaybackState p = AdPlaybackState.j;

        public long a(int i, int i2) {
            AdPlaybackState.a aVarA = this.p.a(i);
            if (aVarA.l != -1) {
                return aVarA.o[i2];
            }
            return -9223372036854775807L;
        }

        public int b(long j) {
            AdPlaybackState adPlaybackState = this.p;
            long j2 = this.m;
            Objects.requireNonNull(adPlaybackState);
            if (j == Long.MIN_VALUE) {
                return -1;
            }
            if (j2 != -9223372036854775807L && j >= j2) {
                return -1;
            }
            int i = adPlaybackState.q;
            while (i < adPlaybackState.n) {
                if (adPlaybackState.a(i).k == Long.MIN_VALUE || adPlaybackState.a(i).k > j) {
                    AdPlaybackState.a aVarA = adPlaybackState.a(i);
                    if (aVarA.l == -1 || aVarA.a(-1) < aVarA.l) {
                        break;
                    }
                }
                i++;
            }
            if (i < adPlaybackState.n) {
                return i;
            }
            return -1;
        }

        public long c(int i) {
            return this.p.a(i).k;
        }

        public int d(int i) {
            return this.p.a(i).a(-1);
        }

        public boolean e(int i) {
            return this.p.a(i).q;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return Util2.a(this.j, bVar.j) && Util2.a(this.k, bVar.k) && this.l == bVar.l && this.m == bVar.m && this.n == bVar.n && this.o == bVar.o && Util2.a(this.p, bVar.p);
        }

        public b f(@Nullable Object obj, @Nullable Object obj2, int i, long j, long j2, AdPlaybackState adPlaybackState, boolean z2) {
            this.j = obj;
            this.k = obj2;
            this.l = i;
            this.m = j;
            this.n = j2;
            this.p = adPlaybackState;
            this.o = z2;
            return this;
        }

        public int hashCode() {
            Object obj = this.j;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.k;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.l) * 31;
            long j = this.m;
            int i = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.n;
            return this.p.hashCode() + ((((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.o ? 1 : 0)) * 31);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.o2$c */
    /* JADX INFO: compiled from: Timeline.java */
    public static final class c implements Bundleable {
        public static final Object j = new Object();
        public static final Object k = new Object();
        public static final MediaItem2 l;
        public static final Bundleable.a<c> m;
        public long A;
        public int B;
        public int C;
        public long D;

        @Nullable
        @Deprecated
        public Object o;

        @Nullable
        public Object q;
        public long r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public long f1042s;
        public long t;
        public boolean u;
        public boolean v;

        @Deprecated
        public boolean w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @Nullable
        public MediaItem2.g f1043x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f1044y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public long f1045z;
        public Object n = j;
        public MediaItem2 p = l;

        static {
            MediaItem2.i iVar;
            MediaItem2.d.a aVar = new MediaItem2.d.a();
            MediaItem2.f.a aVar2 = new MediaItem2.f.a(null);
            List listEmptyList = Collections.emptyList();
            ImmutableList2<Object> immutableList2 = RegularImmutableList.l;
            MediaItem2.g.a aVar3 = new MediaItem2.g.a();
            Uri uri = Uri.EMPTY;
            AnimatableValueParser.D(aVar2.f1037b == null || aVar2.a != null);
            if (uri != null) {
                iVar = new MediaItem2.i(uri, null, aVar2.a != null ? new MediaItem2.f(aVar2, null) : null, null, listEmptyList, null, immutableList2, null, null);
            } else {
                iVar = null;
            }
            l = new MediaItem2("com.google.android.exoplayer2.Timeline", aVar.a(), iVar, new MediaItem2.g(aVar3, null), MediaMetadata.j, null);
            m = new Bundleable.a() { // from class: b.i.a.c.q0
                @Override // b.i.a.c.Bundleable.a
                public final Bundleable a(Bundle bundle) {
                    Bundle bundle2 = bundle.getBundle(Timeline.c.d(1));
                    MediaItem2 mediaItem2 = bundle2 != null ? (MediaItem2) MediaItem2.j.a(bundle2) : null;
                    long j2 = bundle.getLong(Timeline.c.d(2), -9223372036854775807L);
                    long j3 = bundle.getLong(Timeline.c.d(3), -9223372036854775807L);
                    long j4 = bundle.getLong(Timeline.c.d(4), -9223372036854775807L);
                    boolean z2 = bundle.getBoolean(Timeline.c.d(5), false);
                    boolean z3 = bundle.getBoolean(Timeline.c.d(6), false);
                    Bundle bundle3 = bundle.getBundle(Timeline.c.d(7));
                    MediaItem2.g gVar = bundle3 != null ? (MediaItem2.g) MediaItem2.g.k.a(bundle3) : null;
                    boolean z4 = bundle.getBoolean(Timeline.c.d(8), false);
                    long j5 = bundle.getLong(Timeline.c.d(9), 0L);
                    long j6 = bundle.getLong(Timeline.c.d(10), -9223372036854775807L);
                    int i = bundle.getInt(Timeline.c.d(11), 0);
                    int i2 = bundle.getInt(Timeline.c.d(12), 0);
                    long j7 = bundle.getLong(Timeline.c.d(13), 0L);
                    Timeline.c cVar = new Timeline.c();
                    cVar.e(Timeline.c.k, mediaItem2, null, j2, j3, j4, z2, z3, gVar, j5, j6, i, i2, j7);
                    cVar.f1044y = z4;
                    return cVar;
                }
            };
        }

        public static String d(int i) {
            return Integer.toString(i, 36);
        }

        public long a() {
            return Util2.M(this.f1045z);
        }

        public long b() {
            return Util2.M(this.A);
        }

        public boolean c() {
            AnimatableValueParser.D(this.w == (this.f1043x != null));
            return this.f1043x != null;
        }

        public c e(Object obj, @Nullable MediaItem2 mediaItem2, @Nullable Object obj2, long j2, long j3, long j4, boolean z2, boolean z3, @Nullable MediaItem2.g gVar, long j5, long j6, int i, int i2, long j7) {
            MediaItem2.h hVar;
            this.n = obj;
            this.p = mediaItem2 != null ? mediaItem2 : l;
            this.o = (mediaItem2 == null || (hVar = mediaItem2.l) == null) ? null : hVar.g;
            this.q = obj2;
            this.r = j2;
            this.f1042s = j3;
            this.t = j4;
            this.u = z2;
            this.v = z3;
            this.w = gVar != null;
            this.f1043x = gVar;
            this.f1045z = j5;
            this.A = j6;
            this.B = i;
            this.C = i2;
            this.D = j7;
            this.f1044y = false;
            return this;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !c.class.equals(obj.getClass())) {
                return false;
            }
            c cVar = (c) obj;
            return Util2.a(this.n, cVar.n) && Util2.a(this.p, cVar.p) && Util2.a(this.q, cVar.q) && Util2.a(this.f1043x, cVar.f1043x) && this.r == cVar.r && this.f1042s == cVar.f1042s && this.t == cVar.t && this.u == cVar.u && this.v == cVar.v && this.f1044y == cVar.f1044y && this.f1045z == cVar.f1045z && this.A == cVar.A && this.B == cVar.B && this.C == cVar.C && this.D == cVar.D;
        }

        public int hashCode() {
            int iHashCode = (this.p.hashCode() + ((this.n.hashCode() + 217) * 31)) * 31;
            Object obj = this.q;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            MediaItem2.g gVar = this.f1043x;
            int iHashCode3 = (iHashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31;
            long j2 = this.r;
            int i = (iHashCode3 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.f1042s;
            int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.t;
            int i3 = (((((((i2 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.u ? 1 : 0)) * 31) + (this.v ? 1 : 0)) * 31) + (this.f1044y ? 1 : 0)) * 31;
            long j5 = this.f1045z;
            int i4 = (i3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
            long j6 = this.A;
            int i5 = (((((i4 + ((int) (j6 ^ (j6 >>> 32)))) * 31) + this.B) * 31) + this.C) * 31;
            long j7 = this.D;
            return i5 + ((int) (j7 ^ (j7 >>> 32)));
        }
    }

    public int a(boolean z2) {
        return q() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z2) {
        if (q()) {
            return -1;
        }
        return p() - 1;
    }

    public final int d(int i, b bVar, c cVar, int i2, boolean z2) {
        int i3 = g(i, bVar, false).l;
        if (n(i3, cVar).C != i) {
            return i + 1;
        }
        int iE = e(i3, i2, z2);
        if (iE == -1) {
            return -1;
        }
        return n(iE, cVar).B;
    }

    public int e(int i, int i2, boolean z2) {
        if (i2 == 0) {
            if (i == c(z2)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == c(z2) ? a(z2) : i + 1;
        }
        throw new IllegalStateException();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.p() != p() || timeline.i() != i()) {
            return false;
        }
        c cVar = new c();
        b bVar = new b();
        c cVar2 = new c();
        b bVar2 = new b();
        for (int i = 0; i < p(); i++) {
            if (!n(i, cVar).equals(timeline.n(i, cVar2))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < i(); i2++) {
            if (!g(i2, bVar, true).equals(timeline.g(i2, bVar2, true))) {
                return false;
            }
        }
        return true;
    }

    public final b f(int i, b bVar) {
        return g(i, bVar, false);
    }

    public abstract b g(int i, b bVar, boolean z2);

    public b h(Object obj, b bVar) {
        return g(b(obj), bVar, true);
    }

    public int hashCode() {
        c cVar = new c();
        b bVar = new b();
        int iP = p() + 217;
        for (int i = 0; i < p(); i++) {
            iP = (iP * 31) + n(i, cVar).hashCode();
        }
        int i2 = i() + (iP * 31);
        for (int i3 = 0; i3 < i(); i3++) {
            i2 = (i2 * 31) + g(i3, bVar, true).hashCode();
        }
        return i2;
    }

    public abstract int i();

    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs)")
    @Deprecated
    public final Pair<Object, Long> j(c cVar, b bVar, int i, long j2) {
        Pair<Object, Long> pairK = k(cVar, bVar, i, j2, 0L);
        Objects.requireNonNull(pairK);
        return pairK;
    }

    @Nullable
    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs, defaultPositionProjectionUs)")
    @Deprecated
    public final Pair<Object, Long> k(c cVar, b bVar, int i, long j2, long j3) {
        AnimatableValueParser.t(i, 0, p());
        o(i, cVar, j3);
        if (j2 == -9223372036854775807L) {
            j2 = cVar.f1045z;
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = cVar.B;
        f(i2, bVar);
        while (i2 < cVar.C && bVar.n != j2) {
            int i3 = i2 + 1;
            if (f(i3, bVar).n > j2) {
                break;
            }
            i2 = i3;
        }
        g(i2, bVar, true);
        long jMin = j2 - bVar.n;
        long j4 = bVar.m;
        if (j4 != -9223372036854775807L) {
            jMin = Math.min(jMin, j4 - 1);
        }
        long jMax = Math.max(0L, jMin);
        Object obj = bVar.k;
        Objects.requireNonNull(obj);
        return Pair.create(obj, Long.valueOf(jMax));
    }

    public int l(int i, int i2, boolean z2) {
        if (i2 == 0) {
            if (i == a(z2)) {
                return -1;
            }
            return i - 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == a(z2) ? c(z2) : i - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object m(int i);

    public final c n(int i, c cVar) {
        return o(i, cVar, 0L);
    }

    public abstract c o(int i, c cVar, long j2);

    public abstract int p();

    public final boolean q() {
        return p() == 0;
    }
}
