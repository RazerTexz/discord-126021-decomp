package b.i.a.b.j;

/* JADX INFO: compiled from: TransportRuntime_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements c0.a.a {
    public final c0.a.a<b.i.a.b.j.v.a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0.a.a<b.i.a.b.j.v.a> f770b;
    public final c0.a.a<b.i.a.b.j.t.e> c;
    public final c0.a.a<b.i.a.b.j.t.h.l> d;
    public final c0.a.a<b.i.a.b.j.t.h.p> e;

    public p(c0.a.a<b.i.a.b.j.v.a> aVar, c0.a.a<b.i.a.b.j.v.a> aVar2, c0.a.a<b.i.a.b.j.t.e> aVar3, c0.a.a<b.i.a.b.j.t.h.l> aVar4, c0.a.a<b.i.a.b.j.t.h.p> aVar5) {
        this.a = aVar;
        this.f770b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    @Override // c0.a.a
    public Object get() {
        return new n(this.a.get(), this.f770b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
