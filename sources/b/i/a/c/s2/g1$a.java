package b.i.a.c.s2;

import androidx.annotation.Nullable;
import b.i.a.c.a3.a0$a;
import b.i.a.c.o2;
import b.i.a.c.o2$b;
import b.i.a.c.y1;
import b.i.b.b.q$a;

/* JADX INFO: compiled from: AnalyticsCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g1$a {
    public final o2$b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.i.b.b.p<a0$a> f1081b;
    public b.i.b.b.q<a0$a, o2> c;

    @Nullable
    public a0$a d;
    public a0$a e;
    public a0$a f;

    public g1$a(o2$b o2_b) {
        this.a = o2_b;
        b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
        this.f1081b = b.i.b.b.h0.l;
        this.c = b.i.b.b.i0.m;
    }

    @Nullable
    public static a0$a b(y1 y1Var, b.i.b.b.p<a0$a> pVar, @Nullable a0$a a0_a, o2$b o2_b) {
        o2 o2VarK = y1Var.K();
        int iM = y1Var.m();
        Object objM = o2VarK.q() ? null : o2VarK.m(iM);
        int iB = (y1Var.f() || o2VarK.q()) ? -1 : o2VarK.f(iM, o2_b).b(b.i.a.c.f3.e0.B(y1Var.T()) - o2_b.n);
        for (int i = 0; i < pVar.size(); i++) {
            a0$a a0_a2 = pVar.get(i);
            if (c(a0_a2, objM, y1Var.f(), y1Var.B(), y1Var.q(), iB)) {
                return a0_a2;
            }
        }
        if (pVar.isEmpty() && a0_a != null) {
            if (c(a0_a, objM, y1Var.f(), y1Var.B(), y1Var.q(), iB)) {
                return a0_a;
            }
        }
        return null;
    }

    public static boolean c(a0$a a0_a, @Nullable Object obj, boolean z2, int i, int i2, int i3) {
        if (a0_a.a.equals(obj)) {
            return (z2 && a0_a.f835b == i && a0_a.c == i2) || (!z2 && a0_a.f835b == -1 && a0_a.e == i3);
        }
        return false;
    }

    public final void a(q$a<a0$a, o2> q_a, @Nullable a0$a a0_a, o2 o2Var) {
        if (a0_a == null) {
            return;
        }
        if (o2Var.b(a0_a.a) != -1) {
            q_a.c(a0_a, o2Var);
            return;
        }
        o2 o2Var2 = this.c.get(a0_a);
        if (o2Var2 != null) {
            q_a.c(a0_a, o2Var2);
        }
    }

    public final void d(o2 o2Var) {
        q$a<a0$a, o2> q_a = new q$a<>(4);
        if (this.f1081b.isEmpty()) {
            a(q_a, this.e, o2Var);
            if (!b.i.a.f.e.o.f.V(this.f, this.e)) {
                a(q_a, this.f, o2Var);
            }
            if (!b.i.a.f.e.o.f.V(this.d, this.e) && !b.i.a.f.e.o.f.V(this.d, this.f)) {
                a(q_a, this.d, o2Var);
            }
        } else {
            for (int i = 0; i < this.f1081b.size(); i++) {
                a(q_a, this.f1081b.get(i), o2Var);
            }
            if (!this.f1081b.contains(this.d)) {
                a(q_a, this.d, o2Var);
            }
        }
        this.c = q_a.a();
    }
}
