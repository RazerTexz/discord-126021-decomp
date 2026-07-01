package b.i.a.c.a3;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: CompositeMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o$a implements b0, b.i.a.c.w2.s {
    public final T j;
    public b0$a k;
    public b.i.a.c.w2.s$a l;
    public final /* synthetic */ o m;

    public o$a(o oVar, T t) {
        this.m = oVar;
        this.k = oVar.c.g(0, null, 0L);
        this.l = oVar.d.g(0, null);
        this.j = t;
    }

    @Override // b.i.a.c.w2.s
    public void J(int i, @Nullable a0$a a0_a) {
        a(i, a0_a);
        this.l.b();
    }

    @Override // b.i.a.c.w2.s
    public void S(int i, @Nullable a0$a a0_a) {
        a(i, a0_a);
        this.l.a();
    }

    @Override // b.i.a.c.a3.b0
    public void X(int i, @Nullable a0$a a0_a, t tVar, w wVar) {
        a(i, a0_a);
        this.k.d(tVar, b(wVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(int i, @Nullable a0$a a0_a) {
        a0$a a0_aB;
        if (a0_a != null) {
            o oVar = this.m;
            T t = this.j;
            v vVar = (v) oVar;
            Objects.requireNonNull(vVar);
            Object obj = a0_a.a;
            Object obj2 = vVar.n.n;
            if (obj2 != null && obj2.equals(obj)) {
                obj = v$a.l;
            }
            a0_aB = a0_a.b(obj);
        } else {
            a0_aB = null;
        }
        Objects.requireNonNull(this.m);
        b0$a b0_a = this.k;
        if (b0_a.a != i || !b.i.a.c.f3.e0.a(b0_a.f807b, a0_aB)) {
            this.k = this.m.c.g(i, a0_aB, 0L);
        }
        b.i.a.c.w2.s$a s_a = this.l;
        if (s_a.a == i && b.i.a.c.f3.e0.a(s_a.f1156b, a0_aB)) {
            return true;
        }
        this.l = new b.i.a.c.w2.s$a(this.m.d.c, i, a0_aB);
        return true;
    }

    public final w b(w wVar) {
        o oVar = this.m;
        long j = wVar.f;
        Objects.requireNonNull(oVar);
        o oVar2 = this.m;
        long j2 = wVar.g;
        Objects.requireNonNull(oVar2);
        return (j == wVar.f && j2 == wVar.g) ? wVar : new w(wVar.a, wVar.f834b, wVar.c, wVar.d, wVar.e, j, j2);
    }

    @Override // b.i.a.c.w2.s
    public void c0(int i, @Nullable a0$a a0_a, int i2) {
        a(i, a0_a);
        this.l.d(i2);
    }

    @Override // b.i.a.c.w2.s
    public void d0(int i, @Nullable a0$a a0_a) {
        a(i, a0_a);
        this.l.f();
    }

    @Override // b.i.a.c.a3.b0
    public void g0(int i, @Nullable a0$a a0_a, t tVar, w wVar, IOException iOException, boolean z2) {
        a(i, a0_a);
        this.k.e(tVar, b(wVar), iOException, z2);
    }

    @Override // b.i.a.c.w2.s
    public void i0(int i, @Nullable a0$a a0_a) {
        a(i, a0_a);
        this.l.c();
    }

    @Override // b.i.a.c.a3.b0
    public void o(int i, @Nullable a0$a a0_a, w wVar) {
        a(i, a0_a);
        this.k.b(b(wVar));
    }

    @Override // b.i.a.c.a3.b0
    public void q(int i, @Nullable a0$a a0_a, t tVar, w wVar) {
        a(i, a0_a);
        this.k.c(tVar, b(wVar));
    }

    @Override // b.i.a.c.w2.s
    public void u(int i, @Nullable a0$a a0_a, Exception exc) {
        a(i, a0_a);
        this.l.e(exc);
    }

    @Override // b.i.a.c.a3.b0
    public void x(int i, @Nullable a0$a a0_a, t tVar, w wVar) {
        a(i, a0_a);
        this.k.f(tVar, b(wVar));
    }
}
