package b.i.a.c;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c0 implements Runnable {
    public final /* synthetic */ f1 j;
    public final /* synthetic */ h1$d k;

    public /* synthetic */ c0(f1 f1Var, h1$d h1_d) {
        this.j = f1Var;
        this.k = h1_d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        boolean z2;
        long jM0;
        f1 f1Var = this.j;
        h1$d h1_d = this.k;
        int i = f1Var.f960x - h1_d.c;
        f1Var.f960x = i;
        boolean z3 = true;
        if (h1_d.d) {
            f1Var.f961y = h1_d.e;
            f1Var.f962z = true;
        }
        if (h1_d.f) {
            f1Var.A = h1_d.g;
        }
        if (i == 0) {
            o2 o2Var = h1_d.f1012b.f1146b;
            if (!f1Var.F.f1146b.q() && o2Var.q()) {
                f1Var.G = -1;
                f1Var.H = 0L;
            }
            if (!o2Var.q()) {
                List listAsList = Arrays.asList(((c2) o2Var).r);
                b.c.a.a0.d.D(listAsList.size() == f1Var.m.size());
                for (int i2 = 0; i2 < listAsList.size(); i2++) {
                    f1Var.m.get(i2).f963b = (o2) listAsList.get(i2);
                }
            }
            long j2 = -9223372036854775807L;
            if (f1Var.f962z) {
                if (h1_d.f1012b.c.equals(f1Var.F.c) && h1_d.f1012b.e == f1Var.F.t) {
                    z3 = false;
                }
                if (z3) {
                    if (o2Var.q() || h1_d.f1012b.c.a()) {
                        jM0 = h1_d.f1012b.e;
                    } else {
                        w1 w1Var = h1_d.f1012b;
                        jM0 = f1Var.m0(o2Var, w1Var.c, w1Var.e);
                    }
                    j2 = jM0;
                }
                j = j2;
                z2 = z3;
            } else {
                j = -9223372036854775807L;
                z2 = false;
            }
            f1Var.f962z = false;
            f1Var.s0(h1_d.f1012b, 1, f1Var.A, false, z2, f1Var.f961y, j, -1);
        }
    }
}
