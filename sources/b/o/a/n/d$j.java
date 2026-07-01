package b.o.a.n;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$j implements Runnable {
    public final /* synthetic */ boolean j;
    public final /* synthetic */ d k;

    public d$j(d dVar, boolean z2) {
        this.k = dVar;
        this.j = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.o.a.n.v.e eVar = this.k.n.f;
        b.o.a.n.v.e eVar2 = b.o.a.n.v.e.BIND;
        if (eVar.f(eVar2) && this.k.O()) {
            this.k.k0(this.j);
            return;
        }
        d dVar = this.k;
        dVar.v = this.j;
        if (dVar.n.f.f(eVar2)) {
            this.k.Y();
        }
    }
}
