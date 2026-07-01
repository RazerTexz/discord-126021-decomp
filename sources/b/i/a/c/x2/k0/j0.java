package b.i.a.c.x2.k0;

import b.i.a.c.j1;
import b.i.a.c.j1$b;
import java.util.List;

/* JADX INFO: compiled from: UserDataReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j0 {
    public final List<j1> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.c.x2.w[] f1261b;

    public j0(List<j1> list) {
        this.a = list;
        this.f1261b = new b.i.a.c.x2.w[list.size()];
    }

    public void a(long j, b.i.a.c.f3.x xVar) {
        if (xVar.a() < 9) {
            return;
        }
        int iF = xVar.f();
        int iF2 = xVar.f();
        int iT = xVar.t();
        if (iF == 434 && iF2 == 1195456820 && iT == 3) {
            b.c.a.a0.d.K(j, xVar, this.f1261b);
        }
    }

    public void b(b.i.a.c.x2.j jVar, i0$d i0_d) {
        for (int i = 0; i < this.f1261b.length; i++) {
            i0_d.a();
            b.i.a.c.x2.w wVarP = jVar.p(i0_d.c(), 3);
            j1 j1Var = this.a.get(i);
            String str = j1Var.w;
            boolean z2 = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String strValueOf = String.valueOf(str);
            b.c.a.a0.d.m(z2, strValueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(strValueOf) : new String("Invalid closed caption mime type provided: "));
            j1$b j1_b = new j1$b();
            j1_b.a = i0_d.b();
            j1_b.k = str;
            j1_b.d = j1Var.o;
            j1_b.c = j1Var.n;
            j1_b.C = j1Var.O;
            j1_b.m = j1Var.f1019y;
            wVarP.e(j1_b.a());
            this.f1261b[i] = wVarP;
        }
    }
}
