package b.i.a.c.x2.k0;

import b.i.a.c.j1;
import b.i.a.c.j1$b;
import java.util.List;

/* JADX INFO: compiled from: SeiReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e0 {
    public final List<j1> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.c.x2.w[] f1246b;

    public e0(List<j1> list) {
        this.a = list;
        this.f1246b = new b.i.a.c.x2.w[list.size()];
    }

    public void a(b.i.a.c.x2.j jVar, i0$d i0_d) {
        for (int i = 0; i < this.f1246b.length; i++) {
            i0_d.a();
            b.i.a.c.x2.w wVarP = jVar.p(i0_d.c(), 3);
            j1 j1Var = this.a.get(i);
            String str = j1Var.w;
            boolean z2 = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String strValueOf = String.valueOf(str);
            b.c.a.a0.d.m(z2, strValueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(strValueOf) : new String("Invalid closed caption mime type provided: "));
            String strB = j1Var.l;
            if (strB == null) {
                strB = i0_d.b();
            }
            j1$b j1_b = new j1$b();
            j1_b.a = strB;
            j1_b.k = str;
            j1_b.d = j1Var.o;
            j1_b.c = j1Var.n;
            j1_b.C = j1Var.O;
            j1_b.m = j1Var.f1019y;
            wVarP.e(j1_b.a());
            this.f1246b[i] = wVarP;
        }
    }
}
