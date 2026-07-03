package p007b.p225i.p226a.p242c;

import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p243a3.C2558o0;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p255c3.C2648n;
import p007b.p225i.p226a.p242c.p259f3.C2747n;
import p007b.p225i.p226a.p242c.p260g3.C2788y;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.c.y1 */
/* JADX INFO: compiled from: Player.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC3128y1 {

    /* JADX INFO: renamed from: b.i.a.c.y1$b */
    /* JADX INFO: compiled from: Player.java */
    public static final class b implements InterfaceC2963w0 {

        /* JADX INFO: renamed from: j */
        public static final b f9032j = new b(new C2747n.b().m3033b(), null);

        /* JADX INFO: renamed from: k */
        public final C2747n f9033k;

        /* JADX INFO: renamed from: b.i.a.c.y1$b$a */
        /* JADX INFO: compiled from: Player.java */
        public static final class a {

            /* JADX INFO: renamed from: a */
            public final C2747n.b f9034a = new C2747n.b();

            /* JADX INFO: renamed from: a */
            public a m3826a(b bVar) {
                C2747n.b bVar2 = this.f9034a;
                C2747n c2747n = bVar.f9033k;
                Objects.requireNonNull(bVar2);
                for (int i = 0; i < c2747n.m3031c(); i++) {
                    bVar2.m3032a(c2747n.m3030b(i));
                }
                return this;
            }

            /* JADX INFO: renamed from: b */
            public a m3827b(int i, boolean z2) {
                C2747n.b bVar = this.f9034a;
                Objects.requireNonNull(bVar);
                if (z2) {
                    C1460d.m426D(!bVar.f6735b);
                    bVar.f6734a.append(i, true);
                }
                return this;
            }

            /* JADX INFO: renamed from: c */
            public b m3828c() {
                return new b(this.f9034a.m3033b(), null);
            }
        }

        public b(C2747n c2747n, a aVar) {
            this.f9033k = c2747n;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f9033k.equals(((b) obj).f9033k);
            }
            return false;
        }

        public int hashCode() {
            return this.f9033k.hashCode();
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.y1$c */
    /* JADX INFO: compiled from: Player.java */
    @Deprecated
    public interface c {
        /* JADX INFO: renamed from: A */
        void mo235A(C2835p1 c2835p1);

        /* JADX INFO: renamed from: D */
        void mo236D(boolean z2);

        /* JADX INFO: renamed from: E */
        void mo237E(InterfaceC3128y1 interfaceC3128y1, d dVar);

        @Deprecated
        /* JADX INFO: renamed from: H */
        void mo239H(boolean z2, int i);

        /* JADX INFO: renamed from: L */
        void mo240L(int i);

        /* JADX INFO: renamed from: M */
        void mo241M(@Nullable C2831o1 c2831o1, int i);

        /* JADX INFO: renamed from: W */
        void mo242W(boolean z2, int i);

        @Deprecated
        /* JADX INFO: renamed from: Y */
        void mo243Y(C2558o0 c2558o0, C2648n c2648n);

        @Deprecated
        /* JADX INFO: renamed from: a */
        void mo244a();

        /* JADX INFO: renamed from: b0 */
        void mo247b0(C2998x1 c2998x1);

        /* JADX INFO: renamed from: f0 */
        void mo252f0(@Nullable PlaybackException playbackException);

        /* JADX INFO: renamed from: g */
        void mo253g(f fVar, f fVar2, int i);

        /* JADX INFO: renamed from: h */
        void mo254h(int i);

        @Deprecated
        /* JADX INFO: renamed from: i */
        void mo255i(boolean z2);

        @Deprecated
        /* JADX INFO: renamed from: j */
        void mo256j(int i);

        /* JADX INFO: renamed from: j0 */
        void mo257j0(boolean z2);

        /* JADX INFO: renamed from: p */
        void mo258p(C2836p2 c2836p2);

        /* JADX INFO: renamed from: r */
        void mo259r(boolean z2);

        /* JADX INFO: renamed from: s */
        void mo260s(PlaybackException playbackException);

        /* JADX INFO: renamed from: t */
        void mo261t(b bVar);

        /* JADX INFO: renamed from: v */
        void mo262v(AbstractC2832o2 abstractC2832o2, int i);

        /* JADX INFO: renamed from: y */
        void mo264y(int i);
    }

    /* JADX INFO: renamed from: b.i.a.c.y1$d */
    /* JADX INFO: compiled from: Player.java */
    public static final class d {

        /* JADX INFO: renamed from: a */
        public final C2747n f9035a;

        public d(C2747n c2747n) {
            this.f9035a = c2747n;
        }

        /* JADX INFO: renamed from: a */
        public boolean m3829a(int... iArr) {
            C2747n c2747n = this.f9035a;
            Objects.requireNonNull(c2747n);
            for (int i : iArr) {
                if (c2747n.m3029a(i)) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d) {
                return this.f9035a.equals(((d) obj).f9035a);
            }
            return false;
        }

        public int hashCode() {
            return this.f9035a.hashCode();
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.y1$e */
    /* JADX INFO: compiled from: Player.java */
    public interface e extends c {
        /* JADX INFO: renamed from: G */
        void mo238G(int i, boolean z2);

        /* JADX INFO: renamed from: a0 */
        void mo245a0(int i, int i2);

        /* JADX INFO: renamed from: b */
        void mo246b(Metadata metadata);

        /* JADX INFO: renamed from: c */
        void mo248c();

        /* JADX INFO: renamed from: d */
        void mo249d(boolean z2);

        /* JADX INFO: renamed from: e */
        void mo250e(List<C2578b> list);

        /* JADX INFO: renamed from: f */
        void mo251f(C2788y c2788y);

        /* JADX INFO: renamed from: w */
        void mo263w(float f);

        /* JADX INFO: renamed from: z */
        void mo265z(C2633c1 c2633c1);
    }

    /* JADX INFO: renamed from: b.i.a.c.y1$f */
    /* JADX INFO: compiled from: Player.java */
    public static final class f implements InterfaceC2963w0 {

        /* JADX INFO: renamed from: j */
        @Nullable
        public final Object f9036j;

        /* JADX INFO: renamed from: k */
        public final int f9037k;

        /* JADX INFO: renamed from: l */
        @Nullable
        public final C2831o1 f9038l;

        /* JADX INFO: renamed from: m */
        @Nullable
        public final Object f9039m;

        /* JADX INFO: renamed from: n */
        public final int f9040n;

        /* JADX INFO: renamed from: o */
        public final long f9041o;

        /* JADX INFO: renamed from: p */
        public final long f9042p;

        /* JADX INFO: renamed from: q */
        public final int f9043q;

        /* JADX INFO: renamed from: r */
        public final int f9044r;

        public f(@Nullable Object obj, int i, @Nullable C2831o1 c2831o1, @Nullable Object obj2, int i2, long j, long j2, int i3, int i4) {
            this.f9036j = obj;
            this.f9037k = i;
            this.f9038l = c2831o1;
            this.f9039m = obj2;
            this.f9040n = i2;
            this.f9041o = j;
            this.f9042p = j2;
            this.f9043q = i3;
            this.f9044r = i4;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.f9037k == fVar.f9037k && this.f9040n == fVar.f9040n && this.f9041o == fVar.f9041o && this.f9042p == fVar.f9042p && this.f9043q == fVar.f9043q && this.f9044r == fVar.f9044r && C3404f.m4252V(this.f9036j, fVar.f9036j) && C3404f.m4252V(this.f9039m, fVar.f9039m) && C3404f.m4252V(this.f9038l, fVar.f9038l);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f9036j, Integer.valueOf(this.f9037k), this.f9038l, this.f9039m, Integer.valueOf(this.f9040n), Long.valueOf(this.f9041o), Long.valueOf(this.f9042p), Integer.valueOf(this.f9043q), Integer.valueOf(this.f9044r)});
        }
    }

    /* JADX INFO: renamed from: A */
    List<C2578b> mo2879A();

    /* JADX INFO: renamed from: B */
    int mo2880B();

    /* JADX INFO: renamed from: C */
    int mo2881C();

    /* JADX INFO: renamed from: D */
    boolean mo3518D(int i);

    /* JADX INFO: renamed from: E */
    void mo2882E(int i);

    /* JADX INFO: renamed from: F */
    void mo2883F(@Nullable SurfaceView surfaceView);

    /* JADX INFO: renamed from: G */
    int mo2884G();

    /* JADX INFO: renamed from: H */
    C2836p2 mo2885H();

    /* JADX INFO: renamed from: I */
    int mo2886I();

    /* JADX INFO: renamed from: J */
    long mo2887J();

    /* JADX INFO: renamed from: K */
    AbstractC2832o2 mo2888K();

    /* JADX INFO: renamed from: L */
    Looper mo2889L();

    /* JADX INFO: renamed from: M */
    boolean mo2890M();

    /* JADX INFO: renamed from: N */
    long mo2891N();

    /* JADX INFO: renamed from: O */
    void mo3519O();

    /* JADX INFO: renamed from: P */
    void mo3520P();

    /* JADX INFO: renamed from: Q */
    void mo2892Q(@Nullable TextureView textureView);

    /* JADX INFO: renamed from: R */
    void mo3521R();

    /* JADX INFO: renamed from: S */
    C2835p1 mo2893S();

    /* JADX INFO: renamed from: T */
    long mo2894T();

    /* JADX INFO: renamed from: U */
    long mo2895U();

    /* JADX INFO: renamed from: a */
    void mo2896a();

    /* JADX INFO: renamed from: c */
    C2998x1 mo2897c();

    /* JADX INFO: renamed from: d */
    void mo3531d();

    /* JADX INFO: renamed from: e */
    void mo3532e();

    /* JADX INFO: renamed from: f */
    boolean mo2900f();

    /* JADX INFO: renamed from: g */
    long mo2902g();

    /* JADX INFO: renamed from: h */
    void mo2904h(int i, long j);

    /* JADX INFO: renamed from: i */
    b mo2906i();

    /* JADX INFO: renamed from: j */
    boolean mo2908j();

    /* JADX INFO: renamed from: k */
    void mo2909k(boolean z2);

    /* JADX INFO: renamed from: l */
    long mo2910l();

    /* JADX INFO: renamed from: m */
    int mo2912m();

    /* JADX INFO: renamed from: n */
    void mo2914n(@Nullable TextureView textureView);

    /* JADX INFO: renamed from: o */
    C2788y mo2916o();

    /* JADX INFO: renamed from: p */
    void mo2918p(e eVar);

    /* JADX INFO: renamed from: q */
    int mo2920q();

    /* JADX INFO: renamed from: r */
    void mo2922r(@Nullable SurfaceView surfaceView);

    /* JADX INFO: renamed from: s */
    void mo3533s();

    @Nullable
    /* JADX INFO: renamed from: t */
    PlaybackException mo2925t();

    /* JADX INFO: renamed from: u */
    void mo2926u(boolean z2);

    /* JADX INFO: renamed from: v */
    long mo2927v();

    /* JADX INFO: renamed from: w */
    long mo2928w();

    /* JADX INFO: renamed from: x */
    void mo2929x(e eVar);

    /* JADX INFO: renamed from: y */
    int mo2930y();

    /* JADX INFO: renamed from: z */
    boolean mo3534z();
}
