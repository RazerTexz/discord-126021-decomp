package b.i.a.c;

import b.i.a.c.a3.a0$a;
import b.i.a.c.s2.g1$a;
import b.i.b.b.p$a;
import java.util.Objects;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class m0 implements Runnable {
    public final /* synthetic */ s1 j;
    public final /* synthetic */ p$a k;
    public final /* synthetic */ a0$a l;

    public /* synthetic */ m0(s1 s1Var, p$a p_a, a0$a a0_a) {
        this.j = s1Var;
        this.k = p_a;
        this.l = a0_a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        s1 s1Var = this.j;
        p$a p_a = this.k;
        a0$a a0_a = this.l;
        b.i.a.c.s2.g1 g1Var = s1Var.c;
        b.i.b.b.p pVarC = p_a.c();
        g1$a g1_a = g1Var.m;
        y1 y1Var = g1Var.p;
        Objects.requireNonNull(y1Var);
        Objects.requireNonNull(g1_a);
        g1_a.f1081b = b.i.b.b.p.n(pVarC);
        if (!pVarC.isEmpty()) {
            g1_a.e = (a0$a) pVarC.get(0);
            Objects.requireNonNull(a0_a);
            g1_a.f = a0_a;
        }
        if (g1_a.d == null) {
            g1_a.d = g1$a.b(y1Var, g1_a.f1081b, g1_a.e, g1_a.a);
        }
        g1_a.d(y1Var.K());
    }
}
