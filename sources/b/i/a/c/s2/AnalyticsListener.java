package b.i.a.c.s2;

import androidx.annotation.Nullable;
import b.i.a.c.Timeline;
import b.i.a.c.a3.MediaSource2;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.s2.h1, reason: use source file name */
/* JADX INFO: compiled from: AnalyticsListener.java */
/* JADX INFO: loaded from: classes3.dex */
public interface AnalyticsListener {

    /* JADX INFO: renamed from: b.i.a.c.s2.h1$a */
    /* JADX INFO: compiled from: AnalyticsListener.java */
    public static final class a {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Timeline f1084b;
        public final int c;

        @Nullable
        public final MediaSource2.a d;
        public final long e;
        public final Timeline f;
        public final int g;

        @Nullable
        public final MediaSource2.a h;
        public final long i;
        public final long j;

        public a(long j, Timeline timeline, int i, @Nullable MediaSource2.a aVar, long j2, Timeline timeline2, int i2, @Nullable MediaSource2.a aVar2, long j3, long j4) {
            this.a = j;
            this.f1084b = timeline;
            this.c = i;
            this.d = aVar;
            this.e = j2;
            this.f = timeline2;
            this.g = i2;
            this.h = aVar2;
            this.i = j3;
            this.j = j4;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.c == aVar.c && this.e == aVar.e && this.g == aVar.g && this.i == aVar.i && this.j == aVar.j && b.i.a.f.e.o.f.V(this.f1084b, aVar.f1084b) && b.i.a.f.e.o.f.V(this.d, aVar.d) && b.i.a.f.e.o.f.V(this.f, aVar.f) && b.i.a.f.e.o.f.V(this.h, aVar.h);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{Long.valueOf(this.a), this.f1084b, Integer.valueOf(this.c), this.d, Long.valueOf(this.e), this.f, Integer.valueOf(this.g), this.h, Long.valueOf(this.i), Long.valueOf(this.j)});
        }
    }

    void A();

    void B();

    void C();

    void D();

    void E();

    @Deprecated
    void F();

    @Deprecated
    void G();

    void H();

    void I();

    void J();

    void K();

    @Deprecated
    void L();

    void M();

    void N();

    void O();

    void P();

    void Q();

    void R();

    @Deprecated
    void S();

    @Deprecated
    void T();

    void U();

    void V();

    void W();

    void X();

    void Y();

    void Z();

    @Deprecated
    void a();

    void a0();

    void b();

    void b0();

    void c();

    void c0();

    void d();

    @Deprecated
    void d0();

    void e();

    void e0();

    void f();

    void f0();

    @Deprecated
    void g();

    void g0();

    void h();

    @Deprecated
    void h0();

    void i();

    @Deprecated
    void i0();

    void j();

    @Deprecated
    void j0();

    void k();

    @Deprecated
    void k0();

    void l();

    void l0();

    void m();

    @Deprecated
    void m0();

    void n();

    void n0();

    void o();

    void o0();

    void p();

    @Deprecated
    void p0();

    void q();

    @Deprecated
    void r();

    void s();

    void t();

    void u();

    void v();

    void w();

    @Deprecated
    void x();

    void y();

    void z();
}
