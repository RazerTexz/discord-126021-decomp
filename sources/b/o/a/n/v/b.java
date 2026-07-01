package b.o.a.n.v;

import b.o.a.n.i$c;

/* JADX INFO: compiled from: CameraOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements Runnable {
    public final /* synthetic */ a j;

    public b(a aVar) {
        this.j = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a$c<?> a_c;
        synchronized (this.j.e) {
            a_c = null;
            if (!this.j.d) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (a$c<?> a_c2 : this.j.c) {
                    if (a_c2.e <= jCurrentTimeMillis) {
                        a_c = a_c2;
                        break;
                    }
                }
                if (a_c != null) {
                    this.j.d = true;
                }
            }
        }
        if (a_c != null) {
            a aVar = this.j;
            b.o.a.r.g gVar = ((i$c) aVar.f1941b).a.k;
            gVar.c(new c(aVar, a_c, gVar));
        }
    }
}
