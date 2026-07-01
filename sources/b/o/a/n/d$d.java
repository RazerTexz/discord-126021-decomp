package b.o.a.n;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$d implements Runnable {
    public final /* synthetic */ b.o.a.m.h j;
    public final /* synthetic */ d k;

    public d$d(d dVar, b.o.a.m.h hVar) {
        this.k = dVar;
        this.j = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = this.k;
        if (dVar.i1(dVar.f1921i0, this.j)) {
            this.k.k1();
        }
    }
}
