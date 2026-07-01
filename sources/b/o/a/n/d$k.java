package b.o.a.n;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$k implements Runnable {
    public final /* synthetic */ int j;
    public final /* synthetic */ d k;

    public d$k(d dVar, int i) {
        this.k = dVar;
        this.j = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.o.a.n.v.e eVar = this.k.n.f;
        b.o.a.n.v.e eVar2 = b.o.a.n.v.e.BIND;
        if (eVar.f(eVar2) && this.k.O()) {
            this.k.g0(this.j);
            return;
        }
        d dVar = this.k;
        int i = this.j;
        if (i <= 0) {
            i = 35;
        }
        dVar.u = i;
        if (dVar.n.f.f(eVar2)) {
            this.k.Y();
        }
    }
}
