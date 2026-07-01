package b.i.a.b.j.t.i;

/* JADX INFO: compiled from: SQLiteEventStore_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements c0.a.a {
    public final c0.a.a<b.i.a.b.j.v.a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0.a.a<b.i.a.b.j.v.a> f803b;
    public final c0.a.a<d> c;
    public final c0.a.a<z> d;

    public u(c0.a.a<b.i.a.b.j.v.a> aVar, c0.a.a<b.i.a.b.j.v.a> aVar2, c0.a.a<d> aVar3, c0.a.a<z> aVar4) {
        this.a = aVar;
        this.f803b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    @Override // c0.a.a
    public Object get() {
        return new t(this.a.get(), this.f803b.get(), this.c.get(), this.d.get());
    }
}
