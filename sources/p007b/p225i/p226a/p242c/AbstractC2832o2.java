package p007b.p225i.p226a.p242c;

import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.errorprone.annotations.InlineMe;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.AbstractC2832o2;
import p007b.p225i.p226a.p242c.C2831o1;
import p007b.p225i.p226a.p242c.InterfaceC2963w0;
import p007b.p225i.p226a.p242c.p243a3.p244p0.C2562c;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.C4508h0;

/* JADX INFO: renamed from: b.i.a.c.o2 */
/* JADX INFO: compiled from: Timeline.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2832o2 implements InterfaceC2963w0 {

    /* JADX INFO: renamed from: j */
    public static final AbstractC2832o2 f7337j = new a();

    /* JADX INFO: renamed from: b.i.a.c.o2$a */
    /* JADX INFO: compiled from: Timeline.java */
    public class a extends AbstractC2832o2 {
        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: b */
        public int mo2554b(Object obj) {
            return -1;
        }

        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: g */
        public b mo2513g(int i, b bVar, boolean z2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: i */
        public int mo2555i() {
            return 0;
        }

        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: m */
        public Object mo2556m(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: o */
        public c mo2514o(int i, c cVar, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: p */
        public int mo2557p() {
            return 0;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.o2$b */
    /* JADX INFO: compiled from: Timeline.java */
    public static final class b implements InterfaceC2963w0 {

        /* JADX INFO: renamed from: j */
        @Nullable
        public Object f7338j;

        /* JADX INFO: renamed from: k */
        @Nullable
        public Object f7339k;

        /* JADX INFO: renamed from: l */
        public int f7340l;

        /* JADX INFO: renamed from: m */
        public long f7341m;

        /* JADX INFO: renamed from: n */
        public long f7342n;

        /* JADX INFO: renamed from: o */
        public boolean f7343o;

        /* JADX INFO: renamed from: p */
        public C2562c f7344p = C2562c.f5680j;

        /* JADX INFO: renamed from: a */
        public long m3332a(int i, int i2) {
            C2562c.a aVarM2578a = this.f7344p.m2578a(i);
            if (aVarM2578a.f5691l != -1) {
                return aVarM2578a.f5694o[i2];
            }
            return -9223372036854775807L;
        }

        /* JADX INFO: renamed from: b */
        public int m3333b(long j) {
            C2562c c2562c = this.f7344p;
            long j2 = this.f7341m;
            Objects.requireNonNull(c2562c);
            if (j == Long.MIN_VALUE) {
                return -1;
            }
            if (j2 != -9223372036854775807L && j >= j2) {
                return -1;
            }
            int i = c2562c.f5687q;
            while (i < c2562c.f5684n) {
                if (c2562c.m2578a(i).f5690k == Long.MIN_VALUE || c2562c.m2578a(i).f5690k > j) {
                    C2562c.a aVarM2578a = c2562c.m2578a(i);
                    if (aVarM2578a.f5691l == -1 || aVarM2578a.m2580a(-1) < aVarM2578a.f5691l) {
                        break;
                    }
                }
                i++;
            }
            if (i < c2562c.f5684n) {
                return i;
            }
            return -1;
        }

        /* JADX INFO: renamed from: c */
        public long m3334c(int i) {
            return this.f7344p.m2578a(i).f5690k;
        }

        /* JADX INFO: renamed from: d */
        public int m3335d(int i) {
            return this.f7344p.m2578a(i).m2580a(-1);
        }

        /* JADX INFO: renamed from: e */
        public boolean m3336e(int i) {
            return this.f7344p.m2578a(i).f5696q;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return C2738e0.m2993a(this.f7338j, bVar.f7338j) && C2738e0.m2993a(this.f7339k, bVar.f7339k) && this.f7340l == bVar.f7340l && this.f7341m == bVar.f7341m && this.f7342n == bVar.f7342n && this.f7343o == bVar.f7343o && C2738e0.m2993a(this.f7344p, bVar.f7344p);
        }

        /* JADX INFO: renamed from: f */
        public b m3337f(@Nullable Object obj, @Nullable Object obj2, int i, long j, long j2, C2562c c2562c, boolean z2) {
            this.f7338j = obj;
            this.f7339k = obj2;
            this.f7340l = i;
            this.f7341m = j;
            this.f7342n = j2;
            this.f7344p = c2562c;
            this.f7343o = z2;
            return this;
        }

        public int hashCode() {
            Object obj = this.f7338j;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f7339k;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f7340l) * 31;
            long j = this.f7341m;
            int i = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.f7342n;
            return this.f7344p.hashCode() + ((((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.f7343o ? 1 : 0)) * 31);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.o2$c */
    /* JADX INFO: compiled from: Timeline.java */
    public static final class c implements InterfaceC2963w0 {

        /* JADX INFO: renamed from: j */
        public static final Object f7345j = new Object();

        /* JADX INFO: renamed from: k */
        public static final Object f7346k = new Object();

        /* JADX INFO: renamed from: l */
        public static final C2831o1 f7347l;

        /* JADX INFO: renamed from: m */
        public static final InterfaceC2963w0.a<c> f7348m;

        /* JADX INFO: renamed from: A */
        public long f7349A;

        /* JADX INFO: renamed from: B */
        public int f7350B;

        /* JADX INFO: renamed from: C */
        public int f7351C;

        /* JADX INFO: renamed from: D */
        public long f7352D;

        /* JADX INFO: renamed from: o */
        @Nullable
        @Deprecated
        public Object f7354o;

        /* JADX INFO: renamed from: q */
        @Nullable
        public Object f7356q;

        /* JADX INFO: renamed from: r */
        public long f7357r;

        /* JADX INFO: renamed from: s */
        public long f7358s;

        /* JADX INFO: renamed from: t */
        public long f7359t;

        /* JADX INFO: renamed from: u */
        public boolean f7360u;

        /* JADX INFO: renamed from: v */
        public boolean f7361v;

        /* JADX INFO: renamed from: w */
        @Deprecated
        public boolean f7362w;

        /* JADX INFO: renamed from: x */
        @Nullable
        public C2831o1.g f7363x;

        /* JADX INFO: renamed from: y */
        public boolean f7364y;

        /* JADX INFO: renamed from: z */
        public long f7365z;

        /* JADX INFO: renamed from: n */
        public Object f7353n = f7345j;

        /* JADX INFO: renamed from: p */
        public C2831o1 f7355p = f7347l;

        static {
            C2831o1.i iVar;
            C2831o1.d.a aVar = new C2831o1.d.a();
            C2831o1.f.a aVar2 = new C2831o1.f.a(null);
            List listEmptyList = Collections.emptyList();
            AbstractC4523p<Object> abstractC4523p = C4508h0.f12012l;
            C2831o1.g.a aVar3 = new C2831o1.g.a();
            Uri uri = Uri.EMPTY;
            C1460d.m426D(aVar2.f7299b == null || aVar2.f7298a != null);
            if (uri != null) {
                iVar = new C2831o1.i(uri, null, aVar2.f7298a != null ? new C2831o1.f(aVar2, null) : null, null, listEmptyList, null, abstractC4523p, null, null);
            } else {
                iVar = null;
            }
            f7347l = new C2831o1("com.google.android.exoplayer2.Timeline", aVar.m3322a(), iVar, new C2831o1.g(aVar3, null), C2835p1.f7368j, null);
            f7348m = new InterfaceC2963w0.a() { // from class: b.i.a.c.q0
                @Override // p007b.p225i.p226a.p242c.InterfaceC2963w0.a
                /* JADX INFO: renamed from: a */
                public final InterfaceC2963w0 mo2576a(Bundle bundle) {
                    Bundle bundle2 = bundle.getBundle(AbstractC2832o2.c.m3338d(1));
                    C2831o1 c2831o1 = bundle2 != null ? (C2831o1) C2831o1.f7261j.mo2576a(bundle2) : null;
                    long j = bundle.getLong(AbstractC2832o2.c.m3338d(2), -9223372036854775807L);
                    long j2 = bundle.getLong(AbstractC2832o2.c.m3338d(3), -9223372036854775807L);
                    long j3 = bundle.getLong(AbstractC2832o2.c.m3338d(4), -9223372036854775807L);
                    boolean z2 = bundle.getBoolean(AbstractC2832o2.c.m3338d(5), false);
                    boolean z3 = bundle.getBoolean(AbstractC2832o2.c.m3338d(6), false);
                    Bundle bundle3 = bundle.getBundle(AbstractC2832o2.c.m3338d(7));
                    C2831o1.g gVar = bundle3 != null ? (C2831o1.g) C2831o1.g.f7307k.mo2576a(bundle3) : null;
                    boolean z4 = bundle.getBoolean(AbstractC2832o2.c.m3338d(8), false);
                    long j4 = bundle.getLong(AbstractC2832o2.c.m3338d(9), 0L);
                    long j5 = bundle.getLong(AbstractC2832o2.c.m3338d(10), -9223372036854775807L);
                    int i = bundle.getInt(AbstractC2832o2.c.m3338d(11), 0);
                    int i2 = bundle.getInt(AbstractC2832o2.c.m3338d(12), 0);
                    long j6 = bundle.getLong(AbstractC2832o2.c.m3338d(13), 0L);
                    AbstractC2832o2.c cVar = new AbstractC2832o2.c();
                    cVar.m3342e(AbstractC2832o2.c.f7346k, c2831o1, null, j, j2, j3, z2, z3, gVar, j4, j5, i, i2, j6);
                    cVar.f7364y = z4;
                    return cVar;
                }
            };
        }

        /* JADX INFO: renamed from: d */
        public static String m3338d(int i) {
            return Integer.toString(i, 36);
        }

        /* JADX INFO: renamed from: a */
        public long m3339a() {
            return C2738e0.m2992M(this.f7365z);
        }

        /* JADX INFO: renamed from: b */
        public long m3340b() {
            return C2738e0.m2992M(this.f7349A);
        }

        /* JADX INFO: renamed from: c */
        public boolean m3341c() {
            C1460d.m426D(this.f7362w == (this.f7363x != null));
            return this.f7363x != null;
        }

        /* JADX INFO: renamed from: e */
        public c m3342e(Object obj, @Nullable C2831o1 c2831o1, @Nullable Object obj2, long j, long j2, long j3, boolean z2, boolean z3, @Nullable C2831o1.g gVar, long j4, long j5, int i, int i2, long j6) {
            C2831o1.h hVar;
            this.f7353n = obj;
            this.f7355p = c2831o1 != null ? c2831o1 : f7347l;
            this.f7354o = (c2831o1 == null || (hVar = c2831o1.f7263l) == null) ? null : hVar.f7324g;
            this.f7356q = obj2;
            this.f7357r = j;
            this.f7358s = j2;
            this.f7359t = j3;
            this.f7360u = z2;
            this.f7361v = z3;
            this.f7362w = gVar != null;
            this.f7363x = gVar;
            this.f7365z = j4;
            this.f7349A = j5;
            this.f7350B = i;
            this.f7351C = i2;
            this.f7352D = j6;
            this.f7364y = false;
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
            return C2738e0.m2993a(this.f7353n, cVar.f7353n) && C2738e0.m2993a(this.f7355p, cVar.f7355p) && C2738e0.m2993a(this.f7356q, cVar.f7356q) && C2738e0.m2993a(this.f7363x, cVar.f7363x) && this.f7357r == cVar.f7357r && this.f7358s == cVar.f7358s && this.f7359t == cVar.f7359t && this.f7360u == cVar.f7360u && this.f7361v == cVar.f7361v && this.f7364y == cVar.f7364y && this.f7365z == cVar.f7365z && this.f7349A == cVar.f7349A && this.f7350B == cVar.f7350B && this.f7351C == cVar.f7351C && this.f7352D == cVar.f7352D;
        }

        public int hashCode() {
            int iHashCode = (this.f7355p.hashCode() + ((this.f7353n.hashCode() + 217) * 31)) * 31;
            Object obj = this.f7356q;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            C2831o1.g gVar = this.f7363x;
            int iHashCode3 = (iHashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31;
            long j = this.f7357r;
            int i = (iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.f7358s;
            int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.f7359t;
            int i3 = (((((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.f7360u ? 1 : 0)) * 31) + (this.f7361v ? 1 : 0)) * 31) + (this.f7364y ? 1 : 0)) * 31;
            long j4 = this.f7365z;
            int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j5 = this.f7349A;
            int i5 = (((((i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.f7350B) * 31) + this.f7351C) * 31;
            long j6 = this.f7352D;
            return i5 + ((int) (j6 ^ (j6 >>> 32)));
        }
    }

    /* JADX INFO: renamed from: a */
    public int mo2582a(boolean z2) {
        return m3331q() ? -1 : 0;
    }

    /* JADX INFO: renamed from: b */
    public abstract int mo2554b(Object obj);

    /* JADX INFO: renamed from: c */
    public int mo2583c(boolean z2) {
        if (m3331q()) {
            return -1;
        }
        return mo2557p() - 1;
    }

    /* JADX INFO: renamed from: d */
    public final int m3325d(int i, b bVar, c cVar, int i2, boolean z2) {
        int i3 = mo2513g(i, bVar, false).f7340l;
        if (m3330n(i3, cVar).f7351C != i) {
            return i + 1;
        }
        int iMo2584e = mo2584e(i3, i2, z2);
        if (iMo2584e == -1) {
            return -1;
        }
        return m3330n(iMo2584e, cVar).f7350B;
    }

    /* JADX INFO: renamed from: e */
    public int mo2584e(int i, int i2, boolean z2) {
        if (i2 == 0) {
            if (i == mo2583c(z2)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == mo2583c(z2) ? mo2582a(z2) : i + 1;
        }
        throw new IllegalStateException();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC2832o2)) {
            return false;
        }
        AbstractC2832o2 abstractC2832o2 = (AbstractC2832o2) obj;
        if (abstractC2832o2.mo2557p() != mo2557p() || abstractC2832o2.mo2555i() != mo2555i()) {
            return false;
        }
        c cVar = new c();
        b bVar = new b();
        c cVar2 = new c();
        b bVar2 = new b();
        for (int i = 0; i < mo2557p(); i++) {
            if (!m3330n(i, cVar).equals(abstractC2832o2.m3330n(i, cVar2))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < mo2555i(); i2++) {
            if (!mo2513g(i2, bVar, true).equals(abstractC2832o2.mo2513g(i2, bVar2, true))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    public final b m3326f(int i, b bVar) {
        return mo2513g(i, bVar, false);
    }

    /* JADX INFO: renamed from: g */
    public abstract b mo2513g(int i, b bVar, boolean z2);

    /* JADX INFO: renamed from: h */
    public b mo3327h(Object obj, b bVar) {
        return mo2513g(mo2554b(obj), bVar, true);
    }

    public int hashCode() {
        c cVar = new c();
        b bVar = new b();
        int iMo2557p = mo2557p() + 217;
        for (int i = 0; i < mo2557p(); i++) {
            iMo2557p = (iMo2557p * 31) + m3330n(i, cVar).hashCode();
        }
        int iMo2555i = mo2555i() + (iMo2557p * 31);
        for (int i2 = 0; i2 < mo2555i(); i2++) {
            iMo2555i = (iMo2555i * 31) + mo2513g(i2, bVar, true).hashCode();
        }
        return iMo2555i;
    }

    /* JADX INFO: renamed from: i */
    public abstract int mo2555i();

    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs)")
    @Deprecated
    /* JADX INFO: renamed from: j */
    public final Pair<Object, Long> m3328j(c cVar, b bVar, int i, long j) {
        Pair<Object, Long> pairM3329k = m3329k(cVar, bVar, i, j, 0L);
        Objects.requireNonNull(pairM3329k);
        return pairM3329k;
    }

    @Nullable
    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs, defaultPositionProjectionUs)")
    @Deprecated
    /* JADX INFO: renamed from: k */
    public final Pair<Object, Long> m3329k(c cVar, b bVar, int i, long j, long j2) {
        C1460d.m571t(i, 0, mo2557p());
        mo2514o(i, cVar, j2);
        if (j == -9223372036854775807L) {
            j = cVar.f7365z;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = cVar.f7350B;
        m3326f(i2, bVar);
        while (i2 < cVar.f7351C && bVar.f7342n != j) {
            int i3 = i2 + 1;
            if (m3326f(i3, bVar).f7342n > j) {
                break;
            }
            i2 = i3;
        }
        mo2513g(i2, bVar, true);
        long jMin = j - bVar.f7342n;
        long j3 = bVar.f7341m;
        if (j3 != -9223372036854775807L) {
            jMin = Math.min(jMin, j3 - 1);
        }
        long jMax = Math.max(0L, jMin);
        Object obj = bVar.f7339k;
        Objects.requireNonNull(obj);
        return Pair.create(obj, Long.valueOf(jMax));
    }

    /* JADX INFO: renamed from: l */
    public int mo2585l(int i, int i2, boolean z2) {
        if (i2 == 0) {
            if (i == mo2582a(z2)) {
                return -1;
            }
            return i - 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == mo2582a(z2) ? mo2583c(z2) : i - 1;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: renamed from: m */
    public abstract Object mo2556m(int i);

    /* JADX INFO: renamed from: n */
    public final c m3330n(int i, c cVar) {
        return mo2514o(i, cVar, 0L);
    }

    /* JADX INFO: renamed from: o */
    public abstract c mo2514o(int i, c cVar, long j);

    /* JADX INFO: renamed from: p */
    public abstract int mo2557p();

    /* JADX INFO: renamed from: q */
    public final boolean m3331q() {
        return mo2557p() == 0;
    }
}
