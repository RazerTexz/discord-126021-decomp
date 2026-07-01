package b.i.a.c.g3;

import b.i.a.c.f3.e0;
import java.util.Objects;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ x$a j;
    public final /* synthetic */ b.i.a.c.v2.e k;

    public /* synthetic */ c(x$a x_a, b.i.a.c.v2.e eVar) {
        this.j = x_a;
        this.k = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x$a x_a = this.j;
        b.i.a.c.v2.e eVar = this.k;
        Objects.requireNonNull(x_a);
        synchronized (eVar) {
        }
        x xVar = x_a.f995b;
        int i = e0.a;
        xVar.Z(eVar);
    }
}
