package b.f.j.p;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ThreadHandoffProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class f1$a<T> extends e1<T> {
    public final /* synthetic */ z0 o;
    public final /* synthetic */ x0 p;
    public final /* synthetic */ l q;
    public final /* synthetic */ f1 r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1$a(f1 f1Var, l lVar, z0 z0Var, x0 x0Var, String str, z0 z0Var2, x0 x0Var2, l lVar2) {
        super(lVar, z0Var, x0Var, str);
        this.r = f1Var;
        this.o = z0Var2;
        this.p = x0Var2;
        this.q = lVar2;
    }

    @Override // b.f.j.p.e1
    public void b(T t) {
    }

    @Override // b.f.j.p.e1
    public T d() throws Exception {
        return null;
    }

    @Override // b.f.j.p.e1
    public void g(T t) {
        this.o.j(this.p, "BackgroundThreadHandoffProducer", null);
        this.r.a.b(this.q, this.p);
    }
}
