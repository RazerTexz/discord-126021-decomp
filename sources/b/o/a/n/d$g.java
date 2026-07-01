package b.o.a.n;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$g implements Runnable {
    public final /* synthetic */ float j;
    public final /* synthetic */ d k;

    public d$g(d dVar, float f) {
        this.k = dVar;
        this.j = f;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = this.k;
        if (dVar.j1(dVar.f1921i0, this.j)) {
            this.k.k1();
        }
    }
}
