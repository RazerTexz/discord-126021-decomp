package b.i.a.c;

import android.util.Pair;
import androidx.annotation.Nullable;
import b.i.a.c.a3.a0$a;
import b.i.a.c.a3.b0$a;
import b.i.a.c.w2.s$a;
import java.io.IOException;

/* JADX INFO: compiled from: MediaSourceList.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u1$a implements b.i.a.c.a3.b0, b.i.a.c.w2.s {
    public final u1$c j;
    public b0$a k;
    public s$a l;
    public final /* synthetic */ u1 m;

    public u1$a(u1 u1Var, u1$c u1_c) {
        this.m = u1Var;
        this.k = u1Var.e;
        this.l = u1Var.f;
        this.j = u1_c;
    }

    @Override // b.i.a.c.w2.s
    public void J(int i, @Nullable a0$a a0_a) {
        if (a(i, a0_a)) {
            this.l.b();
        }
    }

    @Override // b.i.a.c.w2.s
    public void S(int i, @Nullable a0$a a0_a) {
        if (a(i, a0_a)) {
            this.l.a();
        }
    }

    @Override // b.i.a.c.a3.b0
    public void X(int i, @Nullable a0$a a0_a, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar) {
        if (a(i, a0_a)) {
            this.k.d(tVar, wVar);
        }
    }

    public final boolean a(int i, @Nullable a0$a a0_a) {
        a0$a a0_aB = null;
        if (a0_a != null) {
            u1$c u1_c = this.j;
            for (int i2 = 0; i2 < u1_c.c.size(); i2++) {
                if (u1_c.c.get(i2).d == a0_a.d) {
                    a0_aB = a0_a.b(Pair.create(u1_c.f1139b, a0_a.a));
                    break;
                }
            }
            if (a0_aB == null) {
                return false;
            }
        }
        int i3 = i + this.j.d;
        b0$a b0_a = this.k;
        if (b0_a.a != i3 || !b.i.a.c.f3.e0.a(b0_a.f807b, a0_aB)) {
            this.k = this.m.e.g(i3, a0_aB, 0L);
        }
        s$a s_a = this.l;
        if (s_a.a == i3 && b.i.a.c.f3.e0.a(s_a.f1156b, a0_aB)) {
            return true;
        }
        this.l = this.m.f.g(i3, a0_aB);
        return true;
    }

    @Override // b.i.a.c.w2.s
    public void c0(int i, @Nullable a0$a a0_a, int i2) {
        if (a(i, a0_a)) {
            this.l.d(i2);
        }
    }

    @Override // b.i.a.c.w2.s
    public void d0(int i, @Nullable a0$a a0_a) {
        if (a(i, a0_a)) {
            this.l.f();
        }
    }

    @Override // b.i.a.c.a3.b0
    public void g0(int i, @Nullable a0$a a0_a, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar, IOException iOException, boolean z2) {
        if (a(i, a0_a)) {
            this.k.e(tVar, wVar, iOException, z2);
        }
    }

    @Override // b.i.a.c.w2.s
    public void i0(int i, @Nullable a0$a a0_a) {
        if (a(i, a0_a)) {
            this.l.c();
        }
    }

    @Override // b.i.a.c.a3.b0
    public void o(int i, @Nullable a0$a a0_a, b.i.a.c.a3.w wVar) {
        if (a(i, a0_a)) {
            this.k.b(wVar);
        }
    }

    @Override // b.i.a.c.a3.b0
    public void q(int i, @Nullable a0$a a0_a, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar) {
        if (a(i, a0_a)) {
            this.k.c(tVar, wVar);
        }
    }

    @Override // b.i.a.c.w2.s
    public void u(int i, @Nullable a0$a a0_a, Exception exc) {
        if (a(i, a0_a)) {
            this.l.e(exc);
        }
    }

    @Override // b.i.a.c.a3.b0
    public void x(int i, @Nullable a0$a a0_a, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar) {
        if (a(i, a0_a)) {
            this.k.f(tVar, wVar);
        }
    }
}
