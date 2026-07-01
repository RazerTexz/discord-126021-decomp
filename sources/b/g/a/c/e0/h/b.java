package b.g.a.c.e0.h;

import b.g.a.a.c0$a;

/* JADX INFO: compiled from: AsExistingPropertyTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends d {
    public b(b.g.a.c.e0.e eVar, b.g.a.c.d dVar, String str) {
        super(eVar, dVar, str);
    }

    @Override // b.g.a.c.e0.h.d, b.g.a.c.e0.h.a, b.g.a.c.e0.g
    public /* bridge */ /* synthetic */ b.g.a.c.e0.g a(b.g.a.c.d dVar) {
        return i(dVar);
    }

    @Override // b.g.a.c.e0.h.d, b.g.a.c.e0.h.a, b.g.a.c.e0.g
    public c0$a c() {
        return c0$a.EXISTING_PROPERTY;
    }

    @Override // b.g.a.c.e0.h.d, b.g.a.c.e0.h.a
    public /* bridge */ /* synthetic */ a g(b.g.a.c.d dVar) {
        return i(dVar);
    }

    @Override // b.g.a.c.e0.h.d
    public /* bridge */ /* synthetic */ d h(b.g.a.c.d dVar) {
        return i(dVar);
    }

    public b i(b.g.a.c.d dVar) {
        return this.f699b == dVar ? this : new b(this.a, dVar, this.c);
    }
}
