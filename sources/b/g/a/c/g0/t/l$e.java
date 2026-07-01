package b.g.a.c.g0.t;

/* JADX INFO: compiled from: PropertySerializerMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l$e extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f709b;
    public final b.g.a.c.n<Object> c;

    public l$e(l lVar, Class<?> cls, b.g.a.c.n<Object> nVar) {
        super(lVar);
        this.f709b = cls;
        this.c = nVar;
    }

    @Override // b.g.a.c.g0.t.l
    public l b(Class<?> cls, b.g.a.c.n<Object> nVar) {
        return new l$a(this, this.f709b, this.c, cls, nVar);
    }

    @Override // b.g.a.c.g0.t.l
    public b.g.a.c.n<Object> c(Class<?> cls) {
        if (cls == this.f709b) {
            return this.c;
        }
        return null;
    }
}
