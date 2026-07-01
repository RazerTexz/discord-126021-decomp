package b.f.j.p;

/* JADX INFO: compiled from: ThreadHandoffProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class f1$b extends e {
    public final /* synthetic */ e1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f1 f611b;

    public f1$b(f1 f1Var, e1 e1Var) {
        this.f611b = f1Var;
        this.a = e1Var;
    }

    @Override // b.f.j.p.y0
    public void a() {
        this.a.a();
        g1 g1Var = this.f611b.f610b;
        e1 e1Var = this.a;
        h1 h1Var = (h1) g1Var;
        synchronized (h1Var) {
            h1Var.a.remove(e1Var);
        }
    }
}
