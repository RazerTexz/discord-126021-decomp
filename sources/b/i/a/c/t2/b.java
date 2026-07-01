package b.i.a.c.t2;

import java.util.Objects;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ r$a j;
    public final /* synthetic */ b.i.a.c.v2.e k;

    public /* synthetic */ b(r$a r_a, b.i.a.c.v2.e eVar) {
        this.j = r_a;
        this.k = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r$a r_a = this.j;
        b.i.a.c.v2.e eVar = this.k;
        Objects.requireNonNull(r_a);
        synchronized (eVar) {
        }
        r rVar = r_a.f1126b;
        int i = b.i.a.c.f3.e0.a;
        rVar.k(eVar);
    }
}
