package b.f.j.p;

/* JADX INFO: compiled from: DelayProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class o$a implements Runnable {
    public final /* synthetic */ l j;
    public final /* synthetic */ x0 k;
    public final /* synthetic */ o l;

    public o$a(o oVar, l lVar, x0 x0Var) {
        this.l = oVar;
        this.j = lVar;
        this.k = x0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.l.a.b(this.j, this.k);
    }
}
