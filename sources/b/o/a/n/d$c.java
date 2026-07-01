package b.o.a.n;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$c implements Runnable {
    public final /* synthetic */ b.o.a.m.m j;
    public final /* synthetic */ d k;

    public d$c(d dVar, b.o.a.m.m mVar) {
        this.k = dVar;
        this.j = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = this.k;
        if (dVar.m1(dVar.f1921i0, this.j)) {
            this.k.k1();
        }
    }
}
