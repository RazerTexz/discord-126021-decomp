package b.i.a.c;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: ExoPlayer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e1$b {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.i.a.c.f3.g f923b;
    public b.i.b.a.l<i2> c;
    public b.i.b.a.l<b.i.a.c.a3.c0> d;
    public b.i.b.a.l<b.i.a.c.c3.q> e;
    public b.i.b.a.l<n1> f;
    public b.i.b.a.l<b.i.a.c.e3.f> g;
    public b.i.b.a.l<b.i.a.c.s2.g1> h;
    public Looper i;
    public b.i.a.c.t2.o j;
    public int k;
    public boolean l;
    public j2 m;
    public long n;
    public long o;
    public m1 p;
    public long q;
    public long r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f924s;

    public e1$b(Context context) {
        f fVar = new f(context);
        h hVar = new h(context);
        g gVar = new g(context);
        a aVar = a.j;
        e eVar = new e(context);
        this.a = context;
        this.c = fVar;
        this.d = hVar;
        this.e = gVar;
        this.f = aVar;
        this.g = eVar;
        this.h = new i(this);
        this.i = b.i.a.c.f3.e0.o();
        this.j = b.i.a.c.t2.o.j;
        this.k = 1;
        this.l = true;
        this.m = j2.f1026b;
        this.n = 5000L;
        this.o = 15000L;
        this.p = new y0(0.97f, 1.03f, 1000L, 1.0E-7f, b.i.a.c.f3.e0.B(20L), b.i.a.c.f3.e0.B(500L), 0.999f, null);
        this.f923b = b.i.a.c.f3.g.a;
        this.q = 500L;
        this.r = 2000L;
    }
}
