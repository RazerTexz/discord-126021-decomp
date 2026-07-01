package b.f.j.p;

/* JADX INFO: compiled from: DelegatingConsumer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p<I, O> extends b<I> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<O> f632b;

    public p(l<O> lVar) {
        this.f632b = lVar;
    }

    @Override // b.f.j.p.b
    public void g() {
        this.f632b.d();
    }

    @Override // b.f.j.p.b
    public void h(Throwable th) {
        this.f632b.c(th);
    }

    @Override // b.f.j.p.b
    public void j(float f) {
        this.f632b.a(f);
    }
}
