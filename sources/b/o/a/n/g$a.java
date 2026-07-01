package b.o.a.n;

/* JADX INFO: compiled from: CameraBaseEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class g$a implements Runnable {
    public final /* synthetic */ b.o.a.m.e j;
    public final /* synthetic */ b.o.a.m.e k;
    public final /* synthetic */ g l;

    public g$a(g gVar, b.o.a.m.e eVar, b.o.a.m.e eVar2) {
        this.l = gVar;
        this.j = eVar;
        this.k = eVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.l.c(this.j)) {
            this.l.X();
        } else {
            this.l.P = this.k;
        }
    }
}
