package b.g.a.c.e0.h;

import b.g.a.a.c0$a;

/* JADX INFO: compiled from: AsPropertyTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends a {
    public final String c;

    public d(b.g.a.c.e0.e eVar, b.g.a.c.d dVar, String str) {
        super(eVar, dVar);
        this.c = str;
    }

    @Override // b.g.a.c.e0.h.a, b.g.a.c.e0.g
    public /* bridge */ /* synthetic */ b.g.a.c.e0.g a(b.g.a.c.d dVar) {
        return h(dVar);
    }

    @Override // b.g.a.c.e0.h.m, b.g.a.c.e0.g
    public String b() {
        return this.c;
    }

    @Override // b.g.a.c.e0.h.a, b.g.a.c.e0.g
    public c0$a c() {
        return c0$a.PROPERTY;
    }

    @Override // b.g.a.c.e0.h.a
    public /* bridge */ /* synthetic */ a g(b.g.a.c.d dVar) {
        return h(dVar);
    }

    public d h(b.g.a.c.d dVar) {
        return this.f699b == dVar ? this : new d(this.a, dVar, this.c);
    }
}
