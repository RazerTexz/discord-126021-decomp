package b.g.a.c.g0.t;

/* JADX INFO: compiled from: PropertySerializerMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l$a extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f705b;
    public final Class<?> c;
    public final b.g.a.c.n<Object> d;
    public final b.g.a.c.n<Object> e;

    public l$a(l lVar, Class<?> cls, b.g.a.c.n<Object> nVar, Class<?> cls2, b.g.a.c.n<Object> nVar2) {
        super(lVar);
        this.f705b = cls;
        this.d = nVar;
        this.c = cls2;
        this.e = nVar2;
    }

    @Override // b.g.a.c.g0.t.l
    public l b(Class<?> cls, b.g.a.c.n<Object> nVar) {
        return new l$c(this, new l$f[]{new l$f(this.f705b, this.d), new l$f(this.c, this.e), new l$f(cls, nVar)});
    }

    @Override // b.g.a.c.g0.t.l
    public b.g.a.c.n<Object> c(Class<?> cls) {
        if (cls == this.f705b) {
            return this.d;
        }
        if (cls == this.c) {
            return this.e;
        }
        return null;
    }
}
