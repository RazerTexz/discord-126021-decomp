package b.i.a.c.e3;

import b.i.a.c.f3.v$b;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements v$b {
    public final /* synthetic */ p a;

    public /* synthetic */ b(p pVar) {
        this.a = pVar;
    }

    @Override // b.i.a.c.f3.v$b
    public final void a(int i) {
        p pVar = this.a;
        synchronized (pVar) {
            int i2 = pVar.p;
            if (i2 == 0 || pVar.l) {
                if (i2 == i) {
                    return;
                }
                pVar.p = i;
                if (i != 1 && i != 0 && i != 8) {
                    pVar.f946s = pVar.h(i);
                    long jD = pVar.k.d();
                    pVar.j(pVar.m > 0 ? (int) (jD - pVar.n) : 0, pVar.o, pVar.f946s);
                    pVar.n = jD;
                    pVar.o = 0L;
                    pVar.r = 0L;
                    pVar.q = 0L;
                    x xVar = pVar.j;
                    xVar.c.clear();
                    xVar.e = -1;
                    xVar.f = 0;
                    xVar.g = 0;
                }
            }
        }
    }
}
